import kotlin.js.Promise
import kotlinx.coroutines.*
external val document:dynamic = definedExternally
external val tf:dynamic = definedExternally
external val tfvis:dynamic = definedExternally
external val fetch:dynamic = definedExternally
external val Array:dynamic = definedExternally

fun main() {
    
    document.addEventListener("DOMContentLoaded", {
        val msg = "welcome to kotlin tensorflow.js!"
        GlobalScope.async{run()}
        println(msg)
    })
    
}

fun point(x:dynamic,y:dynamic):dynamic{return object{val x=x;val y=y}}

suspend fun run(){
    try{
        val carsDataReq = (fetch("https://storage.googleapis.com/tfjs-tutorials/carsData.json") as Promise<dynamic>).await()
        val carsData = (carsDataReq.json() as Promise<dynamic>).await()
        
        val data = carsData.map{car -> object{val mpg= car.Miles_per_Gallon;val horsepower= car.Horsepower}}.filter{car -> car.mpg != null && car.horsepower != null}
        
        val surface = tfvis.visor().surface(object{val name= "Horsepower vs MPG";val tab= "Charts"})
        val originalPoints = data.map{ d -> point(d.horsepower,d.mpg) }
        tfvis.render.scatterplot(surface, object{val values= originalPoints}, 
        object{
            val xLabel= "Horsepower"
            val yLabel= "MPG"
            val height= 300
        })
        
        // Create the model
        val model = createModel()  
        tfvis.show.modelSummary(object{val name= "Model Summary"}, model)
        
        val tensorData = convertToTensor(data)
        
        // Train the model  
        (trainModel(model, tensorData) as Promise<dynamic>).await()
        println("Done Training")
    
        // Make some predictions using the model and compare them to the
        // original data
        testModel(model, data, tensorData)
    
    } catch(err:Throwable){
        println("""err: ${err.message}""")
    }
}

val createModel = {
    // Create a sequential model
    val model = tf.sequential() 
    
    // Add a single hidden layer
    model.add(tf.layers.dense(object{val inputShape= arrayOf(1);val units= 1;val useBias= true}))
    
    // Add an output layer
    model.add(tf.layers.dense(object{val units= 1;val useBias= true}))
    
    model
}

/**
 * Convert the input data to tensors that we can use for machine 
 * learning. We will also do the important best practices of _shuffling_
 * the data and _normalizing_ the data
 * MPG on the y-axis.
 */
val convertToTensor = { data:dynamic ->
    // Wrapping these calculations in a tidy will dispose any 
    // intermediate tensors.
    tf.tidy({
        // Step 1. Shuffle the data    
        tf.util.shuffle(data)
        
        // Step 2. Convert data to Tensor
        val inputs = data.map{d -> d.horsepower}
        val labels = data.map{d -> d.mpg}
        
        val inputTensor = tf.tensor2d(inputs, arrayOf(inputs.length, 1))
        val labelTensor = tf.tensor2d(labels, arrayOf(labels.length, 1))
        
        //Step 3. Normalize the data to the range 0 - 1 using min-max scaling
        val inputMax = inputTensor.max()
        val inputMin = inputTensor.min()  
        val labelMax = labelTensor.max()
        val labelMin = labelTensor.min()
        
        val normalizedInputs = inputTensor.sub(inputMin).div(inputMax.sub(inputMin))
        val normalizedLabels = labelTensor.sub(labelMin).div(labelMax.sub(labelMin))
        
        object{
        val inputs= normalizedInputs
        val labels= normalizedLabels
        val inputMax= inputMax
        val inputMin= inputMin
        val labelMax= labelMax
        val labelMin= labelMin
        }
        
    })
}
    
val trainModel = {model:dynamic, tensorData:dynamic ->

    // Prepare the model for training.  
    model.compile(object{
        val optimizer = tf.train.adam()
        val loss = tf.losses.meanSquaredError
        val metrics = arrayOf("mse")
    })
    
    model.fit(tensorData.inputs, tensorData.labels, object{
        val batchSize = 32
        val epochs = 100
        val shuffle = true
        val callbacks = tfvis.show.fitCallbacks(object{val name= "Training Performance"},arrayOf("loss", "mse"),object{val height= 200;val callbacks= arrayOf("onEpochEnd")})
    })
}

fun testModel(model:dynamic, inputData:dynamic, normalizationData:dynamic) {
    
    val inputMax = normalizationData.inputMax
    val inputMin = normalizationData.inputMin
    val labelMin = normalizationData.labelMin
    val labelMax = normalizationData.labelMax
    
    // Generate predictions for a uniform range of numbers between 0 and 1;
    // We un-normalize the data by doing the inverse of the min-max scaling 
    // that we did earlier.
    val xs_preds = tf.tidy({
    
        val xs = tf.linspace(0, 1, 100)
        val preds = model.predict(xs.reshape(arrayOf(100, 1)))
        
        val unNormXs = xs
        .mul(inputMax.sub(inputMin))
        .add(inputMin)
        
        val unNormPreds = preds
        .mul(labelMax.sub(labelMin))
        .add(labelMin)
        
        // Un-normalize the data
        Pair(unNormXs.dataSync(), unNormPreds.dataSync())
    })
    
    val xs = xs_preds.first
    val preds = xs_preds.second
    
    val array_xs = Array.from(xs)
    val array_preds = Array.from(preds)
    
    val predictedPoints = array_xs.map { value, index ->
        point(value,array_preds[index])
    }
    
    val originalPoints = inputData.map{ d -> 
        point(d.horsepower,d.mpg)
    }
    
    tfvis.render.scatterplot(object{val name= "Model Predictions vs Original Data"}, object{val values= arrayOf(originalPoints, predictedPoints);val series= arrayOf("original", "predicted")}, object{val xLabel= "Horsepower";val yLabel= "MPG";val height= 300})
    println("All done!")
}
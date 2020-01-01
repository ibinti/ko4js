package tensorflow
import kotlinx.coroutines.*
/*
GlobalScope.async { }
GlobalScope.launch { }
*/
import org.w3c.dom.*

external val tf:dynamic = definedExternally
external val tfvis:dynamic = definedExternally
external val fetch:dynamic = definedExternally

val document:dynamic = kotlin.browser.document
val kquery:dynamic = document.querySelector.bind(document)
val window:dynamic = kotlin.browser.window

fun main() {
    
    document.addEventListener("DOMContentLoaded", {
        val msg = "welcome to kotlin for tensorflow.js!"
        /*
        example1 and example 2 will run concurrently 
        and example2 will finish first
        */
        example1()
        example2()
        println(msg)
    })
    
}

fun printjo(jo:dynamic){val msg = kotlin.js.JSON.stringify(jo);println(msg)}

val kob = {
  val o:dynamic=object{}
  o
} 

fun example1() {

    if(tf == undefined) { println("""tf == undefined""");return }

    val msg = "hello tensorflow"
    println(msg)
    kquery("#out").innerText = msg

    val model = tf.sequential()
    model.add(tf.layers.dense(js("{units: 1, inputShape: [1]}")))

    model.compile(js("{loss: 'meanSquaredError', optimizer: 'sgd'}"))

    // Generate some synthetic data for training.
    //val xs = tf.tensor2d(js("[1, 2, 3, 4]"), js("[4, 1]"))
    //val ys = tf.tensor2d(js("[1, 3, 5, 7]"), js("[4, 1]"))
    val xs = tf.tensor2d(arrayOf(1,2,3,4), arrayOf(4,1))
    val ys = tf.tensor2d(arrayOf(1,3,5,7), arrayOf(4,1))

    // Train the model using the data.
    /*
    100 epochs may takes a few seconds or more
     */
    model.fit(xs, ys, js("{epochs: 100}"))
    .then({
        model.predict(tf.tensor2d(js("[5]"), js("[1, 1]")))
    })
    .then({ out ->
        kquery("#out").innerText = out
        out.print()
    })
    
}

fun example2() {

    if(tfvis == undefined) { println("""tfvis == undefined""");return }

    fetch("https://storage.googleapis.com/tfjs-tutorials/carsData.json")
    .then({carsDataReq->
        carsDataReq.json()
    })
    .then({carsData->
        printjo(carsData)
        carsData.map{car -> js("""{
            mpg: car.Miles_per_Gallon,
            horsepower: car.Horsepower,
        }""") }
        .filter{car -> car.mpg != null && car.horsepower != null}
    })
    .then({data->
        printjo(data)
        data.map{d -> js("""{
            x: d.horsepower,
            y: d.mpg,
          }""")}
    })
    .then({plot_data->
        printjo(plot_data)
        val surface = tfvis.visor().surface(js("""{ name: 'Horsepower v MPG', tab: 'Charts' }"""))
        tfvis.render.scatterplot(surface, js("""{values: plot_data}"""), 
        js("""{
          xLabel: 'Horsepower',
          yLabel: 'MPG',
          height: 300
        }"""))
    })
    .catch({err ->
        println("""err: ${err.message}""")
    })
}
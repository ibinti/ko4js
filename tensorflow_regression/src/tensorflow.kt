suspend fun tensorflow() {

    val msg = "hello tensorflow"
    println(msg)
    kquery("#out").innerText = msg

    val model = tf.sequential()
    model.add(tf.layers.dense(object{val units=1;val inputShape=Array.of(1)}))

    model.compile(object{val loss="meanSquaredError";val optimizer="sgd"})

    // Generate some synthetic data for training
    val xs = tf.tensor2d(Array.of(1,2,3,4),Array.of(4,1))
    val ys = tf.tensor2d(Array.of(1,3,5,7),Array.of(4,1))

    // Train the model using the data
    pawait(model.fit(xs, ys, object{val epochs=100}))
    val out = model.predict(tf.tensor2d(Array.of(5),Array.of(1, 1)))
    
    kquery("#out").innerText = out
    out.print()
    
}
/*
apt install nodejs

node will use NODE_PATH to locate the global node_modules
export NODE_PATH=$(npm root --quiet -g)
in bash_profile, or .bashrc, or .profile etc whaterver your os needs


npm install -g kotlin
npm install -g kotlinx-coroutines-core
npm install -g express 
npm install -g node-fetch

*/
import kotlinx.coroutines.*
external val require:dynamic = definedExternally
external val Date:dynamic = definedExternally
external val JSON:dynamic = definedExternally

fun main() {
    
    println("welcome to kotlin nodejs express")
    
    express_server()

}

/*
helper
 */
fun printjo(jo:dynamic){val msg = JSON.stringify(jo);println(msg)}

val express_server = {
    
    val express = require("express")
    val fetch = require("node-fetch")
    
    val app = express()
    val port = 8055
    
    app.get("/",  {req, res -> GlobalScope.async{
            val jo:dynamic = object{}
            jo.hello="hello kotlin world!"

            suspend fun x_something_deep(): Int {
                // ... some long running operation here
                // this synchronously waits for x_something_deep() to finish
                delay(5000)
                return 5000
            }
            suspend fun y_something_deep(): Int {
                // ... some long running operation here
                // this synchronously waits for y_something_deep() to finish
                delay(6000)
                return 6000
            }
            val x =  GlobalScope.async { x_something_deep() }
            val y =  GlobalScope.async { y_something_deep() }
        
            jo.before = Date()
            jo.x = x.await()
            jo.y = y.await()
            jo.after = Date()
            res.send(jo)
            printjo(jo)
    } })
    
    app.get("/users/:user_id/books/:book_id", {req, res -> 
        res.send(req.params)
        printjo(req.params)       
    })
   
    app.get("/fetch", {req, res -> GlobalScope.async { 
        fetch("https://github.com/ibinti/ko4js")
        .then({response->
            response.text()
        })
        .then({body->
            res.statusCode = 200
            res.setHeader("Content-Type", "text/html") 
            res.send(body)
            printjo(body)
        })
        .catch({err ->
            println("""err: ${err.message}""")
        })
    }})
    
    app.listen(port, { println("express listening on port ${port}!")})
}
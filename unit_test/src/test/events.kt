package ko4js
import kotlin.test.*
import kotlin.js.Promise
import kotlinx.coroutines.*


@JsModule("events")
@JsNonModule
external abstract class EventEmitter(){}

class MyEmitter:EventEmitter(){}

class events_test {
    @Test fun event() {
        
        val myEmitter:dynamic = MyEmitter()
        myEmitter.on("event", {
          println("an event occurred!")
        })
        myEmitter.emit("event")

    }
    @Test fun event_a_b() {

        val myEmitter:dynamic = MyEmitter()
        myEmitter.on("event", { a, b ->
          println("event ($a, $b) occurred!")
        })
        myEmitter.emit("event", "a", "b")

    }
    @Test fun event_async()  = run_suspend {
        
        val myEmitter:dynamic = MyEmitter()
        Promise<dynamic> { resolve:dynamic, _ -> 
            myEmitter.on("event", {a, b ->
            
                setImmediate( {
                   println("event ($a,$b) occurred asynchronously!")
                   resolve()
                })
                
            })
            myEmitter.emit("event", "c", "d")
        }.await()
        
    }
}
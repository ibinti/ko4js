import kotlin.js.Promise
import kotlinx.coroutines.*
external val document:dynamic = definedExternally
external val tf:dynamic = definedExternally
external val tfvis:dynamic = definedExternally
external val fetch:dynamic = definedExternally
external val Array:dynamic = definedExternally

fun main() {
    
    document.addEventListener("DOMContentLoaded", {
        val msg = "welcome to tensorflow.js!"
        GlobalScope.async {tensorflow()}
        GlobalScope.async{regression()}
        println(msg)
    })
    
}

val kquery = document.querySelector.bind(document)
fun point(x:dynamic,y:dynamic)=object{val x=x;val y=y}
suspend fun pawait(promise:dynamic):dynamic{return (promise as Promise<dynamic>).await()}

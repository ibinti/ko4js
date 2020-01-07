/*
npm install -g kotlin
npm install -g vm-browserify
npm install -g browserify
*/
external val require:dynamic = definedExternally
external val window:dynamic = definedExternally
external val document:dynamic = definedExternally

fun main() {
    
    println("welcome to kotlin vm browserify with uglifyjs example")
    
    val vm = require("vm")
 
    window.addEventListener("load", {
        val res = vm.runInNewContext("a + 32", js("{ a : 32 }"))
        document.querySelector("#res").textContent = "$res-bit process" 
        Unit
    })

}
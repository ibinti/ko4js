external val require:dynamic = definedExternally
external val window:dynamic = definedExternally
external val document:dynamic = definedExternally

fun main() {
    
    println("welcome to kotlin vm example")
    
    val vm = require("vm")
 
    window.addEventListener("load", {
        val res = vm.runInNewContext("a + 8", object{ val a = 111 })
        document.querySelector("#res").textContent = res
        Unit
    })

}
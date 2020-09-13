@JsModule("vm")
@JsNonModule
external val vm:dynamic = definedExternally
external val window:dynamic = definedExternally
external val document:dynamic = definedExternally

fun main() {
    
    println("""welcome to kotlin.js with @JsModule("vm") example""")
 
    window.addEventListener("load", {
        val res = vm.runInNewContext("a + 111",object{val a=111})
        document.querySelector("#res").textContent = res
        Unit
    })

}
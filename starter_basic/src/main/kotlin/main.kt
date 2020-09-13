external val document:dynamic = definedExternally
val kquery:dynamic = document.querySelector.bind(document)

fun main() {
    document.addEventListener("DOMContentLoaded", {
        val msg = "This is basic example from Kotlin/JS!"
//        val basic:dynamic = kquery("#basic")
        //basic.is_toggle = false
//        kquery("#basic").onclick = { e: dynamic ->
        kquery("#basic").onclick = { evt:dynamic ->
            evt.currentTarget.innerText = msg
          //  basic.is_toggle = !basic.is_toggle
//            basic.innerText = if(basic.is_toggle) msg else "well, click me again"
            Unit
        }
    })
}
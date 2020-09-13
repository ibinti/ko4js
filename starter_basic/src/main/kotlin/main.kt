external val document:dynamic = definedExternally
val kquery:dynamic = document.querySelector.bind(document)

fun main() {
    document.addEventListener("DOMContentLoaded", {
        val msg = "This is basic example from Kotlin/JS!"
        val basic:dynamic = kquery("#basic")
        basic.is_toggle = false
        basic.onclick = {
            basic.is_toggle = !basic.is_toggle
            basic.innerText = if(basic.is_toggle) msg else "there and back again"
        }
        Unit
    })
}
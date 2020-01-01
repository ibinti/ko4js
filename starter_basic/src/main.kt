val document:dynamic = kotlin.browser.document
val kquery:dynamic = document.querySelector.bind(document)
external val jQuery:dynamic = definedExternally

fun main() {
    document.addEventListener("DOMContentLoaded", {
        val msg = "This is basic example from Kotlin/JS!"
        kquery("#basic").onclick = { evt:dynamic ->
            evt.currentTarget.innerText = msg
        }
        println(msg)
    })
}
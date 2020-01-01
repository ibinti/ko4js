val document:dynamic = kotlin.browser.document
val kquery:dynamic = document.querySelector.bind(document)

fun main() {
    document.addEventListener("DOMContentLoaded", {
        val msg = "HelloWorld from Kotlin!"
        kquery("#helloworld").onclick = { evt:dynamic ->
            evt.currentTarget.innerText = msg
        }
        println(msg)
    })
}
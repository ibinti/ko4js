val document:dynamic = kotlin.browser.document
val kquery:dynamic = document.querySelector.bind(document)

fun main() {
    document.addEventListener("DOMContentLoaded", {
        val msg = "This is after uglifyjs from Kotlin/JS!"
        kquery("#uglifyjs").onclick = { evt:dynamic ->
            evt.currentTarget.innerText = msg
        }
        println(msg)
    })
}

fun you_will_not_see_me_after_dce() {
/*
you should not see this after DCE
 */
    println("I see you!")
}

@JsName("fn") 
fun you_will_still_see_me_after_dec() {
/*
you should see this after DCE
 */
    println("I see you!")
}
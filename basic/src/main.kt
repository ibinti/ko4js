external val document:dynamic = definedExternally
val kquery:dynamic = document.querySelector.bind(document)

fun main() {
    document.addEventListener("DOMContentLoaded", {
        val msg = "this is basic example of kotlin.js"
        val basic:dynamic = kquery("#basic")
        basic.is_toggle = false
        basic.onclick = {
            basic.is_toggle = !basic.is_toggle
            basic.innerText = if(basic.is_toggle) msg else "there and back again"
        }
        Unit
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
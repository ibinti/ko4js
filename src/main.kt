package okoko
val document:dynamic = kotlin.browser.document
val kquery:dynamic = document.querySelector.bind(document)
external val jQuery:dynamic = definedExternally

fun main() {
    log()
    kumbaya()
}

fun log() {
    println("this is the log!")
}

@JsName("jtext") fun jtext(selector:String,txt:String) {
    jQuery(selector).text(txt)
}

fun you_do_not_see_me() {
/*
you should not see this after DCE
 */
    println("I see you!")
}

@JsName("fn") 
fun you_will_see_me_after_dec() {
/*
you should see this after DCE
 */
    println("I see you!")
}

fun kumbaya() {
    document.addEventListener("DOMContentLoaded", {
        kquery("#kotlin").onclick = { evt:dynamic ->
            evt.currentTarget.innerText = "This is from Kotlin/JS!"
            log()
        }
        Unit
    })
}
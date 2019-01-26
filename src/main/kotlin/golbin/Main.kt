package okoko
import kotlin.browser.document
import kotlin.browser.window
external fun jQuery(selector: dynamic): dynamic = definedExternally

fun log() {
    println("log from Kotlin for JavaScript!")
    you_shoud_not_see_me()
}

fun jtext(selector:dynamic,txt:dynamic) {
    jQuery(selector).text(txt)
}

fun you_shoud_not_see_me() {
    println("I see you!")
}

fun boombayah() {
    jQuery(document).ready({
        jQuery("p").click( { jtext("p","Thank You, Sir!") })
        jtext("p","If you click on me, you will be mesmerized.")
    })
}

fun main(args: Array<String>) {
    println("Welcome to Kotlin for JavaScript!")
    boombayah()
    log()
}
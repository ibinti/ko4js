package okoko
import kotlin.browser.document
import kotlin.browser.window
external val jQuery:dynamic = definedExternally

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

fun boombaya() {
    jQuery(document).ready({
        jQuery("p").click( {
            jtext("p","Thank You, Sir!")
            log()
        })
        jtext("p","If you click on me, you will be mesmerized.")
    })
}

fun main(args: Array<String>) {
    log()
    boombaya()
}
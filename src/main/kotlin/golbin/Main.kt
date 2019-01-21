package okoko
import kotlin.browser.document
import kotlin.browser.window
external fun jQuery(selector: Any?): Unit

fun log(){
    println("log from Kotlin for JavaScript!")
}

fun jtext(selector:Any,txt:Any) {
    jQuery(selector).asDynamic().text(txt)
}

fun boombayah() {
    jQuery(document).asDynamic().ready({
        jQuery("p").asDynamic().click( { jtext("p","Thank You, Sir!") })
        jtext("p","If you click on me, You will be mesmerized.")
    })
}

fun main(args: Array<String>) {
    println("Welcome to Kotlin for JavaScript!")
    boombayah()
}
package okoko
//import kotlin.browser.document
//import kotlin.browser.window
//external val jQuery: dynamic = definedExternally

//fun log() {
//    println("log from Kotlin for JavaScript!")
//    //you_shoud_not_see_me()
//}
//
//@JsName("jtext") fun jtext(selector:String,txt:String) {
//    jQuery(selector).text(txt)
//}

fun you_shoud_not_see_me() {
    println("I see you!")
}

//fun boombayah() {
//    jQuery(document).ready({
//        jQuery("p").click( {
//            jtext("p","Thank You, Sir!")
//            log()
//        })
//        jtext("p","If you click on me, you will be mesmerized.")
//    })
//}

external val postMessage: dynamic = definedExternally
external val self: dynamic = definedExternally
fun main(args: Array<String>) {
    println("Welcome to Kotlin for JavaScript!")
    //boombayah()

    self.onmessage = { event: dynamic ->
        var data = event.data
        postMessage(data.cmd + " self.onmessage " + data.msg)
    }

}
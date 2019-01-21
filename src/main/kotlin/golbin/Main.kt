@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package okoko

external fun jQuery(selector: Any?): Unit

fun log(){
    println("log from Kotlin for JavaScript!")
}
fun jtext(selector:Any,txt:Any) {
    jQuery(selector).asDynamic().text(txt)
}
fun ko_2_int(time:Any):Int {
    return "$time".toDouble().toInt()
}

fun main(args: Array<String>) {
    println("Welcome to Kotlin for JavaScript!")
}
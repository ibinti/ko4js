@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package ko4js

val window:dynamic = kotlin.browser.window
val document:dynamic = kotlin.browser.document

var ko:dynamic = js("{}")
var jQuery:dynamic = js("{}")

var profile:dynamic = null
fun save() {
    val jo_string = JSON.stringify(profile)
    kotlin.browser.localStorage.setItem("jo_string", jo_string)
}
fun load() {
    val jo_string = kotlin.browser.localStorage.getItem("jo_string") ?: "{}"
    profile = kotlin.js.JSON.parse("$jo_string")
}
@JsName("koi")
fun koi() {

    load()
    save() //save whenever profile changes

}

val ab2str = js("""function(buf){var encodedString = String.fromCharCode.apply(null, new Uint8Array(buf));return decodeURIComponent(escape(encodedString))}""")
val str2ab = js("""function(str){
  var buf = new ArrayBuffer(str.length*2) // 2 bytes for each char
  var bufView = new Uint8Array(buf)
  for (var i=0, strLen=str.length; i < strLen; i++) {
    bufView[i] = str.charCodeAt(i)
  }
  return buf}""")
val zero_pad = js("""function (num, places) {
    var zero = places - num.toString().length + 1;
    return Array(+(zero > 0 && zero)).join("0") + num;
}""")

fun ko_min_sec(time:dynamic):String {
    val t = "$time".toDouble().toInt()
    val min = (t / 60)
    val sec = (t % 60)
    return "${zero_pad(min,1)}:${zero_pad(sec,2)}"
}

fun ko_2_int(time:dynamic):Int {
    return "$time".toDouble().toInt()
}

fun koQuery(url:dynamic, jo:dynamic, success:dynamic, async:dynamic = true) {
    var data = js("{}")
    data.jo_string = kotlin.js.JSON.stringify(jo)

    var setting = js("{}")
    setting.url = url
    setting.data = data
    setting.method = "POST"
    setting.success = success
    setting.async = async

    jQuery.ajax(setting)
}

fun html(url: String, fn:dynamic, html:String) {
    var jo = js("{}")
    jo.action = "html"
    jo.html = html

    koQuery(url, jo, { data:dynamic, textStatus:dynamic, jqXHR:dynamic ->
        if(textStatus=="success") {
            try {
                var jo: dynamic = kotlin.js.JSON.parse(data)
                if (jo.html) {
                    fn(jo.html)
                }
            } catch (e:Throwable){ }
        }
    })
}

fun append(url: String, element:String, html:String) {
    val jo = js("{}")
    jo.action = "html"
    jo.html = html

    koQuery(url, jo, { data:dynamic, textStatus:dynamic, jqXHR:dynamic ->
        if(textStatus=="success") {
            try {
                val jo: dynamic = kotlin.js.JSON.parse(data)
                if (jo.html) {
                    jQuery(element).append(jo.html)
                }
            } catch (e:Throwable){ }
        }
    })
}


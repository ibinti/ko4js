package ko4js
external val Number:dynamic = definedExternally
external val Array:dynamic = definedExternally

val version_azureus = { version:String ->
    version.replace(Regex("""\d*."""), { val x = "${it.value}".toFloat() % 100; "0$x".takeLast(2)}).take(4)
}

fun get_version_azureus(version:String):String {
    return version.replace(Regex("""\d*."""), { val x = "${it.value}".toFloat() % 100; "0$x".takeLast(2)}).take(4)
}

val jstype = {t:Any->js("typeof t")}

fun get_jstype(t:Any):String { return js("typeof t")}

val zero_pad = {num:dynamic, places:dynamic ->
    var zero = Number(places - num.toString().length + 1.asDynamic())
    if(zero < 0) zero = 0
    Array(zero).join("0") + num
}
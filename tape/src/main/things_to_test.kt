package ko4js

val version_azureus = { version:String ->
    version.replace(Regex("""\d*."""), { val x = "${it.value}".toFloat() % 100; "0$x".takeLast(2)}).take(4)
}

fun get_version_azureus(version:String):String {
    return version.replace(Regex("""\d*."""), { val x = "${it.value}".toFloat() % 100; "0$x".takeLast(2)}).take(4)
}

val jstype = {t:Any->js("typeof t")}

fun get_jstype(t:Any):String { return js("typeof t")}

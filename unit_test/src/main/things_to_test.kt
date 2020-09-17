package ko4js

import kotlin.js.Promise
import kotlinx.coroutines.*

external val require:dynamic = definedExternally
external val Array:dynamic = definedExternally
external val setTimeout:dynamic = definedExternally

val version_azureus = { version:String ->
    version.replace(Regex("""\d*."""), { val x = "${it.value}".toFloat() % 100; "0$x".takeLast(2)}).take(4)
}

fun get_version_azureus(version:String):String {
    return version.replace(Regex("""\d*."""), { val x = "${it.value}".toFloat() % 100; "0$x".takeLast(2)}).take(4)
}

val jstype = {t:Any->js("typeof t")}

val js_type = {t:dynamic->js("typeof t")}

fun get_jstype(t:Any):String { return js("typeof t")}

val simple_sha1 = require("simple-sha1")

val simple_sha1_promise = {input:dynamic ->
    Promise<dynamic> { resolve:dynamic, reject -> 
        simple_sha1(input, { hash ->
            resolve(hash)
        })
    }
}

suspend fun pawait(promise:dynamic):dynamic{return (promise as Promise<dynamic>).await()}

fun run_blocking( block: suspend () -> Unit): Promise<dynamic> = Promise<dynamic> { resolve:dynamic, _ -> GlobalScope.async{ block(); resolve() }}

val shajs = require("sha.js")

fun sha1(piece:dynamic):dynamic {
    return shajs("sha1").update(piece).digest("hex")
}

fun sha2(piece:dynamic):dynamic {
    return shajs("sha256").update(piece).digest("hex")
}

external val document:dynamic = definedExternally
external val window:dynamic = definedExternally

fun new(type: dynamic, vararg args: dynamic): dynamic {
    val argsArray = (listOf(null) + args).toTypedArray()
    return js("new (Function.prototype.bind.apply(type, argsArray))")
}

val printjo = { jo:dynamic -> 
    val msg = kotlin.js.JSON.stringify(jo)
    println(msg)
    msg
}


/*
drag-drop is installed on the system with npm install -g drag-drop 
*/
@JsModule("drag-drop")
external val dragDrop:dynamic = definedExternally

/*
webtorrent is installed on the system with npm install -g webtorrent 
*/
@JsModule("webtorrent")
external val WebTorrent:dynamic = definedExternally

fun main() {
    
     window.addEventListener("load", {
        
        document.querySelector("#res").innerText = "WebTorrent Seed"
        
        var client = new(WebTorrent)
        // When user drops files on the browser, create a new torrent and start seeding it!
        dragDrop("#dropTarget", { files ->
            
            printjo(files)
            client.seed(files, { torrent:dynamic ->
               document.querySelector("#dropTarget").innerText = "${torrent.magnetURI}"
               Unit
            })
            
        })
        
        Unit
    })

}
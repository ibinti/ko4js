external val document:dynamic = definedExternally
external val window:dynamic = definedExternally
external val JSON:dynamic = definedExternally

val printjo = { jo:dynamic -> 
    val msg = JSON.stringify(jo)
    println(msg)
    msg
}

@JsModule("drag-drop") //for npm install drag-drop
external val dragDrop:dynamic = definedExternally

fun main() {

     window.addEventListener("load", {
        
        document.querySelector("#res").innerText = "Drag and Drop Files"
        dragDrop("#dropTarget", { files ->
            
            val msg = printjo(files)
            document.querySelector("#dropTarget").innerText = "${msg}"
            
            Unit
        })
        
        Unit
    })
    
}
/*
apt install nodejs

node will use NODE_PATH to locate the global node_modules
export NODE_PATH=$(npm root --quiet -g)
in bash_profile, or .bashrc, or .profile etc whaterver your os needs

npm install -g kotlin
npm install -g vm //vm for node
npm install -g vm-browserify //vm for browser
npm install -g browserify

*/
external val require:dynamic = definedExternally
external val window:dynamic = definedExternally
external val document:dynamic = definedExternally

fun main() {
    
    println("welcome to kotlin vm browserify example")
    
    val vm = require("vm")
 
    window.addEventListener("load", {
        val res = vm.runInNewContext("a + 32", js("{ a : 32 }"))
        document.querySelector("#res").textContent = "$res-bit process" 
        Unit
    })

}
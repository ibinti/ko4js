package ko4js

@JsModule("tape")
external val test:dynamic = definedExternally

fun main() {

    test("jstype", { t ->
        t.plan(1)
        val test_string = "sunny not sunhee"
        val test = jstype(test_string)
        val label = "string"
        t.equal(test, label)
    })
    
    test("get_jstype", { t ->
        t.plan(1)
        val test_string = "sunny not sunhee"
        val test = get_jstype(test_string)
        val label = "string"
        t.equal(test, label)
    })
    
    test("empty map", { t ->
          emptyArray<Any>().map { x -> 
            t.fail("this callback should never fire")
        }
    
        t.end()
    })
    
    test("version_azureus", { t ->
        val label = arrayOf("0016", "0102", "0007")
        val versions = arrayOf("0.16.1", "1.2.5", "0.07.17")
        versions.forEachIndexed { index , version ->
            val test = version_azureus(version)
            
            t.equal(test, label[index])
        }
        t.end()
    })
    
    test("get_version_azureus", { t ->
        val label = arrayOf("0016", "0102", "0007")
        val versions = arrayOf("0.16.1", "1.2.5", "0.07.17")
        versions.forEachIndexed { index , version ->
            val test = get_version_azureus(version)
            
            t.equal(test, label[index])
        }
        t.end()
    })
    
    test("when_peer", { t ->
        val torrent = object { val numPeers = 1 }
        val test = when("${torrent.numPeers}"){
            "1"->"peer"
            else->"peers"
        }
        val label = "peer"
        t.equal(test, label)
        t.end()
    })
    
    test("when_peers", { t ->
        val torrent = object { val numPeers = 999 }
        val test = when("${torrent.numPeers}"){
            "1"->"peer"
            else->"peers"
        }
        val label = "peers"
        t.equal(test, label)
        t.end()
    })
    
    test("when_peers_empty", { t ->
        val torrent:dynamic = object { }
        val test_when = """${torrent.numPeers ?: 0}"""
        val test = when(test_when){
            "0"->"peer"
            "1"->"peer"
            else->"peers"
        }
        val label = "peer"
        t.equal(test, label)
        t.end()
    })
    
    test("when_peers_0", { t ->
        val torrent:dynamic = object { val numPeers = 0 }
        val test_when = """${torrent.numPeers ?: 0}"""
        val test = when(test_when){
            "0"->"peer"
            "1"->"peer"
            else->"peers"
        }
        val label = "peer"
        t.equal(test, label)
        t.end()
    })
    
    test("when_peers_1", { t ->
        val torrent:dynamic = object { val numPeers = 1 }
        val test_when = """${torrent.numPeers ?: 0}"""
        val test = when(test_when){
            "0"->"peer"
            "1"->"peer"
            else->"peers"
        }
        val label = "peer"
        t.equal(test, label)
        t.end()
    })
    
    test("when_peers_2", { t ->
        val torrent:dynamic = object { val numPeers = 2 }
        val test_when = """${torrent.numPeers ?: 0}"""
        val test = when(test_when){
            "0"->"peer"
            "1"->"peer"
            else->"peers"
        }
        val label = "peers"
        t.equal(test, label)
        t.end()
    })
}
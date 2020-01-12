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
    
}
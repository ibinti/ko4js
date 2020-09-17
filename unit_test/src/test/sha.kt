package ko4js
import kotlin.test.*
import kotlin.js.Promise
import kotlinx.coroutines.*

class sha_test {
    
    val labels = Array.of(
    "0123456789abcdefghijklmnopqrstuvwxyz", 
    "Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.", 
    "Use '--warning-mode all' to show the individual deprecation warnings."
    )
    
    @Test fun sha1_0() = run_blocking {
        println("""
            |sha1_0()
            |""".trimMargin())
        for(index in 0 until labels.length){ 
            val label_to_test = labels[index]
            val test_simple_sha1 = simple_sha1_promise(label_to_test).await()
            val test_sha1 = sha1(label_to_test)
            println("""$index:
                |$test_simple_sha1
                |$test_sha1
                |""".trimMargin())
            assertEquals(test_simple_sha1, test_sha1)
        }
    }
    
    @Test fun sha1_1() = run_blocking {
        println("""| 
            |sha1_1()
            |""".trimMargin())
        for(index in 0 until labels.length){ 
            val label_to_test = labels[index]
            val test_simple_sha1 = simple_sha1_promise(label_to_test).await()
            val test_sha2 = sha2(label_to_test)
            println("""$index:
                |$test_simple_sha1
                |$test_sha2
                |""".trimMargin())
            assertNotEquals(test_simple_sha1, test_sha2)
        }
    }
    
    @Test fun sha1_2() = run_blocking {
        println("""| 
            |sha1_2()
            |""".trimMargin())
        for(index in 0 until labels.length){ 
            val label_to_test = labels[index]
            val test_simple_sha1 = simple_sha1_promise(label_to_test).await()
            val test_sha2 = sha2(label_to_test)
            println("""$index:
                |$test_simple_sha1
                |$test_sha2
                |""".trimMargin())
            assertNotEquals(test_simple_sha1, test_sha2)
            delay(100)
            println("""
            |delayed 100 ms to demo suspending function
            |""".trimMargin())
        }
    }
}
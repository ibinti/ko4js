val kotlin_version: String by extra

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.4.10"
}

plugins {
    val kotlin_version: String by extra
    kotlin("js") version kotlin_version
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.3.9")
    testImplementation(kotlin("test-js"))
    implementation(npm("simple-sha1","3.0.1"))
    implementation(npm("sha.js","2.4.11"))
}

repositories {
    jcenter()
}

defaultTasks("browserTest")

kotlin {
    
    sourceSets["main"].apply {    
        kotlin.srcDir("src/main") 
    }
    
    sourceSets["test"].apply {    
        kotlin.srcDir("src/main")
        kotlin.srcDir("src/test") 
    }
    
    js {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    //useSafari()
                    //useFirefox()
                    //useChrome()
                }
            }
        }
    }
}
//./gradlew wrapper --gradle-version=6.6.1 --distribution-type=all

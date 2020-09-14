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
    testImplementation(kotlin("test-js"))
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
    
    target {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    //useFirefox()
                }
            }
        }
    }
}
//./gradlew wrapper --gradle-version=6.6.1 --distribution-type=all

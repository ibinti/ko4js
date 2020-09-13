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
}

repositories {
    jcenter()
}

defaultTasks("browserProductionWebpack")

kotlin {
    js {
        sourceSets["main"].apply {    
            kotlin.srcDir("src") 
        }
        browser {
            distribution {
                directory = File("${projectDir}/js")
            }
        }
        binaries.executable()
    }
}

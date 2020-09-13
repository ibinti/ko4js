val kotlin_version: String by extra

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.4.10"
}

plugins {
    kotlin("js") version "1.4.10"
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
        browser {
            distribution {
                directory = File("${projectDir}/js")
            }
        }
        binaries.executable()
    }
}

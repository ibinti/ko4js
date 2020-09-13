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
}

repositories {
    jcenter()
}

defaultTasks("ibinti")

tasks{
    register("ibinti") {
        dependsOn("build")
        doLast {
            copy {
                from("build/js/packages/${name}/kotlin/${name}.js")
                into("${projectDir}")
            }
        }
    }
}

kotlin {
    sourceSets["main"].apply {    
        kotlin.srcDir("src") 
    }
    js {
        moduleName = "ibinti" //this does not affect distribution module name yet!
        nodejs {
            
        }
        binaries.executable()
    }
}
//./gradlew wrapper --gradle-version=6.6.1 --distribution-type=all

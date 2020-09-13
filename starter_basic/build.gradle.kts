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

defaultTasks("basic")

tasks{
    register("basic") {
        dependsOn("browserProductionWebpack")
        /*
        * this is until the kotlin("js") does honestly what it claims
        * moduleName and output.filename are useless at the moment
        * */
        doLast {
            copy {
                from("build/distributions/starter_basic.js")
                into("${projectDir}/js")
                rename("starter_basic.js", "ibinti.js")
            }
        }
    }
}

kotlin {
    sourceSets["main"].apply {    
        kotlin.srcDir("src") 
    }
    js {
        moduleName = "ibinti" //this does not affect distribution module name yet! it only affect build.packages.moduleName, but who cares about temporary build name that automatically re-builds every time?
        
        browser {
            webpackTask {
            /* 
             output.filename = "ibinti.js"
                    ^ Unresolved reference: filename
             it should but it does not as of 1.4.10
             as a workarounf for now, use "basic" task doLast{}
            */
               //output.filename = "ibinti.js"
            }
//            distribution {
//                directory = File("${projectDir}/js")
//            }
        }
        binaries.executable()
    }
}
//./gradlew wrapper --gradle-version=6.6.1 --distribution-type=all
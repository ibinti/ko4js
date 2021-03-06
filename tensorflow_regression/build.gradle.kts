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
        dependsOn("browserProductionWebpack")
        /*
        * this is until the kotlin("js") does honestly what it claims
        * moduleName and output.filename are useless at the moment
        * */
        doLast {
            copy {
                from("build/distributions/${project.name}.js")
                into("js_bundle")
                rename("${project.name}.js", "ibinti.js")
            }
        }
        doLast { 
            val output = File("ibinti.js").writer()
            output.write("let ibinti={};")
            arrayOf("tf.min.js","tfjs-vis.umd.min.js","ibinti.js").forEach {
                val js = File("js_bundle/${it}").readText()
                output.write(js)
                output.write("\n")
            }
            output.close()
        }
    }
}

kotlin {
    sourceSets["main"].apply {    
        kotlin.srcDir("src") 
    }
    js {
        moduleName = "ibinti" //this does not affect distribution module name yet!
        
        browser {
            dceTask {
                keep("${moduleName}.fn" )
            }
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
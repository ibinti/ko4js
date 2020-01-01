plugins {
    id("kotlin2js") version "1.3.61"
    id("kotlin-dce-js") version "1.3.61"
}
sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {    
    kotlin.srcDir("src")
}
dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.3.2")
}

repositories {
    jcenter()
}

defaultTasks("uglifyjs")

tasks {
    
    runDceKotlinJs {
        //If the function has parameters, its name will be mangled, so the mangled name should be used in the keep directive. However if @JsName is used for the function name, use JsName instead so that no mangled name is necessary.
        keep("ko4js.ibinti.fn")
    }

    register("dce") {
        dependsOn(runDceKotlinJs)
        doLast {
            copy {
                from("build/kotlin-js-min/main/ko4js.js")
                into("js/dce")
            }
        }
    }

    register<Exec>("uglifyjs") {
        dependsOn("dce")
        /*
        uglifyjs is installed on the system with node 
        or
        apt install node-uglify
        
        node -v
        v8.10.0
        
        v10 complains about strict mode
        */
        commandLine("uglifyjs", 
        "build/kotlin-js-min/main/kotlin.js", 
        "build/kotlin-js-min/main/kotlinx-coroutines-core.js",
        "js/dce/ko4js.js", 
        "-c", "-m", "-o", "js/ko4js.min.js")
    }
    
    compileKotlin2Js {
        kotlinOptions {
            outputFile = "${projectDir}/js/ko4js.js"
            moduleKind = "plain"
            sourceMap = false
            sourceMapEmbedSources = "never"
            metaInfo = false
        }
    }
    
}
//./gradlew wrapper --gradle-version 6.0.1 --distribution-type all
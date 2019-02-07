import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
    id("kotlin2js") version "1.3.20"
    id("kotlin-dce-js") version "1.3.20"
}

dependencies {
    implementation(kotlin("stdlib-js"))
}

repositories {
    jcenter()
}

defaultTasks("uglifyjs")

tasks {
    
    runDceKotlinJs {
        //If the function has parameters, its name will be mangled, so the mangled name should be used in the keep directive. However if @JsName is used for the function name, use JsName instead so that no more mangled name is necessary.
        keep("ko4js.okoko.log", "ko4js.okoko.jtext_wn2jw4\$", "ko4js.okoko.no_mangle")
    }

    register<Exec>("uglifyjs") {
        dependsOn("runDceKotlinJs")
        /*
        uglifyjs is installed on the system with npm 
        */
        commandLine("uglifyjs", "build/kotlin-js-min/main/kotlin.js", "build/kotlin-js-min/main/ko4js.js", "-c","-m", "-o", "build/kotlin-js-min/main/ko4js.min.js")
    }
    
    compileKotlin2Js {
        kotlinOptions {
            outputFile = "${sourceSets.main.get().output.resourcesDir}/ko4js.js"
            moduleKind = "plain"
            sourceMap = false
            sourceMapEmbedSources = "never"
            metaInfo = false
        }
    }
    
}
//./gradlew wrapper --gradle-version 5.2 --distribution-type all
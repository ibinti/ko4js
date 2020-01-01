plugins {
    id("kotlin2js") version "1.3.61"
    id("kotlin-dce-js") version "1.3.61"
}
sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {    
    kotlin.srcDir("src")
}
dependencies {
    implementation(kotlin("stdlib-js"))
}

repositories {
    jcenter()
}

defaultTasks("dce")

tasks {
    
    runDceKotlinJs {
        //If the function has parameters, its name will be mangled,
        // so the mangled name should be used in the keep directive. 
        // However if @JsName is used for the function name, 
        // use JsName instead so that no mangled name is necessary.
        keep("dce.fn")
    }

    register("dce") {
        dependsOn(runDceKotlinJs)
        doLast {
            copy {
                from("build/kotlin-js-min/main/dce.js")
                into("${projectDir}/js/after_dce")
            }
            copy {
                from("build/kotlin-js-min/main/kotlin.js")
                into("${projectDir}/js")
            }
        }
    }
    
    compileKotlin2Js {
        kotlinOptions {
            outputFile = "${projectDir}/js/dce.js"
            moduleKind = "plain"
            sourceMap = false
            sourceMapEmbedSources = "never"
            metaInfo = false
        }
    }
    
}
//./gradlew wrapper --gradle-version 6.0.1 --distribution-type all
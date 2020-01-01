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

defaultTasks("basic")

tasks {
    
    register("basic") {
        dependsOn(runDceKotlinJs)
        doLast {
            copy {
                from("build/kotlin-js-min/main/basic.js")
                into("${projectDir}/js")
            }
            copy {
                from("build/kotlin-js-min/main/kotlin.js")
                into("${projectDir}/js")
            }
            
        }
    }

    compileKotlin2Js {
        kotlinOptions {
            outputFile = "${projectDir}/js/basic.js"
            moduleKind = "plain"
            sourceMap = false
            sourceMapEmbedSources = "never"
            metaInfo = false
        }
    }
    
}
//./gradlew wrapper --gradle-version 6.0.1 --distribution-type all
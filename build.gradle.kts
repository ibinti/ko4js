import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
    id("kotlin2js") version "1.3.11"
    id("kotlin-dce-js") version "1.3.11"
}

dependencies {
    implementation(kotlin("stdlib-js"))
}

repositories {
    jcenter()
}

defaultTasks("uglifyjs")

tasks {
    register<Exec>("uglifyjs") {
        //dependsOn(build)
        dependsOn("runDceKotlinJs")
        /*
        uglifyjs is installed on the system with npm 
        */
        commandLine("uglifyjs", "build/kotlin-js-min/main/kotlin.js", "build/kotlin-js-min/main/ko4js.js", "-c","-m", "-o", "build/kotlin-js-min/main/ko4js.core.js")
        // commandLine("uglifyjs", "build/kotlin-js-min/main/kotlin.js", "build/kotlin-js-min/main/ko4js.js", "-b", "-o", "js/ko4js.core.js") 
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
    val unpackKotlinJsStdlib by registering {
        group = "build"
        description = "Unpack the Kotlin JavaScript standard library"
        val outputDir = file("$buildDir/$name")
        inputs.property("compileClasspath", configurations.compileClasspath.get())
        outputs.dir(outputDir)
        doLast {
            val kotlinStdLibJar = configurations.compileClasspath.get().single {
                it.name.matches(Regex("kotlin-stdlib-js-.+\\.jar"))
            }
            copy {
                includeEmptyDirs = false
                from(zipTree(kotlinStdLibJar))
                into(outputDir)
                include("**/*.js")
                exclude("META-INF/**")
            }
        }
    }
    val assembleWeb by registering(Copy::class) {
        group = "build"
        description = "Assemble the web application"
        includeEmptyDirs = false
        from(unpackKotlinJsStdlib)
        from(sourceSets.main.get().output) {
            exclude("**/*.kjsm")
        }
        into("$buildDir/web")
    }
    assemble {
        dependsOn(assembleWeb)
    }
}
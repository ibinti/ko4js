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

    register<Exec>("uglifyjs") {
        dependsOn(runDceKotlinJs)
        /*
        uglifyjs is installed on the system with apt install uglifyjs 
        */
        commandLine("uglifyjs", 
        "build/kotlin-js-min/main/app.js", 
        "-c", "-m", "-o", "js/app.js")
    }
    
    compileKotlin2Js {
        kotlinOptions {
            outputFile = "${projectDir}/js/app.js"
            moduleKind = "commonjs"
            sourceMap = false
            sourceMapEmbedSources = "never"
            metaInfo = false
        }
    }
}

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

defaultTasks("browserify")

tasks {

    register<Exec>("browserify") {
        dependsOn(runDceKotlinJs)
        /*
        browserify is installed on the system with npm install -g browserify 
        */
        commandLine("browserify", 
        "build/kotlin-js-min/main/app.js", 
        "-o", "bundle.js")
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

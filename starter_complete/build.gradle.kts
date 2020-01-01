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
        keep("ko4js.fn")
    }

    register<Exec>("uglifyjs") {
        dependsOn(runDceKotlinJs)
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
        "build/kotlin-js-min/main/ko4js.js", 
        "-c", "-m", "-o", "ibinti.min.js")
    }
    
    compileKotlin2Js {
        kotlinOptions {
            outputFile = "${projectDir}/build/ko4js.js"
            moduleKind = "plain"
            sourceMap = false
            sourceMapEmbedSources = "never"
            metaInfo = false
        }
    }
    
}
//./gradlew wrapper --gradle-version 6.0.1 --distribution-type all
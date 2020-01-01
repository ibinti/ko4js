plugins {
    id("kotlin2js") version "1.3.61"
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

defaultTasks("build")

tasks {
    
    compileKotlin2Js {
        kotlinOptions {
            outputFile = "${projectDir}/js/helloworld.js"
            moduleKind = "plain"
            sourceMap = false
            sourceMapEmbedSources = "never"
            metaInfo = false
        }
    }
    
}
//./gradlew wrapper --gradle-version 6.0.1 --distribution-type all
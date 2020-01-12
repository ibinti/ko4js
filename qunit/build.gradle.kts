val kotlin_version: String by extra
buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.3.61"
}

plugins {
    val kotlin_version: String by extra
    id("kotlin2js") version "$kotlin_version"
}

dependencies {
    implementation(kotlin("stdlib-js"))
    testImplementation(kotlin("test-js"))
}

repositories {
    jcenter()
}

sourceSets {
    main {
        withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
            kotlin.srcDir("src/main")
        }
    }
    test {
        withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
            kotlin.srcDir("src/main")
            kotlin.srcDir("src/test")
        }
    }
}

defaultTasks("qunit")

tasks {

    compileKotlin2Js {
        kotlinOptions {
            outputFile = "${projectDir}/js/app.js"
            moduleKind = "commonjs"
            sourceMap = false
            sourceMapEmbedSources = "never"
            metaInfo = false
        }
    }
    
    compileTestKotlin2Js {
        kotlinOptions {
            outputFile = "${projectDir}/test/app.js"
            moduleKind = "commonjs"
            sourceMap = false
            sourceMapEmbedSources = "never"
            metaInfo = false
        }
    }
    
    register<Exec>("install-qunitjs") {
        commandLine("npm","install", "--prefix", "${projectDir}", "qunitjs", "--save-dev")
    }

    register<Exec>("install-node-qunit") {
        commandLine("npm","install", "--prefix", "${projectDir}", "node-qunit", "--save-dev")
    }

    register<Exec>("qunit") {
        dependsOn(test)
        commandLine("qunit") //default is js files in test directory, gunit test/app.js
    }

}

//./gradlew wrapper --gradle-version=6.0.1 --distribution-type=all
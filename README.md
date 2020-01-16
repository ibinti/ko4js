# This is ko4js

## Kotlin for JavaScript

The projects show how to code in Kotlin to generate a complete js file that works in the browser and nodejs.

For those projects that use npm modules and targeting nodejs, obviously working node and npm are required.

For those projects that target browser and nevertheless still use node npm modules, browserify must be installed on the system along with other relevant npm modules. 

This repo consists of sub directories. Each directory is a complete standalone project.
 
Project build is done with Gradle Kotlin DSL. To build a browser project, open the terminal and cd to the directory of your interest. Run <code>./gradlew</code>, and then open html file to see the action in the browser. Note that JDK8 is required for the Gradle. We use <code>./gradlew</code> so that Gradle installation in the system level is not required.


<a href="https://ibinti.com/ko4js" target="_blank">https://ibinti.com/ko4js</a>
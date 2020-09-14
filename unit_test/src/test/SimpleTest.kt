package ko4js

import kotlin.test.*
external val require:dynamic = definedExternally

class SimpleTest {

    @Test fun test_jstype() {
        val test_string = "sunny not sunhee"
        val test = jstype(test_string)
        val label = "string"
        assertEquals(test, label)
    }
    
    @Test fun test_get_jstype() {
        val test_string = "sunny not sunhee"
        val test = get_jstype(test_string)
        val label = "string"
        assertEquals(test, label)
    }
    
    @Test fun test_version_azureus() {
    /**
     * Version number in Azureus-style. Generated from major and minor semver version.
     * For example:
     *   '0.16.1' -> '0016'
     *   '1.2.5' -> '0102'
     *   '0.07.17' -> '0007'
     */

        val label = arrayOf("0016", "0102", "0007")
        val versions = arrayOf("0.16.1", "1.2.5", "0.07.17")
        versions.forEachIndexed { index , version ->
            val test = version_azureus(version)
            
            assertEquals(test, label[index])
        }
        
    }
    
    @Test fun test_get_version_azureus() {
    /**
     * Version number in Azureus-style. Generated from major and minor semver version.
     * For example:
     *   '0.16.1' -> '0016'
     *   '1.2.5' -> '0102'
     *   '0.07.17' -> '0007'
     */

        val label = arrayOf("0016", "0102", "0007")
        val versions = arrayOf("0.16.1", "1.2.5", "0.07.17")
        versions.forEachIndexed { index , version ->
            val test = get_version_azureus(version)
            
            assertEquals(test, label[index])
        }
        
    }

    @Test fun test_package_version_5() {
        
        val label_version = "0123"
        
        val version = require("../../../../../package.json").version
        val test_version = version_azureus(version)
        
        assertEquals(test_version, label_version)
        
    }
    
    @Test fun test_package_version_4() {
        
        val label_version = "0123"
        
        val version = require("../../../../package.json").version
        val test_version = version_azureus(version)
        
        assertEquals(test_version, label_version)
        
    }
    
    @Test fun test_package_version_3() {
        
        val label_version = "0123"
        
        val version = require("../../../package.json").version
        val test_version = version_azureus(version)
        
        assertEquals(test_version, label_version)
        
    }
    
    @Test fun test_package_version_2() {
        
        val label_version = "0123"
        
        val version = require("../../package.json").version
        val test_version = version_azureus(version)
        
        assertEquals(test_version, label_version)
        
    }
    
    @Test fun test_package_version_1() {
        
        val label_version = "0123"
        
        val version = require("../package.json").version
        val test_version = version_azureus(version)
        
        assertEquals(test_version, label_version)
        
    }
    
    @Test fun test_package_version_0() {
        
        val label_version = "0123"
        
        val version = require("package.json").version
        val test_version = version_azureus(version)
        
        assertEquals(test_version, label_version)
        
    }
    
}
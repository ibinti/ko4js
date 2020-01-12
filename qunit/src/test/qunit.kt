package ko4js
external val QUnit:dynamic = definedExternally

fun main() {

    QUnit.test( "qunit test jstype", {assert ->
        val test_string = "sunny not sunhee"
        val test = jstype(test_string)
        val label = "string"
        assert.equal(test, label)
    })
    
    QUnit.test( "qunit test get_jstype", {assert ->
        val test_string = "sunny not sunhee"
        val test = get_jstype(test_string)
        val label = "string"
        assert.equal(test, label)
    })
    
    QUnit.test( "qunit multiple assert test", {assert ->
        assert.equal( 0, 0, "Zero, Zero; equal succeeds" );
        assert.equal( "", 0, "Empty, Zero; equal succeeds" );
        assert.equal( "", "", "Empty, Empty; equal succeeds" );
        
        assert.equal( "three", 3, "Three, 3; equal fails" );
        assert.equal( null, false, "null, false; equal fails" );
    })
    
    QUnit.test( "equal test 1", {assert ->
        assert.equal( 0, 0, "Zero, Zero; equal succeeds" );
    })
    
    QUnit.test( "equal test 2", {assert ->
        assert.equal( "", 0, "Empty, Zero; equal succeeds" );
    })
    
    QUnit.test( "equal test 3", {assert ->
        assert.equal( "", "", "Empty, Empty; equal succeeds" );
    })
    
    QUnit.test( "equal test 4", {assert ->
        assert.equal( "three", 3, "Three, 3; equal fails" );
    })
    
    QUnit.test( "equal test 5", {assert ->
        assert.equal( null, false, "null, false; equal fails" );
    })
    
}
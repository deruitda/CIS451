import org.junit.Assert;
import org.junit.Test;

import static edu.gvsu.dlunit.DLUnit.*;

/**
 * Sample test cases for SignedLessThan.jls
 * 
 * Created by Will Herrmann and Danny DeRuiter on 1/30/17.
 */
public class SignedLessThanTests {
    
    private static final long testPositiveIntegers[] = {0, 1, 2, 13, 127, 128, 129, 55, 18, 1800, 5738, 10, 99};
    
    private static final long testNegativeIntegers[] = {-412, -8382, 0, -888, -8, -1, -9, -4999, -229};
    
    private static final long testAbsolutelyLargePositive[] = {30000, 31000, 24959, 32000, 29567, 28282, 31500, 32109};

    private static final long testAbsolutelyLargeNegative[] = {-30000, -31000, -24959, -32000, -29567, -28282, -31500, -32109};


    protected void verify(long a, long b) {
	int expected = a < b ? 1 : 0;
	setPinSigned("InputA", a);
	setPinSigned("InputB", b);
	run();
	String message = "Output of a < b   ("+a+" < "+b+") is "+readPinUnsigned("Output")+", but expected "+expected;
	
	Assert.assertEquals(message, expected, readPinUnsigned("Output"));
    }
    
    @Test
    public void testPositive() {
	for (long a : testPositiveIntegers) {
	    for (long b : testPositiveIntegers) {
		verify(a, b);
	    }
	}
    }

    @Test
    public void testNegative(){
	for (long a : testNegativeIntegers) {
            for (long b : testNegativeIntegers) {
                verify(a, b);
            }
        }
    }

    @Test
    public void testPostiveAndNegative(){
	for (long a : testPositiveIntegers) {
            for (long b : testNegativeIntegers) {
                verify(a, b);
            }
        }
    }

    @Test
    public void testPositiveOverflow(){
	for (long a : testAbsolutelyLargePositive) {
            for (long b : testAbsolutelyLargeNegative) {
                verify(a, b);
            }
        }
    }

    @Test 
    public void testNegativeOverflow(){
	for (long a : testAbsolutelyLargeNegative) {
            for (long b : testAbsolutelyLargePositive) {
                verify(a, b);
            }
        }
    }
}//end of class

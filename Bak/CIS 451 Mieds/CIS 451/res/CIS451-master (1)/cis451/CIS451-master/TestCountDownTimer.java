package W13project1;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestCountDownTimer {
/*23456789012345678901234567890123456789012345678901234567890123456789012	

	/******  Your assignment is to complete the test cases below ******/
	
	// The following test cases are for the first part (steps 1 - 4) 
	// of the assignment
	
	@Test
	public void testConstructor() {
		CountDownTimer s = new CountDownTimer(5,10,30);
		assertEquals(s.toString(),"5:10:30");
		
		s = new CountDownTimer("20:10:8");
		assertEquals(s.toString(),"20:10:08");
		
		s = new CountDownTimer("20:8");
		assertEquals(s.toString(),"0:20:08");
		
		s = new CountDownTimer("8");
		assertEquals(s.toString(),"0:00:08");

		// You create 5 more JUnit tests for different constructors 
		// and toString methods.
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorWithErrors() {
		CountDownTimer s = new CountDownTimer(5,100,300);
		// You create 5 more JUnit tests for different constructors 
	}

	@Test
	public void testSubMethod () {
		CountDownTimer s1 = new CountDownTimer(5,01,30);
		s1.subtract(2000);
		assertEquals (s1.toString(),"4:28:10");
		
		s1 = new CountDownTimer(5,59,30);
		CountDownTimer s2 = new CountDownTimer(1,2,35);
		s1.subtract(s2);
		assertEquals (s1.toString(),"4:56:55");
	
		for (int i = 0; i < 15000; i++) {
			s1.dec();
			// System.out.println (s1);
		}

		assertEquals (s1.toString(),"0:46:55");

	
	// You are to create 6 more JUnit tests for different 
	//	add and inc methods.
	
	}
	
	@Test 
	public void testEqual () {
		CountDownTimer s1 = new CountDownTimer(5,59,00);
		CountDownTimer s2 = new CountDownTimer(6,01,00);
		CountDownTimer s3 = new CountDownTimer(5,50,20);
		CountDownTimer s4 = new CountDownTimer("5:59:00");

		assertFalse(s1.equals(s2));
		assertTrue (s1.equals(s4));

	// You are to create 3 more JUnit tests for the equals methods.
	
	}
	
	@Test 
	public void testCompareTo () {
		CountDownTimer s1 = new CountDownTimer(5,59,00);
		CountDownTimer s2 = new CountDownTimer(6,01,00);
		CountDownTimer s3 = new CountDownTimer(5,50,20);
		CountDownTimer s4 = new CountDownTimer("5:59:00");
		
		assertTrue (s2.compareTo(s1) > 0);
		assertTrue (s3.compareTo(s1) < 0);
		assertTrue (s1.compareTo(s4) == 0);

	// You are to create 4 more JUnit tests for the compareTo Methods.
	
	}
	
	/*********************** Second part ******************************/
	
// These test cases are for the second part (step 5) of the assignment
	
	@Test 
	public void testLoadSave () {
		CountDownTimer s1 = new CountDownTimer(5,59,30);
		CountDownTimer s2 = new CountDownTimer("5:59:30");

		s1.save("file1");
		s1 = new CountDownTimer();  // resets to zero
		
		s1.load("file1");
		assertTrue (s1.equals(s2));
	
	// You are to create 2 more JUnit test for load and Save
	}
		
	@Test 
	public void testCounter () {
		CountDownTimer s1 = new CountDownTimer(6,59,00);
		CountDownTimer s2 = new CountDownTimer(6,59,00);
		
		 System.out.println(CountDownTimer.getNumberCreated());
		// Be careful on this one!!!!  why 20; why not 2;  Testing is done randomly
        // Hence, ask your instructor on ways of having a testCounter method.
		assertTrue (CountDownTimer.getNumberCreated() == 20);
		
	// You are to create 2 more JUnit test for load and Save methods
	}
}

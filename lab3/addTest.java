package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class addTest {

	@Test
	public void test() {
		junitTesting test = new junitTesting();
		junitTesting test2 = new junitTesting();
		
		int output = test.addition(5, 10);
		assertEquals(15, output);
		System.out.println("15 equal to " + output );
		
		int output2 = test2.addition(6, 21);
		System.out.println("20 not equal to " + output2 );
		assertEquals(20, output2);
		
		
	}

}

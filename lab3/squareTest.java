package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class squareTest {

	@Test
	public void test() {
		junitTesting test2 = new junitTesting();
		junitTesting test = new junitTesting();
		
		int output = test.square(5);
		System.out.println("20 not equal to " + output);
		assertEquals(20,output);
		
		
		int output2 = test2.square(10);
		assertEquals(100, output2);
		System.out.println("100 equal to " + output2);
	
	}

}

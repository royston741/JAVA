package com.test.JUNIT_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArraySortTest {
	ArraySort sortArray;

	@Before
	public void setUp() throws Exception {
		sortArray = new ArraySort();
	}

	@After
	public void tearDown() throws Exception {
		sortArray = null;
	}

	@Test
	public void testMaxValueOfArray() {

		// comparing expected value with the method returned value
		assertEquals(124, sortArray.maxValueOfArray(new int[] { 32, 43, 54, 12, 56, 1254 }));
	}
}

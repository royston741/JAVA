/* 
	Program : Finding the max value in an array
	@Author : Royston
	@Date :23 Nov
*/

package com.test.JUNIT_Test;

import java.util.Arrays;

public class ArraySort {
	// create maxValueOfArray
	public int maxValueOfArray(int... arr) {
		// sort the array
		Arrays.sort(arr);
		// return the max value of array
		return arr[arr.length - 1];
	}

}

package com.student.student_management;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.dao.StudentDao;

/**
 * Unit test for simple App.
 */
public class AppTest {
	StudentDao studentOp;

	@Before
	public void setUp() throws Exception {
		studentOp = new StudentDao();
	}

	@After
	public void tearDown() throws Exception {
		studentOp = null;
	}

	@Test
	public void testDeleteStudent() {
		// storing the deleted student id
		long deletedStdId = studentOp.deleteStudent(1).getStdId();
		// check if deleted
		assertEquals(1, deletedStdId);
	}

	@Test
	public final void testDeleteStudentException() {
		Assertions.assertThrows(IllegalStateException.class, () -> studentOp.deleteStudent(1));

	}

}

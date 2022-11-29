package com.student.student_management;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.dao.StudentDao;
import com.entity.Student;

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

	@Ignore
	public void testDeleteStudent() {
		// storing the deleted student
		Student deletedStd = studentOp.deleteStudent(1);

		// check if deleted
		assertEquals(null, deletedStd);
	}

	@Test
	public void testGetStudentById() {
		Student getStd = studentOp.getStudentById(2);

		// Id
		assertEquals(2, getStd.getStdId());
		// first name
		assertEquals("Jhon", getStd.getFirstName());
		// last name
		assertEquals("Wick", getStd.getLastName());
		// email
		assertEquals("jhon123wickn@gmail.com", getStd.getEmailAddr());

	}

	@Ignore
	public final void testDeleteStudentException() {
		Assertions.assertThrows(IllegalStateException.class, () -> studentOp.deleteStudent(1));
	}

}

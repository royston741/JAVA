/*
 	Program : Create a maven project to implement student management system to implement the CRUD using hibernate with a single Junit test case
    			to test deletion of an existing student.
	@Author : Royston
	@Date :24 Nov
 */

package com.student.student_management;

import com.dao.StudentDao;
import com.entity.Course;
import com.entity.Student;

public class App {
	public static void main(String[] args) {
		// Create student and course object
		Student s1 = new Student("Royston", "Rodrigues", "roy71ston@gmail.com");
		Course c1 = new Course("Python");
		s1.setCourse(c1);
		c1.setStudent(s1);

		Student s2 = new Student("Jhon", "Wick", "jhon123wickn@gmail.com");
		Course c2 = new Course("Java");
		s2.setCourse(c2);
		c2.setStudent(s2);

		Student s3 = new Student("Leonardo", "Dcaprio", "leonardo3232dcaprio@gmail.com");
		Course c3 = new Course("C++");
		s3.setCourse(c3);
		c3.setStudent(s3);

		Student s4 = new Student("Elise", "Ton", "elis71322ton@gmail.com");
		Course c4 = new Course("Ruby");
		s4.setCourse(c4);
		c4.setStudent(s4);

		// Create studentDao object
		StudentDao stdDao = new StudentDao();
		// Add student
		stdDao.saveStudent(s1);
		stdDao.saveStudent(s2);
		stdDao.saveStudent(s3);
		stdDao.saveStudent(s4);

		// Delete student
//		Student s = stdDao.deleteStudent(s2.getStdId());
//		System.out.println("Deleted Student : " + s.getFirstName());

		// Update student
//		s4.setFirstName("Joel");
//		stdDao.updateStudent(s4);

		// get student by id
//		System.out.println("The student name is :" + stdDao.getStudentById(3).getFirstName());

		// get all student first name
//		System.out.println("------- STUDENT LIST -------");
		// getting all student
//		List<Student> allStudents = stdDao.getAllStudent();
		// printing all student first name
//		allStudents.forEach(s -> System.out.println(s.getFirstName()));
	}
}

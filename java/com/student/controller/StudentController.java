package com.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.model.StudentDTO;
import com.student.service.StudentService;
import com.student.util.Converter;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private Converter converter;
	
	//build create student REST API
	@PostMapping("/createStudent/{role}")
	public ResponseEntity<?> createStudent(@Valid @RequestBody StudentDTO studentDTO,
			@PathVariable("role") String role)
	{
		final Student student= converter.convertToEntity(studentDTO);
		if(role.equals("admin"))
		{
			return new ResponseEntity<String>(studentService.createStudent(student),
					HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<String>("You are not an admin",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//build update student details REST API
	@PutMapping("/updateStudent/{identity}")
	public StudentDTO updateStudent(@PathVariable("identity") int id,
			@Valid @RequestBody StudentDTO studentDTO)
	{
		Student student1 = converter.convertToEntity(studentDTO);
		return studentService.updateStudent(id, student1);
	}
	
	//build get student details using id REST API
	@GetMapping("/getStudentById/{id}")
	public StudentDTO getStudentById(@PathVariable("id") int id)
	{
		return studentService.getStudentById(id);
	}
	
	
	//build get all student details REST API
	@GetMapping("/getAllStudents")
	public List<StudentDTO> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	//build delete student details using id REST API
	@DeleteMapping("/deleteStudentById/{id}")
	public String deleteStudentById(@PathVariable("id") int id)
	{
		return studentService.deleteStudentById(id);
	}
	
	@DeleteMapping("/deleteAllStudents")
	public ResponseEntity<String> deleteAllStudents()
	{
		studentService.deleteAllStudents();
		return new ResponseEntity<String>("All students details "
				+ "have been deleted",HttpStatus.OK);
	}
	
	@GetMapping("/getStudentByName/{name}")
	public List<StudentDTO> getStudentByName(@PathVariable("name") String studentName)
	{
		return studentService.getStudentByName(studentName);
	}
	
	@GetMapping("/getStudentByEmail/{email}")
	public List<StudentDTO> getStudentByEmail(@PathVariable("email") String email)
	{
		return studentService.getStudentByEmail(email);
	}
	
	@PostMapping("/assignAddressToStudent/{studentId}/{addressId}")
	public StudentDTO assignAddressToStudent(@PathVariable("studentId") int id,
			@PathVariable("addressId") int addressId)
	{
		return studentService.assignAddressToStudent(id, addressId);
	}
	
	
	@GetMapping("/getAllStudentsWithSort/{field}")
	public List<StudentDTO> getAllStudentsWithSort(@PathVariable String field)
	{
		return studentService.getAllStudentWithSort(field);
	}
	
	@GetMapping("/findStudentsWithPagination/{offset}/{pageSize}")
	public Page<Student> findStudentsWithPagination(@PathVariable("offset") int offset,
			@PathVariable("pageSize") int pageSize)
	{
		return studentService.findStudentsWithPagination(offset, pageSize);
	}
}

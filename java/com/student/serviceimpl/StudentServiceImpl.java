package com.student.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.student.entity.Address;
import com.student.entity.Student;
import com.student.exception.ResourceNotFoundException;
import com.student.model.StudentDTO;
import com.student.repository.AddressRepository;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import com.student.util.Converter;

@Service
public class StudentServiceImpl implements StudentService{

	private static final Logger l = LoggerFactory.getLogger(Student.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private Converter converter;
	
	@Override
	public String createStudent(Student student) {
		String message=null;
		student.setUserName(student.getUserName());
		student.setPassword(student.getPassword());
		student.setRole(student.getRole());
		l.info("Student "+student.toString()+" added at "+ new Date());
		studentRepository.save(student);
		if(student!=null)
		{
			message="Student details saved successfully";
		}
		return message;
	}

	@Override
	public StudentDTO updateStudent(int id, Student student) {
		Student existingStudent =studentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "ID", id));
		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setPhone(student.getPhone());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setUserName(student.getUserName());
		existingStudent.setPassword(student.getPassword());
		existingStudent.setRole(student.getRole());
		l.info("Student with id "+id+" updated at "+new Date());
		studentRepository.save(existingStudent);
		
		return converter.convertToStudentDTO(existingStudent);
	}

	@Override
	public StudentDTO getStudentById(int id) {
		Student getS = studentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "ID", id));
		l.info("Getting student details with ID "+id+" at "+new Date());
		return converter.convertToStudentDTO(getS);
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> students=studentRepository.findAll();
		
		List<StudentDTO> sDTO = new ArrayList<>();
		for(Student s: students)
		{
			sDTO.add(converter.convertToStudentDTO(s));
		}
		l.info("Getting all students details at "+ new Date());
		return sDTO;
	}

	@Override
	public String deleteStudentById(int id) {
		String message = null;
		Optional<Student> student= studentRepository.findById(id);
		if(student.isPresent())
		{
			studentRepository.deleteById(id);
			message = "Student details deleted successfully";
		}
		else
		{
			throw new ResourceNotFoundException("Student", "ID", id);
		}
		l.info("Student details deleted with id "+id+" at "+ new Date());
		return message;
	}

	@Override
	public void deleteAllStudents() {
		l.info("All student details deleted at "+new Date());
		studentRepository.deleteAll();
		
	}

	@Override
	public List<StudentDTO> getStudentByName(String studentName) {
		List<Student> students = studentRepository.getStudentByName(studentName);
		List<StudentDTO> studentDTO = new ArrayList<>();
		for(Student s: students)
		{
			studentDTO.add(converter.convertToStudentDTO(s));
		}
		l.info("Getting student details using name "+studentName+" at "+new Date());
		return studentDTO;
	}

	@Override
	public List<StudentDTO> getStudentByEmail(String email) {
		List<Student> stu = studentRepository.getStudentByEmail(email);
		List<StudentDTO> studentDTO = new ArrayList<>();
		for(Student s: stu)
		{
			studentDTO.add(converter.convertToStudentDTO(s));
		}
		l.info("Getting student details using email "+email+" at "+new Date());
		return studentDTO;
	}

	@Override
	public StudentDTO assignAddressToStudent(int id, int addressId) {
		Student student = studentRepository.findById(id).get();
		Address address = addressRepository.findById(addressId).get();
		l.info("Assigning address with id "+addressId+" to student with id "+id+" at "+new Date());
		student.setAddress(address);
		studentRepository.save(student);
		return converter.convertToStudentDTO(student);
	}

	
	@Override
	public List<StudentDTO> getAllStudentWithSort(String field) {
		List<Student> students = studentRepository.findAll(Sort.by(field));
		List<StudentDTO> sDTO = new ArrayList<>();
		for(Student s: students)
		{
			sDTO.add(converter.convertToStudentDTO(s));
		}
		return sDTO;
	}

	@Override
	public Page<Student> findStudentsWithPagination(int offset, int pageSize) {
		Page<Student> students =studentRepository.findAll(PageRequest.of(offset, pageSize));
		return students;
	}
 
	


	
}

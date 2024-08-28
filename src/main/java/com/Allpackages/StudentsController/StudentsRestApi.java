package com.Allpackages.StudentsController;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Allpackages.StudentsRepo.StudentsRepository;
import com.Allpackages.entity.Students;

@RestController
public class StudentsRestApi {

	@Autowired
	StudentsRepository srp;

	// post data

	@PostMapping("/insert")
	public Students insertData(@RequestBody Students std) {

		Students status = srp.save(std);

		return status;

	}

//	@PostMapping("/insertAllRecords")
//	public List insertAllRecords(@RequestBody List<Students> std) {
//		
//		
//		 return  srp.saveAll(std);
//
//	}
	
	//-----------------------------------------------------------------------------------

	// Get Data

	@GetMapping("/students")

	public List<Students> getAllData() {
		List<Students> allstudents = srp.findAll();

		return allstudents;
	}

	// get single specified record.

	@GetMapping("/students/{id}")

	public Students getById(@PathVariable("id") Integer studentId) {

		Students std = srp.findById(studentId).get();

		return std;

	}
	
	//----------------------------------------------------------------------------------
	
	//Delete Data
	
	@DeleteMapping("/students/{id}")
	public void deleteById(@PathVariable Integer id) {
		srp.deleteById(id);
	}
	
	//------------------------------------------------------------------------------------
	
	//Update data
	
	@PutMapping("/students/{id}")
	//i am sending data from postman in JSON format and i will collect it as an  students object by using @RequestBody .
	//if and if i want to update my data that  is notNull and notEmpty.
	public Students updateData(@PathVariable Integer id,@RequestBody Students std) {
		
		Students sid= srp.findById(id).get();
			
		if(Objects.nonNull(std.getStudent_name()) &&
				!"".equalsIgnoreCase(std.getStudent_name())) {
			
			sid.setStudent_name(std.getStudent_name());
		}
		
		if(Objects.nonNull(std.getStudent_marks()) &&
				!"".equalsIgnoreCase((std.getStudent_marks()).toString())) {
			
			sid.setStudent_marks(std.getStudent_marks());
		}
		
		
		return srp.save(sid);
		
	}
	
	
//	@GetMapping("/students/name/{name}")
//	public Students FetchByStudentName(@PathVariable String student_name) {
//		return srp.findByStudent_name(student_name);
//		
//	}
}

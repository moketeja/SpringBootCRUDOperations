package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;

@RestController
public class StudentController {
	StudentService studentService;
	
	public StudentController(StudentService studentService)
	{
		this.studentService=studentService;
	}
	
	@PostMapping("/create")
	public String create(@RequestBody Student st) 
	{
		studentService.createStudent(st);
		return "Student is saved.";
	}
	
	@GetMapping("/get/{roll}")
	public Student get(@PathVariable int roll) 
	{
		return studentService.getStudent(roll);
	}
	
	@GetMapping("/getall")
	public List<Student> getAll()
	{
		return studentService.getAllStudent();
	}
	
//	 @PutMapping("/ping/{roll}")
//	    public String ping(@PathVariable int roll) {
//	        return "Ping success " + roll;
//	    }
	
	@PutMapping("/update/{roll}")
	public String update(@PathVariable int roll, @RequestBody Student st) {
	    st.setRoll(roll);
	    studentService.updateStudent(st);
	    return "Student is Updated";
	}

	
	@DeleteMapping("/delete/{roll}")
	public String delete(@PathVariable int roll)
	{
		studentService.deleteStudent(roll);
		return "Student is Deleted"; 
	}
}

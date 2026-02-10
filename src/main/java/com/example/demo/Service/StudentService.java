package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;


@Service
public class StudentService {
	
	StudentRepository studentRepo;
	
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo=studentRepo;
	}
	
	public void createStudent(Student st) {
		studentRepo.save(st);
	}
	
	public Student getStudent(int roll) {
		Student st = studentRepo.findById(roll).orElse(null);
		return st;
	}
	
	public List<Student> getAllStudent() {
		List<Student> studentList = studentRepo.findAll();
		return studentList;
	}
	
	public void updateStudent(Student st) {
		studentRepo.save(st);
	}
	
	public void deleteStudent(int roll) {
		studentRepo.deleteById(roll);
	}
}


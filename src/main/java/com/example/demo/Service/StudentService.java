package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void createStudent(Student st) {
        studentRepo.save(st);
    }

    public Student getStudent(int roll) {
        return studentRepo.findById(roll).orElse(null);
    }

    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    public void updateStudent(Student st) {
        studentRepo.save(st);
    }

    public void deleteStudent(int roll) {
        studentRepo.deleteById(roll);
    }

    public Student getStudentbyEmail(String email) {
        return studentRepo.findByEmail(email);
    }
}

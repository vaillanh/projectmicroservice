package com.student.studentProject.service;

import com.student.studentProject.entity.Student;
import com.student.studentProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {return studentRepository.findAll();}
    public Student getStudentById(String id) {return studentRepository.findById(id).orElse(null);}
    public Student addStudent(Student student) {return studentRepository.save(student);}
    public Student updateStudent(Student student) {return studentRepository.save(student);}
    public void deleteStudent(String id) {studentRepository.deleteById(id);}
}

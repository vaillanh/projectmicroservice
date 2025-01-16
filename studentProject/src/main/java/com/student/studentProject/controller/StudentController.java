package com.student.studentProject.controller;

import com.student.studentProject.entity.Student;
import com.student.studentProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @GetMapping
    public List<Student> getAllStudents() { return studentService.getAllStudents(); }

    @GetMapping("/id/{id}")
    public ResponseEntity<Map<String, Object>> getStudentById(@PathVariable String id) {
        Student tempo = studentService.getStudentById(id);
        String result = restTemplateBuilder.build().getForEntity("http://localhost:8081/student/" + tempo.getSchoolID(), String.class).getBody();

        Map<String, Object> response = new HashMap<>();
        response.put("student", tempo);
        response.put("school", result);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {return studentService.addStudent(student); }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable String id) {studentService.deleteStudent(id); }

    @PutMapping("/{id}")
    public Optional<Student> updateStudent(@RequestBody Student student) {
        return Optional.ofNullable(studentService.updateStudent(student));
    }
}

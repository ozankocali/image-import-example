package com.ozeeesoftware.imageimportexample.controller;

import com.ozeeesoftware.imageimportexample.model.Student;
import com.ozeeesoftware.imageimportexample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String,Boolean>> deleteStudent(@RequestBody Student student){
        return studentService.deleteStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }
}

package com.ozeeesoftware.imageimportexample.service;

import com.ozeeesoftware.imageimportexample.exception.NotFoundByIdException;
import com.ozeeesoftware.imageimportexample.model.Student;
import com.ozeeesoftware.imageimportexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public ResponseEntity<Student> createStudent(Student student) {
        studentRepository.save(student);
        return ResponseEntity.ok(student);
    }

    public ResponseEntity<Student> getStudentById(Long id) {
        Student student =studentRepository.findById(id).orElseThrow(()->new NotFoundByIdException("Student not exist with id:"+id));
        return ResponseEntity.ok(student);
    }

    public ResponseEntity<Map<String,Boolean>> deleteStudent(Student student){
        Student existingStudent =studentRepository.findById(student.getId()).orElseThrow(()->new NotFoundByIdException("Student not exist with id:"+student.getId()));
        studentRepository.delete(existingStudent);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Map<String,Boolean>> deleteStudentById(Long id){
        Student student =studentRepository.findById(id).orElseThrow(()->new NotFoundByIdException("Student not exist with id:"+id));
        studentRepository.delete(student);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

package com.example.studentmanager.controller;

import com.example.studentmanager.exception.ResourceNotFoundException;
import com.example.studentmanager.model.Student;
import com.example.studentmanager.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @GetMapping()
    public List<Student> getAllEmployees() {
        return studentService.getAllStudent();
    }
    @PostMapping("")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) throws ResourceNotFoundException {
        return studentService.getStudentByID(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> getUpdateStudent(@PathVariable(value = "id") long id,@RequestBody  Student student) throws ResourceNotFoundException{
        return studentService.getUpdateStudent(id,student);
    }
    @DeleteMapping("/{id}")
    public  void deleteStudent(@PathVariable Long id) throws  ResourceNotFoundException {
        studentService.deleteStudent(id);
        System.out.println("delete sussces");
    }
    @DeleteMapping("/delete-all")
    public void deleteAll() throws  ResourceNotFoundException{
        studentService.deleteAll();
    }
}

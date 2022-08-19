package com.example.studentmanager.service;

import com.example.studentmanager.exception.ResourceNotFoundException;
import com.example.studentmanager.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student createStudent(Student student);

    ResponseEntity<Student> getStudentByID(long id) throws ResourceNotFoundException;
    ResponseEntity<?> getUpdateStudent(long id,Student student) throws  ResourceNotFoundException;
    public void deleteStudent(long id) throws ResourceNotFoundException;
    public void deleteAll() throws  ResourceNotFoundException;
}

package com.example.studentmanager.service;

import com.example.studentmanager.exception.ResourceNotFoundException;
import com.example.studentmanager.model.Student;
import com.example.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public ResponseEntity<Student> getStudentByID(long id) throws ResourceNotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        return ResponseEntity.ok().body(student);
    }

    @Override
    public ResponseEntity<?> getUpdateStudent(long id, Student studentLast) throws ResourceNotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        student.setName(studentLast.getName());
        student.setSex(studentLast.getSex());
        student.setMark(studentLast.getMark());
        return ResponseEntity.ok().body(studentRepository.save(student));
    }

    @Override
    public void deleteStudent(long id) throws ResourceNotFoundException{
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        studentRepository.delete(student);
    }

    @Override
    public void deleteAll() throws ResourceNotFoundException {
        studentRepository.deleteAll();
    }
}

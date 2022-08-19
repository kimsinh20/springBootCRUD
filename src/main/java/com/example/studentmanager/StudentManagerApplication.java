package com.example.studentmanager;

import com.example.studentmanager.model.Student;
import com.example.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagerApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(StudentManagerApplication.class, args);
    }

}

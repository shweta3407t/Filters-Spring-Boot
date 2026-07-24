package com.example.filterDemo.service;

import com.example.filterDemo.dto.Student;
import com.example.filterDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository s){
        this.studentRepository=s;
    }

    public void createStudent(Student student){
        System.out.println("Student created");
        System.out.println(student.getName());
        System.out.println(student.getEmail());
    }
}

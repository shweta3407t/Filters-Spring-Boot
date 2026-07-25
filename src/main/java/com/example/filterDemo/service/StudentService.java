package com.example.filterDemo.service;

import com.example.filterDemo.dto.Student;
import com.example.filterDemo.dto.StudentResponseDTO;
import com.example.filterDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository s){
        this.studentRepository=s;
    }

    public StudentResponseDTO createStudent(Student student){

        StudentResponseDTO responseDTO=new StudentResponseDTO();
         responseDTO.setName(student.getName());
         responseDTO.setMessage("Student is saved successfully");

         return responseDTO;
    }
}

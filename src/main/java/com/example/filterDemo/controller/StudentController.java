package com.example.filterDemo.controller;

import com.example.filterDemo.dto.Student;
import com.example.filterDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    public  StudentController(StudentService s){
        this.studentService=s;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.createStudent(student);

        return  ResponseEntity.ok("DONE");
    }

}

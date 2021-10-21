package com.studentapp.controller;


import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.model.NameComparator;
import com.studentapp.model.Student;
import com.studentapp.repository.StudentRepository;
import com.studentapp.service.SequenceGeneratorService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    
    @GetMapping("/viewallstudents")
    public List < Student > viewAllStudents() {
    	List<Student> list = studentRepository.findAll();
    	Collections.sort(list, new NameComparator());
        return list;
    }
  

    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {
    	Student s = new Student();
    	if(student.getName()!=null) {
    	student.setId(sequenceGeneratorService.generateSequence(Student.SEQUENCE_NAME));
        s = studentRepository.save(student);
    	}
    	return s;
    }


}

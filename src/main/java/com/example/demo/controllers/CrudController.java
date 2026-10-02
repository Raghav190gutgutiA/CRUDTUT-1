package com.example.demo.controllers;

import com.example.demo.Service.StudentSer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTP.StudentDto;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/crud")
public class CrudController {
    public StudentSer stsV;
    public CrudController(StudentSer sts)
     {
       this.stsV = sts;
     }
    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        return ResponseEntity.ok("Gandhiji");
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody StudentDto studentDto) {

//        studentDto.setId(idCounter.incrementAndGet());

        return ResponseEntity.ok(stsV.createUser(studentDto));
    }

    @GetMapping("/get")
    public ResponseEntity<StudentDto> getStudent(@RequestParam("id") Integer id) {
        StudentDto student = stsV.getUser(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
}

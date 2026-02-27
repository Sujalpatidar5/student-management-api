package com.cfs.student_api.controller;

import com.cfs.student_api.dto.StudentRequestDTO;
import com.cfs.student_api.dto.StudentResponseDTO;
import com.cfs.student_api.entity.Student;
import com.cfs.student_api.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // REST api bnane k liye
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController (StudentService studentService){
        this.studentService = studentService;
    }

    //1- Add student
    @PostMapping
    public ResponseEntity<StudentResponseDTO> addStudent (@Valid @RequestBody StudentRequestDTO request) {
        StudentResponseDTO response = studentService.addStudent(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //2- Get all students
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents () {
        List<StudentResponseDTO> students = studentService.getAllStudents();

        return ResponseEntity.ok(students);
    }

    //3- get student by id
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById (@PathVariable Long id) {
        StudentResponseDTO student = studentService.getStudentById(id);

        return ResponseEntity.ok(student);
    }

    //4- update student
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent (@PathVariable Long id, @Valid @RequestBody StudentRequestDTO request) {
        StudentResponseDTO updateStudent = studentService.updateStudent(id,request);

        return ResponseEntity.ok(updateStudent);
    }

    //5- delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();

    }

}

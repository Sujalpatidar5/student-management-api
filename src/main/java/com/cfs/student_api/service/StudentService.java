package com.cfs.student_api.service;

import com.cfs.student_api.dto.StudentRequestDTO;
import com.cfs.student_api.dto.StudentResponseDTO;
import com.cfs.student_api.entity.Student;
import com.cfs.student_api.exception.StudentNotFoundException;
import com.cfs.student_api.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Method - 1
    //1. RequestDTO recieve krega
    //2. Entity bnayga
    //3. Repo me save krega
    //4. ResponseDTO return krega
    public StudentResponseDTO addStudent (StudentRequestDTO request) {

         //DTO -> Entity
        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setAge((request.getAge()));

        //save in DB
        Student savedStudent = studentRepository.save(student);

        //Entity -> ResponseDTO
        StudentResponseDTO response = new StudentResponseDTO();
        response.setId(savedStudent.getId());
        response.setName(savedStudent.getName());
        response.setEmail(savedStudent.getEmail());
        response.setAge(student.getAge());

        return response;
    }

    //Method - 2
    public List<StudentResponseDTO> getAllStudents() {

        //DB se sab students lo
        List<Student> students = studentRepository.findAll();

        //Entity list ko DTO list me convert kro
        List<StudentResponseDTO> responseList = new ArrayList<>();

        for (Student student : students) {
            StudentResponseDTO dto = new StudentResponseDTO();

            dto.setId(student.getId());
            dto.setName(student.getName());
            dto.setEmail(student.getEmail());
            dto.setAge(student.getAge());
            responseList.add(dto);
        }

        return responseList;
    }

    //Method - 3
    public StudentResponseDTO getStudentById (Long id) {

        //student find kro
        Student student = studentRepository.findById(id).orElseThrow(() -> new
                StudentNotFoundException("Student not found with id : " + id));

        //Entity -> DTO
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());

        return dto;
    }

    //Method - 4
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO request) {

        //find existing student
        Student student = studentRepository.findById(id).orElseThrow(() -> new
                StudentNotFoundException("Student not found with id : " + id));

        //update fields
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());

        //save updated student
        Student updatedStudent = studentRepository.save(student);

        //entity -> DTO
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(updatedStudent.getId());
        dto.setName(updatedStudent.getName());
        dto.setEmail(updatedStudent.getEmail());
        dto.setAge(updatedStudent.getAge());

        return dto;
    }

    //Method - 5
    public void deleteStudent (Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new
                StudentNotFoundException("Student not found with id : " + id));

        //delete student
        studentRepository.delete(student);
    }
}

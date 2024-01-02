package com.nerv.series.springbootcrud.interfaces.rest.controller;

import com.nerv.series.springbootcrud.domain.model.Student;
import com.nerv.series.springbootcrud.domain.service.StudentService;
import com.nerv.series.springbootcrud.interfaces.rest.resource.CreateStudentResource;
import com.nerv.series.springbootcrud.interfaces.rest.resource.StudentResource;
import com.nerv.series.springbootcrud.interfaces.rest.resource.UpdateStudentResource;
import com.nerv.series.springbootcrud.interfaces.rest.resource.transform.StudentResourceAssembler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

    private final StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource student) {
        Student createdStudent = studentService.create(StudentResourceAssembler.toModel(student));
        StudentResource studentResource = StudentResourceAssembler.toResource(createdStudent);

        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentResource>> getAllStudents() {
        List<Student> students = studentService.getAll();
        List<StudentResource> studentResources = StudentResourceAssembler.toResourceList(students);

        return new ResponseEntity<>(studentResources, HttpStatus.OK);
    }

    @GetMapping("{studentId}")
    public ResponseEntity<StudentResource> getStudentById(@PathVariable Long studentId) {
        Student student = studentService.getById(studentId);
        StudentResource studentResource = StudentResourceAssembler.toResource(student);

        return new ResponseEntity<>(studentResource, HttpStatus.OK);
    }

    @PutMapping("{studentId}")
    public ResponseEntity<StudentResource> updateStudentById(@PathVariable Long studentId, @RequestBody UpdateStudentResource student) {
        Student updatedStudent = studentService.update(studentId, StudentResourceAssembler.toModel(student));
        StudentResource studentResource = StudentResourceAssembler.toResource(updatedStudent);

        return new ResponseEntity<>(studentResource, HttpStatus.OK);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long studentId) {
        studentService.delete(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

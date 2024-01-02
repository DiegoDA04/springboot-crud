package com.nerv.series.springbootcrud.domain.service;

import com.nerv.series.springbootcrud.domain.model.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);
    List<Student> getAll();
    Student getById(Long studentId);
    Student update(Long studentId, Student student);
    void delete(Long studentId);
}

package com.nerv.series.springbootcrud.application.internal.service;

import com.nerv.series.springbootcrud.domain.exception.StudentException;
import com.nerv.series.springbootcrud.domain.model.Student;
import com.nerv.series.springbootcrud.domain.service.StudentService;
import com.nerv.series.springbootcrud.infrastructure.persistence.jpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentException(studentId));
    }

    @Override
    public Student update(Long studentId, Student student) {

        return studentRepository.findById(studentId)
                .map(studentToUpdate -> {

                    studentToUpdate.setFirstName(student.getFirstName());
                    studentToUpdate.setLastName(student.getLastName());
                    studentToUpdate.setAge(student.getAge());

                    return studentRepository.save(studentToUpdate);
                })
                .orElseThrow(() -> new StudentException(studentId));
    }

    @Override
    public void delete(Long studentId) {

        if (!studentRepository.existsById(studentId))
            throw new StudentException(studentId);

        studentRepository.deleteById(studentId);
    }
}

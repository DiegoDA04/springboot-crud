package com.nerv.series.springbootcrud.infrastructure.persistence.jpa.repository;

import com.nerv.series.springbootcrud.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}

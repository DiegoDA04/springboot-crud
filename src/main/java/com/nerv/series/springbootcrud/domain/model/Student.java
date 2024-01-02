package com.nerv.series.springbootcrud.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @NotBlank
    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Min(value = 8)
    @Column(name = "age", nullable = false)
    private int age;
}

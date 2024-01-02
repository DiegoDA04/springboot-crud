package com.nerv.series.springbootcrud.interfaces.rest.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentResource {
    private String firstName;
    private String lastName;
    private int age;
}

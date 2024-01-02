package com.nerv.series.springbootcrud.interfaces.rest.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResource {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
}

package com.nerv.series.springbootcrud.interfaces.rest.resource.transform;

import com.nerv.series.springbootcrud.domain.model.Student;
import com.nerv.series.springbootcrud.interfaces.rest.resource.CreateStudentResource;
import com.nerv.series.springbootcrud.interfaces.rest.resource.StudentResource;
import com.nerv.series.springbootcrud.interfaces.rest.resource.UpdateStudentResource;

import java.util.List;
import java.util.stream.Collectors;

public class StudentResourceAssembler {

    public static StudentResource toResource(Student student) {
        return new StudentResource(
            student.getId(),
            student.getFirstName(),
            student.getLastName(),
            student.getAge()
        );
    }

    public static Student toModel(CreateStudentResource studentResource) {
        return new Student().withFirstName(studentResource.getFirstName())
                            .withLastName(studentResource.getLastName())
                            .withAge(studentResource.getAge());
    }
    public static Student toModel(UpdateStudentResource studentResource) {
        return new Student().withFirstName(studentResource.getFirstName())
                .withLastName(studentResource.getLastName())
                .withAge(studentResource.getAge());
    }

    public static List<StudentResource> toResourceList(List<Student> students) {
        return students.stream().map(StudentResourceAssembler::toResource).collect(Collectors.toList());
    }
}

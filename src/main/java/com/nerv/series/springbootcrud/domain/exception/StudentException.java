package com.nerv.series.springbootcrud.domain.exception;

public class StudentException extends RuntimeException {

    public StudentException(String message) {
        super(message);
    }

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentException(Throwable cause) {
        super(cause);
    }

    public StudentException(Long studentId) {
        super("Student with id " + studentId + " not found.");
    }
}

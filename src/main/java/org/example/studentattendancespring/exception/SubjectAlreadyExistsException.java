package org.example.studentattendancespring.exception;

public class SubjectAlreadyExistsException extends RuntimeException{
    public SubjectAlreadyExistsException(String message) {
        super(message);
    }
}

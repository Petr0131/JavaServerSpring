package org.example.studentattendancespring.exception;

public class LessonAlreadyExistsException extends RuntimeException{
    public LessonAlreadyExistsException(String message) {
        super(message);
    }
}

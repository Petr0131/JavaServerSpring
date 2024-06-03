package org.example.studentattendancespring.exception;

public class GroupNameAlreadyExistsException extends RuntimeException {
    public GroupNameAlreadyExistsException(String message) {
        super(message);
    }
}

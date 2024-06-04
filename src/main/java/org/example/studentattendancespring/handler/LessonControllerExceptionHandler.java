package org.example.studentattendancespring.handler;

import org.example.studentattendancespring.exception.LessonAlreadyExistsException;
import org.example.studentattendancespring.exception.LessonForPeriodNotFound;
import org.example.studentattendancespring.exception.LessonNotFoundException;
import org.example.studentattendancespring.model.dto.Lesson;
import org.example.studentattendancespring.model.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class LessonControllerExceptionHandler extends ControllerExceptionHandler {
    @ExceptionHandler(LessonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CommonResponse<Lesson>> handleLessonNotFound(RuntimeException ex) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new CommonResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ExceptionHandler(LessonAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<CommonResponse<Lesson>> handleLessonDateAndNumberExistsException(RuntimeException ex) {
        return  ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new CommonResponse<>(HttpStatus.CONFLICT.value(), ex.getMessage()));
    }
}

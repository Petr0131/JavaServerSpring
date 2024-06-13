package org.example.studentattendancespring.validator;

import org.example.studentattendancespring.entity.LessonEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.sql.Timestamp;

@Component
public class LessonEntityValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return LessonEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LessonEntity lesson = (LessonEntity) target;

        ValidationUtils.rejectIfEmpty(errors,
                "teacher",
                "NotEmpty.lessonEntity.teacher",
                "Teacher name cannot be empty");
        ValidationUtils.rejectIfEmpty(errors,
                "group",
                "NotEmpty.lessonEntity.group",
                "Group name cannot be empty");

        if (lesson.getSubject() == null) {
            errors.rejectValue(
                    "subject",
                    "NotNull.lessonEntity.subject",
                    "Subject name cannot be empty");
        }

        if (lesson.getGroup() == null) {
            errors.rejectValue(
                    "group",
                    "NotNull.lessonEntity.group",
                    "Group name cannot be empty");
        }

        if (lesson.getDate() != null && lesson.getDate().before(new Date(System.currentTimeMillis()))) {
            errors.rejectValue(
                    "date",
                    "FutureOrPresent.lessonEntity.date",
                    "Дата должна быть в будущем или в настоящем времени");
        }

        if (lesson.getLessonNumber() <= 0) {
            errors.rejectValue(
                    "lessonNumber",
                    "Positive.lessonEntity.lessonNumber",
                    "Номер урока должен быть положительным числом");
        }
    }
}

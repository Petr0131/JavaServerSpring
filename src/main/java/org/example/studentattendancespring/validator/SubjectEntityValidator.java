package org.example.studentattendancespring.validator;

import org.example.studentattendancespring.entity.SubjectEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SubjectEntityValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SubjectEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "subjectName",
                "NotEmpty.subjectEntity.subjectName",
                "Subject name cannot be empty");
    }
}

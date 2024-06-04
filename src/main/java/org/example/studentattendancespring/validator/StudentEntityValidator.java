package org.example.studentattendancespring.validator;


import org.example.studentattendancespring.entity.StudentEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StudentEntityValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return StudentEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentEntity student = (StudentEntity) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "lastName",
                "NotEmpty.studentEntity.lastName",
                "Last name cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "firstName",
                "NotEmpty.studentEntity.firstName",
                "First name cannot be empty");
        ValidationUtils.rejectIfEmpty(errors,
                "group",
                "NotEmpty.lessonEntity.group",
                "Group name cannot be empty");

        if (student.getMiddleName() == null) {
            errors.rejectValue(
                    "middleName",
                    "NotNull.studentEntity.middleName",
                    "Middle name cannot be empty");
        }


        if (student.getGroup() == null) {
            errors.rejectValue(
                    "group",
                    "NotNull.lessonEntity.group",
                    "Group name cannot be empty");
        }

    }
}

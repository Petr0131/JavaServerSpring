package org.example.studentattendancespring.model.dto;

import org.example.studentattendancespring.entity.TeacherEntity;

public class Teacher {
    private  Long id;
    private String lastName;
    private String firstName;
    private String middleName;

    public static Teacher toModel(TeacherEntity teacher) {
        Teacher model = new Teacher();
        model.setId(teacher.getId());
        model.setLastName(teacher.getLastName());
        model.setFirstName(teacher.getFirstName());
        model.setMiddleName(teacher.getMiddleName());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}

package org.example.studentattendancespring.model.dto;

import org.example.studentattendancespring.entity.StudentEntity;

public class Student {
    private  Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String status;
    private Long idGroup;

    public static Student toModel(StudentEntity student){
        Student model = new Student();
        model.setId(student.getId());
        model.setLastName(student.getLastName());
        model.setFirstName(student.getFirstName());
        model.setMiddleName(student.getMiddleName());
        model.setStatus(student.getStatus());
        model.setIdGroup(student.getGroup().getId());
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }
}

package org.example.studentattendancespring.model.dto;

import org.example.studentattendancespring.entity.SubjectEntity;

public class Subject {
    private  Long id;
    private String subjectName;

    public static Subject toModel(SubjectEntity subject){
        Subject model = new Subject();
        model.setId(subject.getId());
        model.setSubjectName(subject.getSubjectName());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}

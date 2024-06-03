package org.example.studentattendancespring.model.dto;

import org.example.studentattendancespring.entity.LessonEntity;

import java.sql.Timestamp;

public class Lesson {
    private  Long id;
    private Timestamp date;
    private int lessonNumber;
    public static Lesson toModel(LessonEntity lesson){
        Lesson model = new Lesson();
        model.setId(lesson.getId());
        model.setDate(lesson.getDate());
        model.setLessonNumber(lesson.getLessonNumber());
        return model;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }
}

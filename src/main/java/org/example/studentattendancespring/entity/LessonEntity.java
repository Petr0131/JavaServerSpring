package org.example.studentattendancespring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "lesson")
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @FutureOrPresent(message = "Date must be in the future or present")
    private Date date;

    @Positive
    @Column(name = "lesson_number")
    private int lessonNumber;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @NotNull(message = "Teacher name cannot be empty")
    private TeacherEntity teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @NotNull(message = "Subject name cannot be empty")
    private SubjectEntity subject;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @NotNull(message = "Group name cannot be empty")
    private GroupEntity group;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }
}

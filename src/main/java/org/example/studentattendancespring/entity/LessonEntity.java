package org.example.studentattendancespring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "lesson")
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @FutureOrPresent(message = "Дата должна быть в будущем или в настоящем времени")
    private Timestamp date;

    @Positive
    @Column(name = "lesson_number")
    private int lessonNumber;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @NotNull(message = "Необходимо указать преподавателя")
    private TeacherEntity teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @NotNull(message = "Необходимо указать предмет")
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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

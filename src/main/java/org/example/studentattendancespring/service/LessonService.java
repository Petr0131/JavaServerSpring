package org.example.studentattendancespring.service;

import org.example.studentattendancespring.entity.LessonEntity;
import org.example.studentattendancespring.exception.*;
import org.example.studentattendancespring.model.dto.Lesson;
import org.example.studentattendancespring.repository.GroupRepo;
import org.example.studentattendancespring.repository.LessonRepo;
import org.example.studentattendancespring.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    @Autowired
    private LessonRepo lessonRepo;
    @Autowired
    private  GroupRepo groupRepo;
    @Autowired
    private  TeacherRepo teacherRepo;

    public Lesson addLesson(LessonEntity lesson) {
        if(lessonRepo.findByDateAndLessonNumber(lesson.getDate(), lesson.getLessonNumber()) != null) {
            throw new LessonAlreadyExistsException("Lesson with this date and number already exists!");
        }
        lessonRepo.save(lesson);
        return Lesson.toModel(lesson);
    }

    public Lesson editLesson(LessonEntity lesson) {
        LessonEntity lessonEntity = lessonRepo.findById(lesson.getId())
                .orElseThrow(() -> new LessonNotFoundException("Lesson not found!"));
        lessonEntity.setDate(lesson.getDate());
        lessonEntity.setLessonNumber(lesson.getLessonNumber());
        lessonRepo.save(lessonEntity);
        return Lesson.toModel(lesson);
    }

    public Lesson getLesson(Long id) {
        LessonEntity lesson = lessonRepo.findById(id)
                .orElseThrow(() -> new LessonNotFoundException("Lesson not found!"));
        return Lesson.toModel(lesson);
    }
    public Long deleteLesson(Long id) {
        lessonRepo.deleteById(id);
        return id;
    }
}

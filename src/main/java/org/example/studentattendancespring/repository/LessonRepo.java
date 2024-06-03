package org.example.studentattendancespring.repository;

import org.example.studentattendancespring.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface LessonRepo extends JpaRepository<LessonEntity,Long> {
    LessonEntity findByDateAndLessonNumber(Timestamp date, int lessonNumber);
    List<LessonEntity> findByDateBetween(Timestamp startDate, Timestamp endDate);
}

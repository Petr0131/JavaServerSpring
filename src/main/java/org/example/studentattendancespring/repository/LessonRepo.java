package org.example.studentattendancespring.repository;

import org.example.studentattendancespring.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface LessonRepo extends JpaRepository<LessonEntity,Long> {
    LessonEntity findByDateAndLessonNumber(Date date, int lessonNumber);
    List<LessonEntity> findByDateBetween(Date startDate, Date endDate);
}

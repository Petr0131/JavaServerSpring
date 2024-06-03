package org.example.studentattendancespring.service;

import org.example.studentattendancespring.entity.TeacherEntity;
import org.example.studentattendancespring.exception.TeacherNotFoundException;
import org.example.studentattendancespring.model.dto.Teacher;
import org.example.studentattendancespring.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    public Teacher addTeacher(TeacherEntity teacher) {
        teacherRepo.save(teacher);
        return Teacher.toModel(teacher);
    }

    public Teacher editTeacher(TeacherEntity teacher) {
        TeacherEntity teacherEntity = teacherRepo.findById(teacher.getId())
                .orElseThrow(()-> new TeacherNotFoundException("Teacher not found!"));
        teacherEntity.setFirstName(teacher.getFirstName());
        teacherEntity.setMiddleName(teacher.getMiddleName());
        teacherEntity.setLastName(teacher.getLastName());
        teacherRepo.save(teacherEntity);
        return Teacher.toModel(teacherEntity);
    }

    public Teacher getTeacher(Long id) {
        TeacherEntity teacher = teacherRepo.findById(id)
                .orElseThrow(()-> new TeacherNotFoundException("Teacher not found!"));
        return Teacher.toModel(teacher);
    }

    public List<Teacher> getAllTeachers() {
        List<TeacherEntity> teacherEntities = teacherRepo.findAll();
        return teacherEntities.stream()
                .map(Teacher::toModel)
                .collect(Collectors.toList());
    }

    public Long deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
        return id;
    }
}

package org.example.studentattendancespring.service;

import org.example.studentattendancespring.entity.SubjectEntity;
import org.example.studentattendancespring.exception.SubjectNotFoundException;
import org.example.studentattendancespring.exception.SubjectAlreadyExistsException;
import org.example.studentattendancespring.model.dto.Subject;
import org.example.studentattendancespring.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepo subjectRepo;

    public Subject addSubject(SubjectEntity subject) {
        if (subjectRepo.findByName(subject.getName())!=null){
            throw new SubjectAlreadyExistsException("Subject already exists!");
        }
        subjectRepo.save(subject);
        return Subject.toModel(subject);
    }

    public Subject editSubject(SubjectEntity subject) {
        SubjectEntity subjectEntity = subjectRepo.findById(subject.getId())
                .orElseThrow(()-> new SubjectNotFoundException("Subject not found!"));
        subjectEntity.setName(subject.getName());
        subjectRepo.save(subjectEntity);
        return Subject.toModel(subject);
    }

    public Subject getSubject(Long id) {
        SubjectEntity subject = subjectRepo.findById(id)
                .orElseThrow(()-> new SubjectNotFoundException("Subject not found!"));
        return Subject.toModel(subject);
    }

    public List<Subject> getAllSubjects() {
        List<SubjectEntity> subjectEntities = subjectRepo.findAll();
        return subjectEntities.stream()
                .map(Subject::toModel)
                .collect(Collectors.toList());
    }

    public Long deleteSubject(Long id) {
        subjectRepo.deleteById(id);
        return id;
    }

}

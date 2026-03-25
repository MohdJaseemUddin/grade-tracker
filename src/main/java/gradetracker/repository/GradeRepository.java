package com.gradetracker.repository;

import com.gradetracker.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    List<Grade> findByStudentId(Long studentId);

    List<Grade> findByStudentIdAndSubject(Long studentId, String subject);

    void deleteByStudentId(Long studentId);
}

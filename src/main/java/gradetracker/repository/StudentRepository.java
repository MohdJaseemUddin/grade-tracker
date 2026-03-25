package com.gradetracker.repository;

import com.gradetracker.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByRollNumber(String rollNumber);

    List<Student> findByDepartment(String department);

    boolean existsByRollNumber(String rollNumber);

    @Query("SELECT s FROM Student s WHERE " +
           "LOWER(s.firstName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(s.lastName)  LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(s.rollNumber) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(s.department) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Student> searchStudents(@Param("query") String query);

    List<Student> findByDepartmentOrderByFirstNameAsc(String department);
}

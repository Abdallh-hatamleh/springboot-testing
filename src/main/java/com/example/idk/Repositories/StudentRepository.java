package com.example.idk.Repositories;

import com.example.idk.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    // Custom query to get top 3 students by grade in descending order
    @Query("SELECT s FROM Student s ORDER BY s.grade DESC limit 3")
    List<Student> findTop3ByGrade();
}

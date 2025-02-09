package com.example.idk.Services;

import com.example.idk.Models.Student;
import com.example.idk.Repositories.StudentRepository;
import com.example.idk.dto.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentResponse getAllStudents(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        StudentResponse response = new StudentResponse();
        response.content = studentPage.getContent();
        response.pageSize = (studentPage.getNumber());
        response.pageNum = (studentPage.getSize());
        response.totalEntries = (studentPage.getTotalElements());
        response.totalPages = (studentPage.getTotalPages());

        return response;
    }
    public List<Student> getTop3StudentsByGrade() {
        return studentRepository.findTop3ByGrade();
    }
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    public void checkAndUpdateGrades() {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            if (student.getGrade() < 50) {
                student.setGrade(0);
                studentRepository.save(student);
            }
        }
    }
}

package com.example.idk;

import com.example.idk.Models.Student;
import com.example.idk.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private int nextId = 1;
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents()
    {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/top3")
    public ResponseEntity<List<Student>> top3()
    {
        return ResponseEntity.ok(studentService.getTop3StudentsByGrade());
    }
    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.status(201).body(savedStudent);
    }
    // GET all students

//    @GetMapping
//    public ResponseEntity<List<Student>> getAllStudents(
//            @RequestParam(required = false) Double grade,
//            @RequestParam(required = false) Integer age) {
//        List<Student> filteredStudents = students;
//
//        if (grade != null) {
//            filteredStudents = filteredStudents.stream()
//                    .filter(s -> s.getGrade() == grade)
//                    .collect(Collectors.toList());
//        }
//
//        return ResponseEntity.ok(filteredStudents);
//    }
//
//    // GET a specific student by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
//        Optional<Student> student = students.stream()
//                .filter(s -> s.getId() == id)
//                .findFirst();
//
//        if (student.isPresent()) {
//            return ResponseEntity.ok(student.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    // POST: Add a new student
//    @PostMapping
//    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
//        student.setId(nextId++);
//        students.add(student);
//        return ResponseEntity.status(HttpStatus.CREATED).body(student);
//    }
//
//    // PUT: Update a student
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable int id, @Valid @RequestBody Student student) {
//        Optional<Student> existingStudent = students.stream()
//                .filter(s -> s.getId() == id)
//                .findFirst();
//
//        if (existingStudent.isPresent()) {
//            student.setId(id);
//            students.remove(existingStudent.get());
//            students.add(student);
//            return ResponseEntity.ok(student);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    // DELETE: Remove a student by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
//        Optional<Student> student = students.stream()
//                .filter(s -> s.getId() == id)
//                .findFirst();
//
//        if (student.isPresent()) {
//            students.remove(student.get());
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
}

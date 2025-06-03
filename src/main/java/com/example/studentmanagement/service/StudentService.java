package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> getAllStudents(String keyword, Pageable pageable);
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
}

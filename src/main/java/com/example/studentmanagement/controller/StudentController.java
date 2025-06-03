package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewStudents(Model model,
                                @RequestParam(defaultValue = "") String keyword,
                                @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("students", studentService.getAllStudents(keyword, pageable));
        model.addAttribute("keyword", keyword);
        return "list";
    }

    @GetMapping("/student/add")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/student/save")
    public String saveStudent(@Valid @ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors()) return "form";
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/student/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "form";
    }

    @GetMapping("/student/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}

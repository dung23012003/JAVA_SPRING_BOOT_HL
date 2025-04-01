package com.nnd.lesson09.controller;

import com.nnd.lesson09.entity.Student;
import com.nnd.lesson09.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list";
    }

    @GetMapping("/add-new")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student()); // Thêm một đối tượng mới
        return "student-add";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        Student student = studentService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student id: " + id));
        model.addAttribute("student", student);
        return "student-edit";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student); // Lưu student vào database
        return "redirect:/students"; // Chuyển hướng về danh sách sinh viên
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        studentService.updateStudentById(id, student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
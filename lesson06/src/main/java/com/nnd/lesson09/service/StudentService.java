package com.nnd.lesson09.service;

import com.nnd.lesson09.entity.Student;
import com.nnd.lesson09.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudents() {
        try {
            List<Student> students = studentRepository.findAll();
            System.out.println("Fetched students: " + students); // Log để debug
            return students;
        } catch (Exception e) {
            System.err.println("Error fetching students: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>(); // Trả về danh sách rỗng nếu có lỗi
        }
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public void save(Student student) {
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save student: " + e.getMessage(), e);
        }
    }

    public Student updateStudentById(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                    student.setAge(updatedStudent.getAge());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student with ID " + id + " does not exist");
        }
        studentRepository.deleteById(id);
    }
}
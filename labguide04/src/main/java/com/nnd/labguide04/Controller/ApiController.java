package com.nnd.labguide04.Controller;



import com.nnd.labguide04.dto.EmployeeDTO;
import com.nnd.labguide04.dto.KhoaDTO;
import com.nnd.labguide04.dto.MonHocDTO;
import com.nnd.labguide04.Entity.Employee;
import com.nnd.labguide04.Entity.Khoa;
import com.nnd.labguide04.Entity.MonHoc;
import com.nnd.labguide04.Service.EmployeeService;
import com.nnd.labguide04.Service.KhoaService;
import com.nnd.labguide04.Service.MonHocService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final KhoaService khoaService;
    private final MonHocService monHocService;
    private final EmployeeService employeeService;

    // Khoa APIs
    @GetMapping("/khoa")
    public ResponseEntity<List<Khoa>> getAllKhoa() {
        return ResponseEntity.ok(khoaService.findAll());
    }

    @GetMapping("/khoa/{maKhoa}")
    public ResponseEntity<Khoa> getKhoaById(@PathVariable String maKhoa) {
        return ResponseEntity.ok(khoaService.findById(maKhoa));
    }

    @PostMapping("/khoa")
    public ResponseEntity<String> createKhoa(@Valid @RequestBody KhoaDTO khoaDTO) {
        try {
            khoaService.create(khoaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Khoa created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/khoa/{maKhoa}")
    public ResponseEntity<String> updateKhoa(@PathVariable String maKhoa, @Valid @RequestBody KhoaDTO khoaDTO) {
        try {
            khoaService.update(maKhoa, khoaDTO);
            return ResponseEntity.ok("Khoa updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/khoa/{maKhoa}")
    public ResponseEntity<String> deleteKhoa(@PathVariable String maKhoa) {
        try {
            khoaService.delete(maKhoa);
            return ResponseEntity.ok("Khoa deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // MonHoc APIs
    @GetMapping("/monhoc")
    public ResponseEntity<List<MonHoc>> getAllMonHoc() {
        return ResponseEntity.ok(monHocService.findAll());
    }

    @GetMapping("/monhoc/{maMH}")
    public ResponseEntity<MonHoc> getMonHocById(@PathVariable String maMH) {
        return ResponseEntity.ok(monHocService.findById(maMH));
    }

    @PostMapping("/monhoc")
    public ResponseEntity<String> createMonHoc(@Valid @RequestBody MonHocDTO monHocDTO) {
        try {
            monHocService.create(monHocDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("MonHoc created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/monhoc/{maMH}")
    public ResponseEntity<String> updateMonHoc(@PathVariable String maMH, @Valid @RequestBody MonHocDTO monHocDTO) {
        try {
            monHocService.update(maMH, monHocDTO);
            return ResponseEntity.ok("MonHoc updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/monhoc/{maMH}")
    public ResponseEntity<String> deleteMonHoc(@PathVariable String maMH) {
        try {
            monHocService.delete(maMH);
            return ResponseEntity.ok("MonHoc deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Employee APIs
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping("/employee")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        try {
            employeeService.create(employeeDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        try {
            employeeService.update(id, employeeDTO);
            return ResponseEntity.ok("Employee updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        try {
            employeeService.delete(id);
            return ResponseEntity.ok("Employee deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
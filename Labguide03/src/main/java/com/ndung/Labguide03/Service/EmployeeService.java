package com.ndung.Labguide03.Service;

import com.ndung.Labguide03.Entity.Employee;
import com.ndung.Labguide03.Entity.Khoa;
import com.ndung.Labguide03.Entity.MonHoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();

    @Autowired
    private KhoaService khoaService;  // Inject KhoaService

    @Autowired
    private MonHocService monHocService;  // Inject MonHocService

    public EmployeeService() {
        employeeList.add(new Employee(1L, "Nguyen Ngoc Dung", "Nam", 22, 1000.0));
        employeeList.add(new Employee(2L, "Tran Thi B", "Nữ", 28, 1200.0));
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public Employee updateEmployee(Long id, Employee newEmployee) {
        Employee existingEmployee = getEmployeeById(id);
        if (existingEmployee != null) {
            existingEmployee.setFullName(newEmployee.getFullName());
            existingEmployee.setGender(newEmployee.getGender());
            existingEmployee.setAge(newEmployee.getAge());
            existingEmployee.setSalary(newEmployee.getSalary());
        }
        return existingEmployee;
    }

    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(employee -> employee.getId().equals(id));
    }

    // Gọi danh sách khoa từ KhoaService
    public List<Khoa> getAllDepartments() {
        return khoaService.getAllKhoa();
    }

    // Gọi danh sách môn học từ MonHocService
    public List<MonHoc> getAllSubjects() {
        return monHocService.getAllMonHoc();
    }
}

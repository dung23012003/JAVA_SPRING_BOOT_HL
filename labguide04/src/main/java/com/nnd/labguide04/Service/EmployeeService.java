package com.nnd.labguide04.Service;

import com.nnd.labguide04.dto.EmployeeDTO;
import com.nnd.labguide04.Entity.Employee;
import com.nnd.labguide04.Mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

    public EmployeeService() {
        // Khởi tạo 5 nhân viên ban đầu
        employeeList.add(new Employee(idCounter.incrementAndGet(), "Nguyen Ngoc Dung", "Nam", 22, 5000));
        employeeList.add(new Employee(idCounter.incrementAndGet(), "Tran Thi B", "Nu", 30, 6000));
        employeeList.add(new Employee(idCounter.incrementAndGet(), "Le Van C", "Nam", 40, 7000));
        employeeList.add(new Employee(idCounter.incrementAndGet(), "Pham Thi D", "Nu", 28, 5500));
        employeeList.add(new Employee(idCounter.incrementAndGet(), "Hoang Van E", "Nam", 35, 6500));
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employeeList);
    }

    public Employee findById(Long id) {
        return employeeList.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy nhân viên với id: " + id));
    }

    public void create(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO); // Sử dụng Mapper để chuyển đổi từ DTO sang Entity
        employee.setId(idCounter.incrementAndGet());
        employeeList.add(employee);
    }

    public void update(Long id, EmployeeDTO employeeDTO) {
        Employee employee = findById(id);
        // Cập nhật thông tin nhân viên từ DTO
        employeeMapper.updateEntityFromDTO(employeeDTO, employee); // Sử dụng Mapper để cập nhật thông tin
    }

    public void delete(Long id) {
        Employee employee = findById(id);
        employeeList.remove(employee);
    }
}

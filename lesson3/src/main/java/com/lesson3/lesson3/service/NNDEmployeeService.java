package com.lesson3.lesson3.service;

import com.lesson3.lesson3.request.NNDEmployeeRequest;
import com.lesson3.lesson3.mapper.NNDEmployeeMapper;
import com.lesson3.lesson3.entity.NNDEmployee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NNDEmployeeService {

    private final NNDEmployeeMapper nndEmployeeMapper;
    private final List<NNDEmployee> nndEmployeeList;

    public NNDEmployeeService(NNDEmployeeMapper NNDEmployeeMapper) {
        this.nndEmployeeMapper = NNDEmployeeMapper;
        this.nndEmployeeList = new ArrayList<>();

        // Dữ liệu mẫu
        this.nndEmployeeList.add(new NNDEmployee(1L, "Nguyễn Ngọc", "Dũng", 12.222f, "dung@gmail.com"));
        this.nndEmployeeList.add(new NNDEmployee(2L, "Nguyễn Thị", "Dung", 20.2312f, "dungthi@gmail.com"));
    }

    public List<NNDEmployeeRequest> getNndEmployeeList() {
        return nndEmployeeList.stream()
                .map(nndEmployeeMapper::toNndEmployeeRequest)
                .collect(Collectors.toList());
    }

    public void nndEmployeeAdd(NNDEmployeeRequest nndEmployeeRequest) {
        NNDEmployee nndEmployee = nndEmployeeMapper.toNndEmployee(nndEmployeeRequest);
        nndEmployeeList.add(nndEmployee);
    }

    public void nndEmployeeUpdate(Long id, NNDEmployeeRequest request) {
        for (NNDEmployee employee : nndEmployeeList) {
            if (employee.getId().equals(id)) { // Không còn lỗi
                employee.setFirstName(request.getFirstName());
                employee.setLastName(request.getLastName());
                employee.setSalary(request.getSalary());
                employee.setEmail(request.getEmail());
                return;
            }
        }
        throw new RuntimeException("Employee with ID " + id + " not found");
    }

    public void nndEmployeeDelete(Long id) {
        boolean removed = nndEmployeeList.removeIf(employee -> employee.getId().equals(id));
        if (!removed) {
            throw new RuntimeException("Employee with ID " + id + " not found");
        }
    }
}

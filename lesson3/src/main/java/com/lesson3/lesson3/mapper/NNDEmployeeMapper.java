package com.lesson3.lesson3.mapper;

import com.lesson3.lesson3.request.NNDEmployeeRequest;
import com.lesson3.lesson3.entity.NNDEmployee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NNDEmployeeMapper {

    @Mapping(target = "salary", source = "salary", defaultValue = "0")
    NNDEmployee toNndEmployee(NNDEmployeeRequest employeeRequest);

//
//    public Employee toEmployee(EmployeeRequest employeeRequest) {
//        Employee employee = new Employee();
//        employee.setId(employeeRequest.getId());
//        employee.setFirstName(employeeRequest.getFirstName());
//        employee.setLastName(employeeRequest.getLastName());
//        employee.setEmail(employeeRequest.getEmail());
//        employee.setSalary(0);
//        return employee;
//    }


    NNDEmployeeRequest toNndEmployeeRequest(NNDEmployee employee);
//    public EmployeeRequest toEmployeeRequest(Employee employee) {
//        EmployeeRequest employeeRequest = new EmployeeRequest();
//        employeeRequest.setId(employee.getId());
//        employeeRequest.setFirstName(employee.getFirstName());
//        employeeRequest.setLastName(employee.getLastName());
//        employeeRequest.setEmail(employee.getEmail());
//        return employeeRequest;
//    }
}

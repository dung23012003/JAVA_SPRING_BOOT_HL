package com.nnd.labguide04.Mapper;

import com.nnd.labguide04.dto.EmployeeDTO;
import com.nnd.labguide04.Entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    // Chuyển từ EmployeeDTO sang Employee
    Employee toEntity(EmployeeDTO employeeDTO);

    // Chuyển từ Employee sang EmployeeDTO
    EmployeeDTO toDto(Employee employee);

    // Phương thức cập nhật Entity từ DTO
    void updateEntityFromDTO(EmployeeDTO employeeDTO, Employee employee);
}

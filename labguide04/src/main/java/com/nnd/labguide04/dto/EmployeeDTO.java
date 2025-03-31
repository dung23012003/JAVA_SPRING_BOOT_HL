package com.nnd.labguide04.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDTO {
    Long id;

    @NotBlank(message = "Họ tên không được để trống")
    @Size(min = 3, max = 25, message = "Họ tên phải từ 3-25 ký tự")
    String fullName;

    @NotBlank(message = "Giới tính không được để trống")
    String gender;

    @Min(value = 18, message = "Tuổi phải từ 18-60")
    @Max(value = 60, message = "Tuổi phải từ 18-60")
    int age;

    @Min(value = 0, message = "Lương phải lớn hơn 0")
    double salary;
}
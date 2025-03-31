package com.nnd.labguide04.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MonHocDTO {
    @NotBlank(message = "Mã môn học không được để trống")
    @Size(min = 2, max = 2, message = "Mã môn học phải có đúng 2 ký tự")
    String maMH;

    @NotBlank(message = "Tên môn học không được để trống")
    @Size(min = 5, max = 50, message = "Tên môn học phải từ 5-50 ký tự")
    String tenMH;

    @Min(value = 45, message = "Số tiết phải từ 45-75")
    @Max(value = 75, message = "Số tiết phải từ 45-75")
    int soTiet;
}
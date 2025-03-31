package com.nnd.labguide04.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhoaDTO {
    @NotBlank(message = "Mã khoa không được để trống")
    @Size(min = 2, max = 2, message = "Mã khoa phải có đúng 2 ký tự")
    String maKhoa;

    @NotBlank(message = "Tên khoa không được để trống")
    @Size(min = 5, max = 25, message = "Tên khoa phải từ 5-25 ký tự")
    String tenKhoa;
}
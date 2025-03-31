package com.nnd.labguide04.Entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Khoa {
    String maKhoa;
    String tenKhoa;
}
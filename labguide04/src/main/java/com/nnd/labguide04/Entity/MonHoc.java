package com.nnd.labguide04.Entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MonHoc {
    String maMH;
    String tenMH;
    int soTiet;
}
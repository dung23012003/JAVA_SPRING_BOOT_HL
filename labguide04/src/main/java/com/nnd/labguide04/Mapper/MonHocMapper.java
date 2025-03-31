package com.nnd.labguide04.Mapper;

import com.nnd.labguide04.dto.MonHocDTO;
import com.nnd.labguide04.Entity.MonHoc;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MonHocMapper {

    MonHocMapper INSTANCE = Mappers.getMapper(MonHocMapper.class);

    // Chuyển từ MonHocDTO sang MonHoc
    MonHoc toEntity(MonHocDTO monHocDTO);

    // Chuyển từ MonHoc sang MonHocDTO
    MonHocDTO toDto(MonHoc monHoc);

    // Phương thức cập nhật Entity từ DTO
    void updateEntityFromDTO(MonHocDTO monHocDTO, MonHoc monHoc);
}

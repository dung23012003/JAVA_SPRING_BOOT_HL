package com.nnd.labguide04.Mapper;

import com.nnd.labguide04.dto.KhoaDTO;
import com.nnd.labguide04.Entity.Khoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KhoaMapper {

    KhoaMapper INSTANCE = Mappers.getMapper(KhoaMapper.class);

    // Chuyển từ KhoaDTO sang Khoa
    Khoa toEntity(KhoaDTO khoaDTO);

    // Chuyển từ Khoa sang KhoaDTO
    KhoaDTO toDto(Khoa khoa);

    // Phương thức updateEntityFromDTO
    void updateEntityFromDTO(KhoaDTO khoaDTO, Khoa khoa);
}

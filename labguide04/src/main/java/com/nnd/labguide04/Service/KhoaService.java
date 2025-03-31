package com.nnd.labguide04.Service;

import com.nnd.labguide04.dto.KhoaDTO;
import com.nnd.labguide04.Entity.Khoa;
import com.nnd.labguide04.Mapper.KhoaMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KhoaService {
    private final List<Khoa> khoaList = new ArrayList<>();
    private final KhoaMapper khoaMapper = KhoaMapper.INSTANCE;

    public KhoaService() {
        // Khởi tạo 5 khoa ban đầu
        khoaList.add(new Khoa("KH", "Công Nghệ"));
        khoaList.add(new Khoa("CN", "Công Nghệ"));
        khoaList.add(new Khoa("KT", "Kinh Tế"));
        khoaList.add(new Khoa("XD", "Xây Dựng"));
        khoaList.add(new Khoa("NN", "Ngôn Ngữ"));
    }

    public List<Khoa> findAll() {
        return new ArrayList<>(khoaList);
    }

    public Khoa findById(String maKhoa) {
        return khoaList.stream()
                .filter(khoa -> khoa.getMaKhoa().equals(maKhoa))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khoa với mã: " + maKhoa));
    }

    public void create(KhoaDTO khoaDTO) {
        if (khoaList.stream().anyMatch(khoa -> khoa.getMaKhoa().equals(khoaDTO.getMaKhoa()))) {
            throw new IllegalArgumentException("Mã khoa đã tồn tại: " + khoaDTO.getMaKhoa());
        }
        Khoa khoa = khoaMapper.toEntity(khoaDTO); // Sử dụng mapper để chuyển đổi từ DTO sang Entity
        khoaList.add(khoa);
    }

    public void update(String maKhoa, KhoaDTO khoaDTO) {
        Khoa khoa = findById(maKhoa);
        khoaMapper.updateEntityFromDTO(khoaDTO, khoa); // Sử dụng mapper để cập nhật thông tin entity từ DTO
    }

    public void delete(String maKhoa) {
        Khoa khoa = findById(maKhoa);
        khoaList.remove(khoa);
    }
}

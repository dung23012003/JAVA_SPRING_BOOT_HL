package com.nnd.labguide04.Service;

import com.nnd.labguide04.dto.MonHocDTO;
import com.nnd.labguide04.Entity.MonHoc;
import com.nnd.labguide04.Mapper.MonHocMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonHocService {

    private final List<MonHoc> monHocList = new ArrayList<>();
    private final MonHocMapper monHocMapper = MonHocMapper.INSTANCE; // Khởi tạo mapper

    public MonHocService() {
        // Khởi tạo 5 môn học ban đầu
        monHocList.add(new MonHoc("MH1", "Công Nghệ Thông Tin", 45));
        monHocList.add(new MonHoc("MH2", "Lập Trình Java", 60));
        monHocList.add(new MonHoc("MH3", "Kinh Tế Vi Mô", 75));
        monHocList.add(new MonHoc("MH4", "Vật Lý Đại Cương", 50));
        monHocList.add(new MonHoc("MH5", "Tiếng Anh Cơ Bản", 45));
    }

    public List<MonHoc> findAll() {
        return new ArrayList<>(monHocList);
    }

    public MonHoc findById(String maMH) {
        return monHocList.stream()
                .filter(monHoc -> monHoc.getMaMH().equals(maMH))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy môn học với mã: " + maMH));
    }

    public void create(MonHocDTO monHocDTO) {
        MonHoc monHoc = monHocMapper.toEntity(monHocDTO); // Chuyển từ DTO sang Entity
        monHocList.add(monHoc);
    }

    public void update(String maMH, MonHocDTO monHocDTO) {
        MonHoc monHoc = findById(maMH);
        monHocMapper.updateEntityFromDTO(monHocDTO, monHoc); // Cập nhật thông tin entity từ DTO
    }

    public void delete(String maMH) {
        MonHoc monHoc = findById(maMH);
        monHocList.remove(monHoc);
    }
}
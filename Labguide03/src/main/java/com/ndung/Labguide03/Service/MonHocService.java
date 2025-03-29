package com.ndung.Labguide03.Service;

import com.ndung.Labguide03.Entity.MonHoc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonHocService {
    private List<MonHoc> monHocList = new ArrayList<>();

    public MonHocService() {
        monHocList.add(new MonHoc("MH001", "Lập trình Java", 3));
        monHocList.add(new MonHoc("MH002", "Cấu trúc dữ liệu", 4));
        monHocList.add(new MonHoc("MH003", "Toán rời rạc", 2));
    }

    public List<MonHoc> getAllMonHoc() {
        return monHocList;
    }

    public MonHoc getMonHocById(String mamh) {
        return monHocList.stream()
                .filter(monHoc -> monHoc.getMamh().equals(mamh))
                .findFirst()
                .orElse(null);
    }

    public MonHoc addMonHoc(MonHoc monHoc) {
        monHocList.add(monHoc);
        return monHoc;
    }

    public MonHoc updateMonHoc(String mamh, MonHoc newMonHoc) {
        MonHoc existingMonHoc = getMonHocById(mamh);
        if (existingMonHoc != null) {
            existingMonHoc.setTenmh(newMonHoc.getTenmh());
            existingMonHoc.setSoTiet(newMonHoc.getSoTiet());
        }
        return existingMonHoc;
    }

    public boolean deleteMonHoc(String mamh) {
        return monHocList.removeIf(monHoc -> monHoc.getMamh().equals(mamh));
    }
}

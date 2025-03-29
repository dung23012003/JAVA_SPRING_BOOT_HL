package com.ndung.Labguide03.Service;

import com.ndung.Labguide03.Entity.Khoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KhoaService {
    private List<Khoa> khoaList = new ArrayList<>();

    public KhoaService() {
        khoaList.add(new Khoa("KH001", "Công nghệ thông tin"));
        khoaList.add(new Khoa("KH002", "Kinh tế"));
        khoaList.add(new Khoa("KH003", "Khoa học dữ liệu"));
        khoaList.add(new Khoa("KH004", "Quản trị kinh doanh"));
        khoaList.add(new Khoa("KH005", "Kế toán tài chính"));
    }
    public List<Khoa> getAllKhoa() {
        return khoaList;
    }

    public Khoa getKhoaById(String makh) {
        return khoaList.stream()
                .filter(khoa -> khoa.getMakh().equals(makh))
                .findFirst()
                .orElse(null);
    }

    public Khoa addKhoa(Khoa khoa) {
        khoaList.add(khoa);
        return khoa;
    }

    public Khoa updateKhoa(String makh, Khoa newKhoa) {
        Khoa existingKhoa = getKhoaById(makh);
        if (existingKhoa != null) {
            existingKhoa.setTenkh(newKhoa.getTenkh());
        }
        return existingKhoa;
    }

    public boolean deleteKhoa(String makh) {
        return khoaList.removeIf(khoa -> khoa.getMakh().equals(makh));
    }
}

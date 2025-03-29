package com.ndung.Labguide03.Controller;

import com.ndung.Labguide03.Entity.MonHoc;
import com.ndung.Labguide03.Service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monhoc")
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    // Lấy danh sách tất cả môn học
    @GetMapping("/list")
    public List<MonHoc> getAllMonHoc() {
        return monHocService.getAllMonHoc();
    }

    // Lấy môn học theo mã
    @GetMapping("/{mamh}")
    public MonHoc getMonHocById(@PathVariable String mamh) {
        return monHocService.getMonHocById(mamh);
    }

    // Thêm mới môn học
    @PostMapping("/add")
    public MonHoc addMonHoc(@RequestBody MonHoc monHoc) {
        return monHocService.addMonHoc(monHoc);
    }

    // Cập nhật thông tin môn học
    @PutMapping("/{mamh}")
    public MonHoc updateMonHoc(@PathVariable String mamh, @RequestBody MonHoc monHoc) {
        return monHocService.updateMonHoc(mamh, monHoc);
    }

    // Xóa môn học theo mã
    @DeleteMapping("/{mamh}")
    public boolean deleteMonHoc(@PathVariable String mamh) {
        return monHocService.deleteMonHoc(mamh);
    }
}

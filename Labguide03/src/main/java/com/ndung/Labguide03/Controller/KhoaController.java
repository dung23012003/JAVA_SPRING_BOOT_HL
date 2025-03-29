package com.ndung.Labguide03.Controller;

import com.ndung.Labguide03.Entity.Khoa;
import com.ndung.Labguide03.Service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khoa")
public class KhoaController {
    @Autowired
    private KhoaService khoaService;

    @GetMapping
    public List<Khoa> getAllKhoa() {
        return khoaService.getAllKhoa();
    }

    @GetMapping("/{makh}")
    public Khoa getKhoaById(@PathVariable String makh) {
        return khoaService.getKhoaById(makh);
    }

    @PostMapping
    public Khoa addKhoa(@RequestBody Khoa khoa) {
        return khoaService.addKhoa(khoa);
    }

    @PutMapping("/{makh}")
    public Khoa updateKhoa(@PathVariable String makh, @RequestBody Khoa newKhoa) {
        return khoaService.updateKhoa(makh, newKhoa);
    }

    @DeleteMapping("/{makh}")
    public boolean deleteKhoa(@PathVariable String makh) {
        return khoaService.deleteKhoa(makh);
    }
}

package com.ndung.Labguide03.Entity;

public class MonHoc {
    private String mamh;
    private String tenmh;
    private int soTiet;

    public MonHoc() {
    }

    public MonHoc(String mamh, String tenmh, int soTiet) {
        this.mamh = mamh;
        this.tenmh = tenmh;
        this.soTiet = soTiet;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public String getTenmh() {
        return tenmh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
    }

    public int getSoTiet() {  // BỔ SUNG
        return soTiet;
    }

    public void setSoTiet(int soTiet) {  // BỔ SUNG
        this.soTiet = soTiet;
    }
}

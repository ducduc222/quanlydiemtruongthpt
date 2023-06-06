package com.mycompany.quanlydiemtruongthpt.Model;

public class KhoiLop extends Model{
    private String TenKhoiLop;

    public String getTenKhoiLop() {
        return TenKhoiLop;
    }

    public void setTenKhoiLop(String tenKhoiLop) {
        TenKhoiLop = tenKhoiLop;
    }

    public KhoiLop() {
    }

    public KhoiLop(String tenKhoiLop) {
        TenKhoiLop = tenKhoiLop;
    }
}

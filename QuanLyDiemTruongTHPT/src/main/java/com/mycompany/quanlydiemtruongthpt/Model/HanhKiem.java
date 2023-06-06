package com.mycompany.quanlydiemtruongthpt.Model;

public class HanhKiem extends Model{
    private String TenHanhKiem;

    public HanhKiem() {
    }

    public HanhKiem(String tenHanhKiem) {
        TenHanhKiem = tenHanhKiem;
    }

    public String getTenHanhKiem() {
        return TenHanhKiem;
    }

    public void setTenHanhKiem(String tenHanhKiem) {
        TenHanhKiem = tenHanhKiem;
    }
}

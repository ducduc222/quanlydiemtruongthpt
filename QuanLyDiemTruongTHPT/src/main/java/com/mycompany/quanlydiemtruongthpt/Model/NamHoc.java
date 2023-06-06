package com.mycompany.quanlydiemtruongthpt.Model;

public class NamHoc extends Model{
    private String TenNamHoc;

    public String getTenNamHoc() {
        return TenNamHoc;
    }

    public void setTenNamHoc(String tenNamHoc) {
        TenNamHoc = tenNamHoc;
    }

    public NamHoc() {
    }

    public NamHoc(String tenNamHoc) {
        TenNamHoc = tenNamHoc;
    }

}

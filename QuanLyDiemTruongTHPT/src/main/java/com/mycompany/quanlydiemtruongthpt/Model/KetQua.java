package com.mycompany.quanlydiemtruongthpt.Model;

public class KetQua extends Model{
    private String TenKetQua;

    public KetQua() {
    }

    public KetQua(String tenKetQua) {
        TenKetQua = tenKetQua;
    }

    public String getTenKetQua() {
        return TenKetQua;
    }

    public void setTenKetQua(String tenKetQua) {
        TenKetQua = tenKetQua;
    }
}

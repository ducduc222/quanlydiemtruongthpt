package com.mycompany.quanlydiemtruongthpt.Model;

public class LoaiDiem extends Model{
    private String TenLoaiDiem;
    private Float HeSo;

    public LoaiDiem() {
    }


    public LoaiDiem(String tenLoaiDiem, Float heSo) {
        TenLoaiDiem = tenLoaiDiem;
        HeSo = heSo;
    }

    public String getTenLoaiDiem() {
        return TenLoaiDiem;
    }

    public void setTenLoaiDiem(String tenLoaiDiem) {
        TenLoaiDiem = tenLoaiDiem;
    }

    public Float getHeSo() {
        return HeSo;
    }

    public void setHeSo(Float heSo) {
        HeSo = heSo;
    }
}

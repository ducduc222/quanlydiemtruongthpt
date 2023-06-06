package com.mycompany.quanlydiemtruongthpt.Model;

public class MonHoc extends Model{
    private String TenMonHoc;
    private Integer SoTiet;
    private Float HeSo;

    public String getTenMonHoc() {
        return TenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        TenMonHoc = tenMonHoc;
    }

    public Integer getSoTiet() {
        return SoTiet;
    }

    public void setSoTiet(Integer soTiet) {
        SoTiet = soTiet;
    }

    public Float getHeSo() {
        return HeSo;
    }

    public void setHeSo(Float heSo) {
        HeSo = heSo;
    }

    public MonHoc() {
    }

    public MonHoc(String tenMonHoc, Integer soTiet, Float heSo) {
        TenMonHoc = tenMonHoc;
        SoTiet = soTiet;
        HeSo = heSo;
    }
}

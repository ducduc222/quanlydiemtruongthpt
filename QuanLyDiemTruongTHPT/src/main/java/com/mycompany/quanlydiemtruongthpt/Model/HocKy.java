package com.mycompany.quanlydiemtruongthpt.Model;

public class HocKy extends Model{
    private String TenHocKy;
    private Float HeSo;
    private Integer NamHoc_Id;
    private Boolean HocKyHienTai;
    public HocKy() {
    }

    public HocKy(String tenHocKy, Float heSo, Integer namHoc_Id, Boolean hocKyHienTai) {
        TenHocKy = tenHocKy;
        HeSo = heSo;
        NamHoc_Id = namHoc_Id;
        HocKyHienTai = hocKyHienTai;
    }

    public Boolean getHocKyHienTai() {
        return HocKyHienTai;
    }

    public String getTenHocKy() {
        return TenHocKy;
    }

    public void setTenHocKy(String tenHocKy) {
        TenHocKy = tenHocKy;
    }

    public Float getHeSo() {
        return HeSo;
    }

    public void setHeSo(Float heSo) {
        HeSo = heSo;
    }

    public Integer getNamHoc_Id() {
        return NamHoc_Id;
    }

    public void setNamHoc_Id(Integer namHoc_Id) {
        NamHoc_Id = namHoc_Id;
    }

    public Boolean isHocKyHienTai() {
        return HocKyHienTai;
    }

    public void setHocKyHienTai(Boolean hocKyHienTai) {
        HocKyHienTai = hocKyHienTai;
    }
}

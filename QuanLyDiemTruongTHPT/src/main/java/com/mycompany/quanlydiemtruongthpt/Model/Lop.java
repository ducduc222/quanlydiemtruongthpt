/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlydiemtruongthpt.Model;

/**
 *
 * @author nguyenduc
 */
public class Lop extends Model{
    private String TenLop;
    private Integer KhoiLop_Id;
    private Integer NamHoc_Id;
    private Integer SiSo;
    private Integer GiaoVien_Id;

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String tenLop) {
        TenLop = tenLop;
    }

    public Integer getKhoiLop_Id() {
        return KhoiLop_Id;
    }

    public void setKhoiLop_Id(Integer khoiLop_Id) {
        KhoiLop_Id = khoiLop_Id;
    }

    public Integer getNamHoc_Id() {
        return NamHoc_Id;
    }

    public void setNamHoc_Id(Integer namHoc_Id) {
        NamHoc_Id = namHoc_Id;
    }

    public Integer getSiSo() {
        return SiSo;
    }

    public void setSiSo(Integer siSo) {
        SiSo = siSo;
    }

    public Integer getGiaoVien_Id() {
        return GiaoVien_Id;
    }

    public void setGiaoVien_Id(Integer giaoVien_Id) {
        GiaoVien_Id = giaoVien_Id;
    }

    public Lop() {
    }

    public Lop(String tenLop, Integer khoiLop_Id, Integer namHoc_Id, Integer siSo, Integer giaoVien_Id) {
        TenLop = tenLop;
        KhoiLop_Id = khoiLop_Id;
        NamHoc_Id = namHoc_Id;
        SiSo = siSo;
        GiaoVien_Id = giaoVien_Id;
    }

}

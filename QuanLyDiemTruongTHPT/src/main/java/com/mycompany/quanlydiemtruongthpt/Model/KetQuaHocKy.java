package com.mycompany.quanlydiemtruongthpt.Model;

public class KetQuaHocKy extends Model{
    private Integer HocSinh_Id;
    private Integer HocKy_Id;
    private Float DiemHocKy;
    private Integer HocLuc_Id;
    private Integer HanhKiem_Id;
    private Integer KetQua_Id;

    public Integer getHocSinh_Id() {
        return HocSinh_Id;
    }

    public void setHocSinh_Id(Integer hocSinh_Id) {
        HocSinh_Id = hocSinh_Id;
    }

    public Integer getHocKy_Id() {
        return HocKy_Id;
    }

    public void setHocKy_Id(Integer hocKy_Id) {
        HocKy_Id = hocKy_Id;
    }

    public Float getDiemHocKy() {
        return DiemHocKy;
    }

    public void setDiemHocKy(Float diemHocKy) {
        DiemHocKy = diemHocKy;
    }

    public Integer getHocLuc_Id() {
        return HocLuc_Id;
    }

    public void setHocLuc_Id(Integer hocLuc_Id) {
        HocLuc_Id = hocLuc_Id;
    }

    public Integer getHanhKiem_Id() {
        return HanhKiem_Id;
    }

    public void setHanhKiem_Id(Integer hanhKiem_Id) {
        HanhKiem_Id = hanhKiem_Id;
    }

    public Integer getKetQua_Id() {
        return KetQua_Id;
    }

    public void setKetQua_Id(Integer ketQua_Id) {
        KetQua_Id = ketQua_Id;
    }

    public KetQuaHocKy() {
    }

    public KetQuaHocKy(Integer hocSinh_Id, Integer hocKy_Id, Float diemHocKy, Integer hocLuc_Id, Integer hanhKiem_Id, Integer ketQua_Id) {
        HocSinh_Id = hocSinh_Id;
        HocKy_Id = hocKy_Id;
        DiemHocKy = diemHocKy;
        HocLuc_Id = hocLuc_Id;
        HanhKiem_Id = hanhKiem_Id;
        KetQua_Id = ketQua_Id;
    }
}

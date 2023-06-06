package com.mycompany.quanlydiemtruongthpt.Model;

public class KetQuaHocSinh extends Model{
    private Integer HoSoHocSinh_Id;
    private Integer Lop_Id;
    private Integer KetQua_Id;
    private Integer HocLuc_Id;
    private Integer HanhKiem_Id;
    private Integer NamHoc_Id;
    private Float DiemTrungBinhCaNam;

    public Integer getNamHoc_Id() {
        return NamHoc_Id;
    }

    public void setNamHoc_Id(Integer namHoc_Id) {
        NamHoc_Id = namHoc_Id;
    }

    public Integer getHoSoHocSinh_Id() {
        return HoSoHocSinh_Id;
    }

    public void setHoSoHocSinh_Id(Integer hoSoHocSinh_Id) {
        HoSoHocSinh_Id = hoSoHocSinh_Id;
    }

    public Integer getLop_Id() {
        return Lop_Id;
    }

    public void setLop_Id(Integer lop_Id) {
        Lop_Id = lop_Id;
    }

    public Integer getKetQua_Id() {
        return KetQua_Id;
    }

    public void setKetQua_Id(Integer ketQua_Id) {
        KetQua_Id = ketQua_Id;
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

    public Float getDiemTrungBinhCaNam() {
        return DiemTrungBinhCaNam;
    }

    public void setDiemTrungBinhCaNam(Float diemTrungBinhCaNam) {
        DiemTrungBinhCaNam = diemTrungBinhCaNam;
    }

    public KetQuaHocSinh() {
    }

    public KetQuaHocSinh(Integer hoSoHocSinh_Id, Integer lop_Id, Integer ketQua_Id, Integer hocLuc_Id, Integer hanhKiem_Id, Float diemTrungBinhCaNam) {
        HoSoHocSinh_Id = hoSoHocSinh_Id;
        Lop_Id = lop_Id;
        KetQua_Id = ketQua_Id;
        HocLuc_Id = hocLuc_Id;
        HanhKiem_Id = hanhKiem_Id;
        DiemTrungBinhCaNam = diemTrungBinhCaNam;
    }
}

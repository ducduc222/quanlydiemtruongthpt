package com.mycompany.quanlydiemtruongthpt.Model;

public class DiemHocKyMonHoc extends Model{
    private Integer HocSinh_Id;
    private Integer MonHoc_Id;
    private Integer HocKy_Id;
    private Float DiemTrungBinhMon;


    public DiemHocKyMonHoc() {
    }

    public DiemHocKyMonHoc(Integer hocSinh_Id, Integer monHoc_Id, Integer hocKy_Id, Float diemTrungBinhMon) {
        HocSinh_Id = hocSinh_Id;
        MonHoc_Id = monHoc_Id;
        HocKy_Id = hocKy_Id;
        DiemTrungBinhMon = diemTrungBinhMon;
    }

    public Integer getHocSinh_Id() {
        return HocSinh_Id;
    }

    public void setHocSinh_Id(Integer hocSinh_Id) {
        HocSinh_Id = hocSinh_Id;
    }

    public Integer getMonHoc_Id() {
        return MonHoc_Id;
    }

    public void setMonHoc_Id(Integer monHoc_Id) {
        MonHoc_Id = monHoc_Id;
    }

    public Integer getHocKy_Id() {
        return HocKy_Id;
    }

    public void setHocKy_Id(Integer hocKy_Id) {
        HocKy_Id = hocKy_Id;
    }

    public Float getDiemTrungBinhMon() {
        return DiemTrungBinhMon;
    }

    public void setDiemTrungBinhMon(Float diemTrungBinhMon) {
        DiemTrungBinhMon = diemTrungBinhMon;
    }
}

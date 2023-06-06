package com.mycompany.quanlydiemtruongthpt.Model;

public class DiemCaNam extends Model{
    private Integer HocSinh_Id;
    private Integer MonHoc_Id;
    private Integer NamHoc_Id;
    private Float DiemTrungBinhMonCaNam;

    public Integer getNamHoc_Id() {
        return NamHoc_Id;
    }

    public void setNamHoc_Id(Integer namHoc_Id) {
        NamHoc_Id = namHoc_Id;
    }

    public DiemCaNam() {
    }

    public DiemCaNam(Integer hocSinh_Id, Integer monHoc_Id, Integer namHoc_Id, Float diemTrungBinhMonCaNam) {
        HocSinh_Id = hocSinh_Id;
        MonHoc_Id = monHoc_Id;
        NamHoc_Id = namHoc_Id;
        DiemTrungBinhMonCaNam = diemTrungBinhMonCaNam;
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

    public Float getDiemTrungBinhMonCaNam() {
        return DiemTrungBinhMonCaNam;
    }

    public void setDiemTrungBinhMonCaNam(Float diemTrungBinhMonCaNam) {
        DiemTrungBinhMonCaNam = diemTrungBinhMonCaNam;
    }
}

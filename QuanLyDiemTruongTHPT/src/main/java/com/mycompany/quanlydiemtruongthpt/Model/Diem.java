package com.mycompany.quanlydiemtruongthpt.Model;

public class Diem extends Model{
    private Integer DiemHocKyMonHoc_Id;
    private Integer LoaiDiem_Id;
    private Float diem;


    public Diem() {
    }

    public Diem(Integer diemHocKyMonHoc_Id, Integer loaiDiem_Id, Float diem) {
        DiemHocKyMonHoc_Id = diemHocKyMonHoc_Id;
        LoaiDiem_Id = loaiDiem_Id;
        this.diem = diem;
    }

    public Integer getDiemHocKyMonHoc_Id() {
        return DiemHocKyMonHoc_Id;
    }

    public void setDiemHocKyMonHoc_Id(Integer diemHocKyMonHoc_Id) {
        DiemHocKyMonHoc_Id = diemHocKyMonHoc_Id;
    }

    public Integer getLoaiDiem_Id() {
        return LoaiDiem_Id;
    }

    public void setLoaiDiem_Id(Integer loaiDiem_Id) {
        LoaiDiem_Id = loaiDiem_Id;
    }

    public Float getDiem() {
        return diem;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }
}

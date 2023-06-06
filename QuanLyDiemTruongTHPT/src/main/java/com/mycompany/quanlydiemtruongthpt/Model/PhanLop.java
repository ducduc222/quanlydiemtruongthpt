package com.mycompany.quanlydiemtruongthpt.Model;

public class PhanLop extends Model{
    private Integer GiaoVien_Id;
    private Integer Lop_Id;




    public Integer getGiaoVien_Id() {
        return GiaoVien_Id;
    }

    public void setGiaoVien_Id(Integer giaoVien_Id) {
        GiaoVien_Id = giaoVien_Id;
    }

    public Integer getLop_Id() {
        return Lop_Id;
    }

    public void setLop_Id(Integer lop_Id) {
        Lop_Id = lop_Id;
    }

    public PhanLop() {
    }

    public PhanLop(Integer giaoVien_Id, Integer lop_Id) {
        GiaoVien_Id = giaoVien_Id;
        Lop_Id = lop_Id;
    }
}

package com.mycompany.quanlydiemtruongthpt.Model;

public class HocLuc extends Model{
    private String TenHocLuc;
    private Float DiemCanTren;
    private Float DiemCanDuoi;

    public HocLuc() {
    }

    public HocLuc(String tenHocLuc, Float diemCanTren, Float diemCanDuoi) {
        TenHocLuc = tenHocLuc;
        DiemCanTren = diemCanTren;
        DiemCanDuoi = diemCanDuoi;
    }

    public String getTenHocLuc() {
        return TenHocLuc;
    }

    public void setTenHocLuc(String tenHocLuc) {
        TenHocLuc = tenHocLuc;
    }

    public Float getDiemCanTren() {
        return DiemCanTren;
    }

    public void setDiemCanTren(Float diemCanTren) {
        DiemCanTren = diemCanTren;
    }

    public Float getDiemCanDuoi() {
        return DiemCanDuoi;
    }

    public void setDiemCanDuoi(Float diemCanDuoi) {
        DiemCanDuoi = diemCanDuoi;
    }
}

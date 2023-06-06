package com.mycompany.quanlydiemtruongthpt.Model;


public class GiaoVien extends Model{
    private String HoTen;
    private String GioiTinh;
    private String NgaySinh;
    private String DiaChi;
    private String SoDienThoai;
    private Integer DanToc_Id;
    private Integer TonGiao_Id;
    private Integer MonHoc_Id;

    public GiaoVien() {
    }

    public GiaoVien(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String soDienThoai, Integer danToc_Id, Integer tonGiao_Id, Integer monHoc_Id) {
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        SoDienThoai = soDienThoai;
        DanToc_Id = danToc_Id;
        TonGiao_Id = tonGiao_Id;
        MonHoc_Id = monHoc_Id;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public Integer getDanToc_Id() {
        return DanToc_Id;
    }

    public void setDanToc_Id(Integer danToc_Id) {
        DanToc_Id = danToc_Id;
    }

    public Integer getTonGiao_Id() {
        return TonGiao_Id;
    }

    public void setTonGiao_Id(Integer tonGiao_Id) {
        TonGiao_Id = tonGiao_Id;
    }

    public Integer getMonHoc_Id() {
        return MonHoc_Id;
    }

    public void setMonHoc_Id(Integer monHoc_Id) {
        MonHoc_Id = monHoc_Id;
    }
}

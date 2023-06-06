package com.mycompany.quanlydiemtruongthpt.Model;


public class HoSoHocSinh extends Model{
    private String HoTen;
    private String GioiTinh;
    private String NgaySinh;
    private String NoiSinh;
    private Integer DanToc_Id;
    private Integer TonGiao_Id;
    private String HoTenCha;
    private String NgheNghiepCha;
    private Integer NamSinhCha;
    private String SoDienThoaiCha;
    private String HoTenMe;
    private String NgheNghiepMe;
    private Integer NamSinhMe;
    private String SoDienThoaiMe;
    private Integer Lop_Id;

    public Integer getLop_Id() {
        return Lop_Id;
    }

    public void setLop_Id(Integer lop_Id) {
        Lop_Id = lop_Id;
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

    public String getNoiSinh() {
        return NoiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        NoiSinh = noiSinh;
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

    public String getHoTenCha() {
        return HoTenCha;
    }

    public void setHoTenCha(String hoTenCha) {
        HoTenCha = hoTenCha;
    }

    public String getNgheNghiepCha() {
        return NgheNghiepCha;
    }

    public void setNgheNghiepCha(String ngheNghiepCha) {
        NgheNghiepCha = ngheNghiepCha;
    }

    public Integer getNamSinhCha() {
        return NamSinhCha;
    }

    public void setNamSinhCha(Integer namSinhCha) {
        NamSinhCha = namSinhCha;
    }

    public String getSoDienThoaiCha() {
        return SoDienThoaiCha;
    }

    public void setSoDienThoaiCha(String soDienThoaiCha) {
        SoDienThoaiCha = soDienThoaiCha;
    }

    public String getHoTenMe() {
        return HoTenMe;
    }

    public void setHoTenMe(String hoTenMe) {
        HoTenMe = hoTenMe;
    }

    public String getNgheNghiepMe() {
        return NgheNghiepMe;
    }

    public void setNgheNghiepMe(String ngheNghiepMe) {
        NgheNghiepMe = ngheNghiepMe;
    }

    public Integer getNamSinhMe() {
        return NamSinhMe;
    }

    public void setNamSinhMe(Integer namSinhMe) {
        NamSinhMe = namSinhMe;
    }

    public String getSoDienThoaiMe() {
        return SoDienThoaiMe;
    }

    public void setSoDienThoaiMe(String soDienThoaiMe) {
        SoDienThoaiMe = soDienThoaiMe;
    }

    public HoSoHocSinh() {
    }

    public HoSoHocSinh(String hoTen, String gioiTinh, String ngaySinh, String noiSinh, Integer danToc_Id, Integer tonGiao_Id, String hoTenCha, String ngheNghiepCha, Integer namSinhCha, String soDienThoaiCha, String hoTenMe, String ngheNghiepMe, Integer namSinhMe, String soDienThoaiMe) {
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        NoiSinh = noiSinh;
        DanToc_Id = danToc_Id;
        TonGiao_Id = tonGiao_Id;
        HoTenCha = hoTenCha;
        NgheNghiepCha = ngheNghiepCha;
        NamSinhCha = namSinhCha;
        SoDienThoaiCha = soDienThoaiCha;
        HoTenMe = hoTenMe;
        NgheNghiepMe = ngheNghiepMe;
        NamSinhMe = namSinhMe;
        SoDienThoaiMe = soDienThoaiMe;
    }

    public HoSoHocSinh(String hoTen, String gioiTinh, String ngaySinh, String noiSinh, Integer danToc_Id, Integer tonGiao_Id, String hoTenCha, String ngheNghiepCha, Integer namSinhCha, String soDienThoaiCha, String hoTenMe, String ngheNghiepMe, Integer namSinhMe, String soDienThoaiMe, Integer lop_Id) {
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        NoiSinh = noiSinh;
        DanToc_Id = danToc_Id;
        TonGiao_Id = tonGiao_Id;
        HoTenCha = hoTenCha;
        NgheNghiepCha = ngheNghiepCha;
        NamSinhCha = namSinhCha;
        SoDienThoaiCha = soDienThoaiCha;
        HoTenMe = hoTenMe;
        NgheNghiepMe = ngheNghiepMe;
        NamSinhMe = namSinhMe;
        SoDienThoaiMe = soDienThoaiMe;
        Lop_Id = lop_Id;
    }
}

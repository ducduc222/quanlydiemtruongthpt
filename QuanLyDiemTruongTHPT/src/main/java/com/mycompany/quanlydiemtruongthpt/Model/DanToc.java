package com.mycompany.quanlydiemtruongthpt.Model;

public class DanToc extends Model{

    private String TenDanToc;

    public DanToc() {
    }

    public DanToc(String tenDanToc) {
        TenDanToc = tenDanToc;
    }

    public String getTenDanToc() {
        return TenDanToc;
    }

    public void setTenDanToc(String tenDanToc) {
        TenDanToc = tenDanToc;
    }
}

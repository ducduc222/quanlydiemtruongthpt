package com.mycompany.quanlydiemtruongthpt.Model;

public class TonGiao extends Model{
    private String TenTonGiao;


    public TonGiao() {
    }

    public TonGiao(String tenTonGiao) {
        TenTonGiao = tenTonGiao;
    }

    public String getTenTonGiao() {
        return TenTonGiao;
    }

    public void setTenTonGiao(String tenTonGiao) {
        TenTonGiao = tenTonGiao;
    }
}

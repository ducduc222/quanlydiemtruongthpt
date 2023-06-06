package com.mycompany.quanlydiemtruongthpt.Controller;


import com.mycompany.quanlydiemtruongthpt.DAO.KetQuaHocSinhDAO;
import com.mycompany.quanlydiemtruongthpt.Model.KetQuaHocSinh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KetQuaHocSinhCtrl {
    private KetQuaHocSinhDAO ketQuaHocSinhDAO;
    public KetQuaHocSinhCtrl () {
        this.ketQuaHocSinhDAO = new KetQuaHocSinhDAO();
    }

    public List<KetQuaHocSinh> getAllKetQuaHocSinh() throws SQLException {
        return ketQuaHocSinhDAO.getAll();
    }

    public KetQuaHocSinh getKetQuaHocSinhId (int id) throws SQLException {
        return ketQuaHocSinhDAO.findId(id).get(0);
    }

    public void createKetQuaHocSinh(KetQuaHocSinh ketQuaHocSinh) throws SQLException {
        ArrayList<String> columeName = new ArrayList<>();
        columeName.add("HoSoHocSinh_Id");
        columeName.add("Lop_Id");
        columeName.add("KetQua_Id");
        columeName.add("HocLuc_Id");
        columeName.add("HanhKiem_Id");
        columeName.add("DiemTrungBinhCaNam");

        Object[] value = {ketQuaHocSinh.getHoSoHocSinh_Id(), ketQuaHocSinh.getLop_Id(), ketQuaHocSinh.getKetQua_Id(), ketQuaHocSinh.getHocLuc_Id(), ketQuaHocSinh.getHanhKiem_Id(), ketQuaHocSinh.getDiemTrungBinhCaNam()};

        ketQuaHocSinhDAO.create(columeName, value);
    }
    public void deleteKetQuaHocSinhId (int id) throws SQLException {
        ketQuaHocSinhDAO.deleteId(id);
    }
}

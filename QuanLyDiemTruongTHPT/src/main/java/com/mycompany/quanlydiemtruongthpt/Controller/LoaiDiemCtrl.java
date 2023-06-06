package com.mycompany.quanlydiemtruongthpt.Controller;


import com.mycompany.quanlydiemtruongthpt.DAO.LoaiDiemDAO;
import com.mycompany.quanlydiemtruongthpt.Model.LoaiDiem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiDiemCtrl {
    private LoaiDiemDAO loaiDiemDAO;
    public LoaiDiemCtrl () {
        this.loaiDiemDAO = new LoaiDiemDAO();
    }

    public List<LoaiDiem> getAllLoaiDiem() throws SQLException {
        return loaiDiemDAO.getAll();
    }

    public LoaiDiem getLoaiDiemById (int id) throws SQLException {
        return loaiDiemDAO.findId(id).get(0);
    }

    public void createLoaiDiem(LoaiDiem loaiDiem) throws SQLException {
        ArrayList<String> columeName = new ArrayList<>();
        columeName.add("TenLoaiDiem");
        columeName.add("HeSo");

        Object[] value = {loaiDiem.getTenLoaiDiem(), loaiDiem.getHeSo()};

        loaiDiemDAO.create(columeName, value);
    }
    public void deleteLoaiDiemById (int id) throws SQLException {
        loaiDiemDAO.deleteId(id);
    }
}

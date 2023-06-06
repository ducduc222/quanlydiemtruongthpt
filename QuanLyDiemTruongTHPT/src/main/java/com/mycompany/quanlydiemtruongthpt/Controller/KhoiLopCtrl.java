package com.mycompany.quanlydiemtruongthpt.Controller;

import com.mycompany.quanlydiemtruongthpt.DAO.KhoiLopDAO;
import com.mycompany.quanlydiemtruongthpt.DAO.LopDAO;
import com.mycompany.quanlydiemtruongthpt.Model.KhoiLop;
import com.mycompany.quanlydiemtruongthpt.Model.Lop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhoiLopCtrl {
    private KhoiLopDAO khoiLopDAO;
    public KhoiLopCtrl () {
        this.khoiLopDAO = new KhoiLopDAO();
    }

    public List<KhoiLop> getAllKhoiLop() throws SQLException {
        return khoiLopDAO.getAll();
    }

    public KhoiLop getKhoiLopById (int id) throws SQLException {
        return khoiLopDAO.findId(id).get(0);
    }

    public void createKhoiLop(KhoiLop khoiLop) throws SQLException {
        ArrayList<String> columeName = new ArrayList<>();
        columeName.add("TenKhoiLop");

        Object[] value = {khoiLop.getTenKhoiLop()};

        khoiLopDAO.create(columeName, value);
    }
    public void deleteKhoiLopById (int id) throws SQLException {
        khoiLopDAO.deleteId(id);
    }
}

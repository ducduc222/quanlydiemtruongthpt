package com.mycompany.quanlydiemtruongthpt.Controller;

import com.mycompany.quanlydiemtruongthpt.DAO.LopDAO;
import com.mycompany.quanlydiemtruongthpt.DAO.MonHocDAO;
import com.mycompany.quanlydiemtruongthpt.Model.Lop;
import com.mycompany.quanlydiemtruongthpt.Model.MonHoc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonHocCtrl {
    private MonHocDAO monHocDAO;
    public MonHocCtrl () {
        this.monHocDAO = new MonHocDAO();
    }

    public List<MonHoc> getAllMonHoc() throws SQLException {
        return monHocDAO.getAll();
    }

    public MonHoc getMonHocById (int id) throws SQLException {
        return monHocDAO.findId(id).get(0);
    }

    public void createMonHoc(MonHoc monHoc) throws SQLException {
        ArrayList<String> columeName = new ArrayList<>();
        columeName.add("TenMonHoc");
        columeName.add("SoTiet");
        columeName.add("HeSo");

        Object[] value = {monHoc.getTenMonHoc(), monHoc.getSoTiet(), monHoc.getHeSo()};

        monHocDAO.create(columeName, value);
    }
    public void deleteMonHocById (int id) throws SQLException {
        monHocDAO.deleteId(id);
    }
}

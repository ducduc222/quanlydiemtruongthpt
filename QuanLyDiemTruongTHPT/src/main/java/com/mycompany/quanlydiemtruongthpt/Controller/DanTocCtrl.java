package com.mycompany.quanlydiemtruongthpt.Controller;

import com.mycompany.quanlydiemtruongthpt.DAO.DanTocDAO;
import com.mycompany.quanlydiemtruongthpt.Model.DanToc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanTocCtrl {
    private DanTocDAO danTocDAO;
    public DanTocCtrl () {
        this.danTocDAO = new DanTocDAO();
    }

    public List<DanToc> getAllDanToc() throws SQLException {
        return danTocDAO.getAll();
    }

    public DanToc getDanTocById (int id) throws SQLException {
        return danTocDAO.findId(id).get(0);
    }

    public void createDanToc(DanToc danToc) throws SQLException {
        ArrayList<String> columeName = new ArrayList<>();
        columeName.add("TenDanToc");
        Object[] value = {danToc.getTenDanToc()};
        danTocDAO.create(columeName, value);
    }
    public void deleteDanTocById (int id) throws SQLException {
        danTocDAO.deleteId(id);
    }
}

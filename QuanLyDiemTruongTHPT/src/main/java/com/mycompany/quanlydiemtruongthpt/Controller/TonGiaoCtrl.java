package com.mycompany.quanlydiemtruongthpt.Controller;

import com.mycompany.quanlydiemtruongthpt.DAO.LopDAO;
import com.mycompany.quanlydiemtruongthpt.DAO.TonGiaoDAO;
import com.mycompany.quanlydiemtruongthpt.Model.Lop;
import com.mycompany.quanlydiemtruongthpt.Model.TonGiao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TonGiaoCtrl {
    private TonGiaoDAO tonGiaoDAO;
    public TonGiaoCtrl () {
        this.tonGiaoDAO = new TonGiaoDAO();
    }

    public List<TonGiao> getAllTonGiao() throws SQLException {
        return tonGiaoDAO.getAll();
    }

    public TonGiao getTonGiaoById (int id) throws SQLException {
        return tonGiaoDAO.findId(id).get(0);
    }

    public void createTonGiao(TonGiao tonGiao) throws SQLException {
        ArrayList<String> columeName = new ArrayList<>();
        columeName.add("TenTonGiao");
        Object[] value = {tonGiao.getTenTonGiao()};
        tonGiaoDAO.create(columeName, value);
    }
    public void deleteTonGiaoById (int id) throws SQLException {
        tonGiaoDAO.deleteId(id);
    }
}

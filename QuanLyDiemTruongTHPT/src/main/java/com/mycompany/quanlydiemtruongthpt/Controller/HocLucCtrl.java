package com.mycompany.quanlydiemtruongthpt.Controller;

import com.mycompany.quanlydiemtruongthpt.Connection.MyConnection;
import com.mycompany.quanlydiemtruongthpt.DAO.HocLucDAO;
import com.mycompany.quanlydiemtruongthpt.Model.HocLuc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HocLucCtrl {
    private HocLucDAO hocLucDAO;
    public HocLucCtrl () {
        this.hocLucDAO = new HocLucDAO();
    }

    public List<HocLuc> getAllHocLuc() throws SQLException {
        return hocLucDAO.getAll();
    }

    public HocLuc getHocLucById (int id) throws SQLException {
        return hocLucDAO.findId(id).get(0);
    }
    public int getIdHocLucByName(String tenHocLuc) throws SQLException {
        String sql = "SELECT HocLuc_Id FROM HOCLUC WHERE TenHocLuc = '" +tenHocLuc+"'";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) {
            return resultSet.getInt("HocLuc_Id");
        }
        return 0;
    }
    public void createHocLuc(HocLuc hocLuc) throws SQLException {
        ArrayList<String> columeName = new ArrayList<>();

        columeName.add("TenHocLuc");

        Object[] value = {hocLuc.getTenHocLuc()};

        hocLucDAO.create(columeName, value);
    }
    public void deleteHocLucId (int id) throws SQLException {
        hocLucDAO.deleteId(id);
    }
}

package com.mycompany.quanlydiemtruongthpt.Controller;


import com.mycompany.quanlydiemtruongthpt.Connection.MyConnection;
import com.mycompany.quanlydiemtruongthpt.DAO.HanhKiemDAO;
import com.mycompany.quanlydiemtruongthpt.Model.HanhKiem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HanhKiemCtrl {
    private HanhKiemDAO hanhKiemDAO;
    public HanhKiemCtrl () {
        this.hanhKiemDAO = new HanhKiemDAO();
    }

    public List<HanhKiem> getAllHanhKiem() throws SQLException {
        return hanhKiemDAO.getAll();
    }

    public HanhKiem getHanhKiemById (int id) throws SQLException {
        return hanhKiemDAO.findId(id).get(0);
    }

    public int getIdHanhKiemByName(String tenHanhKiem) throws SQLException {
        String sql = "SELECT HanhKiem_Id FROM HANHKIEM WHERE TenHanhKiem = '" +tenHanhKiem+"'";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) {
            return resultSet.getInt("HanhKiem_Id");
        }
        return 0;
    }

    public void createHanhKiem(HanhKiem hanhKiem) throws SQLException {
        ArrayList<String> columeName = new ArrayList<>();

        columeName.add("TenHanhKiem");

        Object[] value = {hanhKiem.getTenHanhKiem()};

        hanhKiemDAO.create(columeName, value);
    }
    public void deleteHanhKiemId (int id) throws SQLException {
        hanhKiemDAO.deleteId(id);
    }

}

package com.mycompany.quanlydiemtruongthpt.Controller;

import com.mycompany.quanlydiemtruongthpt.Connection.MyConnection;
import com.mycompany.quanlydiemtruongthpt.DAO.KetQuaDAO;
import com.mycompany.quanlydiemtruongthpt.Model.KetQua;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KetQuaCtrl {
    private KetQuaDAO ketQuaDAO;
    public KetQuaCtrl () {
        this.ketQuaDAO = new KetQuaDAO();
    }

    public List<KetQua> getAllKetQua() throws SQLException {
        return ketQuaDAO.getAll();
    }
    public int getIdKetQuaByName(String tenKetQua) throws SQLException {
        String sql = "SELECT KetQua_Id FROM KETQUA WHERE TenKetQua = '" +tenKetQua+"'";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) {
            return resultSet.getInt("KetQua_Id");
        }
        return 0;
    }
    public KetQua getKetQuaId (int id) throws SQLException {
        return ketQuaDAO.findId(id).get(0);
    }

    public void createKetQua(KetQua ketQua) throws SQLException {
        ArrayList<String> columeName = new ArrayList<>();
        columeName.add("TenKetQua");

        Object[] value = {ketQua.getTenKetQua()};
        ketQuaDAO.create(columeName, value);
    }
    public void deleteKetQuaId (int id) throws SQLException {
        ketQuaDAO.deleteId(id);
    }
}

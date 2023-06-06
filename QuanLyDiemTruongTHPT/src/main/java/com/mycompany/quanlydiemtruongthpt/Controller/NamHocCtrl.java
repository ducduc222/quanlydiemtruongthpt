package com.mycompany.quanlydiemtruongthpt.Controller;

import com.mycompany.quanlydiemtruongthpt.Connection.MyConnection;
import com.mycompany.quanlydiemtruongthpt.DAO.NamHocDAO;
import com.mycompany.quanlydiemtruongthpt.Model.HocKy;
import com.mycompany.quanlydiemtruongthpt.Model.Lop;
import com.mycompany.quanlydiemtruongthpt.Model.NamHoc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NamHocCtrl {
    private NamHocDAO namHocDAO;

    public NamHocCtrl() {
        this.namHocDAO = new NamHocDAO();
    }
    public NamHoc getNamHocById (int id) throws SQLException {
        return namHocDAO.findId(id).get(0);
    }
    public List<NamHoc> getAllNamHoc() throws SQLException {
        return namHocDAO.getAll();
    }

    public int getIdNamHocByName(String tenNamHoc) throws SQLException {
        String sql = "SELECT NamHoc_Id FROM NAMHOC WHERE TenNamHoc = '"+tenNamHoc+"'";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) return resultSet.getInt("NamHoc_Id");

        return 0;
    }

    public List<HocKy> getDanhSachHocKyByIdNamHoc (int idNamHoc) throws SQLException {
        String sql = "SELECT * FROM HOCKY WHERE NamHoc_Id = " + idNamHoc;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        List<HocKy> hocKys = new ArrayList<>();
        while (resultSet.next()) {
            HocKy hocKy = new HocKy();
            hocKy.setId(resultSet.getInt("HocKy_Id"));
            hocKy.setTenHocKy(resultSet.getString("TenHocKy"));
            hocKy.setNamHoc_Id(idNamHoc);
            hocKy.setHocKyHienTai(resultSet.getBoolean("HocKyHienTai"));

            hocKys.add(hocKy);
        }

        return hocKys;
    }
}

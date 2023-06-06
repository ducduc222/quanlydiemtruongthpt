package com.mycompany.quanlydiemtruongthpt.Controller;

import com.mycompany.quanlydiemtruongthpt.Connection.MyConnection;
import com.mycompany.quanlydiemtruongthpt.DAO.HanhKiemDAO;
import com.mycompany.quanlydiemtruongthpt.DAO.HocKyDAO;
import com.mycompany.quanlydiemtruongthpt.Model.HanhKiem;
import com.mycompany.quanlydiemtruongthpt.Model.HocKy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HocKyCtrl {
    private HocKyDAO hocKyDAO;
    public HocKyCtrl () {
        this.hocKyDAO = new HocKyDAO();
    }

    public List<HocKy> getAllHocKy() throws SQLException {
        return hocKyDAO.getAll();
    }

    public HocKy getHocKyById (int id) throws SQLException {
        return hocKyDAO.findId(id).get(0);
    }
    public int getIdHocKyByTenHocKy(String tenHocKy) throws SQLException {
        String sql = "SELECT HocKy_Id FROM HOCKY WHERE TenHocKy = '"+tenHocKy +"'";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) return resultSet.getInt("HocKy_Id");
        return 0;
    }

    public void createHocKy(HocKy hocKy) throws SQLException {
        String insertSql = "INSERT INTO HOCKY (TenHocKy, HeSo, NamHoc_Id, HocKyHienTai) VALUES ('"
                +hocKy.getTenHocKy()+"',"+hocKy.getHeSo()+","+hocKy.getNamHoc_Id()+","+hocKy.getHocKyHienTai()+")";

        MyConnection.ExcuteQuerySetTable(insertSql);

        if (!hocKy.getHocKyHienTai()) return;
        String updateHocKyChinh = "UPDATE HOCKY SET HocKyHienTai = 0";
        MyConnection.ExcuteQuerySetTable(updateHocKyChinh);
        String updateNewHocKyChinh = "UPDATE HOCKY SET HocKyHienTai = 1 WHERE TenHocKy = '"+hocKy.getTenHocKy()+"' and NamHoc_Id = "+hocKy.getNamHoc_Id();
        MyConnection.ExcuteQuerySetTable(updateNewHocKyChinh);

    }

    public void updateHocKy(HocKy hocKy) throws SQLException {
        String updateSql = "UPDATE  HOCKY SET TenHocKy = '"+hocKy.getTenHocKy()+"', HeSo = "+hocKy.getHeSo()+", NamHoc_Id = "+hocKy.getNamHoc_Id()
                +", HocKyHienTai = "+hocKy.getHocKyHienTai()+" WHERE HocKy_Id = "+hocKy.getId();

        MyConnection.ExcuteQuerySetTable(updateSql);
        if (!hocKy.getHocKyHienTai()) return;
        String updateHocKyChinh = "UPDATE HOCKY SET HocKyHienTai = 0";
        MyConnection.ExcuteQuerySetTable(updateHocKyChinh);
        String updateNewHocKyChinh = "UPDATE HOCKY SET HocKyHienTai = 1 WHERE HocKy_Id = "+hocKy.getId();
        MyConnection.ExcuteQuerySetTable(updateNewHocKyChinh);

    }
    public void deleteHocKyId (int id) throws SQLException {
        hocKyDAO.deleteId(id);
    }

    public List<HocKy> getHocKyByIdNamHoc (int idNamHoc) throws SQLException {
        String sql = "SELECT * FROM HOCKY WHERE NamHoc_Id = " + idNamHoc;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        List<HocKy> list = new ArrayList<>();
        while (resultSet.next()) {
            int idHocKy = resultSet.getInt("HocKy_Id");
            String tenHocKy = resultSet.getString("TenHocKy");
            Float heso = resultSet.getFloat("HeSo");
            Boolean hocKyHienTai = resultSet.getBoolean("HocKyHienTai");

            HocKy hocKy = new HocKy();
            hocKy.setId(idHocKy);
            hocKy.setTenHocKy(tenHocKy);
            hocKy.setHeSo(heso);
            hocKy.setNamHoc_Id(idNamHoc);
            hocKy.setHocKyHienTai(hocKyHienTai);

            list.add(hocKy);
        }
        return list;
    }


}

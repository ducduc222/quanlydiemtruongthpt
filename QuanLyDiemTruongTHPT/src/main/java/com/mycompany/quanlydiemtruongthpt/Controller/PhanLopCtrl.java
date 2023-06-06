package com.mycompany.quanlydiemtruongthpt.Controller;


import com.mycompany.quanlydiemtruongthpt.Connection.MyConnection;
import com.mycompany.quanlydiemtruongthpt.DAO.PhanLopDAO;

import com.mycompany.quanlydiemtruongthpt.Model.PhanLop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhanLopCtrl {
    private PhanLopDAO phanLopDAO;
    public PhanLopCtrl () {
        this.phanLopDAO = new PhanLopDAO();
    }

    public List<PhanLop> getAllPhanLop() throws SQLException {
        return phanLopDAO.getAll();
    }

    public PhanLop getPhanLopById (int id) throws SQLException {
        return phanLopDAO.findId(id).get(0);
    }

    public void createPhanLop(PhanLop phanLop) throws SQLException {
        ArrayList<String> columeName = new ArrayList<>();
        columeName.add("GiaoVien_Id");
        columeName.add("Lop_Id");


        Object[] value = {phanLop.getGiaoVien_Id(), phanLop.getLop_Id()};
        phanLopDAO.create(columeName, value);
    }
    public void deletePhanLopById (int id) throws SQLException {
        phanLopDAO.deleteId(id);
    }

    public void phanLop(int idGiaoVien, int idLop) {
        String sql = "INSERT INTO PHANLOP (GiaoVien_Id, Lop_Id) VALUES ("+idGiaoVien+","+idLop+")";
        MyConnection.ExcuteQuerySetTable(sql);
    }
}

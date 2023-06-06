package com.mycompany.quanlydiemtruongthpt.Controller;

import com.mycompany.quanlydiemtruongthpt.Connection.MyConnection;
import com.mycompany.quanlydiemtruongthpt.DAO.LopDAO;
import com.mycompany.quanlydiemtruongthpt.Model.HoSoHocSinh;
import com.mycompany.quanlydiemtruongthpt.Model.Lop;
import com.mycompany.quanlydiemtruongthpt.Model.MonHoc;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LopCtrl {
    private LopDAO lopDAO;
    public LopCtrl () {
        this.lopDAO = new LopDAO();
    }

    public List<Lop> getAllLop() throws SQLException {
        return lopDAO.getAll();
    }

    public Lop getLopById (int id) throws SQLException {
        return lopDAO.findId(id).get(0);
    }

    public void createLop(Lop lop) throws SQLException {
        if (lop.getTenLop().equals("")){
            JOptionPane.showMessageDialog(null, "Hãy nhập tên lớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ArrayList<String> columeName = new ArrayList<>();
        columeName.add("TenLop");
        columeName.add("KhoiLop_Id");
        columeName.add("NamHoc_Id");
        columeName.add("GiaoVien_Id");

        Object[] value = {lop.getTenLop(), lop.getKhoiLop_Id(), lop.getNamHoc_Id(), lop.getGiaoVien_Id()};

        lopDAO.create(columeName, value);

    }
    public void deleteLopById (int id) throws SQLException {
        lopDAO.deleteId(id);
    }

    public void updateLop (Lop lop) {
        String sql = "UPDATE LOP SET TenLop = '" + lop.getTenLop() +
                                    "' ,KhoiLop_Id = " + lop.getKhoiLop_Id()+
                                    ",NamHoc_Id = " + lop.getNamHoc_Id() +
                                    ",GiaoVien_Id = " + lop.getGiaoVien_Id() +
                    " WHERE Lop_Id = " + lop.getId();
        MyConnection.ExcuteQuerySetTable(sql);
    }

    public List<HoSoHocSinh> getAllHocSinhByIdLop(int idLop) throws SQLException {
        List<HoSoHocSinh> hoSoHocSinhs = new ArrayList<>();
        String sql = "SELECT * FROM HOSOHOCSINH WHERE Lop_Id = "+idLop;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);

        while (resultSet.next()) {
            HoSoHocSinh hoSoHocSinh = new HoSoHocSinh();
            hoSoHocSinh.setId(resultSet.getInt("HoSoHocSinh_Id"));
            hoSoHocSinh.setHoTen(resultSet.getString("HoTen"));
            hoSoHocSinh.setGioiTinh(resultSet.getString("GioiTinh"));
            hoSoHocSinh.setNgaySinh(resultSet.getString("NgaySinh"));

            hoSoHocSinhs.add(hoSoHocSinh);
        }

        return hoSoHocSinhs;
    }

    public String getTenLopById (int idLop) throws SQLException {
        String sql = "SELECT TenLop FROM LOP WHERE Lop_Id = "+idLop;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) return resultSet.getString("TenLop");
        return "";
    }
    public int getIdLopChuNhiemByIdGiaoVien(int idGiaoVien) throws SQLException {
        String sql = "SELECT Lop_Id FROM LOP WHERE GiaoVien_Id = "+idGiaoVien;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) return resultSet.getInt("Lop_Id");
        return 0;
    }

    public ResultSet getBangDiemHocKyByIdLop(int idLop, int idHocKy) throws SQLException {
        List<MonHoc> monHocs = new MonHocCtrl().getAllMonHoc();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT HOSOHOCSINH.HoTen, HOSOHOCSINH.NgaySinh, HOSOHOCSINH.GioiTinh, DIEMHOCKYMONHOC.HocSinh_Id, ");
        for (int i = 0; i<monHocs.size(); i++) {
            sql.append(" MAX(CASE WHEN MONHOC.TenMonHoc = '")
                    .append(monHocs.get(i).getTenMonHoc())
                    .append("' THEN DIEMHOCKYMONHOC.DiemTrungBinhMon END) AS '")
                    .append(monHocs.get(i).getTenMonHoc())
                    .append("', ");
        }

        sql.append(" KETQUAHOCKY.DiemHocKy ");
        sql.append(" FROM DIEMHOCKYMONHOC ");
        sql.append(" LEFT JOIN KETQUAHOCKY ON KETQUAHOCKY.HocSinh_Id = DIEMHOCKYMONHOC.HocSinh_Id\n" +
                " LEFT JOIN MONHOC ON DIEMHOCKYMONHOC.MonHoc_Id = MONHOC.MonHoc_Id\n" +
                " LEFT JOIN HOSOHOCSINH ON DIEMHOCKYMONHOC.HocSinh_Id = HOSOHOCSINH.HoSoHocSinh_Id\n" +
                " WHERE DIEMHOCKYMONHOC.HocSinh_Id IN (SELECT HoSoHocSinh_Id AS HocSinh_Id FROM HOSOHOCSINH WHERE Lop_Id = "+idLop+") AND DIEMHOCKYMONHOC.HocKy_Id = "+idHocKy+
                " GROUP BY DIEMHOCKYMONHOC.HocSinh_Id;");

        return MyConnection.ExcuteQueryGetTable(sql.toString());
    }

    public ResultSet getKetQuaTheoNamHoc(int idLop, int idNamHoc) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT KETQUAHOCKY.HocSinh_Id, HOSOHOCSINH.HoTen, HOSOHOCSINH.NgaySinh, HOSOHOCSINH.GioiTinh,");

        String getHocKy = " SELECT * FROM HOCKY WHERE NamHoc_Id = "+idNamHoc;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(getHocKy);
        while (resultSet.next()){
            sql.append(" MAX(CASE WHEN HOCKY.TenHocKy = '")
                    .append(resultSet.getString("TenHocKy"))
                    .append("' THEN KETQUAHOCKY.DiemHocKy end) as '")
                    .append(resultSet.getString("TenHocKy"))
                    .append("', ");

        }

        sql.append(" DiemTrungBinhCaNam, TenHanhKiem, TenHocLuc, TenKetQua");
        sql.append(" FROM KETQUAHOCKY\n" +
                " LEFT JOIN KETQUAHOCSINH ON KETQUAHOCKY.HocSinh_Id = KETQUAHOCSINH.HocSinh_Id\n" +
                " LEFT JOIN HOCKY ON KETQUAHOCKY.HocKy_Id = HOCKY.HocKy_Id\n" +
                " LEFT JOIN HOSOHOCSINH ON KETQUAHOCKY.HocSinh_Id = HOSOHOCSINH.HoSoHocSinh_Id\n" +
                " LEFT JOIN HANHKIEM ON KETQUAHOCSINH.HanhKiem_Id = HANHKIEM.HanhKiem_Id\n" +
                " LEFT JOIN HOCLUC ON KETQUAHOCSINH.HocLuc_Id = HOCLUC.HocLuc_Id\n" +
                " LEFT JOIN KETQUA ON KETQUAHOCSINH.KetQua_Id = KETQUA.KetQua_Id "+
                " WHERE KETQUAHOCKY.HocKy_Id IN (SELECT HocKy_Id FROM HOCKY WHERE NamHoc_Id = "+idNamHoc+")\n" +
                " AND KETQUAHOCKY.HocSinh_Id IN (SELECT HoSoHocSinh_Id AS HocSinh_Id FROM HOSOHOCSINH WHERE Lop_Id = "+idLop+")\n" +
                " GROUP BY KETQUAHOCKY.HocSinh_Id;");

        return MyConnection.ExcuteQueryGetTable(sql.toString());
    }

}

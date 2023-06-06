package com.mycompany.quanlydiemtruongthpt.Controller;

import com.mycompany.quanlydiemtruongthpt.Connection.MyConnection;
import com.mycompany.quanlydiemtruongthpt.DAO.GiaoVienDAO;
import com.mycompany.quanlydiemtruongthpt.DAO.LopDAO;
import com.mycompany.quanlydiemtruongthpt.Model.GiaoVien;
import com.mycompany.quanlydiemtruongthpt.Model.Lop;
import com.mycompany.quanlydiemtruongthpt.Session;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GiaoVienCtrl {
    private GiaoVienDAO giaoVienDAO;
    public GiaoVienCtrl () {
        this.giaoVienDAO = new GiaoVienDAO();
    }

    public List<GiaoVien> getAllGiaoVien() throws SQLException {
        return giaoVienDAO.getAll();
    }
    public List<GiaoVien> getListGiaoVienKhongLaChuNhiem() throws SQLException {
        String sql = "SELECT * FROM GIAOVIEN WHERE GiaoVien_Id NOT IN (SELECT GiaoVien_Id FROM LOP);";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        List<GiaoVien> giaoViens = new ArrayList<>();
        while (resultSet.next()) {
            GiaoVien giaoVien = new GiaoVien();
            giaoVien.setId(resultSet.getInt("GiaoVien_Id"));
            giaoVien.setHoTen(resultSet.getString("HoTen"));

            giaoViens.add(giaoVien);
        }
        return giaoViens;
    }
    public GiaoVien getGiaoVienById (int id) throws SQLException {
        return giaoVienDAO.findId(id).get(0);
    }

    public void createGiaoVien(GiaoVien giaoVien) throws SQLException {
        if (giaoVien.getHoTen().equals("")||giaoVien.getSoDienThoai().equals("")||giaoVien.getDiaChi().equals("")){
            JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<String> columeName = new ArrayList<>();
        columeName.add("HoTen");
        columeName.add("GioiTinh");
        columeName.add("NgaySinh");
        columeName.add("DiaChi");
        columeName.add("SoDienThoai");
        columeName.add("DanToc_Id");
        columeName.add("TonGiao_Id");
        columeName.add("MonHoc_Id");

        Object[] value = {giaoVien.getHoTen(), giaoVien.getGioiTinh(), giaoVien.getNgaySinh(), giaoVien.getDiaChi(), giaoVien.getSoDienThoai(), giaoVien.getDanToc_Id(), giaoVien.getTonGiao_Id(), giaoVien.getMonHoc_Id()};

        giaoVienDAO.create(columeName, value);
        new UserCtrl().createAcountForGiaoVien(giaoVien.getHoTen(), giaoVien.getNgaySinh(), giaoVien.getSoDienThoai(), giaoVien.getGioiTinh());
    }
    public void deleteGiaoVienById (int id) throws SQLException {
        int choice = JOptionPane.showConfirmDialog(null, "Xác nhận xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            if (id == Session.getUserIdLogged())
                JOptionPane.showMessageDialog(null, "Không thể xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            else giaoVienDAO.deleteId(id);

        } else {
        }

    }

    public ResultSet getBangDiemByLop (int idGiaoVien, int idMonHoc, int idHocKy, int idLop) throws SQLException {
        String sqlLoaiDiem = "SELECT TenLoaiDiem FROM LOAIDIEM ORDER BY LoaiDiem_Id";
        ResultSet result = MyConnection.ExcuteQueryGetTable(sqlLoaiDiem);

        StringBuilder sb = new StringBuilder();

        while (result.next()) {
            String sql = "MAX(CASE WHEN LD.TenLoaiDiem = '"+result.getString("TenLoaiDiem")
                    + "' THEN D.Diem END) AS " + result.getString("TenLoaiDiem").replaceAll("\\s", "_")
                    + ",";
            sb.append(sql);

        }
        sb.deleteCharAt(sb.length() - 1);


        String chuoiSql = "SELECT DHMH.HocSinh_Id, "+sb.toString()+" FROM DIEMHOCKYMONHOC DHMH\n" +
                "          JOIN DIEM D ON DHMH.DiemHocKyMonHoc_Id = D.DiemHocKyMonHoc_Id\n" +
                "          JOIN LOAIDIEM LD ON D.LoaiDiem_Id = LD.LoaiDiem_Id\n" +
                "          WHERE DHMH.HocKy_Id = "+idHocKy+"\n" +
                "          AND DHMH.MonHoc_Id = " +idMonHoc+
                "          AND DHMH.HocSinh_Id IN (SELECT HoSoHocSinh_Id FROM KETQUAHOCSINH WHERE Lop_Id = "+idLop+") \n" +
                "          GROUP BY DHMH.HocSinh_Id ;";

        return MyConnection.ExcuteQueryGetTable(chuoiSql);

    }


    public List<Lop> getDanhSachLopByIdGiaoVien(int idGiaoVien) throws SQLException {
        String sql = "SELECT * FROM LOP WHERE Lop_Id IN (SELECT Lop_Id FROM PHANLOP WHERE GiaoVien_Id = "+idGiaoVien+")";
        List<Lop> lops = new ArrayList<>();
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        while (resultSet.next()) {
            Lop lop = new Lop();
            lop.setId(resultSet.getInt("Lop_Id"));
            lop.setTenLop(resultSet.getString("TenLop"));
            lops.add(lop);
        }

        return lops;
    }

    public Lop getLopChuNhiem(int idGiaoVien) throws SQLException {
        String sql = "SELECT * FROM LOP WHERE GiaoVien_Id = "+idGiaoVien;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        Lop lop = new Lop();
        if (resultSet.next()) {
            lop.setId(resultSet.getInt("Lop_Id"));
            lop.setTenLop(resultSet.getString("TenLop"));
            lop.setGiaoVien_Id(resultSet.getInt("GiaoVien_Id"));
            lop.setKhoiLop_Id(resultSet.getInt("KhoiLop_Id"));
            lop.setNamHoc_Id(resultSet.getInt("NamHoc_Id"));
            lop.setSiSo(resultSet.getInt("SiSo"));
        }
        return lop;
    }

    public String getTenMonHocIdGiaoVien (int idGiaoVien) throws SQLException {
        String sql= "SELECT TenMonHoc FROM MONHOC WHERE MonHoc_Id = (SELECT MonHoc_Id FROM GIAOVIEN WHERE GiaoVien_Id = "+idGiaoVien+")";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) return resultSet.getString("TenMonHoc");
        return "";
    }

    public int getIdMonHocByIdGiaoVien (int idGiaoVien) throws SQLException {
        String sql = "SELECT MonHoc_Id FROM GIAOVIEN WHERE GiaoVien_Id = "+idGiaoVien;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) return resultSet.getInt("MonHoc_Id");
        return 0;
    }

    public void updateDiemMoi(List<Object[]> objects) throws SQLException {
        for (int i = 0; i<objects.size(); i++) {
            int idHocSinh = (int) objects.get(i)[0];
            int idMonHoc = (int) objects.get(i)[1];
            int idHocKy = (int) objects.get(i)[2];
            int idLoaiDiem = (int) objects.get(i)[3];
            float diemMoi = (float) objects.get(i)[4];

            String sqlGetDiemHocKyMonHocId = "SELECT DiemHocKyMonHoc_Id FROM DIEMHOCKYMONHOC WHERE HocSinh_Id = "+idHocSinh
                    + " AND MonHoc_Id = "+idMonHoc+" AND HocKy_Id = "+idHocKy;

            int idDiemHocKyMonHoc = 0;
            ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sqlGetDiemHocKyMonHocId);
            if (resultSet.next())  idDiemHocKyMonHoc = resultSet.getInt("DiemHocKyMonHoc_Id");

            String sqlUpdateDiem = "UPDATE DIEM SET Diem = " +diemMoi+ " WHERE DiemHocKyMonHoc_Id = " + idDiemHocKyMonHoc
            + " AND LoaiDiem_Id = "+idLoaiDiem;

            MyConnection.ExcuteQuerySetTable(sqlUpdateDiem);
        }
    }


    // tính điểm tổng kết học kỳ của 1 môn học của một lớp trong 1 học kỳ : trung bình các đầu điểm
    public void tinhDiemTongKetHocKyBoMon(int idMonHoc, int idLop, int idHocKy) throws SQLException {
        String sql = "SELECT  HocSinh_Id, MonHoc_Id, HocKy_Id, SUM(DIEM.Diem * HeSo) as Diem\n" +
                "FROM DIEM\n" +
                "LEFT JOIN LOAIDIEM ON DIEM.LoaiDiem_Id = LOAIDIEM.LoaiDiem_Id\n" +
                "LEFT JOIN DIEMHOCKYMONHOC ON DIEMHOCKYMONHOC.DiemHocKyMonHoc_Id = DIEM.DiemHocKyMonHoc_Id\n" +
                "WHERE HocKy_Id = "+idHocKy+" AND MonHoc_Id = "+idMonHoc+" AND HocSinh_Id IN (SELECT HoSoHocSinh_Id AS HocSinh_Id FROM HOSOHOCSINH WHERE Lop_Id = "+idLop+")\n" +
                "GROUP BY DIEM.DiemHocKyMonHoc_Id;";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        while (resultSet.next()) {
            String sqlUpdate = "UPDATE DIEMHOCKYMONHOC SET DiemTrungBinhMon = " +resultSet.getFloat("Diem")
                    +" WHERE HocSinh_Id = "+resultSet.getInt("HocSinh_Id")
                    +" AND MonHoc_Id = "+resultSet.getInt("MonHoc_Id")
                    +" AND HocKy_Id = "+resultSet.getInt("HocKy_Id")+";";
            MyConnection.ExcuteQuerySetTable(sqlUpdate);
        }
    }

    //tính điểm tổng kết của 1 học kỳ: trung bình các môn trong 1 học kỳ
    public void tinhDiemTongKetHocKy(int idLop, int idHocKy) throws SQLException {
        String sql = "SELECT HocSinh_Id,HocKy_Id, SUM(DiemTrungBinhMon*HeSo) / (SELECT SUM(HeSo) FROM MONHOC) as Diem\n" +
                "FROM DIEMHOCKYMONHOC\n" +
                "LEFT JOIN MONHOC ON DIEMHOCKYMONHOC.MonHoc_Id = MONHOC.MonHoc_Id\n" +
                "WHERE HocSinh_Id IN (SELECT HoSoHocSinh_Id AS HocSinh_Id FROM HOSOHOCSINH WHERE Lop_Id = "+idLop+") AND HocKy_Id = "+idHocKy+"\n" +
                "GROUP BY HocSinh_Id, HocKy_Id;";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        while (resultSet.next()) {
            String sqlUpdateKetQuaHocKy = "UPDATE KETQUAHOCKY SET DiemHocKy = "+resultSet.getFloat("Diem")
                    +" WHERE HocSinh_Id = "+resultSet.getInt("HocSinh_Id")
                    +" AND HocKy_Id = "+resultSet.getInt("HocKy_Id");
            MyConnection.ExcuteQuerySetTable(sqlUpdateKetQuaHocKy);
        }

    }
    // tính điểm trung bình 2 kỳ của một môn học trong 1 năm của lớp

    // tính điểm tổng kết năm học: trung bình 13 môn trong 1 năm
    public void tinhDiemTongKetNamHoc (int idLop, int idNamHoc) throws SQLException {
        String tinhDiemCaNam = "SELECT HocSinh_Id,MonHoc_Id, NamHoc_Id,  SUM(DIEMHOCKYMONHOC.DiemTrungBinhMon*HOCKY.HeSo)/(SELECT SUM(HeSo) FROM HOCKY WHERE NamHoc_Id = 1) AS Diem\n" +
                "FROM DIEMHOCKYMONHOC\n" +
                "LEFT JOIN HOCKY ON DIEMHOCKYMONHOC.HocKy_Id = HOCKY.HocKy_Id\n" +
                "WHERE NamHoc_Id = "+idNamHoc+" AND HocSinh_Id IN (SELECT HoSoHocSinh_Id AS HocSinh_Id FROM HOSOHOCSINH WHERE Lop_Id = "+idLop+")\n" +
                "GROUP BY HocSinh_Id, MonHoc_Id, NamHoc_Id\n" +
                ";";
        ResultSet resultSet2 = MyConnection.ExcuteQueryGetTable(tinhDiemCaNam);
        while (resultSet2.next()) {
            String updateDiemCaNam = "UPDATE DIEMCANAM SET DiemTrungBinhMonCaNam = "+resultSet2.getFloat("Diem")
                    + " WHERE HocSinh_Id = "+resultSet2.getInt("HocSinh_Id")
                    + " AND MonHoc_Id = "+resultSet2.getInt("MonHoc_Id")
                    + " AND NamHoc_Id = " + resultSet2.getInt("NamHoc_Id");

            MyConnection.ExcuteQuerySetTable(updateDiemCaNam);
        }


        String sql = "SELECT HocSinh_Id,NamHoc_Id, SUM(DiemTrungBinhMonCaNam*HeSo) / (SELECT SUM(HeSo) FROM MONHOC) as Diem\n" +
                "FROM DIEMCANAM\n" +
                "LEFT JOIN MONHOC ON DIEMCANAM.MonHoc_Id = MONHOC.MonHoc_Id\n" +
                "WHERE HocSinh_Id IN (SELECT HoSoHocSinh_Id AS HocSinh_Id FROM HOSOHOCSINH WHERE Lop_Id = "+idLop+") AND NamHoc_Id = "+idNamHoc+"\n" +
                "GROUP BY HocSinh_Id, NamHoc_Id;";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        while (resultSet.next()) {
            String sqlUpdateKetQuaHocKy = "UPDATE KETQUAHOCSINH SET DiemTrungBinhCaNam = "+resultSet.getFloat("Diem")
                    +" WHERE HocSinh_Id = "+resultSet.getInt("HocSinh_Id")
                    +" AND NamHoc_Id = "+resultSet.getInt("NamHoc_Id");
            MyConnection.ExcuteQuerySetTable(sqlUpdateKetQuaHocKy);
        }
    }


    //-----------------------------------------------------------------------
    // lấy điểm tổng kết học kỳ của 1 môn học (dựa vào idHocSinh, idMonHoc, idHocKy)
    public Float getDiemTongKetHocKyBoMonCuaHocSinh (int idHocSinh, int idMonHoc, String TenHocKy) throws SQLException {
        int idHocKy = new HocKyCtrl().getIdHocKyByTenHocKy(TenHocKy);
        String sql = "SELECT DiemTrungBinhMon FROM DIEMHOCKYMONHOC WHERE HocSinh_Id = " + idHocSinh + " AND MonHoc_Id = "+ idMonHoc+ " AND HocKy_Id = "+idHocKy;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) return resultSet.getFloat("DiemTrungBinhMon");
        return (float) -2;
    }

    // lấy điểm tổng kết các môn của học sinh trong 1 học kỳ
    public Float getDiemTongKetHocKyCua1HocSinh(int idHocSinh, String tenHocKy) throws SQLException {
        int idHocKy = new HocKyCtrl().getIdHocKyByTenHocKy(tenHocKy);
        String sql = "SELECT DiemHocKy FROM KETQUAHOCKY WHERE HocSinh_Id = "+idHocSinh +" AND HocKy_Id = " + idHocKy;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) return resultSet.getFloat("DiemHocKy");

        return (float) 0;
    }

    // Lấy điểm trung bình cả năm của học sinh:
    public Float getDiemTongKetNam( int idHocSinh, int idNamHoc) throws SQLException {
        String sql = "SELECT DiemTrungBinhCaNam FROM KETQUAHOCSINH WHERE HocSinh_Id = "+idHocSinh + " AND NamHoc_Id = "+idNamHoc;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) return resultSet.getFloat("DiemTrungBinhCaNam");
        return (float) -2;
    }

    public ResultSet getKetQuaDanhGiaCuaHocSinh( int idHocSinh, int idNamHoc) {
        String sql = "SELECT TenHocLuc, TenHanhKiem, TenKetQua FROM KETQUAHOCSINH "
                + "LEFT JOIN HOCLUC ON KETQUAHOCSINH.HocLuc_Id = HOCLUC.HocLuc_Id "
                + "LEFT JOIN HANHKIEM ON KETQUAHOCSINH.HanhKiem_Id = HANHKIEM.HanhKiem_Id  "
                + "LEFT JOIN KETQUA ON KETQUAHOCSINH.KetQua_Id = KETQUA.KetQua_Id "
                + " WHERE HocSinh_Id = " +idHocSinh
                +" AND NamHoc_Id = "+idNamHoc;
        return MyConnection.ExcuteQueryGetTable(sql);

    }

    public void updateHanhKiem (Map<Integer, Integer> hanhKiems, int idNamHoc) {
        for (Integer key : hanhKiems.keySet()) {
            StringBuilder sql = new StringBuilder();
            int idHocSinh = key;
            sql.append("UPDATE KETQUAHOCSINH SET HanhKiem_Id = ").append(hanhKiems.get(idHocSinh));

            sql.append(" WHERE HocSinh_Id = ").append(idHocSinh);
            sql.append(" AND NamHoc_Id = ").append(idNamHoc);
            sql.append(";");
            MyConnection.ExcuteQuerySetTable(sql.toString());
        }

    }

    public void danhGiaKetQuaNamHoc(int idLop, int idNamHoc) {
        String sql = "UPDATE KETQUAHOCSINH\n" +
                "SET HocLuc_Id = CASE\n" +
                "    WHEN DiemTrungBinhCaNam > 8 THEN 1\n" +
                "    WHEN DiemTrungBinhCaNam BETWEEN 6.5 AND 7.9 THEN 2\n" +
                "    WHEN DiemTrungBinhCaNam BETWEEN 5 AND 6.4 THEN 3\n" +
                "    WHEN DiemTrungBinhCaNam BETWEEN 3.5 AND 4.9 THEN 4\n" +
                "    ELSE 5\n" +
                "END,\n" +
                "KetQua_Id = CASE\n" +
                "    WHEN HocLuc_Id = 5 THEN 3\n" +
                "    WHEN HanhKiem_Id = 4 THEN 3\n" +
                "    ELSE 1\n" +
                "END\n" +
                "WHERE HocSinh_Id IN (SELECT HoSoHocSinh_Id AS HocSinh_Id FROM HOSOHOCSINH WHERE Lop_Id = "+idLop+") AND NamHoc_Id = "+idNamHoc+";\n";
        MyConnection.ExcuteQuerySetTable(sql);
    }
}

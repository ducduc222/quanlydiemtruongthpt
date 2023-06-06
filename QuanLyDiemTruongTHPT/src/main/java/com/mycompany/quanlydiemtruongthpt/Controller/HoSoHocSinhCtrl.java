package com.mycompany.quanlydiemtruongthpt.Controller;

import com.mycompany.quanlydiemtruongthpt.Connection.MyConnection;
import com.mycompany.quanlydiemtruongthpt.DAO.DAO;
import com.mycompany.quanlydiemtruongthpt.DAO.HoSoHocSinhDAO;
import com.mycompany.quanlydiemtruongthpt.Model.HoSoHocSinh;
import com.mycompany.quanlydiemtruongthpt.Model.LoaiDiem;
import com.mycompany.quanlydiemtruongthpt.Model.MonHoc;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoSoHocSinhCtrl extends DAO<HoSoHocSinh> {
    private HoSoHocSinhDAO hoSoHocSinhDAO;
    public HoSoHocSinhCtrl () {
        this.hoSoHocSinhDAO = new HoSoHocSinhDAO();
    }

    public List<HoSoHocSinh> getAllHoSoHocSinh() throws SQLException {
        return hoSoHocSinhDAO.getAll();
    }

    public HoSoHocSinh getHoSoHocSinhById (int id) throws SQLException {
        return hoSoHocSinhDAO.findId(id).get(0);
    }

    public void createHoSoHocSinh(HoSoHocSinh hoSoHocSinh) throws SQLException {
        ArrayList<String> columeName = new ArrayList<>();
        columeName.add("HoTen");
        columeName.add("GioiTinh");
        columeName.add("NgaySinh");
        columeName.add("NoiSinh");
        columeName.add("DanToc_Id");
        columeName.add("TonGiao_Id");
        columeName.add("HoTenCha");
        columeName.add("NgheNghiepCha");
        columeName.add("NamSinhCha");
        columeName.add("SoDienThoaiCha");
        columeName.add("HoTenMe");
        columeName.add("NgheNghiepMe");
        columeName.add("NamSinhMe");
        columeName.add("SoDienThoaiMe");
        columeName.add("Lop_Id");

        Object[] value = {hoSoHocSinh.getHoTen(), hoSoHocSinh.getGioiTinh(), hoSoHocSinh.getNgaySinh(), hoSoHocSinh.getNoiSinh(), hoSoHocSinh.getDanToc_Id(), hoSoHocSinh.getTonGiao_Id()
        ,hoSoHocSinh.getHoTenCha(), hoSoHocSinh.getNgheNghiepCha(), hoSoHocSinh.getNamSinhCha(), hoSoHocSinh.getSoDienThoaiCha(), hoSoHocSinh.getHoTenMe()
        ,hoSoHocSinh.getNgheNghiepMe(), hoSoHocSinh.getNamSinhMe(), hoSoHocSinh.getSoDienThoaiMe(), hoSoHocSinh.getLop_Id()};

        hoSoHocSinhDAO.create(columeName, value);
        String sqlTest = "SELECT HoSoHocSinh_Id FROM HOSOHOCSINH WHERE HoTen = '"+hoSoHocSinh.getHoTen()+"' AND NgaySinh = '"+hoSoHocSinh.getNgaySinh()
                + "' AND SoDienThoaiCha = '" +hoSoHocSinh.getSoDienThoaiCha()+"'";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sqlTest);
        int idHocSinh = 0;
        if (resultSet.next()) idHocSinh =  resultSet.getInt("HoSoHocSinh_Id");

        String updateLop = "UPDATE LOP SET SiSo = SiSo + 1 WHERE Lop_Id = "+hoSoHocSinh.getLop_Id();
        MyConnection.ExcuteQuerySetTable(updateLop);
        buildKetQuaHocTap(idHocSinh, hoSoHocSinh.getLop_Id());

    }
    public void deleteHocSinhById (int id) throws SQLException {
        hoSoHocSinhDAO.deleteId(id);
        String deleteDIEM = "DELETE FROM DIEM WHERE DiemHocKyMonHoc_Id IN (SELECT DiemHocKyMonHoc_Id FROM DIEMHOCKYMONHOC WHERE HocSinh_Id = "+id+")";
        MyConnection.ExcuteQuerySetTable(deleteDIEM);
        String deleteDIEMHOCKYMONHOC = "DELETE FROM DIEMHOCKYMONHOC WHERE HocSinh_Id = "+id;
        MyConnection.ExcuteQuerySetTable(deleteDIEMHOCKYMONHOC);
        String deleteHOSOHOCSINH = "DELETE FROM HOSOHOCSINH WHERE HoSoHocSinh_Id = "+id;
        MyConnection.ExcuteQuerySetTable(deleteHOSOHOCSINH);
        String deleteKETQUAHOCKY = "DELETE FROM KETQUAHOCKY WHERE HocSinh_Id = "+id;
        MyConnection.ExcuteQuerySetTable(deleteKETQUAHOCKY);
        String deleteKETQUAHOCSINH = "DELETE FROM KETQUAHOCSINH WHERE HocSinh_Id = "+id;
        MyConnection.ExcuteQuerySetTable(deleteKETQUAHOCSINH);
        String deleteDIEMCANAM = "DELETE FROM DIEMCANAM WHERE HocSinh_Id = "+id;
        MyConnection.ExcuteQuerySetTable(deleteDIEMCANAM);
    }

    public void chuyenLop(List<Integer> idHocSinhs, int idLopMoi) throws SQLException {
        for (int i = 0; i < idHocSinhs.size(); i++) {
            int idHocSinh = idHocSinhs.get(i);

            // Giảm sĩ số lớp cũ đi 1
            int idLopCu = 0;
            String getIdLopCu = "SELECT Lop_Id FROM HOSOHOCSINH WHERE HoSoHocSinh_Id = " + idHocSinh;
            ResultSet resultSet = MyConnection.ExcuteQueryGetTable(getIdLopCu);
            if (resultSet.next()) idLopCu = resultSet.getInt("Lop_Id");

            String giamSiSo = "UPDATE LOP SET SiSo = SiSo - 1 WHERE Lop_Id = " + idLopCu;
            MyConnection.ExcuteQuerySetTable(giamSiSo);

            // Chuyển lớp

            String sql1 = "UPDATE HOSOHOCSINH SET Lop_Id = " + idLopMoi + " WHERE HoSoHocSinh_Id = " + idHocSinh;
            hoSoHocSinhDAO.ExcuteQuerySetTable(sql1);

            // cập nhật lớp mới của học sinh trong bảng KETQUAHOCSINH
            String sql2 = "UPDATE KETQUAHOCSINH SET Lop_Id = " + idLopMoi + " WHERE HoSoHocSinh_Id = " + idHocSinh;
            hoSoHocSinhDAO.ExcuteQuerySetTable(sql2);

            // Tăng sĩ số lớp mới lên 1
            String tangSiSo = "UPDATE LOP SET SiSo = SiSo + 1 WHERE Lop_Id = " + idLopMoi;
            MyConnection.ExcuteQuerySetTable(giamSiSo);

        }
    }


    // xây dựng bộ điểm các môn, điểm tổng kết học kỳ, điểm trung bình cả năm
    private void buildKetQuaHocTap ( int HocSinh_Id, int Lop_Id) throws SQLException {
        MonHocCtrl monHocCtrl = new MonHocCtrl();
        List<MonHoc> monHocs = monHocCtrl.getAllMonHoc(); // danh sách môn học

        LoaiDiemCtrl loaiDiemCtrl = new LoaiDiemCtrl();
        List<LoaiDiem> loaiDiems = loaiDiemCtrl.getAllLoaiDiem(); // danh sách loại điểm

        // lấy id học kỳ hiện tại
        int HocKy_Id = 0;
        String sql = "SELECT HocKy_Id FROM HOCKY WHERE HocKyHienTai = 1";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) HocKy_Id = resultSet.getInt("HocKy_Id");
        int idNamHoc = 0;
        String getIdNamHocsql = "SELECT NamHoc_Id FROM HOCKY WHERE HocKy_Id = " +HocKy_Id;
        ResultSet resultSet12 = MyConnection.ExcuteQueryGetTable(getIdNamHocsql);
        if (resultSet12.next()) idNamHoc = resultSet12.getInt("NamHoc_Id");
        for (int i = 0; i < monHocs.size(); i++) {
            String insertDIEMHOCKYMONHOC = "INSERT INTO DIEMHOCKYMONHOC (HocSinh_Id, MonHoc_Id, HocKy_Id, DiemTrungBinhMon) VALUES ("
                    + HocSinh_Id + "," + monHocs.get(i).getId() + "," + HocKy_Id + ", -1)";
            MyConnection.ExcuteQuerySetTable(insertDIEMHOCKYMONHOC);

            int idLastInsertOfDIEMHOCKYMONHOC = 0;
            String getLastIdInsert = "SELECT DiemHocKyMonHoc_Id FROM DIEMHOCKYMONHOC WHERE HocSinh_Id = " + HocSinh_Id + " and MonHoc_Id = " + monHocs.get(i).getId() +" and HocKy_Id = " + HocKy_Id;
            ResultSet resultSet1 = MyConnection.ExcuteQueryGetTable(getLastIdInsert);
            if (resultSet1.next()) idLastInsertOfDIEMHOCKYMONHOC = resultSet1.getInt("DiemHocKyMonHoc_Id");


            StringBuilder insertDIEM = new StringBuilder("INSERT INTO DIEM (DiemHocKyMonHoc_Id, LoaiDiem_Id, Diem) VALUES ");
            for (int j = 0; j < loaiDiems.size(); j++) {
                insertDIEM.append( "("
                        + idLastInsertOfDIEMHOCKYMONHOC + "," + loaiDiems.get(j).getId() + ", -1),");
            }
            insertDIEM.deleteCharAt(insertDIEM.length()-1);

            MyConnection.ExcuteQuerySetTable(insertDIEM.toString());

            String insertDIEMCANAM = "INSERT INTO DIEMCANAM (HocSinh_Id, MonHoc_Id,NamHoc_Id, DiemTrungBinhMonCaNam) VALUES ("
                    + HocSinh_Id + "," + monHocs.get(i).getId() +","+idNamHoc+ ", -1)";
            MyConnection.ExcuteQuerySetTable(insertDIEMCANAM);
        }

        int HanhKiem_Id = new HanhKiemCtrl().getIdHanhKiemByName("Chưa đánh giá");
        int HocLuc_Id = new HocLucCtrl().getIdHocLucByName("Chưa đánh giá");
        int KetQua_Id = new KetQuaCtrl().getIdKetQuaByName("Chưa đánh giá");
        String insertKETQUAHOCKY = "INSERT INTO KETQUAHOCKY(HocSinh_Id, HocKy_Id, DiemHocKy) VALUES ("
                + HocSinh_Id + "," + HocKy_Id + ", -1)";
        MyConnection.ExcuteQuerySetTable(insertKETQUAHOCKY);


        String insertKETQUAHOCSINH = "INSERT INTO KETQUAHOCSINH (HoSoHocSinh_Id, Lop_Id, KetQua_Id, HocLuc_Id, HanhKiem_Id, DiemTrungBinhCaNam, NamHoc_Id) VALUES ("
                + HocSinh_Id + "," + Lop_Id + "," + KetQua_Id + "," + HocLuc_Id + "," + HanhKiem_Id + ", -1,"+idNamHoc+")";

        MyConnection.ExcuteQuerySetTable(insertKETQUAHOCSINH);
    }

}

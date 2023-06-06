package com.mycompany.quanlydiemtruongthpt.Controller;

import com.mycompany.quanlydiemtruongthpt.Connection.MyConnection;
import com.mycompany.quanlydiemtruongthpt.DAO.GiaoVienDAO;
import com.mycompany.quanlydiemtruongthpt.DAO.PhanLopDAO;
import com.mycompany.quanlydiemtruongthpt.DAO.UserDAO;
import com.mycompany.quanlydiemtruongthpt.Model.GiaoVien;
import com.mycompany.quanlydiemtruongthpt.Model.PhanLop;
import com.mycompany.quanlydiemtruongthpt.Model.User;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserCtrl {
    private UserDAO userDAO;
    public UserCtrl () {
        this.userDAO = new UserDAO();
    }

    public List<User> getAllUser() throws SQLException {
        return userDAO.getAll();
    }

    public User getUserById (int id) throws SQLException {
        return userDAO.findId(id).get(0);
    }
    public void createAccount(String username, String password, GiaoVien giaoVien, Boolean isAdmin) throws SQLException {
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


        GiaoVienDAO giaoVienDAO = new GiaoVienDAO();
        giaoVienDAO.create(columeName, value);

        String getIdGiaoVien = "SELECT GiaoVien_Id FROM GIAOVIEN WHERE HoTen = '"+giaoVien.getHoTen()
                + "' AND NgaySinh = '" +giaoVien.getNgaySinh()
                + "' AND SoDienThoai = '"+giaoVien.getSoDienThoai()
                + "' AND MonHoc_Id = "+ giaoVien.getMonHoc_Id();
        int idGiaoVien = 0;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(getIdGiaoVien);
        if (resultSet.next()) idGiaoVien = resultSet.getInt("GiaoVien_Id");

        ArrayList<String> columnNameUser = new ArrayList<>();
        columnNameUser.add("Username");
        columnNameUser.add("Password");
        columnNameUser.add("GiaoVien_Id");
        columnNameUser.add("isAdmin");

        Object[] value2 = {username, password, idGiaoVien, isAdmin};

        userDAO.create(columnNameUser, value2);



        String usernameGV = giaoVien.getSoDienThoai();
        String pass = "123456789";
        JPasswordField jPasswordField = new JPasswordField(pass);
        String passwordGV = Arrays.toString(jPasswordField.getPassword());

        String sqlCreateUser = "INSERT INTO USER (Username, Password, GiaoVien_Id, isAdmin) VALUES ('"
                +username+"', '"+password+"', "+idGiaoVien+", false)";
        MyConnection.ExcuteQuerySetTable(sqlCreateUser);
        String notifical = "Tên đăng nhập TRANG QUẢN LÝ BỘ MÔN: "+username+"\n Mật khẩu: "+pass;
        JOptionPane.showMessageDialog(null, notifical, "Tài khoản mới", JOptionPane.ERROR_MESSAGE);
    }
    public void deleteUserById (int id) throws SQLException {
        userDAO.deleteId(id);
    }

    public int LoginReturnIdGiaoVien (String username, String password) throws SQLException {

        String sql = "SELECT GiaoVien_Id FROM USER WHERE Username = '"+username
                +"' AND Password = '"+password+"'";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);

        if (resultSet.next()) {
            return resultSet.getInt("GiaoVien_Id");
        } else {
            JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu!", "Thông báo", JOptionPane.ERROR_MESSAGE);

        }
        return 0;
    }
    public Boolean isAdmin(String username, String password) throws SQLException {
        String sql = "SELECT isAdmin FROM USER WHERE Username = '"+username
                +"' AND Password = '"+password+"'";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) return resultSet.getBoolean("isAdmin");
        return false;
    }

    public Boolean exitsUser() throws SQLException {
        String sql = "SELECT * FROM USER";
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) return true;
        return false;
    }


    public void createAcountForGiaoVien(String hoTen, String ngaysinh, String sdt, String gioitinh) throws SQLException {
        String getIdGiaoVien = "SELECT GiaoVien_Id FROM GIAOVIEN WHERE HoTen = '"+hoTen
        +"' AND NgaySinh = '"+ngaysinh
        +"' AND SoDienThoai = '"+sdt
        +"' AND GioiTinh = '"+gioitinh+"'";

        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(getIdGiaoVien);
        int idGiaoVien = 0;
        if (resultSet.next()) idGiaoVien = resultSet.getInt("GiaoVien_Id");

        String username = sdt;
        String pass = "123456789";
        JPasswordField jPasswordField = new JPasswordField(pass);
        String password = Arrays.toString(jPasswordField.getPassword());

        String sqlCreateUser = "INSERT INTO USER (Username, Password, GiaoVien_Id, isAdmin) VALUES ('"
                +username+"', '"+password+"', "+idGiaoVien+", false)";
        MyConnection.ExcuteQuerySetTable(sqlCreateUser);
        String notifical = "Tên đăng nhập: "+username+"\n Mật khẩu: "+pass;
        JOptionPane.showMessageDialog(null, notifical, "Tài khoản mới", JOptionPane.ERROR_MESSAGE);

    }
}

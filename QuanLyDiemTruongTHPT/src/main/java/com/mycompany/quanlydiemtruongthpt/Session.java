package com.mycompany.quanlydiemtruongthpt;

import com.mycompany.quanlydiemtruongthpt.Connection.MyConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Session {
    private static int userIdLogged;
    private static int userIdAdmin;
    private static int idLopChuNhiem;
    private static int idMonHocGiangDay;

    public static int getIdMonHocGiangDay() throws SQLException {
        String sql = "SELECT MonHoc_Id FROM GIAOVIEN WHERE GiaoVien_Id = "+userIdLogged;
        ResultSet resultSet = MyConnection.ExcuteQueryGetTable(sql);
        if (resultSet.next()) return resultSet.getInt("MonHoc_Id");
        return 0;
    }

    public static void setIdMonHocGiangDay(int idMonHocGiangDay) {
        Session.idMonHocGiangDay = idMonHocGiangDay;
    }

    public static int getIdLopChuNhiem() {
        return idLopChuNhiem;
    }

    public static void setIdLopChuNhiem(int idLopChuNhiem) {
        Session.idLopChuNhiem = idLopChuNhiem;
    }

    public static int getUserIdLogged() {
        return userIdLogged;
    }

    public static void setUserIdLogged(int userIdLogged) {
        Session.userIdLogged = userIdLogged;
    }

    public static int getUserIdAdmin() {
        return userIdAdmin;
    }

    public static void setUserIdAdmin(int userIdAdmin) {
        Session.userIdAdmin = userIdAdmin;
    }
}

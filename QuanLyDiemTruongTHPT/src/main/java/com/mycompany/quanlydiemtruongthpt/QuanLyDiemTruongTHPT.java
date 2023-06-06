/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quanlydiemtruongthpt;

import com.mycompany.quanlydiemtruongthpt.Controller.LopCtrl;
import com.mycompany.quanlydiemtruongthpt.Controller.UserCtrl;
import com.mycompany.quanlydiemtruongthpt.DAO.LopDAO;
import com.mycompany.quanlydiemtruongthpt.Model.Lop;
import com.mycompany.quanlydiemtruongthpt.UI.Auth.Login;
import com.mycompany.quanlydiemtruongthpt.UI.Auth.RegisterFirst;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nguyenduc
 */
public class QuanLyDiemTruongTHPT {

    public static void main(String[] args) throws SQLException {
        if (new UserCtrl().exitsUser()) {
            Login login = new Login();
            login.setVisible(true);
        } else {
            RegisterFirst registerFirst = new RegisterFirst();
            registerFirst.setVisible(true);
        }
    }
}

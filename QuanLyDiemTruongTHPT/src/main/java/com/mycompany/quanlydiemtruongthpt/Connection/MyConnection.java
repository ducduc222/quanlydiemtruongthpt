package com.mycompany.quanlydiemtruongthpt.Connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnection {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/quanlydiemtruongthpt";
    private static final String DATABASE_USER_NAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static Connection connection;
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
        }
        return connection;
    }

    public static PreparedStatement preparedStatement(String sql, Object...args) throws SQLException{
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("(")){
            pstmt = connection.prepareCall(sql);
        } else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt;
    }
    public static void executeUpdate(String sql, Object... args) throws SQLException {
        try {
            PreparedStatement stmt = preparedStatement(sql, args);
            try {
                stmt.executeUpdate();
            } finally {
                stmt.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static ResultSet ExcuteQueryGetTable(String sql) {
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    public static void ExcuteQuerySetTable(String sql) {
        try {
            Statement stmt = getConnection().createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public static ResultSet executeQuery(String sql, Object... args) {
        PreparedStatement stmt;
        try {
            stmt = preparedStatement(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

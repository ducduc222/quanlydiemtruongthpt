package com.mycompany.quanlydiemtruongthpt.Model;

public class User extends Model{
    private String Username;
    private String Password;
    private Integer GiaoVien_Id;
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getGiaoVien_Id() {
        return GiaoVien_Id;
    }

    public void setGiaoVien_Id(Integer giaoVien_Id) {
        GiaoVien_Id = giaoVien_Id;
    }

    public User() {
    }

    public User(String username, String password, Integer giaoVien_Id) {
        Username = username;
        Password = password;
        GiaoVien_Id = giaoVien_Id;
    }
}

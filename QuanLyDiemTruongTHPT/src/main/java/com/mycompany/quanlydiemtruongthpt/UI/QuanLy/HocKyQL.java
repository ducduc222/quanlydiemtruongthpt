/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.quanlydiemtruongthpt.UI.QuanLy;

import com.mycompany.quanlydiemtruongthpt.Controller.HocKyCtrl;
import com.mycompany.quanlydiemtruongthpt.Controller.NamHocCtrl;
import com.mycompany.quanlydiemtruongthpt.Model.HocKy;
import com.mycompany.quanlydiemtruongthpt.Model.NamHoc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nguyenduc
 */
public class HocKyQL extends javax.swing.JFrame {

    /**
     * Creates new form HocKyQL
     */
    public HocKyQL() throws SQLException {
        hocKyCtrl = new HocKyCtrl();
        namHocCtrl = new NamHocCtrl();


        initComponents();
        //load Combobox năm học:
        jComboBoxNamHoc.removeAllItems();
        List<NamHoc> namHocs = namHocCtrl.getAllNamHoc();
        for (int i = 0; i<namHocs.size(); i++) {
            jComboBoxNamHoc.addItem(namHocs.get(i).getId()+"-"+namHocs.get(i).getTenNamHoc());
        }
        //
        loadDanhSachHocKy();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButtonQuanLyNamHoc = new javax.swing.JButton();
        jButtonThoat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanelQuanLyHocKy = new javax.swing.JPanel();
        jLabelDanhSachHocKy = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDanhSachHocKy = new javax.swing.JTable();
        jButtonSuaHocKy = new javax.swing.JButton();
        jButtonXoaHocKy = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelTenHocKy = new javax.swing.JLabel();
        jTextFieldTenHocKy = new javax.swing.JTextField();
        jLabelHeSo = new javax.swing.JLabel();
        jTextFieldHeSo = new javax.swing.JTextField();
        jLabelNamHoc = new javax.swing.JLabel();
        jComboBoxNamHoc = new javax.swing.JComboBox<>();
        jButtonThemHocKy = new javax.swing.JButton();
        jCheckBoxHocKyMoi = new javax.swing.JCheckBox();
        jPanelQuanLyNamHoc = new javax.swing.JPanel();
        jPanelQuanLyHocKy1 = new javax.swing.JPanel();
        jLabelDanhSachNamHoc = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDanhSachNamHoc = new javax.swing.JTable();
        jButtonSuaNamHoc = new javax.swing.JButton();
        jButtonXoaNamHoc = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelTenNamHoc = new javax.swing.JLabel();
        jTextFieldTenNamHoc = new javax.swing.JTextField();
        jButtonThemNamHoc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ HỌC KỲ-NĂM HỌC");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Quản lý học kỳ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonQuanLyNamHoc.setText("Quản lý năm học");
        jButtonQuanLyNamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuanLyNamHocActionPerformed(evt);
            }
        });

        jButtonThoat.setText("Thoát");
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonQuanLyNamHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonThoat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButtonQuanLyNamHoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonThoat)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.CardLayout());

        jLabelDanhSachHocKy.setText("Danh sách học kỳ:");

        jTableDanhSachHocKy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                    "ID", "Học kỳ", "Hệ số", "Học kỳ hiện tại"
            }
        ));
        danhSachHocKy = (DefaultTableModel) jTableDanhSachHocKy.getModel();
        jTableDanhSachHocKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDanhSachHocKyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDanhSachHocKy);

        jButtonSuaHocKy.setText("Sửa");
        jButtonSuaHocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonSuaHocKyActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jButtonXoaHocKy.setText("Xóa");
        jButtonXoaHocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaHocKyActionPerformed(evt);
            }
        });

        jLabelTenHocKy.setText("Tên học kỳ:");

        jLabelHeSo.setText("Hệ số:");

        jLabelNamHoc.setText("Năm Học:");

        jComboBoxNamHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonThemHocKy.setText("Thêm");
        jButtonThemHocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonThemHocKyActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jCheckBoxHocKyMoi.setText("Học kỳ mới");

        javax.swing.GroupLayout jPanelQuanLyHocKyLayout = new javax.swing.GroupLayout(jPanelQuanLyHocKy);
        jPanelQuanLyHocKy.setLayout(jPanelQuanLyHocKyLayout);
        jPanelQuanLyHocKyLayout.setHorizontalGroup(
            jPanelQuanLyHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQuanLyHocKyLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelQuanLyHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonThemHocKy)
                    .addGroup(jPanelQuanLyHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelQuanLyHocKyLayout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanelQuanLyHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonSuaHocKy)
                                .addComponent(jButtonXoaHocKy)))
                        .addComponent(jLabelDanhSachHocKy)
                        .addComponent(jSeparator1))
                    .addGroup(jPanelQuanLyHocKyLayout.createSequentialGroup()
                        .addGroup(jPanelQuanLyHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTenHocKy)
                            .addComponent(jLabelHeSo)
                            .addComponent(jLabelNamHoc))
                        .addGap(45, 45, 45)
                        .addGroup(jPanelQuanLyHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxHocKyMoi)
                            .addGroup(jPanelQuanLyHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldHeSo, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addComponent(jTextFieldTenHocKy)
                                .addComponent(jComboBoxNamHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanelQuanLyHocKyLayout.setVerticalGroup(
            jPanelQuanLyHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQuanLyHocKyLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelDanhSachHocKy)
                .addGroup(jPanelQuanLyHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelQuanLyHocKyLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelQuanLyHocKyLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButtonSuaHocKy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonXoaHocKy)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelQuanLyHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTenHocKy)
                    .addComponent(jTextFieldTenHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelQuanLyHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHeSo)
                    .addComponent(jTextFieldHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelQuanLyHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNamHoc)
                    .addComponent(jComboBoxNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxHocKyMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonThemHocKy)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.add(jPanelQuanLyHocKy, "QuanLyHocKyCard");

        jLabelDanhSachNamHoc.setText("Danh sách năm học:");

        jTableDanhSachNamHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableDanhSachNamHoc);

        jButtonSuaNamHoc.setText("Sửa");
        jButtonSuaNamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaNamHocActionPerformed(evt);
            }
        });

        jButtonXoaNamHoc.setText("Xóa");
        jButtonXoaNamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaNamHocActionPerformed(evt);
            }
        });

        jLabelTenNamHoc.setText("Tên năm học:");

        jButtonThemNamHoc.setText("Thêm");
        jButtonThemNamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemNamHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelQuanLyHocKy1Layout = new javax.swing.GroupLayout(jPanelQuanLyHocKy1);
        jPanelQuanLyHocKy1.setLayout(jPanelQuanLyHocKy1Layout);
        jPanelQuanLyHocKy1Layout.setHorizontalGroup(
            jPanelQuanLyHocKy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQuanLyHocKy1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelQuanLyHocKy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonThemNamHoc)
                    .addGroup(jPanelQuanLyHocKy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator2)
                        .addGroup(jPanelQuanLyHocKy1Layout.createSequentialGroup()
                            .addGroup(jPanelQuanLyHocKy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelQuanLyHocKy1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanelQuanLyHocKy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonSuaNamHoc)
                                        .addComponent(jButtonXoaNamHoc)))
                                .addComponent(jLabelDanhSachNamHoc))
                            .addGap(104, 104, 104)))
                    .addGroup(jPanelQuanLyHocKy1Layout.createSequentialGroup()
                        .addComponent(jLabelTenNamHoc)
                        .addGap(45, 45, 45)
                        .addComponent(jTextFieldTenNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanelQuanLyHocKy1Layout.setVerticalGroup(
            jPanelQuanLyHocKy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQuanLyHocKy1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelDanhSachNamHoc)
                .addGroup(jPanelQuanLyHocKy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelQuanLyHocKy1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelQuanLyHocKy1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButtonSuaNamHoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonXoaNamHoc)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelQuanLyHocKy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTenNamHoc)
                    .addComponent(jTextFieldTenNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonThemNamHoc)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelQuanLyNamHocLayout = new javax.swing.GroupLayout(jPanelQuanLyNamHoc);
        jPanelQuanLyNamHoc.setLayout(jPanelQuanLyNamHocLayout);
        jPanelQuanLyNamHocLayout.setHorizontalGroup(
            jPanelQuanLyNamHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
            .addGroup(jPanelQuanLyNamHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelQuanLyNamHocLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelQuanLyHocKy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelQuanLyNamHocLayout.setVerticalGroup(
            jPanelQuanLyNamHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
            .addGroup(jPanelQuanLyNamHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelQuanLyNamHocLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelQuanLyHocKy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel2.add(jPanelQuanLyNamHoc, "QuanLyNamHocCard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void loadDanhSachHocKy() throws SQLException {
        if (danhSachHocKy.getRowCount()>0) danhSachHocKy.setRowCount(0);
        List<HocKy> hocKys = hocKyCtrl.getAllHocKy();
        for (int i = 0; i<hocKys.size(); i++) {
            int idHocKy = hocKys.get(i).getId();
            String tenHocKy = hocKys.get(i).getTenHocKy();
            Float heSo = hocKys.get(i).getHeSo();
            Boolean hockychinh = hocKys.get(i).getHocKyHienTai();
            String hockychinhStr = "";
            if (hockychinh) hockychinhStr = "True";
            Object[] row = {idHocKy, tenHocKy, heSo, hockychinh};
            danhSachHocKy.addRow(row);
        }
    }
    private void jButtonSuaHocKyActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_jButtonSuaHocKyActionPerformed
        openSuaHocKy();
        loadDanhSachHocKy();
    }//GEN-LAST:event_jButtonSuaHocKyActionPerformed

    private void jButtonXoaHocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaHocKyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonXoaHocKyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showPanel("QuanLyHocKyCard");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonQuanLyNamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuanLyNamHocActionPerformed
        showPanel("QuanLyNamHocCard");
    }//GEN-LAST:event_jButtonQuanLyNamHocActionPerformed

    private void jButtonThemHocKyActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_jButtonThemHocKyActionPerformed
        if (checkJtext(jTextFieldTenHocKy)) return;
        String tenHocKy = jTextFieldTenHocKy.getText();
        if (isDecimalNumber(jTextFieldHeSo.getText())){
            JOptionPane.showMessageDialog(null, "Hệ số phải là số thập phân", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Float heSo = Float.valueOf(jTextFieldHeSo.getText());

        String strNamHoc = (String) jComboBoxNamHoc.getSelectedItem();
        String[] parts = strNamHoc.split("-");
        int idNamHoc = Integer.parseInt(parts[0].trim());

        Boolean hockychinh = jCheckBoxHocKyMoi.isSelected();

        HocKy hocKy = new HocKy(tenHocKy, heSo, idNamHoc, hockychinh);
        hocKyCtrl.createHocKy(hocKy);


    }//GEN-LAST:event_jButtonThemHocKyActionPerformed
    public void openSuaHocKy() throws SQLException {
        SuaHocKy suaHocKy = new SuaHocKy(idHocKySua);

        suaHocKy.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    loadDanhSachHocKy();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        suaHocKy.setVisible(true);
    }
    private boolean checkJtext(javax.swing.JTextField jText) {
        if (jText.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public static boolean isDecimalNumber(String input) {
        try {
            // Sử dụng phương thức parseDouble để kiểm tra xem có thể chuyển đổi thành số thập phân hay không
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void jButtonSuaNamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaNamHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSuaNamHocActionPerformed

    private void jButtonXoaNamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaNamHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonXoaNamHocActionPerformed

    private void jButtonThemNamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemNamHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonThemNamHocActionPerformed

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        dispose();
        HomeQuanLy homeQuanLy = new HomeQuanLy();
        homeQuanLy.setVisible(true);
    }//GEN-LAST:event_jButtonThoatActionPerformed

    private void jTableDanhSachHocKyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDanhSachHocKyMouseClicked
        int row = jTableDanhSachHocKy.getSelectedRow();
        idHocKySua = (int) jTableDanhSachHocKy.getValueAt(row, 0);

    }//GEN-LAST:event_jTableDanhSachHocKyMouseClicked
    private void showPanel(String panelName) {

        CardLayout layout = (CardLayout) jPanel2.getLayout();
        layout.show(jPanel2, panelName);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HocKyQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HocKyQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HocKyQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HocKyQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HocKyQL().setVisible(true);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonQuanLyNamHoc;
    private javax.swing.JButton jButtonSuaHocKy;
    private javax.swing.JButton jButtonSuaNamHoc;
    private javax.swing.JButton jButtonThemHocKy;
    private javax.swing.JButton jButtonThemNamHoc;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JButton jButtonXoaHocKy;
    private javax.swing.JButton jButtonXoaNamHoc;
    private javax.swing.JCheckBox jCheckBoxHocKyMoi;
    private javax.swing.JComboBox<String> jComboBoxNamHoc;
    private javax.swing.JLabel jLabelDanhSachHocKy;
    private javax.swing.JLabel jLabelDanhSachNamHoc;
    private javax.swing.JLabel jLabelHeSo;
    private javax.swing.JLabel jLabelNamHoc;
    private javax.swing.JLabel jLabelTenHocKy;
    private javax.swing.JLabel jLabelTenNamHoc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelQuanLyHocKy;
    private javax.swing.JPanel jPanelQuanLyHocKy1;
    private javax.swing.JPanel jPanelQuanLyNamHoc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableDanhSachHocKy;
    private javax.swing.JTable jTableDanhSachNamHoc;
    private javax.swing.JTextField jTextFieldHeSo;
    private javax.swing.JTextField jTextFieldTenHocKy;
    private javax.swing.JTextField jTextFieldTenNamHoc;
    // End of variables declaration//GEN-END:variables

    private HocKyCtrl hocKyCtrl;
    private NamHocCtrl namHocCtrl;
    private DefaultTableModel danhSachHocKy;
    private int idHocKySua;
}
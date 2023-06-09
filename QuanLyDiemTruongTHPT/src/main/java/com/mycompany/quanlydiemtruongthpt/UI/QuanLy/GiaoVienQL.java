/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.quanlydiemtruongthpt.UI.QuanLy;

import com.mycompany.quanlydiemtruongthpt.Controller.DanTocCtrl;
import com.mycompany.quanlydiemtruongthpt.Controller.GiaoVienCtrl;
import com.mycompany.quanlydiemtruongthpt.Controller.MonHocCtrl;
import com.mycompany.quanlydiemtruongthpt.Controller.TonGiaoCtrl;
import com.mycompany.quanlydiemtruongthpt.DAO.DanTocDAO;
import com.mycompany.quanlydiemtruongthpt.DAO.GiaoVienDAO;
import com.mycompany.quanlydiemtruongthpt.DAO.MonHocDAO;
import com.mycompany.quanlydiemtruongthpt.DAO.TonGiaoDAO;
import com.mycompany.quanlydiemtruongthpt.Model.DanToc;
import com.mycompany.quanlydiemtruongthpt.Model.GiaoVien;
import com.mycompany.quanlydiemtruongthpt.Model.MonHoc;
import com.mycompany.quanlydiemtruongthpt.Model.TonGiao;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nguyenduc
 */
public class GiaoVienQL extends javax.swing.JFrame {

    /**
     * Creates new form GiaoVienQL
     */
    public GiaoVienQL() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        loadDanhSachGiaoVien();
        loadComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        giaoVienDAO = new GiaoVienDAO();
        giaoVienCtrl = new GiaoVienCtrl();
        danTocDAO = new DanTocDAO();
        danTocCtrl = new DanTocCtrl();
        monHocDAO = new MonHocDAO();
        monHocCtrl = new MonHocCtrl();
        tonGiaoDAO = new TonGiaoDAO();
        tonGiaoCtrl = new TonGiaoCtrl();
        newGiaoVien = new GiaoVien();
        suaGiaoVien = new GiaoVien();


        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDanhSachGiaoVien = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonXemChiTiet = new javax.swing.JButton();
        jButtonChinhSua = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelHoVaTen = new javax.swing.JLabel();
        jTextFieldHoVaTen = new javax.swing.JTextField();
        jLabelGioiTinh = new javax.swing.JLabel();
        jRadioButtonNam = new javax.swing.JRadioButton();
        jRadioButtonNu = new javax.swing.JRadioButton();
        jLabelNgaySinh = new javax.swing.JLabel();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabelDiaChi = new javax.swing.JLabel();
        jTextFieldDiaChi = new javax.swing.JTextField();
        jLabelDanToc = new javax.swing.JLabel();
        jComboBoxDanToc = new javax.swing.JComboBox<>();
        jLabelTonGiao = new javax.swing.JLabel();
        jComboBoxTonGiao = new javax.swing.JComboBox<>();
        jLabelSdt = new javax.swing.JLabel();
        jTextFieldSdt = new javax.swing.JTextField();
        jButtonThemGiaoVien = new javax.swing.JButton();
        jLabelMonGiangDay = new javax.swing.JLabel();
        jComboBoxMonGiangDay = new javax.swing.JComboBox<>();
        jButtonThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ GIÁO VIÊN");
        setAutoRequestFocus(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableDanhSachGiaoVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Môn giảng dạy"
            }
        ));
        jTableDanhSachGiaoVien.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDanhSachGiaoVienMouseClicked(evt);
            }
        });
        danhSachGiaoVien = (DefaultTableModel) jTableDanhSachGiaoVien.getModel();
        jScrollPane1.setViewportView(jTableDanhSachGiaoVien);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setText("Danh sách giáo viên");

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setRollover(true);

        jButtonXemChiTiet.setText("Xem chi tiết");
        jButtonXemChiTiet.setFocusable(false);
        jButtonXemChiTiet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonXemChiTiet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXemChiTietActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonXemChiTiet);

        jButtonChinhSua.setText("Chỉnh sửa");
        jButtonChinhSua.setFocusable(false);
        jButtonChinhSua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonChinhSua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChinhSuaActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonChinhSua);

        jButtonXoa.setText("Xóa");
        jButtonXoa.setFocusable(false);
        jButtonXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonXoaActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        jToolBar1.add(jButtonXoa);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1214, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nhập thông tin giáo viên");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelHoVaTen.setText("Họ và tên:");

        jLabelGioiTinh.setText("Giới tính:");

        buttonGroup1.add(jRadioButtonNam);
        jRadioButtonNam.setSelected(true);
        jRadioButtonNam.setText("Nam");

        buttonGroup1.add(jRadioButtonNu);
        jRadioButtonNu.setText("Nữ");

        jLabelNgaySinh.setText("Ngày sinh:");

        jLabelDiaChi.setText("Địa chỉ");

        jLabelDanToc.setText("Dân tộc:");

        jComboBoxDanToc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        jLabelTonGiao.setText("Tôn giáo:");

        jComboBoxTonGiao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        jLabelSdt.setText("Số điện thoại:");

        jButtonThemGiaoVien.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButtonThemGiaoVien.setText("Thêm giáo viên");
        jButtonThemGiaoVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonThemGiaoVienActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jLabelMonGiangDay.setText("Môn giảng dạy:");

        jComboBoxMonGiangDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonThemGiaoVien)
                .addGap(98, 98, 98))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHoVaTen)
                            .addComponent(jLabelGioiTinh))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButtonNu)
                                .addGap(67, 67, 67))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jTextFieldHoVaTen))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTonGiao)
                        .addGap(60, 60, 60)
                        .addComponent(jComboBoxTonGiao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDiaChi)
                            .addComponent(jLabelNgaySinh)
                            .addComponent(jLabelDanToc))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButtonNam)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxDanToc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSdt)
                            .addComponent(jLabelMonGiangDay))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMonGiangDay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldSdt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonThoat)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHoVaTen)
                    .addComponent(jTextFieldHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelGioiTinh)
                        .addComponent(jRadioButtonNam))
                    .addComponent(jRadioButtonNu, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNgaySinh)
                    .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDiaChi)
                    .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDanToc)
                    .addComponent(jComboBoxDanToc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTonGiao)
                    .addComponent(jComboBoxTonGiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSdt)
                    .addComponent(jTextFieldSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMonGiangDay)
                    .addComponent(jComboBoxMonGiangDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jButtonThemGiaoVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonThoat)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButtonXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXemChiTietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonXemChiTietActionPerformed

    private void jButtonChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChinhSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonChinhSuaActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_jButtonXoaActionPerformed
        giaoVienCtrl.deleteGiaoVienById(idGiaoVienDelete);
        loadDanhSachGiaoVien();
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonThemGiaoVienActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_jButtonThemGiaoVienActionPerformed
        newHoTen = jTextFieldHoVaTen.getText();
        if (jRadioButtonNam.isSelected()) newGioiTinh = "Nam";
        else if (jRadioButtonNu.isSelected()) newGioiTinh = "Nữ";
        Date date = jDateChooserNgaySinh.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        newNgaySinh = dateFormat.format(date);

        newDiaChi = jTextFieldDiaChi.getText();

        String str = null;
        String[] parts = null;

        str = (String) jComboBoxDanToc.getSelectedItem();
        parts = str.split("-");
        newDanToc_Id = Integer.parseInt(parts[0].trim());

        str = (String) jComboBoxTonGiao.getSelectedItem();
        parts = str.split("-");
        newTonGiao_Id = Integer.parseInt(parts[0].trim());

        newSoDienThoai = jTextFieldSdt.getText();

        str = (String) jComboBoxMonGiangDay.getSelectedItem();
        parts = str.split("-");
        newMonHoc_Id = Integer.parseInt(parts[0].trim());

        newGiaoVien.setTonGiao_Id(newTonGiao_Id);
        newGiaoVien.setDiaChi(newDiaChi);
        newGiaoVien.setDanToc_Id(newDanToc_Id);
        newGiaoVien.setGioiTinh(newGioiTinh);
        newGiaoVien.setHoTen(newHoTen);
        newGiaoVien.setNgaySinh(newNgaySinh);
        newGiaoVien.setMonHoc_Id(newMonHoc_Id);
        newGiaoVien.setSoDienThoai(newSoDienThoai);

        giaoVienCtrl.createGiaoVien(newGiaoVien);
        loadDanhSachGiaoVien();
    }//GEN-LAST:event_jButtonThemGiaoVienActionPerformed

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        dispose();
        HomeQuanLy homeQuanLy = new HomeQuanLy();
        homeQuanLy.setVisible(true);
    }//GEN-LAST:event_jButtonThoatActionPerformed

    private void loadDanhSachGiaoVien() throws SQLException {
        if (danhSachGiaoVien.getRowCount()>0) danhSachGiaoVien.setRowCount(0);
        List<GiaoVien> giaoViens = new ArrayList<>();
        giaoViens = giaoVienCtrl.getAllGiaoVien();
        for (int i = 0; i< giaoViens.size(); i++) {
            int id = giaoViens.get(i).getId();
            String hoTen = giaoViens.get(i).getHoTen();
            String gioiTinh = giaoViens.get(i).getGioiTinh();
            String ngaySinh = giaoViens.get(i).getNgaySinh();
            String diaChi = giaoViens.get(i).getDiaChi();
            String sdt = giaoViens.get(i).getSoDienThoai();
            String monGiangDay = monHocCtrl.getMonHocById(giaoViens.get(i).getMonHoc_Id()).getTenMonHoc();

            Object[] row = {id,hoTen,gioiTinh,ngaySinh,diaChi,sdt, monGiangDay };

            danhSachGiaoVien.addRow(row);
        }
    }
    private void jTableDanhSachGiaoVienMouseClicked(java.awt.event.MouseEvent evt) {
        int x = jTableDanhSachGiaoVien.getSelectedRow();
        if (x >= 0){
            idGiaoVienDelete = (int) jTableDanhSachGiaoVien.getValueAt(x, 0);
        }
    }
    private void loadComboBox() throws SQLException {
        List<DanToc> danTocs = danTocCtrl.getAllDanToc();
        for (int i = 0 ; i< danTocs.size(); i++)
        {
            String str =  danTocs.get(i).getId()+"-"+danTocs.get(i).getTenDanToc();
            jComboBoxDanToc.addItem(str);
        }

        List<TonGiao> tonGiaos = tonGiaoCtrl.getAllTonGiao();
        for (int i = 0 ; i< tonGiaos.size(); i++)
        {
            String str =  tonGiaos.get(i).getId()+"-"+tonGiaos.get(i).getTenTonGiao();
            jComboBoxTonGiao.addItem(str);
        }

        List<MonHoc> monHocs = monHocCtrl.getAllMonHoc();
        for (int i = 0 ; i< monHocs.size(); i++)
        {
            String str =  monHocs.get(i).getId()+"-"+monHocs.get(i).getTenMonHoc();
            jComboBoxMonGiangDay.addItem(str);
        }
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
            java.util.logging.Logger.getLogger(GiaoVienQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoVienQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoVienQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoVienQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GiaoVienQL().setVisible(true);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonChinhSua;
    private javax.swing.JButton jButtonThemGiaoVien;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JButton jButtonXemChiTiet;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JComboBox<String> jComboBoxDanToc;
    private javax.swing.JComboBox<String> jComboBoxMonGiangDay;
    private javax.swing.JComboBox<String> jComboBoxTonGiao;
    private com.toedter.calendar.JDateChooser jDateChooserNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelDanToc;
    private javax.swing.JLabel jLabelDiaChi;
    private javax.swing.JLabel jLabelGioiTinh;
    private javax.swing.JLabel jLabelHoVaTen;
    private javax.swing.JLabel jLabelMonGiangDay;
    private javax.swing.JLabel jLabelNgaySinh;
    private javax.swing.JLabel jLabelSdt;
    private javax.swing.JLabel jLabelTonGiao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonNam;
    private javax.swing.JRadioButton jRadioButtonNu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableDanhSachGiaoVien;
    private javax.swing.JTextField jTextFieldDiaChi;
    private javax.swing.JTextField jTextFieldHoVaTen;
    private javax.swing.JTextField jTextFieldSdt;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    private GiaoVienDAO giaoVienDAO;
    private GiaoVienCtrl giaoVienCtrl;
    private DanTocDAO danTocDAO;
    private DanTocCtrl danTocCtrl;
    private MonHocDAO monHocDAO;
    private MonHocCtrl monHocCtrl;
    private TonGiaoDAO tonGiaoDAO;
    private TonGiaoCtrl tonGiaoCtrl;

    private GiaoVien newGiaoVien;
    private String newHoTen;
    private String  newGioiTinh;
    private String  newDiaChi;
    private String  newSoDienThoai;
    private Integer newDanToc_Id;
    private Integer newTonGiao_Id;
    private Integer newMonHoc_Id;
    private String newNgaySinh;
    private GiaoVien suaGiaoVien;
    private int idGiaoVienDelete;
    private String suaHoTen;
    private String  suaGioiTinh;
    private String  suaDiaChi;
    private String  suaSoDienThoai;
    private Integer suaDanToc_Id;
    private Integer suaTonGiao_Id;
    private Integer suaMonHoc_Id;
    private String suaNgaySinh;
    DefaultTableModel danhSachGiaoVien;
}

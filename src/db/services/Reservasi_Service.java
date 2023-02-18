/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.services;

import db.entitas.Reservasi_Entitas;
import db.koneksi.KoneksiDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adisa
 */
public class Reservasi_Service {

    DefaultTableModel model;

    public boolean insert(Reservasi_Entitas reservasi_Entitas) {
        boolean flag = false;

        try {
            Connection connection = KoneksiDB.getConnection();

            PreparedStatement ps = connection.prepareStatement("INSERT INTO `reservasi` "
                    + "(`id_reservasi`, `id_penumpang`, `stasiun_berangkat`, `stasiun_tujuan`, "
                    + "`tanggal_berangkat`,`jam_berangkat`, `jam_tiba`, `waktu_pemesanan`, `id_kereta`) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?);");

            ps.setString(1, reservasi_Entitas.getId_reservasi());
            ps.setString(2, reservasi_Entitas.getId_penumpang());
            ps.setString(3, reservasi_Entitas.getStasiun_berangkat());
            ps.setString(4, reservasi_Entitas.getStasiun_tujuan());
            ps.setDate(5, new Date(reservasi_Entitas.getTanggal_berangkat().getTime()));
            ps.setString(6, reservasi_Entitas.getJam_berangkat());
            ps.setString(7, reservasi_Entitas.getJam_tiba());
            ps.setString(8, reservasi_Entitas.getKereta());

            int i = ps.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Insert Penumpang , karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return flag;
    }

    public boolean update(Reservasi_Entitas reservasi_entitas2) {
        boolean flag = false;
        try {
            Connection connection = KoneksiDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(""
                    + "UPDATE reservasi SET id_penumpang=?, stasiun_berangkat=?, "
                    + "stasiun_tujuan=?, jam_berangkat=?, jam_tiba=?, "
                    + "harga=?, kelas=?, waktu_pemesanan=?, "
                    + "WHERE id_reservasi=?");
            ps.setString(1, reservasi_entitas2.getId_reservasi());
            ps.setString(2, reservasi_entitas2.getId_penumpang());
            ps.setString(3, reservasi_entitas2.getStasiun_berangkat());
            ps.setString(4, reservasi_entitas2.getStasiun_tujuan());
            ps.setString(5, reservasi_entitas2.getJam_berangkat());
            ps.setString(6, reservasi_entitas2.getJam_tiba());
//            ps.setString(7, reservasi_entitas2.getHarga());

            int i = ps.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Update Penumpang, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return flag;
    }

    public boolean delete(String id_reservasi) {
        boolean flag = false;
        try {
            Connection connection = KoneksiDB.getConnection();

            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM reservasi WHERE id_reservasi='" + id_reservasi + "'");

            if (i == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Delete Penumpang, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return flag;
    }

    public DefaultTableModel initTableModel() {
        model = new DefaultTableModel();
        model.addColumn("ID Reservasi");
        model.addColumn("ID Penumpang");
        model.addColumn("Stasiun Berangkat");
        model.addColumn("Stasiun Tujuan");
        model.addColumn("Tanggal Berangkat");
        model.addColumn("Jam Berangkat");
        model.addColumn("Jam Tiba");
        model.addColumn("Kereta");
        model.addColumn("Waktu Pemesanan");

        return model;
    }

    public DefaultTableModel read() {
        initTableModel();
        try {
            Statement stmt = KoneksiDB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select reservasi.id_reservasi, reservasi.tanggal_berangkat, "
                    + "reservasi.jam_berangkat, reservasi.jam_tiba, reservasi.waktu_pemesanan, "
                    + "reservasi.stasiun_berangkat as berangkat, c1.nama_stasiun, "
                    + "reservasi.stasiun_tujuan as tujuan, c2.nama_stasiun, "
                    + "penumpang_ka.nama_penumpang, kereta_api.nama_kereta_api, kereta_api.kelas_kereta "
                    + "from reservasi left join stasiun as c1 ON reservasi.stasiun_berangkat = c1.id_stasiun "
                    + "INNER JOIN stasiun as c2 ON reservasi.stasiun_tujuan = c2.id_stasiun "
                    + "left JOIN penumpang_ka on reservasi.id_penumpang = penumpang_ka.id_penumpang "
                    + "left join kereta_api on reservasi.id_kereta = kereta_api.id_kereta");

            while (rs.next()) {
//                model.addColumn("ID Reservasi");
//                model.addColumn("ID Penumpang");
//                model.addColumn("Stasiun Berangkat");
//                model.addColumn("Stasiun Tujuan");
//                model.addColumn("Tanggal Berangkat");
//                model.addColumn("Jam Berangkat");
//                model.addColumn("Jam Tiba");
//                model.addColumn("Kereta");
//                model.addColumn("Waktu Pemesanan");

                // buat cetak hard copy
                model.addRow(new Object[]{
                    rs.getString("id_reservasi"),
                    rs.getString("nama_penumpang"),
                    rs.getString("berangkat")+" | "+rs.getString("nama_stasiun"),
                    rs.getString("tujuan")+" | "+rs.getString("nama_stasiun"),                    
                    rs.getDate("tanggal_berangkat"),
                    rs.getString("jam_berangkat"),
                    rs.getString("jam_tiba"),
                    rs.getString("nama_kereta_api")+" | "+rs.getString("kelas_kereta"),
                    rs.getTimestamp("waktu_pemesanan")

                });

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Read Penumpang, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return model;
    }

//    public DefaultComboBoxModel modelComboBox() {
//        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
//
//        try {
//            Statement stmt = KoneksiDB.getConnection().createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM reservasi");
//
//            while (rs.next()) {
//                boxModel.addElement(rs.getString("id_stasiun"));
//                boxModel.addElement(rs.getString("nama_stasiun"));
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error @Read Stasiun, karena : " + ex.getMessage(),
//                    "Error", JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
//        }
//        return boxModel;
//    }
}

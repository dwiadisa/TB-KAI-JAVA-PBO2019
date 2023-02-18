/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.services;

import db.entitas.Stasiun_Entitas;
import db.koneksi.KoneksiDB;
import java.sql.Connection;
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
public class Stasiun_Service {

    DefaultTableModel model;

    public boolean insert(Stasiun_Entitas stasiun_Entitas) {
        boolean flag = false;

        try {
            Connection connection = KoneksiDB.getConnection();

            PreparedStatement ps = connection.prepareStatement("INSERT INTO Stasiun VALUES (?, ?)");
            ps.setString(1, stasiun_Entitas.getId_stasiun());
            ps.setString(2, stasiun_Entitas.getNama_stasiun());

            int i = ps.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Insert Stasiun , karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return flag;
    }

    public boolean update(Stasiun_Entitas stasiun_Entitas) {
        boolean flag = false;
        try {
            Connection connection = KoneksiDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE Stasiun SET nama_stasiun=? WHERE id_stasiun=?");
             ps.setString(1, stasiun_Entitas.getId_stasiun());
             ps.setString(2, stasiun_Entitas.getNama_stasiun());
//            ps.setInt(1, kelas_KAI.getHarga());
//            ps.setString(2, kelas_KAI.getId_kelas());

            int i = ps.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Update Stasiun, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return flag;
    }

    public boolean delete(String id_stasiun) {
        boolean flag = false;
        try {
            Connection connection = KoneksiDB.getConnection();

            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM Stasiun WHERE id_stasiun='" + id_stasiun + "'");

            if (i == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Delete Stasiun, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return flag;
    }

    public DefaultTableModel initTableModel() {
        model = new DefaultTableModel();
        model.addColumn("ID Stasiun");
        model.addColumn("Nama Stasiun");

        return model;
    }

    public DefaultTableModel read() {
        initTableModel();
        try {
            Statement stmt = KoneksiDB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM stasiun");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_stasiun"),
                    rs.getString("nama_stasiun")
                });

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Read Stasiun, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return model;
    }

    public DefaultComboBoxModel modelComboBox() {
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();

        try {
            Statement stmt = KoneksiDB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM stasiun");

            while (rs.next()) {
                boxModel.addElement(rs.getString("id_stasiun")+" | "+rs.getString("nama_stasiun"));                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Read Stasiun, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return boxModel;
    }
}

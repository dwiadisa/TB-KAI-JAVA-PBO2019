/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.services;

import db.entitas.Kelas_KAI_Entitas;
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
public class Kelas_KAI_Service {

    DefaultTableModel model;

    public boolean insert(Kelas_KAI_Entitas kelas_KAI) {
        boolean flag = false;

        try {
            Connection connection = KoneksiDB.getConnection();

            PreparedStatement ps = connection.prepareStatement("INSERT INTO kelas_kereta VALUES (?, ?)");
            ps.setString(1, kelas_KAI.getId_kelas());
            ps.setInt(2, kelas_KAI.getHarga());

            int i = ps.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Insert Kelas KAI, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return flag;
    }

    public boolean update(Kelas_KAI_Entitas kelas_KAI) {
        boolean flag = false;
        try {
            Connection connection = KoneksiDB.getConnection();

            PreparedStatement ps = connection.prepareStatement("UPDATE kelas_kereta SET harga=? WHERE id_kelas=?");

            ps.setInt(1, kelas_KAI.getHarga());
            ps.setString(2, kelas_KAI.getId_kelas());

            int i = ps.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Update Kelas KAI, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return flag;
    }

    public boolean delete(String id_kelas_kai) {
        boolean flag = false;
        try {
            Connection connection = KoneksiDB.getConnection();

            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM kelas_kereta WHERE id_kelas='" + id_kelas_kai+"'");

            if (i == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Delete Kelas KAI, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return flag;
    }

    public DefaultTableModel initTableModel() {
        model = new DefaultTableModel();
        model.addColumn("ID Kelas");
        model.addColumn("Harga");

        return model;
    }

    public DefaultTableModel read() {
        initTableModel();
        try {
            Statement stmt = KoneksiDB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM kelas_kereta");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_kelas"),
                    rs.getInt("harga")
                });

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Read Kelas KAI, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return model;
    }
    
    public DefaultComboBoxModel modelComboBox(){
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        
        try {
            Statement stmt = KoneksiDB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM kelas_kereta");

            while (rs.next()) {
                boxModel.addElement(rs.getString("id_kelas"));        
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Read Kereta Api, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }        
        return boxModel;
    }
}

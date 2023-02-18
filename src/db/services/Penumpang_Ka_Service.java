/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.services;

import db.entitas.Penumpang_Ka_Entitas;
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
public class Penumpang_Ka_Service {

    DefaultTableModel model;

    public boolean insert(Penumpang_Ka_Entitas penumpang1) {
        boolean flag = false;

        try {
            Connection connection = KoneksiDB.getConnection();

            PreparedStatement ps = connection.prepareStatement("INSERT INTO penumpang_ka VALUES (?, ?)");
            ps.setString(1, penumpang1.getId_penumpang());
            ps.setString(2, penumpang1.getNama_penumpang());

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

    public boolean update(Penumpang_Ka_Entitas penumpang2) {
        boolean flag = false;
        try {
            Connection connection = KoneksiDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE penumpang_ka SET nama_penumpang=? WHERE id_penumpang=?");
             ps.setString(2, penumpang2.getId_penumpang());
             ps.setString(1, penumpang2.getNama_penumpang());

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

    public boolean delete(String Id_penumpang) {
        boolean flag = false;
        try {
            Connection connection = KoneksiDB.getConnection();

            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM penumpang_ka WHERE id_penumpang='" + Id_penumpang + "'");

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
        model.addColumn("ID Penumpang");
        model.addColumn("Nama Penumpang");

        return model;
    }

    public DefaultTableModel read() {
        initTableModel();
        try {
            Statement stmt = KoneksiDB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM penumpang_ka");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_penumpang"),
                    rs.getString("nama_penumpang")
                });

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Read penumpang, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return model;
    }

    public DefaultComboBoxModel modelComboBox() {
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();

        try {
            Statement stmt = KoneksiDB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM penumpang_ka");

            while (rs.next()) {
                boxModel.addElement(rs.getString("id_penumpang")+" | "+rs.getString("nama_penumpang"));                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Read Penumpang, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return boxModel;
    }
}

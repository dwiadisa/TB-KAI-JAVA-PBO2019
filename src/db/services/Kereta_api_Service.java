package db.services;

import db.entitas.Kereta_Api_Entitas;
import db.entitas.Kereta_Api_Entitas;
import db.koneksi.KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Kereta_api_Service {

    DefaultTableModel model;

    public boolean insert(Kereta_Api_Entitas kereta_api) {
        boolean flag = false;

        try {
            Connection connection = KoneksiDB.getConnection();

            PreparedStatement ps = connection.prepareStatement("INSERT INTO kereta_api VALUES (?, ?, ?)");
            ps.setString(1, kereta_api.getId_kereta());
            ps.setString(2, kereta_api.getNama_kereta_api());
            ps.setString(3, kereta_api.getKelas_kereta());

            int i = ps.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Insert Kereta Api, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return flag;
    }

    public boolean update(Kereta_Api_Entitas kereta_api) {
        boolean flag = false;
        try {
            Connection connection = KoneksiDB.getConnection();

            PreparedStatement ps = connection.prepareStatement("UPDATE kereta_api SET nama_kereta_api=?, kelas_kereta=? WHERE id_kereta=?");

            ps.setString(1, kereta_api.getNama_kereta_api());
            ps.setString(2, kereta_api.getKelas_kereta());
            ps.setString(3, kereta_api.getId_kereta());

            int i = ps.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Update Kereta Api, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return flag;
    }

    public boolean delete(String id_kereta) {
        boolean flag = false;
        try {
            Connection connection = KoneksiDB.getConnection();

            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM kereta_api WHERE id_kereta='" + id_kereta + "'");

            if (i == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Delete Kereta Api, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return flag;
    }

    public DefaultTableModel initTableModel() {
        model = new DefaultTableModel();
        model.addColumn("ID Kereta");
        model.addColumn("Nama Kereta");
        model.addColumn("Kelas");
        model.addColumn("Harga");

        return model;
    }

    public DefaultTableModel read() {
        initTableModel();
        try {
            Statement stmt = KoneksiDB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT kereta_api.*, kelas_kereta.harga FROM `kereta_api` "
                    + "left join kelas_kereta on kereta_api.kelas_kereta = kelas_kereta.id_kelas "
                    + "ORDER BY kereta_api.`id_kereta` ASC");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_kereta"),
                    rs.getString("nama_kereta_api"),
                    rs.getString("kelas_kereta"),
                    rs.getInt("harga")});

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Read Kereta Api, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return model;
    }
    
    public DefaultComboBoxModel modelComboBox() {
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();

        try {
            Statement stmt = KoneksiDB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM kereta_api");

            while (rs.next()) {
                boxModel.addElement(rs.getString("id_kereta")+" | "+rs.getString("nama_kereta_api")+" | "+rs.getString("kelas_kereta"));                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error @Read Kereta, karena : " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return boxModel;
    }

}

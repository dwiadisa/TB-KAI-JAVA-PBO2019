/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.koneksi;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {

    private static Connection koneksi;

    public static Connection getConnection() throws SQLException {
        if (koneksi == null) {
            // panggil Driver MySQL
            new Driver();
            // buat koneksi
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_kai", "root", "");
        }
        return koneksi;
    }

    public static void main(String args[]) {
        try {
            getConnection();
            System.out.println("Koneksi Berhasil");
        } catch (SQLException ex) {
            System.err.println("Koneksi Gagal");
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverpcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Wiwi
 */
public class KoneksiDBXXXX {

    private Connection koneksi;
    private PreparedStatement ps;

    public Connection getKoneksi() {
        if (koneksi == null) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                try {
                    String url = "jdbc:jtds:sqlserver://localhost:1433/PCS4814";
                    koneksi = DriverManager.getConnection(url,"sa","eman");
                    System.out.println("Koneksi Database sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi Database Gagal error:" + se);
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class tidak ditemukan, error: " + cnfe);
                System.exit(0);
            }
        }
        return koneksi;
    }

    public boolean eksekusiNonQuery(String query) {
        try {
            ps = koneksi.prepareStatement(query);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("salah query : " + e);
            return false;
        }
    }

    public ResultSet eksekusiQuery(String query) {
        try {
            ps = koneksi.prepareStatement(query);
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("salah query : " + e);
            return null;
        }
    }
}
//    public boolean eksekusiQuery1(String query, boolean ambilRs) {
//        try {
//            ps = koneksi.prepareStatement(query);
//            if (ambilRs) {
//                setRs(ps.executeQuery());
//            } else {
//                ps.executeUpdate();
//            }
//            return true;
//        } catch (SQLException e) {
//            System.out.println("salah : " + e);
//            return false;
//        }
//    }


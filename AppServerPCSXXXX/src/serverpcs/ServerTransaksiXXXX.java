/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverpcs;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pcs.entitas.Item;
import pcs.entitas.Produk;
import pcs.entitas.Transaksi;
import pcs.remoteclient.RemoteClientLogin;
import pcs.remoteserver.RemoteServerLogin;

import pcs.remoteserver.RemoteServerTransaksi;

/**
 *
 * @author Wiwi
 */
public class ServerTransaksiXXXX extends UnicastRemoteObject
        implements RemoteServerTransaksi, RemoteServerLogin {

    private KoneksiDBXXXX konDB = new KoneksiDBXXXX();
    private String strQuery;
    private boolean statusEksekusi;
    private ResultSet rs;   
    private List list = new ArrayList();
    

    public ServerTransaksiXXXX() throws RemoteException {
        konDB.getKoneksi();
    }

    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here
        Registry reg = LocateRegistry.createRegistry(1100);
        ServerTransaksiXXXX sn = new ServerTransaksiXXXX();
        reg.rebind("ServerTransaksi", sn);

                JOptionPane.showMessageDialog(null,"Aplikasi server Dijalankan");
        String in=null;
     do{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Stop AppServer Dengan input 'stop' :");

        try {
            //in = bf.readLine();
            in = JOptionPane.showInputDialog("Stop AppServer Dengan input 'stop' :");
            if(in.equalsIgnoreCase("stop")){
//                System.out.println("AppServer Dihentikan");
                JOptionPane.showMessageDialog(null,"AppServer Dihentikan");
                System.exit(0);
            }else{
//                System.out.println("kurang benar harus 'stop'");
                JOptionPane.showMessageDialog(null,"kurang benar harus 'stop'");
            }
        } catch (Exception ex) {
//            System.out.println("Input Error :" +ex.getMessage());
            JOptionPane.showMessageDialog(null,"Input Error :"+ex.getMessage());
        }
     }while(in != "stop");
    }

    @Override
    public boolean insertTransaksi(Transaksi tran, List<Item> listItem) throws RemoteException {
        strQuery = "SpInsertTran '"
                + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(tran.getTglNota())
                + "', '" + tran.getKodeMember() + "' ";
        konDB.getKoneksi();
        System.out.println(strQuery);
        rs = konDB.eksekusiQuery(strQuery);
        System.out.println(rs);
        try {
            if (rs.next()) {
                System.out.println("2");
                String nonota = rs.getString(1);
                for (int i = 0; i < listItem.size(); i++) {
                    Item data = new Item();
                    data = listItem.get(i);
                    strQuery = "SpInsertItemTran '" + nonota + "','"
                            + data.getKdProduk() + "'," + data.getBanyak();
                    statusEksekusi = konDB.eksekusiNonQuery(strQuery);
                    System.out.println(statusEksekusi);
                }
            }
        } catch (SQLException se) {
             System.out.println("eksekusi query error:" + se);
            return false;
        }

        return statusEksekusi;
    }

    @Override
    public List selectProduk() throws RemoteException {
        strQuery = "SpTampilDaftarProduk";
        konDB.getKoneksi();
        rs = konDB.eksekusiQuery(strQuery);
        List listData = new ArrayList<Produk>();
        try {
            while (rs.next()) {
                Produk data = new Produk();
                data.setKode(rs.getString(1));
                data.setNama(rs.getString(2));
                data.setHarga(rs.getDouble(3));
                data.setDiskon(rs.getDouble(4));  
                listData.add(data);
            }
            rs.close();
            System.out.println("tampil daftar produk");
            return listData;
        } catch (SQLException se) {
             System.out.println("eksekusi query error:" + se);
            return null;
        }
    }

    @Override
    public int daftarClient(RemoteClientLogin rcl, String nama) throws RemoteException {
        int i = 0;
        System.out.println(nama + " login");
        list.add(rcl);
        i = list.indexOf(rcl);
        System.out.println("Jumlah Client :" + list.size());
        return i;
    }

    @Override
    public void hapusClient(int i, String nama) throws RemoteException {
        System.out.println(nama + " logout");
        list.remove(i);
        for (int j = i; j < list.size(); j++) {
            RemoteClientLogin rcl = (RemoteClientLogin) list.get(j);
            if (rcl != null) {
                rcl.setIClient(i);

            }
        }
        System.out.println("Jumlah Client  :" + list.size());
    }
}

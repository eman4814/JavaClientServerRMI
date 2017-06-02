/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpcstransaksi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import pcs.remoteclient.RemoteClientLogin;
import pcs.remoteserver.RemoteServerLogin;
import pcs.remoteserver.RemoteServerTransaksi;

/**
 * @author Wiwi
 */
public class ClientTransaksiXXXX extends UnicastRemoteObject
        implements RemoteClientLogin {

    Registry registry;
    RemoteServerLogin rsl;
    RemoteServerTransaksi rst;
    FrmTransaksiXXXX form = new FrmTransaksiXXXX();
    int iClient = 0;
    String namaOperator;

    public ClientTransaksiXXXX(String namaOp) throws RemoteException,
            NotBoundException {
        super();
        namaOperator = namaOp;
        registry = LocateRegistry.getRegistry("localhost", 1100);
        rst = (RemoteServerTransaksi) registry.lookup("ServerTransaksi");
        rsl = (RemoteServerLogin) registry.lookup("ServerTransaksi");
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        form.setiFrm(rsl.daftarClient(this, namaOp), namaOp);
        form.setRsl(rsl);
        form.setRst(rst);
    }

    public void setIClient(int i) throws RemoteException {
        form.setiFrm(i+1, namaOperator);
    }
}

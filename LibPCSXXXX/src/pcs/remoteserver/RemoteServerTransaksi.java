/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcs.remoteserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import pcs.entitas.Item;
import pcs.entitas.Transaksi;

/**
 *
 * @author Wiwi
 */
public interface RemoteServerTransaksi extends Remote {

    public boolean insertTransaksi(Transaksi tran,
            List<Item> listItem) throws RemoteException;

    public List selectProduk() throws RemoteException;
}

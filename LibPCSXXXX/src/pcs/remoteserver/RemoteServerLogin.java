package pcs.remoteserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

import pcs.remoteclient.RemoteClientLogin;

/**
 *
 * @author Wiwi
 */
public interface RemoteServerLogin extends Remote {
    public int daftarClient(RemoteClientLogin rcl, String nama) throws RemoteException;
    public void hapusClient(int i, String nama) throws RemoteException;
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcs.remoteclient;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 *
 * @author Wiwi
 */
public interface RemoteClientLogin extends Remote {

    public void setIClient(int i) throws RemoteException;
  
}

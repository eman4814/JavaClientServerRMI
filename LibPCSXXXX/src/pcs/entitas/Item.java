/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcs.entitas;

import java.io.Serializable;

/**
 *
 * @author Wiwi
 */
public class Item implements Serializable {

    private String kdProduk;
    private int banyak;


    public String getKdProduk() {
        return kdProduk;
    }

    public void setKdProduk(String kdProduk) {
        this.kdProduk = kdProduk;
    }

    public int getBanyak() {
        return banyak;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }

    
}

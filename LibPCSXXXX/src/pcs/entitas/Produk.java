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
public class Produk implements Serializable {
    private String kode;
    private String nama;
    private double harga;
    private double diskon;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}

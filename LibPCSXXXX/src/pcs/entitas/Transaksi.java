/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pcs.entitas;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Wiwi
 */
public class Transaksi implements Serializable{
    private String noNota;
    private Date tanggal;
    private String KodeMember;

    public String getKodeMember() {
        return KodeMember;
    }

    public void setKodeMember(String KodeMember) {
        this.KodeMember = KodeMember;
    }

    public String getNoNota() {
        return noNota;
    }

    public void setNoNota(String noNota) {
        this.noNota = noNota;
    }

    public Date getTglNota() {
        return tanggal;
    }

    public void setTglNota(Date tglNota) {
        this.tanggal = tglNota;
    }
    
}

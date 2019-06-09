/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pablo
 */
@Embeddable
public class ItemEntradaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AEENT_NUMERO")
    private String aeentNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MEBIE_ID")
    private String mebieId;

    public ItemEntradaPK() {
    }

    public ItemEntradaPK(String aeentNumero, String mebieId) {
        this.aeentNumero = aeentNumero;
        this.mebieId = mebieId;
    }

    public String getAeentNumero() {
        return aeentNumero;
    }

    public void setAeentNumero(String aeentNumero) {
        this.aeentNumero = aeentNumero;
    }

    public String getMebieId() {
        return mebieId;
    }

    public void setMebieId(String mebieId) {
        this.mebieId = mebieId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aeentNumero != null ? aeentNumero.hashCode() : 0);
        hash += (mebieId != null ? mebieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemEntradaPK)) {
            return false;
        }
        ItemEntradaPK other = (ItemEntradaPK) object;
        if ((this.aeentNumero == null && other.aeentNumero != null) || (this.aeentNumero != null && !this.aeentNumero.equals(other.aeentNumero))) {
            return false;
        }
        if ((this.mebieId == null && other.mebieId != null) || (this.mebieId != null && !this.mebieId.equals(other.mebieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.ItemEntradaPK[ aeentNumero=" + aeentNumero + ", mebieId=" + mebieId + " ]";
    }
    
}

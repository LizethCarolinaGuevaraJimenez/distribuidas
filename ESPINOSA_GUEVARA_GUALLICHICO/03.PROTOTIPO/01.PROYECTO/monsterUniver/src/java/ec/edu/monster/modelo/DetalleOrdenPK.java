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
public class DetalleOrdenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CEORD_NUMERO")
    private String ceordNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CESOL_NUMERO")
    private String cesolNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MEBIE_ID")
    private String mebieId;

    public DetalleOrdenPK() {
    }

    public DetalleOrdenPK(String ceordNumero, String cesolNumero, String mebieId) {
        this.ceordNumero = ceordNumero;
        this.cesolNumero = cesolNumero;
        this.mebieId = mebieId;
    }

    public String getCeordNumero() {
        return ceordNumero;
    }

    public void setCeordNumero(String ceordNumero) {
        this.ceordNumero = ceordNumero;
    }

    public String getCesolNumero() {
        return cesolNumero;
    }

    public void setCesolNumero(String cesolNumero) {
        this.cesolNumero = cesolNumero;
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
        hash += (ceordNumero != null ? ceordNumero.hashCode() : 0);
        hash += (cesolNumero != null ? cesolNumero.hashCode() : 0);
        hash += (mebieId != null ? mebieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOrdenPK)) {
            return false;
        }
        DetalleOrdenPK other = (DetalleOrdenPK) object;
        if ((this.ceordNumero == null && other.ceordNumero != null) || (this.ceordNumero != null && !this.ceordNumero.equals(other.ceordNumero))) {
            return false;
        }
        if ((this.cesolNumero == null && other.cesolNumero != null) || (this.cesolNumero != null && !this.cesolNumero.equals(other.cesolNumero))) {
            return false;
        }
        if ((this.mebieId == null && other.mebieId != null) || (this.mebieId != null && !this.mebieId.equals(other.mebieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.DetalleOrdenPK[ ceordNumero=" + ceordNumero + ", cesolNumero=" + cesolNumero + ", mebieId=" + mebieId + " ]";
    }
    
}

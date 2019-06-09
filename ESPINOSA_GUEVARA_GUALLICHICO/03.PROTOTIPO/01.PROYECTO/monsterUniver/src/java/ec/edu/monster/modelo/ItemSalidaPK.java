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
public class ItemSalidaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PEEMP_ID")
    private String peempId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AESAL_NUMERO")
    private String aesalNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MEBIE_ID")
    private String mebieId;

    public ItemSalidaPK() {
    }

    public ItemSalidaPK(String peempId, String aesalNumero, String mebieId) {
        this.peempId = peempId;
        this.aesalNumero = aesalNumero;
        this.mebieId = mebieId;
    }

    public String getPeempId() {
        return peempId;
    }

    public void setPeempId(String peempId) {
        this.peempId = peempId;
    }

    public String getAesalNumero() {
        return aesalNumero;
    }

    public void setAesalNumero(String aesalNumero) {
        this.aesalNumero = aesalNumero;
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
        hash += (peempId != null ? peempId.hashCode() : 0);
        hash += (aesalNumero != null ? aesalNumero.hashCode() : 0);
        hash += (mebieId != null ? mebieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemSalidaPK)) {
            return false;
        }
        ItemSalidaPK other = (ItemSalidaPK) object;
        if ((this.peempId == null && other.peempId != null) || (this.peempId != null && !this.peempId.equals(other.peempId))) {
            return false;
        }
        if ((this.aesalNumero == null && other.aesalNumero != null) || (this.aesalNumero != null && !this.aesalNumero.equals(other.aesalNumero))) {
            return false;
        }
        if ((this.mebieId == null && other.mebieId != null) || (this.mebieId != null && !this.mebieId.equals(other.mebieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.ItemSalidaPK[ peempId=" + peempId + ", aesalNumero=" + aesalNumero + ", mebieId=" + mebieId + " ]";
    }
    
}

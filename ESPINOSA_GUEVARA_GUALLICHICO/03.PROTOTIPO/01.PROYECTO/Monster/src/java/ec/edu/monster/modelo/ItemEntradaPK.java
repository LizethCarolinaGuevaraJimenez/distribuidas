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
 * @author Jonathan
 */
@Embeddable
public class ItemEntradaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BIEN_ID")
    private String bienId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ENT_NUMERO")
    private String entNumero;

    public ItemEntradaPK() {
    }

    public ItemEntradaPK(String bienId, String entNumero) {
        this.bienId = bienId;
        this.entNumero = entNumero;
    }

    public String getBienId() {
        return bienId;
    }

    public void setBienId(String bienId) {
        this.bienId = bienId;
    }

    public String getEntNumero() {
        return entNumero;
    }

    public void setEntNumero(String entNumero) {
        this.entNumero = entNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bienId != null ? bienId.hashCode() : 0);
        hash += (entNumero != null ? entNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemEntradaPK)) {
            return false;
        }
        ItemEntradaPK other = (ItemEntradaPK) object;
        if ((this.bienId == null && other.bienId != null) || (this.bienId != null && !this.bienId.equals(other.bienId))) {
            return false;
        }
        if ((this.entNumero == null && other.entNumero != null) || (this.entNumero != null && !this.entNumero.equals(other.entNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.ItemEntradaPK[ bienId=" + bienId + ", entNumero=" + entNumero + " ]";
    }
    
}

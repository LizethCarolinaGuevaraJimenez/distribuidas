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
public class ItemSolicitudPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SOL_NUMERO")
    private String solNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BIEN_ID")
    private String bienId;

    public ItemSolicitudPK() {
    }

    public ItemSolicitudPK(String solNumero, String bienId) {
        this.solNumero = solNumero;
        this.bienId = bienId;
    }

    public String getSolNumero() {
        return solNumero;
    }

    public void setSolNumero(String solNumero) {
        this.solNumero = solNumero;
    }

    public String getBienId() {
        return bienId;
    }

    public void setBienId(String bienId) {
        this.bienId = bienId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solNumero != null ? solNumero.hashCode() : 0);
        hash += (bienId != null ? bienId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemSolicitudPK)) {
            return false;
        }
        ItemSolicitudPK other = (ItemSolicitudPK) object;
        if ((this.solNumero == null && other.solNumero != null) || (this.solNumero != null && !this.solNumero.equals(other.solNumero))) {
            return false;
        }
        if ((this.bienId == null && other.bienId != null) || (this.bienId != null && !this.bienId.equals(other.bienId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.ItemSolicitudPK[ solNumero=" + solNumero + ", bienId=" + bienId + " ]";
    }
    
}

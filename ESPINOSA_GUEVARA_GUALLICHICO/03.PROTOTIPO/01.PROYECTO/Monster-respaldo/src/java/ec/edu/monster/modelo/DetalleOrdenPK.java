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

/**
 *
 * @author Administrator
 */
@Embeddable
public class DetalleOrdenPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOL_NUMERO")
    private String solNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIEN_ID")
    private String bienId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORD_NUMERO")
    private String ordNumero;

    public DetalleOrdenPK() {
    }

    public DetalleOrdenPK(String solNumero, String bienId, String ordNumero) {
        this.solNumero = solNumero;
        this.bienId = bienId;
        this.ordNumero = ordNumero;
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

    public String getOrdNumero() {
        return ordNumero;
    }

    public void setOrdNumero(String ordNumero) {
        this.ordNumero = ordNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += Integer.parseInt(solNumero);
        hash += Integer.parseInt(bienId);
        hash += Integer.parseInt(ordNumero); 
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOrdenPK)) {
            return false;
        }
        DetalleOrdenPK other = (DetalleOrdenPK) object;
        if (!this.solNumero.equals(other.solNumero)) {
            return false;
        }
        if (!this.bienId.equals(other.bienId)) {
            return false;
        }
        if (!this.ordNumero.equals(other.ordNumero)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.DetalleOrdenPK[ solNumero=" + solNumero + ", bienId=" + bienId + ", ordNumero=" + ordNumero + " ]";
    }
    
}

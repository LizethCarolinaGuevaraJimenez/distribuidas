/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "medet_detord")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedetDetord.findAll", query = "SELECT m FROM DetalleOrden m"),
    @NamedQuery(name = "MedetDetord.findBySolNumero", query = "SELECT m FROM DetalleOrden m WHERE m.DetalleOrdenPK.solNumero = :solNumero"),
    @NamedQuery(name = "MedetDetord.findByBienId", query = "SELECT m FROM DetalleOrden m WHERE m.DetalleOrdenPK.bienId = :bienId"),
    @NamedQuery(name = "MedetDetord.findByOrdNumero", query = "SELECT m FROM DetalleOrden m WHERE m.DetalleOrdenPK.ordNumero = :ordNumero")})
public class DetalleOrden implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleOrdenPK DetalleOrdenPK;

    public DetalleOrden() {
    }

    public DetalleOrden(DetalleOrdenPK medetDetordPK) {
        this.DetalleOrdenPK = medetDetordPK;
    }

    public DetalleOrden(String solNumero, String bienId, String ordNumero) {
        this.DetalleOrdenPK = new DetalleOrdenPK(solNumero, bienId, ordNumero);
    }

    public DetalleOrdenPK getDetalleOrdenPK() {
        return DetalleOrdenPK;
    }

    public void setDetalleOrdenPK(DetalleOrdenPK DetalleOrdenPK) {
        this.DetalleOrdenPK = DetalleOrdenPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (DetalleOrdenPK != null ? DetalleOrdenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOrden)) {
            return false;
        }
        DetalleOrden other = (DetalleOrden) object;
        if ((this.DetalleOrdenPK == null && other.DetalleOrdenPK != null) || (this.DetalleOrdenPK != null && !this.DetalleOrdenPK.equals(other.DetalleOrdenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.DetalleOrden[ DetalleOrdenPK=" + DetalleOrdenPK + " ]";
    }
    
}

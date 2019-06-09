/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "cedet_detord")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleOrden.findAll", query = "SELECT d FROM DetalleOrden d")
    , @NamedQuery(name = "DetalleOrden.findByCeordNumero", query = "SELECT d FROM DetalleOrden d WHERE d.detalleOrdenPK.ceordNumero = :ceordNumero")
    , @NamedQuery(name = "DetalleOrden.findByCesolNumero", query = "SELECT d FROM DetalleOrden d WHERE d.detalleOrdenPK.cesolNumero = :cesolNumero")
    , @NamedQuery(name = "DetalleOrden.findByMebieId", query = "SELECT d FROM DetalleOrden d WHERE d.detalleOrdenPK.mebieId = :mebieId")
    , @NamedQuery(name = "DetalleOrden.findByCedetFirma", query = "SELECT d FROM DetalleOrden d WHERE d.cedetFirma = :cedetFirma")})
public class DetalleOrden implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleOrdenPK detalleOrdenPK;
    @Size(max = 50)
    @Column(name = "CEDET_FIRMA")
    private String cedetFirma;
    @JoinColumns({
        @JoinColumn(name = "CESOL_NUMERO", referencedColumnName = "CESOL_NUMERO", insertable = false, updatable = false)
        , @JoinColumn(name = "MEBIE_ID", referencedColumnName = "MEBIE_ID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ItemSolicitud itemSolicitud;
    @JoinColumn(name = "CEORD_NUMERO", referencedColumnName = "CEORD_NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrdenContractual ordenContractual;

    public DetalleOrden() {
    }

    public DetalleOrden(DetalleOrdenPK detalleOrdenPK) {
        this.detalleOrdenPK = detalleOrdenPK;
    }

    public DetalleOrden(String ceordNumero, String cesolNumero, String mebieId) {
        this.detalleOrdenPK = new DetalleOrdenPK(ceordNumero, cesolNumero, mebieId);
    }

    public DetalleOrdenPK getDetalleOrdenPK() {
        return detalleOrdenPK;
    }

    public void setDetalleOrdenPK(DetalleOrdenPK detalleOrdenPK) {
        this.detalleOrdenPK = detalleOrdenPK;
    }

    public String getCedetFirma() {
        return cedetFirma;
    }

    public void setCedetFirma(String cedetFirma) {
        this.cedetFirma = cedetFirma;
    }

    public ItemSolicitud getItemSolicitud() {
        return itemSolicitud;
    }

    public void setItemSolicitud(ItemSolicitud itemSolicitud) {
        this.itemSolicitud = itemSolicitud;
    }

    public OrdenContractual getOrdenContractual() {
        return ordenContractual;
    }

    public void setOrdenContractual(OrdenContractual ordenContractual) {
        this.ordenContractual = ordenContractual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleOrdenPK != null ? detalleOrdenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOrden)) {
            return false;
        }
        DetalleOrden other = (DetalleOrden) object;
        if ((this.detalleOrdenPK == null && other.detalleOrdenPK != null) || (this.detalleOrdenPK != null && !this.detalleOrdenPK.equals(other.detalleOrdenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.DetalleOrden[ detalleOrdenPK=" + detalleOrdenPK + " ]";
    }
    
}

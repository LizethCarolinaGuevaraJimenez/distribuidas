/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "ceord_ordcon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenContractual.findAll", query = "SELECT o FROM OrdenContractual o")
    , @NamedQuery(name = "OrdenContractual.findByOrdNumero", query = "SELECT o FROM OrdenContractual o WHERE o.ordNumero = :ordNumero")
    , @NamedQuery(name = "OrdenContractual.findByOrdFechaorden", query = "SELECT o FROM OrdenContractual o WHERE o.ordFechaorden = :ordFechaorden")
    , @NamedQuery(name = "OrdenContractual.findByOrdFechaentrega", query = "SELECT o FROM OrdenContractual o WHERE o.ordFechaentrega = :ordFechaentrega")
    , @NamedQuery(name = "OrdenContractual.findByOrdMontototal", query = "SELECT o FROM OrdenContractual o WHERE o.ordMontototal = :ordMontototal")
    , @NamedQuery(name = "OrdenContractual.findByOrdAprovaciondirectorfinanciero", query = "SELECT o FROM OrdenContractual o WHERE o.ordAprovaciondirectorfinanciero = :ordAprovaciondirectorfinanciero")})
public class OrdenContractual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ORD_NUMERO")
    private String ordNumero;
    @Column(name = "ORD_FECHAORDEN")
    @Temporal(TemporalType.DATE)
    private Date ordFechaorden;
    @Column(name = "ORD_FECHAENTREGA")
    @Temporal(TemporalType.DATE)
    private Date ordFechaentrega;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ORD_MONTOTOTAL")
    private Float ordMontototal;
    @Column(name = "ORD_APROVACIONDIRECTORFINANCIERO")
    private Boolean ordAprovaciondirectorfinanciero;
    @ManyToMany(mappedBy = "ordenContractualCollection")
    private Collection<ItemSolicitud> itemSolicitudCollection;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne(optional = false)
    private Proveedor proId;

    public OrdenContractual() {
    }

    public OrdenContractual(String ordNumero) {
        this.ordNumero = ordNumero;
    }

    public String getOrdNumero() {
        return ordNumero;
    }

    public void setOrdNumero(String ordNumero) {
        this.ordNumero = ordNumero;
    }

    public Date getOrdFechaorden() {
        return ordFechaorden;
    }

    public void setOrdFechaorden(Date ordFechaorden) {
        this.ordFechaorden = ordFechaorden;
    }

    public Date getOrdFechaentrega() {
        return ordFechaentrega;
    }

    public void setOrdFechaentrega(Date ordFechaentrega) {
        this.ordFechaentrega = ordFechaentrega;
    }

    public Float getOrdMontototal() {
        return ordMontototal;
    }

    public void setOrdMontototal(Float ordMontototal) {
        this.ordMontototal = ordMontototal;
    }

    public Boolean getOrdAprovaciondirectorfinanciero() {
        return ordAprovaciondirectorfinanciero;
    }

    public void setOrdAprovaciondirectorfinanciero(Boolean ordAprovaciondirectorfinanciero) {
        this.ordAprovaciondirectorfinanciero = ordAprovaciondirectorfinanciero;
    }

    @XmlTransient
    public Collection<ItemSolicitud> getItemSolicitudCollection() {
        return itemSolicitudCollection;
    }

    public void setItemSolicitudCollection(Collection<ItemSolicitud> itemSolicitudCollection) {
        this.itemSolicitudCollection = itemSolicitudCollection;
    }

    public Proveedor getProId() {
        return proId;
    }

    public void setProId(Proveedor proId) {
        this.proId = proId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordNumero != null ? ordNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenContractual)) {
            return false;
        }
        OrdenContractual other = (OrdenContractual) object;
        if ((this.ordNumero == null && other.ordNumero != null) || (this.ordNumero != null && !this.ordNumero.equals(other.ordNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.OrdenContractual[ ordNumero=" + ordNumero + " ]";
    }
    
}

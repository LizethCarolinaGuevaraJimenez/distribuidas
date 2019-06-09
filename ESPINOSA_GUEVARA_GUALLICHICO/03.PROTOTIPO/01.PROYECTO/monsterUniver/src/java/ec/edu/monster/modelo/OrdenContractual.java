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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "ceord_ordcon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenContractual.findAll", query = "SELECT o FROM OrdenContractual o")
    , @NamedQuery(name = "OrdenContractual.findByCeordNumero", query = "SELECT o FROM OrdenContractual o WHERE o.ceordNumero = :ceordNumero")
    , @NamedQuery(name = "OrdenContractual.findByCeordFechaord", query = "SELECT o FROM OrdenContractual o WHERE o.ceordFechaord = :ceordFechaord")
    , @NamedQuery(name = "OrdenContractual.findByCeordFechentrega", query = "SELECT o FROM OrdenContractual o WHERE o.ceordFechentrega = :ceordFechentrega")
    , @NamedQuery(name = "OrdenContractual.findByCeordMontotal", query = "SELECT o FROM OrdenContractual o WHERE o.ceordMontotal = :ceordMontotal")
    , @NamedQuery(name = "OrdenContractual.findByCeordAprobdirfinanciero", query = "SELECT o FROM OrdenContractual o WHERE o.ceordAprobdirfinanciero = :ceordAprobdirfinanciero")})
public class OrdenContractual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CEORD_NUMERO")
    private String ceordNumero;
    @Column(name = "CEORD_FECHAORD")
    @Temporal(TemporalType.DATE)
    private Date ceordFechaord;
    @Column(name = "CEORD_FECHENTREGA")
    @Temporal(TemporalType.DATE)
    private Date ceordFechentrega;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CEORD_MONTOTAL")
    private Float ceordMontotal;
    @Column(name = "CEORD_APROBDIRFINANCIERO")
    private Boolean ceordAprobdirfinanciero;
    @JoinColumn(name = "AEPRO_ID", referencedColumnName = "AEPRO_ID")
    @ManyToOne(optional = false)
    private Proveedor aeproId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenContractual")
    private Collection<DetalleOrden> detalleOrdenCollection;

    public OrdenContractual() {
    }

    public OrdenContractual(String ceordNumero) {
        this.ceordNumero = ceordNumero;
    }

    public String getCeordNumero() {
        return ceordNumero;
    }

    public void setCeordNumero(String ceordNumero) {
        this.ceordNumero = ceordNumero;
    }

    public Date getCeordFechaord() {
        return ceordFechaord;
    }

    public void setCeordFechaord(Date ceordFechaord) {
        this.ceordFechaord = ceordFechaord;
    }

    public Date getCeordFechentrega() {
        return ceordFechentrega;
    }

    public void setCeordFechentrega(Date ceordFechentrega) {
        this.ceordFechentrega = ceordFechentrega;
    }

    public Float getCeordMontotal() {
        return ceordMontotal;
    }

    public void setCeordMontotal(Float ceordMontotal) {
        this.ceordMontotal = ceordMontotal;
    }

    public Boolean getCeordAprobdirfinanciero() {
        return ceordAprobdirfinanciero;
    }

    public void setCeordAprobdirfinanciero(Boolean ceordAprobdirfinanciero) {
        this.ceordAprobdirfinanciero = ceordAprobdirfinanciero;
    }

    public Proveedor getAeproId() {
        return aeproId;
    }

    public void setAeproId(Proveedor aeproId) {
        this.aeproId = aeproId;
    }

    @XmlTransient
    public Collection<DetalleOrden> getDetalleOrdenCollection() {
        return detalleOrdenCollection;
    }

    public void setDetalleOrdenCollection(Collection<DetalleOrden> detalleOrdenCollection) {
        this.detalleOrdenCollection = detalleOrdenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ceordNumero != null ? ceordNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenContractual)) {
            return false;
        }
        OrdenContractual other = (OrdenContractual) object;
        if ((this.ceordNumero == null && other.ceordNumero != null) || (this.ceordNumero != null && !this.ceordNumero.equals(other.ceordNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.OrdenContractual[ ceordNumero=" + ceordNumero + " ]";
    }
    
}

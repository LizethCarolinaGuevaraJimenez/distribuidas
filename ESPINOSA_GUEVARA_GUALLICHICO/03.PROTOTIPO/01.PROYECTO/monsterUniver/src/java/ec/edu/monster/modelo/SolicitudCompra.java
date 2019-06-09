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
@Table(name = "cesol_solcom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudCompra.findAll", query = "SELECT s FROM SolicitudCompra s")
    , @NamedQuery(name = "SolicitudCompra.findByCesolNumero", query = "SELECT s FROM SolicitudCompra s WHERE s.cesolNumero = :cesolNumero")
    , @NamedQuery(name = "SolicitudCompra.findByCesolFecha", query = "SELECT s FROM SolicitudCompra s WHERE s.cesolFecha = :cesolFecha")
    , @NamedQuery(name = "SolicitudCompra.findByCesolAprovdirefinancier", query = "SELECT s FROM SolicitudCompra s WHERE s.cesolAprovdirefinancier = :cesolAprovdirefinancier")
    , @NamedQuery(name = "SolicitudCompra.findByCesolAprojefearea", query = "SELECT s FROM SolicitudCompra s WHERE s.cesolAprojefearea = :cesolAprojefearea")
    , @NamedQuery(name = "SolicitudCompra.findByCesolTotal", query = "SELECT s FROM SolicitudCompra s WHERE s.cesolTotal = :cesolTotal")})
public class SolicitudCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CESOL_NUMERO")
    private String cesolNumero;
    @Column(name = "CESOL_FECHA")
    @Temporal(TemporalType.DATE)
    private Date cesolFecha;
    @Column(name = "CESOL_APROVDIREFINANCIER")
    private Boolean cesolAprovdirefinancier;
    @Column(name = "CESOL_APROJEFEAREA")
    private Boolean cesolAprojefearea;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CESOL_TOTAL")
    private Float cesolTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudCompra")
    private Collection<ItemSolicitud> itemSolicitudCollection;
    @JoinColumn(name = "PEARE_ID", referencedColumnName = "PEARE_ID")
    @ManyToOne(optional = false)
    private Area peareId;
    @JoinColumn(name = "PEEMP_ID", referencedColumnName = "PEEMP_ID")
    @ManyToOne(optional = false)
    private Empleado peempId;
    @JoinColumn(name = "CERUB_CODIGO", referencedColumnName = "CERUB_CODIGO")
    @ManyToOne(optional = false)
    private RubroPresupuestario cerubCodigo;

    public SolicitudCompra() {
    }

    public SolicitudCompra(String cesolNumero) {
        this.cesolNumero = cesolNumero;
    }

    public String getCesolNumero() {
        return cesolNumero;
    }

    public void setCesolNumero(String cesolNumero) {
        this.cesolNumero = cesolNumero;
    }

    public Date getCesolFecha() {
        return cesolFecha;
    }

    public void setCesolFecha(Date cesolFecha) {
        this.cesolFecha = cesolFecha;
    }

    public Boolean getCesolAprovdirefinancier() {
        return cesolAprovdirefinancier;
    }

    public void setCesolAprovdirefinancier(Boolean cesolAprovdirefinancier) {
        this.cesolAprovdirefinancier = cesolAprovdirefinancier;
    }

    public Boolean getCesolAprojefearea() {
        return cesolAprojefearea;
    }

    public void setCesolAprojefearea(Boolean cesolAprojefearea) {
        this.cesolAprojefearea = cesolAprojefearea;
    }

    public Float getCesolTotal() {
        return cesolTotal;
    }

    public void setCesolTotal(Float cesolTotal) {
        this.cesolTotal = cesolTotal;
    }

    @XmlTransient
    public Collection<ItemSolicitud> getItemSolicitudCollection() {
        return itemSolicitudCollection;
    }

    public void setItemSolicitudCollection(Collection<ItemSolicitud> itemSolicitudCollection) {
        this.itemSolicitudCollection = itemSolicitudCollection;
    }

    public Area getPeareId() {
        return peareId;
    }

    public void setPeareId(Area peareId) {
        this.peareId = peareId;
    }

    public Empleado getPeempId() {
        return peempId;
    }

    public void setPeempId(Empleado peempId) {
        this.peempId = peempId;
    }

    public RubroPresupuestario getCerubCodigo() {
        return cerubCodigo;
    }

    public void setCerubCodigo(RubroPresupuestario cerubCodigo) {
        this.cerubCodigo = cerubCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cesolNumero != null ? cesolNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudCompra)) {
            return false;
        }
        SolicitudCompra other = (SolicitudCompra) object;
        if ((this.cesolNumero == null && other.cesolNumero != null) || (this.cesolNumero != null && !this.cesolNumero.equals(other.cesolNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.SolicitudCompra[ cesolNumero=" + cesolNumero + " ]";
    }
    
}

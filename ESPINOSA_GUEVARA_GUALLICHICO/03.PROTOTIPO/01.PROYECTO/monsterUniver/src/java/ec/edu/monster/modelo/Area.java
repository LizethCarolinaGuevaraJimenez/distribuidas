/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "peare_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
    , @NamedQuery(name = "Area.findByPeareId", query = "SELECT a FROM Area a WHERE a.peareId = :peareId")
    , @NamedQuery(name = "Area.findByPeareNombre", query = "SELECT a FROM Area a WHERE a.peareNombre = :peareNombre")
    , @NamedQuery(name = "Area.findByPeareUbicacion", query = "SELECT a FROM Area a WHERE a.peareUbicacion = :peareUbicacion")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PEARE_ID")
    private String peareId;
    @Size(max = 100)
    @Column(name = "PEARE_NOMBRE")
    private String peareNombre;
    @Size(max = 100)
    @Column(name = "PEARE_UBICACION")
    private String peareUbicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peareId")
    private Collection<Cargo> cargoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peareId")
    private Collection<SolicitudCompra> solicitudCompraCollection;

    public Area() {
    }

    public Area(String peareId) {
        this.peareId = peareId;
    }

    public String getPeareId() {
        return peareId;
    }

    public void setPeareId(String peareId) {
        this.peareId = peareId;
    }

    public String getPeareNombre() {
        return peareNombre;
    }

    public void setPeareNombre(String peareNombre) {
        this.peareNombre = peareNombre;
    }

    public String getPeareUbicacion() {
        return peareUbicacion;
    }

    public void setPeareUbicacion(String peareUbicacion) {
        this.peareUbicacion = peareUbicacion;
    }

    @XmlTransient
    public Collection<Cargo> getCargoCollection() {
        return cargoCollection;
    }

    public void setCargoCollection(Collection<Cargo> cargoCollection) {
        this.cargoCollection = cargoCollection;
    }

    @XmlTransient
    public Collection<SolicitudCompra> getSolicitudCompraCollection() {
        return solicitudCompraCollection;
    }

    public void setSolicitudCompraCollection(Collection<SolicitudCompra> solicitudCompraCollection) {
        this.solicitudCompraCollection = solicitudCompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peareId != null ? peareId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.peareId == null && other.peareId != null) || (this.peareId != null && !this.peareId.equals(other.peareId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return peareNombre;//"ec.edu.monster.modelo.Area[ peareId=" + peareId + " ]";
    }
    
}

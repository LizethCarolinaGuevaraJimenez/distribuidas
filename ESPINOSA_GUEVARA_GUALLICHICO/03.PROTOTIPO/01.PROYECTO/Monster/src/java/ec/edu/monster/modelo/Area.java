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
 * @author Jonathan
 */
@Entity
@Table(name = "peare_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
    , @NamedQuery(name = "Area.findByAreId", query = "SELECT a FROM Area a WHERE a.areId = :areId")
    , @NamedQuery(name = "Area.findByAreNombre", query = "SELECT a FROM Area a WHERE a.areNombre = :areNombre")
    , @NamedQuery(name = "Area.findByAreUbicacion", query = "SELECT a FROM Area a WHERE a.areUbicacion = :areUbicacion")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ARE_ID")
    private String areId;
    @Size(max = 100)
    @Column(name = "ARE_NOMBRE")
    private String areNombre;
    @Size(max = 100)
    @Column(name = "ARE_UBICACION")
    private String areUbicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areId")
    private Collection<Cargo> cargoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areId")
    private Collection<SolicitudCompra> solicitudCompraCollection;

    public Area() {
    }

    public Area(String areId) {
        this.areId = areId;
    }

    public String getAreId() {
        return areId;
    }

    public void setAreId(String areId) {
        this.areId = areId;
    }

    public String getAreNombre() {
        return areNombre;
    }

    public void setAreNombre(String areNombre) {
        this.areNombre = areNombre;
    }

    public String getAreUbicacion() {
        return areUbicacion;
    }

    public void setAreUbicacion(String areUbicacion) {
        this.areUbicacion = areUbicacion;
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
        hash += (areId != null ? areId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.areId == null && other.areId != null) || (this.areId != null && !this.areId.equals(other.areId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Area[ areId=" + areId + " ]";
    }
    
}

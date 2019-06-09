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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pecar_cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")
    , @NamedQuery(name = "Cargo.findByPecarId", query = "SELECT c FROM Cargo c WHERE c.pecarId = :pecarId")
    , @NamedQuery(name = "Cargo.findByPecarNombre", query = "SELECT c FROM Cargo c WHERE c.pecarNombre = :pecarNombre")
    , @NamedQuery(name = "Cargo.findByPecarDetalle", query = "SELECT c FROM Cargo c WHERE c.pecarDetalle = :pecarDetalle")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PECAR_ID")
    private String pecarId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PECAR_NOMBRE")
    private String pecarNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "PECAR_DETALLE")
    private String pecarDetalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pecarId")
    private Collection<Empleado> empleadoCollection;
    @JoinColumn(name = "PEARE_ID", referencedColumnName = "PEARE_ID")
    @ManyToOne(optional = false)
    private Area peareId;

    public Cargo() {
    }

    public Cargo(String pecarId) {
        this.pecarId = pecarId;
    }

    public Cargo(String pecarId, String pecarNombre, String pecarDetalle) {
        this.pecarId = pecarId;
        this.pecarNombre = pecarNombre;
        this.pecarDetalle = pecarDetalle;
    }

    public String getPecarId() {
        return pecarId;
    }

    public void setPecarId(String pecarId) {
        this.pecarId = pecarId;
    }

    public String getPecarNombre() {
        return pecarNombre;
    }

    public void setPecarNombre(String pecarNombre) {
        this.pecarNombre = pecarNombre;
    }

    public String getPecarDetalle() {
        return pecarDetalle;
    }

    public void setPecarDetalle(String pecarDetalle) {
        this.pecarDetalle = pecarDetalle;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    public Area getPeareId() {
        return peareId;
    }

    public void setPeareId(Area peareId) {
        this.peareId = peareId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pecarId != null ? pecarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.pecarId == null && other.pecarId != null) || (this.pecarId != null && !this.pecarId.equals(other.pecarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pecarNombre;//"ec.edu.monster.modelo.Cargo[ pecarId=" + pecarId + " ]";
    }
    
}

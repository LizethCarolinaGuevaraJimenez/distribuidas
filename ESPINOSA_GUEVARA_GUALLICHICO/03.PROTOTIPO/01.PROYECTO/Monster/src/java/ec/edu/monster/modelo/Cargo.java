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
 * @author Jonathan
 */
@Entity
@Table(name = "pecar_cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")
    , @NamedQuery(name = "Cargo.findByCarId", query = "SELECT c FROM Cargo c WHERE c.carId = :carId")
    , @NamedQuery(name = "Cargo.findByCarNombre", query = "SELECT c FROM Cargo c WHERE c.carNombre = :carNombre")
    , @NamedQuery(name = "Cargo.findByCarDetalles", query = "SELECT c FROM Cargo c WHERE c.carDetalles = :carDetalles")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CAR_ID")
    private String carId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CAR_NOMBRE")
    private String carNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "CAR_DETALLES")
    private String carDetalles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carId")
    private Collection<Empleado> empleadoCollection;
    @JoinColumn(name = "ARE_ID", referencedColumnName = "ARE_ID")
    @ManyToOne(optional = false)
    private Area areId;

    public Cargo() {
    }

    public Cargo(String carId) {
        this.carId = carId;
    }

    public Cargo(String carId, String carNombre, String carDetalles) {
        this.carId = carId;
        this.carNombre = carNombre;
        this.carDetalles = carDetalles;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarNombre() {
        return carNombre;
    }

    public void setCarNombre(String carNombre) {
        this.carNombre = carNombre;
    }

    public String getCarDetalles() {
        return carDetalles;
    }

    public void setCarDetalles(String carDetalles) {
        this.carDetalles = carDetalles;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    public Area getAreId() {
        return areId;
    }

    public void setAreId(Area areId) {
        this.areId = areId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carId != null ? carId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.carId == null && other.carId != null) || (this.carId != null && !this.carId.equals(other.carId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Cargo[ carId=" + carId + " ]";
    }
    
}

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
@Table(name = "peest_estciv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e")
    , @NamedQuery(name = "EstadoCivil.findByPeestCodigo", query = "SELECT e FROM EstadoCivil e WHERE e.peestCodigo = :peestCodigo")
    , @NamedQuery(name = "EstadoCivil.findByPeestNombre", query = "SELECT e FROM EstadoCivil e WHERE e.peestNombre = :peestNombre")})
public class EstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PEEST_CODIGO")
    private String peestCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PEEST_NOMBRE")
    private String peestNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peestCodigo")
    private Collection<Empleado> empleadoCollection;

    public EstadoCivil() {
    }

    public EstadoCivil(String peestCodigo) {
        this.peestCodigo = peestCodigo;
    }

    public EstadoCivil(String peestCodigo, String peestNombre) {
        this.peestCodigo = peestCodigo;
        this.peestNombre = peestNombre;
    }

    public String getPeestCodigo() {
        return peestCodigo;
    }

    public void setPeestCodigo(String peestCodigo) {
        this.peestCodigo = peestCodigo;
    }

    public String getPeestNombre() {
        return peestNombre;
    }

    public void setPeestNombre(String peestNombre) {
        this.peestNombre = peestNombre;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peestCodigo != null ? peestCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.peestCodigo == null && other.peestCodigo != null) || (this.peestCodigo != null && !this.peestCodigo.equals(other.peestCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return peestNombre;//"ec.edu.monster.modelo.EstadoCivil[ peestCodigo=" + peestCodigo + " ]";
    }
    
}

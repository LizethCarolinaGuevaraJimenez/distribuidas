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
@Table(name = "pesex_sexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sexo.findAll", query = "SELECT s FROM Sexo s")
    , @NamedQuery(name = "Sexo.findByPesexCodigo", query = "SELECT s FROM Sexo s WHERE s.pesexCodigo = :pesexCodigo")
    , @NamedQuery(name = "Sexo.findByPesexDescripcion", query = "SELECT s FROM Sexo s WHERE s.pesexDescripcion = :pesexDescripcion")})
public class Sexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PESEX_CODIGO")
    private String pesexCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PESEX_DESCRIPCION")
    private String pesexDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pesexCodigo")
    private Collection<Empleado> empleadoCollection;

    public Sexo() {
    }

    public Sexo(String pesexCodigo) {
        this.pesexCodigo = pesexCodigo;
    }

    public Sexo(String pesexCodigo, String pesexDescripcion) {
        this.pesexCodigo = pesexCodigo;
        this.pesexDescripcion = pesexDescripcion;
    }

    public String getPesexCodigo() {
        return pesexCodigo;
    }

    public void setPesexCodigo(String pesexCodigo) {
        this.pesexCodigo = pesexCodigo;
    }

    public String getPesexDescripcion() {
        return pesexDescripcion;
    }

    public void setPesexDescripcion(String pesexDescripcion) {
        this.pesexDescripcion = pesexDescripcion;
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
        hash += (pesexCodigo != null ? pesexCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sexo)) {
            return false;
        }
        Sexo other = (Sexo) object;
        if ((this.pesexCodigo == null && other.pesexCodigo != null) || (this.pesexCodigo != null && !this.pesexCodigo.equals(other.pesexCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pesexDescripcion;//"ec.edu.monster.modelo.Sexo[ pesexCodigo=" + pesexCodigo + " ]";
    }
    
}

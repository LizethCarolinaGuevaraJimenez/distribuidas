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
@Table(name = "pedir_direcc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d")
    , @NamedQuery(name = "Direccion.findByPedirCodigo", query = "SELECT d FROM Direccion d WHERE d.pedirCodigo = :pedirCodigo")
    , @NamedQuery(name = "Direccion.findByPedirNcasa", query = "SELECT d FROM Direccion d WHERE d.pedirNcasa = :pedirNcasa")
    , @NamedQuery(name = "Direccion.findByPedirCallep", query = "SELECT d FROM Direccion d WHERE d.pedirCallep = :pedirCallep")
    , @NamedQuery(name = "Direccion.findByPedirCalles", query = "SELECT d FROM Direccion d WHERE d.pedirCalles = :pedirCalles")
    , @NamedQuery(name = "Direccion.findByPedirReferencia", query = "SELECT d FROM Direccion d WHERE d.pedirReferencia = :pedirReferencia")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PEDIR_CODIGO")
    private String pedirCodigo;
    @Size(max = 10)
    @Column(name = "PEDIR_NCASA")
    private String pedirNcasa;
    @Size(max = 50)
    @Column(name = "PEDIR_CALLEP")
    private String pedirCallep;
    @Size(max = 50)
    @Column(name = "PEDIR_CALLES")
    private String pedirCalles;
    @Size(max = 50)
    @Column(name = "PEDIR_REFERENCIA")
    private String pedirReferencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedirCodigo")
    private Collection<Empleado> empleadoCollection;
    @JoinColumn(name = "PECIU_CODIGO", referencedColumnName = "PECIU_CODIGO")
    @ManyToOne(optional = false)
    private Ciudad peciuCodigo;

    public Direccion() {
    }

    public Direccion(String pedirCodigo) {
        this.pedirCodigo = pedirCodigo;
    }

    public String getPedirCodigo() {
        return pedirCodigo;
    }

    public void setPedirCodigo(String pedirCodigo) {
        this.pedirCodigo = pedirCodigo;
    }

    public String getPedirNcasa() {
        return pedirNcasa;
    }

    public void setPedirNcasa(String pedirNcasa) {
        this.pedirNcasa = pedirNcasa;
    }

    public String getPedirCallep() {
        return pedirCallep;
    }

    public void setPedirCallep(String pedirCallep) {
        this.pedirCallep = pedirCallep;
    }

    public String getPedirCalles() {
        return pedirCalles;
    }

    public void setPedirCalles(String pedirCalles) {
        this.pedirCalles = pedirCalles;
    }

    public String getPedirReferencia() {
        return pedirReferencia;
    }

    public void setPedirReferencia(String pedirReferencia) {
        this.pedirReferencia = pedirReferencia;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    public Ciudad getPeciuCodigo() {
        return peciuCodigo;
    }

    public void setPeciuCodigo(Ciudad peciuCodigo) {
        this.peciuCodigo = peciuCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedirCodigo != null ? pedirCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.pedirCodigo == null && other.pedirCodigo != null) || (this.pedirCodigo != null && !this.pedirCodigo.equals(other.pedirCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pedirCallep+pedirCalles;//"ec.edu.monster.modelo.Direccion[ pedirCodigo=" + pedirCodigo + " ]";
    }
    
}

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
@Table(name = "aepro_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByAeproId", query = "SELECT p FROM Proveedor p WHERE p.aeproId = :aeproId")
    , @NamedQuery(name = "Proveedor.findByAeproRuc", query = "SELECT p FROM Proveedor p WHERE p.aeproRuc = :aeproRuc")
    , @NamedQuery(name = "Proveedor.findByAeproNombre", query = "SELECT p FROM Proveedor p WHERE p.aeproNombre = :aeproNombre")
    , @NamedQuery(name = "Proveedor.findByAeproTelefono", query = "SELECT p FROM Proveedor p WHERE p.aeproTelefono = :aeproTelefono")
    , @NamedQuery(name = "Proveedor.findByAeproDireccion", query = "SELECT p FROM Proveedor p WHERE p.aeproDireccion = :aeproDireccion")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AEPRO_ID")
    private String aeproId;
    @Size(max = 100)
    @Column(name = "AEPRO_RUC")
    private String aeproRuc;
    @Size(max = 100)
    @Column(name = "AEPRO_NOMBRE")
    private String aeproNombre;
    @Size(max = 15)
    @Column(name = "AEPRO_TELEFONO")
    private String aeproTelefono;
    @Size(max = 200)
    @Column(name = "AEPRO_DIRECCION")
    private String aeproDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aeproId")
    private Collection<OrdenContractual> ordenContractualCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aeproId")
    private Collection<Bienes> bienesCollection;

    public Proveedor() {
    }

    public Proveedor(String aeproId) {
        this.aeproId = aeproId;
    }

    public String getAeproId() {
        return aeproId;
    }

    public void setAeproId(String aeproId) {
        this.aeproId = aeproId;
    }

    public String getAeproRuc() {
        return aeproRuc;
    }

    public void setAeproRuc(String aeproRuc) {
        this.aeproRuc = aeproRuc;
    }

    public String getAeproNombre() {
        return aeproNombre;
    }

    public void setAeproNombre(String aeproNombre) {
        this.aeproNombre = aeproNombre;
    }

    public String getAeproTelefono() {
        return aeproTelefono;
    }

    public void setAeproTelefono(String aeproTelefono) {
        this.aeproTelefono = aeproTelefono;
    }

    public String getAeproDireccion() {
        return aeproDireccion;
    }

    public void setAeproDireccion(String aeproDireccion) {
        this.aeproDireccion = aeproDireccion;
    }

    @XmlTransient
    public Collection<OrdenContractual> getOrdenContractualCollection() {
        return ordenContractualCollection;
    }

    public void setOrdenContractualCollection(Collection<OrdenContractual> ordenContractualCollection) {
        this.ordenContractualCollection = ordenContractualCollection;
    }

    @XmlTransient
    public Collection<Bienes> getBienesCollection() {
        return bienesCollection;
    }

    public void setBienesCollection(Collection<Bienes> bienesCollection) {
        this.bienesCollection = bienesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aeproId != null ? aeproId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.aeproId == null && other.aeproId != null) || (this.aeproId != null && !this.aeproId.equals(other.aeproId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return aeproNombre;//"ec.edu.monster.modelo.Proveedor[ aeproId=" + aeproId + " ]";
    }
    
}

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
@Table(name = "aepro_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByProId", query = "SELECT p FROM Proveedor p WHERE p.proId = :proId")
    , @NamedQuery(name = "Proveedor.findByProRuc", query = "SELECT p FROM Proveedor p WHERE p.proRuc = :proRuc")
    , @NamedQuery(name = "Proveedor.findByProNombre", query = "SELECT p FROM Proveedor p WHERE p.proNombre = :proNombre")
    , @NamedQuery(name = "Proveedor.findByProTelefono", query = "SELECT p FROM Proveedor p WHERE p.proTelefono = :proTelefono")
    , @NamedQuery(name = "Proveedor.findByProDireccion", query = "SELECT p FROM Proveedor p WHERE p.proDireccion = :proDireccion")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PRO_ID")
    private String proId;
    @Size(max = 100)
    @Column(name = "PRO_RUC")
    private String proRuc;
    @Size(max = 100)
    @Column(name = "PRO_NOMBRE")
    private String proNombre;
    @Size(max = 15)
    @Column(name = "PRO_TELEFONO")
    private String proTelefono;
    @Size(max = 200)
    @Column(name = "PRO_DIRECCION")
    private String proDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private Collection<OrdenContractual> ordenContractualCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private Collection<Bienes> bienesCollection;

    public Proveedor() {
    }

    public Proveedor(String proId) {
        this.proId = proId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProRuc() {
        return proRuc;
    }

    public void setProRuc(String proRuc) {
        this.proRuc = proRuc;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProTelefono() {
        return proTelefono;
    }

    public void setProTelefono(String proTelefono) {
        this.proTelefono = proTelefono;
    }

    public String getProDireccion() {
        return proDireccion;
    }

    public void setProDireccion(String proDireccion) {
        this.proDireccion = proDireccion;
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
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Proveedor[ proId=" + proId + " ]";
    }
    
}

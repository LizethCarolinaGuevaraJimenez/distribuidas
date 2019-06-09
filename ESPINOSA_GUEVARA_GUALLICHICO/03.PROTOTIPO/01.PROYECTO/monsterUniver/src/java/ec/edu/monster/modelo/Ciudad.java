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
@Table(name = "peciu_ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByPeciuCodigo", query = "SELECT c FROM Ciudad c WHERE c.peciuCodigo = :peciuCodigo")
    , @NamedQuery(name = "Ciudad.findByPeciuNombre", query = "SELECT c FROM Ciudad c WHERE c.peciuNombre = :peciuNombre")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PECIU_CODIGO")
    private String peciuCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PECIU_NOMBRE")
    private String peciuNombre;
    @JoinColumn(name = "PEPROV_CODIGO", referencedColumnName = "PEPROV_CODIGO")
    @ManyToOne(optional = false)
    private Provincia peprovCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peciuCodigo")
    private Collection<Direccion> direccionCollection;

    public Ciudad() {
    }

    public Ciudad(String peciuCodigo) {
        this.peciuCodigo = peciuCodigo;
    }

    public Ciudad(String peciuCodigo, String peciuNombre) {
        this.peciuCodigo = peciuCodigo;
        this.peciuNombre = peciuNombre;
    }

    public String getPeciuCodigo() {
        return peciuCodigo;
    }

    public void setPeciuCodigo(String peciuCodigo) {
        this.peciuCodigo = peciuCodigo;
    }

    public String getPeciuNombre() {
        return peciuNombre;
    }

    public void setPeciuNombre(String peciuNombre) {
        this.peciuNombre = peciuNombre;
    }

    public Provincia getPeprovCodigo() {
        return peprovCodigo;
    }

    public void setPeprovCodigo(Provincia peprovCodigo) {
        this.peprovCodigo = peprovCodigo;
    }

    @XmlTransient
    public Collection<Direccion> getDireccionCollection() {
        return direccionCollection;
    }

    public void setDireccionCollection(Collection<Direccion> direccionCollection) {
        this.direccionCollection = direccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peciuCodigo != null ? peciuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.peciuCodigo == null && other.peciuCodigo != null) || (this.peciuCodigo != null && !this.peciuCodigo.equals(other.peciuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return peciuNombre;//"ec.edu.monster.modelo.Ciudad[ peciuCodigo=" + peciuCodigo + " ]";
    }
    
}

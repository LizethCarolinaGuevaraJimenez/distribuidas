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
@Table(name = "pepro_provin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p")
    , @NamedQuery(name = "Provincia.findByPeprovCodigo", query = "SELECT p FROM Provincia p WHERE p.peprovCodigo = :peprovCodigo")
    , @NamedQuery(name = "Provincia.findByPeprovNombre", query = "SELECT p FROM Provincia p WHERE p.peprovNombre = :peprovNombre")})
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PEPROV_CODIGO")
    private String peprovCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PEPROV_NOMBRE")
    private String peprovNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peprovCodigo")
    private Collection<Ciudad> ciudadCollection;
    @JoinColumn(name = "PEPAI_CODIGO", referencedColumnName = "PEPAI_CODIGO")
    @ManyToOne(optional = false)
    private Pais pepaiCodigo;

    public Provincia() {
    }

    public Provincia(String peprovCodigo) {
        this.peprovCodigo = peprovCodigo;
    }

    public Provincia(String peprovCodigo, String peprovNombre) {
        this.peprovCodigo = peprovCodigo;
        this.peprovNombre = peprovNombre;
    }

    public String getPeprovCodigo() {
        return peprovCodigo;
    }

    public void setPeprovCodigo(String peprovCodigo) {
        this.peprovCodigo = peprovCodigo;
    }

    public String getPeprovNombre() {
        return peprovNombre;
    }

    public void setPeprovNombre(String peprovNombre) {
        this.peprovNombre = peprovNombre;
    }

    @XmlTransient
    public Collection<Ciudad> getCiudadCollection() {
        return ciudadCollection;
    }

    public void setCiudadCollection(Collection<Ciudad> ciudadCollection) {
        this.ciudadCollection = ciudadCollection;
    }

    public Pais getPepaiCodigo() {
        return pepaiCodigo;
    }

    public void setPepaiCodigo(Pais pepaiCodigo) {
        this.pepaiCodigo = pepaiCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peprovCodigo != null ? peprovCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.peprovCodigo == null && other.peprovCodigo != null) || (this.peprovCodigo != null && !this.peprovCodigo.equals(other.peprovCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return peprovNombre;//"ec.edu.monster.modelo.Provincia[ peprovCodigo=" + peprovCodigo + " ]";
    }
    
}

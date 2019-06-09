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
@Table(name = "pepai_pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")
    , @NamedQuery(name = "Pais.findByPepaiCodigo", query = "SELECT p FROM Pais p WHERE p.pepaiCodigo = :pepaiCodigo")
    , @NamedQuery(name = "Pais.findByPepaiNombre", query = "SELECT p FROM Pais p WHERE p.pepaiNombre = :pepaiNombre")
    , @NamedQuery(name = "Pais.findByPepaiCodpCopost", query = "SELECT p FROM Pais p WHERE p.pepaiCodpCopost = :pepaiCodpCopost")})
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PEPAI_CODIGO")
    private String pepaiCodigo;
    @Size(max = 30)
    @Column(name = "PEPAI_NOMBRE")
    private String pepaiNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PEPAI_CODP_COPOST")
    private String pepaiCodpCopost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pepaiCodigo")
    private Collection<Provincia> provinciaCollection;

    public Pais() {
    }

    public Pais(String pepaiCodigo) {
        this.pepaiCodigo = pepaiCodigo;
    }

    public Pais(String pepaiCodigo, String pepaiCodpCopost) {
        this.pepaiCodigo = pepaiCodigo;
        this.pepaiCodpCopost = pepaiCodpCopost;
    }

    public String getPepaiCodigo() {
        return pepaiCodigo;
    }

    public void setPepaiCodigo(String pepaiCodigo) {
        this.pepaiCodigo = pepaiCodigo;
    }

    public String getPepaiNombre() {
        return pepaiNombre;
    }

    public void setPepaiNombre(String pepaiNombre) {
        this.pepaiNombre = pepaiNombre;
    }

    public String getPepaiCodpCopost() {
        return pepaiCodpCopost;
    }

    public void setPepaiCodpCopost(String pepaiCodpCopost) {
        this.pepaiCodpCopost = pepaiCodpCopost;
    }

    @XmlTransient
    public Collection<Provincia> getProvinciaCollection() {
        return provinciaCollection;
    }

    public void setProvinciaCollection(Collection<Provincia> provinciaCollection) {
        this.provinciaCollection = provinciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pepaiCodigo != null ? pepaiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.pepaiCodigo == null && other.pepaiCodigo != null) || (this.pepaiCodigo != null && !this.pepaiCodigo.equals(other.pepaiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pepaiNombre;//"ec.edu.monster.modelo.Pais[ pepaiCodigo=" + pepaiCodigo + " ]";
    }
    
}

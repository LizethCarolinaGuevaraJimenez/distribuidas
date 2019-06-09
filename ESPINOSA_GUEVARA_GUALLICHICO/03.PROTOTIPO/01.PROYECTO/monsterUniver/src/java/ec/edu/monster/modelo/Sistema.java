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
@Table(name = "sesis_sistem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sistema.findAll", query = "SELECT s FROM Sistema s")
    , @NamedQuery(name = "Sistema.findBySesisCodigo", query = "SELECT s FROM Sistema s WHERE s.sesisCodigo = :sesisCodigo")
    , @NamedQuery(name = "Sistema.findBySesisNombre", query = "SELECT s FROM Sistema s WHERE s.sesisNombre = :sesisNombre")})
public class Sistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SESIS_CODIGO")
    private String sesisCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SESIS_NOMBRE")
    private String sesisNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sesisCodigo")
    private Collection<Opcion> opcionCollection;
    @JoinColumn(name = "SEEST_CODIGO", referencedColumnName = "SEEST_CODIGO")
    @ManyToOne(optional = false)
    private Estado seestCodigo;

    public Sistema() {
    }

    public Sistema(String sesisCodigo) {
        this.sesisCodigo = sesisCodigo;
    }

    public Sistema(String sesisCodigo, String sesisNombre) {
        this.sesisCodigo = sesisCodigo;
        this.sesisNombre = sesisNombre;
    }

    public String getSesisCodigo() {
        return sesisCodigo;
    }

    public void setSesisCodigo(String sesisCodigo) {
        this.sesisCodigo = sesisCodigo;
    }

    public String getSesisNombre() {
        return sesisNombre;
    }

    public void setSesisNombre(String sesisNombre) {
        this.sesisNombre = sesisNombre;
    }

    @XmlTransient
    public Collection<Opcion> getOpcionCollection() {
        return opcionCollection;
    }

    public void setOpcionCollection(Collection<Opcion> opcionCollection) {
        this.opcionCollection = opcionCollection;
    }

    public Estado getSeestCodigo() {
        return seestCodigo;
    }

    public void setSeestCodigo(Estado seestCodigo) {
        this.seestCodigo = seestCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sesisCodigo != null ? sesisCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.sesisCodigo == null && other.sesisCodigo != null) || (this.sesisCodigo != null && !this.sesisCodigo.equals(other.sesisCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return sesisNombre;//"ec.edu.monster.modelo.Sistema[ sesisCodigo=" + sesisCodigo + " ]";
    }
    
}

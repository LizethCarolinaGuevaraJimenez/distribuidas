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
@Table(name = "sesis_sistem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sistema.findAll", query = "SELECT s FROM Sistema s")
    , @NamedQuery(name = "Sistema.findBySisCodigo", query = "SELECT s FROM Sistema s WHERE s.sisCodigo = :sisCodigo")
    , @NamedQuery(name = "Sistema.findBySisDescripcion", query = "SELECT s FROM Sistema s WHERE s.sisDescripcion = :sisDescripcion")})
public class Sistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SIS_CODIGO")
    private String sisCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SIS_DESCRIPCION")
    private String sisDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sisCodigo")
    private Collection<Opcion> opcionCollection;
    @JoinColumn(name = "EST_CODIGO", referencedColumnName = "EST_CODIGO")
    @ManyToOne(optional = false)
    private Estado estCodigo;

    public Sistema() {
    }

    public Sistema(String sisCodigo) {
        this.sisCodigo = sisCodigo;
    }

    public Sistema(String sisCodigo, String sisDescripcion) {
        this.sisCodigo = sisCodigo;
        this.sisDescripcion = sisDescripcion;
    }

    public String getSisCodigo() {
        return sisCodigo;
    }

    public void setSisCodigo(String sisCodigo) {
        this.sisCodigo = sisCodigo;
    }

    public String getSisDescripcion() {
        return sisDescripcion;
    }

    public void setSisDescripcion(String sisDescripcion) {
        this.sisDescripcion = sisDescripcion;
    }

    @XmlTransient
    public Collection<Opcion> getOpcionCollection() {
        return opcionCollection;
    }

    public void setOpcionCollection(Collection<Opcion> opcionCollection) {
        this.opcionCollection = opcionCollection;
    }

    public Estado getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Estado estCodigo) {
        this.estCodigo = estCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sisCodigo != null ? sisCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.sisCodigo == null && other.sisCodigo != null) || (this.sisCodigo != null && !this.sisCodigo.equals(other.sisCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Sistema[ sisCodigo=" + sisCodigo + " ]";
    }
    
}

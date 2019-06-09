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
@Table(name = "seest_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
    , @NamedQuery(name = "Estado.findBySeestCodigo", query = "SELECT e FROM Estado e WHERE e.seestCodigo = :seestCodigo")
    , @NamedQuery(name = "Estado.findBySeestDescripcion", query = "SELECT e FROM Estado e WHERE e.seestDescripcion = :seestDescripcion")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SEEST_CODIGO")
    private String seestCodigo;
    @Size(max = 30)
    @Column(name = "SEEST_DESCRIPCION")
    private String seestDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seestCodigo")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seestCodigo")
    private Collection<Sistema> sistemaCollection;

    public Estado() {
    }

    public Estado(String seestCodigo) {
        this.seestCodigo = seestCodigo;
    }

    public String getSeestCodigo() {
        return seestCodigo;
    }

    public void setSeestCodigo(String seestCodigo) {
        this.seestCodigo = seestCodigo;
    }

    public String getSeestDescripcion() {
        return seestDescripcion;
    }

    public void setSeestDescripcion(String seestDescripcion) {
        this.seestDescripcion = seestDescripcion;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Sistema> getSistemaCollection() {
        return sistemaCollection;
    }

    public void setSistemaCollection(Collection<Sistema> sistemaCollection) {
        this.sistemaCollection = sistemaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seestCodigo != null ? seestCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.seestCodigo == null && other.seestCodigo != null) || (this.seestCodigo != null && !this.seestCodigo.equals(other.seestCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return seestDescripcion;//"ec.edu.monster.modelo.Estado[ seestCodigo=" + seestCodigo + " ]";
    }
    
}

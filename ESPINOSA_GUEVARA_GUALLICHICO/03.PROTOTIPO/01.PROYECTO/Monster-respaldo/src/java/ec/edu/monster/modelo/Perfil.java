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
import javax.persistence.OneToOne;
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
@Table(name = "seper_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.findByPerCodigo", query = "SELECT p FROM Perfil p WHERE p.perCodigo = :perCodigo")
    , @NamedQuery(name = "Perfil.findByPerDescripcion", query = "SELECT p FROM Perfil p WHERE p.perDescripcion = :perDescripcion")
    , @NamedQuery(name = "Perfil.findByPerObservacion", query = "SELECT p FROM Perfil p WHERE p.perObservacion = :perObservacion")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PER_CODIGO")
    private String perCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PER_DESCRIPCION")
    private String perDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PER_OBSERVACION")
    private String perObservacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private Collection<UsuarioPerfil> usuarioPerfilCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "perfil")
    private Rol rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private Collection<OpcionPerfil> opcionPerfilCollection;

    public Perfil() {
    }

    public Perfil(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Perfil(String perCodigo, String perDescripcion, String perObservacion) {
        this.perCodigo = perCodigo;
        this.perDescripcion = perDescripcion;
        this.perObservacion = perObservacion;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerDescripcion() {
        return perDescripcion;
    }

    public void setPerDescripcion(String perDescripcion) {
        this.perDescripcion = perDescripcion;
    }

    public String getPerObservacion() {
        return perObservacion;
    }

    public void setPerObservacion(String perObservacion) {
        this.perObservacion = perObservacion;
    }

    @XmlTransient
    public Collection<UsuarioPerfil> getUsuarioPerfilCollection() {
        return usuarioPerfilCollection;
    }

    public void setUsuarioPerfilCollection(Collection<UsuarioPerfil> usuarioPerfilCollection) {
        this.usuarioPerfilCollection = usuarioPerfilCollection;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @XmlTransient
    public Collection<OpcionPerfil> getOpcionPerfilCollection() {
        return opcionPerfilCollection;
    }

    public void setOpcionPerfilCollection(Collection<OpcionPerfil> opcionPerfilCollection) {
        this.opcionPerfilCollection = opcionPerfilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perCodigo != null ? perCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.perCodigo == null && other.perCodigo != null) || (this.perCodigo != null && !this.perCodigo.equals(other.perCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Perfil[ perCodigo=" + perCodigo + " ]";
    }
    
}

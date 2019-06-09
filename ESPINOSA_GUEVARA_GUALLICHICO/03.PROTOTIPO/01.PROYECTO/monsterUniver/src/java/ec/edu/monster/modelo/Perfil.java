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
 * @author pablo
 */
@Entity
@Table(name = "seper_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.findBySeperCodigo", query = "SELECT p FROM Perfil p WHERE p.seperCodigo = :seperCodigo")
    , @NamedQuery(name = "Perfil.findBySeperNombre", query = "SELECT p FROM Perfil p WHERE p.seperNombre = :seperNombre")
    , @NamedQuery(name = "Perfil.findBySeperDescripcion", query = "SELECT p FROM Perfil p WHERE p.seperDescripcion = :seperDescripcion")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SEPER_CODIGO")
    private String seperCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SEPER_NOMBRE")
    private String seperNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SEPER_DESCRIPCION")
    private String seperDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private Collection<OpcionPerfil> opcionPerfilCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private Collection<VentanaPerfil> ventanaPerfilCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private Collection<UsuarioPerfil> usuarioPerfilCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "perfil")
    private Rol rol;

    public Perfil() {
    }

    public Perfil(String seperCodigo) {
        this.seperCodigo = seperCodigo;
    }

    public Perfil(String seperCodigo, String seperNombre, String seperDescripcion) {
        this.seperCodigo = seperCodigo;
        this.seperNombre = seperNombre;
        this.seperDescripcion = seperDescripcion;
    }

    public String getSeperCodigo() {
        return seperCodigo;
    }

    public void setSeperCodigo(String seperCodigo) {
        this.seperCodigo = seperCodigo;
    }

    public String getSeperNombre() {
        return seperNombre;
    }

    public void setSeperNombre(String seperNombre) {
        this.seperNombre = seperNombre;
    }

    public String getSeperDescripcion() {
        return seperDescripcion;
    }

    public void setSeperDescripcion(String seperDescripcion) {
        this.seperDescripcion = seperDescripcion;
    }

    @XmlTransient
    public Collection<OpcionPerfil> getOpcionPerfilCollection() {
        return opcionPerfilCollection;
    }

    public void setOpcionPerfilCollection(Collection<OpcionPerfil> opcionPerfilCollection) {
        this.opcionPerfilCollection = opcionPerfilCollection;
    }

    @XmlTransient
    public Collection<VentanaPerfil> getVentanaPerfilCollection() {
        return ventanaPerfilCollection;
    }

    public void setVentanaPerfilCollection(Collection<VentanaPerfil> ventanaPerfilCollection) {
        this.ventanaPerfilCollection = ventanaPerfilCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seperCodigo != null ? seperCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.seperCodigo == null && other.seperCodigo != null) || (this.seperCodigo != null && !this.seperCodigo.equals(other.seperCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return seperNombre;//"ec.edu.monster.modelo.Perfil[ seperCodigo=" + seperCodigo + " ]";
    }
    
}

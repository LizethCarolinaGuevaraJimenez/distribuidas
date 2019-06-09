/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "seusu_usuari")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findBySeusuUsuario", query = "SELECT u FROM Usuario u WHERE u.seusuUsuario = :seusuUsuario")
    , @NamedQuery(name = "Usuario.findBySeusuContrasena", query = "SELECT u FROM Usuario u WHERE u.seusuContrasena = :seusuContrasena")
    , @NamedQuery(name = "Usuario.findBySeusuFechacreacion", query = "SELECT u FROM Usuario u WHERE u.seusuFechacreacion = :seusuFechacreacion")
    , @NamedQuery(name = "Usuario.findBySeusuFechaultimocambio", query = "SELECT u FROM Usuario u WHERE u.seusuFechaultimocambio = :seusuFechaultimocambio")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SEUSU_USUARIO")
    private String seusuUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SEUSU_CONTRASENA")
    private String seusuContrasena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEUSU_FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date seusuFechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEUSU_FECHAULTIMOCAMBIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date seusuFechaultimocambio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<UsuarioPerfil> usuarioPerfilCollection;
    @JoinColumn(name = "PEEMP_ID", referencedColumnName = "PEEMP_ID")
    @ManyToOne(optional = false)
    private Empleado peempId;
    @JoinColumn(name = "SEEST_CODIGO", referencedColumnName = "SEEST_CODIGO")
    @ManyToOne(optional = false)
    private Estado seestCodigo;

    public Usuario() {
    }

    public Usuario(String seusuUsuario) {
        this.seusuUsuario = seusuUsuario;
    }

    public Usuario(String seusuUsuario, String seusuContrasena, Date seusuFechacreacion, Date seusuFechaultimocambio) {
        this.seusuUsuario = seusuUsuario;
        this.seusuContrasena = seusuContrasena;
        this.seusuFechacreacion = seusuFechacreacion;
        this.seusuFechaultimocambio = seusuFechaultimocambio;
    }

    public String getSeusuUsuario() {
        return seusuUsuario;
    }

    public void setSeusuUsuario(String seusuUsuario) {
        this.seusuUsuario = seusuUsuario;
    }

    public String getSeusuContrasena() {
        return seusuContrasena;
    }

    public void setSeusuContrasena(String seusuContrasena) {
        this.seusuContrasena = seusuContrasena;
    }

    public Date getSeusuFechacreacion() {
        return seusuFechacreacion;
    }

    public void setSeusuFechacreacion(Date seusuFechacreacion) {
        this.seusuFechacreacion = seusuFechacreacion;
    }

    public Date getSeusuFechaultimocambio() {
        return seusuFechaultimocambio;
    }

    public void setSeusuFechaultimocambio(Date seusuFechaultimocambio) {
        this.seusuFechaultimocambio = seusuFechaultimocambio;
    }

    @XmlTransient
    public Collection<UsuarioPerfil> getUsuarioPerfilCollection() {
        return usuarioPerfilCollection;
    }

    public void setUsuarioPerfilCollection(Collection<UsuarioPerfil> usuarioPerfilCollection) {
        this.usuarioPerfilCollection = usuarioPerfilCollection;
    }

    public Empleado getPeempId() {
        return peempId;
    }

    public void setPeempId(Empleado peempId) {
        this.peempId = peempId;
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
        hash += (seusuUsuario != null ? seusuUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.seusuUsuario == null && other.seusuUsuario != null) || (this.seusuUsuario != null && !this.seusuUsuario.equals(other.seusuUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return seusuUsuario;//"ec.edu.monster.modelo.Usuario[ seusuUsuario=" + seusuUsuario + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "seusu_usaper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioPerfil.findAll", query = "SELECT u FROM UsuarioPerfil u")
    , @NamedQuery(name = "UsuarioPerfil.findBySeperCodigo", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuarioPerfilPK.seperCodigo = :seperCodigo")
    , @NamedQuery(name = "UsuarioPerfil.findBySeusuUsuario", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuarioPerfilPK.seusuUsuario = :seusuUsuario")
    , @NamedQuery(name = "UsuarioPerfil.findBySeusuFechaasignacion", query = "SELECT u FROM UsuarioPerfil u WHERE u.seusuFechaasignacion = :seusuFechaasignacion")
    , @NamedQuery(name = "UsuarioPerfil.findBySeusuFechacambio", query = "SELECT u FROM UsuarioPerfil u WHERE u.seusuFechacambio = :seusuFechacambio")})
public class UsuarioPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPerfilPK usuarioPerfilPK;
    @Column(name = "SEUSU_FECHAASIGNACION")
    @Temporal(TemporalType.DATE)
    private Date seusuFechaasignacion;
    @Column(name = "SEUSU_FECHACAMBIO")
    @Temporal(TemporalType.DATE)
    private Date seusuFechacambio;
    @JoinColumn(name = "SEPER_CODIGO", referencedColumnName = "SEPER_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;
    @JoinColumn(name = "SEUSU_USUARIO", referencedColumnName = "SEUSU_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioPerfil() {
    }

    public UsuarioPerfil(UsuarioPerfilPK usuarioPerfilPK) {
        this.usuarioPerfilPK = usuarioPerfilPK;
    }

    public UsuarioPerfil(String seperCodigo, String seusuUsuario) {
        this.usuarioPerfilPK = new UsuarioPerfilPK(seperCodigo, seusuUsuario);
    }

    public UsuarioPerfilPK getUsuarioPerfilPK() {
        return usuarioPerfilPK;
    }

    public void setUsuarioPerfilPK(UsuarioPerfilPK usuarioPerfilPK) {
        this.usuarioPerfilPK = usuarioPerfilPK;
    }

    public Date getSeusuFechaasignacion() {
        return seusuFechaasignacion;
    }

    public void setSeusuFechaasignacion(Date seusuFechaasignacion) {
        this.seusuFechaasignacion = seusuFechaasignacion;
    }

    public Date getSeusuFechacambio() {
        return seusuFechacambio;
    }

    public void setSeusuFechacambio(Date seusuFechacambio) {
        this.seusuFechacambio = seusuFechacambio;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPerfilPK != null ? usuarioPerfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPerfil)) {
            return false;
        }
        UsuarioPerfil other = (UsuarioPerfil) object;
        if ((this.usuarioPerfilPK == null && other.usuarioPerfilPK != null) || (this.usuarioPerfilPK != null && !this.usuarioPerfilPK.equals(other.usuarioPerfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.UsuarioPerfil[ usuarioPerfilPK=" + usuarioPerfilPK + " ]";
    }
    
}

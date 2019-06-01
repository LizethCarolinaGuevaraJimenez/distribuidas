/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "seusu_usaper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioPerfil.findAll", query = "SELECT u FROM UsuarioPerfil u")
    , @NamedQuery(name = "UsuarioPerfil.findByEmpId", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuarioPerfilPK.empId = :empId")
    , @NamedQuery(name = "UsuarioPerfil.findByPerCodigo", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuarioPerfilPK.perCodigo = :perCodigo")
    , @NamedQuery(name = "UsuarioPerfil.findByUsuperFechaasignacion", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuperFechaasignacion = :usuperFechaasignacion")
    , @NamedQuery(name = "UsuarioPerfil.findByUsuperFechacambio", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuperFechacambio = :usuperFechacambio")})
public class UsuarioPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPerfilPK usuarioPerfilPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUPER_FECHAASIGNACION")
    @Temporal(TemporalType.DATE)
    private Date usuperFechaasignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUPER_FECHACAMBIO")
    @Temporal(TemporalType.DATE)
    private Date usuperFechacambio;
    @JoinColumn(name = "PER_CODIGO", referencedColumnName = "PER_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioPerfil() {
    }

    public UsuarioPerfil(UsuarioPerfilPK usuarioPerfilPK) {
        this.usuarioPerfilPK = usuarioPerfilPK;
    }

    public UsuarioPerfil(UsuarioPerfilPK usuarioPerfilPK, Date usuperFechaasignacion, Date usuperFechacambio) {
        this.usuarioPerfilPK = usuarioPerfilPK;
        this.usuperFechaasignacion = usuperFechaasignacion;
        this.usuperFechacambio = usuperFechacambio;
    }

    public UsuarioPerfil(String empId, String perCodigo) {
        this.usuarioPerfilPK = new UsuarioPerfilPK(empId, perCodigo);
    }

    public UsuarioPerfilPK getUsuarioPerfilPK() {
        return usuarioPerfilPK;
    }

    public void setUsuarioPerfilPK(UsuarioPerfilPK usuarioPerfilPK) {
        this.usuarioPerfilPK = usuarioPerfilPK;
    }

    public Date getUsuperFechaasignacion() {
        return usuperFechaasignacion;
    }

    public void setUsuperFechaasignacion(Date usuperFechaasignacion) {
        this.usuperFechaasignacion = usuperFechaasignacion;
    }

    public Date getUsuperFechacambio() {
        return usuperFechacambio;
    }

    public void setUsuperFechacambio(Date usuperFechacambio) {
        this.usuperFechacambio = usuperFechacambio;
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

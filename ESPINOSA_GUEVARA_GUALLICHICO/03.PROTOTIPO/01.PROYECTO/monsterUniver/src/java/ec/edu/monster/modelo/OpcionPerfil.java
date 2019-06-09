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
@Table(name = "seopc_opcper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpcionPerfil.findAll", query = "SELECT o FROM OpcionPerfil o")
    , @NamedQuery(name = "OpcionPerfil.findBySeperCodigo", query = "SELECT o FROM OpcionPerfil o WHERE o.opcionPerfilPK.seperCodigo = :seperCodigo")
    , @NamedQuery(name = "OpcionPerfil.findBySeopcCodigo", query = "SELECT o FROM OpcionPerfil o WHERE o.opcionPerfilPK.seopcCodigo = :seopcCodigo")
    , @NamedQuery(name = "OpcionPerfil.findBySeopcFechaasignacion", query = "SELECT o FROM OpcionPerfil o WHERE o.seopcFechaasignacion = :seopcFechaasignacion")})
public class OpcionPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OpcionPerfilPK opcionPerfilPK;
    @Column(name = "SEOPC_FECHAASIGNACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date seopcFechaasignacion;
    @JoinColumn(name = "SEOPC_CODIGO", referencedColumnName = "SEOPC_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Opcion opcion;
    @JoinColumn(name = "SEPER_CODIGO", referencedColumnName = "SEPER_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;

    public OpcionPerfil() {
    }

    public OpcionPerfil(OpcionPerfilPK opcionPerfilPK) {
        this.opcionPerfilPK = opcionPerfilPK;
    }

    public OpcionPerfil(String seperCodigo, String seopcCodigo) {
        this.opcionPerfilPK = new OpcionPerfilPK(seperCodigo, seopcCodigo);
    }

    public OpcionPerfilPK getOpcionPerfilPK() {
        return opcionPerfilPK;
    }

    public void setOpcionPerfilPK(OpcionPerfilPK opcionPerfilPK) {
        this.opcionPerfilPK = opcionPerfilPK;
    }

    public Date getSeopcFechaasignacion() {
        return seopcFechaasignacion;
    }

    public void setSeopcFechaasignacion(Date seopcFechaasignacion) {
        this.seopcFechaasignacion = seopcFechaasignacion;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcionPerfilPK != null ? opcionPerfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionPerfil)) {
            return false;
        }
        OpcionPerfil other = (OpcionPerfil) object;
        if ((this.opcionPerfilPK == null && other.opcionPerfilPK != null) || (this.opcionPerfilPK != null && !this.opcionPerfilPK.equals(other.opcionPerfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.OpcionPerfil[ opcionPerfilPK=" + opcionPerfilPK + " ]";
    }
    
}

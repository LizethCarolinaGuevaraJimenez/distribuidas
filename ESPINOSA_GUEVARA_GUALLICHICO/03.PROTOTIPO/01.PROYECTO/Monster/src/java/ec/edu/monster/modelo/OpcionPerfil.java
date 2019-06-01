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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "seopc_opcper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpcionPerfil.findAll", query = "SELECT o FROM OpcionPerfil o")
    , @NamedQuery(name = "OpcionPerfil.findByPerCodigo", query = "SELECT o FROM OpcionPerfil o WHERE o.opcionPerfilPK.perCodigo = :perCodigo")
    , @NamedQuery(name = "OpcionPerfil.findByOpcCodigo", query = "SELECT o FROM OpcionPerfil o WHERE o.opcionPerfilPK.opcCodigo = :opcCodigo")
    , @NamedQuery(name = "OpcionPerfil.findByOpcperFechaasignacion", query = "SELECT o FROM OpcionPerfil o WHERE o.opcperFechaasignacion = :opcperFechaasignacion")
    , @NamedQuery(name = "OpcionPerfil.findByOpcperEstado", query = "SELECT o FROM OpcionPerfil o WHERE o.opcperEstado = :opcperEstado")})
public class OpcionPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OpcionPerfilPK opcionPerfilPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPCPER_FECHAASIGNACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date opcperFechaasignacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "OPCPER_ESTADO")
    private String opcperEstado;
    @JoinColumn(name = "OPC_CODIGO", referencedColumnName = "OPC_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Opcion opcion;
    @JoinColumn(name = "PER_CODIGO", referencedColumnName = "PER_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;

    public OpcionPerfil() {
    }

    public OpcionPerfil(OpcionPerfilPK opcionPerfilPK) {
        this.opcionPerfilPK = opcionPerfilPK;
    }

    public OpcionPerfil(OpcionPerfilPK opcionPerfilPK, Date opcperFechaasignacion, String opcperEstado) {
        this.opcionPerfilPK = opcionPerfilPK;
        this.opcperFechaasignacion = opcperFechaasignacion;
        this.opcperEstado = opcperEstado;
    }

    public OpcionPerfil(String perCodigo, String opcCodigo) {
        this.opcionPerfilPK = new OpcionPerfilPK(perCodigo, opcCodigo);
    }

    public OpcionPerfilPK getOpcionPerfilPK() {
        return opcionPerfilPK;
    }

    public void setOpcionPerfilPK(OpcionPerfilPK opcionPerfilPK) {
        this.opcionPerfilPK = opcionPerfilPK;
    }

    public Date getOpcperFechaasignacion() {
        return opcperFechaasignacion;
    }

    public void setOpcperFechaasignacion(Date opcperFechaasignacion) {
        this.opcperFechaasignacion = opcperFechaasignacion;
    }

    public String getOpcperEstado() {
        return opcperEstado;
    }

    public void setOpcperEstado(String opcperEstado) {
        this.opcperEstado = opcperEstado;
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

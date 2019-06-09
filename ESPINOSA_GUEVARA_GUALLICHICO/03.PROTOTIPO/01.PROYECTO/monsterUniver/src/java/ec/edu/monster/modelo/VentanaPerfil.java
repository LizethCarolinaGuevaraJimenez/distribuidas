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
@Table(name = "seven_venper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentanaPerfil.findAll", query = "SELECT v FROM VentanaPerfil v")
    , @NamedQuery(name = "VentanaPerfil.findBySevenCodigo", query = "SELECT v FROM VentanaPerfil v WHERE v.ventanaPerfilPK.sevenCodigo = :sevenCodigo")
    , @NamedQuery(name = "VentanaPerfil.findBySeperCodigo", query = "SELECT v FROM VentanaPerfil v WHERE v.ventanaPerfilPK.seperCodigo = :seperCodigo")
    , @NamedQuery(name = "VentanaPerfil.findBySevenFechaasignacion", query = "SELECT v FROM VentanaPerfil v WHERE v.sevenFechaasignacion = :sevenFechaasignacion")})
public class VentanaPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentanaPerfilPK ventanaPerfilPK;
    @Column(name = "SEVEN_FECHAASIGNACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sevenFechaasignacion;
    @JoinColumn(name = "SEPER_CODIGO", referencedColumnName = "SEPER_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;
    @JoinColumn(name = "SEVEN_CODIGO", referencedColumnName = "SEVEN_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ventana ventana;

    public VentanaPerfil() {
    }

    public VentanaPerfil(VentanaPerfilPK ventanaPerfilPK) {
        this.ventanaPerfilPK = ventanaPerfilPK;
    }

    public VentanaPerfil(String sevenCodigo, String seperCodigo) {
        this.ventanaPerfilPK = new VentanaPerfilPK(sevenCodigo, seperCodigo);
    }

    public VentanaPerfilPK getVentanaPerfilPK() {
        return ventanaPerfilPK;
    }

    public void setVentanaPerfilPK(VentanaPerfilPK ventanaPerfilPK) {
        this.ventanaPerfilPK = ventanaPerfilPK;
    }

    public Date getSevenFechaasignacion() {
        return sevenFechaasignacion;
    }

    public void setSevenFechaasignacion(Date sevenFechaasignacion) {
        this.sevenFechaasignacion = sevenFechaasignacion;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Ventana getVentana() {
        return ventana;
    }

    public void setVentana(Ventana ventana) {
        this.ventana = ventana;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventanaPerfilPK != null ? ventanaPerfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentanaPerfil)) {
            return false;
        }
        VentanaPerfil other = (VentanaPerfil) object;
        if ((this.ventanaPerfilPK == null && other.ventanaPerfilPK != null) || (this.ventanaPerfilPK != null && !this.ventanaPerfilPK.equals(other.ventanaPerfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.VentanaPerfil[ ventanaPerfilPK=" + ventanaPerfilPK + " ]";
    }
    
}

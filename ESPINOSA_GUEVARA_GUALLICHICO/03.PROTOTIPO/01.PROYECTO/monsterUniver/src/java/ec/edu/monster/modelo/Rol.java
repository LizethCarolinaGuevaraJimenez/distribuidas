/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "serol_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findBySeperCodigo", query = "SELECT r FROM Rol r WHERE r.seperCodigo = :seperCodigo")
    , @NamedQuery(name = "Rol.findBySerolInsercion", query = "SELECT r FROM Rol r WHERE r.serolInsercion = :serolInsercion")
    , @NamedQuery(name = "Rol.findBySerolActualizacion", query = "SELECT r FROM Rol r WHERE r.serolActualizacion = :serolActualizacion")
    , @NamedQuery(name = "Rol.findBySerolEliminacion", query = "SELECT r FROM Rol r WHERE r.serolEliminacion = :serolEliminacion")
    , @NamedQuery(name = "Rol.findBySerolConsulta", query = "SELECT r FROM Rol r WHERE r.serolConsulta = :serolConsulta")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SEPER_CODIGO")
    private String seperCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SEROL_INSERCION")
    private String serolInsercion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SEROL_ACTUALIZACION")
    private String serolActualizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SEROL_ELIMINACION")
    private String serolEliminacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SEROL_CONSULTA")
    private String serolConsulta;
    @JoinColumn(name = "SEPER_CODIGO", referencedColumnName = "SEPER_CODIGO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Perfil perfil;

    public Rol() {
    }

    public Rol(String seperCodigo) {
        this.seperCodigo = seperCodigo;
    }

    public Rol(String seperCodigo, String serolInsercion, String serolActualizacion, String serolEliminacion, String serolConsulta) {
        this.seperCodigo = seperCodigo;
        this.serolInsercion = serolInsercion;
        this.serolActualizacion = serolActualizacion;
        this.serolEliminacion = serolEliminacion;
        this.serolConsulta = serolConsulta;
    }

    public String getSeperCodigo() {
        return seperCodigo;
    }

    public void setSeperCodigo(String seperCodigo) {
        this.seperCodigo = seperCodigo;
    }

    public String getSerolInsercion() {
        return serolInsercion;
    }

    public void setSerolInsercion(String serolInsercion) {
        this.serolInsercion = serolInsercion;
    }

    public String getSerolActualizacion() {
        return serolActualizacion;
    }

    public void setSerolActualizacion(String serolActualizacion) {
        this.serolActualizacion = serolActualizacion;
    }

    public String getSerolEliminacion() {
        return serolEliminacion;
    }

    public void setSerolEliminacion(String serolEliminacion) {
        this.serolEliminacion = serolEliminacion;
    }

    public String getSerolConsulta() {
        return serolConsulta;
    }

    public void setSerolConsulta(String serolConsulta) {
        this.serolConsulta = serolConsulta;
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
        hash += (seperCodigo != null ? seperCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.seperCodigo == null && other.seperCodigo != null) || (this.seperCodigo != null && !this.seperCodigo.equals(other.seperCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Rol[ seperCodigo=" + seperCodigo + " ]";
    }
    
}

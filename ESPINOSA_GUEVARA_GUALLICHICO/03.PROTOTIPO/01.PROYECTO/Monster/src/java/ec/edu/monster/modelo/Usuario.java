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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "seusu_usuari")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByEmpId", query = "SELECT u FROM Usuario u WHERE u.empId = :empId")
    , @NamedQuery(name = "Usuario.findByUsuContrasena", query = "SELECT u FROM Usuario u WHERE u.usuContrasena = :usuContrasena")
    , @NamedQuery(name = "Usuario.findByUsuPiefirma", query = "SELECT u FROM Usuario u WHERE u.usuPiefirma = :usuPiefirma")
    , @NamedQuery(name = "Usuario.findByUsuFechacreacion", query = "SELECT u FROM Usuario u WHERE u.usuFechacreacion = :usuFechacreacion")
    , @NamedQuery(name = "Usuario.findByUsuFechaultimocambio", query = "SELECT u FROM Usuario u WHERE u.usuFechaultimocambio = :usuFechaultimocambio")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMP_ID")
    private String empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "USU_CONTRASENA")
    private String usuContrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USU_PIEFIRMA")
    private String usuPiefirma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_FECHAULTIMOCAMBIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFechaultimocambio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<UsuarioPerfil> usuarioPerfilCollection;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleado empleado;
    @JoinColumn(name = "EST_CODIGO", referencedColumnName = "EST_CODIGO")
    @ManyToOne(optional = false)
    private Estado estCodigo;

    public Usuario() {
    }

    public Usuario(String empId) {
        this.empId = empId;
    }

    public Usuario(String empId, String usuContrasena, String usuPiefirma, Date usuFechacreacion, Date usuFechaultimocambio) {
        this.empId = empId;
        this.usuContrasena = usuContrasena;
        this.usuPiefirma = usuPiefirma;
        this.usuFechacreacion = usuFechacreacion;
        this.usuFechaultimocambio = usuFechaultimocambio;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getUsuContrasena() {
        return usuContrasena;
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena = usuContrasena;
    }

    public String getUsuPiefirma() {
        return usuPiefirma;
    }

    public void setUsuPiefirma(String usuPiefirma) {
        this.usuPiefirma = usuPiefirma;
    }

    public Date getUsuFechacreacion() {
        return usuFechacreacion;
    }

    public void setUsuFechacreacion(Date usuFechacreacion) {
        this.usuFechacreacion = usuFechacreacion;
    }

    public Date getUsuFechaultimocambio() {
        return usuFechaultimocambio;
    }

    public void setUsuFechaultimocambio(Date usuFechaultimocambio) {
        this.usuFechaultimocambio = usuFechaultimocambio;
    }

    @XmlTransient
    public Collection<UsuarioPerfil> getUsuarioPerfilCollection() {
        return usuarioPerfilCollection;
    }

    public void setUsuarioPerfilCollection(Collection<UsuarioPerfil> usuarioPerfilCollection) {
        this.usuarioPerfilCollection = usuarioPerfilCollection;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Estado getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Estado estCodigo) {
        this.estCodigo = estCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Usuario[ empId=" + empId + " ]";
    }
    
}

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
@Table(name = "cerub_rubpre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RubroPresupuestario.findAll", query = "SELECT r FROM RubroPresupuestario r")
    , @NamedQuery(name = "RubroPresupuestario.findByCerubCodigo", query = "SELECT r FROM RubroPresupuestario r WHERE r.cerubCodigo = :cerubCodigo")
    , @NamedQuery(name = "RubroPresupuestario.findByCerubCategoria", query = "SELECT r FROM RubroPresupuestario r WHERE r.cerubCategoria = :cerubCategoria")
    , @NamedQuery(name = "RubroPresupuestario.findByCerubPresupuesto", query = "SELECT r FROM RubroPresupuestario r WHERE r.cerubPresupuesto = :cerubPresupuesto")})
public class RubroPresupuestario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CERUB_CODIGO")
    private String cerubCodigo;
    @Size(max = 100)
    @Column(name = "CERUB_CATEGORIA")
    private String cerubCategoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CERUB_PRESUPUESTO")
    private Float cerubPresupuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cerubCodigo")
    private Collection<SolicitudCompra> solicitudCompraCollection;

    public RubroPresupuestario() {
    }

    public RubroPresupuestario(String cerubCodigo) {
        this.cerubCodigo = cerubCodigo;
    }

    public String getCerubCodigo() {
        return cerubCodigo;
    }

    public void setCerubCodigo(String cerubCodigo) {
        this.cerubCodigo = cerubCodigo;
    }

    public String getCerubCategoria() {
        return cerubCategoria;
    }

    public void setCerubCategoria(String cerubCategoria) {
        this.cerubCategoria = cerubCategoria;
    }

    public Float getCerubPresupuesto() {
        return cerubPresupuesto;
    }

    public void setCerubPresupuesto(Float cerubPresupuesto) {
        this.cerubPresupuesto = cerubPresupuesto;
    }

    @XmlTransient
    public Collection<SolicitudCompra> getSolicitudCompraCollection() {
        return solicitudCompraCollection;
    }

    public void setSolicitudCompraCollection(Collection<SolicitudCompra> solicitudCompraCollection) {
        this.solicitudCompraCollection = solicitudCompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cerubCodigo != null ? cerubCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RubroPresupuestario)) {
            return false;
        }
        RubroPresupuestario other = (RubroPresupuestario) object;
        if ((this.cerubCodigo == null && other.cerubCodigo != null) || (this.cerubCodigo != null && !this.cerubCodigo.equals(other.cerubCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.RubroPresupuestario[ cerubCodigo=" + cerubCodigo + " ]";
    }
    
}

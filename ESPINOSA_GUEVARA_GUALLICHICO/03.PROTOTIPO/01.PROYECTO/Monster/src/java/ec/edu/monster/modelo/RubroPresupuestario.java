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
 * @author Jonathan
 */
@Entity
@Table(name = "cerub_rubpre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RubroPresupuestario.findAll", query = "SELECT r FROM RubroPresupuestario r")
    , @NamedQuery(name = "RubroPresupuestario.findByRubCodigo", query = "SELECT r FROM RubroPresupuestario r WHERE r.rubCodigo = :rubCodigo")
    , @NamedQuery(name = "RubroPresupuestario.findByRubCategoria", query = "SELECT r FROM RubroPresupuestario r WHERE r.rubCategoria = :rubCategoria")
    , @NamedQuery(name = "RubroPresupuestario.findByRubPresupuesto", query = "SELECT r FROM RubroPresupuestario r WHERE r.rubPresupuesto = :rubPresupuesto")})
public class RubroPresupuestario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RUB_CODIGO")
    private String rubCodigo;
    @Size(max = 100)
    @Column(name = "RUB_CATEGORIA")
    private String rubCategoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RUB_PRESUPUESTO")
    private Float rubPresupuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rubCodigo")
    private Collection<SolicitudCompra> solicitudCompraCollection;

    public RubroPresupuestario() {
    }

    public RubroPresupuestario(String rubCodigo) {
        this.rubCodigo = rubCodigo;
    }

    public String getRubCodigo() {
        return rubCodigo;
    }

    public void setRubCodigo(String rubCodigo) {
        this.rubCodigo = rubCodigo;
    }

    public String getRubCategoria() {
        return rubCategoria;
    }

    public void setRubCategoria(String rubCategoria) {
        this.rubCategoria = rubCategoria;
    }

    public Float getRubPresupuesto() {
        return rubPresupuesto;
    }

    public void setRubPresupuesto(Float rubPresupuesto) {
        this.rubPresupuesto = rubPresupuesto;
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
        hash += (rubCodigo != null ? rubCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RubroPresupuestario)) {
            return false;
        }
        RubroPresupuestario other = (RubroPresupuestario) object;
        if ((this.rubCodigo == null && other.rubCodigo != null) || (this.rubCodigo != null && !this.rubCodigo.equals(other.rubCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.RubroPresupuestario[ rubCodigo=" + rubCodigo + " ]";
    }
    
}

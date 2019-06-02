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
 * @author Jonathan
 */
@Entity
@Table(name = "cesol_solcom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudCompra.findAll", query = "SELECT s FROM SolicitudCompra s")
    , @NamedQuery(name = "SolicitudCompra.findBySolNumero", query = "SELECT s FROM SolicitudCompra s WHERE s.solNumero = :solNumero")
    , @NamedQuery(name = "SolicitudCompra.findBySolFecha", query = "SELECT s FROM SolicitudCompra s WHERE s.solFecha = :solFecha")
    , @NamedQuery(name = "SolicitudCompra.findBySolAprobaciondirectorfinanciero", query = "SELECT s FROM SolicitudCompra s WHERE s.solAprobaciondirectorfinanciero = :solAprobaciondirectorfinanciero")
    , @NamedQuery(name = "SolicitudCompra.findBySolAprobacionjefearea", query = "SELECT s FROM SolicitudCompra s WHERE s.solAprobacionjefearea = :solAprobacionjefearea")
    , @NamedQuery(name = "SolicitudCompra.findBySolTotal", query = "SELECT s FROM SolicitudCompra s WHERE s.solTotal = :solTotal")})
public class SolicitudCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SOL_NUMERO")
    private String solNumero;
    @Column(name = "SOL_FECHA")
    @Temporal(TemporalType.DATE)
    private Date solFecha;
    @Column(name = "SOL_APROBACIONDIRECTORFINANCIERO")
    private Boolean solAprobaciondirectorfinanciero;
    @Column(name = "SOL_APROBACIONJEFEAREA")
    private Boolean solAprobacionjefearea;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SOL_TOTAL")
    private Float solTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudCompra")
    private Collection<ItemSolicitud> itemSolicitudCollection;
    @JoinColumn(name = "RUB_CODIGO", referencedColumnName = "RUB_CODIGO")
    @ManyToOne(optional = false)
    private RubroPresupuestario rubCodigo;
    @JoinColumn(name = "ARE_ID", referencedColumnName = "ARE_ID")
    @ManyToOne(optional = false)
    private Area areId;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(optional = false)
    private Empleado empId;

    public SolicitudCompra() {
    }

    public SolicitudCompra(String solNumero) {
        this.solNumero = solNumero;
    }

    public String getSolNumero() {
        return solNumero;
    }

    public void setSolNumero(String solNumero) {
        this.solNumero = solNumero;
    }

    public Date getSolFecha() {
        return solFecha;
    }

    public void setSolFecha(Date solFecha) {
        this.solFecha = solFecha;
    }

    public Boolean getSolAprobaciondirectorfinanciero() {
        return solAprobaciondirectorfinanciero;
    }

    public void setSolAprobaciondirectorfinanciero(Boolean solAprobaciondirectorfinanciero) {
        this.solAprobaciondirectorfinanciero = solAprobaciondirectorfinanciero;
    }

    public Boolean getSolAprobacionjefearea() {
        return solAprobacionjefearea;
    }

    public void setSolAprobacionjefearea(Boolean solAprobacionjefearea) {
        this.solAprobacionjefearea = solAprobacionjefearea;
    }

    public Float getSolTotal() {
        return solTotal;
    }

    public void setSolTotal(Float solTotal) {
        this.solTotal = solTotal;
    }

    @XmlTransient
    public Collection<ItemSolicitud> getItemSolicitudCollection() {
        return itemSolicitudCollection;
    }

    public void setItemSolicitudCollection(Collection<ItemSolicitud> itemSolicitudCollection) {
        this.itemSolicitudCollection = itemSolicitudCollection;
    }

    public RubroPresupuestario getRubCodigo() {
        return rubCodigo;
    }

    public void setRubCodigo(RubroPresupuestario rubCodigo) {
        this.rubCodigo = rubCodigo;
    }

    public Area getAreId() {
        return areId;
    }

    public void setAreId(Area areId) {
        this.areId = areId;
    }

    public Empleado getEmpId() {
        return empId;
    }

    public void setEmpId(Empleado empId) {
        this.empId = empId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solNumero != null ? solNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudCompra)) {
            return false;
        }
        SolicitudCompra other = (SolicitudCompra) object;
        if ((this.solNumero == null && other.solNumero != null) || (this.solNumero != null && !this.solNumero.equals(other.solNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.SolicitudCompra[ solNumero=" + solNumero + " ]";
    }
    
}

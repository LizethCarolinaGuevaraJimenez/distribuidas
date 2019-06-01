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
@Table(name = "aesal_salalm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalidaAlmacen.findAll", query = "SELECT s FROM SalidaAlmacen s")
    , @NamedQuery(name = "SalidaAlmacen.findBySalNumero", query = "SELECT s FROM SalidaAlmacen s WHERE s.salNumero = :salNumero")
    , @NamedQuery(name = "SalidaAlmacen.findBySalFechasalida", query = "SELECT s FROM SalidaAlmacen s WHERE s.salFechasalida = :salFechasalida")
    , @NamedQuery(name = "SalidaAlmacen.findBySalFechaentrega", query = "SELECT s FROM SalidaAlmacen s WHERE s.salFechaentrega = :salFechaentrega")})
public class SalidaAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SAL_NUMERO")
    private String salNumero;
    @Column(name = "SAL_FECHASALIDA")
    @Temporal(TemporalType.DATE)
    private Date salFechasalida;
    @Column(name = "SAL_FECHAENTREGA")
    @Temporal(TemporalType.DATE)
    private Date salFechaentrega;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(optional = false)
    private Empleado empId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salidaAlmacen")
    private Collection<ItemSalida> itemSalidaCollection;

    public SalidaAlmacen() {
    }

    public SalidaAlmacen(String salNumero) {
        this.salNumero = salNumero;
    }

    public String getSalNumero() {
        return salNumero;
    }

    public void setSalNumero(String salNumero) {
        this.salNumero = salNumero;
    }

    public Date getSalFechasalida() {
        return salFechasalida;
    }

    public void setSalFechasalida(Date salFechasalida) {
        this.salFechasalida = salFechasalida;
    }

    public Date getSalFechaentrega() {
        return salFechaentrega;
    }

    public void setSalFechaentrega(Date salFechaentrega) {
        this.salFechaentrega = salFechaentrega;
    }

    public Empleado getEmpId() {
        return empId;
    }

    public void setEmpId(Empleado empId) {
        this.empId = empId;
    }

    @XmlTransient
    public Collection<ItemSalida> getItemSalidaCollection() {
        return itemSalidaCollection;
    }

    public void setItemSalidaCollection(Collection<ItemSalida> itemSalidaCollection) {
        this.itemSalidaCollection = itemSalidaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salNumero != null ? salNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaAlmacen)) {
            return false;
        }
        SalidaAlmacen other = (SalidaAlmacen) object;
        if ((this.salNumero == null && other.salNumero != null) || (this.salNumero != null && !this.salNumero.equals(other.salNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.SalidaAlmacen[ salNumero=" + salNumero + " ]";
    }
    
}

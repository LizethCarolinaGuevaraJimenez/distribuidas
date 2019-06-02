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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "peemp_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByEmpId", query = "SELECT e FROM Empleado e WHERE e.empId = :empId")
    , @NamedQuery(name = "Empleado.findByEmpCedula", query = "SELECT e FROM Empleado e WHERE e.empCedula = :empCedula")
    , @NamedQuery(name = "Empleado.findByEmpNombre", query = "SELECT e FROM Empleado e WHERE e.empNombre = :empNombre")
    , @NamedQuery(name = "Empleado.findByEmpTelefono", query = "SELECT e FROM Empleado e WHERE e.empTelefono = :empTelefono")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMP_ID")
    private String empId;
    @Size(max = 15)
    @Column(name = "EMP_CEDULA")
    private String empCedula;
    @Size(max = 100)
    @Column(name = "EMP_NOMBRE")
    private String empNombre;
    @Size(max = 10)
    @Column(name = "EMP_TELEFONO")
    private String empTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empId")
    private Collection<SalidaAlmacen> salidaAlmacenCollection;
    @JoinColumn(name = "CAR_ID", referencedColumnName = "CAR_ID")
    @ManyToOne(optional = false)
    private Cargo carId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empId")
    private Collection<SolicitudCompra> solicitudCompraCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Collection<ItemSalida> itemSalidaCollection;

    public Empleado() {
    }

    public Empleado(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpCedula() {
        return empCedula;
    }

    public void setEmpCedula(String empCedula) {
        this.empCedula = empCedula;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpTelefono() {
        return empTelefono;
    }

    public void setEmpTelefono(String empTelefono) {
        this.empTelefono = empTelefono;
    }

    @XmlTransient
    public Collection<SalidaAlmacen> getSalidaAlmacenCollection() {
        return salidaAlmacenCollection;
    }

    public void setSalidaAlmacenCollection(Collection<SalidaAlmacen> salidaAlmacenCollection) {
        this.salidaAlmacenCollection = salidaAlmacenCollection;
    }

    public Cargo getCarId() {
        return carId;
    }

    public void setCarId(Cargo carId) {
        this.carId = carId;
    }

    @XmlTransient
    public Collection<SolicitudCompra> getSolicitudCompraCollection() {
        return solicitudCompraCollection;
    }

    public void setSolicitudCompraCollection(Collection<SolicitudCompra> solicitudCompraCollection) {
        this.solicitudCompraCollection = solicitudCompraCollection;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Empleado[ empId=" + empId + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "aeite_itesal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemSalida.findAll", query = "SELECT i FROM ItemSalida i")
    , @NamedQuery(name = "ItemSalida.findBySalNumero", query = "SELECT i FROM ItemSalida i WHERE i.itemSalidaPK.salNumero = :salNumero")
    , @NamedQuery(name = "ItemSalida.findByBienId", query = "SELECT i FROM ItemSalida i WHERE i.itemSalidaPK.bienId = :bienId")
    , @NamedQuery(name = "ItemSalida.findByEmpId", query = "SELECT i FROM ItemSalida i WHERE i.itemSalidaPK.empId = :empId")
    , @NamedQuery(name = "ItemSalida.findByItesaCantidadentregada", query = "SELECT i FROM ItemSalida i WHERE i.itesaCantidadentregada = :itesaCantidadentregada")})
public class ItemSalida implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemSalidaPK itemSalidaPK;
    @Column(name = "ITESA_CANTIDADENTREGADA")
    private Integer itesaCantidadentregada;
    @JoinColumn(name = "SAL_NUMERO", referencedColumnName = "SAL_NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalidaAlmacen salidaAlmacen;
    @JoinColumn(name = "BIEN_ID", referencedColumnName = "BIEN_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bienes bienes;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;

    public ItemSalida() {
    }

    public ItemSalida(ItemSalidaPK itemSalidaPK) {
        this.itemSalidaPK = itemSalidaPK;
    }

    public ItemSalida(String salNumero, String bienId, String empId) {
        this.itemSalidaPK = new ItemSalidaPK(salNumero, bienId, empId);
    }

    public ItemSalidaPK getItemSalidaPK() {
        return itemSalidaPK;
    }

    public void setItemSalidaPK(ItemSalidaPK itemSalidaPK) {
        this.itemSalidaPK = itemSalidaPK;
    }

    public Integer getItesaCantidadentregada() {
        return itesaCantidadentregada;
    }

    public void setItesaCantidadentregada(Integer itesaCantidadentregada) {
        this.itesaCantidadentregada = itesaCantidadentregada;
    }

    public SalidaAlmacen getSalidaAlmacen() {
        return salidaAlmacen;
    }

    public void setSalidaAlmacen(SalidaAlmacen salidaAlmacen) {
        this.salidaAlmacen = salidaAlmacen;
    }

    public Bienes getBienes() {
        return bienes;
    }

    public void setBienes(Bienes bienes) {
        this.bienes = bienes;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemSalidaPK != null ? itemSalidaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemSalida)) {
            return false;
        }
        ItemSalida other = (ItemSalida) object;
        if ((this.itemSalidaPK == null && other.itemSalidaPK != null) || (this.itemSalidaPK != null && !this.itemSalidaPK.equals(other.itemSalidaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.ItemSalida[ itemSalidaPK=" + itemSalidaPK + " ]";
    }
    
}

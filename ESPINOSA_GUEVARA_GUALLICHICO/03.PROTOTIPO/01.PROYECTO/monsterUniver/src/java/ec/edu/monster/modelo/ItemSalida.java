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
 * @author pablo
 */
@Entity
@Table(name = "aeite_itesal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemSalida.findAll", query = "SELECT i FROM ItemSalida i")
    , @NamedQuery(name = "ItemSalida.findByPeempId", query = "SELECT i FROM ItemSalida i WHERE i.itemSalidaPK.peempId = :peempId")
    , @NamedQuery(name = "ItemSalida.findByAesalNumero", query = "SELECT i FROM ItemSalida i WHERE i.itemSalidaPK.aesalNumero = :aesalNumero")
    , @NamedQuery(name = "ItemSalida.findByMebieId", query = "SELECT i FROM ItemSalida i WHERE i.itemSalidaPK.mebieId = :mebieId")
    , @NamedQuery(name = "ItemSalida.findByAeiteCantientr", query = "SELECT i FROM ItemSalida i WHERE i.aeiteCantientr = :aeiteCantientr")})
public class ItemSalida implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemSalidaPK itemSalidaPK;
    @Column(name = "AEITE_CANTIENTR")
    private Integer aeiteCantientr;
    @JoinColumn(name = "MEBIE_ID", referencedColumnName = "MEBIE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bienes bienes;
    @JoinColumn(name = "PEEMP_ID", referencedColumnName = "PEEMP_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;
    @JoinColumn(name = "AESAL_NUMERO", referencedColumnName = "AESAL_NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalidaAlmacen salidaAlmacen;

    public ItemSalida() {
    }

    public ItemSalida(ItemSalidaPK itemSalidaPK) {
        this.itemSalidaPK = itemSalidaPK;
    }

    public ItemSalida(String peempId, String aesalNumero, String mebieId) {
        this.itemSalidaPK = new ItemSalidaPK(peempId, aesalNumero, mebieId);
    }

    public ItemSalidaPK getItemSalidaPK() {
        return itemSalidaPK;
    }

    public void setItemSalidaPK(ItemSalidaPK itemSalidaPK) {
        this.itemSalidaPK = itemSalidaPK;
    }

    public Integer getAeiteCantientr() {
        return aeiteCantientr;
    }

    public void setAeiteCantientr(Integer aeiteCantientr) {
        this.aeiteCantientr = aeiteCantientr;
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

    public SalidaAlmacen getSalidaAlmacen() {
        return salidaAlmacen;
    }

    public void setSalidaAlmacen(SalidaAlmacen salidaAlmacen) {
        this.salidaAlmacen = salidaAlmacen;
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

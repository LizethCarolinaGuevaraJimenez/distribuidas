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
@Table(name = "aeite_iteent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemEntrada.findAll", query = "SELECT i FROM ItemEntrada i")
    , @NamedQuery(name = "ItemEntrada.findByAeentNumero", query = "SELECT i FROM ItemEntrada i WHERE i.itemEntradaPK.aeentNumero = :aeentNumero")
    , @NamedQuery(name = "ItemEntrada.findByMebieId", query = "SELECT i FROM ItemEntrada i WHERE i.itemEntradaPK.mebieId = :mebieId")
    , @NamedQuery(name = "ItemEntrada.findByAeiteCantentrega", query = "SELECT i FROM ItemEntrada i WHERE i.aeiteCantentrega = :aeiteCantentrega")})
public class ItemEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemEntradaPK itemEntradaPK;
    @Column(name = "AEITE_CANTENTREGA")
    private Integer aeiteCantentrega;
    @JoinColumn(name = "MEBIE_ID", referencedColumnName = "MEBIE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bienes bienes;
    @JoinColumn(name = "AEENT_NUMERO", referencedColumnName = "AEENT_NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EntradaAlmacen entradaAlmacen;

    public ItemEntrada() {
    }

    public ItemEntrada(ItemEntradaPK itemEntradaPK) {
        this.itemEntradaPK = itemEntradaPK;
    }

    public ItemEntrada(String aeentNumero, String mebieId) {
        this.itemEntradaPK = new ItemEntradaPK(aeentNumero, mebieId);
    }

    public ItemEntradaPK getItemEntradaPK() {
        return itemEntradaPK;
    }

    public void setItemEntradaPK(ItemEntradaPK itemEntradaPK) {
        this.itemEntradaPK = itemEntradaPK;
    }

    public Integer getAeiteCantentrega() {
        return aeiteCantentrega;
    }

    public void setAeiteCantentrega(Integer aeiteCantentrega) {
        this.aeiteCantentrega = aeiteCantentrega;
    }

    public Bienes getBienes() {
        return bienes;
    }

    public void setBienes(Bienes bienes) {
        this.bienes = bienes;
    }

    public EntradaAlmacen getEntradaAlmacen() {
        return entradaAlmacen;
    }

    public void setEntradaAlmacen(EntradaAlmacen entradaAlmacen) {
        this.entradaAlmacen = entradaAlmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemEntradaPK != null ? itemEntradaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemEntrada)) {
            return false;
        }
        ItemEntrada other = (ItemEntrada) object;
        if ((this.itemEntradaPK == null && other.itemEntradaPK != null) || (this.itemEntradaPK != null && !this.itemEntradaPK.equals(other.itemEntradaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.ItemEntrada[ itemEntradaPK=" + itemEntradaPK + " ]";
    }
    
}

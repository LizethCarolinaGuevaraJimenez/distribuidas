/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "ceite_itesol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemSolicitud.findAll", query = "SELECT i FROM ItemSolicitud i")
    , @NamedQuery(name = "ItemSolicitud.findBySolNumero", query = "SELECT i FROM ItemSolicitud i WHERE i.itemSolicitudPK.solNumero = :solNumero")
    , @NamedQuery(name = "ItemSolicitud.findByBienId", query = "SELECT i FROM ItemSolicitud i WHERE i.itemSolicitudPK.bienId = :bienId")
    , @NamedQuery(name = "ItemSolicitud.findByItesCantidadsolicitada", query = "SELECT i FROM ItemSolicitud i WHERE i.itesCantidadsolicitada = :itesCantidadsolicitada")
    , @NamedQuery(name = "ItemSolicitud.findByItesCantidaddespachada", query = "SELECT i FROM ItemSolicitud i WHERE i.itesCantidaddespachada = :itesCantidaddespachada")
    , @NamedQuery(name = "ItemSolicitud.findByItesValortotal", query = "SELECT i FROM ItemSolicitud i WHERE i.itesValortotal = :itesValortotal")})
public class ItemSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemSolicitudPK itemSolicitudPK;
    @Column(name = "ITES_CANTIDADSOLICITADA")
    private Integer itesCantidadsolicitada;
    @Column(name = "ITES_CANTIDADDESPACHADA")
    private Integer itesCantidaddespachada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ITES_VALORTOTAL")
    private Float itesValortotal;
    @JoinTable(name = "medet_detord", joinColumns = {
        @JoinColumn(name = "SOL_NUMERO", referencedColumnName = "SOL_NUMERO")
        , @JoinColumn(name = "BIEN_ID", referencedColumnName = "BIEN_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ORD_NUMERO", referencedColumnName = "ORD_NUMERO")})
    @ManyToMany
    private Collection<OrdenContractual> ordenContractualCollection;
    @JoinColumn(name = "SOL_NUMERO", referencedColumnName = "SOL_NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SolicitudCompra solicitudCompra;
    @JoinColumn(name = "BIEN_ID", referencedColumnName = "BIEN_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bienes bienes;

    public ItemSolicitud() {
    }

    public ItemSolicitud(ItemSolicitudPK itemSolicitudPK) {
        this.itemSolicitudPK = itemSolicitudPK;
    }

    public ItemSolicitud(String solNumero, String bienId) {
        this.itemSolicitudPK = new ItemSolicitudPK(solNumero, bienId);
    }

    public ItemSolicitudPK getItemSolicitudPK() {
        return itemSolicitudPK;
    }

    public void setItemSolicitudPK(ItemSolicitudPK itemSolicitudPK) {
        this.itemSolicitudPK = itemSolicitudPK;
    }

    public Integer getItesCantidadsolicitada() {
        return itesCantidadsolicitada;
    }

    public void setItesCantidadsolicitada(Integer itesCantidadsolicitada) {
        this.itesCantidadsolicitada = itesCantidadsolicitada;
    }

    public Integer getItesCantidaddespachada() {
        return itesCantidaddespachada;
    }

    public void setItesCantidaddespachada(Integer itesCantidaddespachada) {
        this.itesCantidaddespachada = itesCantidaddespachada;
    }

    public Float getItesValortotal() {
        return itesValortotal;
    }

    public void setItesValortotal(Float itesValortotal) {
        this.itesValortotal = itesValortotal;
    }

    @XmlTransient
    public Collection<OrdenContractual> getOrdenContractualCollection() {
        return ordenContractualCollection;
    }

    public void setOrdenContractualCollection(Collection<OrdenContractual> ordenContractualCollection) {
        this.ordenContractualCollection = ordenContractualCollection;
    }

    public SolicitudCompra getSolicitudCompra() {
        return solicitudCompra;
    }

    public void setSolicitudCompra(SolicitudCompra solicitudCompra) {
        this.solicitudCompra = solicitudCompra;
    }

    public Bienes getBienes() {
        return bienes;
    }

    public void setBienes(Bienes bienes) {
        this.bienes = bienes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemSolicitudPK != null ? itemSolicitudPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemSolicitud)) {
            return false;
        }
        ItemSolicitud other = (ItemSolicitud) object;
        if ((this.itemSolicitudPK == null && other.itemSolicitudPK != null) || (this.itemSolicitudPK != null && !this.itemSolicitudPK.equals(other.itemSolicitudPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.ItemSolicitud[ itemSolicitudPK=" + itemSolicitudPK + " ]";
    }
    
}

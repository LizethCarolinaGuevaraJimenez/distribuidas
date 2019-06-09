/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "ceite_itesol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemSolicitud.findAll", query = "SELECT i FROM ItemSolicitud i")
    , @NamedQuery(name = "ItemSolicitud.findByCesolNumero", query = "SELECT i FROM ItemSolicitud i WHERE i.itemSolicitudPK.cesolNumero = :cesolNumero")
    , @NamedQuery(name = "ItemSolicitud.findByMebieId", query = "SELECT i FROM ItemSolicitud i WHERE i.itemSolicitudPK.mebieId = :mebieId")
    , @NamedQuery(name = "ItemSolicitud.findByCeiteCantidadsalida", query = "SELECT i FROM ItemSolicitud i WHERE i.ceiteCantidadsalida = :ceiteCantidadsalida")
    , @NamedQuery(name = "ItemSolicitud.findByCeiteCantidaddespachada", query = "SELECT i FROM ItemSolicitud i WHERE i.ceiteCantidaddespachada = :ceiteCantidaddespachada")
    , @NamedQuery(name = "ItemSolicitud.findByCeiteValortotal", query = "SELECT i FROM ItemSolicitud i WHERE i.ceiteValortotal = :ceiteValortotal")})
public class ItemSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemSolicitudPK itemSolicitudPK;
    @Column(name = "CEITE_CANTIDADSALIDA")
    private Integer ceiteCantidadsalida;
    @Column(name = "CEITE_CANTIDADDESPACHADA")
    private Integer ceiteCantidaddespachada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CEITE_VALORTOTAL")
    private Float ceiteValortotal;
    @JoinColumn(name = "MEBIE_ID", referencedColumnName = "MEBIE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bienes bienes;
    @JoinColumn(name = "CESOL_NUMERO", referencedColumnName = "CESOL_NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SolicitudCompra solicitudCompra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemSolicitud")
    private Collection<DetalleOrden> detalleOrdenCollection;

    public ItemSolicitud() {
    }

    public ItemSolicitud(ItemSolicitudPK itemSolicitudPK) {
        this.itemSolicitudPK = itemSolicitudPK;
    }

    public ItemSolicitud(String cesolNumero, String mebieId) {
        this.itemSolicitudPK = new ItemSolicitudPK(cesolNumero, mebieId);
    }

    public ItemSolicitudPK getItemSolicitudPK() {
        return itemSolicitudPK;
    }

    public void setItemSolicitudPK(ItemSolicitudPK itemSolicitudPK) {
        this.itemSolicitudPK = itemSolicitudPK;
    }

    public Integer getCeiteCantidadsalida() {
        return ceiteCantidadsalida;
    }

    public void setCeiteCantidadsalida(Integer ceiteCantidadsalida) {
        this.ceiteCantidadsalida = ceiteCantidadsalida;
    }

    public Integer getCeiteCantidaddespachada() {
        return ceiteCantidaddespachada;
    }

    public void setCeiteCantidaddespachada(Integer ceiteCantidaddespachada) {
        this.ceiteCantidaddespachada = ceiteCantidaddespachada;
    }

    public Float getCeiteValortotal() {
        return ceiteValortotal;
    }

    public void setCeiteValortotal(Float ceiteValortotal) {
        this.ceiteValortotal = ceiteValortotal;
    }

    public Bienes getBienes() {
        return bienes;
    }

    public void setBienes(Bienes bienes) {
        this.bienes = bienes;
    }

    public SolicitudCompra getSolicitudCompra() {
        return solicitudCompra;
    }

    public void setSolicitudCompra(SolicitudCompra solicitudCompra) {
        this.solicitudCompra = solicitudCompra;
    }

    @XmlTransient
    public Collection<DetalleOrden> getDetalleOrdenCollection() {
        return detalleOrdenCollection;
    }

    public void setDetalleOrdenCollection(Collection<DetalleOrden> detalleOrdenCollection) {
        this.detalleOrdenCollection = detalleOrdenCollection;
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

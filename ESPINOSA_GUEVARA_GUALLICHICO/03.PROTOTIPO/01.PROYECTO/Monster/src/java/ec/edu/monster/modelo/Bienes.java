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
@Table(name = "mebie_bienes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bienes.findAll", query = "SELECT b FROM Bienes b")
    , @NamedQuery(name = "Bienes.findByBienId", query = "SELECT b FROM Bienes b WHERE b.bienId = :bienId")
    , @NamedQuery(name = "Bienes.findByBienNombre", query = "SELECT b FROM Bienes b WHERE b.bienNombre = :bienNombre")
    , @NamedQuery(name = "Bienes.findByBienUnidadmedida", query = "SELECT b FROM Bienes b WHERE b.bienUnidadmedida = :bienUnidadmedida")
    , @NamedQuery(name = "Bienes.findByBienTipo", query = "SELECT b FROM Bienes b WHERE b.bienTipo = :bienTipo")})
public class Bienes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BIEN_ID")
    private String bienId;
    @Size(max = 100)
    @Column(name = "BIEN_NOMBRE")
    private String bienNombre;
    @Size(max = 100)
    @Column(name = "BIEN_UNIDADMEDIDA")
    private String bienUnidadmedida;
    @Size(max = 100)
    @Column(name = "BIEN_TIPO")
    private String bienTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienId")
    private Collection<Stock> stockCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienes")
    private Collection<ItemSolicitud> itemSolicitudCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienes")
    private Collection<ItemEntrada> itemEntradaCollection;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne(optional = false)
    private Proveedor proId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienes")
    private Collection<ItemSalida> itemSalidaCollection;

    public Bienes() {
    }

    public Bienes(String bienId) {
        this.bienId = bienId;
    }

    public String getBienId() {
        return bienId;
    }

    public void setBienId(String bienId) {
        this.bienId = bienId;
    }

    public String getBienNombre() {
        return bienNombre;
    }

    public void setBienNombre(String bienNombre) {
        this.bienNombre = bienNombre;
    }

    public String getBienUnidadmedida() {
        return bienUnidadmedida;
    }

    public void setBienUnidadmedida(String bienUnidadmedida) {
        this.bienUnidadmedida = bienUnidadmedida;
    }

    public String getBienTipo() {
        return bienTipo;
    }

    public void setBienTipo(String bienTipo) {
        this.bienTipo = bienTipo;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    @XmlTransient
    public Collection<ItemSolicitud> getItemSolicitudCollection() {
        return itemSolicitudCollection;
    }

    public void setItemSolicitudCollection(Collection<ItemSolicitud> itemSolicitudCollection) {
        this.itemSolicitudCollection = itemSolicitudCollection;
    }

    @XmlTransient
    public Collection<ItemEntrada> getItemEntradaCollection() {
        return itemEntradaCollection;
    }

    public void setItemEntradaCollection(Collection<ItemEntrada> itemEntradaCollection) {
        this.itemEntradaCollection = itemEntradaCollection;
    }

    public Proveedor getProId() {
        return proId;
    }

    public void setProId(Proveedor proId) {
        this.proId = proId;
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
        hash += (bienId != null ? bienId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bienes)) {
            return false;
        }
        Bienes other = (Bienes) object;
        if ((this.bienId == null && other.bienId != null) || (this.bienId != null && !this.bienId.equals(other.bienId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Bienes[ bienId=" + bienId + " ]";
    }
    
}

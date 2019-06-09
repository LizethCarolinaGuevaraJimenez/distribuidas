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
 * @author pablo
 */
@Entity
@Table(name = "mebie_bienes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bienes.findAll", query = "SELECT b FROM Bienes b")
    , @NamedQuery(name = "Bienes.findByMebieId", query = "SELECT b FROM Bienes b WHERE b.mebieId = :mebieId")
    , @NamedQuery(name = "Bienes.findByMebieNombre", query = "SELECT b FROM Bienes b WHERE b.mebieNombre = :mebieNombre")
    , @NamedQuery(name = "Bienes.findByMebieUmedida", query = "SELECT b FROM Bienes b WHERE b.mebieUmedida = :mebieUmedida")
    , @NamedQuery(name = "Bienes.findByMebieTipo", query = "SELECT b FROM Bienes b WHERE b.mebieTipo = :mebieTipo")})
public class Bienes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MEBIE_ID")
    private String mebieId;
    @Size(max = 100)
    @Column(name = "MEBIE_NOMBRE")
    private String mebieNombre;
    @Size(max = 100)
    @Column(name = "MEBIE_UMEDIDA")
    private String mebieUmedida;
    @Size(max = 100)
    @Column(name = "MEBIE_TIPO")
    private String mebieTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mebieId")
    private Collection<Stock> stockCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienes")
    private Collection<ItemSolicitud> itemSolicitudCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienes")
    private Collection<ItemEntrada> itemEntradaCollection;
    @JoinColumn(name = "AEPRO_ID", referencedColumnName = "AEPRO_ID")
    @ManyToOne(optional = false)
    private Proveedor aeproId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienes")
    private Collection<ItemSalida> itemSalidaCollection;

    public Bienes() {
    }

    public Bienes(String mebieId) {
        this.mebieId = mebieId;
    }

    public String getMebieId() {
        return mebieId;
    }

    public void setMebieId(String mebieId) {
        this.mebieId = mebieId;
    }

    public String getMebieNombre() {
        return mebieNombre;
    }

    public void setMebieNombre(String mebieNombre) {
        this.mebieNombre = mebieNombre;
    }

    public String getMebieUmedida() {
        return mebieUmedida;
    }

    public void setMebieUmedida(String mebieUmedida) {
        this.mebieUmedida = mebieUmedida;
    }

    public String getMebieTipo() {
        return mebieTipo;
    }

    public void setMebieTipo(String mebieTipo) {
        this.mebieTipo = mebieTipo;
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

    public Proveedor getAeproId() {
        return aeproId;
    }

    public void setAeproId(Proveedor aeproId) {
        this.aeproId = aeproId;
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
        hash += (mebieId != null ? mebieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bienes)) {
            return false;
        }
        Bienes other = (Bienes) object;
        if ((this.mebieId == null && other.mebieId != null) || (this.mebieId != null && !this.mebieId.equals(other.mebieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return mebieNombre;//"ec.edu.monster.modelo.Bienes[ mebieId=" + mebieId + " ]";
    }
    
}

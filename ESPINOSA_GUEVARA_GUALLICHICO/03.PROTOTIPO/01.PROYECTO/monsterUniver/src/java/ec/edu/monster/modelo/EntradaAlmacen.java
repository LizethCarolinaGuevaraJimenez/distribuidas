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
 * @author pablo
 */
@Entity
@Table(name = "aeent_entalm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntradaAlmacen.findAll", query = "SELECT e FROM EntradaAlmacen e")
    , @NamedQuery(name = "EntradaAlmacen.findByAeentNumero", query = "SELECT e FROM EntradaAlmacen e WHERE e.aeentNumero = :aeentNumero")
    , @NamedQuery(name = "EntradaAlmacen.findByAeentFecha", query = "SELECT e FROM EntradaAlmacen e WHERE e.aeentFecha = :aeentFecha")
    , @NamedQuery(name = "EntradaAlmacen.findByAeentNumfactura", query = "SELECT e FROM EntradaAlmacen e WHERE e.aeentNumfactura = :aeentNumfactura")
    , @NamedQuery(name = "EntradaAlmacen.findByAeentTotalbienes", query = "SELECT e FROM EntradaAlmacen e WHERE e.aeentTotalbienes = :aeentTotalbienes")
    , @NamedQuery(name = "EntradaAlmacen.findByAeentValortot", query = "SELECT e FROM EntradaAlmacen e WHERE e.aeentValortot = :aeentValortot")})
public class EntradaAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AEENT_NUMERO")
    private String aeentNumero;
    @Column(name = "AEENT_FECHA")
    @Temporal(TemporalType.DATE)
    private Date aeentFecha;
    @Size(max = 100)
    @Column(name = "AEENT_NUMFACTURA")
    private String aeentNumfactura;
    @Column(name = "AEENT_TOTALBIENES")
    private Integer aeentTotalbienes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AEENT_VALORTOT")
    private Float aeentValortot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entradaAlmacen")
    private Collection<ItemEntrada> itemEntradaCollection;

    public EntradaAlmacen() {
    }

    public EntradaAlmacen(String aeentNumero) {
        this.aeentNumero = aeentNumero;
    }

    public String getAeentNumero() {
        return aeentNumero;
    }

    public void setAeentNumero(String aeentNumero) {
        this.aeentNumero = aeentNumero;
    }

    public Date getAeentFecha() {
        return aeentFecha;
    }

    public void setAeentFecha(Date aeentFecha) {
        this.aeentFecha = aeentFecha;
    }

    public String getAeentNumfactura() {
        return aeentNumfactura;
    }

    public void setAeentNumfactura(String aeentNumfactura) {
        this.aeentNumfactura = aeentNumfactura;
    }

    public Integer getAeentTotalbienes() {
        return aeentTotalbienes;
    }

    public void setAeentTotalbienes(Integer aeentTotalbienes) {
        this.aeentTotalbienes = aeentTotalbienes;
    }

    public Float getAeentValortot() {
        return aeentValortot;
    }

    public void setAeentValortot(Float aeentValortot) {
        this.aeentValortot = aeentValortot;
    }

    @XmlTransient
    public Collection<ItemEntrada> getItemEntradaCollection() {
        return itemEntradaCollection;
    }

    public void setItemEntradaCollection(Collection<ItemEntrada> itemEntradaCollection) {
        this.itemEntradaCollection = itemEntradaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aeentNumero != null ? aeentNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaAlmacen)) {
            return false;
        }
        EntradaAlmacen other = (EntradaAlmacen) object;
        if ((this.aeentNumero == null && other.aeentNumero != null) || (this.aeentNumero != null && !this.aeentNumero.equals(other.aeentNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.EntradaAlmacen[ aeentNumero=" + aeentNumero + " ]";
    }
    
}

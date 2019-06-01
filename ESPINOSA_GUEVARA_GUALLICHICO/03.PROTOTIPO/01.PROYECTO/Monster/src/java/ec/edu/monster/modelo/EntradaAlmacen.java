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
 * @author Jonathan
 */
@Entity
@Table(name = "aeent_entalm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntradaAlmacen.findAll", query = "SELECT e FROM EntradaAlmacen e")
    , @NamedQuery(name = "EntradaAlmacen.findByEntNumero", query = "SELECT e FROM EntradaAlmacen e WHERE e.entNumero = :entNumero")
    , @NamedQuery(name = "EntradaAlmacen.findByEntFecha", query = "SELECT e FROM EntradaAlmacen e WHERE e.entFecha = :entFecha")
    , @NamedQuery(name = "EntradaAlmacen.findByEntNumerofactura", query = "SELECT e FROM EntradaAlmacen e WHERE e.entNumerofactura = :entNumerofactura")
    , @NamedQuery(name = "EntradaAlmacen.findByEntTotalbienes", query = "SELECT e FROM EntradaAlmacen e WHERE e.entTotalbienes = :entTotalbienes")
    , @NamedQuery(name = "EntradaAlmacen.findByEntValortotal", query = "SELECT e FROM EntradaAlmacen e WHERE e.entValortotal = :entValortotal")})
public class EntradaAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ENT_NUMERO")
    private String entNumero;
    @Column(name = "ENT_FECHA")
    @Temporal(TemporalType.DATE)
    private Date entFecha;
    @Size(max = 100)
    @Column(name = "ENT_NUMEROFACTURA")
    private String entNumerofactura;
    @Column(name = "ENT_TOTALBIENES")
    private Integer entTotalbienes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ENT_VALORTOTAL")
    private Float entValortotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entradaAlmacen")
    private Collection<ItemEntrada> itemEntradaCollection;

    public EntradaAlmacen() {
    }

    public EntradaAlmacen(String entNumero) {
        this.entNumero = entNumero;
    }

    public String getEntNumero() {
        return entNumero;
    }

    public void setEntNumero(String entNumero) {
        this.entNumero = entNumero;
    }

    public Date getEntFecha() {
        return entFecha;
    }

    public void setEntFecha(Date entFecha) {
        this.entFecha = entFecha;
    }

    public String getEntNumerofactura() {
        return entNumerofactura;
    }

    public void setEntNumerofactura(String entNumerofactura) {
        this.entNumerofactura = entNumerofactura;
    }

    public Integer getEntTotalbienes() {
        return entTotalbienes;
    }

    public void setEntTotalbienes(Integer entTotalbienes) {
        this.entTotalbienes = entTotalbienes;
    }

    public Float getEntValortotal() {
        return entValortotal;
    }

    public void setEntValortotal(Float entValortotal) {
        this.entValortotal = entValortotal;
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
        hash += (entNumero != null ? entNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaAlmacen)) {
            return false;
        }
        EntradaAlmacen other = (EntradaAlmacen) object;
        if ((this.entNumero == null && other.entNumero != null) || (this.entNumero != null && !this.entNumero.equals(other.entNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.EntradaAlmacen[ entNumero=" + entNumero + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "aesto_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findByAestoId", query = "SELECT s FROM Stock s WHERE s.aestoId = :aestoId")
    , @NamedQuery(name = "Stock.findByAestoCantidad", query = "SELECT s FROM Stock s WHERE s.aestoCantidad = :aestoCantidad")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AESTO_ID")
    private String aestoId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AESTO_CANTIDAD")
    private BigDecimal aestoCantidad;
    @JoinColumn(name = "MEBIE_ID", referencedColumnName = "MEBIE_ID")
    @ManyToOne(optional = false)
    private Bienes mebieId;

    public Stock() {
    }

    public Stock(String aestoId) {
        this.aestoId = aestoId;
    }

    public String getAestoId() {
        return aestoId;
    }

    public void setAestoId(String aestoId) {
        this.aestoId = aestoId;
    }

    public BigDecimal getAestoCantidad() {
        return aestoCantidad;
    }

    public void setAestoCantidad(BigDecimal aestoCantidad) {
        this.aestoCantidad = aestoCantidad;
    }

    public Bienes getMebieId() {
        return mebieId;
    }

    public void setMebieId(Bienes mebieId) {
        this.mebieId = mebieId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aestoId != null ? aestoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.aestoId == null && other.aestoId != null) || (this.aestoId != null && !this.aestoId.equals(other.aestoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Stock[ aestoId=" + aestoId + " ]";
    }
    
}

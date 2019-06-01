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
 * @author Jonathan
 */
@Entity
@Table(name = "aesto_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findByStoId", query = "SELECT s FROM Stock s WHERE s.stoId = :stoId")
    , @NamedQuery(name = "Stock.findByStoCantidad", query = "SELECT s FROM Stock s WHERE s.stoCantidad = :stoCantidad")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "STO_ID")
    private String stoId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "STO_CANTIDAD")
    private BigDecimal stoCantidad;
    @JoinColumn(name = "BIEN_ID", referencedColumnName = "BIEN_ID")
    @ManyToOne(optional = false)
    private Bienes bienId;

    public Stock() {
    }

    public Stock(String stoId) {
        this.stoId = stoId;
    }

    public String getStoId() {
        return stoId;
    }

    public void setStoId(String stoId) {
        this.stoId = stoId;
    }

    public BigDecimal getStoCantidad() {
        return stoCantidad;
    }

    public void setStoCantidad(BigDecimal stoCantidad) {
        this.stoCantidad = stoCantidad;
    }

    public Bienes getBienId() {
        return bienId;
    }

    public void setBienId(Bienes bienId) {
        this.bienId = bienId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stoId != null ? stoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.stoId == null && other.stoId != null) || (this.stoId != null && !this.stoId.equals(other.stoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Stock[ stoId=" + stoId + " ]";
    }
    
}

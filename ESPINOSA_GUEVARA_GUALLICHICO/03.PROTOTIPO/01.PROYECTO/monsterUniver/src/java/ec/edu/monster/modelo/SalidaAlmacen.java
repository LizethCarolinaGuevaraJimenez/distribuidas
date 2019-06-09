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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "aesal_salalm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalidaAlmacen.findAll", query = "SELECT s FROM SalidaAlmacen s")
    , @NamedQuery(name = "SalidaAlmacen.findByAesalNumero", query = "SELECT s FROM SalidaAlmacen s WHERE s.aesalNumero = :aesalNumero")
    , @NamedQuery(name = "SalidaAlmacen.findByAesalFesalida", query = "SELECT s FROM SalidaAlmacen s WHERE s.aesalFesalida = :aesalFesalida")
    , @NamedQuery(name = "SalidaAlmacen.findByAesalFeentrega", query = "SELECT s FROM SalidaAlmacen s WHERE s.aesalFeentrega = :aesalFeentrega")})
public class SalidaAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AESAL_NUMERO")
    private String aesalNumero;
    @Column(name = "AESAL_FESALIDA")
    @Temporal(TemporalType.DATE)
    private Date aesalFesalida;
    @Column(name = "AESAL_FEENTREGA")
    @Temporal(TemporalType.DATE)
    private Date aesalFeentrega;
    @JoinColumn(name = "PEEMP_ID", referencedColumnName = "PEEMP_ID")
    @ManyToOne(optional = false)
    private Empleado peempId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salidaAlmacen")
    private Collection<ItemSalida> itemSalidaCollection;

    public SalidaAlmacen() {
    }

    public SalidaAlmacen(String aesalNumero) {
        this.aesalNumero = aesalNumero;
    }

    public String getAesalNumero() {
        return aesalNumero;
    }

    public void setAesalNumero(String aesalNumero) {
        this.aesalNumero = aesalNumero;
    }

    public Date getAesalFesalida() {
        return aesalFesalida;
    }

    public void setAesalFesalida(Date aesalFesalida) {
        this.aesalFesalida = aesalFesalida;
    }

    public Date getAesalFeentrega() {
        return aesalFeentrega;
    }

    public void setAesalFeentrega(Date aesalFeentrega) {
        this.aesalFeentrega = aesalFeentrega;
    }

    public Empleado getPeempId() {
        return peempId;
    }

    public void setPeempId(Empleado peempId) {
        this.peempId = peempId;
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
        hash += (aesalNumero != null ? aesalNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaAlmacen)) {
            return false;
        }
        SalidaAlmacen other = (SalidaAlmacen) object;
        if ((this.aesalNumero == null && other.aesalNumero != null) || (this.aesalNumero != null && !this.aesalNumero.equals(other.aesalNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.SalidaAlmacen[ aesalNumero=" + aesalNumero + " ]";
    }
    
}

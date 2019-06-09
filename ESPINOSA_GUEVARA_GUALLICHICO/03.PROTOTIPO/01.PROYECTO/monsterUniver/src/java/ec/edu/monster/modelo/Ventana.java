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
@Table(name = "seven_ventan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventana.findAll", query = "SELECT v FROM Ventana v")
    , @NamedQuery(name = "Ventana.findBySevenCodigo", query = "SELECT v FROM Ventana v WHERE v.sevenCodigo = :sevenCodigo")
    , @NamedQuery(name = "Ventana.findBySevenDescripcion", query = "SELECT v FROM Ventana v WHERE v.sevenDescripcion = :sevenDescripcion")
    , @NamedQuery(name = "Ventana.findBySevenMensaje", query = "SELECT v FROM Ventana v WHERE v.sevenMensaje = :sevenMensaje")})
public class Ventana implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SEVEN_CODIGO")
    private String sevenCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SEVEN_DESCRIPCION")
    private String sevenDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SEVEN_MENSAJE")
    private String sevenMensaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventana")
    private Collection<VentanaPerfil> ventanaPerfilCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sevenCodigo")
    private Collection<Opcion> opcionCollection;

    public Ventana() {
    }

    public Ventana(String sevenCodigo) {
        this.sevenCodigo = sevenCodigo;
    }

    public Ventana(String sevenCodigo, String sevenDescripcion, String sevenMensaje) {
        this.sevenCodigo = sevenCodigo;
        this.sevenDescripcion = sevenDescripcion;
        this.sevenMensaje = sevenMensaje;
    }

    public String getSevenCodigo() {
        return sevenCodigo;
    }

    public void setSevenCodigo(String sevenCodigo) {
        this.sevenCodigo = sevenCodigo;
    }

    public String getSevenDescripcion() {
        return sevenDescripcion;
    }

    public void setSevenDescripcion(String sevenDescripcion) {
        this.sevenDescripcion = sevenDescripcion;
    }

    public String getSevenMensaje() {
        return sevenMensaje;
    }

    public void setSevenMensaje(String sevenMensaje) {
        this.sevenMensaje = sevenMensaje;
    }

    @XmlTransient
    public Collection<VentanaPerfil> getVentanaPerfilCollection() {
        return ventanaPerfilCollection;
    }

    public void setVentanaPerfilCollection(Collection<VentanaPerfil> ventanaPerfilCollection) {
        this.ventanaPerfilCollection = ventanaPerfilCollection;
    }

    @XmlTransient
    public Collection<Opcion> getOpcionCollection() {
        return opcionCollection;
    }

    public void setOpcionCollection(Collection<Opcion> opcionCollection) {
        this.opcionCollection = opcionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sevenCodigo != null ? sevenCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventana)) {
            return false;
        }
        Ventana other = (Ventana) object;
        if ((this.sevenCodigo == null && other.sevenCodigo != null) || (this.sevenCodigo != null && !this.sevenCodigo.equals(other.sevenCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return sevenDescripcion;//"ec.edu.monster.modelo.Ventana[ sevenCodigo=" + sevenCodigo + " ]";
    }
    
}

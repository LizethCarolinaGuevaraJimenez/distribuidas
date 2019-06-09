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
@Table(name = "seopc_opcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o")
    , @NamedQuery(name = "Opcion.findBySeopcCodigo", query = "SELECT o FROM Opcion o WHERE o.seopcCodigo = :seopcCodigo")
    , @NamedQuery(name = "Opcion.findBySeopcNombre", query = "SELECT o FROM Opcion o WHERE o.seopcNombre = :seopcNombre")
    , @NamedQuery(name = "Opcion.findBySeopcVista", query = "SELECT o FROM Opcion o WHERE o.seopcVista = :seopcVista")})
public class Opcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SEOPC_CODIGO")
    private String seopcCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SEOPC_NOMBRE")
    private String seopcNombre;
    @Size(max = 50)
    @Column(name = "SEOPC_VISTA")
    private String seopcVista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opcion")
    private Collection<OpcionPerfil> opcionPerfilCollection;
    @JoinColumn(name = "SEVEN_CODIGO", referencedColumnName = "SEVEN_CODIGO")
    @ManyToOne(optional = false)
    private Ventana sevenCodigo;
    @JoinColumn(name = "SESIS_CODIGO", referencedColumnName = "SESIS_CODIGO")
    @ManyToOne(optional = false)
    private Sistema sesisCodigo;

    public Opcion() {
    }

    public Opcion(String seopcCodigo) {
        this.seopcCodigo = seopcCodigo;
    }

    public Opcion(String seopcCodigo, String seopcNombre) {
        this.seopcCodigo = seopcCodigo;
        this.seopcNombre = seopcNombre;
    }

    public String getSeopcCodigo() {
        return seopcCodigo;
    }

    public void setSeopcCodigo(String seopcCodigo) {
        this.seopcCodigo = seopcCodigo;
    }

    public String getSeopcNombre() {
        return seopcNombre;
    }

    public void setSeopcNombre(String seopcNombre) {
        this.seopcNombre = seopcNombre;
    }

    public String getSeopcVista() {
        return seopcVista;
    }

    public void setSeopcVista(String seopcVista) {
        this.seopcVista = seopcVista;
    }

    @XmlTransient
    public Collection<OpcionPerfil> getOpcionPerfilCollection() {
        return opcionPerfilCollection;
    }

    public void setOpcionPerfilCollection(Collection<OpcionPerfil> opcionPerfilCollection) {
        this.opcionPerfilCollection = opcionPerfilCollection;
    }

    public Ventana getSevenCodigo() {
        return sevenCodigo;
    }

    public void setSevenCodigo(Ventana sevenCodigo) {
        this.sevenCodigo = sevenCodigo;
    }

    public Sistema getSesisCodigo() {
        return sesisCodigo;
    }

    public void setSesisCodigo(Sistema sesisCodigo) {
        this.sesisCodigo = sesisCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seopcCodigo != null ? seopcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.seopcCodigo == null && other.seopcCodigo != null) || (this.seopcCodigo != null && !this.seopcCodigo.equals(other.seopcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return seopcNombre;//"ec.edu.monster.modelo.Opcion[ seopcCodigo=" + seopcCodigo + " ]";
    }
    
}

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
@Table(name = "seopc_opcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o")
    , @NamedQuery(name = "Opcion.findByOpcCodigo", query = "SELECT o FROM Opcion o WHERE o.opcCodigo = :opcCodigo")
    , @NamedQuery(name = "Opcion.findByOpcDescripcion", query = "SELECT o FROM Opcion o WHERE o.opcDescripcion = :opcDescripcion")})
public class Opcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "OPC_CODIGO")
    private String opcCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "OPC_DESCRIPCION")
    private String opcDescripcion;
    @JoinColumn(name = "SIS_CODIGO", referencedColumnName = "SIS_CODIGO")
    @ManyToOne(optional = false)
    private Sistema sisCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opcCodigo")
    private Collection<Ventana> ventanaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opcion")
    private Collection<OpcionPerfil> opcionPerfilCollection;

    public Opcion() {
    }

    public Opcion(String opcCodigo) {
        this.opcCodigo = opcCodigo;
    }

    public Opcion(String opcCodigo, String opcDescripcion) {
        this.opcCodigo = opcCodigo;
        this.opcDescripcion = opcDescripcion;
    }

    public String getOpcCodigo() {
        return opcCodigo;
    }

    public void setOpcCodigo(String opcCodigo) {
        this.opcCodigo = opcCodigo;
    }

    public String getOpcDescripcion() {
        return opcDescripcion;
    }

    public void setOpcDescripcion(String opcDescripcion) {
        this.opcDescripcion = opcDescripcion;
    }

    public Sistema getSisCodigo() {
        return sisCodigo;
    }

    public void setSisCodigo(Sistema sisCodigo) {
        this.sisCodigo = sisCodigo;
    }

    @XmlTransient
    public Collection<Ventana> getVentanaCollection() {
        return ventanaCollection;
    }

    public void setVentanaCollection(Collection<Ventana> ventanaCollection) {
        this.ventanaCollection = ventanaCollection;
    }

    @XmlTransient
    public Collection<OpcionPerfil> getOpcionPerfilCollection() {
        return opcionPerfilCollection;
    }

    public void setOpcionPerfilCollection(Collection<OpcionPerfil> opcionPerfilCollection) {
        this.opcionPerfilCollection = opcionPerfilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcCodigo != null ? opcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.opcCodigo == null && other.opcCodigo != null) || (this.opcCodigo != null && !this.opcCodigo.equals(other.opcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Opcion[ opcCodigo=" + opcCodigo + " ]";
    }
    
}

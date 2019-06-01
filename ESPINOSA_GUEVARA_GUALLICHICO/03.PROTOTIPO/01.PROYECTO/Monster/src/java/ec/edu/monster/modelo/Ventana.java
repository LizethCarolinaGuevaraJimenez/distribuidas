/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
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
@Table(name = "seven_ventan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventana.findAll", query = "SELECT v FROM Ventana v")
    , @NamedQuery(name = "Ventana.findByVenCodigo", query = "SELECT v FROM Ventana v WHERE v.venCodigo = :venCodigo")
    , @NamedQuery(name = "Ventana.findByVenDescripcion", query = "SELECT v FROM Ventana v WHERE v.venDescripcion = :venDescripcion")
    , @NamedQuery(name = "Ventana.findByVenMensaje", query = "SELECT v FROM Ventana v WHERE v.venMensaje = :venMensaje")})
public class Ventana implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "VEN_CODIGO")
    private String venCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "VEN_DESCRIPCION")
    private String venDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "VEN_MENSAJE")
    private String venMensaje;
    @JoinColumn(name = "OPC_CODIGO", referencedColumnName = "OPC_CODIGO")
    @ManyToOne(optional = false)
    private Opcion opcCodigo;

    public Ventana() {
    }

    public Ventana(String venCodigo) {
        this.venCodigo = venCodigo;
    }

    public Ventana(String venCodigo, String venDescripcion, String venMensaje) {
        this.venCodigo = venCodigo;
        this.venDescripcion = venDescripcion;
        this.venMensaje = venMensaje;
    }

    public String getVenCodigo() {
        return venCodigo;
    }

    public void setVenCodigo(String venCodigo) {
        this.venCodigo = venCodigo;
    }

    public String getVenDescripcion() {
        return venDescripcion;
    }

    public void setVenDescripcion(String venDescripcion) {
        this.venDescripcion = venDescripcion;
    }

    public String getVenMensaje() {
        return venMensaje;
    }

    public void setVenMensaje(String venMensaje) {
        this.venMensaje = venMensaje;
    }

    public Opcion getOpcCodigo() {
        return opcCodigo;
    }

    public void setOpcCodigo(Opcion opcCodigo) {
        this.opcCodigo = opcCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venCodigo != null ? venCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventana)) {
            return false;
        }
        Ventana other = (Ventana) object;
        if ((this.venCodigo == null && other.venCodigo != null) || (this.venCodigo != null && !this.venCodigo.equals(other.venCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Ventana[ venCodigo=" + venCodigo + " ]";
    }
    
}

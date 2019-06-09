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
@Table(name = "peemp_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByPeempId", query = "SELECT e FROM Empleado e WHERE e.peempId = :peempId")
    , @NamedQuery(name = "Empleado.findByPeempCedula", query = "SELECT e FROM Empleado e WHERE e.peempCedula = :peempCedula")
    , @NamedQuery(name = "Empleado.findByPeempNomres", query = "SELECT e FROM Empleado e WHERE e.peempNomres = :peempNomres")
    , @NamedQuery(name = "Empleado.findByPeempApellidos", query = "SELECT e FROM Empleado e WHERE e.peempApellidos = :peempApellidos")
    , @NamedQuery(name = "Empleado.findByPeempTelefono", query = "SELECT e FROM Empleado e WHERE e.peempTelefono = :peempTelefono")
    , @NamedQuery(name = "Empleado.findByPeempCorreo", query = "SELECT e FROM Empleado e WHERE e.peempCorreo = :peempCorreo")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PEEMP_ID")
    private String peempId;
    @Size(max = 15)
    @Column(name = "PEEMP_CEDULA")
    private String peempCedula;
    @Size(max = 100)
    @Column(name = "PEEMP_NOMRES")
    private String peempNomres;
    @Size(max = 100)
    @Column(name = "PEEMP_APELLIDOS")
    private String peempApellidos;
    @Size(max = 10)
    @Column(name = "PEEMP_TELEFONO")
    private String peempTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PEEMP_CORREO")
    private String peempCorreo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peempId")
    private Collection<SalidaAlmacen> salidaAlmacenCollection;
    @JoinColumn(name = "PECAR_ID", referencedColumnName = "PECAR_ID")
    @ManyToOne(optional = false)
    private Cargo pecarId;
    @JoinColumn(name = "PESEX_CODIGO", referencedColumnName = "PESEX_CODIGO")
    @ManyToOne(optional = false)
    private Sexo pesexCodigo;
    @JoinColumn(name = "PEEST_CODIGO", referencedColumnName = "PEEST_CODIGO")
    @ManyToOne(optional = false)
    private EstadoCivil peestCodigo;
    @JoinColumn(name = "PEDIR_CODIGO", referencedColumnName = "PEDIR_CODIGO")
    @ManyToOne(optional = false)
    private Direccion pedirCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Collection<ItemSalida> itemSalidaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peempId")
    private Collection<SolicitudCompra> solicitudCompraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peempId")
    private Collection<Usuario> usuarioCollection;

    public Empleado() {
    }

    public Empleado(String peempId) {
        this.peempId = peempId;
    }

    public Empleado(String peempId, String peempCorreo) {
        this.peempId = peempId;
        this.peempCorreo = peempCorreo;
    }

    public String getPeempId() {
        return peempId;
    }

    public void setPeempId(String peempId) {
        this.peempId = peempId;
    }

    public String getPeempCedula() {
        return peempCedula;
    }

    public void setPeempCedula(String peempCedula) {
        this.peempCedula = peempCedula;
    }

    public String getPeempNomres() {
        return peempNomres;
    }

    public void setPeempNomres(String peempNomres) {
        this.peempNomres = peempNomres;
    }

    public String getPeempApellidos() {
        return peempApellidos;
    }

    public void setPeempApellidos(String peempApellidos) {
        this.peempApellidos = peempApellidos;
    }

    public String getPeempTelefono() {
        return peempTelefono;
    }

    public void setPeempTelefono(String peempTelefono) {
        this.peempTelefono = peempTelefono;
    }

    public String getPeempCorreo() {
        return peempCorreo;
    }

    public void setPeempCorreo(String peempCorreo) {
        this.peempCorreo = peempCorreo;
    }

    @XmlTransient
    public Collection<SalidaAlmacen> getSalidaAlmacenCollection() {
        return salidaAlmacenCollection;
    }

    public void setSalidaAlmacenCollection(Collection<SalidaAlmacen> salidaAlmacenCollection) {
        this.salidaAlmacenCollection = salidaAlmacenCollection;
    }

    public Cargo getPecarId() {
        return pecarId;
    }

    public void setPecarId(Cargo pecarId) {
        this.pecarId = pecarId;
    }

    public Sexo getPesexCodigo() {
        return pesexCodigo;
    }

    public void setPesexCodigo(Sexo pesexCodigo) {
        this.pesexCodigo = pesexCodigo;
    }

    public EstadoCivil getPeestCodigo() {
        return peestCodigo;
    }

    public void setPeestCodigo(EstadoCivil peestCodigo) {
        this.peestCodigo = peestCodigo;
    }

    public Direccion getPedirCodigo() {
        return pedirCodigo;
    }

    public void setPedirCodigo(Direccion pedirCodigo) {
        this.pedirCodigo = pedirCodigo;
    }

    @XmlTransient
    public Collection<ItemSalida> getItemSalidaCollection() {
        return itemSalidaCollection;
    }

    public void setItemSalidaCollection(Collection<ItemSalida> itemSalidaCollection) {
        this.itemSalidaCollection = itemSalidaCollection;
    }

    @XmlTransient
    public Collection<SolicitudCompra> getSolicitudCompraCollection() {
        return solicitudCompraCollection;
    }

    public void setSolicitudCompraCollection(Collection<SolicitudCompra> solicitudCompraCollection) {
        this.solicitudCompraCollection = solicitudCompraCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peempId != null ? peempId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.peempId == null && other.peempId != null) || (this.peempId != null && !this.peempId.equals(other.peempId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return peempNomres+peempApellidos;//"ec.edu.monster.modelo.Empleado[ peempId=" + peempId + " ]";
    }
    
}

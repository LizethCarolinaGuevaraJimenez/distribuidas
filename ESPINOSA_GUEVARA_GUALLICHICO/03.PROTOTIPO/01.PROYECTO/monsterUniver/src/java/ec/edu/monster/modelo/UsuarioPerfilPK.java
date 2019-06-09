/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pablo
 */
@Embeddable
public class UsuarioPerfilPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SEPER_CODIGO")
    private String seperCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SEUSU_USUARIO")
    private String seusuUsuario;

    public UsuarioPerfilPK() {
    }

    public UsuarioPerfilPK(String seperCodigo, String seusuUsuario) {
        this.seperCodigo = seperCodigo;
        this.seusuUsuario = seusuUsuario;
    }

    public String getSeperCodigo() {
        return seperCodigo;
    }

    public void setSeperCodigo(String seperCodigo) {
        this.seperCodigo = seperCodigo;
    }

    public String getSeusuUsuario() {
        return seusuUsuario;
    }

    public void setSeusuUsuario(String seusuUsuario) {
        this.seusuUsuario = seusuUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seperCodigo != null ? seperCodigo.hashCode() : 0);
        hash += (seusuUsuario != null ? seusuUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPerfilPK)) {
            return false;
        }
        UsuarioPerfilPK other = (UsuarioPerfilPK) object;
        if ((this.seperCodigo == null && other.seperCodigo != null) || (this.seperCodigo != null && !this.seperCodigo.equals(other.seperCodigo))) {
            return false;
        }
        if ((this.seusuUsuario == null && other.seusuUsuario != null) || (this.seusuUsuario != null && !this.seusuUsuario.equals(other.seusuUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.UsuarioPerfilPK[ seperCodigo=" + seperCodigo + ", seusuUsuario=" + seusuUsuario + " ]";
    }
    
}

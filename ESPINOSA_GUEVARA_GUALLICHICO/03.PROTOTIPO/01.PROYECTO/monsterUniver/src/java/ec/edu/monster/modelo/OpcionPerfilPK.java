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
public class OpcionPerfilPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SEPER_CODIGO")
    private String seperCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SEOPC_CODIGO")
    private String seopcCodigo;

    public OpcionPerfilPK() {
    }

    public OpcionPerfilPK(String seperCodigo, String seopcCodigo) {
        this.seperCodigo = seperCodigo;
        this.seopcCodigo = seopcCodigo;
    }

    public String getSeperCodigo() {
        return seperCodigo;
    }

    public void setSeperCodigo(String seperCodigo) {
        this.seperCodigo = seperCodigo;
    }

    public String getSeopcCodigo() {
        return seopcCodigo;
    }

    public void setSeopcCodigo(String seopcCodigo) {
        this.seopcCodigo = seopcCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seperCodigo != null ? seperCodigo.hashCode() : 0);
        hash += (seopcCodigo != null ? seopcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionPerfilPK)) {
            return false;
        }
        OpcionPerfilPK other = (OpcionPerfilPK) object;
        if ((this.seperCodigo == null && other.seperCodigo != null) || (this.seperCodigo != null && !this.seperCodigo.equals(other.seperCodigo))) {
            return false;
        }
        if ((this.seopcCodigo == null && other.seopcCodigo != null) || (this.seopcCodigo != null && !this.seopcCodigo.equals(other.seopcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.OpcionPerfilPK[ seperCodigo=" + seperCodigo + ", seopcCodigo=" + seopcCodigo + " ]";
    }
    
}

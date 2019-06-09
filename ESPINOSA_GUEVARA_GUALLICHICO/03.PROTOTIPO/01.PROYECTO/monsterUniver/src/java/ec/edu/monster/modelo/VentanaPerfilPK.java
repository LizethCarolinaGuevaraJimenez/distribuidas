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
public class VentanaPerfilPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SEVEN_CODIGO")
    private String sevenCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SEPER_CODIGO")
    private String seperCodigo;

    public VentanaPerfilPK() {
    }

    public VentanaPerfilPK(String sevenCodigo, String seperCodigo) {
        this.sevenCodigo = sevenCodigo;
        this.seperCodigo = seperCodigo;
    }

    public String getSevenCodigo() {
        return sevenCodigo;
    }

    public void setSevenCodigo(String sevenCodigo) {
        this.sevenCodigo = sevenCodigo;
    }

    public String getSeperCodigo() {
        return seperCodigo;
    }

    public void setSeperCodigo(String seperCodigo) {
        this.seperCodigo = seperCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sevenCodigo != null ? sevenCodigo.hashCode() : 0);
        hash += (seperCodigo != null ? seperCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentanaPerfilPK)) {
            return false;
        }
        VentanaPerfilPK other = (VentanaPerfilPK) object;
        if ((this.sevenCodigo == null && other.sevenCodigo != null) || (this.sevenCodigo != null && !this.sevenCodigo.equals(other.sevenCodigo))) {
            return false;
        }
        if ((this.seperCodigo == null && other.seperCodigo != null) || (this.seperCodigo != null && !this.seperCodigo.equals(other.seperCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.VentanaPerfilPK[ sevenCodigo=" + sevenCodigo + ", seperCodigo=" + seperCodigo + " ]";
    }
    
}

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
 * @author Jonathan
 */
@Embeddable
public class ItemSalidaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SAL_NUMERO")
    private String salNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BIEN_ID")
    private String bienId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMP_ID")
    private String empId;

    public ItemSalidaPK() {
    }

    public ItemSalidaPK(String salNumero, String bienId, String empId) {
        this.salNumero = salNumero;
        this.bienId = bienId;
        this.empId = empId;
    }

    public String getSalNumero() {
        return salNumero;
    }

    public void setSalNumero(String salNumero) {
        this.salNumero = salNumero;
    }

    public String getBienId() {
        return bienId;
    }

    public void setBienId(String bienId) {
        this.bienId = bienId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salNumero != null ? salNumero.hashCode() : 0);
        hash += (bienId != null ? bienId.hashCode() : 0);
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemSalidaPK)) {
            return false;
        }
        ItemSalidaPK other = (ItemSalidaPK) object;
        if ((this.salNumero == null && other.salNumero != null) || (this.salNumero != null && !this.salNumero.equals(other.salNumero))) {
            return false;
        }
        if ((this.bienId == null && other.bienId != null) || (this.bienId != null && !this.bienId.equals(other.bienId))) {
            return false;
        }
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.ItemSalidaPK[ salNumero=" + salNumero + ", bienId=" + bienId + ", empId=" + empId + " ]";
    }
    
}

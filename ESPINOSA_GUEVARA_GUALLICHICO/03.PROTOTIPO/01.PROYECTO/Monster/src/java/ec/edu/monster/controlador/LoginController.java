/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.Empleado;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Jonathan
 */


@Named("LoginController")
@SessionScoped
public class LoginController implements Serializable{
    Empleado current;

    @PostConstruct
    public void init(){
        current=new Empleado();
    }

    public Empleado getCurrent() {
        return current;
    }

    public void setCurrent(Empleado current) {
        this.current = current;
    }
    
    
    
    public void verificarSesion(){
        try {
            FacesContext context=FacesContext.getCurrentInstance();
            current=(Empleado) context.getExternalContext().getSessionMap().get("empleado");
            if(current == null){
                context.getExternalContext().redirect("/../index.xhtml");
            } 
        } catch (Exception e) {
        }
    }
}

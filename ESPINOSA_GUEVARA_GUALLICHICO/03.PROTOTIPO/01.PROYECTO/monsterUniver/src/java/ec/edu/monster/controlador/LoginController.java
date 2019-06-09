/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controlador;
 
import ec.edu.monster.modelo.Usuario;
import java.io.Serializable; 
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jonathan
 */
@Named("LoginController")
@SessionScoped
public class LoginController implements Serializable {

    private Usuario current; 
    private UsuarioController usuarioController; 

    @PostConstruct
    public void init() {
        current = new Usuario(); 
        usuarioController=new UsuarioController();
    }

    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }

    public UsuarioController getUsuarioController() {
        return usuarioController;
    }

    public void setUsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

}

package ec.edu.monster.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ec.edu.monster.modelo.OpcionPerfil;
import ec.edu.monster.modelo.Usuario;
import ec.edu.monster.modelo.UsuarioPerfil;
import ec.edu.monster.modelo.VentanaPerfil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named("MenuController")
@SessionScoped
public class MenuController implements Serializable {

    @EJB
    private ec.edu.monster.facade.UsuarioPerfilFacade usuarioPerfilFacade;
    @EJB
    private ec.edu.monster.facade.VentanaPerfilFacade ventanaPerfilFacade; 
    @EJB
    private ec.edu.monster.facade.OpcionPerfilFacade opcionPerfilFacade;

    private MenuModel model;

    private List<UsuarioPerfil> listaUsuarioPerfil;
    private List<VentanaPerfil> listaVentanaPerfil;
    private List<OpcionPerfil> listaOpcionPerfil;

    @PostConstruct
    public void init() {
        this.listar();
        model = new DefaultMenuModel();
        DefaultMenuItem item = new DefaultMenuItem("Inicio");
        item.setUrl("../faces/index.xhtml");
        item.setIcon("ui-icon-home");
        model.addElement(item);

        this.Permisos();
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void listar() {
        try {
            this.listaUsuarioPerfil = usuarioPerfilFacade.findAll();
            this.listaVentanaPerfil = ventanaPerfilFacade.findAll();
            this.listaOpcionPerfil = opcionPerfilFacade.findAll();
        } catch (Exception e) {

        }
    }

    public void Permisos() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario usu = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

            for (UsuarioPerfil usuper : listaUsuarioPerfil) {
                if (usuper.getUsuario().getSeusuUsuario().equals(usu.getSeusuUsuario())) {

                    for (VentanaPerfil venper : listaVentanaPerfil) {
                        if (venper.getPerfil().getSeperCodigo().equals(usuper.getPerfil().getSeperCodigo())) {

                            DefaultSubMenu submenu = new DefaultSubMenu(venper.getVentana().getSevenDescripcion());

                            for (OpcionPerfil opcper : listaOpcionPerfil) {

                                if (opcper.getPerfil().getSeperCodigo().equals(usuper.getPerfil().getSeperCodigo())
                                        && venper.getVentana().getSevenCodigo().equals(opcper.getOpcion().getSevenCodigo().getSevenCodigo())) {

                                    DefaultMenuItem item = new DefaultMenuItem(opcper.getOpcion().getSeopcNombre());
                                    item.setUrl("../" + opcper.getOpcion().getSeopcVista());
                                    submenu.addElement(item);

                                }

                            }
                            model.addElement(submenu);

                        }

                    }
                }

            }

            DefaultMenuItem item = new DefaultMenuItem("Cambio de Clave");
            item.setUrl("../clave/Create.xhtml");
            model.addElement(item);
        } catch (Exception e) {

        }
    }

}

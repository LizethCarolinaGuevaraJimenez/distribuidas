package ec.edu.monster.controlador;

import ec.edu.monster.modelo.UsuarioPerfil;
import ec.edu.monster.controlador.util.JsfUtil;
import ec.edu.monster.controlador.util.PaginationHelper;
import ec.edu.monster.facade.UsuarioPerfilFacade;
import ec.edu.monster.modelo.Empleado;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("usuarioPerfilController")
@SessionScoped
public class UsuarioPerfilController implements Serializable {

    private UsuarioPerfil current;
    private DataModel items = null;
    @EJB
    private ec.edu.monster.facade.UsuarioPerfilFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public UsuarioPerfilController() {
    }

    @PostConstruct
    public void init() {
        current = new UsuarioPerfil();
    }

    public UsuarioPerfil getCurrent() {
        return current;
    }

    public void setCurrent(UsuarioPerfil current) {
        this.current = current;
    }

    public String perfilAsignado() {
        String perfil = null;
        List<UsuarioPerfil> lista = null;
        try {
            Empleado emp = (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado");
            lista = ejbFacade.usuperTodos();
            if (emp != null && !lista.isEmpty()) {
                for (UsuarioPerfil up : lista) {
                    if (up.getUsuario().getEmpId().equals(emp.getEmpId())) {
                        perfil = up.getPerfil().getPerDescripcion();
                    }
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "PROBLEMAS"));
            }
        } catch (Exception e) {
        }
        return perfil;
    }

    public UsuarioPerfil getSelected() {
        if (current == null) {
            current = new UsuarioPerfil();
            current.setUsuarioPerfilPK(new ec.edu.monster.modelo.UsuarioPerfilPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private UsuarioPerfilFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (UsuarioPerfil) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new UsuarioPerfil();
        current.setUsuarioPerfilPK(new ec.edu.monster.modelo.UsuarioPerfilPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            Date ahora = new Date(System.currentTimeMillis());
            current.setUsuperFechaasignacion(ahora);
            current.setUsuperFechacambio(ahora);
            current.getUsuarioPerfilPK().setEmpId(current.getUsuario().getEmpId());
            current.getUsuarioPerfilPK().setPerCodigo(current.getPerfil().getPerCodigo());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsuarioPerfilCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (UsuarioPerfil) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            Date ahora = new Date(System.currentTimeMillis()); 
            current.setUsuperFechacambio(ahora);
            current.getUsuarioPerfilPK().setEmpId(current.getUsuario().getEmpId());
            current.getUsuarioPerfilPK().setPerCodigo(current.getPerfil().getPerCodigo());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsuarioPerfilUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (UsuarioPerfil) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsuarioPerfilDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public UsuarioPerfil getUsuarioPerfil(ec.edu.monster.modelo.UsuarioPerfilPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = UsuarioPerfil.class)
    public static class UsuarioPerfilControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioPerfilController controller = (UsuarioPerfilController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioPerfilController");
            return controller.getUsuarioPerfil(getKey(value));
        }

        ec.edu.monster.modelo.UsuarioPerfilPK getKey(String value) {
            ec.edu.monster.modelo.UsuarioPerfilPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new ec.edu.monster.modelo.UsuarioPerfilPK();
            key.setEmpId(values[0]);
            key.setPerCodigo(values[1]);
            return key;
        }

        String getStringKey(ec.edu.monster.modelo.UsuarioPerfilPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getEmpId());
            sb.append(SEPARATOR);
            sb.append(value.getPerCodigo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof UsuarioPerfil) {
                UsuarioPerfil o = (UsuarioPerfil) object;
                return getStringKey(o.getUsuarioPerfilPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + UsuarioPerfil.class.getName());
            }
        }

    }

}

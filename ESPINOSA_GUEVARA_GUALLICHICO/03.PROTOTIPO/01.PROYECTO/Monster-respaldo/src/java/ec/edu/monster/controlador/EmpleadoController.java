package ec.edu.monster.controlador;

import ec.edu.monster.modelo.Empleado;
import ec.edu.monster.controlador.util.JsfUtil;
import ec.edu.monster.controlador.util.PaginationHelper;
import ec.edu.monster.facade.EmpleadoFacade;
import ec.edu.monster.modelo.Usuario;

import java.io.Serializable;
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

@Named("empleadoController")
@SessionScoped
public class EmpleadoController implements Serializable {

    private Empleado current;
    private DataModel items = null;
    @EJB
    private ec.edu.monster.facade.EmpleadoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private List<Empleado> listaCurrent;

    public EmpleadoController() {
    }

    @PostConstruct
    public void init() {
        current = new Empleado();
    }

    public Empleado getCurrent() {
        return current;
    }

    public void setCurrent(Empleado current) {
        this.current = current;
    }

    public void buscarEmpleados() {
        try {

            System.out.println("dsfds");
            listaCurrent = ejbFacade.buscar(current);
        } catch (Exception e) {
        }
    }

    public String mostrarEmpleados() {
        String empleados = null;
        System.out.println("dsfds");
        for (int i = 0; i < listaCurrent.size(); i++) {
            empleados = empleados + listaCurrent.get(i).toString() + "/n ";
        }
        return empleados;
    }

    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() >= 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public String iniciarSesion(UsuarioController usu) {
        Empleado emp;
        List<Usuario> lista = null;
        String redireccion = null;
        boolean ced = false;
        try {
            emp = ejbFacade.iniciarSesion(current);
            lista = usu.contrasena();
            ced = validadorDeCedula(emp.getEmpCedula());
            if (emp != null && !lista.isEmpty()) {
                for (Usuario u : lista) {
                    if (u.getEmpId().equals(emp.getEmpId())) {
                        //cuida las sesiones del JSF
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empleado", emp);
                        redireccion = "/index"; 
                        current=null;
                    }
                } 
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrecto"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
        return redireccion;
    }

    public Empleado getSelected() {
        if (current == null) {
            current = new Empleado();
            selectedItemIndex = -1;
        }
        return current;
    }

    private EmpleadoFacade getFacade() {
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
        current = (Empleado) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current=null;
        current = new Empleado();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        if (validadorDeCedula(current.getEmpCedula())) {
            try {
                getFacade().create(current);
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmpleadoCreated"));
                return prepareCreate();

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }
        } else {
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cedula Incorrecta", ""));
        }
        return null;
    }

    public String prepareEdit() {
        current = (Empleado) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        if (validadorDeCedula(current.getEmpCedula())) {
            try {

                getFacade().edit(current);
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmpleadoUpdated"));
                return "View";
            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }
        } else {
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cedula Incorrecta",""));
        }
        return null;
    }

    public String destroy() {
        current = (Empleado) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmpleadoDeleted"));
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

    public List<Empleado> getAll() {
        return ejbFacade.findAll();
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Empleado getEmpleado(java.lang.String id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Empleado.class)
    public static class EmpleadoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmpleadoController controller = (EmpleadoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "empleadoController");
            return controller.getEmpleado(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Empleado) {
                Empleado o = (Empleado) object;
                return getStringKey(o.getEmpId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Empleado.class.getName());
            }
        }

    }

}

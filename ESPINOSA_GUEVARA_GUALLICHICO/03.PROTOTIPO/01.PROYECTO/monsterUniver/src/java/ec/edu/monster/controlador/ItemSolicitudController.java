package ec.edu.monster.controlador;

import ec.edu.monster.modelo.ItemSolicitud;
import ec.edu.monster.controlador.util.JsfUtil;
import ec.edu.monster.controlador.util.PaginationHelper;
import ec.edu.monster.facade.ItemSolicitudFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("itemSolicitudController")
@SessionScoped
public class ItemSolicitudController implements Serializable {

    private ItemSolicitud current;
    private DataModel items = null;
    @EJB
    private ec.edu.monster.facade.ItemSolicitudFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ItemSolicitudController() {
    }

    public ItemSolicitud getSelected() {
        if (current == null) {
            current = new ItemSolicitud();
            current.setItemSolicitudPK(new ec.edu.monster.modelo.ItemSolicitudPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private ItemSolicitudFacade getFacade() {
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
        current = (ItemSolicitud) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new ItemSolicitud();
        current.setItemSolicitudPK(new ec.edu.monster.modelo.ItemSolicitudPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getItemSolicitudPK().setMebieId(current.getBienes().getMebieId());
            current.getItemSolicitudPK().setCesolNumero(current.getSolicitudCompra().getCesolNumero());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemSolicitudCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ItemSolicitud) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getItemSolicitudPK().setMebieId(current.getBienes().getMebieId());
            current.getItemSolicitudPK().setCesolNumero(current.getSolicitudCompra().getCesolNumero());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemSolicitudUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (ItemSolicitud) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemSolicitudDeleted"));
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

    public ItemSolicitud getItemSolicitud(ec.edu.monster.modelo.ItemSolicitudPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = ItemSolicitud.class)
    public static class ItemSolicitudControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ItemSolicitudController controller = (ItemSolicitudController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "itemSolicitudController");
            return controller.getItemSolicitud(getKey(value));
        }

        ec.edu.monster.modelo.ItemSolicitudPK getKey(String value) {
            ec.edu.monster.modelo.ItemSolicitudPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new ec.edu.monster.modelo.ItemSolicitudPK();
            key.setCesolNumero(values[0]);
            key.setMebieId(values[1]);
            return key;
        }

        String getStringKey(ec.edu.monster.modelo.ItemSolicitudPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCesolNumero());
            sb.append(SEPARATOR);
            sb.append(value.getMebieId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ItemSolicitud) {
                ItemSolicitud o = (ItemSolicitud) object;
                return getStringKey(o.getItemSolicitudPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ItemSolicitud.class.getName());
            }
        }

    }

}

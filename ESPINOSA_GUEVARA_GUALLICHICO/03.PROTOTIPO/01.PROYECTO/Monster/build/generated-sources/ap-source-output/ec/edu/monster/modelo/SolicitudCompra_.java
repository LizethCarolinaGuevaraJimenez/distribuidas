package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Area;
import ec.edu.monster.modelo.Empleado;
import ec.edu.monster.modelo.ItemSolicitud;
import ec.edu.monster.modelo.RubroPresupuestario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-07T17:38:57")
@StaticMetamodel(SolicitudCompra.class)
public class SolicitudCompra_ { 

    public static volatile SingularAttribute<SolicitudCompra, Empleado> empId;
    public static volatile SingularAttribute<SolicitudCompra, String> solNumero;
    public static volatile CollectionAttribute<SolicitudCompra, ItemSolicitud> itemSolicitudCollection;
    public static volatile SingularAttribute<SolicitudCompra, Area> areId;
    public static volatile SingularAttribute<SolicitudCompra, Boolean> solAprobacionjefearea;
    public static volatile SingularAttribute<SolicitudCompra, Date> solFecha;
    public static volatile SingularAttribute<SolicitudCompra, Boolean> solAprobaciondirectorfinanciero;
    public static volatile SingularAttribute<SolicitudCompra, RubroPresupuestario> rubCodigo;
    public static volatile SingularAttribute<SolicitudCompra, Float> solTotal;

}
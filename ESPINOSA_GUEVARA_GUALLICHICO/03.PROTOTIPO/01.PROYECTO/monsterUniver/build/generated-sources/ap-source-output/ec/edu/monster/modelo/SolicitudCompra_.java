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

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(SolicitudCompra.class)
public class SolicitudCompra_ { 

    public static volatile SingularAttribute<SolicitudCompra, String> cesolNumero;
    public static volatile CollectionAttribute<SolicitudCompra, ItemSolicitud> itemSolicitudCollection;
    public static volatile SingularAttribute<SolicitudCompra, Area> peareId;
    public static volatile SingularAttribute<SolicitudCompra, Float> cesolTotal;
    public static volatile SingularAttribute<SolicitudCompra, RubroPresupuestario> cerubCodigo;
    public static volatile SingularAttribute<SolicitudCompra, Boolean> cesolAprojefearea;
    public static volatile SingularAttribute<SolicitudCompra, Boolean> cesolAprovdirefinancier;
    public static volatile SingularAttribute<SolicitudCompra, Date> cesolFecha;
    public static volatile SingularAttribute<SolicitudCompra, Empleado> peempId;

}
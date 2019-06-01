package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Empleado;
import ec.edu.monster.modelo.ItemSalida;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-07T17:38:57")
@StaticMetamodel(SalidaAlmacen.class)
public class SalidaAlmacen_ { 

    public static volatile SingularAttribute<SalidaAlmacen, Empleado> empId;
    public static volatile SingularAttribute<SalidaAlmacen, String> salNumero;
    public static volatile SingularAttribute<SalidaAlmacen, Date> salFechasalida;
    public static volatile CollectionAttribute<SalidaAlmacen, ItemSalida> itemSalidaCollection;
    public static volatile SingularAttribute<SalidaAlmacen, Date> salFechaentrega;

}
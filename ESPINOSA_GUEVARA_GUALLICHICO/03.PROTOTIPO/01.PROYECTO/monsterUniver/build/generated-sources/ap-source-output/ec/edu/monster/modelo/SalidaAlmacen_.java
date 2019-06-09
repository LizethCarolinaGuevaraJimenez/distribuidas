package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Empleado;
import ec.edu.monster.modelo.ItemSalida;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:20")
@StaticMetamodel(SalidaAlmacen.class)
public class SalidaAlmacen_ { 

    public static volatile SingularAttribute<SalidaAlmacen, Date> aesalFeentrega;
    public static volatile SingularAttribute<SalidaAlmacen, String> aesalNumero;
    public static volatile SingularAttribute<SalidaAlmacen, Date> aesalFesalida;
    public static volatile SingularAttribute<SalidaAlmacen, Empleado> peempId;
    public static volatile CollectionAttribute<SalidaAlmacen, ItemSalida> itemSalidaCollection;

}
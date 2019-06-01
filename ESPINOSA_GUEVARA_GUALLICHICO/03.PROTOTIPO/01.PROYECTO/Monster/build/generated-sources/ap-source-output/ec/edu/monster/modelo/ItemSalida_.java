package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Bienes;
import ec.edu.monster.modelo.Empleado;
import ec.edu.monster.modelo.ItemSalidaPK;
import ec.edu.monster.modelo.SalidaAlmacen;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-07T17:38:58")
@StaticMetamodel(ItemSalida.class)
public class ItemSalida_ { 

    public static volatile SingularAttribute<ItemSalida, Integer> itesaCantidadentregada;
    public static volatile SingularAttribute<ItemSalida, SalidaAlmacen> salidaAlmacen;
    public static volatile SingularAttribute<ItemSalida, Empleado> empleado;
    public static volatile SingularAttribute<ItemSalida, ItemSalidaPK> itemSalidaPK;
    public static volatile SingularAttribute<ItemSalida, Bienes> bienes;

}
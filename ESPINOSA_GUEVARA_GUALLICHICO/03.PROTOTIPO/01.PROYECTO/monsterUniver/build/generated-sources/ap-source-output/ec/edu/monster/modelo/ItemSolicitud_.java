package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Bienes;
import ec.edu.monster.modelo.DetalleOrden;
import ec.edu.monster.modelo.ItemSolicitudPK;
import ec.edu.monster.modelo.SolicitudCompra;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:20")
@StaticMetamodel(ItemSolicitud.class)
public class ItemSolicitud_ { 

    public static volatile SingularAttribute<ItemSolicitud, Integer> ceiteCantidadsalida;
    public static volatile SingularAttribute<ItemSolicitud, Float> ceiteValortotal;
    public static volatile SingularAttribute<ItemSolicitud, ItemSolicitudPK> itemSolicitudPK;
    public static volatile SingularAttribute<ItemSolicitud, Integer> ceiteCantidaddespachada;
    public static volatile CollectionAttribute<ItemSolicitud, DetalleOrden> detalleOrdenCollection;
    public static volatile SingularAttribute<ItemSolicitud, Bienes> bienes;
    public static volatile SingularAttribute<ItemSolicitud, SolicitudCompra> solicitudCompra;

}
package ec.edu.monster.modelo;

import ec.edu.monster.modelo.DetalleOrdenPK;
import ec.edu.monster.modelo.ItemSolicitud;
import ec.edu.monster.modelo.OrdenContractual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(DetalleOrden.class)
public class DetalleOrden_ { 

    public static volatile SingularAttribute<DetalleOrden, ItemSolicitud> itemSolicitud;
    public static volatile SingularAttribute<DetalleOrden, OrdenContractual> ordenContractual;
    public static volatile SingularAttribute<DetalleOrden, String> cedetFirma;
    public static volatile SingularAttribute<DetalleOrden, DetalleOrdenPK> detalleOrdenPK;

}
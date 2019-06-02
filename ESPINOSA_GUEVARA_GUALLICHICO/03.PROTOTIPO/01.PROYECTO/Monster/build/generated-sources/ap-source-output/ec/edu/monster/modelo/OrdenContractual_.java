package ec.edu.monster.modelo;

import ec.edu.monster.modelo.ItemSolicitud;
import ec.edu.monster.modelo.Proveedor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-07T17:38:57")
@StaticMetamodel(OrdenContractual.class)
public class OrdenContractual_ { 

    public static volatile SingularAttribute<OrdenContractual, String> ordNumero;
    public static volatile SingularAttribute<OrdenContractual, Boolean> ordAprovaciondirectorfinanciero;
    public static volatile CollectionAttribute<OrdenContractual, ItemSolicitud> itemSolicitudCollection;
    public static volatile SingularAttribute<OrdenContractual, Date> ordFechaorden;
    public static volatile SingularAttribute<OrdenContractual, Date> ordFechaentrega;
    public static volatile SingularAttribute<OrdenContractual, Float> ordMontototal;
    public static volatile SingularAttribute<OrdenContractual, Proveedor> proId;

}
package ec.edu.monster.modelo;

import ec.edu.monster.modelo.DetalleOrden;
import ec.edu.monster.modelo.Proveedor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(OrdenContractual.class)
public class OrdenContractual_ { 

    public static volatile SingularAttribute<OrdenContractual, Proveedor> aeproId;
    public static volatile SingularAttribute<OrdenContractual, String> ceordNumero;
    public static volatile SingularAttribute<OrdenContractual, Date> ceordFechentrega;
    public static volatile SingularAttribute<OrdenContractual, Float> ceordMontotal;
    public static volatile SingularAttribute<OrdenContractual, Boolean> ceordAprobdirfinanciero;
    public static volatile CollectionAttribute<OrdenContractual, DetalleOrden> detalleOrdenCollection;
    public static volatile SingularAttribute<OrdenContractual, Date> ceordFechaord;

}
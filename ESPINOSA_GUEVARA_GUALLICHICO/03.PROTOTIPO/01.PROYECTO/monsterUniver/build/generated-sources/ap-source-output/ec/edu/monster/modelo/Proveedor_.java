package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Bienes;
import ec.edu.monster.modelo.OrdenContractual;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, String> aeproTelefono;
    public static volatile CollectionAttribute<Proveedor, Bienes> bienesCollection;
    public static volatile SingularAttribute<Proveedor, String> aeproId;
    public static volatile SingularAttribute<Proveedor, String> aeproNombre;
    public static volatile SingularAttribute<Proveedor, String> aeproRuc;
    public static volatile SingularAttribute<Proveedor, String> aeproDireccion;
    public static volatile CollectionAttribute<Proveedor, OrdenContractual> ordenContractualCollection;

}
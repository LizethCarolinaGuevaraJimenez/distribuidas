package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Bienes;
import ec.edu.monster.modelo.OrdenContractual;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T22:21:30")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, String> proTelefono;
    public static volatile CollectionAttribute<Proveedor, Bienes> bienesCollection;
    public static volatile SingularAttribute<Proveedor, String> proDireccion;
    public static volatile SingularAttribute<Proveedor, String> proNombre;
    public static volatile SingularAttribute<Proveedor, String> proId;
    public static volatile SingularAttribute<Proveedor, String> proRuc;
    public static volatile CollectionAttribute<Proveedor, OrdenContractual> ordenContractualCollection;

}
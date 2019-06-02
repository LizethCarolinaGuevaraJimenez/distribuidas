package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Cargo;
import ec.edu.monster.modelo.ItemSalida;
import ec.edu.monster.modelo.SalidaAlmacen;
import ec.edu.monster.modelo.SolicitudCompra;
import ec.edu.monster.modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T22:21:30")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> empId;
    public static volatile SingularAttribute<Empleado, String> empNombre;
    public static volatile CollectionAttribute<Empleado, SolicitudCompra> solicitudCompraCollection;
    public static volatile SingularAttribute<Empleado, Usuario> usuario;
    public static volatile CollectionAttribute<Empleado, SalidaAlmacen> salidaAlmacenCollection;
    public static volatile SingularAttribute<Empleado, String> empCedula;
    public static volatile CollectionAttribute<Empleado, ItemSalida> itemSalidaCollection;
    public static volatile SingularAttribute<Empleado, String> empTelefono;
    public static volatile SingularAttribute<Empleado, Cargo> carId;

}
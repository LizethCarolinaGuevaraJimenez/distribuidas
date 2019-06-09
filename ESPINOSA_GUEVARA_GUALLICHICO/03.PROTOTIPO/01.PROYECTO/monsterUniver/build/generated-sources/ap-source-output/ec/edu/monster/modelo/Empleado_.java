package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Cargo;
import ec.edu.monster.modelo.Direccion;
import ec.edu.monster.modelo.EstadoCivil;
import ec.edu.monster.modelo.ItemSalida;
import ec.edu.monster.modelo.SalidaAlmacen;
import ec.edu.monster.modelo.Sexo;
import ec.edu.monster.modelo.SolicitudCompra;
import ec.edu.monster.modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> peempCorreo;
    public static volatile SingularAttribute<Empleado, Sexo> pesexCodigo;
    public static volatile CollectionAttribute<Empleado, SolicitudCompra> solicitudCompraCollection;
    public static volatile SingularAttribute<Empleado, EstadoCivil> peestCodigo;
    public static volatile SingularAttribute<Empleado, String> peempNomres;
    public static volatile CollectionAttribute<Empleado, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Empleado, Cargo> pecarId;
    public static volatile SingularAttribute<Empleado, String> peempCedula;
    public static volatile SingularAttribute<Empleado, Direccion> pedirCodigo;
    public static volatile SingularAttribute<Empleado, String> peempId;
    public static volatile SingularAttribute<Empleado, String> peempApellidos;
    public static volatile SingularAttribute<Empleado, String> peempTelefono;
    public static volatile CollectionAttribute<Empleado, SalidaAlmacen> salidaAlmacenCollection;
    public static volatile CollectionAttribute<Empleado, ItemSalida> itemSalidaCollection;

}
package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Empleado;
import ec.edu.monster.modelo.Estado;
import ec.edu.monster.modelo.UsuarioPerfil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-07T17:38:57")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> usuPiefirma;
    public static volatile SingularAttribute<Usuario, String> empId;
    public static volatile SingularAttribute<Usuario, Date> usuFechaultimocambio;
    public static volatile SingularAttribute<Usuario, Empleado> empleado;
    public static volatile SingularAttribute<Usuario, Estado> estCodigo;
    public static volatile SingularAttribute<Usuario, Date> usuFechacreacion;
    public static volatile CollectionAttribute<Usuario, UsuarioPerfil> usuarioPerfilCollection;
    public static volatile SingularAttribute<Usuario, String> usuContrasena;

}
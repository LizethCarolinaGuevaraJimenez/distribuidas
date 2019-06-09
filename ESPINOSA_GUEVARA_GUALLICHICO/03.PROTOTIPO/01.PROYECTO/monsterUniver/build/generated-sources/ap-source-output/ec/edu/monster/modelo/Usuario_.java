package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Empleado;
import ec.edu.monster.modelo.Estado;
import ec.edu.monster.modelo.UsuarioPerfil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Estado> seestCodigo;
    public static volatile SingularAttribute<Usuario, String> seusuUsuario;
    public static volatile SingularAttribute<Usuario, Date> seusuFechacreacion;
    public static volatile CollectionAttribute<Usuario, UsuarioPerfil> usuarioPerfilCollection;
    public static volatile SingularAttribute<Usuario, Empleado> peempId;
    public static volatile SingularAttribute<Usuario, Date> seusuFechaultimocambio;
    public static volatile SingularAttribute<Usuario, String> seusuContrasena;

}
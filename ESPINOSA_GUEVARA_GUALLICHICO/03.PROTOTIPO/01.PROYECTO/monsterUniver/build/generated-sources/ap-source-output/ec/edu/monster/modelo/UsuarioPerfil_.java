package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Perfil;
import ec.edu.monster.modelo.Usuario;
import ec.edu.monster.modelo.UsuarioPerfilPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(UsuarioPerfil.class)
public class UsuarioPerfil_ { 

    public static volatile SingularAttribute<UsuarioPerfil, Date> seusuFechaasignacion;
    public static volatile SingularAttribute<UsuarioPerfil, Date> seusuFechacambio;
    public static volatile SingularAttribute<UsuarioPerfil, Usuario> usuario;
    public static volatile SingularAttribute<UsuarioPerfil, UsuarioPerfilPK> usuarioPerfilPK;
    public static volatile SingularAttribute<UsuarioPerfil, Perfil> perfil;

}
package ec.edu.monster.modelo;

import ec.edu.monster.modelo.OpcionPerfil;
import ec.edu.monster.modelo.Rol;
import ec.edu.monster.modelo.UsuarioPerfil;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T22:21:30")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile SingularAttribute<Perfil, String> perObservacion;
    public static volatile SingularAttribute<Perfil, String> perCodigo;
    public static volatile CollectionAttribute<Perfil, UsuarioPerfil> usuarioPerfilCollection;
    public static volatile SingularAttribute<Perfil, String> perDescripcion;
    public static volatile CollectionAttribute<Perfil, OpcionPerfil> opcionPerfilCollection;
    public static volatile SingularAttribute<Perfil, Rol> rol;

}
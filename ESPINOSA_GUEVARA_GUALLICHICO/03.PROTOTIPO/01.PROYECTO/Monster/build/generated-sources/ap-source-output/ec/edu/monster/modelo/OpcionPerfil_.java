package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Opcion;
import ec.edu.monster.modelo.OpcionPerfilPK;
import ec.edu.monster.modelo.Perfil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T22:21:30")
@StaticMetamodel(OpcionPerfil.class)
public class OpcionPerfil_ { 

    public static volatile SingularAttribute<OpcionPerfil, String> opcperEstado;
    public static volatile SingularAttribute<OpcionPerfil, Opcion> opcion;
    public static volatile SingularAttribute<OpcionPerfil, OpcionPerfilPK> opcionPerfilPK;
    public static volatile SingularAttribute<OpcionPerfil, Date> opcperFechaasignacion;
    public static volatile SingularAttribute<OpcionPerfil, Perfil> perfil;

}
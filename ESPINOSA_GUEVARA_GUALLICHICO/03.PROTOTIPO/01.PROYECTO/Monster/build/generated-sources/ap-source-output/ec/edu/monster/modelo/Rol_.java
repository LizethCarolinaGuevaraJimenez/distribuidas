package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Perfil;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T22:21:30")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> rolInsercion;
    public static volatile SingularAttribute<Rol, String> rolConsulta;
    public static volatile SingularAttribute<Rol, String> rolEliminacion;
    public static volatile SingularAttribute<Rol, String> rolActualizacion;
    public static volatile SingularAttribute<Rol, String> perCodigo;
    public static volatile SingularAttribute<Rol, Perfil> perfil;

}
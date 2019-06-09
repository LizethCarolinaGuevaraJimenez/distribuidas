package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Ciudad;
import ec.edu.monster.modelo.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Direccion.class)
public class Direccion_ { 

    public static volatile SingularAttribute<Direccion, Ciudad> peciuCodigo;
    public static volatile SingularAttribute<Direccion, String> pedirCallep;
    public static volatile SingularAttribute<Direccion, String> pedirCodigo;
    public static volatile SingularAttribute<Direccion, String> pedirNcasa;
    public static volatile CollectionAttribute<Direccion, Empleado> empleadoCollection;
    public static volatile SingularAttribute<Direccion, String> pedirCalles;
    public static volatile SingularAttribute<Direccion, String> pedirReferencia;

}
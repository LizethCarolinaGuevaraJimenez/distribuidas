package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Area;
import ec.edu.monster.modelo.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile SingularAttribute<Cargo, Area> peareId;
    public static volatile CollectionAttribute<Cargo, Empleado> empleadoCollection;
    public static volatile SingularAttribute<Cargo, String> pecarDetalle;
    public static volatile SingularAttribute<Cargo, String> pecarNombre;
    public static volatile SingularAttribute<Cargo, String> pecarId;

}
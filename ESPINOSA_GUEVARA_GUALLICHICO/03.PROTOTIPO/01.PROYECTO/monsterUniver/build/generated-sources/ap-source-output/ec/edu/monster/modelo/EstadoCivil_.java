package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(EstadoCivil.class)
public class EstadoCivil_ { 

    public static volatile SingularAttribute<EstadoCivil, String> peestNombre;
    public static volatile CollectionAttribute<EstadoCivil, Empleado> empleadoCollection;
    public static volatile SingularAttribute<EstadoCivil, String> peestCodigo;

}
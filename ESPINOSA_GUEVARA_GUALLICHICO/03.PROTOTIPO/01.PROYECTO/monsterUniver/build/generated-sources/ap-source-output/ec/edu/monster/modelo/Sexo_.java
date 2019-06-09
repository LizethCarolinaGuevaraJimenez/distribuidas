package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Sexo.class)
public class Sexo_ { 

    public static volatile SingularAttribute<Sexo, String> pesexCodigo;
    public static volatile CollectionAttribute<Sexo, Empleado> empleadoCollection;
    public static volatile SingularAttribute<Sexo, String> pesexDescripcion;

}
package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Direccion;
import ec.edu.monster.modelo.Provincia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, String> peciuCodigo;
    public static volatile SingularAttribute<Ciudad, Provincia> peprovCodigo;
    public static volatile CollectionAttribute<Ciudad, Direccion> direccionCollection;
    public static volatile SingularAttribute<Ciudad, String> peciuNombre;

}
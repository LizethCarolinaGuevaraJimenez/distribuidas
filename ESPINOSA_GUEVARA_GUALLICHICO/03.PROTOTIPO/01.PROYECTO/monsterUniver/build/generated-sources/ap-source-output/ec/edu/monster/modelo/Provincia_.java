package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Ciudad;
import ec.edu.monster.modelo.Pais;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Provincia.class)
public class Provincia_ { 

    public static volatile SingularAttribute<Provincia, Pais> pepaiCodigo;
    public static volatile CollectionAttribute<Provincia, Ciudad> ciudadCollection;
    public static volatile SingularAttribute<Provincia, String> peprovCodigo;
    public static volatile SingularAttribute<Provincia, String> peprovNombre;

}
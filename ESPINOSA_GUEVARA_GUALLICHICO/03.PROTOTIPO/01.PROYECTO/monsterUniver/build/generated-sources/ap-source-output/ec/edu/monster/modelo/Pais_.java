package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Provincia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, String> pepaiCodigo;
    public static volatile CollectionAttribute<Pais, Provincia> provinciaCollection;
    public static volatile SingularAttribute<Pais, String> pepaiNombre;
    public static volatile SingularAttribute<Pais, String> pepaiCodpCopost;

}
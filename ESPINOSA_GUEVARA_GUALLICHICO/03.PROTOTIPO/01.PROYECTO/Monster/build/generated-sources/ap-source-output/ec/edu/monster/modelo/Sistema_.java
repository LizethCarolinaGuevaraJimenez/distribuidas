package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Estado;
import ec.edu.monster.modelo.Opcion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T22:21:30")
@StaticMetamodel(Sistema.class)
public class Sistema_ { 

    public static volatile SingularAttribute<Sistema, String> sisCodigo;
    public static volatile SingularAttribute<Sistema, String> sisDescripcion;
    public static volatile SingularAttribute<Sistema, Estado> estCodigo;
    public static volatile CollectionAttribute<Sistema, Opcion> opcionCollection;

}
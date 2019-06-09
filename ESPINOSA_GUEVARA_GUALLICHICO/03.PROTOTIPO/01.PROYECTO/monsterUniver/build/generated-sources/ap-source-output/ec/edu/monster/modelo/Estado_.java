package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Sistema;
import ec.edu.monster.modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, String> seestCodigo;
    public static volatile SingularAttribute<Estado, String> seestDescripcion;
    public static volatile CollectionAttribute<Estado, Sistema> sistemaCollection;
    public static volatile CollectionAttribute<Estado, Usuario> usuarioCollection;

}
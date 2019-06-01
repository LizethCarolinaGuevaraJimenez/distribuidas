package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Sistema;
import ec.edu.monster.modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-07T17:38:58")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, String> estDescripcion;
    public static volatile SingularAttribute<Estado, String> estCodigo;
    public static volatile CollectionAttribute<Estado, Sistema> sistemaCollection;
    public static volatile CollectionAttribute<Estado, Usuario> usuarioCollection;

}
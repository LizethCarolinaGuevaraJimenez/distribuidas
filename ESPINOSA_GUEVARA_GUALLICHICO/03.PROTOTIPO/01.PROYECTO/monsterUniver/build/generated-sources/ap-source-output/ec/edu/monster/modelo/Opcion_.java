package ec.edu.monster.modelo;

import ec.edu.monster.modelo.OpcionPerfil;
import ec.edu.monster.modelo.Sistema;
import ec.edu.monster.modelo.Ventana;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Opcion.class)
public class Opcion_ { 

    public static volatile SingularAttribute<Opcion, Ventana> sevenCodigo;
    public static volatile SingularAttribute<Opcion, String> seopcCodigo;
    public static volatile SingularAttribute<Opcion, String> seopcVista;
    public static volatile CollectionAttribute<Opcion, OpcionPerfil> opcionPerfilCollection;
    public static volatile SingularAttribute<Opcion, String> seopcNombre;
    public static volatile SingularAttribute<Opcion, Sistema> sesisCodigo;

}
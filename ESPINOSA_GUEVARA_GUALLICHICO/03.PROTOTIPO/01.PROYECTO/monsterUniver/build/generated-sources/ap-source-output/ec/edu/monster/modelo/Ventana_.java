package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Opcion;
import ec.edu.monster.modelo.VentanaPerfil;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:20")
@StaticMetamodel(Ventana.class)
public class Ventana_ { 

    public static volatile SingularAttribute<Ventana, String> sevenDescripcion;
    public static volatile SingularAttribute<Ventana, String> sevenMensaje;
    public static volatile SingularAttribute<Ventana, String> sevenCodigo;
    public static volatile CollectionAttribute<Ventana, Opcion> opcionCollection;
    public static volatile CollectionAttribute<Ventana, VentanaPerfil> ventanaPerfilCollection;

}
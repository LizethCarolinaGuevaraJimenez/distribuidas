package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Cargo;
import ec.edu.monster.modelo.SolicitudCompra;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T22:21:30")
@StaticMetamodel(Area.class)
public class Area_ { 

    public static volatile SingularAttribute<Area, String> areId;
    public static volatile CollectionAttribute<Area, SolicitudCompra> solicitudCompraCollection;
    public static volatile SingularAttribute<Area, String> areUbicacion;
    public static volatile CollectionAttribute<Area, Cargo> cargoCollection;
    public static volatile SingularAttribute<Area, String> areNombre;

}
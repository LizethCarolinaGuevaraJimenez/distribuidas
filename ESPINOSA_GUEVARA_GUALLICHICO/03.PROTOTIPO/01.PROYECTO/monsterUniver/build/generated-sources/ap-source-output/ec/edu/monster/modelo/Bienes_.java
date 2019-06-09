package ec.edu.monster.modelo;

import ec.edu.monster.modelo.ItemEntrada;
import ec.edu.monster.modelo.ItemSalida;
import ec.edu.monster.modelo.ItemSolicitud;
import ec.edu.monster.modelo.Proveedor;
import ec.edu.monster.modelo.Stock;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Bienes.class)
public class Bienes_ { 

    public static volatile SingularAttribute<Bienes, Proveedor> aeproId;
    public static volatile CollectionAttribute<Bienes, ItemSolicitud> itemSolicitudCollection;
    public static volatile CollectionAttribute<Bienes, Stock> stockCollection;
    public static volatile CollectionAttribute<Bienes, ItemEntrada> itemEntradaCollection;
    public static volatile SingularAttribute<Bienes, String> mebieId;
    public static volatile SingularAttribute<Bienes, String> mebieNombre;
    public static volatile SingularAttribute<Bienes, String> mebieUmedida;
    public static volatile SingularAttribute<Bienes, String> mebieTipo;
    public static volatile CollectionAttribute<Bienes, ItemSalida> itemSalidaCollection;

}
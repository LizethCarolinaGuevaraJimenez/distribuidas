package ec.edu.monster.modelo;

import ec.edu.monster.modelo.ItemEntrada;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-07T17:38:58")
@StaticMetamodel(EntradaAlmacen.class)
public class EntradaAlmacen_ { 

    public static volatile SingularAttribute<EntradaAlmacen, String> entNumerofactura;
    public static volatile SingularAttribute<EntradaAlmacen, Integer> entTotalbienes;
    public static volatile SingularAttribute<EntradaAlmacen, Date> entFecha;
    public static volatile CollectionAttribute<EntradaAlmacen, ItemEntrada> itemEntradaCollection;
    public static volatile SingularAttribute<EntradaAlmacen, String> entNumero;
    public static volatile SingularAttribute<EntradaAlmacen, Float> entValortotal;

}
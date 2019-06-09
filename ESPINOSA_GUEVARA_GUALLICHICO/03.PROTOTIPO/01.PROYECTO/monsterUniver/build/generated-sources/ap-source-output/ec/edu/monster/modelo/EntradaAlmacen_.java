package ec.edu.monster.modelo;

import ec.edu.monster.modelo.ItemEntrada;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(EntradaAlmacen.class)
public class EntradaAlmacen_ { 

    public static volatile SingularAttribute<EntradaAlmacen, String> aeentNumero;
    public static volatile SingularAttribute<EntradaAlmacen, Date> aeentFecha;
    public static volatile CollectionAttribute<EntradaAlmacen, ItemEntrada> itemEntradaCollection;
    public static volatile SingularAttribute<EntradaAlmacen, String> aeentNumfactura;
    public static volatile SingularAttribute<EntradaAlmacen, Integer> aeentTotalbienes;
    public static volatile SingularAttribute<EntradaAlmacen, Float> aeentValortot;

}
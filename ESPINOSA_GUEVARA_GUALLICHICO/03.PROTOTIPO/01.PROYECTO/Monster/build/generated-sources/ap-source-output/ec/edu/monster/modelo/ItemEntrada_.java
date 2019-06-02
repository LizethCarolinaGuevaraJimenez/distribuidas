package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Bienes;
import ec.edu.monster.modelo.EntradaAlmacen;
import ec.edu.monster.modelo.ItemEntradaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T22:21:30")
@StaticMetamodel(ItemEntrada.class)
public class ItemEntrada_ { 

    public static volatile SingularAttribute<ItemEntrada, EntradaAlmacen> entradaAlmacen;
    public static volatile SingularAttribute<ItemEntrada, Integer> iteeCantidadentregada;
    public static volatile SingularAttribute<ItemEntrada, Bienes> bienes;
    public static volatile SingularAttribute<ItemEntrada, ItemEntradaPK> itemEntradaPK;

}
package ec.edu.monster.modelo;

import ec.edu.monster.modelo.SolicitudCompra;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-07T17:38:57")
@StaticMetamodel(RubroPresupuestario.class)
public class RubroPresupuestario_ { 

    public static volatile SingularAttribute<RubroPresupuestario, String> rubCategoria;
    public static volatile CollectionAttribute<RubroPresupuestario, SolicitudCompra> solicitudCompraCollection;
    public static volatile SingularAttribute<RubroPresupuestario, Float> rubPresupuesto;
    public static volatile SingularAttribute<RubroPresupuestario, String> rubCodigo;

}
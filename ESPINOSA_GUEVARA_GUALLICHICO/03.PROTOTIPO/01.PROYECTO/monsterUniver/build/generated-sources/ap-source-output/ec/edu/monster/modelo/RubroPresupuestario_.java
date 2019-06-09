package ec.edu.monster.modelo;

import ec.edu.monster.modelo.SolicitudCompra;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:20")
@StaticMetamodel(RubroPresupuestario.class)
public class RubroPresupuestario_ { 

    public static volatile CollectionAttribute<RubroPresupuestario, SolicitudCompra> solicitudCompraCollection;
    public static volatile SingularAttribute<RubroPresupuestario, String> cerubCodigo;
    public static volatile SingularAttribute<RubroPresupuestario, String> cerubCategoria;
    public static volatile SingularAttribute<RubroPresupuestario, Float> cerubPresupuesto;

}
package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Bienes;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T22:21:30")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, String> stoId;
    public static volatile SingularAttribute<Stock, BigDecimal> stoCantidad;
    public static volatile SingularAttribute<Stock, Bienes> bienId;

}
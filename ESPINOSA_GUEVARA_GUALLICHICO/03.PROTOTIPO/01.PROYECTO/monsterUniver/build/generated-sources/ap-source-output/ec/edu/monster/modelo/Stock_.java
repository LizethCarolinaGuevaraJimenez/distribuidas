package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Bienes;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-09T14:39:21")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, BigDecimal> aestoCantidad;
    public static volatile SingularAttribute<Stock, String> aestoId;
    public static volatile SingularAttribute<Stock, Bienes> mebieId;

}
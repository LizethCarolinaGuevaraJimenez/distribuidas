CREATE DATABASE  IF NOT EXISTS `monsteruniversity` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `monsteruniversity`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
DROP TABLE IF EXISTS `mebie_bienes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mebie_bienes` (
  `BIEN_ID` int(11) NOT NULL,
  `PRO_ID` int(11) NOT NULL,
  `BIEN_NOMBRE` varchar(100) DEFAULT NULL,
  `BIEN_UNIDADMEDIDA` varchar(100) DEFAULT NULL,
  `BIEN_TIPO` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`BIEN_ID`),
  KEY `FK_PROVEEDOR_BIENES` (`PRO_ID`),
  CONSTRAINT `FK_PROVEEDOR_BIENES` FOREIGN KEY (`PRO_ID`) REFERENCES `aepro_proveedor` (`PRO_ID`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `mebie_bienes` (`BIEN_ID`, `PRO_ID`, `BIEN_NOMBRE`, `BIEN_UNIDADMEDIDA`, `BIEN_TIPO`) VALUES (1,1,'Mesa','cm','Inmueble');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


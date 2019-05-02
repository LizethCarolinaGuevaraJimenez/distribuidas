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
DROP TABLE IF EXISTS `aesto_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aesto_stock` (
  `STO_ID` int(11) NOT NULL,
  `BIEN_ID` int(11) NOT NULL,
  `STO_CANTIDAD` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`STO_ID`),
  KEY `FK_BIENES_STOCK` (`BIEN_ID`),
  CONSTRAINT `FK_BIENES_STOCK` FOREIGN KEY (`BIEN_ID`) REFERENCES `mebie_bienes` (`BIEN_ID`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `aesto_stock` (`STO_ID`, `BIEN_ID`, `STO_CANTIDAD`) VALUES (1,1,10.00);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

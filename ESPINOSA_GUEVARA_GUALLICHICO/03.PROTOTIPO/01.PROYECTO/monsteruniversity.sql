CREATE DATABASE  IF NOT EXISTS `monsteruniversity` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `monsteruniversity`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: monsteruniversity
-- ------------------------------------------------------
-- Server version	5.6.43-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aeent_entalm`
--

DROP TABLE IF EXISTS `aeent_entalm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aeent_entalm` (
  `AEENT_NUMERO` varchar(100) NOT NULL,
  `AEENT_FECHA` date DEFAULT NULL,
  `AEENT_NUMFACTURA` varchar(100) DEFAULT NULL,
  `AEENT_TOTALBIENES` int(11) DEFAULT NULL,
  `AEENT_VALORTOT` float DEFAULT NULL,
  PRIMARY KEY (`AEENT_NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aeent_entalm`
--

LOCK TABLES `aeent_entalm` WRITE;
/*!40000 ALTER TABLE `aeent_entalm` DISABLE KEYS */;
/*!40000 ALTER TABLE `aeent_entalm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aeite_iteent`
--

DROP TABLE IF EXISTS `aeite_iteent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aeite_iteent` (
  `AEENT_NUMERO` varchar(100) NOT NULL,
  `MEBIE_ID` varchar(100) NOT NULL,
  `AEITE_CANTENTREGA` int(11) DEFAULT NULL,
  PRIMARY KEY (`AEENT_NUMERO`,`MEBIE_ID`),
  KEY `FK_BIENES_ITEM_ENTRADA` (`MEBIE_ID`),
  CONSTRAINT `FK_BIENES_ITEM_ENTRADA` FOREIGN KEY (`MEBIE_ID`) REFERENCES `mebie_bienes` (`MEBIE_ID`),
  CONSTRAINT `FK_ITEM_ENTRADA_ENTRADA` FOREIGN KEY (`AEENT_NUMERO`) REFERENCES `aeent_entalm` (`AEENT_NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aeite_iteent`
--

LOCK TABLES `aeite_iteent` WRITE;
/*!40000 ALTER TABLE `aeite_iteent` DISABLE KEYS */;
/*!40000 ALTER TABLE `aeite_iteent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aeite_itesal`
--

DROP TABLE IF EXISTS `aeite_itesal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aeite_itesal` (
  `PEEMP_ID` varchar(100) NOT NULL,
  `AESAL_NUMERO` varchar(100) NOT NULL,
  `MEBIE_ID` varchar(100) NOT NULL,
  `AEITE_CANTIENTR` int(11) DEFAULT NULL,
  PRIMARY KEY (`PEEMP_ID`,`AESAL_NUMERO`,`MEBIE_ID`),
  KEY `FK_BIENES_ITEM_SALIDA` (`MEBIE_ID`),
  KEY `FK_SALIDA_ALMACEN_ITEM_SALIDA` (`AESAL_NUMERO`),
  CONSTRAINT `FK_BIENES_ITEM_SALIDA` FOREIGN KEY (`MEBIE_ID`) REFERENCES `mebie_bienes` (`MEBIE_ID`),
  CONSTRAINT `FK_ITEM_SALIDA_EMPLEADO` FOREIGN KEY (`PEEMP_ID`) REFERENCES `peemp_empleado` (`PEEMP_ID`),
  CONSTRAINT `FK_SALIDA_ALMACEN_ITEM_SALIDA` FOREIGN KEY (`AESAL_NUMERO`) REFERENCES `aesal_salalm` (`AESAL_NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aeite_itesal`
--

LOCK TABLES `aeite_itesal` WRITE;
/*!40000 ALTER TABLE `aeite_itesal` DISABLE KEYS */;
/*!40000 ALTER TABLE `aeite_itesal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aepro_proveedor`
--

DROP TABLE IF EXISTS `aepro_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aepro_proveedor` (
  `AEPRO_ID` varchar(100) NOT NULL,
  `AEPRO_RUC` varchar(100) DEFAULT NULL,
  `AEPRO_NOMBRE` varchar(100) DEFAULT NULL,
  `AEPRO_TELEFONO` varchar(15) DEFAULT NULL,
  `AEPRO_DIRECCION` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`AEPRO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aepro_proveedor`
--

LOCK TABLES `aepro_proveedor` WRITE;
/*!40000 ALTER TABLE `aepro_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `aepro_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aesal_salalm`
--

DROP TABLE IF EXISTS `aesal_salalm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aesal_salalm` (
  `AESAL_NUMERO` varchar(100) NOT NULL,
  `PEEMP_ID` varchar(100) NOT NULL,
  `AESAL_FESALIDA` date DEFAULT NULL,
  `AESAL_FEENTREGA` date DEFAULT NULL,
  PRIMARY KEY (`AESAL_NUMERO`),
  KEY `FK_SALIDA_EMPLEADO` (`PEEMP_ID`),
  CONSTRAINT `FK_SALIDA_EMPLEADO` FOREIGN KEY (`PEEMP_ID`) REFERENCES `peemp_empleado` (`PEEMP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aesal_salalm`
--

LOCK TABLES `aesal_salalm` WRITE;
/*!40000 ALTER TABLE `aesal_salalm` DISABLE KEYS */;
/*!40000 ALTER TABLE `aesal_salalm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aesto_stock`
--

DROP TABLE IF EXISTS `aesto_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aesto_stock` (
  `AESTO_ID` varchar(100) NOT NULL,
  `MEBIE_ID` varchar(100) NOT NULL,
  `AESTO_CANTIDAD` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`AESTO_ID`),
  KEY `FK_BIENES_STOCK` (`MEBIE_ID`),
  CONSTRAINT `FK_BIENES_STOCK` FOREIGN KEY (`MEBIE_ID`) REFERENCES `mebie_bienes` (`MEBIE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aesto_stock`
--

LOCK TABLES `aesto_stock` WRITE;
/*!40000 ALTER TABLE `aesto_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `aesto_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cedet_detord`
--

DROP TABLE IF EXISTS `cedet_detord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cedet_detord` (
  `CEORD_NUMERO` varchar(100) NOT NULL,
  `CESOL_NUMERO` varchar(100) NOT NULL,
  `MEBIE_ID` varchar(100) NOT NULL,
  `CEDET_FIRMA` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CEORD_NUMERO`,`CESOL_NUMERO`,`MEBIE_ID`),
  KEY `FK_DETORD_ITEMSOL` (`CESOL_NUMERO`,`MEBIE_ID`),
  CONSTRAINT `FK_DETORD_ITEMSOL` FOREIGN KEY (`CESOL_NUMERO`, `MEBIE_ID`) REFERENCES `ceite_itesol` (`CESOL_NUMERO`, `MEBIE_ID`),
  CONSTRAINT `FK_DETORD_ORDCON` FOREIGN KEY (`CEORD_NUMERO`) REFERENCES `ceord_ordcon` (`CEORD_NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cedet_detord`
--

LOCK TABLES `cedet_detord` WRITE;
/*!40000 ALTER TABLE `cedet_detord` DISABLE KEYS */;
/*!40000 ALTER TABLE `cedet_detord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ceite_itesol`
--

DROP TABLE IF EXISTS `ceite_itesol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ceite_itesol` (
  `CESOL_NUMERO` varchar(100) NOT NULL,
  `MEBIE_ID` varchar(100) NOT NULL,
  `CEITE_CANTIDADSALIDA` int(11) DEFAULT NULL,
  `CEITE_CANTIDADDESPACHADA` int(11) DEFAULT NULL,
  `CEITE_VALORTOTAL` float DEFAULT NULL,
  PRIMARY KEY (`CESOL_NUMERO`,`MEBIE_ID`),
  KEY `FK_BIENES_ITEM_SOLICITUD` (`MEBIE_ID`),
  CONSTRAINT `FK_BIENES_ITEM_SOLICITUD` FOREIGN KEY (`MEBIE_ID`) REFERENCES `mebie_bienes` (`MEBIE_ID`),
  CONSTRAINT `FK_SOLICITUD_COMPRA_ITEM_SOLICITUD` FOREIGN KEY (`CESOL_NUMERO`) REFERENCES `cesol_solcom` (`CESOL_NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ceite_itesol`
--

LOCK TABLES `ceite_itesol` WRITE;
/*!40000 ALTER TABLE `ceite_itesol` DISABLE KEYS */;
/*!40000 ALTER TABLE `ceite_itesol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ceord_ordcon`
--

DROP TABLE IF EXISTS `ceord_ordcon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ceord_ordcon` (
  `CEORD_NUMERO` varchar(100) NOT NULL,
  `AEPRO_ID` varchar(100) NOT NULL,
  `CEORD_FECHAORD` date DEFAULT NULL,
  `CEORD_FECHENTREGA` date DEFAULT NULL,
  `CEORD_MONTOTAL` float DEFAULT NULL,
  `CEORD_APROBDIRFINANCIERO` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`CEORD_NUMERO`),
  KEY `FK_ORDEN_PROVEEDOR` (`AEPRO_ID`),
  CONSTRAINT `FK_ORDEN_PROVEEDOR` FOREIGN KEY (`AEPRO_ID`) REFERENCES `aepro_proveedor` (`AEPRO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ceord_ordcon`
--

LOCK TABLES `ceord_ordcon` WRITE;
/*!40000 ALTER TABLE `ceord_ordcon` DISABLE KEYS */;
/*!40000 ALTER TABLE `ceord_ordcon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cerub_rubpre`
--

DROP TABLE IF EXISTS `cerub_rubpre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cerub_rubpre` (
  `CERUB_CODIGO` varchar(100) NOT NULL,
  `CERUB_CATEGORIA` varchar(100) DEFAULT NULL,
  `CERUB_PRESUPUESTO` float DEFAULT NULL,
  PRIMARY KEY (`CERUB_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cerub_rubpre`
--

LOCK TABLES `cerub_rubpre` WRITE;
/*!40000 ALTER TABLE `cerub_rubpre` DISABLE KEYS */;
/*!40000 ALTER TABLE `cerub_rubpre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cesol_solcom`
--

DROP TABLE IF EXISTS `cesol_solcom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cesol_solcom` (
  `CESOL_NUMERO` varchar(100) NOT NULL,
  `PEEMP_ID` varchar(100) NOT NULL,
  `PEARE_ID` varchar(100) NOT NULL,
  `CERUB_CODIGO` varchar(100) NOT NULL,
  `CESOL_FECHA` date DEFAULT NULL,
  `CESOL_APROVDIREFINANCIER` tinyint(1) DEFAULT NULL,
  `CESOL_APROJEFEAREA` tinyint(1) DEFAULT NULL,
  `CESOL_TOTAL` float DEFAULT NULL,
  PRIMARY KEY (`CESOL_NUMERO`),
  KEY `FK_SOLICITUD_COMPRA_AREA` (`PEARE_ID`),
  KEY `FK_SOLICITUD_COMPRA_EMPLEADO` (`PEEMP_ID`),
  KEY `FK_SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO` (`CERUB_CODIGO`),
  CONSTRAINT `FK_SOLICITUD_COMPRA_AREA` FOREIGN KEY (`PEARE_ID`) REFERENCES `peare_area` (`PEARE_ID`),
  CONSTRAINT `FK_SOLICITUD_COMPRA_EMPLEADO` FOREIGN KEY (`PEEMP_ID`) REFERENCES `peemp_empleado` (`PEEMP_ID`),
  CONSTRAINT `FK_SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO` FOREIGN KEY (`CERUB_CODIGO`) REFERENCES `cerub_rubpre` (`CERUB_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cesol_solcom`
--

LOCK TABLES `cesol_solcom` WRITE;
/*!40000 ALTER TABLE `cesol_solcom` DISABLE KEYS */;
/*!40000 ALTER TABLE `cesol_solcom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mebie_bienes`
--

DROP TABLE IF EXISTS `mebie_bienes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mebie_bienes` (
  `MEBIE_ID` varchar(100) NOT NULL,
  `AEPRO_ID` varchar(100) NOT NULL,
  `MEBIE_NOMBRE` varchar(100) DEFAULT NULL,
  `MEBIE_UMEDIDA` varchar(100) DEFAULT NULL,
  `MEBIE_TIPO` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`MEBIE_ID`),
  KEY `FK_PROVEEDOR_BIENES` (`AEPRO_ID`),
  CONSTRAINT `FK_PROVEEDOR_BIENES` FOREIGN KEY (`AEPRO_ID`) REFERENCES `aepro_proveedor` (`AEPRO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mebie_bienes`
--

LOCK TABLES `mebie_bienes` WRITE;
/*!40000 ALTER TABLE `mebie_bienes` DISABLE KEYS */;
/*!40000 ALTER TABLE `mebie_bienes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peare_area`
--

DROP TABLE IF EXISTS `peare_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peare_area` (
  `PEARE_ID` varchar(100) NOT NULL,
  `PEARE_NOMBRE` varchar(100) DEFAULT NULL,
  `PEARE_UBICACION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PEARE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peare_area`
--

LOCK TABLES `peare_area` WRITE;
/*!40000 ALTER TABLE `peare_area` DISABLE KEYS */;
INSERT INTO `peare_area` VALUES ('1','Unidad de Admision y Registro','Edificio Central');
/*!40000 ALTER TABLE `peare_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pecar_cargo`
--

DROP TABLE IF EXISTS `pecar_cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pecar_cargo` (
  `PECAR_ID` varchar(100) NOT NULL,
  `PEARE_ID` varchar(100) NOT NULL,
  `PECAR_NOMBRE` varchar(100) NOT NULL,
  `PECAR_DETALLE` varchar(500) NOT NULL,
  PRIMARY KEY (`PECAR_ID`),
  KEY `FK_CARGO_AREA` (`PEARE_ID`),
  CONSTRAINT `FK_CARGO_AREA` FOREIGN KEY (`PEARE_ID`) REFERENCES `peare_area` (`PEARE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pecar_cargo`
--

LOCK TABLES `pecar_cargo` WRITE;
/*!40000 ALTER TABLE `pecar_cargo` DISABLE KEYS */;
INSERT INTO `pecar_cargo` VALUES ('1','1','SuperAdministrador','Control total del sistema');
/*!40000 ALTER TABLE `pecar_cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peciu_ciudad`
--

DROP TABLE IF EXISTS `peciu_ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peciu_ciudad` (
  `PECIU_CODIGO` varchar(20) NOT NULL,
  `PEPROV_CODIGO` varchar(20) NOT NULL,
  `PECIU_NOMBRE` varchar(50) NOT NULL,
  PRIMARY KEY (`PECIU_CODIGO`),
  KEY `FK_TIENE` (`PEPROV_CODIGO`),
  CONSTRAINT `FK_TIENE` FOREIGN KEY (`PEPROV_CODIGO`) REFERENCES `pepro_provin` (`PEPROV_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peciu_ciudad`
--

LOCK TABLES `peciu_ciudad` WRITE;
/*!40000 ALTER TABLE `peciu_ciudad` DISABLE KEYS */;
INSERT INTO `peciu_ciudad` VALUES ('1','1','Quito');
/*!40000 ALTER TABLE `peciu_ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedir_direcc`
--

DROP TABLE IF EXISTS `pedir_direcc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedir_direcc` (
  `PEDIR_CODIGO` varchar(20) NOT NULL,
  `PECIU_CODIGO` varchar(20) NOT NULL,
  `PEDIR_NCASA` varchar(10) DEFAULT NULL,
  `PEDIR_CALLEP` varchar(50) DEFAULT NULL,
  `PEDIR_CALLES` varchar(50) DEFAULT NULL,
  `PEDIR_REFERENCIA` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PEDIR_CODIGO`),
  KEY `FK_ESTA` (`PECIU_CODIGO`),
  CONSTRAINT `FK_ESTA` FOREIGN KEY (`PECIU_CODIGO`) REFERENCES `peciu_ciudad` (`PECIU_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedir_direcc`
--

LOCK TABLES `pedir_direcc` WRITE;
/*!40000 ALTER TABLE `pedir_direcc` DISABLE KEYS */;
INSERT INTO `pedir_direcc` VALUES ('1','1','E11-274','Calle de las Higueras','8 de Septiembre','Frente a papeleria ABC');
/*!40000 ALTER TABLE `pedir_direcc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peemp_empleado`
--

DROP TABLE IF EXISTS `peemp_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peemp_empleado` (
  `PEEMP_ID` varchar(100) NOT NULL,
  `PECAR_ID` varchar(100) NOT NULL,
  `PESEX_CODIGO` char(1) NOT NULL,
  `PEEST_CODIGO` varchar(20) NOT NULL,
  `PEDIR_CODIGO` varchar(20) NOT NULL,
  `PEEMP_CEDULA` varchar(15) DEFAULT NULL,
  `PEEMP_NOMRES` varchar(100) DEFAULT NULL,
  `PEEMP_APELLIDOS` varchar(100) DEFAULT NULL,
  `PEEMP_TELEFONO` varchar(10) DEFAULT NULL,
  `PEEMP_CORREO` varchar(30) NOT NULL,
  PRIMARY KEY (`PEEMP_ID`),
  KEY `FK_EMPLEADO_CARGO` (`PECAR_ID`),
  KEY `FK__` (`PESEX_CODIGO`),
  KEY `FK___` (`PEEST_CODIGO`),
  KEY `FK____` (`PEDIR_CODIGO`),
  CONSTRAINT `FK_EMPLEADO_CARGO` FOREIGN KEY (`PECAR_ID`) REFERENCES `pecar_cargo` (`PECAR_ID`),
  CONSTRAINT `FK__` FOREIGN KEY (`PESEX_CODIGO`) REFERENCES `pesex_sexo` (`PESEX_CODIGO`),
  CONSTRAINT `FK___` FOREIGN KEY (`PEEST_CODIGO`) REFERENCES `peest_estciv` (`PEEST_CODIGO`),
  CONSTRAINT `FK____` FOREIGN KEY (`PEDIR_CODIGO`) REFERENCES `pedir_direcc` (`PEDIR_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peemp_empleado`
--

LOCK TABLES `peemp_empleado` WRITE;
/*!40000 ALTER TABLE `peemp_empleado` DISABLE KEYS */;
INSERT INTO `peemp_empleado` VALUES ('1','1','1','1','1','1314021823','Jonathan ','Espinosa','0985138017',''),('2','1','1','1','1','1303639361','Mirna ','Mieles','099999',''),('3','1','1','1','1','15151','d','d','dd','');
/*!40000 ALTER TABLE `peemp_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peest_estciv`
--

DROP TABLE IF EXISTS `peest_estciv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peest_estciv` (
  `PEEST_CODIGO` varchar(20) NOT NULL,
  `PEEST_NOMBRE` varchar(50) NOT NULL,
  PRIMARY KEY (`PEEST_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peest_estciv`
--

LOCK TABLES `peest_estciv` WRITE;
/*!40000 ALTER TABLE `peest_estciv` DISABLE KEYS */;
INSERT INTO `peest_estciv` VALUES ('1','Casado');
/*!40000 ALTER TABLE `peest_estciv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pepai_pais`
--

DROP TABLE IF EXISTS `pepai_pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pepai_pais` (
  `PEPAI_CODIGO` varchar(20) NOT NULL,
  `PEPAI_NOMBRE` varchar(30) DEFAULT NULL,
  `PEPAI_CODP_COPOST` varchar(50) NOT NULL,
  PRIMARY KEY (`PEPAI_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pepai_pais`
--

LOCK TABLES `pepai_pais` WRITE;
/*!40000 ALTER TABLE `pepai_pais` DISABLE KEYS */;
INSERT INTO `pepai_pais` VALUES ('1','Ecuador','170152');
/*!40000 ALTER TABLE `pepai_pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pepro_provin`
--

DROP TABLE IF EXISTS `pepro_provin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pepro_provin` (
  `PEPROV_CODIGO` varchar(20) NOT NULL,
  `PEPAI_CODIGO` varchar(20) NOT NULL,
  `PEPROV_NOMBRE` varchar(40) NOT NULL,
  PRIMARY KEY (`PEPROV_CODIGO`),
  KEY `FK_PERTENECE` (`PEPAI_CODIGO`),
  CONSTRAINT `FK_PERTENECE` FOREIGN KEY (`PEPAI_CODIGO`) REFERENCES `pepai_pais` (`PEPAI_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pepro_provin`
--

LOCK TABLES `pepro_provin` WRITE;
/*!40000 ALTER TABLE `pepro_provin` DISABLE KEYS */;
INSERT INTO `pepro_provin` VALUES ('1','1','Pichincha');
/*!40000 ALTER TABLE `pepro_provin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pesex_sexo`
--

DROP TABLE IF EXISTS `pesex_sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pesex_sexo` (
  `PESEX_CODIGO` char(1) NOT NULL,
  `PESEX_DESCRIPCION` varchar(50) NOT NULL,
  PRIMARY KEY (`PESEX_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pesex_sexo`
--

LOCK TABLES `pesex_sexo` WRITE;
/*!40000 ALTER TABLE `pesex_sexo` DISABLE KEYS */;
INSERT INTO `pesex_sexo` VALUES ('1','Maculino');
/*!40000 ALTER TABLE `pesex_sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seest_estado`
--

DROP TABLE IF EXISTS `seest_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seest_estado` (
  `SEEST_CODIGO` char(10) NOT NULL,
  `SEEST_DESCRIPCION` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`SEEST_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de estado, modelo l?gico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seest_estado`
--

LOCK TABLES `seest_estado` WRITE;
/*!40000 ALTER TABLE `seest_estado` DISABLE KEYS */;
INSERT INTO `seest_estado` VALUES ('1','Activo');
/*!40000 ALTER TABLE `seest_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seopc_opcion`
--

DROP TABLE IF EXISTS `seopc_opcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seopc_opcion` (
  `SEOPC_CODIGO` varchar(30) NOT NULL,
  `SESIS_CODIGO` char(10) NOT NULL,
  `SEVEN_CODIGO` char(10) NOT NULL,
  `SEOPC_NOMBRE` varchar(100) NOT NULL,
  `SEOPC_VISTA` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SEOPC_CODIGO`),
  KEY `FK_SR_SEOPC_SEVEN` (`SEVEN_CODIGO`),
  KEY `FK_XR_XESIS_XEOPC` (`SESIS_CODIGO`),
  CONSTRAINT `FK_SR_SEOPC_SEVEN` FOREIGN KEY (`SEVEN_CODIGO`) REFERENCES `seven_ventan` (`SEVEN_CODIGO`),
  CONSTRAINT `FK_XR_XESIS_XEOPC` FOREIGN KEY (`SESIS_CODIGO`) REFERENCES `sesis_sistem` (`SESIS_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de opci?n, modelo l?gico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seopc_opcion`
--

LOCK TABLES `seopc_opcion` WRITE;
/*!40000 ALTER TABLE `seopc_opcion` DISABLE KEYS */;
INSERT INTO `seopc_opcion` VALUES ('OPC01','1','VEN04','Empleado','empleado/List.xhtml'),('OPC02','1','VEN04','Cargo','cargo/List.xhtml'),('OPC03','1','VEN05','Usuario','usuario/List.xhtml'),('OPC04','1','VEN05','Perfiles','perfil/List.xhtml');
/*!40000 ALTER TABLE `seopc_opcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seopc_opcper`
--

DROP TABLE IF EXISTS `seopc_opcper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seopc_opcper` (
  `SEPER_CODIGO` char(10) NOT NULL,
  `SEOPC_CODIGO` varchar(30) NOT NULL,
  `SEOPC_FECHAASIGNACION` datetime DEFAULT NULL,
  PRIMARY KEY (`SEPER_CODIGO`,`SEOPC_CODIGO`),
  KEY `FK_OPCPER_OPCION` (`SEOPC_CODIGO`),
  CONSTRAINT `FK_OPCPER_OPCION` FOREIGN KEY (`SEOPC_CODIGO`) REFERENCES `seopc_opcion` (`SEOPC_CODIGO`),
  CONSTRAINT `FK_OPCPER_PERFIL` FOREIGN KEY (`SEPER_CODIGO`) REFERENCES `seper_perfil` (`SEPER_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seopc_opcper`
--

LOCK TABLES `seopc_opcper` WRITE;
/*!40000 ALTER TABLE `seopc_opcper` DISABLE KEYS */;
INSERT INTO `seopc_opcper` VALUES ('1','OPC01',NULL),('1','OPC02',NULL),('1','OPC03',NULL);
/*!40000 ALTER TABLE `seopc_opcper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seper_perfil`
--

DROP TABLE IF EXISTS `seper_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seper_perfil` (
  `SEPER_CODIGO` char(10) NOT NULL,
  `SEPER_NOMBRE` varchar(100) NOT NULL,
  `SEPER_DESCRIPCION` varchar(100) NOT NULL,
  PRIMARY KEY (`SEPER_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de perfil, modelo l?gico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seper_perfil`
--

LOCK TABLES `seper_perfil` WRITE;
/*!40000 ALTER TABLE `seper_perfil` DISABLE KEYS */;
INSERT INTO `seper_perfil` VALUES ('1','SuperAdministrador','Monster University,Bienes,Stock,Personal,Seguridades'),('2','Administrador','Monster University,Bienes,Stock,Personal'),('3','Académico','Monster University,Bienes,Stock'),('4','Operario','Bienes,Stock');
/*!40000 ALTER TABLE `seper_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serol_rol`
--

DROP TABLE IF EXISTS `serol_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serol_rol` (
  `SEPER_CODIGO` char(10) NOT NULL,
  `SEROL_INSERCION` char(5) NOT NULL,
  `SEROL_ACTUALIZACION` char(5) NOT NULL,
  `SEROL_ELIMINACION` char(5) NOT NULL,
  `SEROL_CONSULTA` char(5) NOT NULL,
  PRIMARY KEY (`SEPER_CODIGO`),
  CONSTRAINT `FK_SR_SEPER_SEROL` FOREIGN KEY (`SEPER_CODIGO`) REFERENCES `seper_perfil` (`SEPER_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de rol, modelo l?gico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serol_rol`
--

LOCK TABLES `serol_rol` WRITE;
/*!40000 ALTER TABLE `serol_rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `serol_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sesis_sistem`
--

DROP TABLE IF EXISTS `sesis_sistem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sesis_sistem` (
  `SESIS_CODIGO` char(10) NOT NULL,
  `SEEST_CODIGO` char(10) NOT NULL,
  `SESIS_NOMBRE` varchar(100) NOT NULL,
  PRIMARY KEY (`SESIS_CODIGO`),
  KEY `FK_XR_XEEST_XESIS` (`SEEST_CODIGO`),
  CONSTRAINT `FK_XR_XEEST_XESIS` FOREIGN KEY (`SEEST_CODIGO`) REFERENCES `seest_estado` (`SEEST_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de sistema, modelo l?gico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesis_sistem`
--

LOCK TABLES `sesis_sistem` WRITE;
/*!40000 ALTER TABLE `sesis_sistem` DISABLE KEYS */;
INSERT INTO `sesis_sistem` VALUES ('1','1','MonsterUniversity');
/*!40000 ALTER TABLE `sesis_sistem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seusu_usaper`
--

DROP TABLE IF EXISTS `seusu_usaper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seusu_usaper` (
  `SEPER_CODIGO` char(10) NOT NULL,
  `SEUSU_USUARIO` varchar(50) NOT NULL,
  `SEUSU_FECHAASIGNACION` date DEFAULT NULL,
  `SEUSU_FECHACAMBIO` date DEFAULT NULL,
  PRIMARY KEY (`SEPER_CODIGO`,`SEUSU_USUARIO`),
  KEY `FK_USUPER_USUARIO` (`SEUSU_USUARIO`),
  CONSTRAINT `FK_USUPER_PERFIL` FOREIGN KEY (`SEPER_CODIGO`) REFERENCES `seper_perfil` (`SEPER_CODIGO`),
  CONSTRAINT `FK_USUPER_USUARIO` FOREIGN KEY (`SEUSU_USUARIO`) REFERENCES `seusu_usuari` (`SEUSU_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seusu_usaper`
--

LOCK TABLES `seusu_usaper` WRITE;
/*!40000 ALTER TABLE `seusu_usaper` DISABLE KEYS */;
INSERT INTO `seusu_usaper` VALUES ('1','jeem','2019-06-09','2019-06-09');
/*!40000 ALTER TABLE `seusu_usaper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seusu_usuari`
--

DROP TABLE IF EXISTS `seusu_usuari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seusu_usuari` (
  `SEUSU_USUARIO` varchar(50) NOT NULL,
  `PEEMP_ID` varchar(100) NOT NULL,
  `SEEST_CODIGO` char(10) NOT NULL,
  `SEUSU_CONTRASENA` varchar(200) NOT NULL,
  `SEUSU_FECHACREACION` datetime NOT NULL,
  `SEUSU_FECHAULTIMOCAMBIO` datetime NOT NULL,
  PRIMARY KEY (`SEUSU_USUARIO`),
  KEY `FK_SE_PEEMP_SEUSU` (`PEEMP_ID`),
  KEY `FK_XR_XEEST_XEUSU` (`SEEST_CODIGO`),
  CONSTRAINT `FK_SE_PEEMP_SEUSU` FOREIGN KEY (`PEEMP_ID`) REFERENCES `peemp_empleado` (`PEEMP_ID`),
  CONSTRAINT `FK_XR_XEEST_XEUSU` FOREIGN KEY (`SEEST_CODIGO`) REFERENCES `seest_estado` (`SEEST_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de usuario, modelo l?gico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seusu_usuari`
--

LOCK TABLES `seusu_usuari` WRITE;
/*!40000 ALTER TABLE `seusu_usuari` DISABLE KEYS */;
INSERT INTO `seusu_usuari` VALUES ('jeem','1','1','8b2587f3b7aac7f2234d3a905715da402019e724378e1cc639b52d1ab246236376358aa76136947cd9d7be847ab9fd19e4cac7585ecf0a2eee6a17b5cb101fbb','2012-12-12 00:00:00','2012-12-12 00:00:00'),('Mirna Mieles','2','1','8b2587f3b7aac7f2234d3a905715da402019e724378e1cc639b52d1ab246236376358aa76136947cd9d7be847ab9fd19e4cac7585ecf0a2eee6a17b5cb101fbb','0012-12-12 07:12:12','0012-12-12 07:12:12'),('sad','3','1','dde480f96a194a0a35c887babf4f76f053659dffb7c21a3205d1c3cd5fefa6c306eb8eee723ff8ce1001147c271d24210463de668695eded3aa29b7ae47f2433','0012-12-12 07:12:12','0012-12-12 07:12:12');
/*!40000 ALTER TABLE `seusu_usuari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seven_venper`
--

DROP TABLE IF EXISTS `seven_venper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seven_venper` (
  `SEVEN_CODIGO` char(10) NOT NULL,
  `SEPER_CODIGO` char(10) NOT NULL,
  `SEVEN_FECHAASIGNACION` datetime DEFAULT NULL,
  PRIMARY KEY (`SEVEN_CODIGO`,`SEPER_CODIGO`),
  KEY `FK_VENPER_PERFIL` (`SEPER_CODIGO`),
  CONSTRAINT `FK_VENPER_PERFIL` FOREIGN KEY (`SEPER_CODIGO`) REFERENCES `seper_perfil` (`SEPER_CODIGO`),
  CONSTRAINT `FK_VENPER_VENTANA` FOREIGN KEY (`SEVEN_CODIGO`) REFERENCES `seven_ventan` (`SEVEN_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seven_venper`
--

LOCK TABLES `seven_venper` WRITE;
/*!40000 ALTER TABLE `seven_venper` DISABLE KEYS */;
INSERT INTO `seven_venper` VALUES ('VEN01','1',NULL),('VEN03','1',NULL),('VEN04','1',NULL),('VEN05','1',NULL);
/*!40000 ALTER TABLE `seven_venper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seven_ventan`
--

DROP TABLE IF EXISTS `seven_ventan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seven_ventan` (
  `SEVEN_CODIGO` char(10) NOT NULL,
  `SEVEN_DESCRIPCION` varchar(100) NOT NULL,
  `SEVEN_MENSAJE` varchar(100) NOT NULL,
  PRIMARY KEY (`SEVEN_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de ventana, modelo l?gico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seven_ventan`
--

LOCK TABLES `seven_ventan` WRITE;
/*!40000 ALTER TABLE `seven_ventan` DISABLE KEYS */;
INSERT INTO `seven_ventan` VALUES ('VEN01','Monster',''),('VEN02','Almacen',''),('VEN03','Compras',''),('VEN04','Personal',''),('VEN05','Seguridad','');
/*!40000 ALTER TABLE `seven_ventan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-09 15:27:36

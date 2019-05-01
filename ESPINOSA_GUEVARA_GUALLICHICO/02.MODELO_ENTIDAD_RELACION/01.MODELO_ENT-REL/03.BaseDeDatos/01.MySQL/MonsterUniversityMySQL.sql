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
  `ENT_NUMERO` int(11) NOT NULL,
  `ENT_FECHA` date DEFAULT NULL,
  `ENT_NUMEROFACTURA` int(11) DEFAULT NULL,
  `ENT_TOTALBIENES` int(11) DEFAULT NULL,
  `ENT_VALORTOTAL` float DEFAULT NULL,
  PRIMARY KEY (`ENT_NUMERO`)
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
  `BIEN_ID` int(11) NOT NULL,
  `ENT_NUMERO` int(11) NOT NULL,
  `ITEE_CANTIDADENTREGADA` int(11) DEFAULT NULL,
  PRIMARY KEY (`BIEN_ID`,`ENT_NUMERO`),
  KEY `FK_ITEM_ENTRADA_ENTRADA` (`ENT_NUMERO`),
  CONSTRAINT `FK_BIENES_ITEM_ENTRADA_ALMACEN` FOREIGN KEY (`BIEN_ID`) REFERENCES `mebie_bienes` (`BIEN_ID`),
  CONSTRAINT `FK_ITEM_ENTRADA_ENTRADA` FOREIGN KEY (`ENT_NUMERO`) REFERENCES `aeent_entalm` (`ENT_NUMERO`)
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
  `SAL_NUMERO` int(11) NOT NULL,
  `BIEN_ID` int(11) NOT NULL,
  `EMP_ID` int(11) NOT NULL,
  `ITESA_CANTIDADENTREGADA` int(11) DEFAULT NULL,
  PRIMARY KEY (`SAL_NUMERO`,`BIEN_ID`,`EMP_ID`),
  KEY `FK_BIENES_ITEM_SALIDA` (`BIEN_ID`),
  KEY `FK_ITEM_SALIDA_EMPLEADO` (`EMP_ID`),
  CONSTRAINT `FK_BIENES_ITEM_SALIDA` FOREIGN KEY (`BIEN_ID`) REFERENCES `mebie_bienes` (`BIEN_ID`),
  CONSTRAINT `FK_ITEM_SALIDA_EMPLEADO` FOREIGN KEY (`EMP_ID`) REFERENCES `peemp_empleado` (`EMP_ID`),
  CONSTRAINT `FK_SALIDA_ALMACEN_ITEM_SALIDA` FOREIGN KEY (`SAL_NUMERO`) REFERENCES `aesal_salalm` (`SAL_NUMERO`)
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
  `PRO_ID` int(11) NOT NULL,
  `PRO_RUC` int(11) DEFAULT NULL,
  `PRO_NOMBRE` varchar(100) DEFAULT NULL,
  `PRO_TELEFONO` varchar(10) DEFAULT NULL,
  `PRO_DIRECCION` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PRO_ID`)
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
  `SAL_NUMERO` int(11) NOT NULL,
  `EMP_ID` int(11) NOT NULL,
  `SAL_FECHASALIDA` date DEFAULT NULL,
  `SAL_FECHAENTREGA` date DEFAULT NULL,
  PRIMARY KEY (`SAL_NUMERO`),
  KEY `FK_SALIDA_EMPLEADO` (`EMP_ID`),
  CONSTRAINT `FK_SALIDA_EMPLEADO` FOREIGN KEY (`EMP_ID`) REFERENCES `peemp_empleado` (`EMP_ID`)
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
  `STO_ID` int(11) NOT NULL,
  `BIEN_ID` int(11) NOT NULL,
  `STO_CANTIDAD` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`STO_ID`),
  KEY `FK_BIENES_STOCK` (`BIEN_ID`),
  CONSTRAINT `FK_BIENES_STOCK` FOREIGN KEY (`BIEN_ID`) REFERENCES `mebie_bienes` (`BIEN_ID`)
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
-- Table structure for table `ceite_itesol`
--

DROP TABLE IF EXISTS `ceite_itesol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ceite_itesol` (
  `SOL_NUMERO` int(11) NOT NULL,
  `BIEN_ID` int(11) NOT NULL,
  `ITES_CANTIDADSOLICITADA` int(11) DEFAULT NULL,
  `ITES_CANTIDADDESPACHADA` int(11) DEFAULT NULL,
  `ITES_VALORTOTAL` float DEFAULT NULL,
  PRIMARY KEY (`SOL_NUMERO`,`BIEN_ID`),
  KEY `FK_BIENES_ITEM_SOLICITUD` (`BIEN_ID`),
  CONSTRAINT `FK_BIENES_ITEM_SOLICITUD` FOREIGN KEY (`BIEN_ID`) REFERENCES `mebie_bienes` (`BIEN_ID`),
  CONSTRAINT `FK_SOLICITUD_COMPRA_ITEM_SOLICITUD` FOREIGN KEY (`SOL_NUMERO`) REFERENCES `cesol_solcom` (`SOL_NUMERO`)
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
  `ORD_NUMERO` int(11) NOT NULL,
  `PRO_ID` int(11) NOT NULL,
  `ORD_FECHAORDEN` date DEFAULT NULL,
  `ORD_FECHAENTREGA` date DEFAULT NULL,
  `ORD_MONTOTOTAL` float DEFAULT NULL,
  `ORD_APROVACIONDIRECTORFINANCIERO` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ORD_NUMERO`),
  KEY `FK_ORDEN_PROVEEDOR` (`PRO_ID`),
  CONSTRAINT `FK_ORDEN_PROVEEDOR` FOREIGN KEY (`PRO_ID`) REFERENCES `aepro_proveedor` (`PRO_ID`)
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
  `RUB_CODIGO` int(11) NOT NULL,
  `RUB_CATEGORIA` varchar(100) DEFAULT NULL,
  `RUB_PRESUPUESTO` float DEFAULT NULL,
  PRIMARY KEY (`RUB_CODIGO`)
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
  `SOL_NUMERO` int(11) NOT NULL,
  `EMP_ID` int(11) NOT NULL,
  `ARE_ID` int(11) NOT NULL,
  `RUB_CODIGO` int(11) NOT NULL,
  `SOL_FECHA` date DEFAULT NULL,
  `SOL_APROBACIONDIRECTORFINANCIERO` tinyint(1) DEFAULT NULL,
  `SOL_APROBACIONJEFEAREA` tinyint(1) DEFAULT NULL,
  `SOL_TOTAL` float DEFAULT NULL,
  PRIMARY KEY (`SOL_NUMERO`),
  KEY `FK_SOLICITUD_COMPRA_AREA` (`ARE_ID`),
  KEY `FK_SOLICITUD_COMPRA_EMPLEADO` (`EMP_ID`),
  KEY `FK_SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO` (`RUB_CODIGO`),
  CONSTRAINT `FK_SOLICITUD_COMPRA_AREA` FOREIGN KEY (`ARE_ID`) REFERENCES `peare_area` (`ARE_ID`),
  CONSTRAINT `FK_SOLICITUD_COMPRA_EMPLEADO` FOREIGN KEY (`EMP_ID`) REFERENCES `peemp_empleado` (`EMP_ID`),
  CONSTRAINT `FK_SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO` FOREIGN KEY (`RUB_CODIGO`) REFERENCES `cerub_rubpre` (`RUB_CODIGO`)
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
  `BIEN_ID` int(11) NOT NULL,
  `PRO_ID` int(11) NOT NULL,
  `BIEN_NOMBRE` varchar(100) DEFAULT NULL,
  `BIEN_UNIDADMEDIDA` varchar(100) DEFAULT NULL,
  `BIEN_TIPO` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`BIEN_ID`),
  KEY `FK_PROVEEDOR_BIENES` (`PRO_ID`),
  CONSTRAINT `FK_PROVEEDOR_BIENES` FOREIGN KEY (`PRO_ID`) REFERENCES `aepro_proveedor` (`PRO_ID`)
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
-- Table structure for table `medet_detord`
--

DROP TABLE IF EXISTS `medet_detord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medet_detord` (
  `SOL_NUMERO` int(11) NOT NULL,
  `BIEN_ID` int(11) NOT NULL,
  `ORD_NUMERO` int(11) NOT NULL,
  PRIMARY KEY (`SOL_NUMERO`,`BIEN_ID`,`ORD_NUMERO`),
  KEY `FK_DETALLE_ORDEN2` (`ORD_NUMERO`),
  CONSTRAINT `FK_DETALLE_ORDEN` FOREIGN KEY (`SOL_NUMERO`, `BIEN_ID`) REFERENCES `ceite_itesol` (`SOL_NUMERO`, `BIEN_ID`),
  CONSTRAINT `FK_DETALLE_ORDEN2` FOREIGN KEY (`ORD_NUMERO`) REFERENCES `ceord_ordcon` (`ORD_NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medet_detord`
--

LOCK TABLES `medet_detord` WRITE;
/*!40000 ALTER TABLE `medet_detord` DISABLE KEYS */;
/*!40000 ALTER TABLE `medet_detord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peare_area`
--

DROP TABLE IF EXISTS `peare_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peare_area` (
  `ARE_ID` int(11) NOT NULL,
  `ARE_NOMBRE` varchar(100) DEFAULT NULL,
  `ARE_UBICACION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ARE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peare_area`
--

LOCK TABLES `peare_area` WRITE;
/*!40000 ALTER TABLE `peare_area` DISABLE KEYS */;
/*!40000 ALTER TABLE `peare_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pecar_cargo`
--

DROP TABLE IF EXISTS `pecar_cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pecar_cargo` (
  `CAR_ID` int(11) NOT NULL,
  `ARE_ID` int(11) NOT NULL,
  `CAR_NOMBRE` varchar(100) NOT NULL,
  `CAR_DETALLES` varchar(500) NOT NULL,
  PRIMARY KEY (`CAR_ID`),
  KEY `FK_CARGO_AREA` (`ARE_ID`),
  CONSTRAINT `FK_CARGO_AREA` FOREIGN KEY (`ARE_ID`) REFERENCES `peare_area` (`ARE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pecar_cargo`
--

LOCK TABLES `pecar_cargo` WRITE;
/*!40000 ALTER TABLE `pecar_cargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `pecar_cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peemp_empleado`
--

DROP TABLE IF EXISTS `peemp_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peemp_empleado` (
  `EMP_ID` int(11) NOT NULL,
  `CAR_ID` int(11) NOT NULL,
  `SEX_ID` int(11) NOT NULL,
  `EST_ID` int(11) NOT NULL,
  `EMP_CEDULA` int(11) DEFAULT NULL,
  `EMP_NOMBRE` varchar(100) DEFAULT NULL,
  `EMP_TELEFONO` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`EMP_ID`),
  KEY `FK_EMPLEADO_CARGO` (`CAR_ID`),
  KEY `FK_EMPLEADO_ESTADO_CIVIL` (`EST_ID`),
  KEY `FK_EMPLEADO_SEXO` (`SEX_ID`),
  CONSTRAINT `FK_EMPLEADO_CARGO` FOREIGN KEY (`CAR_ID`) REFERENCES `pecar_cargo` (`CAR_ID`),
  CONSTRAINT `FK_EMPLEADO_ESTADO_CIVIL` FOREIGN KEY (`EST_ID`) REFERENCES `peest_estciv` (`EST_ID`),
  CONSTRAINT `FK_EMPLEADO_SEXO` FOREIGN KEY (`SEX_ID`) REFERENCES `pesex_sexo` (`SEX_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peemp_empleado`
--

LOCK TABLES `peemp_empleado` WRITE;
/*!40000 ALTER TABLE `peemp_empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `peemp_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peest_estciv`
--

DROP TABLE IF EXISTS `peest_estciv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peest_estciv` (
  `EST_ID` int(11) NOT NULL,
  `EST_DETALLES` varchar(30) NOT NULL,
  PRIMARY KEY (`EST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peest_estciv`
--

LOCK TABLES `peest_estciv` WRITE;
/*!40000 ALTER TABLE `peest_estciv` DISABLE KEYS */;
/*!40000 ALTER TABLE `peest_estciv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pesex_sexo`
--

DROP TABLE IF EXISTS `pesex_sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pesex_sexo` (
  `SEX_ID` int(11) NOT NULL,
  `SEX_DESCRIPCION` varchar(30) NOT NULL,
  PRIMARY KEY (`SEX_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pesex_sexo`
--

LOCK TABLES `pesex_sexo` WRITE;
/*!40000 ALTER TABLE `pesex_sexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `pesex_sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seest_estado`
--

DROP TABLE IF EXISTS `seest_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seest_estado` (
  `EST_CODIGO` char(10) NOT NULL,
  `EST_DESCRIPCION` varchar(30) NOT NULL,
  PRIMARY KEY (`EST_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de estado, modelo lógico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seest_estado`
--

LOCK TABLES `seest_estado` WRITE;
/*!40000 ALTER TABLE `seest_estado` DISABLE KEYS */;
/*!40000 ALTER TABLE `seest_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seopc_opcion`
--

DROP TABLE IF EXISTS `seopc_opcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seopc_opcion` (
  `OPC_CODIGO` char(10) NOT NULL,
  `SIS_CODIGO` char(10) NOT NULL,
  `OPC_DESCRIPCION` varchar(100) NOT NULL,
  PRIMARY KEY (`OPC_CODIGO`),
  KEY `FK_XR_XESIS_XEOPC` (`SIS_CODIGO`),
  CONSTRAINT `FK_XR_XESIS_XEOPC` FOREIGN KEY (`SIS_CODIGO`) REFERENCES `sesis_sistem` (`SIS_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de opción, modelo lógico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seopc_opcion`
--

LOCK TABLES `seopc_opcion` WRITE;
/*!40000 ALTER TABLE `seopc_opcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `seopc_opcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seopc_opcper`
--

DROP TABLE IF EXISTS `seopc_opcper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seopc_opcper` (
  `PER_CODIGO` char(10) NOT NULL,
  `OPC_CODIGO` char(10) NOT NULL,
  `OPCPER_FECHAASIGNACION` datetime NOT NULL,
  `OPCPER_ESTADO` varchar(50) NOT NULL,
  PRIMARY KEY (`PER_CODIGO`,`OPC_CODIGO`),
  KEY `FK_SEOPC_OPCPER` (`OPC_CODIGO`),
  CONSTRAINT `FK_SEOPC_OPCPER` FOREIGN KEY (`OPC_CODIGO`) REFERENCES `seopc_opcion` (`OPC_CODIGO`),
  CONSTRAINT `FK_SEOPC_OPCPER2` FOREIGN KEY (`PER_CODIGO`) REFERENCES `seper_perfil` (`PER_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de opciones por perfil, modelo lógico de seguridades';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seopc_opcper`
--

LOCK TABLES `seopc_opcper` WRITE;
/*!40000 ALTER TABLE `seopc_opcper` DISABLE KEYS */;
/*!40000 ALTER TABLE `seopc_opcper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seper_perfil`
--

DROP TABLE IF EXISTS `seper_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seper_perfil` (
  `PER_CODIGO` char(10) NOT NULL,
  `PER_DESCRIPCION` varchar(100) NOT NULL,
  `PER_OBSERVACION` varchar(100) NOT NULL,
  PRIMARY KEY (`PER_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de perfil, modelo lógico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seper_perfil`
--

LOCK TABLES `seper_perfil` WRITE;
/*!40000 ALTER TABLE `seper_perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `seper_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serol_rol`
--

DROP TABLE IF EXISTS `serol_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serol_rol` (
  `PER_CODIGO` char(10) NOT NULL,
  `ROL_INSERCION` char(5) NOT NULL,
  `ROL_ACTUALIZACION` char(5) NOT NULL,
  `ROL_ELIMINACION` char(5) NOT NULL,
  `ROL_CONSULTA` char(5) NOT NULL,
  PRIMARY KEY (`PER_CODIGO`),
  CONSTRAINT `FK_XR_XEPER_XEROL` FOREIGN KEY (`PER_CODIGO`) REFERENCES `seper_perfil` (`PER_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de rol, modelo lógico de seguridades.';
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
  `SIS_CODIGO` char(10) NOT NULL,
  `EST_CODIGO` char(10) NOT NULL,
  `SIS_DESCRIPCION` varchar(100) NOT NULL,
  PRIMARY KEY (`SIS_CODIGO`),
  KEY `FK_XR_XEEST_XESIS` (`EST_CODIGO`),
  CONSTRAINT `FK_XR_XEEST_XESIS` FOREIGN KEY (`EST_CODIGO`) REFERENCES `seest_estado` (`EST_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de sistema, modelo lógico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesis_sistem`
--

LOCK TABLES `sesis_sistem` WRITE;
/*!40000 ALTER TABLE `sesis_sistem` DISABLE KEYS */;
/*!40000 ALTER TABLE `sesis_sistem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seusu_usaper`
--

DROP TABLE IF EXISTS `seusu_usaper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seusu_usaper` (
  `EMP_ID` int(11) NOT NULL,
  `PER_CODIGO` char(10) NOT NULL,
  `USUPER_FECHAASIGNACION` date NOT NULL,
  `USUPER_FECHACAMBIO` date NOT NULL,
  PRIMARY KEY (`EMP_ID`,`PER_CODIGO`),
  KEY `FK_SEUSU_USAPER` (`PER_CODIGO`),
  CONSTRAINT `FK_SEUSU_USAPER` FOREIGN KEY (`PER_CODIGO`) REFERENCES `seper_perfil` (`PER_CODIGO`),
  CONSTRAINT `FK_SEUSU_USAPER2` FOREIGN KEY (`EMP_ID`) REFERENCES `seusu_usuari` (`EMP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de usuario por perfil, modelo lógico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seusu_usaper`
--

LOCK TABLES `seusu_usaper` WRITE;
/*!40000 ALTER TABLE `seusu_usaper` DISABLE KEYS */;
/*!40000 ALTER TABLE `seusu_usaper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seusu_usuari`
--

DROP TABLE IF EXISTS `seusu_usuari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seusu_usuari` (
  `EMP_ID` int(11) NOT NULL,
  `EST_CODIGO` char(10) NOT NULL,
  `USU_CONTRASENA` varchar(200) NOT NULL,
  `USU_PIEFIRMA` varchar(100) NOT NULL,
  `USU_FECHACREACION` datetime NOT NULL,
  `USU_FECHAULTIMOCAMBIO` datetime NOT NULL,
  PRIMARY KEY (`EMP_ID`),
  KEY `FK_XR_XEEST_XEUSU` (`EST_CODIGO`),
  CONSTRAINT `FK_XE_PEEMP_XEUSU` FOREIGN KEY (`EMP_ID`) REFERENCES `peemp_empleado` (`EMP_ID`),
  CONSTRAINT `FK_XR_XEEST_XEUSU` FOREIGN KEY (`EST_CODIGO`) REFERENCES `seest_estado` (`EST_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de usuario, modelo lógico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seusu_usuari`
--

LOCK TABLES `seusu_usuari` WRITE;
/*!40000 ALTER TABLE `seusu_usuari` DISABLE KEYS */;
/*!40000 ALTER TABLE `seusu_usuari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seven_ventan`
--

DROP TABLE IF EXISTS `seven_ventan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seven_ventan` (
  `VEN_CODIGO` char(10) NOT NULL,
  `OPC_CODIGO` char(10) NOT NULL,
  `VEN_DESCRIPCION` varchar(100) NOT NULL,
  `VEN_MENSAJE` varchar(100) NOT NULL,
  PRIMARY KEY (`VEN_CODIGO`),
  KEY `FK_XR_XEOPC_XEVEN` (`OPC_CODIGO`),
  CONSTRAINT `FK_XR_XEOPC_XEVEN` FOREIGN KEY (`OPC_CODIGO`) REFERENCES `seopc_opcion` (`OPC_CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad de ventana, modelo lógico de seguridades.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seven_ventan`
--

LOCK TABLES `seven_ventan` WRITE;
/*!40000 ALTER TABLE `seven_ventan` DISABLE KEYS */;
/*!40000 ALTER TABLE `seven_ventan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'monsteruniversity'
--

--
-- Dumping routines for database 'monsteruniversity'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-21  2:33:18

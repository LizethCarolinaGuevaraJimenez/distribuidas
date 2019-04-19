/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     4/18/2019 6:54:39 PM                         */
/*==============================================================*/


drop table if exists AEENT_ENTALM;

drop table if exists AEITE_ITEENT;

drop table if exists AEITE_ITESAL;

drop table if exists AEPRO_PROVEEDOR;

drop table if exists AESAL_SALALM;

drop table if exists AESTO_STOCK;

drop table if exists CEITE_ITESOL;

drop table if exists CEORD_ORDCON;

drop table if exists CERUB_RUBPRE;

drop table if exists CESOL_SOLCOM;

drop table if exists MEBIE_BIENES;

drop table if exists MEDET_DETORD;

drop table if exists PEARE_AREA;

drop table if exists PECAR_CARGO;

drop table if exists PEEMP_EMPLEADO;

drop table if exists PEEST_ESTCIV;

drop table if exists PESEX_SEXO;

/*==============================================================*/
/* Table: AEENT_ENTALM                                          */
/*==============================================================*/
create table AEENT_ENTALM
(
   ENT_NUMERO           int not null,
   ENT_FECHA            date,
   ENT_NUMEROFACTURA    int,
   ENT_TOTALBIENES      int,
   ENT_VALORTOTAL       float,
   primary key (ENT_NUMERO)
);

/*==============================================================*/
/* Table: AEITE_ITEENT                                          */
/*==============================================================*/
create table AEITE_ITEENT
(
   BIEN_ID              int not null,
   ENT_NUMERO           int not null,
   ITEE_CANTIDADENTREGADA int,
   primary key (BIEN_ID, ENT_NUMERO)
);

/*==============================================================*/
/* Table: AEITE_ITESAL                                          */
/*==============================================================*/
create table AEITE_ITESAL
(
   SAL_NUMERO           int not null,
   BIEN_ID              int not null,
   EMP_ID               int not null,
   ITESA_CANTIDADENTREGADA int,
   primary key (SAL_NUMERO, BIEN_ID, EMP_ID)
);

/*==============================================================*/
/* Table: AEPRO_PROVEEDOR                                       */
/*==============================================================*/
create table AEPRO_PROVEEDOR
(
   PRO_ID               int not null,
   PRO_RUC              int,
   PRO_NOMBRE           varchar(100),
   PRO_TELEFONO         varchar(10),
   PRO_DIRECCION        varchar(200),
   primary key (PRO_ID)
);

/*==============================================================*/
/* Table: AESAL_SALALM                                          */
/*==============================================================*/
create table AESAL_SALALM
(
   SAL_NUMERO           int not null,
   EMP_ID               int not null,
   SAL_FECHASALIDA      date,
   SAL_FECHAENTREGA     date,
   primary key (SAL_NUMERO)
);

/*==============================================================*/
/* Table: AESTO_STOCK                                           */
/*==============================================================*/
create table AESTO_STOCK
(
   STO_ID               int not null,
   BIEN_ID              int not null,
   STO_CANTIDAD         numeric(10,2),
   primary key (STO_ID)
);

/*==============================================================*/
/* Table: CEITE_ITESOL                                          */
/*==============================================================*/
create table CEITE_ITESOL
(
   SOL_NUMERO           int not null,
   BIEN_ID              int not null,
   ITES_CANTIDADSOLICITADA int,
   ITES_CANTIDADDESPACHADA int,
   ITES_VALORTOTAL      float,
   primary key (SOL_NUMERO, BIEN_ID)
);

/*==============================================================*/
/* Table: CEORD_ORDCON                                          */
/*==============================================================*/
create table CEORD_ORDCON
(
   ORD_NUMERO           int not null,
   PRO_ID               int not null,
   ORD_FECHAORDEN       date,
   ORD_FECHAENTREGA     date,
   ORD_MONTOTOTAL       float,
   ORD_APROVACIONDIRECTORFINANCIERO bool,
   primary key (ORD_NUMERO)
);

/*==============================================================*/
/* Table: CERUB_RUBPRE                                          */
/*==============================================================*/
create table CERUB_RUBPRE
(
   RUB_CODIGO           int not null,
   RUB_CATEGORIA        varchar(100),
   RUB_PRESUPUESTO      float,
   primary key (RUB_CODIGO)
);

/*==============================================================*/
/* Table: CESOL_SOLCOM                                          */
/*==============================================================*/
create table CESOL_SOLCOM
(
   SOL_NUMERO           int not null,
   EMP_ID               int not null,
   ARE_ID               int not null,
   RUB_CODIGO           int not null,
   SOL_FECHA            date,
   SOL_APROBACIONDIRECTORFINANCIERO bool,
   SOL_APROBACIONJEFEAREA bool,
   SOL_TOTAL            float,
   primary key (SOL_NUMERO)
);

/*==============================================================*/
/* Table: MEBIE_BIENES                                          */
/*==============================================================*/
create table MEBIE_BIENES
(
   BIEN_ID              int not null,
   PRO_ID               int not null,
   BIEN_NOMBRE          varchar(100),
   BIEN_UNIDADMEDIDA    varchar(100),
   BIEN_TIPO            varchar(100),
   primary key (BIEN_ID)
);

/*==============================================================*/
/* Table: MEDET_DETORD                                          */
/*==============================================================*/
create table MEDET_DETORD
(
   SOL_NUMERO           int not null,
   BIEN_ID              int not null,
   ORD_NUMERO           int not null,
   primary key (SOL_NUMERO, BIEN_ID, ORD_NUMERO)
);

/*==============================================================*/
/* Table: PEARE_AREA                                            */
/*==============================================================*/
create table PEARE_AREA
(
   ARE_ID               int not null,
   ARE_NOMBRE           varchar(100),
   ARE_UBICACION        varchar(100),
   primary key (ARE_ID)
);

/*==============================================================*/
/* Table: PECAR_CARGO                                           */
/*==============================================================*/
create table PECAR_CARGO
(
   CAR_ID               int not null,
   ARE_ID               int not null,
   CAR_NOMBRE           varchar(100) not null,
   CAR_DETALLES         varchar(500) not null,
   primary key (CAR_ID)
);

/*==============================================================*/
/* Table: PEEMP_EMPLEADO                                        */
/*==============================================================*/
create table PEEMP_EMPLEADO
(
   EMP_ID               int not null,
   CAR_ID               int not null,
   SEX_ID               int not null,
   EST_ID               int not null,
   EMP_CEDULA           int,
   EMP_NOMBRE           varchar(100),
   EMP_TELEFONO         varchar(10),
   primary key (EMP_ID)
);

/*==============================================================*/
/* Table: PEEST_ESTCIV                                          */
/*==============================================================*/
create table PEEST_ESTCIV
(
   EST_ID               int not null,
   EST_DESCRIPCION      varchar(30) not null,
   primary key (EST_ID)
);

/*==============================================================*/
/* Table: PESEX_SEXO                                            */
/*==============================================================*/
create table PESEX_SEXO
(
   SEX_ID               int not null,
   SEX_DESCRIPCION      varchar(30) not null,
   primary key (SEX_ID)
);

alter table AEITE_ITEENT add constraint FK_BIENES_ITEM_ENTRADA_ALMACEN foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID);

alter table AEITE_ITEENT add constraint FK_ITEM_ENTRADA_ENTRADA foreign key (ENT_NUMERO)
      references AEENT_ENTALM (ENT_NUMERO);

alter table AEITE_ITESAL add constraint FK_BIENES_ITEM_SALIDA foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID);

alter table AEITE_ITESAL add constraint FK_ITEM_SALIDA_EMPLEADO foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID);

alter table AEITE_ITESAL add constraint FK_SALIDA_ALMACEN_ITEM_SALIDA foreign key (SAL_NUMERO)
      references AESAL_SALALM (SAL_NUMERO);

alter table AESAL_SALALM add constraint FK_SALIDA_EMPLEADO foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID);

alter table AESTO_STOCK add constraint FK_BIENES_STOCK foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID);

alter table CEITE_ITESOL add constraint FK_BIENES_ITEM_SOLICITUD foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID);

alter table CEITE_ITESOL add constraint FK_SOLICITUD_COMPRA_ITEM_SOLICITUD foreign key (SOL_NUMERO)
      references CESOL_SOLCOM (SOL_NUMERO);

alter table CEORD_ORDCON add constraint FK_ORDEN_PROVEEDOR foreign key (PRO_ID)
      references AEPRO_PROVEEDOR (PRO_ID);

alter table CESOL_SOLCOM add constraint FK_SOLICITUD_COMPRA_AREA foreign key (ARE_ID)
      references PEARE_AREA (ARE_ID);

alter table CESOL_SOLCOM add constraint FK_SOLICITUD_COMPRA_EMPLEADO foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID);

alter table CESOL_SOLCOM add constraint FK_SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO foreign key (RUB_CODIGO)
      references CERUB_RUBPRE (RUB_CODIGO);

alter table MEBIE_BIENES add constraint FK_PROVEEDOR_BIENES foreign key (PRO_ID)
      references AEPRO_PROVEEDOR (PRO_ID);

alter table MEDET_DETORD add constraint FK_DETALLE_ORDEN foreign key (SOL_NUMERO, BIEN_ID)
      references CEITE_ITESOL (SOL_NUMERO, BIEN_ID);

alter table MEDET_DETORD add constraint FK_DETALLE_ORDEN2 foreign key (ORD_NUMERO)
      references CEORD_ORDCON (ORD_NUMERO);

alter table PECAR_CARGO add constraint FK_CARGO_AREA foreign key (ARE_ID)
      references PEARE_AREA (ARE_ID);

alter table PEEMP_EMPLEADO add constraint FK_EMPLEADO_CARGO foreign key (CAR_ID)
      references PECAR_CARGO (CAR_ID);

alter table PEEMP_EMPLEADO add constraint FK_EMPLEADO_ESTADO_CIVIL foreign key (EST_ID)
      references PEEST_ESTCIV (EST_ID);

alter table PEEMP_EMPLEADO add constraint FK_EMPLEADO_SEXO foreign key (SEX_ID)
      references PESEX_SEXO (SEX_ID);


/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     4/20/2019 1:22:14 AM                         */
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

drop table if exists SEEST_ESTADO;

drop table if exists SEOPC_OPCION;

drop table if exists SEOPC_OPCPER;

drop table if exists SEPER_PERFIL;

drop table if exists SEROL_ROL;

drop table if exists SESIS_SISTEM;

drop table if exists SEUSU_USAPER;

drop table if exists SEUSU_USUARI;

drop table if exists SEVEN_VENTAN;

/*==============================================================*/
/* Table: ENTRADA AL ALMACEN                                    */
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
/* Table: ITEM DE ENTRADA                                       */
/*==============================================================*/
create table AEITE_ITEENT
(
   BIEN_ID              int not null,
   ENT_NUMERO           int not null,
   ITEE_CANTIDADENTREGADA int,
   primary key (BIEN_ID, ENT_NUMERO)
);

/*==============================================================*/
/* Table: ITEM DE SALIDA                                        */
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
/* Table: PROVEEDOR                                             */
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
/* Table: SALIDA DEL ALMACEN                                    */
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
/* Table: STOCK                                                 */
/*==============================================================*/
create table AESTO_STOCK
(
   STO_ID               int not null,
   BIEN_ID              int not null,
   STO_CANTIDAD         numeric(10,2),
   primary key (STO_ID)
);

/*==============================================================*/
/* Table: ITEM DE SOLICITUD                                     */
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
/* Table: ORDEN CONTRACTUAL                                     */
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
/* Table: RUBRO PRESUPUESTARIO                                  */
/*==============================================================*/
create table CERUB_RUBPRE
(
   RUB_CODIGO           int not null,
   RUB_CATEGORIA        varchar(100),
   RUB_PRESUPUESTO      float,
   primary key (RUB_CODIGO)
);

/*==============================================================*/
/* Table: SOLICITUD DE COMPRA                                   */
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
/* Table: BIENES                                                */
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
/* Table: DETALLE DE ORDEN                                      */
/*==============================================================*/
create table MEDET_DETORD
(
   SOL_NUMERO           int not null,
   BIEN_ID              int not null,
   ORD_NUMERO           int not null,
   primary key (SOL_NUMERO, BIEN_ID, ORD_NUMERO)
);

/*==============================================================*/
/* Table: AREA                                                  */
/*==============================================================*/
create table PEARE_AREA
(
   ARE_ID               int not null,
   ARE_NOMBRE           varchar(100),
   ARE_UBICACION        varchar(100),
   primary key (ARE_ID)
);

/*==============================================================*/
/* Table: CARGO                                                 */
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
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table PEEMP_EMPLEADO
(
   EMP_ID               int not null,
   CAR_ID               int not null, 
   EMP_CEDULA           int,
   EMP_NOMBRE           varchar(100),
   EMP_TELEFONO         varchar(10),
   primary key (EMP_ID)
); 

/*==============================================================*/
/* Table: ESTADO                                                */
/*==============================================================*/
create table SEEST_ESTADO
(
   EST_CODIGO           char(10) not null,
   primary key (EST_CODIGO)
);

alter table SEEST_ESTADO comment 'Entidad de estado, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: OPCION                                                */
/*==============================================================*/
create table SEOPC_OPCION
(
   OPC_CODIGO           char(10) not null,
   SIS_CODIGO           char(10) not null,
   OPC_DESCRIPCION      varchar(100) not null,
   primary key (OPC_CODIGO)
);

alter table SEOPC_OPCION comment 'Entidad de opción, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: OPCION PERFIL                                         */
/*==============================================================*/
create table SEOPC_OPCPER
(
   PER_CODIGO           char(10) not null,
   OPC_CODIGO           char(10) not null,
   OPCPER_FECHAASIGNACION datetime not null,
   OPCPER_ESTADO        varchar(50) not null,
   primary key (PER_CODIGO, OPC_CODIGO)
);

alter table SEOPC_OPCPER comment 'Entidad de opciones por perfil, modelo lógico de seguridades';

/*==============================================================*/
/* Table: PERFIL                                                */
/*==============================================================*/
create table SEPER_PERFIL
(
   PER_CODIGO           char(10) not null,
   PER_DESCRIPCION      varchar(100) not null,
   PER_OBSERVACION      varchar(100) not null,
   primary key (PER_CODIGO)
);

alter table SEPER_PERFIL comment 'Entidad de perfil, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: ROL                                                   */
/*==============================================================*/
create table SEROL_ROL
(
   PER_CODIGO           char(10) not null,
   ROL_INSERCION        char(5) not null,
   ROL_ACTUALIZACION    char(5) not null,
   ROL_ELIMINACION      char(5) not null,
   ROL_CONSULTA         char(5) not null,
   primary key (PER_CODIGO)
);

alter table SEROL_ROL comment 'Entidad de rol, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: SISTEMA                                               */
/*==============================================================*/
create table SESIS_SISTEM
(
   SIS_CODIGO           char(10) not null,
   EST_CODIGO           char(10) not null,
   SIS_DESCRIPCION      varchar(100) not null,
   primary key (SIS_CODIGO)
);

alter table SESIS_SISTEM comment 'Entidad de sistema, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: USARIO PERFIL                                         */
/*==============================================================*/
create table SEUSU_USAPER
(
   EMP_ID               int not null,
   PER_CODIGO           char(10) not null,
   USUPER_FECHAASIGNACION date not null,
   USUPER_FECHACAMBIO   date not null,
   primary key (EMP_ID, PER_CODIGO)
);

alter table SEUSU_USAPER comment 'Entidad de usuario por perfil, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table SEUSU_USUARI
(
   EMP_ID               int not null,
   EST_CODIGO           char(10) not null,
   USU_CONTRASENA       varchar(200) not null,
   USU_PIEFIRMA         varchar(100) not null,
   USU_FECHACREACION    datetime not null,
   USU_FECHAULTIMOCAMBIO datetime not null,
   primary key (EMP_ID)
);

alter table SEUSU_USUARI comment 'Entidad de usuario, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: VENTANA                                               */
/*==============================================================*/
create table SEVEN_VENTAN
(
   VEN_CODIGO           char(10) not null,
   OPC_CODIGO           char(10) not null,
   VEN_DESCRIPCION      varchar(100) not null,
   VEN_MENSAJE          varchar(100) not null,
   primary key (VEN_CODIGO)
);

alter table SEVEN_VENTAN comment 'Entidad de ventana, modelo lógico de seguridades.';

alter table AEITE_ITEENT add constraint FK_BIENES_ITEM_ENTRADA_ALMACEN foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID) on delete restrict on update restrict;

alter table AEITE_ITEENT add constraint FK_ITEM_ENTRADA_ENTRADA foreign key (ENT_NUMERO)
      references AEENT_ENTALM (ENT_NUMERO) on delete restrict on update restrict;

alter table AEITE_ITESAL add constraint FK_BIENES_ITEM_SALIDA foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID) on delete restrict on update restrict;

alter table AEITE_ITESAL add constraint FK_ITEM_SALIDA_EMPLEADO foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID) on delete restrict on update restrict;

alter table AEITE_ITESAL add constraint FK_SALIDA_ALMACEN_ITEM_SALIDA foreign key (SAL_NUMERO)
      references AESAL_SALALM (SAL_NUMERO) on delete restrict on update restrict;

alter table AESAL_SALALM add constraint FK_SALIDA_EMPLEADO foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID) on delete restrict on update restrict;

alter table AESTO_STOCK add constraint FK_BIENES_STOCK foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID) on delete restrict on update restrict;

alter table CEITE_ITESOL add constraint FK_BIENES_ITEM_SOLICITUD foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID) on delete restrict on update restrict;

alter table CEITE_ITESOL add constraint FK_SOLICITUD_COMPRA_ITEM_SOLICITUD foreign key (SOL_NUMERO)
      references CESOL_SOLCOM (SOL_NUMERO) on delete restrict on update restrict;

alter table CEORD_ORDCON add constraint FK_ORDEN_PROVEEDOR foreign key (PRO_ID)
      references AEPRO_PROVEEDOR (PRO_ID) on delete restrict on update restrict;

alter table CESOL_SOLCOM add constraint FK_SOLICITUD_COMPRA_AREA foreign key (ARE_ID)
      references PEARE_AREA (ARE_ID) on delete restrict on update restrict;

alter table CESOL_SOLCOM add constraint FK_SOLICITUD_COMPRA_EMPLEADO foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID) on delete restrict on update restrict;

alter table CESOL_SOLCOM add constraint FK_SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO foreign key (RUB_CODIGO)
      references CERUB_RUBPRE (RUB_CODIGO) on delete restrict on update restrict;

alter table MEBIE_BIENES add constraint FK_PROVEEDOR_BIENES foreign key (PRO_ID)
      references AEPRO_PROVEEDOR (PRO_ID) on delete restrict on update restrict;

alter table MEDET_DETORD add constraint FK_DETALLE_ORDEN foreign key (SOL_NUMERO, BIEN_ID)
      references CEITE_ITESOL (SOL_NUMERO, BIEN_ID) on delete restrict on update restrict;

alter table MEDET_DETORD add constraint FK_DETALLE_ORDEN2 foreign key (ORD_NUMERO)
      references CEORD_ORDCON (ORD_NUMERO) on delete restrict on update restrict;

alter table PECAR_CARGO add constraint FK_CARGO_AREA foreign key (ARE_ID)
      references PEARE_AREA (ARE_ID) on delete restrict on update restrict;

alter table PEEMP_EMPLEADO add constraint FK_EMPLEADO_CARGO foreign key (CAR_ID)
      references PECAR_CARGO (CAR_ID) on delete restrict on update restrict; 
  
alter table SEOPC_OPCION add constraint FK_XR_XESIS_XEOPC foreign key (SIS_CODIGO)
      references SESIS_SISTEM (SIS_CODIGO) on delete restrict on update restrict;

alter table SEOPC_OPCPER add constraint FK_SEOPC_OPCPER foreign key (OPC_CODIGO)
      references SEOPC_OPCION (OPC_CODIGO) on delete restrict on update restrict;

alter table SEOPC_OPCPER add constraint FK_SEOPC_OPCPER2 foreign key (PER_CODIGO)
      references SEPER_PERFIL (PER_CODIGO) on delete restrict on update restrict;

alter table SEROL_ROL add constraint FK_XR_XEPER_XEROL foreign key (PER_CODIGO)
      references SEPER_PERFIL (PER_CODIGO) on delete restrict on update restrict;

alter table SESIS_SISTEM add constraint FK_XR_XEEST_XESIS foreign key (EST_CODIGO)
      references SEEST_ESTADO (EST_CODIGO) on delete restrict on update restrict;

alter table SEUSU_USAPER add constraint FK_SEUSU_USAPER foreign key (PER_CODIGO)
      references SEPER_PERFIL (PER_CODIGO) on delete restrict on update restrict;

alter table SEUSU_USAPER add constraint FK_SEUSU_USAPER2 foreign key (EMP_ID)
      references SEUSU_USUARI (EMP_ID) on delete restrict on update restrict;

alter table SEUSU_USUARI add constraint FK_XE_PEEMP_XEUSU foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID) on delete restrict on update restrict;

alter table SEUSU_USUARI add constraint FK_XR_XEEST_XEUSU foreign key (EST_CODIGO)
      references SEEST_ESTADO (EST_CODIGO) on delete restrict on update restrict;

alter table SEVEN_VENTAN add constraint FK_XR_XEOPC_XEVEN foreign key (OPC_CODIGO)
      references SEOPC_OPCION (OPC_CODIGO) on delete restrict on update restrict;


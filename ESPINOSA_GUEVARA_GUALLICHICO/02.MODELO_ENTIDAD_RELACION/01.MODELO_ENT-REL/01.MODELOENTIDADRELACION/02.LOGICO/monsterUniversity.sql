/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     6/9/2019 3:11:39 AM                          */
/*==============================================================*/


drop table if exists AEENT_ENTALM;

drop table if exists AEITE_ITEENT;

drop table if exists AEITE_ITESAL;

drop table if exists AEPRO_PROVEEDOR;

drop table if exists AESAL_SALALM;

drop table if exists AESTO_STOCK;

drop table if exists CEDET_DETORD;

drop table if exists CEITE_ITESOL;

drop table if exists CEORD_ORDCON;

drop table if exists CERUB_RUBPRE;

drop table if exists CESOL_SOLCOM;

drop table if exists CIUDAD;

drop table if exists MEBIE_BIENES;

drop table if exists PAIS;

drop table if exists PEARE_AREA;

drop table if exists PECAR_CARGO;

drop table if exists PEDIR_DIRECC;

drop table if exists PEEMP_EMPLEADO;

drop table if exists PEEST_ESTCIV;

drop table if exists PEPRO_PROVIN;

drop table if exists PESEX_SEXO;

drop table if exists SEEST_ESTADO;

drop table if exists SEOPC_OPCION;

drop table if exists SEOPC_OPCPER;

drop table if exists SEPER_PERFIL;

drop table if exists SEROL_ROL;

drop table if exists SESIS_SISTEM;

drop table if exists SEUSU_USAPER;

drop table if exists SEUSU_USUARI;

drop table if exists SEVEN_VENPER;

drop table if exists SEVEN_VENTAN;

/*==============================================================*/
/* Table: AEENT_ENTALM                                          */
/*==============================================================*/
create table AEENT_ENTALM
(
   AEENT_NUMERO         varchar(100) not null,
   AEENT_FECHA          date,
   AEENT_NUMFACTURA     varchar(100),
   AEENT_TOTALBIENES    int,
   AEENT_VALORTOT       float,
   primary key (AEENT_NUMERO)
);

/*==============================================================*/
/* Table: AEITE_ITEENT                                          */
/*==============================================================*/
create table AEITE_ITEENT
(
   AEENT_NUMERO         varchar(100) not null,
   MEBIE_ID             varchar(100) not null,
   AEITE_CANTENTREGA    int,
   primary key (AEENT_NUMERO, MEBIE_ID)
);

/*==============================================================*/
/* Table: AEITE_ITESAL                                          */
/*==============================================================*/
create table AEITE_ITESAL
(
   PEEMP_ID             varchar(100) not null,
   AESAL_NUMERO         varchar(100) not null,
   MEBIE_ID             varchar(100) not null,
   AEITE_CANTIENTR      int,
   primary key (PEEMP_ID, AESAL_NUMERO, MEBIE_ID)
);

/*==============================================================*/
/* Table: AEPRO_PROVEEDOR                                       */
/*==============================================================*/
create table AEPRO_PROVEEDOR
(
   AEPRO_ID             varchar(100) not null,
   AEPRO_RUC            varchar(100),
   AEPRO_NOMBRE         varchar(100),
   AEPRO_TELEFONO       varchar(15),
   AEPRO_DIRECCION      varchar(200),
   primary key (AEPRO_ID)
);

/*==============================================================*/
/* Table: AESAL_SALALM                                          */
/*==============================================================*/
create table AESAL_SALALM
(
   AESAL_NUMERO         varchar(100) not null,
   PEEMP_ID             varchar(100) not null,
   AESAL_FESALIDA       date,
   AESAL_FEENTREGA      date,
   primary key (AESAL_NUMERO)
);

/*==============================================================*/
/* Table: AESTO_STOCK                                           */
/*==============================================================*/
create table AESTO_STOCK
(
   AESTO_ID             varchar(100) not null,
   MEBIE_ID             varchar(100) not null,
   AESTO_CANTIDAD       numeric(10,2),
   primary key (AESTO_ID)
);

/*==============================================================*/
/* Table: CEDET_DETORD                                          */
/*==============================================================*/
create table CEDET_DETORD
(
   CEORD_NUMERO         varchar(100) not null,
   CESOL_NUMERO         varchar(100) not null,
   MEBIE_ID             varchar(100) not null,
   CEDET_FIRMA          varchar(50),
   primary key (CEORD_NUMERO, CESOL_NUMERO, MEBIE_ID)
);

/*==============================================================*/
/* Table: CEITE_ITESOL                                          */
/*==============================================================*/
create table CEITE_ITESOL
(
   CESOL_NUMERO         varchar(100) not null,
   MEBIE_ID             varchar(100) not null,
   CEITE_CANTIDADSALIDA int,
   CEITE_CANTIDADDESPACHADA int,
   CEITE_VALORTOTAL     float,
   primary key (CESOL_NUMERO, MEBIE_ID)
);

/*==============================================================*/
/* Table: CEORD_ORDCON                                          */
/*==============================================================*/
create table CEORD_ORDCON
(
   CEORD_NUMERO         varchar(100) not null,
   AEPRO_ID             varchar(100) not null,
   CEORD_FECHAORD       date,
   CEORD_FECHENTREGA    date,
   CEORD_MONTOTAL       float,
   CEORD_APROBDIRFINANCIERO bool,
   primary key (CEORD_NUMERO)
);

/*==============================================================*/
/* Table: CERUB_RUBPRE                                          */
/*==============================================================*/
create table CERUB_RUBPRE
(
   CERUB_CODIGO         varchar(100) not null,
   CERUB_CATEGORIA      varchar(100),
   CERUB_PRESUPUESTO    float,
   primary key (CERUB_CODIGO)
);

/*==============================================================*/
/* Table: CESOL_SOLCOM                                          */
/*==============================================================*/
create table CESOL_SOLCOM
(
   CESOL_NUMERO         varchar(100) not null,
   PEEMP_ID             varchar(100) not null,
   PEARE_ID             varchar(100) not null,
   CERUB_CODIGO         varchar(100) not null,
   CESOL_FECHA          date,
   CESOL_APROVDIREFINANCIER bool,
   CESOL_APROJEFEAREA   bool,
   CESOL_TOTAL          float,
   primary key (CESOL_NUMERO)
);

/*==============================================================*/
/* Table: CIUDAD                                                */
/*==============================================================*/
create table CIUDAD
(
   PECIU_CODIGO         varchar(20) not null,
   PEPROV_CODIGO        varchar(20) not null,
   PECIU_NOMBRE         varchar(50) not null,
   primary key (PECIU_CODIGO)
);

/*==============================================================*/
/* Table: MEBIE_BIENES                                          */
/*==============================================================*/
create table MEBIE_BIENES
(
   MEBIE_ID             varchar(100) not null,
   AEPRO_ID             varchar(100) not null,
   MEBIE_NOMBRE         varchar(100),
   MEBIE_UMEDIDA        varchar(100),
   MEBIE_TIPO           varchar(100),
   primary key (MEBIE_ID)
);

/*==============================================================*/
/* Table: PAIS                                                  */
/*==============================================================*/
create table PAIS
(
   PEPAI_CODIGO         varchar(20) not null,
   PEPAI_NOMBRE         varchar(30),
   PEPAI_CODP_COPOST    varchar(50) not null,
   primary key (PEPAI_CODIGO)
);

/*==============================================================*/
/* Table: PEARE_AREA                                            */
/*==============================================================*/
create table PEARE_AREA
(
   PEARE_ID             varchar(100) not null,
   PEARE_NOMBRE         varchar(100),
   PEARE_UBICACION      varchar(100),
   primary key (PEARE_ID)
);

/*==============================================================*/
/* Table: PECAR_CARGO                                           */
/*==============================================================*/
create table PECAR_CARGO
(
   PECAR_ID             varchar(100) not null,
   PEARE_ID             varchar(100) not null,
   PECAR_NOMBRE         varchar(100) not null,
   PECAR_DETALLE        varchar(500) not null,
   primary key (PECAR_ID)
);

/*==============================================================*/
/* Table: PEDIR_DIRECC                                          */
/*==============================================================*/
create table PEDIR_DIRECC
(
   PEDIR_CODIGO         varchar(20) not null,
   PECIU_CODIGO         varchar(20) not null,
   PEDIR_NCASA          varchar(10),
   PEDIR_CALLEP         varchar(50),
   PEDIR_CALLES         varchar(50),
   PEDIR_REFERENCIA     varchar(50),
   primary key (PEDIR_CODIGO)
);

/*==============================================================*/
/* Table: PEEMP_EMPLEADO                                        */
/*==============================================================*/
create table PEEMP_EMPLEADO
(
   PEEMP_ID             varchar(100) not null,
   PECAR_ID             varchar(100) not null,
   PESEX_CODIGO         char(1) not null,
   PEEST_CODIGO         varchar(20) not null,
   PEDIR_CODIGO         varchar(20) not null,
   PEEMP_CEDULA         varchar(15),
   PEEMP_NOMRES         varchar(100),
   PEEMP_APELLIDOS      varchar(100),
   PEEMP_TELEFONO       varchar(10),
   PEEMP_CORREO         varchar(30) not null,
   primary key (PEEMP_ID)
);

/*==============================================================*/
/* Table: PEEST_ESTCIV                                          */
/*==============================================================*/
create table PEEST_ESTCIV
(
   PEEST_CODIGO         varchar(20) not null,
   PEEST_NOMBRE         varchar(50) not null,
   primary key (PEEST_CODIGO)
);

/*==============================================================*/
/* Table: PEPRO_PROVIN                                          */
/*==============================================================*/
create table PEPRO_PROVIN
(
   PEPROV_CODIGO        varchar(20) not null,
   PEPAI_CODIGO         varchar(20) not null,
   PEPROV_NOMBRE        varchar(40) not null,
   primary key (PEPROV_CODIGO)
);

/*==============================================================*/
/* Table: PESEX_SEXO                                            */
/*==============================================================*/
create table PESEX_SEXO
(
   PESEX_CODIGO         char(1) not null,
   PESEX_DESCRIPCION    varchar(50) not null,
   primary key (PESEX_CODIGO)
);

/*==============================================================*/
/* Table: SEEST_ESTADO                                          */
/*==============================================================*/
create table SEEST_ESTADO
(
   SEEST_CODIGO         char(10) not null,
   SEEST_DESCRIPCION    varchar(30),
   primary key (SEEST_CODIGO)
);

alter table SEEST_ESTADO comment 'Entidad de estado, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: SEOPC_OPCION                                          */
/*==============================================================*/
create table SEOPC_OPCION
(
   SEOPC_CODIGO         varchar(30) not null,
   SESIS_CODIGO         char(10) not null,
   SEVEN_CODIGO         char(10) not null,
   SEOPC_NOMBRE         varchar(100) not null,
   SEOPC_VISTA          varchar(50),
   primary key (SEOPC_CODIGO)
);

alter table SEOPC_OPCION comment 'Entidad de opción, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: SEOPC_OPCPER                                          */
/*==============================================================*/
create table SEOPC_OPCPER
(
   SEPER_CODIGO         char(10) not null,
   SEOPC_CODIGO         varchar(30) not null,
   SEOPC_FECHAASIGNACION datetime,
   primary key (SEPER_CODIGO, SEOPC_CODIGO)
);

/*==============================================================*/
/* Table: SEPER_PERFIL                                          */
/*==============================================================*/
create table SEPER_PERFIL
(
   SEPER_CODIGO         char(10) not null,
   SEPER_NOMBRE         varchar(100) not null,
   SEPER_DESCRIPCION    varchar(100) not null,
   primary key (SEPER_CODIGO)
);

alter table SEPER_PERFIL comment 'Entidad de perfil, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: SEROL_ROL                                             */
/*==============================================================*/
create table SEROL_ROL
(
   SEPER_CODIGO         char(10) not null,
   SEROL_INSERCION      char(5) not null,
   SEROL_ACTUALIZACION  char(5) not null,
   SEROL_ELIMINACION    char(5) not null,
   SEROL_CONSULTA       char(5) not null,
   primary key (SEPER_CODIGO)
);

alter table SEROL_ROL comment 'Entidad de rol, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: SESIS_SISTEM                                          */
/*==============================================================*/
create table SESIS_SISTEM
(
   SESIS_CODIGO         char(10) not null,
   SEEST_CODIGO         char(10) not null,
   SESIS_NOMBRE         varchar(100) not null,
   primary key (SESIS_CODIGO)
);

alter table SESIS_SISTEM comment 'Entidad de sistema, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: SEUSU_USAPER                                          */
/*==============================================================*/
create table SEUSU_USAPER
(
   SEPER_CODIGO         char(10) not null,
   SEUSU_USUARIO        varchar(50) not null,
   SEUSU_FECHAASIGNACION date,
   SEUSU_FECHACAMBIO    date,
   primary key (SEPER_CODIGO, SEUSU_USUARIO)
);

/*==============================================================*/
/* Table: SEUSU_USUARI                                          */
/*==============================================================*/
create table SEUSU_USUARI
(
   SEUSU_USUARIO        varchar(50) not null,
   PEEMP_ID             varchar(100) not null,
   SEEST_CODIGO         char(10) not null,
   SEUSU_CONTRASENA     varchar(200) not null,
   SEUSU_FECHACREACION  datetime not null,
   SEUSU_FECHAULTIMOCAMBIO datetime not null,
   primary key (SEUSU_USUARIO)
);

alter table SEUSU_USUARI comment 'Entidad de usuario, modelo lógico de seguridades.';

/*==============================================================*/
/* Table: SEVEN_VENPER                                          */
/*==============================================================*/
create table SEVEN_VENPER
(
   SEVEN_CODIGO         char(10) not null,
   SEPER_CODIGO         char(10) not null,
   SEVEN_FECHAASIGNACION datetime,
   primary key (SEVEN_CODIGO, SEPER_CODIGO)
);

/*==============================================================*/
/* Table: SEVEN_VENTAN                                          */
/*==============================================================*/
create table SEVEN_VENTAN
(
   SEVEN_CODIGO         char(10) not null,
   SEVEN_DESCRIPCION    varchar(100) not null,
   SEVEN_MENSAJE        varchar(100) not null,
   primary key (SEVEN_CODIGO)
);

alter table SEVEN_VENTAN comment 'Entidad de ventana, modelo lógico de seguridades.';

alter table AEITE_ITEENT add constraint FK_BIENES_ITEM_ENTRADA foreign key (MEBIE_ID)
      references MEBIE_BIENES (MEBIE_ID) on delete restrict on update restrict;

alter table AEITE_ITEENT add constraint FK_ITEM_ENTRADA_ENTRADA foreign key (AEENT_NUMERO)
      references AEENT_ENTALM (AEENT_NUMERO) on delete restrict on update restrict;

alter table AEITE_ITESAL add constraint FK_BIENES_ITEM_SALIDA foreign key (MEBIE_ID)
      references MEBIE_BIENES (MEBIE_ID) on delete restrict on update restrict;

alter table AEITE_ITESAL add constraint FK_ITEM_SALIDA_EMPLEADO foreign key (PEEMP_ID)
      references PEEMP_EMPLEADO (PEEMP_ID) on delete restrict on update restrict;

alter table AEITE_ITESAL add constraint FK_SALIDA_ALMACEN_ITEM_SALIDA foreign key (AESAL_NUMERO)
      references AESAL_SALALM (AESAL_NUMERO) on delete restrict on update restrict;

alter table AESAL_SALALM add constraint FK_SALIDA_EMPLEADO foreign key (PEEMP_ID)
      references PEEMP_EMPLEADO (PEEMP_ID) on delete restrict on update restrict;

alter table AESTO_STOCK add constraint FK_BIENES_STOCK foreign key (MEBIE_ID)
      references MEBIE_BIENES (MEBIE_ID) on delete restrict on update restrict;

alter table CEDET_DETORD add constraint FK_DETORD_ITEMSOL foreign key (CESOL_NUMERO, MEBIE_ID)
      references CEITE_ITESOL (CESOL_NUMERO, MEBIE_ID) on delete restrict on update restrict;

alter table CEDET_DETORD add constraint FK_DETORD_ORDCON foreign key (CEORD_NUMERO)
      references CEORD_ORDCON (CEORD_NUMERO) on delete restrict on update restrict;

alter table CEITE_ITESOL add constraint FK_BIENES_ITEM_SOLICITUD foreign key (MEBIE_ID)
      references MEBIE_BIENES (MEBIE_ID) on delete restrict on update restrict;

alter table CEITE_ITESOL add constraint FK_SOLICITUD_COMPRA_ITEM_SOLICITUD foreign key (CESOL_NUMERO)
      references CESOL_SOLCOM (CESOL_NUMERO) on delete restrict on update restrict;

alter table CEORD_ORDCON add constraint FK_ORDEN_PROVEEDOR foreign key (AEPRO_ID)
      references AEPRO_PROVEEDOR (AEPRO_ID) on delete restrict on update restrict;

alter table CESOL_SOLCOM add constraint FK_SOLICITUD_COMPRA_AREA foreign key (PEARE_ID)
      references PEARE_AREA (PEARE_ID) on delete restrict on update restrict;

alter table CESOL_SOLCOM add constraint FK_SOLICITUD_COMPRA_EMPLEADO foreign key (PEEMP_ID)
      references PEEMP_EMPLEADO (PEEMP_ID) on delete restrict on update restrict;

alter table CESOL_SOLCOM add constraint FK_SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO foreign key (CERUB_CODIGO)
      references CERUB_RUBPRE (CERUB_CODIGO) on delete restrict on update restrict;

alter table CIUDAD add constraint FK_TIENE foreign key (PEPROV_CODIGO)
      references PEPRO_PROVIN (PEPROV_CODIGO) on delete restrict on update restrict;

alter table MEBIE_BIENES add constraint FK_PROVEEDOR_BIENES foreign key (AEPRO_ID)
      references AEPRO_PROVEEDOR (AEPRO_ID) on delete restrict on update restrict;

alter table PECAR_CARGO add constraint FK_CARGO_AREA foreign key (PEARE_ID)
      references PEARE_AREA (PEARE_ID) on delete restrict on update restrict;

alter table PEDIR_DIRECC add constraint FK_ESTA foreign key (PECIU_CODIGO)
      references CIUDAD (PECIU_CODIGO) on delete restrict on update restrict;

alter table PEEMP_EMPLEADO add constraint FK_EMPLEADO_CARGO foreign key (PECAR_ID)
      references PECAR_CARGO (PECAR_ID) on delete restrict on update restrict;

alter table PEEMP_EMPLEADO add constraint FK__ foreign key (PESEX_CODIGO)
      references PESEX_SEXO (PESEX_CODIGO) on delete restrict on update restrict;

alter table PEEMP_EMPLEADO add constraint FK___ foreign key (PEEST_CODIGO)
      references PEEST_ESTCIV (PEEST_CODIGO) on delete restrict on update restrict;

alter table PEEMP_EMPLEADO add constraint FK____ foreign key (PEDIR_CODIGO)
      references PEDIR_DIRECC (PEDIR_CODIGO) on delete restrict on update restrict;

alter table PEPRO_PROVIN add constraint FK_PERTENECE foreign key (PEPAI_CODIGO)
      references PAIS (PEPAI_CODIGO) on delete restrict on update restrict;

alter table SEOPC_OPCION add constraint FK_SR_SEOPC_SEVEN foreign key (SEVEN_CODIGO)
      references SEVEN_VENTAN (SEVEN_CODIGO) on delete restrict on update restrict;

alter table SEOPC_OPCION add constraint FK_XR_XESIS_XEOPC foreign key (SESIS_CODIGO)
      references SESIS_SISTEM (SESIS_CODIGO) on delete restrict on update restrict;

alter table SEOPC_OPCPER add constraint FK_OPCPER_OPCION foreign key (SEOPC_CODIGO)
      references SEOPC_OPCION (SEOPC_CODIGO) on delete restrict on update restrict;

alter table SEOPC_OPCPER add constraint FK_OPCPER_PERFIL foreign key (SEPER_CODIGO)
      references SEPER_PERFIL (SEPER_CODIGO) on delete restrict on update restrict;

alter table SEROL_ROL add constraint FK_SR_SEPER_SEROL foreign key (SEPER_CODIGO)
      references SEPER_PERFIL (SEPER_CODIGO) on delete restrict on update restrict;

alter table SESIS_SISTEM add constraint FK_XR_XEEST_XESIS foreign key (SEEST_CODIGO)
      references SEEST_ESTADO (SEEST_CODIGO) on delete restrict on update restrict;

alter table SEUSU_USAPER add constraint FK_USUPER_PERFIL foreign key (SEPER_CODIGO)
      references SEPER_PERFIL (SEPER_CODIGO) on delete restrict on update restrict;

alter table SEUSU_USAPER add constraint FK_USUPER_USUARIO foreign key (SEUSU_USUARIO)
      references SEUSU_USUARI (SEUSU_USUARIO) on delete restrict on update restrict;

alter table SEUSU_USUARI add constraint FK_SE_PEEMP_SEUSU foreign key (PEEMP_ID)
      references PEEMP_EMPLEADO (PEEMP_ID) on delete restrict on update restrict;

alter table SEUSU_USUARI add constraint FK_XR_XEEST_XEUSU foreign key (SEEST_CODIGO)
      references SEEST_ESTADO (SEEST_CODIGO) on delete restrict on update restrict;

alter table SEVEN_VENPER add constraint FK_VENPER_PERFIL foreign key (SEPER_CODIGO)
      references SEPER_PERFIL (SEPER_CODIGO) on delete restrict on update restrict;

alter table SEVEN_VENPER add constraint FK_VENPER_VENTANA foreign key (SEVEN_CODIGO)
      references SEVEN_VENTAN (SEVEN_CODIGO) on delete restrict on update restrict;


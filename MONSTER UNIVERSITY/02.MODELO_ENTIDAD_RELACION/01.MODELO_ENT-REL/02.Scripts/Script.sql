/*==============================================================*/
/* DBMS name:      SAP SQL Anywhere 16                          */
/* Created on:     4/18/2019 4:18:02 PM                         */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_AEITE_IT_BIENES_IT_MEBIE_BI') then
    alter table AEITE_ITEENT
       delete foreign key FK_AEITE_IT_BIENES_IT_MEBIE_BI
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_AEITE_IT_ITEM_ENTR_AEENT_EN') then
    alter table AEITE_ITEENT
       delete foreign key FK_AEITE_IT_ITEM_ENTR_AEENT_EN
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_AEITE_IT_BIENES_IT_MEBIE_BI') then
    alter table AEITE_ITESAL
       delete foreign key FK_AEITE_IT_BIENES_IT_MEBIE_BI
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_AEITE_IT_ITEM_SALI_PEEMP_EM') then
    alter table AEITE_ITESAL
       delete foreign key FK_AEITE_IT_ITEM_SALI_PEEMP_EM
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_AEITE_IT_SALIDA_AL_AESAL_SA') then
    alter table AEITE_ITESAL
       delete foreign key FK_AEITE_IT_SALIDA_AL_AESAL_SA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_AESAL_SA_SALIDA_EM_PEEMP_EM') then
    alter table AESAL_SALALM
       delete foreign key FK_AESAL_SA_SALIDA_EM_PEEMP_EM
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_AESTO_ST_BIENES_ST_MEBIE_BI') then
    alter table AESTO_STOCK
       delete foreign key FK_AESTO_ST_BIENES_ST_MEBIE_BI
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CEITE_IT_BIENES_IT_MEBIE_BI') then
    alter table CEITE_ITESOL
       delete foreign key FK_CEITE_IT_BIENES_IT_MEBIE_BI
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CEITE_IT_SOLICITUD_CESOL_SO') then
    alter table CEITE_ITESOL
       delete foreign key FK_CEITE_IT_SOLICITUD_CESOL_SO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CEORD_OR_ORDEN_PRO_AEPRO_PR') then
    alter table CEORD_ORDCON
       delete foreign key FK_CEORD_OR_ORDEN_PRO_AEPRO_PR
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CESOL_SO_SOLICITUD_PEARE_AR') then
    alter table CESOL_SOLCOM
       delete foreign key FK_CESOL_SO_SOLICITUD_PEARE_AR
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CESOL_SO_SOLICITUD_PEEMP_EM') then
    alter table CESOL_SOLCOM
       delete foreign key FK_CESOL_SO_SOLICITUD_PEEMP_EM
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CESOL_SO_SOLICITUD_CERUB_RU') then
    alter table CESOL_SOLCOM
       delete foreign key FK_CESOL_SO_SOLICITUD_CERUB_RU
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MEBIE_BI_PROVEEDOR_AEPRO_PR') then
    alter table MEBIE_BIENES
       delete foreign key FK_MEBIE_BI_PROVEEDOR_AEPRO_PR
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MEDET_DE_DETALLE_O_CEITE_IT') then
    alter table MEDET_DETORD
       delete foreign key FK_MEDET_DE_DETALLE_O_CEITE_IT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MEDET_DE_DETALLE_O_CEORD_OR') then
    alter table MEDET_DETORD
       delete foreign key FK_MEDET_DE_DETALLE_O_CEORD_OR
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PECAR_CA_CARGO_ARE_PEARE_AR') then
    alter table PECAR_CARGO
       delete foreign key FK_PECAR_CA_CARGO_ARE_PEARE_AR
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PEEMP_EM_EMPLEADO__PECAR_CA') then
    alter table PEEMP_EMPLEADO
       delete foreign key FK_PEEMP_EM_EMPLEADO__PECAR_CA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PEEMP_EM_EMPLEADO__PEEST_ES') then
    alter table PEEMP_EMPLEADO
       delete foreign key FK_PEEMP_EM_EMPLEADO__PEEST_ES
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PEEMP_EM_EMPLEADO__PESEX_SE') then
    alter table PEEMP_EMPLEADO
       delete foreign key FK_PEEMP_EM_EMPLEADO__PESEX_SE
end if;

drop index if exists AEENT_ENTALM.AEENT_ENTALM_PK;

drop table if exists AEENT_ENTALM;

drop index if exists AEITE_ITEENT.ITEM_ENTRADA_ENTRADA_FK;

drop index if exists AEITE_ITEENT.BIENES_ITEM_ENTRADA_ALMACEN_FK;

drop index if exists AEITE_ITEENT.AEITE_ITEENT_PK;

drop table if exists AEITE_ITEENT;

drop index if exists AEITE_ITESAL.ITEM_SALIDA_EMPLEADO_FK;

drop index if exists AEITE_ITESAL.BIENES_ITEM_SALIDA_FK;

drop index if exists AEITE_ITESAL.SALIDA_ALMACEN_ITEM_SALIDA_FK;

drop index if exists AEITE_ITESAL.AEITE_ITESAL_PK;

drop table if exists AEITE_ITESAL;

drop index if exists AEPRO_PROVEEDOR.AEPRO_PROVEEDOR_PK;

drop table if exists AEPRO_PROVEEDOR;

drop index if exists AESAL_SALALM.SALIDA_EMPLEADO_FK;

drop index if exists AESAL_SALALM.AESAL_SALALM_PK;

drop table if exists AESAL_SALALM;

drop index if exists AESTO_STOCK.BIENES_STOCK_FK;

drop index if exists AESTO_STOCK.AESTO_STOCK_PK;

drop table if exists AESTO_STOCK;

drop index if exists CEITE_ITESOL.BIENES_ITEM_SOLICITUD_FK;

drop index if exists CEITE_ITESOL.SOLICITUD_COMPRA_ITEM_SOLICITUD_FK;

drop index if exists CEITE_ITESOL.CEITE_ITESOL_PK;

drop table if exists CEITE_ITESOL;

drop index if exists CEORD_ORDCON.ORDEN_PROVEEDOR_FK;

drop index if exists CEORD_ORDCON.CEORD_ORDCON_PK;

drop table if exists CEORD_ORDCON;

drop index if exists CERUB_RUBPRE.CERUB_RUBPRE_PK;

drop table if exists CERUB_RUBPRE;

drop index if exists CESOL_SOLCOM.SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO_FK;

drop index if exists CESOL_SOLCOM.SOLICITUD_COMPRA_AREA_FK;

drop index if exists CESOL_SOLCOM.SOLICITUD_COMPRA_EMPLEADO_FK;

drop index if exists CESOL_SOLCOM.CESOL_SOLCOM_PK;

drop table if exists CESOL_SOLCOM;

drop index if exists MEBIE_BIENES.PROVEEDOR_BIENES_FK;

drop index if exists MEBIE_BIENES.MEBIE_BIENES_PK;

drop table if exists MEBIE_BIENES;

drop index if exists MEDET_DETORD.DETALLE_ORDEN_FK;

drop index if exists MEDET_DETORD.DETALLE_ORDEN2_FK;

drop index if exists MEDET_DETORD.DETALLE_ORDEN_PK;

drop table if exists MEDET_DETORD;

drop index if exists PEARE_AREA.PEARE_AREA_PK;

drop table if exists PEARE_AREA;

drop index if exists PECAR_CARGO.CARGO_AREA_FK;

drop index if exists PECAR_CARGO.PECAR_CARGO_PK;

drop table if exists PECAR_CARGO;

drop index if exists PEEMP_EMPLEADO.EMPLEADO_ESTADO_CIVIL_FK;

drop index if exists PEEMP_EMPLEADO.EMPLEADO_SEXO_FK;

drop index if exists PEEMP_EMPLEADO.EMPLEADO_CARGO_FK;

drop index if exists PEEMP_EMPLEADO.PEEMP_EMPLEADO_PK;

drop table if exists PEEMP_EMPLEADO;

drop index if exists PEEST_ESTCIV.PEEST_ESTCIV_PK;

drop table if exists PEEST_ESTCIV;

drop index if exists PESEX_SEXO.PESEX_SEXO_PK;

drop table if exists PESEX_SEXO;

/*==============================================================*/
/* Table: AEENT_ENTALM                                          */
/*==============================================================*/
create table AEENT_ENTALM 
(
   ENT_NUMERO           integer                        not null,
   ENT_FECHA            date                           null,
   ENT_NUMEROFACTURA    integer                        null,
   ENT_TOTALBIENES      integer                        null,
   ENT_VALORTOTAL       float                          null,
   constraint PK_AEENT_ENTALM primary key clustered (ENT_NUMERO)
);

/*==============================================================*/
/* Index: AEENT_ENTALM_PK                                       */
/*==============================================================*/
create unique clustered index AEENT_ENTALM_PK on AEENT_ENTALM (
ENT_NUMERO ASC
);

/*==============================================================*/
/* Table: AEITE_ITEENT                                          */
/*==============================================================*/
create table AEITE_ITEENT 
(
   BIEN_ID              integer                        not null,
   ENT_NUMERO           integer                        not null,
   ITEE_CANTIDADENTREGADA integer                        null,
   constraint PK_AEITE_ITEENT primary key clustered (BIEN_ID, ENT_NUMERO)
);

/*==============================================================*/
/* Index: AEITE_ITEENT_PK                                       */
/*==============================================================*/
create unique clustered index AEITE_ITEENT_PK on AEITE_ITEENT (
BIEN_ID ASC,
ENT_NUMERO ASC
);

/*==============================================================*/
/* Index: BIENES_ITEM_ENTRADA_ALMACEN_FK                        */
/*==============================================================*/
create index BIENES_ITEM_ENTRADA_ALMACEN_FK on AEITE_ITEENT (
BIEN_ID ASC
);

/*==============================================================*/
/* Index: ITEM_ENTRADA_ENTRADA_FK                               */
/*==============================================================*/
create index ITEM_ENTRADA_ENTRADA_FK on AEITE_ITEENT (
ENT_NUMERO ASC
);

/*==============================================================*/
/* Table: AEITE_ITESAL                                          */
/*==============================================================*/
create table AEITE_ITESAL 
(
   SAL_NUMERO           integer                        not null,
   BIEN_ID              integer                        not null,
   EMP_ID               integer                        not null,
   ITESA_CANTIDADENTREGADA integer                        null,
   constraint PK_AEITE_ITESAL primary key clustered (SAL_NUMERO, BIEN_ID, EMP_ID)
);

/*==============================================================*/
/* Index: AEITE_ITESAL_PK                                       */
/*==============================================================*/
create unique clustered index AEITE_ITESAL_PK on AEITE_ITESAL (
SAL_NUMERO ASC,
BIEN_ID ASC,
EMP_ID ASC
);

/*==============================================================*/
/* Index: SALIDA_ALMACEN_ITEM_SALIDA_FK                         */
/*==============================================================*/
create index SALIDA_ALMACEN_ITEM_SALIDA_FK on AEITE_ITESAL (
SAL_NUMERO ASC
);

/*==============================================================*/
/* Index: BIENES_ITEM_SALIDA_FK                                 */
/*==============================================================*/
create index BIENES_ITEM_SALIDA_FK on AEITE_ITESAL (
BIEN_ID ASC
);

/*==============================================================*/
/* Index: ITEM_SALIDA_EMPLEADO_FK                               */
/*==============================================================*/
create index ITEM_SALIDA_EMPLEADO_FK on AEITE_ITESAL (
EMP_ID ASC
);

/*==============================================================*/
/* Table: AEPRO_PROVEEDOR                                       */
/*==============================================================*/
create table AEPRO_PROVEEDOR 
(
   PRO_ID               integer                        not null,
   PRO_RUC              integer                        null,
   PRO_NOMBRE           varchar(100)                   null,
   PRO_TELEFONO         varchar(10)                    null,
   PRO_DIRECCION        varchar(200)                   null,
   constraint PK_AEPRO_PROVEEDOR primary key clustered (PRO_ID)
);

/*==============================================================*/
/* Index: AEPRO_PROVEEDOR_PK                                    */
/*==============================================================*/
create unique clustered index AEPRO_PROVEEDOR_PK on AEPRO_PROVEEDOR (
PRO_ID ASC
);

/*==============================================================*/
/* Table: AESAL_SALALM                                          */
/*==============================================================*/
create table AESAL_SALALM 
(
   SAL_NUMERO           integer                        not null,
   EMP_ID               integer                        not null,
   SAL_FECHASALIDA      date                           null,
   SAL_FECHAENTREGA     date                           null,
   constraint PK_AESAL_SALALM primary key clustered (SAL_NUMERO)
);

/*==============================================================*/
/* Index: AESAL_SALALM_PK                                       */
/*==============================================================*/
create unique clustered index AESAL_SALALM_PK on AESAL_SALALM (
SAL_NUMERO ASC
);

/*==============================================================*/
/* Index: SALIDA_EMPLEADO_FK                                    */
/*==============================================================*/
create index SALIDA_EMPLEADO_FK on AESAL_SALALM (
EMP_ID ASC
);

/*==============================================================*/
/* Table: AESTO_STOCK                                           */
/*==============================================================*/
create table AESTO_STOCK 
(
   STO_ID               integer                        not null,
   BIEN_ID              integer                        not null,
   STO_CANTIDAD         numeric(10,2)                  null,
   constraint PK_AESTO_STOCK primary key clustered (STO_ID)
);

/*==============================================================*/
/* Index: AESTO_STOCK_PK                                        */
/*==============================================================*/
create unique clustered index AESTO_STOCK_PK on AESTO_STOCK (
STO_ID ASC
);

/*==============================================================*/
/* Index: BIENES_STOCK_FK                                       */
/*==============================================================*/
create index BIENES_STOCK_FK on AESTO_STOCK (
BIEN_ID ASC
);

/*==============================================================*/
/* Table: CEITE_ITESOL                                          */
/*==============================================================*/
create table CEITE_ITESOL 
(
   SOL_NUMERO           integer                        not null,
   BIEN_ID              integer                        not null,
   ITES_CANTIDADSOLICITADA integer                        null,
   ITES_CANTIDADDESPACHADA integer                        null,
   ITES_VALORTOTAL      float                          null,
   constraint PK_CEITE_ITESOL primary key clustered (SOL_NUMERO, BIEN_ID)
);

/*==============================================================*/
/* Index: CEITE_ITESOL_PK                                       */
/*==============================================================*/
create unique clustered index CEITE_ITESOL_PK on CEITE_ITESOL (
SOL_NUMERO ASC,
BIEN_ID ASC
);

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_ITEM_SOLICITUD_FK                    */
/*==============================================================*/
create index SOLICITUD_COMPRA_ITEM_SOLICITUD_FK on CEITE_ITESOL (
SOL_NUMERO ASC
);

/*==============================================================*/
/* Index: BIENES_ITEM_SOLICITUD_FK                              */
/*==============================================================*/
create index BIENES_ITEM_SOLICITUD_FK on CEITE_ITESOL (
BIEN_ID ASC
);

/*==============================================================*/
/* Table: CEORD_ORDCON                                          */
/*==============================================================*/
create table CEORD_ORDCON 
(
   ORD_NUMERO           integer                        not null,
   PRO_ID               integer                        not null,
   ORD_FECHAORDEN       date                           null,
   ORD_FECHAENTREGA     date                           null,
   ORD_MONTOTOTAL       float                          null,
   ORD_APROVACIONDIRECTORFINANCIERO smallint                       null,
   constraint PK_CEORD_ORDCON primary key clustered (ORD_NUMERO)
);

/*==============================================================*/
/* Index: CEORD_ORDCON_PK                                       */
/*==============================================================*/
create unique clustered index CEORD_ORDCON_PK on CEORD_ORDCON (
ORD_NUMERO ASC
);

/*==============================================================*/
/* Index: ORDEN_PROVEEDOR_FK                                    */
/*==============================================================*/
create index ORDEN_PROVEEDOR_FK on CEORD_ORDCON (
PRO_ID ASC
);

/*==============================================================*/
/* Table: CERUB_RUBPRE                                          */
/*==============================================================*/
create table CERUB_RUBPRE 
(
   RUB_CODIGO           integer                        not null,
   RUB_CATEGORIA        varchar(100)                   null,
   RUB_PRESUPUESTO      float                          null,
   constraint PK_CERUB_RUBPRE primary key clustered (RUB_CODIGO)
);

/*==============================================================*/
/* Index: CERUB_RUBPRE_PK                                       */
/*==============================================================*/
create unique clustered index CERUB_RUBPRE_PK on CERUB_RUBPRE (
RUB_CODIGO ASC
);

/*==============================================================*/
/* Table: CESOL_SOLCOM                                          */
/*==============================================================*/
create table CESOL_SOLCOM 
(
   SOL_NUMERO           integer                        not null,
   EMP_ID               integer                        not null,
   ARE_ID               integer                        not null,
   RUB_CODIGO           integer                        not null,
   SOL_FECHA            date                           null,
   SOL_APROBACIONDIRECTORFINANCIERO smallint                       null,
   SOL_APROBACIONJEFEAREA smallint                       null,
   SOL_TOTAL            float                          null,
   constraint PK_CESOL_SOLCOM primary key clustered (SOL_NUMERO)
);

/*==============================================================*/
/* Index: CESOL_SOLCOM_PK                                       */
/*==============================================================*/
create unique clustered index CESOL_SOLCOM_PK on CESOL_SOLCOM (
SOL_NUMERO ASC
);

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_EMPLEADO_FK                          */
/*==============================================================*/
create index SOLICITUD_COMPRA_EMPLEADO_FK on CESOL_SOLCOM (
EMP_ID ASC
);

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_AREA_FK                              */
/*==============================================================*/
create index SOLICITUD_COMPRA_AREA_FK on CESOL_SOLCOM (
ARE_ID ASC
);

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO_FK              */
/*==============================================================*/
create index SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO_FK on CESOL_SOLCOM (
RUB_CODIGO ASC
);

/*==============================================================*/
/* Table: MEBIE_BIENES                                          */
/*==============================================================*/
create table MEBIE_BIENES 
(
   BIEN_ID              integer                        not null,
   PRO_ID               integer                        not null,
   BIEN_NOMBRE          varchar(100)                   null,
   BIEN_UNIDADMEDIDA    varchar(100)                   null,
   BIEN_TIPO            varchar(100)                   null,
   constraint PK_MEBIE_BIENES primary key clustered (BIEN_ID)
);

/*==============================================================*/
/* Index: MEBIE_BIENES_PK                                       */
/*==============================================================*/
create unique clustered index MEBIE_BIENES_PK on MEBIE_BIENES (
BIEN_ID ASC
);

/*==============================================================*/
/* Index: PROVEEDOR_BIENES_FK                                   */
/*==============================================================*/
create index PROVEEDOR_BIENES_FK on MEBIE_BIENES (
PRO_ID ASC
);

/*==============================================================*/
/* Table: MEDET_DETORD                                          */
/*==============================================================*/
create table MEDET_DETORD 
(
   SOL_NUMERO           integer                        not null,
   BIEN_ID              integer                        not null,
   ORD_NUMERO           integer                        not null,
   constraint PK_MEDET_DETORD primary key clustered (SOL_NUMERO, BIEN_ID, ORD_NUMERO)
);

/*==============================================================*/
/* Index: DETALLE_ORDEN_PK                                      */
/*==============================================================*/
create unique clustered index DETALLE_ORDEN_PK on MEDET_DETORD (
SOL_NUMERO ASC,
BIEN_ID ASC,
ORD_NUMERO ASC
);

/*==============================================================*/
/* Index: DETALLE_ORDEN2_FK                                     */
/*==============================================================*/
create index DETALLE_ORDEN2_FK on MEDET_DETORD (
ORD_NUMERO ASC
);

/*==============================================================*/
/* Index: DETALLE_ORDEN_FK                                      */
/*==============================================================*/
create index DETALLE_ORDEN_FK on MEDET_DETORD (
SOL_NUMERO ASC,
BIEN_ID ASC
);

/*==============================================================*/
/* Table: PEARE_AREA                                            */
/*==============================================================*/
create table PEARE_AREA 
(
   ARE_ID               integer                        not null,
   ARE_NOMBRE           varchar(100)                   null,
   ARE_UBICACION        varchar(100)                   null,
   constraint PK_PEARE_AREA primary key clustered (ARE_ID)
);

/*==============================================================*/
/* Index: PEARE_AREA_PK                                         */
/*==============================================================*/
create unique clustered index PEARE_AREA_PK on PEARE_AREA (
ARE_ID ASC
);

/*==============================================================*/
/* Table: PECAR_CARGO                                           */
/*==============================================================*/
create table PECAR_CARGO 
(
   CAR_ID               integer                        not null,
   ARE_ID               integer                        not null,
   CAR_NOMBRE           varchar(100)                   not null,
   CAR_DETALLES         varchar(500)                   not null,
   constraint PK_PECAR_CARGO primary key clustered (CAR_ID)
);

/*==============================================================*/
/* Index: PECAR_CARGO_PK                                        */
/*==============================================================*/
create unique clustered index PECAR_CARGO_PK on PECAR_CARGO (
CAR_ID ASC
);

/*==============================================================*/
/* Index: CARGO_AREA_FK                                         */
/*==============================================================*/
create index CARGO_AREA_FK on PECAR_CARGO (
ARE_ID ASC
);

/*==============================================================*/
/* Table: PEEMP_EMPLEADO                                        */
/*==============================================================*/
create table PEEMP_EMPLEADO 
(
   EMP_ID               integer                        not null,
   CAR_ID               integer                        not null,
   SEX_ID               integer                        not null,
   EST_ID               integer                        not null,
   EMP_CEDULA           integer                        null,
   EMP_NOMBRE           varchar(100)                   null,
   EMP_TELEFONO         varchar(10)                    null,
   constraint PK_PEEMP_EMPLEADO primary key clustered (EMP_ID)
);

/*==============================================================*/
/* Index: PEEMP_EMPLEADO_PK                                     */
/*==============================================================*/
create unique clustered index PEEMP_EMPLEADO_PK on PEEMP_EMPLEADO (
EMP_ID ASC
);

/*==============================================================*/
/* Index: EMPLEADO_CARGO_FK                                     */
/*==============================================================*/
create index EMPLEADO_CARGO_FK on PEEMP_EMPLEADO (
CAR_ID ASC
);

/*==============================================================*/
/* Index: EMPLEADO_SEXO_FK                                      */
/*==============================================================*/
create index EMPLEADO_SEXO_FK on PEEMP_EMPLEADO (
SEX_ID ASC
);

/*==============================================================*/
/* Index: EMPLEADO_ESTADO_CIVIL_FK                              */
/*==============================================================*/
create index EMPLEADO_ESTADO_CIVIL_FK on PEEMP_EMPLEADO (
EST_ID ASC
);

/*==============================================================*/
/* Table: PEEST_ESTCIV                                          */
/*==============================================================*/
create table PEEST_ESTCIV 
(
   EST_ID               integer                        not null,
   EST_DESCRIPCION      varchar(30)                    not null,
   constraint PK_PEEST_ESTCIV primary key clustered (EST_ID)
);

/*==============================================================*/
/* Index: PEEST_ESTCIV_PK                                       */
/*==============================================================*/
create unique clustered index PEEST_ESTCIV_PK on PEEST_ESTCIV (
EST_ID ASC
);

/*==============================================================*/
/* Table: PESEX_SEXO                                            */
/*==============================================================*/
create table PESEX_SEXO 
(
   SEX_ID               integer                        not null,
   SEX_DESCRIPCION      varchar(30)                    not null,
   constraint PK_PESEX_SEXO primary key clustered (SEX_ID)
);

/*==============================================================*/
/* Index: PESEX_SEXO_PK                                         */
/*==============================================================*/
create unique clustered index PESEX_SEXO_PK on PESEX_SEXO (
SEX_ID ASC
);

alter table AEITE_ITEENT
   add constraint FK_AEITE_IT_BIENES_IT_MEBIE_BI foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID)
      on update restrict
      on delete restrict;

alter table AEITE_ITEENT
   add constraint FK_AEITE_IT_ITEM_ENTR_AEENT_EN foreign key (ENT_NUMERO)
      references AEENT_ENTALM (ENT_NUMERO)
      on update restrict
      on delete restrict;

alter table AEITE_ITESAL
   add constraint FK_AEITE_IT_BIENES_IT_MEBIE_BI foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID)
      on update restrict
      on delete restrict;

alter table AEITE_ITESAL
   add constraint FK_AEITE_IT_ITEM_SALI_PEEMP_EM foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID)
      on update restrict
      on delete restrict;

alter table AEITE_ITESAL
   add constraint FK_AEITE_IT_SALIDA_AL_AESAL_SA foreign key (SAL_NUMERO)
      references AESAL_SALALM (SAL_NUMERO)
      on update restrict
      on delete restrict;

alter table AESAL_SALALM
   add constraint FK_AESAL_SA_SALIDA_EM_PEEMP_EM foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID)
      on update restrict
      on delete restrict;

alter table AESTO_STOCK
   add constraint FK_AESTO_ST_BIENES_ST_MEBIE_BI foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID)
      on update restrict
      on delete restrict;

alter table CEITE_ITESOL
   add constraint FK_CEITE_IT_BIENES_IT_MEBIE_BI foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID)
      on update restrict
      on delete restrict;

alter table CEITE_ITESOL
   add constraint FK_CEITE_IT_SOLICITUD_CESOL_SO foreign key (SOL_NUMERO)
      references CESOL_SOLCOM (SOL_NUMERO)
      on update restrict
      on delete restrict;

alter table CEORD_ORDCON
   add constraint FK_CEORD_OR_ORDEN_PRO_AEPRO_PR foreign key (PRO_ID)
      references AEPRO_PROVEEDOR (PRO_ID)
      on update restrict
      on delete restrict;

alter table CESOL_SOLCOM
   add constraint FK_CESOL_SO_SOLICITUD_PEARE_AR foreign key (ARE_ID)
      references PEARE_AREA (ARE_ID)
      on update restrict
      on delete restrict;

alter table CESOL_SOLCOM
   add constraint FK_CESOL_SO_SOLICITUD_PEEMP_EM foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID)
      on update restrict
      on delete restrict;

alter table CESOL_SOLCOM
   add constraint FK_CESOL_SO_SOLICITUD_CERUB_RU foreign key (RUB_CODIGO)
      references CERUB_RUBPRE (RUB_CODIGO)
      on update restrict
      on delete restrict;

alter table MEBIE_BIENES
   add constraint FK_MEBIE_BI_PROVEEDOR_AEPRO_PR foreign key (PRO_ID)
      references AEPRO_PROVEEDOR (PRO_ID)
      on update restrict
      on delete restrict;

alter table MEDET_DETORD
   add constraint FK_MEDET_DE_DETALLE_O_CEITE_IT foreign key (SOL_NUMERO, BIEN_ID)
      references CEITE_ITESOL (SOL_NUMERO, BIEN_ID)
      on update restrict
      on delete restrict;

alter table MEDET_DETORD
   add constraint FK_MEDET_DE_DETALLE_O_CEORD_OR foreign key (ORD_NUMERO)
      references CEORD_ORDCON (ORD_NUMERO)
      on update restrict
      on delete restrict;

alter table PECAR_CARGO
   add constraint FK_PECAR_CA_CARGO_ARE_PEARE_AR foreign key (ARE_ID)
      references PEARE_AREA (ARE_ID)
      on update restrict
      on delete restrict;

alter table PEEMP_EMPLEADO
   add constraint FK_PEEMP_EM_EMPLEADO__PECAR_CA foreign key (CAR_ID)
      references PECAR_CARGO (CAR_ID)
      on update restrict
      on delete restrict;

alter table PEEMP_EMPLEADO
   add constraint FK_PEEMP_EM_EMPLEADO__PEEST_ES foreign key (EST_ID)
      references PEEST_ESTCIV (EST_ID)
      on update restrict
      on delete restrict;

alter table PEEMP_EMPLEADO
   add constraint FK_PEEMP_EM_EMPLEADO__PESEX_SE foreign key (SEX_ID)
      references PESEX_SEXO (SEX_ID)
      on update restrict
      on delete restrict;


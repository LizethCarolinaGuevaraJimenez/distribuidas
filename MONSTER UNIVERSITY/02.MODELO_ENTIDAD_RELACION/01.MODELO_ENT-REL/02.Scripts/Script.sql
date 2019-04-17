/*==============================================================*/
/* DBMS name:      SAP SQL Anywhere 16                          */
/* Created on:     4/17/2019 1:43:53 AM                         */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_BIENES_PROVEEDOR_PROVEEDO') then
    alter table BIENES
       delete foreign key FK_BIENES_PROVEEDOR_PROVEEDO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CARGO_CARGO_ARE_AREA') then
    alter table CARGO
       delete foreign key FK_CARGO_CARGO_ARE_AREA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_DETALLE__DETALLE_O_ITEM_SOL') then
    alter table DETALLE_ORDEN
       delete foreign key FK_DETALLE__DETALLE_O_ITEM_SOL
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_DETALLE__DETALLE_O_ORDEN_CO') then
    alter table DETALLE_ORDEN
       delete foreign key FK_DETALLE__DETALLE_O_ORDEN_CO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_EMPLEADO_EMPLEADO__CARGO') then
    alter table EMPLEADO
       delete foreign key FK_EMPLEADO_EMPLEADO__CARGO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_EMPLEADO_EMPLEADO__ESTADO_C') then
    alter table EMPLEADO
       delete foreign key FK_EMPLEADO_EMPLEADO__ESTADO_C
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_EMPLEADO_EMPLEADO__SEXO') then
    alter table EMPLEADO
       delete foreign key FK_EMPLEADO_EMPLEADO__SEXO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ITEM_ENT_BIENES_IT_BIENES') then
    alter table ITEM_ENTRADA
       delete foreign key FK_ITEM_ENT_BIENES_IT_BIENES
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ITEM_ENT_ITEM_ENTR_ENTRADA_') then
    alter table ITEM_ENTRADA
       delete foreign key FK_ITEM_ENT_ITEM_ENTR_ENTRADA_
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ITEM_SAL_BIENES_IT_BIENES') then
    alter table ITEM_SALIDA
       delete foreign key FK_ITEM_SAL_BIENES_IT_BIENES
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ITEM_SAL_ITEM_SALI_EMPLEADO') then
    alter table ITEM_SALIDA
       delete foreign key FK_ITEM_SAL_ITEM_SALI_EMPLEADO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ITEM_SAL_SALIDA_AL_SALIDA_A') then
    alter table ITEM_SALIDA
       delete foreign key FK_ITEM_SAL_SALIDA_AL_SALIDA_A
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ITEM_SOL_BIENES_IT_BIENES') then
    alter table ITEM_SOLICITUD
       delete foreign key FK_ITEM_SOL_BIENES_IT_BIENES
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ITEM_SOL_SOLICITUD_SOLICITU') then
    alter table ITEM_SOLICITUD
       delete foreign key FK_ITEM_SOL_SOLICITUD_SOLICITU
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ORDEN_CO_ORDEN_PRO_PROVEEDO') then
    alter table ORDEN_CONTRACTUAL
       delete foreign key FK_ORDEN_CO_ORDEN_PRO_PROVEEDO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SALIDA_A_SALIDA_EM_EMPLEADO') then
    alter table SALIDA_ALMACEN
       delete foreign key FK_SALIDA_A_SALIDA_EM_EMPLEADO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SOLICITU_SOLICITUD_AREA') then
    alter table SOLICITUD_COMPRA
       delete foreign key FK_SOLICITU_SOLICITUD_AREA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SOLICITU_SOLICITUD_EMPLEADO') then
    alter table SOLICITUD_COMPRA
       delete foreign key FK_SOLICITU_SOLICITUD_EMPLEADO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SOLICITU_SOLICITUD_RUBRO_PR') then
    alter table SOLICITUD_COMPRA
       delete foreign key FK_SOLICITU_SOLICITUD_RUBRO_PR
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_STOCK_BIENES_ST_BIENES') then
    alter table STOCK
       delete foreign key FK_STOCK_BIENES_ST_BIENES
end if;

drop index if exists AREA.AREA_PK;

drop table if exists AREA;

drop index if exists BIENES.PROVEEDOR_BIENES_FK;

drop index if exists BIENES.BIENES_PK;

drop table if exists BIENES;

drop index if exists CARGO.CARGO_AREA_FK;

drop table if exists CARGO;

drop index if exists DETALLE_ORDEN.DETALLE_ORDEN_FK;

drop index if exists DETALLE_ORDEN.DETALLE_ORDEN_PK;

drop table if exists DETALLE_ORDEN;

drop index if exists EMPLEADO.EMPLEADO_CARGO_FK;

drop index if exists EMPLEADO.EMPLEADO_SEXO_FK;

drop index if exists EMPLEADO.EMPLEADO_ESTADO_CIVIL_FK;

drop index if exists EMPLEADO.EMPLEADO_PK;

drop table if exists EMPLEADO;

drop index if exists ENTRADA_ALMACEN.ENTRADA_ALMACEN_PK;

drop table if exists ENTRADA_ALMACEN;

drop index if exists ESTADO_CIVIL.ESTADO_CIVIL_PK;

drop table if exists ESTADO_CIVIL;

drop index if exists ITEM_ENTRADA.ITEM_ENTRADA_ENTRADA_FK;

drop index if exists ITEM_ENTRADA.BIENES_ITEM_ENTRADA_ALMACEN_FK;

drop table if exists ITEM_ENTRADA;

drop index if exists ITEM_SALIDA.ITEM_SALIDA_EMPLEADO_FK;

drop index if exists ITEM_SALIDA.BIENES_ITEM_SALIDA_FK;

drop index if exists ITEM_SALIDA.SALIDA_ALMACEN_ITEM_SALIDA_FK;

drop table if exists ITEM_SALIDA;

drop index if exists ITEM_SOLICITUD.BIENES_ITEM_SOLICITUD_FK;

drop index if exists ITEM_SOLICITUD.SOLICITUD_COMPRA_ITEM_SOLICITUD_FK;

drop table if exists ITEM_SOLICITUD;

drop index if exists ORDEN_CONTRACTUAL.ORDEN_PROVEEDOR_FK;

drop index if exists ORDEN_CONTRACTUAL.ORDEN_CONTRACTUAL_PK;

drop table if exists ORDEN_CONTRACTUAL;

drop index if exists PROVEEDOR.PROVEEDOR_PK;

drop table if exists PROVEEDOR;

drop index if exists RUBRO_PRESUPUESTARIO.RUBRO_PRESUPUESTARIO_PK;

drop table if exists RUBRO_PRESUPUESTARIO;

drop index if exists SALIDA_ALMACEN.SALIDA_EMPLEADO_FK;

drop index if exists SALIDA_ALMACEN.SALIDA_ALMACEN_PK;

drop table if exists SALIDA_ALMACEN;

drop index if exists SEXO.SEXO_PK;

drop table if exists SEXO;

drop index if exists SOLICITUD_COMPRA.SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO_FK;

drop index if exists SOLICITUD_COMPRA.SOLICITUD_COMPRA_AREA_FK;

drop index if exists SOLICITUD_COMPRA.SOLICITUD_COMPRA_EMPLEADO_FK;

drop index if exists SOLICITUD_COMPRA.SOLICITUD_COMPRA_PK;

drop table if exists SOLICITUD_COMPRA;

drop index if exists STOCK.BIENES_STOCK_FK;

drop index if exists STOCK.STOCK_PK;

drop table if exists STOCK;

/*==============================================================*/
/* Table: AREA                                                  */
/*==============================================================*/
create table AREA 
(
   ARE_ID               integer                        not null,
   ARE_NOMBRE           varchar(100)                   null,
   ARE_UBICACION        varchar(100)                   null,
   constraint PK_AREA primary key clustered (ARE_ID)
);

/*==============================================================*/
/* Index: AREA_PK                                               */
/*==============================================================*/
create unique clustered index AREA_PK on AREA (
ARE_ID ASC
);

/*==============================================================*/
/* Table: BIENES                                                */
/*==============================================================*/
create table BIENES 
(
   BIEN_ID              integer                        not null,
   PRO_ID               integer                        not null,
   BIEN_NOMBRE          varchar(100)                   null,
   BIEN_UNIDADMEDIDA    varchar(100)                   null,
   BIEN_TIPO            varchar(100)                   null,
   constraint PK_BIENES primary key clustered (BIEN_ID)
);

/*==============================================================*/
/* Index: BIENES_PK                                             */
/*==============================================================*/
create unique clustered index BIENES_PK on BIENES (
BIEN_ID ASC
);

/*==============================================================*/
/* Index: PROVEEDOR_BIENES_FK                                   */
/*==============================================================*/
create index PROVEEDOR_BIENES_FK on BIENES (
PRO_ID ASC
);

/*==============================================================*/
/* Table: CARGO                                                 */
/*==============================================================*/
create table CARGO 
(
   CAR_ID               integer                        not null,
   ARE_ID               integer                        not null,
   CAR_NOMBRE           varchar(100)                   null,
   CAR_DETALLES         varchar(500)                   null,
   constraint PK_CARGO primary key clustered (CAR_ID)
);

/*==============================================================*/
/* Index: CARGO_AREA_FK                                         */
/*==============================================================*/
create index CARGO_AREA_FK on CARGO (
ARE_ID ASC
);

/*==============================================================*/
/* Table: DETALLE_ORDEN                                         */
/*==============================================================*/
create table DETALLE_ORDEN 
(
   ORD_NUMERO           integer                        not null,
   SOL_NUMERO           integer                        not null,
   BIEN_ID              integer                        not null,
   constraint PK_DETALLE_ORDEN primary key clustered (ORD_NUMERO, SOL_NUMERO, BIEN_ID)
);

/*==============================================================*/
/* Index: DETALLE_ORDEN_PK                                      */
/*==============================================================*/
create unique clustered index DETALLE_ORDEN_PK on DETALLE_ORDEN (
ORD_NUMERO ASC,
SOL_NUMERO ASC,
BIEN_ID ASC
);

/*==============================================================*/
/* Index: DETALLE_ORDEN_FK                                      */
/*==============================================================*/
create index DETALLE_ORDEN_FK on DETALLE_ORDEN (
SOL_NUMERO ASC,
BIEN_ID ASC
);

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO 
(
   EMP_ID               integer                        not null,
   SEX_ID               integer                        not null,
   EST_ID               integer                        not null,
   CAR_ID               integer                        null,
   EMP_CEDULA           integer                        null,
   EMP_NOMBRE           varchar(100)                   null,
   EMP_TELEFONO         varchar(10)                    null,
   constraint PK_EMPLEADO primary key clustered (EMP_ID)
);

/*==============================================================*/
/* Index: EMPLEADO_PK                                           */
/*==============================================================*/
create unique clustered index EMPLEADO_PK on EMPLEADO (
EMP_ID ASC
);

/*==============================================================*/
/* Index: EMPLEADO_ESTADO_CIVIL_FK                              */
/*==============================================================*/
create index EMPLEADO_ESTADO_CIVIL_FK on EMPLEADO (
EST_ID ASC
);

/*==============================================================*/
/* Index: EMPLEADO_SEXO_FK                                      */
/*==============================================================*/
create index EMPLEADO_SEXO_FK on EMPLEADO (
SEX_ID ASC
);

/*==============================================================*/
/* Index: EMPLEADO_CARGO_FK                                     */
/*==============================================================*/
create index EMPLEADO_CARGO_FK on EMPLEADO (
CAR_ID ASC
);

/*==============================================================*/
/* Table: ENTRADA_ALMACEN                                       */
/*==============================================================*/
create table ENTRADA_ALMACEN 
(
   ENT_NUMERO           integer                        not null,
   ENT_FECHA            date                           null,
   ENT_NUMEROFACTURA    integer                        null,
   ENT_TOTALBIENES      integer                        null,
   ENT_VALORTOTAL       float                          null,
   constraint PK_ENTRADA_ALMACEN primary key clustered (ENT_NUMERO)
);

/*==============================================================*/
/* Index: ENTRADA_ALMACEN_PK                                    */
/*==============================================================*/
create unique clustered index ENTRADA_ALMACEN_PK on ENTRADA_ALMACEN (
ENT_NUMERO ASC
);

/*==============================================================*/
/* Table: ESTADO_CIVIL                                          */
/*==============================================================*/
create table ESTADO_CIVIL 
(
   EST_ID               integer                        not null,
   EST_DESCRIPCION      varchar(30)                    not null,
   constraint PK_ESTADO_CIVIL primary key clustered (EST_ID)
);

/*==============================================================*/
/* Index: ESTADO_CIVIL_PK                                       */
/*==============================================================*/
create unique clustered index ESTADO_CIVIL_PK on ESTADO_CIVIL (
EST_ID ASC
);

/*==============================================================*/
/* Table: ITEM_ENTRADA                                          */
/*==============================================================*/
create table ITEM_ENTRADA 
(
   BIEN_ID              integer                        not null,
   ENT_NUMERO           integer                        not null,
   ITEE_CANTIDADENTREGADA integer                        null,
   constraint PK_ITEM_ENTRADA primary key clustered (BIEN_ID, ENT_NUMERO)
);

/*==============================================================*/
/* Index: BIENES_ITEM_ENTRADA_ALMACEN_FK                        */
/*==============================================================*/
create index BIENES_ITEM_ENTRADA_ALMACEN_FK on ITEM_ENTRADA (
BIEN_ID ASC
);

/*==============================================================*/
/* Index: ITEM_ENTRADA_ENTRADA_FK                               */
/*==============================================================*/
create index ITEM_ENTRADA_ENTRADA_FK on ITEM_ENTRADA (
ENT_NUMERO ASC
);

/*==============================================================*/
/* Table: ITEM_SALIDA                                           */
/*==============================================================*/
create table ITEM_SALIDA 
(
   SAL_NUMERO           integer                        not null,
   BIEN_ID              integer                        not null,
   EMP_ID               integer                        not null,
   ITESA_CANTIDADENTREGADA integer                        null,
   constraint PK_ITEM_SALIDA primary key clustered (SAL_NUMERO, BIEN_ID, EMP_ID)
);

/*==============================================================*/
/* Index: SALIDA_ALMACEN_ITEM_SALIDA_FK                         */
/*==============================================================*/
create index SALIDA_ALMACEN_ITEM_SALIDA_FK on ITEM_SALIDA (
SAL_NUMERO ASC
);

/*==============================================================*/
/* Index: BIENES_ITEM_SALIDA_FK                                 */
/*==============================================================*/
create index BIENES_ITEM_SALIDA_FK on ITEM_SALIDA (
BIEN_ID ASC
);

/*==============================================================*/
/* Index: ITEM_SALIDA_EMPLEADO_FK                               */
/*==============================================================*/
create index ITEM_SALIDA_EMPLEADO_FK on ITEM_SALIDA (
EMP_ID ASC
);

/*==============================================================*/
/* Table: ITEM_SOLICITUD                                        */
/*==============================================================*/
create table ITEM_SOLICITUD 
(
   SOL_NUMERO           integer                        not null,
   BIEN_ID              integer                        not null,
   ITES_CANTIDADSOLICITADA integer                        null,
   ITES_CANTIDADDESPACHADA integer                        null,
   ITES_VALORTOTAL      float                          null,
   constraint PK_ITEM_SOLICITUD primary key clustered (SOL_NUMERO, BIEN_ID)
);

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_ITEM_SOLICITUD_FK                    */
/*==============================================================*/
create index SOLICITUD_COMPRA_ITEM_SOLICITUD_FK on ITEM_SOLICITUD (
SOL_NUMERO ASC
);

/*==============================================================*/
/* Index: BIENES_ITEM_SOLICITUD_FK                              */
/*==============================================================*/
create index BIENES_ITEM_SOLICITUD_FK on ITEM_SOLICITUD (
BIEN_ID ASC
);

/*==============================================================*/
/* Table: ORDEN_CONTRACTUAL                                     */
/*==============================================================*/
create table ORDEN_CONTRACTUAL 
(
   ORD_NUMERO           integer                        not null,
   PRO_ID               integer                        not null,
   ORD_FECHAORDEN       date                           null,
   ORD_FECHAENTREGA     date                           null,
   ORD_MONTOTOTAL       float                          null,
   ORD_APROVACIONDIRECTORFINANCIERO smallint                       null,
   constraint PK_ORDEN_CONTRACTUAL primary key clustered (ORD_NUMERO)
);

/*==============================================================*/
/* Index: ORDEN_CONTRACTUAL_PK                                  */
/*==============================================================*/
create unique clustered index ORDEN_CONTRACTUAL_PK on ORDEN_CONTRACTUAL (
ORD_NUMERO ASC
);

/*==============================================================*/
/* Index: ORDEN_PROVEEDOR_FK                                    */
/*==============================================================*/
create index ORDEN_PROVEEDOR_FK on ORDEN_CONTRACTUAL (
PRO_ID ASC
);

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR 
(
   PRO_ID               integer                        not null,
   PRO_RUC              integer                        null,
   PRO_NOMBRE           varchar(100)                   null,
   PRO_TELEFONO         varchar(10)                    null,
   PRO_DIRECCION        varchar(200)                   null,
   constraint PK_PROVEEDOR primary key clustered (PRO_ID)
);

/*==============================================================*/
/* Index: PROVEEDOR_PK                                          */
/*==============================================================*/
create unique clustered index PROVEEDOR_PK on PROVEEDOR (
PRO_ID ASC
);

/*==============================================================*/
/* Table: RUBRO_PRESUPUESTARIO                                  */
/*==============================================================*/
create table RUBRO_PRESUPUESTARIO 
(
   RUB_CODIGO           integer                        not null,
   RUB_CATEGORIA        varchar(100)                   null,
   RUB_PRESUPUESTO      float                          null,
   constraint PK_RUBRO_PRESUPUESTARIO primary key clustered (RUB_CODIGO)
);

/*==============================================================*/
/* Index: RUBRO_PRESUPUESTARIO_PK                               */
/*==============================================================*/
create unique clustered index RUBRO_PRESUPUESTARIO_PK on RUBRO_PRESUPUESTARIO (
RUB_CODIGO ASC
);

/*==============================================================*/
/* Table: SALIDA_ALMACEN                                        */
/*==============================================================*/
create table SALIDA_ALMACEN 
(
   SAL_NUMERO           integer                        not null,
   EMP_ID               integer                        not null,
   SAL_FECHASALIDA      date                           null,
   SAL_FECHAENTREGA     date                           null,
   constraint PK_SALIDA_ALMACEN primary key clustered (SAL_NUMERO)
);

/*==============================================================*/
/* Index: SALIDA_ALMACEN_PK                                     */
/*==============================================================*/
create unique clustered index SALIDA_ALMACEN_PK on SALIDA_ALMACEN (
SAL_NUMERO ASC
);

/*==============================================================*/
/* Index: SALIDA_EMPLEADO_FK                                    */
/*==============================================================*/
create index SALIDA_EMPLEADO_FK on SALIDA_ALMACEN (
EMP_ID ASC
);

/*==============================================================*/
/* Table: SEXO                                                  */
/*==============================================================*/
create table SEXO 
(
   SEX_ID               integer                        not null,
   SEX_DESCRIPCION      varchar(30)                    not null,
   constraint PK_SEXO primary key clustered (SEX_ID)
);

/*==============================================================*/
/* Index: SEXO_PK                                               */
/*==============================================================*/
create unique clustered index SEXO_PK on SEXO (
SEX_ID ASC
);

/*==============================================================*/
/* Table: SOLICITUD_COMPRA                                      */
/*==============================================================*/
create table SOLICITUD_COMPRA 
(
   SOL_NUMERO           integer                        not null,
   EMP_ID               integer                        not null,
   ARE_ID               integer                        not null,
   RUB_CODIGO           integer                        not null,
   SOL_FECHA            date                           null,
   SOL_APROBACIONDIRECTORFINANCIERO smallint                       null,
   SOL_APROBACIONJEFEAREA smallint                       null,
   SOL_TOTAL            float                          null,
   constraint PK_SOLICITUD_COMPRA primary key clustered (SOL_NUMERO)
);

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_PK                                   */
/*==============================================================*/
create unique clustered index SOLICITUD_COMPRA_PK on SOLICITUD_COMPRA (
SOL_NUMERO ASC
);

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_EMPLEADO_FK                          */
/*==============================================================*/
create index SOLICITUD_COMPRA_EMPLEADO_FK on SOLICITUD_COMPRA (
EMP_ID ASC
);

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_AREA_FK                              */
/*==============================================================*/
create index SOLICITUD_COMPRA_AREA_FK on SOLICITUD_COMPRA (
ARE_ID ASC
);

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO_FK              */
/*==============================================================*/
create index SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO_FK on SOLICITUD_COMPRA (
RUB_CODIGO ASC
);

/*==============================================================*/
/* Table: STOCK                                                 */
/*==============================================================*/
create table STOCK 
(
   STO_ID               integer                        not null,
   BIEN_ID              integer                        not null,
   STO_CANTIDAD         numeric(10,2)                  null,
   constraint PK_STOCK primary key clustered (STO_ID)
);

/*==============================================================*/
/* Index: STOCK_PK                                              */
/*==============================================================*/
create unique clustered index STOCK_PK on STOCK (
STO_ID ASC
);

/*==============================================================*/
/* Index: BIENES_STOCK_FK                                       */
/*==============================================================*/
create index BIENES_STOCK_FK on STOCK (
BIEN_ID ASC
);

alter table BIENES
   add constraint FK_BIENES_PROVEEDOR_PROVEEDO foreign key (PRO_ID)
      references PROVEEDOR (PRO_ID)
      on update restrict
      on delete restrict;

alter table CARGO
   add constraint FK_CARGO_CARGO_ARE_AREA foreign key (ARE_ID)
      references AREA (ARE_ID)
      on update restrict
      on delete restrict;

alter table DETALLE_ORDEN
   add constraint FK_DETALLE__DETALLE_O_ITEM_SOL foreign key (SOL_NUMERO, BIEN_ID)
      references ITEM_SOLICITUD (SOL_NUMERO, BIEN_ID)
      on update restrict
      on delete restrict;

alter table DETALLE_ORDEN
   add constraint FK_DETALLE__DETALLE_O_ORDEN_CO foreign key (ORD_NUMERO)
      references ORDEN_CONTRACTUAL (ORD_NUMERO)
      on update restrict
      on delete restrict;

alter table EMPLEADO
   add constraint FK_EMPLEADO_EMPLEADO__CARGO foreign key (CAR_ID)
      references CARGO (CAR_ID)
      on update restrict
      on delete restrict;

alter table EMPLEADO
   add constraint FK_EMPLEADO_EMPLEADO__ESTADO_C foreign key (EST_ID)
      references ESTADO_CIVIL (EST_ID)
      on update restrict
      on delete restrict;

alter table EMPLEADO
   add constraint FK_EMPLEADO_EMPLEADO__SEXO foreign key (SEX_ID)
      references SEXO (SEX_ID)
      on update restrict
      on delete restrict;

alter table ITEM_ENTRADA
   add constraint FK_ITEM_ENT_BIENES_IT_BIENES foreign key (BIEN_ID)
      references BIENES (BIEN_ID)
      on update restrict
      on delete restrict;

alter table ITEM_ENTRADA
   add constraint FK_ITEM_ENT_ITEM_ENTR_ENTRADA_ foreign key (ENT_NUMERO)
      references ENTRADA_ALMACEN (ENT_NUMERO)
      on update restrict
      on delete restrict;

alter table ITEM_SALIDA
   add constraint FK_ITEM_SAL_BIENES_IT_BIENES foreign key (BIEN_ID)
      references BIENES (BIEN_ID)
      on update restrict
      on delete restrict;

alter table ITEM_SALIDA
   add constraint FK_ITEM_SAL_ITEM_SALI_EMPLEADO foreign key (EMP_ID)
      references EMPLEADO (EMP_ID)
      on update restrict
      on delete restrict;

alter table ITEM_SALIDA
   add constraint FK_ITEM_SAL_SALIDA_AL_SALIDA_A foreign key (SAL_NUMERO)
      references SALIDA_ALMACEN (SAL_NUMERO)
      on update restrict
      on delete restrict;

alter table ITEM_SOLICITUD
   add constraint FK_ITEM_SOL_BIENES_IT_BIENES foreign key (BIEN_ID)
      references BIENES (BIEN_ID)
      on update restrict
      on delete restrict;

alter table ITEM_SOLICITUD
   add constraint FK_ITEM_SOL_SOLICITUD_SOLICITU foreign key (SOL_NUMERO)
      references SOLICITUD_COMPRA (SOL_NUMERO)
      on update restrict
      on delete restrict;

alter table ORDEN_CONTRACTUAL
   add constraint FK_ORDEN_CO_ORDEN_PRO_PROVEEDO foreign key (PRO_ID)
      references PROVEEDOR (PRO_ID)
      on update restrict
      on delete restrict;

alter table SALIDA_ALMACEN
   add constraint FK_SALIDA_A_SALIDA_EM_EMPLEADO foreign key (EMP_ID)
      references EMPLEADO (EMP_ID)
      on update restrict
      on delete restrict;

alter table SOLICITUD_COMPRA
   add constraint FK_SOLICITU_SOLICITUD_AREA foreign key (ARE_ID)
      references AREA (ARE_ID)
      on update restrict
      on delete restrict;

alter table SOLICITUD_COMPRA
   add constraint FK_SOLICITU_SOLICITUD_EMPLEADO foreign key (EMP_ID)
      references EMPLEADO (EMP_ID)
      on update restrict
      on delete restrict;

alter table SOLICITUD_COMPRA
   add constraint FK_SOLICITU_SOLICITUD_RUBRO_PR foreign key (RUB_CODIGO)
      references RUBRO_PRESUPUESTARIO (RUB_CODIGO)
      on update restrict
      on delete restrict;

alter table STOCK
   add constraint FK_STOCK_BIENES_ST_BIENES foreign key (BIEN_ID)
      references BIENES (BIEN_ID)
      on update restrict
      on delete restrict;


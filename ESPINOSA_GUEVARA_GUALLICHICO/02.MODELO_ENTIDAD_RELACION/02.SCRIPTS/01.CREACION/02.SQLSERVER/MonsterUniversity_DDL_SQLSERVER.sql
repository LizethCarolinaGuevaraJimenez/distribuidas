/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     4/20/2019 1:24:47 AM                         */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AEITE_ITEENT') and o.name = 'FK_AEITE_ITE_BIENES_ITE_MEBIE_BI')
alter table AEITE_ITEENT
   drop constraint FK_AEITE_ITE_BIENES_ITE_MEBIE_BI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AEITE_ITEENT') and o.name = 'FK_AEITE_IT_ITEM_ENTR_AEENT_EN')
alter table AEITE_ITEENT
   drop constraint FK_AEITE_IT_ITEM_ENTR_AEENT_EN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AEITE_ITESAL') and o.name = 'FK_AEITE_ITS_BIENES_ITS_MEBIE_BI')
alter table AEITE_ITESAL
   drop constraint FK_AEITE_ITS_BIENES_ITS_MEBIE_BI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AEITE_ITESAL') and o.name = 'FK_AEITE_IT_ITEM_SALI_PEEMP_EM')
alter table AEITE_ITESAL
   drop constraint FK_AEITE_IT_ITEM_SALI_PEEMP_EM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AEITE_ITESAL') and o.name = 'FK_AEITE_IT_SALIDA_AL_AESAL_SA')
alter table AEITE_ITESAL
   drop constraint FK_AEITE_IT_SALIDA_AL_AESAL_SA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AESAL_SALALM') and o.name = 'FK_AESAL_SA_SALIDA_EM_PEEMP_EM')
alter table AESAL_SALALM
   drop constraint FK_AESAL_SA_SALIDA_EM_PEEMP_EM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AESTO_STOCK') and o.name = 'FK_AESTO_ST_BIENES_ST_MEBIE_BI')
alter table AESTO_STOCK
   drop constraint FK_AESTO_ST_BIENES_ST_MEBIE_BI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CEITE_ITESOL') and o.name = 'FK_CEITE_IT_BIENES_IT_MEBIE_BI')
alter table CEITE_ITESOL
   drop constraint FK_CEITE_IT_BIENES_IT_MEBIE_BI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CEITE_ITESOL') and o.name = 'FK_CEITE_IT_SOLICITUD_CESOL_SO')
alter table CEITE_ITESOL
   drop constraint FK_CEITE_IT_SOLICITUD_CESOL_SO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CEORD_ORDCON') and o.name = 'FK_CEORD_OR_ORDEN_PRO_AEPRO_PR')
alter table CEORD_ORDCON
   drop constraint FK_CEORD_OR_ORDEN_PRO_AEPRO_PR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CESOL_SOLCOM') and o.name = 'FK_CESOL_SO_SOLICITUD_PEARE_AR')
alter table CESOL_SOLCOM
   drop constraint FK_CESOL_SO_SOLICITUD_PEARE_AR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CESOL_SOLCOM') and o.name = 'FK_CESOL_SO_SOLICITUD_PEEMP_EM')
alter table CESOL_SOLCOM
   drop constraint FK_CESOL_SO_SOLICITUD_PEEMP_EM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CESOL_SOLCOM') and o.name = 'FK_CESOL_SO_SOLICITUD_CERUB_RU')
alter table CESOL_SOLCOM
   drop constraint FK_CESOL_SO_SOLICITUD_CERUB_RU
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEBIE_BIENES') and o.name = 'FK_MEBIE_BI_PROVEEDOR_AEPRO_PR')
alter table MEBIE_BIENES
   drop constraint FK_MEBIE_BI_PROVEEDOR_AEPRO_PR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEDET_DETORD') and o.name = 'FK_MEDET_DE_DETALLE_O_CEITE_IT')
alter table MEDET_DETORD
   drop constraint FK_MEDET_DE_DETALLE_O_CEITE_IT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEDET_DETORD') and o.name = 'FK_MEDET_DE_DETALLE_O_CEORD_OR')
alter table MEDET_DETORD
   drop constraint FK_MEDET_DE_DETALLE_O_CEORD_OR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PECAR_CARGO') and o.name = 'FK_PECAR_CA_CARGO_ARE_PEARE_AR')
alter table PECAR_CARGO
   drop constraint FK_PECAR_CA_CARGO_ARE_PEARE_AR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PEEMP_EMPLEADO') and o.name = 'FK_PEEMP_EM_EMPLEADO__PECAR_CA')
alter table PEEMP_EMPLEADO
   drop constraint FK_PEEMP_EM_EMPLEADO__PECAR_CA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PEEMP_EMPLEADO') and o.name = 'FK_PEEMP_EM_EMPLEADO__PEEST_ES')
alter table PEEMP_EMPLEADO
   drop constraint FK_PEEMP_EM_EMPLEADO__PEEST_ES
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PEEMP_EMPLEADO') and o.name = 'FK_PEEMP_EM_EMPLEADO__PESEX_SE')
alter table PEEMP_EMPLEADO
   drop constraint FK_PEEMP_EM_EMPLEADO__PESEX_SE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SEOPC_OPCION') and o.name = 'FK_SEOPC_OP_XR_XESIS__SESIS_SI')
alter table SEOPC_OPCION
   drop constraint FK_SEOPC_OP_XR_XESIS__SESIS_SI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SEOPC_OPCPER') and o.name = 'FK_SEOPC_OP_SEOPC_OPC_SEOPC_OP')
alter table SEOPC_OPCPER
   drop constraint FK_SEOPC_OP_SEOPC_OPC_SEOPC_OP
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SEOPC_OPCPER') and o.name = 'FK_SEOPC_OP_SEOPC_OPC_SEPER_PE')
alter table SEOPC_OPCPER
   drop constraint FK_SEOPC_OP_SEOPC_OPC_SEPER_PE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SEROL_ROL') and o.name = 'FK_SEROL_RO_XR_XEPER__SEPER_PE')
alter table SEROL_ROL
   drop constraint FK_SEROL_RO_XR_XEPER__SEPER_PE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SESIS_SISTEM') and o.name = 'FK_SESIS_SI_XR_XEEST__SEEST_ES')
alter table SESIS_SISTEM
   drop constraint FK_SESIS_SI_XR_XEEST__SEEST_ES
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SEUSU_USAPER') and o.name = 'FK_SEUSU_US_SEUSU_USA_SEPER_PE')
alter table SEUSU_USAPER
   drop constraint FK_SEUSU_US_SEUSU_USA_SEPER_PE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SEUSU_USAPER') and o.name = 'FK_SEUSU_US_SEUSU_USA_SEUSU_US')
alter table SEUSU_USAPER
   drop constraint FK_SEUSU_US_SEUSU_USA_SEUSU_US
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SEUSU_USUARI') and o.name = 'FK_SEUSU_US_XE_PEEMP__PEEMP_EM')
alter table SEUSU_USUARI
   drop constraint FK_SEUSU_US_XE_PEEMP__PEEMP_EM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SEUSU_USUARI') and o.name = 'FK_SEUSU_US_XR_XEEST__SEEST_ES')
alter table SEUSU_USUARI
   drop constraint FK_SEUSU_US_XR_XEEST__SEEST_ES
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SEVEN_VENTAN') and o.name = 'FK_SEVEN_VE_XR_XEOPC__SEOPC_OP')
alter table SEVEN_VENTAN
   drop constraint FK_SEVEN_VE_XR_XEOPC__SEOPC_OP
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AEENT_ENTALM')
            and   type = 'U')
   drop table AEENT_ENTALM
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('AEITE_ITEENT')
            and   name  = 'ITEM_ENTRADA_ENTRADA_FK'
            and   indid > 0
            and   indid < 255)
   drop index AEITE_ITEENT.ITEM_ENTRADA_ENTRADA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('AEITE_ITEENT')
            and   name  = 'BIENES_ITEM_ENTRADA_ALMACEN_FK'
            and   indid > 0
            and   indid < 255)
   drop index AEITE_ITEENT.BIENES_ITEM_ENTRADA_ALMACEN_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AEITE_ITEENT')
            and   type = 'U')
   drop table AEITE_ITEENT
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('AEITE_ITESAL')
            and   name  = 'ITEM_SALIDA_EMPLEADO_FK'
            and   indid > 0
            and   indid < 255)
   drop index AEITE_ITESAL.ITEM_SALIDA_EMPLEADO_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('AEITE_ITESAL')
            and   name  = 'BIENES_ITEM_SALIDA_FK'
            and   indid > 0
            and   indid < 255)
   drop index AEITE_ITESAL.BIENES_ITEM_SALIDA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('AEITE_ITESAL')
            and   name  = 'SALIDA_ALMACEN_ITEM_SALIDA_FK'
            and   indid > 0
            and   indid < 255)
   drop index AEITE_ITESAL.SALIDA_ALMACEN_ITEM_SALIDA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AEITE_ITESAL')
            and   type = 'U')
   drop table AEITE_ITESAL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AEPRO_PROVEEDOR')
            and   type = 'U')
   drop table AEPRO_PROVEEDOR
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('AESAL_SALALM')
            and   name  = 'SALIDA_EMPLEADO_FK'
            and   indid > 0
            and   indid < 255)
   drop index AESAL_SALALM.SALIDA_EMPLEADO_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AESAL_SALALM')
            and   type = 'U')
   drop table AESAL_SALALM
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('AESTO_STOCK')
            and   name  = 'BIENES_STOCK_FK'
            and   indid > 0
            and   indid < 255)
   drop index AESTO_STOCK.BIENES_STOCK_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AESTO_STOCK')
            and   type = 'U')
   drop table AESTO_STOCK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CEITE_ITESOL')
            and   name  = 'BIENES_ITEM_SOLICITUD_FK'
            and   indid > 0
            and   indid < 255)
   drop index CEITE_ITESOL.BIENES_ITEM_SOLICITUD_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CEITE_ITESOL')
            and   name  = 'SOLICITUD_COMPRA_ITEM_SOLICITUD_FK'
            and   indid > 0
            and   indid < 255)
   drop index CEITE_ITESOL.SOLICITUD_COMPRA_ITEM_SOLICITUD_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CEITE_ITESOL')
            and   type = 'U')
   drop table CEITE_ITESOL
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CEORD_ORDCON')
            and   name  = 'ORDEN_PROVEEDOR_FK'
            and   indid > 0
            and   indid < 255)
   drop index CEORD_ORDCON.ORDEN_PROVEEDOR_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CEORD_ORDCON')
            and   type = 'U')
   drop table CEORD_ORDCON
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CERUB_RUBPRE')
            and   type = 'U')
   drop table CERUB_RUBPRE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CESOL_SOLCOM')
            and   name  = 'SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO_FK'
            and   indid > 0
            and   indid < 255)
   drop index CESOL_SOLCOM.SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CESOL_SOLCOM')
            and   name  = 'SOLICITUD_COMPRA_AREA_FK'
            and   indid > 0
            and   indid < 255)
   drop index CESOL_SOLCOM.SOLICITUD_COMPRA_AREA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CESOL_SOLCOM')
            and   name  = 'SOLICITUD_COMPRA_EMPLEADO_FK'
            and   indid > 0
            and   indid < 255)
   drop index CESOL_SOLCOM.SOLICITUD_COMPRA_EMPLEADO_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CESOL_SOLCOM')
            and   type = 'U')
   drop table CESOL_SOLCOM
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MEBIE_BIENES')
            and   name  = 'PROVEEDOR_BIENES_FK'
            and   indid > 0
            and   indid < 255)
   drop index MEBIE_BIENES.PROVEEDOR_BIENES_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MEBIE_BIENES')
            and   type = 'U')
   drop table MEBIE_BIENES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MEDET_DETORD')
            and   name  = 'DETALLE_ORDEN_FK'
            and   indid > 0
            and   indid < 255)
   drop index MEDET_DETORD.DETALLE_ORDEN_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MEDET_DETORD')
            and   name  = 'DETALLE_ORDEN2_FK'
            and   indid > 0
            and   indid < 255)
   drop index MEDET_DETORD.DETALLE_ORDEN2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MEDET_DETORD')
            and   type = 'U')
   drop table MEDET_DETORD
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PEARE_AREA')
            and   type = 'U')
   drop table PEARE_AREA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PECAR_CARGO')
            and   name  = 'CARGO_AREA_FK'
            and   indid > 0
            and   indid < 255)
   drop index PECAR_CARGO.CARGO_AREA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PECAR_CARGO')
            and   type = 'U')
   drop table PECAR_CARGO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PEEMP_EMPLEADO')
            and   name  = 'EMPLEADO_ESTADO_CIVIL_FK'
            and   indid > 0
            and   indid < 255)
   drop index PEEMP_EMPLEADO.EMPLEADO_ESTADO_CIVIL_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PEEMP_EMPLEADO')
            and   name  = 'EMPLEADO_SEXO_FK'
            and   indid > 0
            and   indid < 255)
   drop index PEEMP_EMPLEADO.EMPLEADO_SEXO_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PEEMP_EMPLEADO')
            and   name  = 'EMPLEADO_CARGO_FK'
            and   indid > 0
            and   indid < 255)
   drop index PEEMP_EMPLEADO.EMPLEADO_CARGO_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PEEMP_EMPLEADO')
            and   type = 'U')
   drop table PEEMP_EMPLEADO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PEEST_ESTCIV')
            and   type = 'U')
   drop table PEEST_ESTCIV
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PESEX_SEXO')
            and   type = 'U')
   drop table PESEX_SEXO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SEEST_ESTADO')
            and   type = 'U')
   drop table SEEST_ESTADO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SEOPC_OPCION')
            and   name  = 'XR_XESIS_XEOPC_FK'
            and   indid > 0
            and   indid < 255)
   drop index SEOPC_OPCION.XR_XESIS_XEOPC_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SEOPC_OPCION')
            and   type = 'U')
   drop table SEOPC_OPCION
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SEOPC_OPCPER')
            and   name  = 'SEOPC_OPCPER_FK'
            and   indid > 0
            and   indid < 255)
   drop index SEOPC_OPCPER.SEOPC_OPCPER_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SEOPC_OPCPER')
            and   name  = 'SEOPC_OPCPER2_FK'
            and   indid > 0
            and   indid < 255)
   drop index SEOPC_OPCPER.SEOPC_OPCPER2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SEOPC_OPCPER')
            and   type = 'U')
   drop table SEOPC_OPCPER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SEPER_PERFIL')
            and   type = 'U')
   drop table SEPER_PERFIL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SEROL_ROL')
            and   type = 'U')
   drop table SEROL_ROL
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SESIS_SISTEM')
            and   name  = 'XR_XEEST_XESIS_FK'
            and   indid > 0
            and   indid < 255)
   drop index SESIS_SISTEM.XR_XEEST_XESIS_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SESIS_SISTEM')
            and   type = 'U')
   drop table SESIS_SISTEM
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SEUSU_USAPER')
            and   name  = 'SEUSU_USAPER_FK'
            and   indid > 0
            and   indid < 255)
   drop index SEUSU_USAPER.SEUSU_USAPER_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SEUSU_USAPER')
            and   name  = 'SEUSU_USAPER2_FK'
            and   indid > 0
            and   indid < 255)
   drop index SEUSU_USAPER.SEUSU_USAPER2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SEUSU_USAPER')
            and   type = 'U')
   drop table SEUSU_USAPER
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SEUSU_USUARI')
            and   name  = 'XR_XEEST_XEUSU_FK'
            and   indid > 0
            and   indid < 255)
   drop index SEUSU_USUARI.XR_XEEST_XEUSU_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SEUSU_USUARI')
            and   type = 'U')
   drop table SEUSU_USUARI
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SEVEN_VENTAN')
            and   name  = 'XR_XEOPC_XEVEN_FK'
            and   indid > 0
            and   indid < 255)
   drop index SEVEN_VENTAN.XR_XEOPC_XEVEN_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SEVEN_VENTAN')
            and   type = 'U')
   drop table SEVEN_VENTAN
go

/*==============================================================*/
/* Table: ENTRADA AL ALMACEN                                    */
/*==============================================================*/
create table AEENT_ENTALM (
   ENT_NUMERO           int                  not null,
   ENT_FECHA            datetime             null,
   ENT_NUMEROFACTURA    int                  null,
   ENT_TOTALBIENES      int                  null,
   ENT_VALORTOTAL       float                null,
   constraint PK_AEENT_ENTALM primary key (ENT_NUMERO)
)
go

/*==============================================================*/
/* Table: ITEM DE ENTRADA                                       */
/*==============================================================*/
create table AEITE_ITEENT (
   BIEN_ID              int                  not null,
   ENT_NUMERO           int                  not null,
   ITEE_CANTIDADENTREGADA int                  null,
   constraint PK_AEITE_ITEENT primary key (BIEN_ID, ENT_NUMERO)
)
go

/*==============================================================*/
/* Index: BIENES_ITEM_ENTRADA_ALMACEN_FK                        */
/*==============================================================*/




create nonclustered index BIENES_ITEM_ENTRADA_ALMACEN_FK on AEITE_ITEENT (BIEN_ID ASC)
go

/*==============================================================*/
/* Index: ITEM_ENTRADA_ENTRADA_FK                               */
/*==============================================================*/




create nonclustered index ITEM_ENTRADA_ENTRADA_FK on AEITE_ITEENT (ENT_NUMERO ASC)
go

/*==============================================================*/
/* Table: ITEM DE SALIDA                                        */
/*==============================================================*/
create table AEITE_ITESAL (
   SAL_NUMERO           int                  not null,
   BIEN_ID              int                  not null,
   EMP_ID               int                  not null,
   ITESA_CANTIDADENTREGADA int                  null,
   constraint PK_AEITE_ITESAL primary key (SAL_NUMERO, BIEN_ID, EMP_ID)
)
go

/*==============================================================*/
/* Index: SALIDA_ALMACEN_ITEM_SALIDA_FK                         */
/*==============================================================*/




create nonclustered index SALIDA_ALMACEN_ITEM_SALIDA_FK on AEITE_ITESAL (SAL_NUMERO ASC)
go

/*==============================================================*/
/* Index: BIENES_ITEM_SALIDA_FK                                 */
/*==============================================================*/




create nonclustered index BIENES_ITEM_SALIDA_FK on AEITE_ITESAL (BIEN_ID ASC)
go

/*==============================================================*/
/* Index: ITEM_SALIDA_EMPLEADO_FK                               */
/*==============================================================*/




create nonclustered index ITEM_SALIDA_EMPLEADO_FK on AEITE_ITESAL (EMP_ID ASC)
go

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table AEPRO_PROVEEDOR (
   PRO_ID               int                  not null,
   PRO_RUC              int                  null,
   PRO_NOMBRE           varchar(100)         null,
   PRO_TELEFONO         varchar(10)          null,
   PRO_DIRECCION        varchar(200)         null,
   constraint PK_AEPRO_PROVEEDOR primary key (PRO_ID)
)
go

/*==============================================================*/
/* Table: SALIDA DEL ALMACEN                                    */
/*==============================================================*/
create table AESAL_SALALM (
   SAL_NUMERO           int                  not null,
   EMP_ID               int                  not null,
   SAL_FECHASALIDA      datetime             null,
   SAL_FECHAENTREGA     datetime             null,
   constraint PK_AESAL_SALALM primary key (SAL_NUMERO)
)
go

/*==============================================================*/
/* Index: SALIDA_EMPLEADO_FK                                    */
/*==============================================================*/




create nonclustered index SALIDA_EMPLEADO_FK on AESAL_SALALM (EMP_ID ASC)
go

/*==============================================================*/
/* Table: STOCK                                                 */
/*==============================================================*/
create table AESTO_STOCK (
   STO_ID               int                  not null,
   BIEN_ID              int                  not null,
   STO_CANTIDAD         numeric(10,2)        null,
   constraint PK_AESTO_STOCK primary key (STO_ID)
)
go

/*==============================================================*/
/* Index: BIENES_STOCK_FK                                       */
/*==============================================================*/




create nonclustered index BIENES_STOCK_FK on AESTO_STOCK (BIEN_ID ASC)
go

/*==============================================================*/
/* Table: ITEM DE SOLICITUD                                     */
/*==============================================================*/
create table CEITE_ITESOL (
   SOL_NUMERO           int                  not null,
   BIEN_ID              int                  not null,
   ITES_CANTIDADSOLICITADA int                  null,
   ITES_CANTIDADDESPACHADA int                  null,
   ITES_VALORTOTAL      float                null,
   constraint PK_CEITE_ITESOL primary key (SOL_NUMERO, BIEN_ID)
)
go

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_ITEM_SOLICITUD_FK                    */
/*==============================================================*/




create nonclustered index SOLICITUD_COMPRA_ITEM_SOLICITUD_FK on CEITE_ITESOL (SOL_NUMERO ASC)
go

/*==============================================================*/
/* Index: BIENES_ITEM_SOLICITUD_FK                              */
/*==============================================================*/




create nonclustered index BIENES_ITEM_SOLICITUD_FK on CEITE_ITESOL (BIEN_ID ASC)
go

/*==============================================================*/
/* Table: ORDEN CONTRACTUAL                                     */
/*==============================================================*/
create table CEORD_ORDCON (
   ORD_NUMERO           int                  not null,
   PRO_ID               int                  not null,
   ORD_FECHAORDEN       datetime             null,
   ORD_FECHAENTREGA     datetime             null,
   ORD_MONTOTOTAL       float                null,
   ORD_APROVACIONDIRECTORFINANCIERO bit                  null,
   constraint PK_CEORD_ORDCON primary key (ORD_NUMERO)
)
go

/*==============================================================*/
/* Index: ORDEN_PROVEEDOR_FK                                    */
/*==============================================================*/




create nonclustered index ORDEN_PROVEEDOR_FK on CEORD_ORDCON (PRO_ID ASC)
go

/*==============================================================*/
/* Table: RUBRO PRESUPUESTARIO                                  */
/*==============================================================*/
create table CERUB_RUBPRE (
   RUB_CODIGO           int                  not null,
   RUB_CATEGORIA        varchar(100)         null,
   RUB_PRESUPUESTO      float                null,
   constraint PK_CERUB_RUBPRE primary key (RUB_CODIGO)
)
go

/*==============================================================*/
/* Table: SOLICITUD DE COMPRA                                   */
/*==============================================================*/
create table CESOL_SOLCOM (
   SOL_NUMERO           int                  not null,
   EMP_ID               int                  not null,
   ARE_ID               int                  not null,
   RUB_CODIGO           int                  not null,
   SOL_FECHA            datetime             null,
   SOL_APROBACIONDIRECTORFINANCIERO bit                  null,
   SOL_APROBACIONJEFEAREA bit                  null,
   SOL_TOTAL            float                null,
   constraint PK_CESOL_SOLCOM primary key (SOL_NUMERO)
)
go

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_EMPLEADO_FK                          */
/*==============================================================*/




create nonclustered index SOLICITUD_COMPRA_EMPLEADO_FK on CESOL_SOLCOM (EMP_ID ASC)
go

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_AREA_FK                              */
/*==============================================================*/




create nonclustered index SOLICITUD_COMPRA_AREA_FK on CESOL_SOLCOM (ARE_ID ASC)
go

/*==============================================================*/
/* Index: SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO_FK              */
/*==============================================================*/




create nonclustered index SOLICITUD_COMPRA_RUBRO_PRESUPUESTARIO_FK on CESOL_SOLCOM (RUB_CODIGO ASC)
go

/*==============================================================*/
/* Table: BIENES                                                */
/*==============================================================*/
create table MEBIE_BIENES (
   BIEN_ID              int                  not null,
   PRO_ID               int                  not null,
   BIEN_NOMBRE          varchar(100)         null,
   BIEN_UNIDADMEDIDA    varchar(100)         null,
   BIEN_TIPO            varchar(100)         null,
   constraint PK_MEBIE_BIENES primary key (BIEN_ID)
)
go

/*==============================================================*/
/* Index: PROVEEDOR_BIENES_FK                                   */
/*==============================================================*/




create nonclustered index PROVEEDOR_BIENES_FK on MEBIE_BIENES (PRO_ID ASC)
go

/*==============================================================*/
/* Table: DETALLE DE ORDEN                                      */
/*==============================================================*/
create table MEDET_DETORD (
   SOL_NUMERO           int                  not null,
   BIEN_ID              int                  not null,
   ORD_NUMERO           int                  not null,
   constraint PK_MEDET_DETORD primary key (SOL_NUMERO, BIEN_ID, ORD_NUMERO)
)
go

/*==============================================================*/
/* Index: DETALLE_ORDEN2_FK                                     */
/*==============================================================*/




create nonclustered index DETALLE_ORDEN2_FK on MEDET_DETORD (ORD_NUMERO ASC)
go

/*==============================================================*/
/* Index: DETALLE_ORDEN_FK                                      */
/*==============================================================*/




create nonclustered index DETALLE_ORDEN_FK on MEDET_DETORD (SOL_NUMERO ASC,
  BIEN_ID ASC)
go

/*==============================================================*/
/* Table: AREA                                                  */
/*==============================================================*/
create table PEARE_AREA (
   ARE_ID               int                  not null,
   ARE_NOMBRE           varchar(100)         null,
   ARE_UBICACION        varchar(100)         null,
   constraint PK_PEARE_AREA primary key (ARE_ID)
)
go

/*==============================================================*/
/* Table: CARGO                                                 */
/*==============================================================*/
create table PECAR_CARGO (
   CAR_ID               int                  not null,
   ARE_ID               int                  not null,
   CAR_NOMBRE           varchar(100)         not null,
   CAR_DETALLES         varchar(500)         not null,
   constraint PK_PECAR_CARGO primary key (CAR_ID)
)
go

/*==============================================================*/
/* Index: CARGO_AREA_FK                                         */
/*==============================================================*/




create nonclustered index CARGO_AREA_FK on PECAR_CARGO (ARE_ID ASC)
go

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table PEEMP_EMPLEADO (
   EMP_ID               int                  not null,
   CAR_ID               int                  not null,
   SEX_ID               int                  not null,
   EST_ID               int                  not null,
   EMP_CEDULA           int                  null,
   EMP_NOMBRE           varchar(100)         null,
   EMP_TELEFONO         varchar(10)          null,
   constraint PK_PEEMP_EMPLEADO primary key (EMP_ID)
)
go

/*==============================================================*/
/* Index: EMPLEADO_CARGO_FK                                     */
/*==============================================================*/




create nonclustered index EMPLEADO_CARGO_FK on PEEMP_EMPLEADO (CAR_ID ASC)
go

/*==============================================================*/
/* Index: EMPLEADO_SEXO_FK                                      */
/*==============================================================*/




create nonclustered index EMPLEADO_SEXO_FK on PEEMP_EMPLEADO (SEX_ID ASC)
go

/*==============================================================*/
/* Index: EMPLEADO_ESTADO_CIVIL_FK                              */
/*==============================================================*/




create nonclustered index EMPLEADO_ESTADO_CIVIL_FK on PEEMP_EMPLEADO (EST_ID ASC)
go

/*==============================================================*/
/* Table: ESTADO CIVIL                                          */
/*==============================================================*/
create table PEEST_ESTCIV (
   EST_ID               int                  not null,
   constraint PK_PEEST_ESTCIV primary key (EST_ID)
)
go

/*==============================================================*/
/* Table: SEXO                                                  */
/*==============================================================*/
create table PESEX_SEXO (
   SEX_ID               int                  not null,
   SEX_DESCRIPCION      varchar(30)          not null,
   constraint PK_PESEX_SEXO primary key (SEX_ID)
)
go

/*==============================================================*/
/* Table: ESTADO                                                */
/*==============================================================*/
create table SEEST_ESTADO (
   EST_CODIGO           char(10)             not null,
   constraint PK_SEEST_ESTADO primary key (EST_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('SEEST_ESTADO') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'SEEST_ESTADO' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad de estado, modelo lógico de seguridades.', 
   'user', @CurrentUser, 'table', 'SEEST_ESTADO'
go

/*==============================================================*/
/* Table: OPCION                                                */
/*==============================================================*/
create table SEOPC_OPCION (
   OPC_CODIGO           char(10)             not null,
   SIS_CODIGO           char(10)             not null,
   OPC_DESCRIPCION      varchar(100)         not null,
   constraint PK_SEOPC_OPCION primary key (OPC_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('SEOPC_OPCION') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'SEOPC_OPCION' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad de opción, modelo lógico de seguridades.', 
   'user', @CurrentUser, 'table', 'SEOPC_OPCION'
go

/*==============================================================*/
/* Index: XR_XESIS_XEOPC_FK                                     */
/*==============================================================*/




create nonclustered index XR_XESIS_XEOPC_FK on SEOPC_OPCION (SIS_CODIGO ASC)
go

/*==============================================================*/
/* Table: OPCION PERFIL                                         */
/*==============================================================*/
create table SEOPC_OPCPER (
   PER_CODIGO           char(10)             not null,
   OPC_CODIGO           char(10)             not null,
   OPCPER_FECHAASIGNACION datetime             not null,
   OPCPER_ESTADO        varchar(50)          not null,
   constraint PK_SEOPC_OPCPER primary key (PER_CODIGO, OPC_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('SEOPC_OPCPER') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'SEOPC_OPCPER' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad de opciones por perfil, modelo lógico de seguridades.', 
   'user', @CurrentUser, 'table', 'SEOPC_OPCPER'
go

/*==============================================================*/
/* Index: SEOPC_OPCPER2_FK                                      */
/*==============================================================*/




create nonclustered index SEOPC_OPCPER2_FK on SEOPC_OPCPER (PER_CODIGO ASC)
go

/*==============================================================*/
/* Index: SEOPC_OPCPER_FK                                       */
/*==============================================================*/




create nonclustered index SEOPC_OPCPER_FK on SEOPC_OPCPER (OPC_CODIGO ASC)
go

/*==============================================================*/
/* Table: PERFIL                                                */
/*==============================================================*/
create table SEPER_PERFIL (
   PER_CODIGO           char(10)             not null,
   PER_DESCRIPCION      varchar(100)         not null,
   PER_OBSERVACION      varchar(100)         not null,
   constraint PK_SEPER_PERFIL primary key (PER_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('SEPER_PERFIL') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'SEPER_PERFIL' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad de perfil, modelo lógico de seguridades.', 
   'user', @CurrentUser, 'table', 'SEPER_PERFIL'
go

/*==============================================================*/
/* Table: ROL                                                   */
/*==============================================================*/
create table SEROL_ROL (
   PER_CODIGO           char(10)             not null,
   ROL_INSERCION        char(5)              not null,
   ROL_ACTUALIZACION    char(5)              not null,
   ROL_ELIMINACION      char(5)              not null,
   ROL_CONSULTA         char(5)              not null,
   constraint PK_SEROL_ROL primary key (PER_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('SEROL_ROL') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'SEROL_ROL' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad de rol, modelo lógico de seguridades.', 
   'user', @CurrentUser, 'table', 'SEROL_ROL'
go

/*==============================================================*/
/* Table: SISTEMA                                               */
/*==============================================================*/
create table SESIS_SISTEM (
   SIS_CODIGO           char(10)             not null,
   EST_CODIGO           char(10)             not null,
   SIS_DESCRIPCION      varchar(100)         not null,
   constraint PK_SESIS_SISTEM primary key (SIS_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('SESIS_SISTEM') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'SESIS_SISTEM' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad de sistema, modelo lógico de seguridades.', 
   'user', @CurrentUser, 'table', 'SESIS_SISTEM'
go

/*==============================================================*/
/* Index: XR_XEEST_XESIS_FK                                     */
/*==============================================================*/




create nonclustered index XR_XEEST_XESIS_FK on SESIS_SISTEM (EST_CODIGO ASC)
go

/*==============================================================*/
/* Table: USARIO PERFIL                                         */
/*==============================================================*/
create table SEUSU_USAPER (
   EMP_ID               int                  not null,
   PER_CODIGO           char(10)             not null,
   USUPER_FECHAASIGNACION datetime             not null,
   USUPER_FECHACAMBIO   datetime             not null,
   constraint PK_SEUSU_USAPER primary key (EMP_ID, PER_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('SEUSU_USAPER') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'SEUSU_USAPER' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad de usuario por perfil, modelo lógico de seguridades.', 
   'user', @CurrentUser, 'table', 'SEUSU_USAPER'
go

/*==============================================================*/
/* Index: SEUSU_USAPER2_FK                                      */
/*==============================================================*/




create nonclustered index SEUSU_USAPER2_FK on SEUSU_USAPER (EMP_ID ASC)
go

/*==============================================================*/
/* Index: SEUSU_USAPER_FK                                       */
/*==============================================================*/




create nonclustered index SEUSU_USAPER_FK on SEUSU_USAPER (PER_CODIGO ASC)
go

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table SEUSU_USUARI (
   EMP_ID               int                  not null,
   EST_CODIGO           char(10)             not null,
   USU_CONTRASENA       varchar(200)         not null,
   USU_PIEFIRMA         varchar(100)         not null,
   USU_FECHACREACION    datetime             not null,
   USU_FECHAULTIMOCAMBIO datetime             not null,
   constraint PK_SEUSU_USUARI primary key (EMP_ID)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('SEUSU_USUARI') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'SEUSU_USUARI' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad de usuario, modelo lógico de seguridades.', 
   'user', @CurrentUser, 'table', 'SEUSU_USUARI'
go

/*==============================================================*/
/* Index: XR_XEEST_XEUSU_FK                                     */
/*==============================================================*/




create nonclustered index XR_XEEST_XEUSU_FK on SEUSU_USUARI (EST_CODIGO ASC)
go

/*==============================================================*/
/* Table: VENTANA                                               */
/*==============================================================*/
create table SEVEN_VENTAN (
   VEN_CODIGO           char(10)             not null,
   OPC_CODIGO           char(10)             not null,
   VEN_DESCRIPCION      varchar(100)         not null,
   VEN_MENSAJE          varchar(100)         not null,
   constraint PK_SEVEN_VENTAN primary key (VEN_CODIGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('SEVEN_VENTAN') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'SEVEN_VENTAN' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad de ventana, modelo lógico de seguridades.', 
   'user', @CurrentUser, 'table', 'SEVEN_VENTAN'
go

/*==============================================================*/
/* Index: XR_XEOPC_XEVEN_FK                                     */
/*==============================================================*/




create nonclustered index XR_XEOPC_XEVEN_FK on SEVEN_VENTAN (OPC_CODIGO ASC)
go

alter table AEITE_ITEENT
   add constraint FK_AEITE_ITE_BIENES_ITE_MEBIE_BI foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID)
go

alter table AEITE_ITEENT
   add constraint FK_AEITE_IT_ITEM_ENTR_AEENT_EN foreign key (ENT_NUMERO)
      references AEENT_ENTALM (ENT_NUMERO)
go

alter table AEITE_ITESAL
   add constraint FK_AEITE_ITS_BIENES_ITS_MEBIE_BI foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID)
go

alter table AEITE_ITESAL
   add constraint FK_AEITE_IT_ITEM_SALI_PEEMP_EM foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID)
go

alter table AEITE_ITESAL
   add constraint FK_AEITE_IT_SALIDA_AL_AESAL_SA foreign key (SAL_NUMERO)
      references AESAL_SALALM (SAL_NUMERO)
go

alter table AESAL_SALALM
   add constraint FK_AESAL_SA_SALIDA_EM_PEEMP_EM foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID)
go

alter table AESTO_STOCK
   add constraint FK_AESTO_ST_BIENES_ST_MEBIE_BI foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID)
go

alter table CEITE_ITESOL
   add constraint FK_CEITE_IT_BIENES_IT_MEBIE_BI foreign key (BIEN_ID)
      references MEBIE_BIENES (BIEN_ID)
go

alter table CEITE_ITESOL
   add constraint FK_CEITE_IT_SOLICITUD_CESOL_SO foreign key (SOL_NUMERO)
      references CESOL_SOLCOM (SOL_NUMERO)
go

alter table CEORD_ORDCON
   add constraint FK_CEORD_OR_ORDEN_PRO_AEPRO_PR foreign key (PRO_ID)
      references AEPRO_PROVEEDOR (PRO_ID)
go

alter table CESOL_SOLCOM
   add constraint FK_CESOL_SO_SOLICITUD_PEARE_AR foreign key (ARE_ID)
      references PEARE_AREA (ARE_ID)
go

alter table CESOL_SOLCOM
   add constraint FK_CESOL_SO_SOLICITUD_PEEMP_EM foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID)
go

alter table CESOL_SOLCOM
   add constraint FK_CESOL_SO_SOLICITUD_CERUB_RU foreign key (RUB_CODIGO)
      references CERUB_RUBPRE (RUB_CODIGO)
go

alter table MEBIE_BIENES
   add constraint FK_MEBIE_BI_PROVEEDOR_AEPRO_PR foreign key (PRO_ID)
      references AEPRO_PROVEEDOR (PRO_ID)
go

alter table MEDET_DETORD
   add constraint FK_MEDET_DE_DETALLE_O_CEITE_IT foreign key (SOL_NUMERO, BIEN_ID)
      references CEITE_ITESOL (SOL_NUMERO, BIEN_ID)
go

alter table MEDET_DETORD
   add constraint FK_MEDET_DE_DETALLE_O_CEORD_OR foreign key (ORD_NUMERO)
      references CEORD_ORDCON (ORD_NUMERO)
go

alter table PECAR_CARGO
   add constraint FK_PECAR_CA_CARGO_ARE_PEARE_AR foreign key (ARE_ID)
      references PEARE_AREA (ARE_ID)
go

alter table PEEMP_EMPLEADO
   add constraint FK_PEEMP_EM_EMPLEADO__PECAR_CA foreign key (CAR_ID)
      references PECAR_CARGO (CAR_ID)
go

alter table PEEMP_EMPLEADO
   add constraint FK_PEEMP_EM_EMPLEADO__PEEST_ES foreign key (EST_ID)
      references PEEST_ESTCIV (EST_ID)
go

alter table PEEMP_EMPLEADO
   add constraint FK_PEEMP_EM_EMPLEADO__PESEX_SE foreign key (SEX_ID)
      references PESEX_SEXO (SEX_ID)
go

alter table SEOPC_OPCION
   add constraint FK_SEOPC_OP_XR_XESIS__SESIS_SI foreign key (SIS_CODIGO)
      references SESIS_SISTEM (SIS_CODIGO)
go

alter table SEOPC_OPCPER
   add constraint FK_SEOPC_OP_SEOPC_OPC_SEOPC_OP foreign key (OPC_CODIGO)
      references SEOPC_OPCION (OPC_CODIGO)
go

alter table SEOPC_OPCPER
   add constraint FK_SEOPC_OP_SEOPC_OPC_SEPER_PE foreign key (PER_CODIGO)
      references SEPER_PERFIL (PER_CODIGO)
go

alter table SEROL_ROL
   add constraint FK_SEROL_RO_XR_XEPER__SEPER_PE foreign key (PER_CODIGO)
      references SEPER_PERFIL (PER_CODIGO)
go

alter table SESIS_SISTEM
   add constraint FK_SESIS_SI_XR_XEEST__SEEST_ES foreign key (EST_CODIGO)
      references SEEST_ESTADO (EST_CODIGO)
go

alter table SEUSU_USAPER
   add constraint FK_SEUSU_US_SEUSU_USA_SEPER_PE foreign key (PER_CODIGO)
      references SEPER_PERFIL (PER_CODIGO)
go

alter table SEUSU_USAPER
   add constraint FK_SEUSU_US_SEUSU_USA_SEUSU_US foreign key (EMP_ID)
      references SEUSU_USUARI (EMP_ID)
go

alter table SEUSU_USUARI
   add constraint FK_SEUSU_US_XE_PEEMP__PEEMP_EM foreign key (EMP_ID)
      references PEEMP_EMPLEADO (EMP_ID)
go

alter table SEUSU_USUARI
   add constraint FK_SEUSU_US_XR_XEEST__SEEST_ES foreign key (EST_CODIGO)
      references SEEST_ESTADO (EST_CODIGO)
go

alter table SEVEN_VENTAN
   add constraint FK_SEVEN_VE_XR_XEOPC__SEOPC_OP foreign key (OPC_CODIGO)
      references SEOPC_OPCION (OPC_CODIGO)
go


/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     31/07/2017 10:01:54                          */
/*==============================================================*/


drop table if exists CLIENTE;

drop table if exists CUENTA;

drop table if exists MOVIMIENTO;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE
(
   CEDULA               char(13) not null,
   NOMBRE               varchar(50) not null,
   GENERO               varchar(50) not null,
   INGRESO              numeric(15,2) not null,
   primary key (CEDULA)
);

/*==============================================================*/
/* Table: CUENTA                                                */
/*==============================================================*/
create table CUENTA
(
   CODIGO_CUENTA        char(8) not null,
   CEDULA               varchar(13) not null,
   TIPO                 varchar(3) not null default 'aho',
   SALDO                numeric(15,2) not null,
   ESTADO               varchar(3) not null default 'act',
   primary key (CODIGO_CUENTA)
);

/*==============================================================*/
/* Table: MOVIMIENTO                                            */
/*==============================================================*/
create table MOVIMIENTO
(
   CODIGO_MOVIMIENTO    int not null auto_increment,
   CODIGO_CUENTA        varchar(8) not null,
   TIPO                 varchar(3) not null default 'aho',
   FECHA                datetime not null,
   MONTO                numeric(15,2) not null,
   SALDO                numeric(15,2) not null,
   primary key (CODIGO_MOVIMIENTO)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   CODIGO_USUARIO       char(20) not null,
   CLAVE                varchar(20) not null,
   NOMBRE               varchar(50) not null,
   primary key (CODIGO_USUARIO)
);

alter table CUENTA add constraint FK_RELATIONSHIP_1 foreign key (CEDULA)
      references CLIENTE (CEDULA) on delete restrict on update restrict;

alter table MOVIMIENTO add constraint FK_RELATIONSHIP_2 foreign key (CODIGO_CUENTA)
      references CUENTA (CODIGO_CUENTA) on delete restrict on update restrict;


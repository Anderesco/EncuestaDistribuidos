create database Encuesta;

use Encuesta;

create table ALUMNO
(
   ID                   integer                        not null identity(1,1),
   BASE                 integer                        NOT null,
   ESCUELA              varchar(100)                   not null,
   SEXO                 char(1)                        not null,
   CICLO                varchar(10)                    not null,
   constraint PK_ALUMNO primary key clustered (ID)
);

create table DIMENSION
(
   ID                   integer                        not null identity(1,1),
   NOMBRE               varchar(50)                    not null,
   DESCRIPCION          text                           not null,
   constraint PK_DIMENSION primary key clustered (ID)
);

create table PREGUNTAS
(
   ID                   integer                        not null identity(1,1),
   NOMBREPREGUNTA       varchar(500)                   not null,
   DESCRIPCION          text                           not null,
   IDDIMENSION          integer                        not null,
   constraint PK_PREGUNTAS primary key clustered (ID)
);

create table ALUMNOFORMULARIO
(
   ID                   integer                        not null identity(1,1),
   IDALUMNO             integer                        null,
   IDPREGUNTA           integer                        null,
   RESPUESTA            varchar(1)                     null,
   constraint PK_ALUMNOFORMULARIO primary key clustered (ID)
);

alter table ALUMNOFORMULARIO
   add constraint FK_ALUMNOFO_REFERENCE_ALUMNO foreign key (IDALUMNO)
      references ALUMNO (ID);

alter table ALUMNOFORMULARIO
   add constraint FK_ALUMNOFO_REFERENCE_PREGUNTA foreign key (IDPREGUNTA)
      references PREGUNTAS (ID);

alter table PREGUNTAS
   add constraint FK_PREGUNTA_REFERENCE_DIMENSIO foreign key (IDDIMENSION)
      references DIMENSION (ID);
create database manga;

use manga;

create table Rol
(
	ID 					int(11)		not null 	auto_increment,
    NombreRol 			varchar(20)	not null,
    FechaCreacion 		datetime	not null,
    UsuarioCreacion 	int(11)		not null,
    UsuarioModificacion int(11)		not null,
    FechaModificacion	datetime	not null,
    Estado 				boolean 	not null,
    
    primary key (ID)
);

create table UsuarioRol
(
	ID			int(11) 	not null 	auto_increment,
    IDRol		int(11)		not null,
    IDUsuario	int(11)		not null,
    Estado 		boolean 	not null,
    
    primary key (ID)
);

create table Usuario
(
	ID					int(11) 	not null 	auto_increment,
    NombreUsuario		varchar(20)	not null,
    Contrasenia			varchar(20) not null,
    IDPersona			int(11) 	not null,
    UsuarioCreacion 	int(11)		not null,
    FechaCreacion	 	datetime 	not null,
    UsuarioModificacion int(11)		not null,
    FechaModificacion	datetime	not null,
    Estado 				boolean 	not null,
    
    primary key (ID)
    
);

create table Persona
(
	ID					int(11) 	not null 	auto_increment,
    Nombre 				varchar(30) not null,
    ApellidoPaterno 	varchar(30) not null,
    ApellidoMaterno 	varchar(30) not null,
    Email				varchar(30) not null,
    UsuarioCreacion 	int(11)		not null,
    FechaCreacion	 	datetime 	not null,
    UsuarioModificacion int(11)		not null,
    FechaModificacion	datetime	not null,
    Estado 				boolean 	not null,
    
    primary key (ID)
);

create table UsuarioManga
(
	ID			int(11) 	not null 	auto_increment,
    IDUsuario	int(11) 	not null,
    IDManga		int(11) 	not null,
    Estado 		boolean 	not null,
    
    primary key (ID)
);

create table Manga
(
	ID					int(11) 		not null 	auto_increment,
    NombreManga			varchar(100) 	not null,
    NombreManga2 		varchar(100),
    EstadoActual 		boolean 		not null,
    Capitulos 			integer 		not null,
    ImagenPortadaRuta 	varchar(100),
    Descripcion 		text 			not null,
    Autores 			varchar(50) 	not null,
    Anio 				integer 		not null,
    RutaManga 			varchar(100) 	not null,
    UsuarioCreacion 	int(11)			not null,
    FechaCreacion	 	datetime 		not null,
    UsuarioModificacion int(11)			not null,
    FechaModificacion	datetime		not null,
    Estado 				boolean 		not null,
    
    primary key (ID)
);

create table MangaGenero
(
	ID			int(11) 	not null 	auto_increment,
    IDManga		int(11) 	not null,
    IDGenero 	int(11) 	not null,
    Estado 		boolean		not null,
    
    primary key (ID)
);

create table Genero
(
	ID					int(11) 	not null 	auto_increment,
    NombreGenero 		varchar(30) not null,
    UsuarioCreacion 	int(11)		not null,
    FechaCreacion	 	datetime 	not null,
    UsuarioModificacion int(11)		not null,
    FechaModificacion	datetime	not null,
    Estado 				boolean 	not null,
    
    primary key (ID)
);

create table CapituloManga
(
	ID					int(11) 		not null 	auto_increment,
    NumeroCapitulo 		integer 		not null,
    NombreCapitulo 		varchar(100) 	not null,
    IDManga 			int(11) 		not null,
    Path 				varchar(50) 	not null,
    UsuarioCreacion 	int(11)			not null,
    FechaCreacion	 	datetime 		not null,
    UsuarioModificacion int(11)			not null,
    FechaModificacion	datetime		not null,
    Estado 				boolean 		not null,
    
    primary key (ID)
);

create table PaginaManga
(
	ID					int(11) 		not null 	auto_increment,
    NumeroPagina		integer			not null,
    IDCapitulo			int(11) 		not null,
    Path 				varchar(100) 	not null,
    UsuarioCreacion 	int(11)			not null,
    FechaCreacion	 	datetime 		not null,
    UsuarioModificacion int(11)			not null,
    FechaModificacion	datetime		not null,
    Estado 				boolean 		not null,
    
    primary key (ID)
);

alter table UsuarioRol 	  add constraint fk_RolUsuarioRol  		foreign key (IDRol) 	 references Rol(ID);
alter table UsuarioRol 	  add constraint fk_UsuarioRolUsuario  	foreign key (IDUsuario)  references Usuario(ID);
alter table Usuario    	  add constraint fk_UsuarioPersona		foreign key (IDPersona)  references Persona(ID);
alter table UsuarioManga  add constraint fk_UsuarioMangaUsuario foreign key (IDUsuario)	 references Usuario(ID);
alter table UsuarioManga  add constraint fk_MangaUsuarioManga 	foreign key (IDManga) 	 references Manga(ID);
alter table MangaGenero	  add constraint fk_MangaGeneroManga	foreign key (IDManga)	 references Manga(ID);
alter table MangaGenero	  add constraint fk_GeneroMangaGenero 	foreign key (IDGenero)	 references Genero(ID);
alter table CapituloManga add constraint fk_MangaCapituloManga  foreign key (IDManga) 	 references Manga(ID);
alter table PaginaManga   add constraint fk_PaginaCapituloManga foreign key (IDCapitulo) references CapituloManga(ID);

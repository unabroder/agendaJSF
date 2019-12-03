create database agenda;
use agenda;
create table persona(
idpersona int(11) not null primary key auto_increment,
nombre varchar(70) not null,
apellido varchar(70) not null,
email varchar(100) not null,
telefono varchar(20) not null
)ENGINE InnoDB;

create table tipousuario(
idtipo int(11) not null primary key auto_increment,
descripcion varchar(25) not null
)ENGINE InnoDB;

create table usuario(
idusuario int(11) not null primary key auto_increment,
usuario varchar(70) not null,
pass varchar(70) not null,
tipo int(11) not null,
estado boolean not null
)ENGINE InnoDB;

create table categoria(
idcategoria int(11) not null primary key auto_increment,
nombre varchar(50) not null
)ENGINE InnoDB;

create table nota(
idnota int(11) not null primary key auto_increment,
codigopersona int(11) not null,
codigocategoria int(11) not null,
encabezado varchar(70) not null,
cuerpo varchar(70) not null,
fechacreacion date not null,
comentarioadmin varchar(150) not null,
valoracion int(11) not null
 )ENGINE InnoDB;
 
 alter table nota
 add foreign key (codigopersona) references persona(idpersona);
 
 alter table usuario
 add foreign key (tipo) references tipousuario(idtipo);
 
 alter table nota
 add foreign key (codigocategoria) references categoria(idcategoria);
 
 
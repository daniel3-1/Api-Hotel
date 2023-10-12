create table clientes(
	id bigint not null auto_increment,
	nombre varchar(100) not null,
	telefono varchar(100) not null unique,
	email varchar(100) not null,
	documento varchar(100) not null unique,
	primary key(id));
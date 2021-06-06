CREATE DATABASE ProjectSpringBoot;
use ProjectSpringBoot;

create table user(
	id int primary key auto_increment not null,
    ativo bit not null,
    nome varchar(25) not null,
	email varchar(35) not null,
	senha varchar(64) not null
);

create table curso(
	id int primary key not null auto_increment,
	nome varchar(50) not null
);

create table periodo(
	id int primary key  not null auto_increment,
	periodo varchar(10) not null
);

create table endereco(
	id int primary key auto_increment not null,
	cep int(11) not null,
    uf varchar(2) not null,
	cidade varchar(30) not null,
	bairro varchar(30) not null,
	rua varchar(30) not null,
	numero int(5),
	complemento varchar(30)
);

create table info_alunos(
	matricula int primary key auto_increment not null,
    cpf varchar(14),
    nome varchar(50) not null,
    sexo varchar(20) not null,
	data_nasc date not null,
    email varchar(50) not null,
    curso_id int not null,
    periodo_id int not null,
    endereco_id int not null,
    foreign key (endereco_id) references endereco(id),
    foreign key (curso_id) references curso (id),
    foreign key (periodo_id) references periodo (id)
);

alter table info_alunos auto_increment = 2021061401;   
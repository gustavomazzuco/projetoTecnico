create database projetoTecnico;

drop table if exists cliente;

create table cliente(
	id int not null primary key auto_increment,
    nome varchar(100) not null,
    cnpj_cpf varchar(20) not null,
    cep varchar(10) not null,
	rua varchar(50) not null,
	numero int,
    bairro varchar(30) not null,
	cidade varchar(30) not null,
	estado varchar(30) not null,
    telefone varchar(20) not null,
    constraint uk_cnpj_cpf unique (cnpj_cpf)
) engine = innodb;
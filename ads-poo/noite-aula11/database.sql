create database petshop;

use petshop;

create table pet (
	id int auto_increment,
	nome char(50),
	raca char(20),
	peso decimal(4, 1),
	nascimento date,
	primary key(id)
);
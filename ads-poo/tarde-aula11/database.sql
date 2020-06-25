create database petshop;

show databases;

use petshop;

	
create table pet (
	id int AUTO_INCREMENT,
	nome char(50),
	raca char(20),
	peso decimal(5, 1),
	nascimento date,
	primary key(id)
	);
	
desc pet;

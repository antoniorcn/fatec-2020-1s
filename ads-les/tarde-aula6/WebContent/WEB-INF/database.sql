create database teste_login;

use teste_login;

create table tbl_usuarios (
	usuario char(20) primary key,
	nome varchar(100),
	email varchar(100),
	telefone varchar(20),
	password varchar(20),
	perfil varchar(20)
);

INSERT INTO tbl_usuarios VALUES 
('antonio', 'Antonio Carvalho', 
'antoniorcn@hotmail.com', '(11) 12345-3434',
'123456', 'admin');
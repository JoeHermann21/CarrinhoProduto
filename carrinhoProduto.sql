create database lojavirtual;

use lojavirtual;

create table produto(
id serial primary key,
nome varchar(100),
descricao varchar (255),
precoUnitario real,
imagem varchar(100)
);

insert into produto (nome, descricao, precoUnitario, imagem) values ('afuche', 'prercursao', 1030, 'afuche.jpg');
insert into produto (nome, descricao, precoUnitario, imagem) values ('bateria', 'percursao', 1000, 'bateria.jpg');
insert into produto (nome, descricao, precoUnitario, imagem) values ('sax', 'sopro', 1500, 'sax.jpg');
insert into produto (nome, descricao, precoUnitario, imagem) values ('ektaratenor', 'sopro', 1200, 'ektaratenor.jpg');
insert into produto (nome, descricao, precoUnitario, imagem) values ('violao', 'cordas', 3200, 'violao.jpg');

select * from produto;
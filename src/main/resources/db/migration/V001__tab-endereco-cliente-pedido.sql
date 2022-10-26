/* CREATE TABLE endereco (
id_endereco SERIAL PRIMARY KEY, 
cep varchar(9) NOT NULL, 
rua varchar(100) NOT NULL,
bairro varchar(50) NOT NULL,
cidade varchar(30),
numero INTEGER NOT NULL,
complemento varchar(20),
uf varchar(2));

CREATE TABLE cliente (
id_cliente SERIAL PRIMARY KEY,
email varchar(30) NOT NULL,
nome_completo varchar(60) NOT NULL,
cpf varchar(14) NOT NULL,
telefone varchar(11),
data_nascimento DATE, 
id_endereco INTEGER, FOREIGN KEY(id_endereco) REFERENCES endereco(id_endereco));

CREATE TABLE pedido (
id_pedido SERIAL PRIMARY KEY,
data_pedido DATE NOT NULL,
data_entrega DATE, 
data_envio DATE, 
status VARCHAR(20),
id_cliente INTEGER, FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente)); */
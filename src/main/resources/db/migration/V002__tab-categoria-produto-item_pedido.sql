CREATE TABLE categoria (
  id_categoria SERIAL PRIMARY KEY,
  nome varchar(30) NOT NULL, 
  descricao varchar(150));

CREATE TABLE produto (
id_produto SERIAL PRIMARY KEY,
nome varchar(30) NOT NULL,
descricao varchar(100),
qtd_estoque INTEGER NOT NULL,
data_cadastro DATE,
valor_unitario FLOAT NOT NULL, 
imagem bytea,
id_categoria INTEGER, FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria));


CREATE TABLE item_pedido (
id_item_pedido SERIAL PRIMARY KEY,
quantidade INTEGER NOT NULL,
preco_venda INTEGER NOT NULL,
percentual_desconto INTEGER,
valor_bruto INTEGER,
valor_liquido INTEGER,
id_pedido INTEGER, FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
id_produto INTEGER,  FOREIGN KEY (id_produto) REFERENCES produto(id_produto));
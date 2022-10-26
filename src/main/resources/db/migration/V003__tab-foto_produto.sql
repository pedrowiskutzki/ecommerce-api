/* create table foto_produto (
  id_foto_produto bigint not null,
  nome_arquivo varchar(150) not null,
  descricao varchar(150),
  content_type varchar(80) not null,
  tamanho int not null,
  PRIMARY KEY (id_foto_produto),
  CONSTRAINT fk_foto_produto_produto FOREIGN KEY (id_foto_produto) REFERENCES produto (id_produto)
) */
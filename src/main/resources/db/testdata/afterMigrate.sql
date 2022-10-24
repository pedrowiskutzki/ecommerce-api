-- Deletando os dados de testes das tabelas
TRUNCATE TABLE categoria RESTART IDENTITY CASCADE;
TRUNCATE TABLE cliente RESTART IDENTITY CASCADE;
TRUNCATE TABLE endereco RESTART IDENTITY CASCADE;
TRUNCATE TABLE item_pedido RESTART IDENTITY CASCADE;
TRUNCATE TABLE pedido RESTART IDENTITY CASCADE;
TRUNCATE TABLE produto RESTART IDENTITY CASCADE;
TRUNCATE TABLE foto_produto RESTART IDENTITY CASCADE;
/*

-- Inserindo dados na tabela cliente
INSERT INTO cliente (nome_completo, email, telefone, cpf, data_nascimento, id_endereco)
VALUES ('Igor', 'igor@serratec.com', '(21)3108-7070', '123.456.852-45','1991-11-06', 1);
INSERT INTO cliente (nome_completo, email, cpf, data_nascimento, id_endereco)
VALUES ('Paulo', 'paulo@serratec.com', '(22)2222-2565', '173.446.152-67','1999-01-09', 2);
INSERT INTO cliente (nome_completo, email, cpf, data_nascimento, id_endereco)
VALUES ('José', 'jose@serratec.com', '(24)2244-3073', '234.968.481-14','1994-06-23', 1);
INSERT INTO cliente (nome_completo, email, cpf, data_nascimento, id_endereco)
VALUES ('Tiago', 'tiago@serratec.com', '(24)2231-3689', '488.033.574-20','1993-04-13', 2);
INSERT INTO cliente (nome_completo, email, cpf, data_nascimento, id_endereco)
VALUES ('Ana', 'ana@serratec.com', '(24)2248-9854', '265.169.785-33','1996-02-28', 2);


-- Inserindo dados na tabela endereco
INSERT INTO endereco (cep, rua, numero, complemento, bairro, celular, telefone, id_cliente)
VALUES ('25665-500', 'rua Luiz Winter', 87, 'A', 'Duarte da Silveira', '(21)97854-5230', 1);
INSERT INTO endereco (cep, rua, numero, complemento, bairro, celular, telefone, id_cliente)
VALUES ('26200-563', 'rua Visconde de Souza Franco', 41, 'B', 'Alto da Serra', '(22)97181-5060', 2);
INSERT INTO endereco (cep, rua, numero, complemento, bairro, celular, telefone, id_cliente)
VALUES ('36587-703', 'rua Luiz Pelegrini', 702, 'C', 'Cascatinha', '(24)98847-4115', 3);
INSERT INTO endereco (cep, rua, numero, complemento, bairro, celular, telefone, id_cliente)
VALUES ('45210-224', 'rua Bartolomeu Sudre', 421, 'A', 'Caxambu', '(24)99921-6474', 4);
INSERT INTO endereco (cep, rua, numero, complemento, bairro, celular, telefone, id_cliente)
VALUES ('78554-335', 'rua Cândido Portinari', 67, 'B', 'Mosela', '(24)98108-0205', 5);
*/
-- Inserindo dados na tabela categoria
INSERT INTO categoria (nome, descricao)
VALUES ('Teclados', 'Teclados de várias marcas');
INSERT INTO categoria (nome, descricao)
VALUES ('Mouses', 'Mouses de vários modelos e marcas');
INSERT INTO categoria (nome, descricao)
VALUES ('Headset Gamer', 'Headset de vários modelos e marcas (específicos para jogos)');
INSERT INTO categoria (nome, descricao)
VALUES ('Webcam', 'Webcams de alta resolução');
INSERT INTO categoria (nome, descricao)
VALUES ('Gabinetes', 'Gabinetes diversos');
/*
-- Inserindo dados na tabela produto
INSERT INTO produto (nome, descricao, qtd_estoque, data_fabricacao, valor_unitario, id_categoria)
VALUES ('HyperX Mars RGB', 'Teclado Mecânico Gamer HyperX Mars, RGB, Switch Outemu Blue, US', 20, '2018-10-05', 375.00, 1);
INSERT INTO produto (nome, descricao, qtd_estoque, data_fabricacao, valor_unitario, id_categoria)
VALUES ('HyperX Cloud Revolver S', 'Headset Gamer HyperX Cloud Revolver S 7.1 Dolby Digital', 7, '2018-10-05', 833.20, 3);
INSERT INTO produto (nome, descricao, qtd_estoque, data_fabricacao, valor_unitario, id_categoria)
VALUES ('Webcam Logitech c922', 'Webcam Full HD Logitech C922 Pro Stream com Microfone Embutido, USB, 1080p e Tripé Incluso', 15, '2019-12-18', 788.15, 4);
INSERT INTO produto (nome, descricao, qtd_estoque, data_fabricacao, valor_unitario, id_categoria)
VALUES ('Razer Deathadder V2', 'Mouse Gamer Razer Deathadder V2, Chroma, Optical Switch, 8 Botões, 20000DPI', 25, '2017-01-17', 588.30, 2);
INSERT INTO produto (nome, descricao, qtd_estoque, data_fabricacao, valor_unitario, id_categoria)
VALUES ('Gabinete Sharkoon TG5', 'Gabinete Sharkoon TG5 Blue Vidro Temperado 4mm Led Fan 12cm ATX', 10, '2018-03-08', 752.80, 5);

-- Inserindo dados na tabela funcionario
INSERT INTO funcionario (nome, cpf)
VALUES ('Rafaela', '654.564.879-31');
INSERT INTO funcionario (nome, cpf)
VALUES ('Luan', '031.552.411-75');
INSERT INTO funcionario (nome, cpf)
VALUES ('Diego', '133.224.901-79');
INSERT INTO funcionario (nome, cpf)
VALUES ('Gisele', '588.631.752-12');
INSERT INTO funcionario (nome, cpf)
VALUES ('Helen', '458.327.788-52');

-- Inserindo dados na tabela funcionarioproduto
INSERT INTO funcionarioproduto (id_funcionario, id_produto)
VALUES (1, 1);
INSERT INTO funcionarioproduto (id_funcionario, id_produto)
VALUES (4, 2);
INSERT INTO funcionarioproduto (id_funcionario, id_produto)
VALUES (1, 3);
INSERT INTO funcionarioproduto (id_funcionario, id_produto)
VALUES (2, 4);
INSERT INTO funcionarioproduto (id_funcionario, id_produto)
VALUES (3, 5);

-- Inserindo dados na tabela pedido
INSERT INTO pedido (Data_pedido, id_cliente)
VALUES ('2020-04-14', 2);
INSERT INTO pedido (Data_pedido, id_cliente)
VALUES ('2019-12-25', 4);
INSERT INTO pedido (Data_pedido, id_cliente)
VALUES ('2020-10-01', 2);
INSERT INTO pedido (Data_pedido, id_cliente)
VALUES ('2021-07-12', 1);
INSERT INTO pedido (Data_pedido, id_cliente)
VALUES ('2018-02-28', 5);

-- Inserindo dados na tabela pedidoitem
INSERT INTO pedidoitem (quantidade, id_pedido, id_produto)
VALUES (1, 1, 1);
INSERT INTO pedidoitem (quantidade, id_pedido, id_produto)
VALUES (1, 1, 4);
INSERT INTO pedidoitem (quantidade, id_pedido, id_produto)
VALUES (2, 2, 2);
INSERT INTO pedidoitem (quantidade, id_pedido, id_produto)
VALUES (1, 3, 5);
INSERT INTO pedidoitem (quantidade, id_pedido, id_produto)
VALUES (3, 4, 3);
INSERT INTO pedidoitem (quantidade, id_pedido, id_produto)
VALUES (2, 5, 4);
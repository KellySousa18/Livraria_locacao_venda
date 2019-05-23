CREATE table cliente (

    id int not null AUTO_INCREMENT,
    nome varchar(15),
    cpf varchar(20),
    data date,
    email varchar(20),
    tipoCliente varchar(13),
    endereco_id int not null,
    telefone varchar(10),

    PRIMARY KEY(id)


);
INSERT into cliente( id, nome, cpf, data, email, tipoCliente, endereco_id, telefone)

values (1,'Ana','001001001-01', '2000-04-09','eugosto@sistema.com','pessoa fisica', 1,'1111-1111');
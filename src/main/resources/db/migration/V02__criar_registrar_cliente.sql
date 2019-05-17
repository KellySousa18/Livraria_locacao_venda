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
create table endereco (

    id int not null AUTO_INCREMENT,
    logradouro varchar(30),
    numero varchar(6),
    complemento varchar(20),
    cidade varchar(20),
    uf varchar(12),
    cep varchar(9),

    primary key (id)
);

insert into endereco (id, logradouro, numero, complemento, cidade, uf, cep)

values (1,'avenida jp', 's/n', 'nova primavera','Rio de Janeiro', 'rj', '6500000');

insert into endereco (id, logradouro, numero, complemento, cidade, uf, cep)
values (2,'Parque botanico', '134','condominio rio sul','Rio de Janeiro', 'RJ','65055-000');


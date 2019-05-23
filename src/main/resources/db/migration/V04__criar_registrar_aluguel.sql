create table aluguel(

    id int not null AUTO_INCREMENT,
    cliente_id int not null,
    livro_id int not null,
    dtEmprestimo DATE,
    dtDevolucao DATE,

    PRIMARY KEY (id)

);
INSERT INTO aluguel (id, cliente_id, livro_id, dtEmprestimo, dtDevolucao)

values (1, 1, 1, '2019-05-05', '2019-05-13');
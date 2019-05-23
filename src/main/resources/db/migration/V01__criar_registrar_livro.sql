CREATE table livro (
    Id int not null AUTO_INCREMENT,
    nome varchar(15),
    nome_editora varchar(20),
    autor varchar(10),
    ano_publicacao int,
    isbn varchar(13),
    assunto varchar(20),
    quantidade_disponivel int,
    compra bit,
    nacional bit,
    preco_venda double,
    preco_aluguel double,
    preco_renovacao_aluguel double,

    PRIMARY KEY (id)

);

INSERT into livro (Id, nome, nome_editora, autor, ano_publicacao, isbn, assunto, quantidade_disponivel,compra, nacional, preco_aluguel,preco_venda, preco_renovacao_aluguel)

values (1,'A1','editora livre','Aderbal',2011,'A1234567890as','banco de dados',10, 1, 1, 10, 25, 5);
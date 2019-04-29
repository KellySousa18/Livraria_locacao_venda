package lpweb.livraria_aluguel_venda.model;

import javax.persistence.*;

@Entity
@Table (name = "livro")
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String nome_editora;
    private String autor;
    private int ano_publicacao;
    private String isbn;
    private String assunto;
    private Integer quantidade_disponivel;
    private boolean compra;
    private boolean nacional;
    private Double preco_venda;
    private Double preco_aluguel;
    private Double preco_renovacao_aluguel;

    public Livro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_editora() {
        return nome_editora;
    }

    public void setNome_editora(String nome_editora) {
        this.nome_editora = nome_editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public String getISBN() {
        return isbn;
    }

    public void setisbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public int getQuantidade_disponivel() {
        return quantidade_disponivel;
    }

    public void setQuantidade_disponivel(int quantidade_disponivel) {
        this.quantidade_disponivel = quantidade_disponivel;
    }

    public boolean isCompra() {
        return compra;
    }

    public void setCompra(boolean compra) {
        this.compra = compra;
    }

    public boolean isNacional() {
        return nacional;
    }

    public void setNacional(boolean nacional) {
        this.nacional = nacional;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public double getPreco_aluguel() {
        return preco_aluguel;
    }

    public void setPreco_aluguel(double preco_aluguel) {
        this.preco_aluguel = preco_aluguel;
    }

    public double getPreco_renovacao_aluguel() {
        return preco_renovacao_aluguel;
    }

    public void setPreco_renovacao_aluguel(double preco_renovacao_aluguel) {
        this.preco_renovacao_aluguel = preco_renovacao_aluguel;
    }
}


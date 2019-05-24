package lpweb.livraria_aluguel_venda.controle.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lpweb.livraria_aluguel_venda.model.Livro;

    public class LivroControllerDTO {
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

        private DTO<Livro, LivroControllerDTO> dto = new DTO<>(this);



        public LivroControllerDTO(Livro p) {
        }


        @JsonIgnore
        public Livro getLivro() {
            Livro p = dto.getEntity(new Livro() );
            return p;
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

        public void setNome(String nome){
            this.nome = nome;
        }

        public String getNome_editora(){
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

        public Integer getAno_publicacao() {
            return ano_publicacao;
        }

        public void setAno_publicacao(Integer ano_publicacao) {
            this.ano_publicacao = ano_publicacao;
        }

        public String getIsbn(){
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getAssunto(){
            return assunto;
        }

        public void setAssunto(String assunto) {
            this.assunto = assunto;
        }

        public Integer getQuantidade_disponivel(){
            return quantidade_disponivel;
        }

        public void setQuantidade_disponivel(Integer quantidade_disponivel) {
            this.quantidade_disponivel = quantidade_disponivel;
        }

        public boolean getCompra(){
            return compra;
        }

        public void setCompra(boolean compra) {
            this.compra = compra;
        }

        public boolean getNacional(){
            return nacional;
        }

        public void setNacional(boolean nacional){
            this.nacional = nacional;
        }
        public  Double getPreco_venda(){
            return preco_venda;
        }

        public void setPreco_venda(Double preco_venda) {
            this.preco_venda = preco_venda;
        }

        public Double getPreco_aluguel() {
            return preco_aluguel;
        }

        public void setPreco_aluguel(Double preco_aluguel) {
            this.preco_aluguel = preco_aluguel;
        }

        public Double getPreco_renovacao_aluguel() {
            return preco_renovacao_aluguel;
        }

        public void setPreco_renovacao_aluguel(Double preco_renovacao_aluguel) {
            this.preco_renovacao_aluguel = preco_renovacao_aluguel;
        }

        public Livro atualizaIgnorandoNulo(Livro livro) {
            livro = dto.mergeIgnorandoNulo(livro);

            return livro;
        }
    }


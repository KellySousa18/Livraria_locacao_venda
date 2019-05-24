package lpweb.livraria_aluguel_venda.repositorio.filter;

public class LivroFiltro {

    private String nome;
    private int ano_publicacaoDe;
    private int ano_publicacaoAte;
    private Double precoAluguelDe;
    private Double precoAluguelAte;
    private Integer livroId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno_publicacaoDe() {
        return ano_publicacaoDe;
    }

    public void setAno_publicacaoDe(int ano_publicacaoDe) {
        this.ano_publicacaoDe = ano_publicacaoDe;
    }

    public int getAno_publicacaoAte() {
        return ano_publicacaoAte;
    }

    public void setAno_publicacaoAte(int ano_publicacaoAte) {
        this.ano_publicacaoAte = ano_publicacaoAte;
    }

    public Double getPrecoAluguelDe() {
        return precoAluguelDe;
    }

    public void setPrecoAluguelDe(Double precoaluguelDe) {
        this.precoAluguelDe = precoaluguelDe;
    }

    public Double getPrecoAluguelAte() {
        return precoAluguelAte;
    }

    public void setPrecoAluguelAte(Double precoAluguelAte) {
        this.precoAluguelAte = precoAluguelAte;
    }

    public Integer getLivroId() {
        return livroId;
    }

    public void setLivroId(Integer livroId) {
        this.livroId = livroId;
    }

    @Override
    public String toString() {
        return "LivroFiltro{" +
                "nome='" + nome + '\'' +
                ", ano_publicacaoDe=" + ano_publicacaoDe +
                ", ano_publicacaoAte=" + ano_publicacaoAte +
                ", precoAluguelDe=" + precoAluguelDe +
                ", precoAluguelAte" + precoAluguelAte +
                ", livroId=" + livroId +
                '}';
    }
}


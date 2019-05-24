package lpweb.livraria_aluguel_venda.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table (name = "aluguel")
public class Aluguel{

    @ManyToOne(cascade={CascadeType.REFRESH, CascadeType.PERSIST,
       CascadeType.MERGE}, fetch=FetchType.EAGER)
    @JoinColumn(name="idCliente")
    private Cliente cliente;

    @ManyToOne(cascade={CascadeType.REFRESH, CascadeType.PERSIST,
            CascadeType.MERGE}, fetch=FetchType.EAGER)
    @JoinColumn(name="idLivro")
    private Livro livro;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(value=TemporalType.DATE)
    private Date dtEmprestimo;

    @Temporal(value=TemporalType.DATE)
    private Date dtDevolucao;


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDtEmprestimo() {
        return dtEmprestimo;
    }

    public void setDtEmprestimo(Date dtEmprestimo) {
        this.dtEmprestimo = dtEmprestimo;
    }

    public Date getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(Date dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluguel)) return false;
        Aluguel aluguel = (Aluguel) o;
        return Objects.equals(getId(), aluguel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    

}

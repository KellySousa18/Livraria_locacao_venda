package lpweb.livraria_aluguel_venda.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "aluguel")
public class Aluguel{

    @EmbeddedId
    private AluguelID aluguelID;

    @Temporal(value=TemporalType.DATE)
    private Date dtEmprestimo;

    @Temporal(value=TemporalType.DATE)
    private Date dtDevolucao;


    public Date getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(Date dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public Date getDtEmprestimo() {
        return dtEmprestimo;
    }

    public void setDtEmprestimo(Date dtEmprestimo) {
        this.dtEmprestimo = dtEmprestimo;
    }

    public AluguelID getAluguelID() {
        return aluguelID;
    }

    public void setAluguelID(AluguelID aluguelID) {
        this.aluguelID = aluguelID;
    }

    public Aluguel() { }



}

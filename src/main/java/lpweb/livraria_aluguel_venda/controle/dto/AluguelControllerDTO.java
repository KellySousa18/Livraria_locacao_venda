package lpweb.livraria_aluguel_venda.controle.dto;
import lpweb.livraria_aluguel_venda.model.Cliente;
import lpweb.livraria_aluguel_venda.model.Livro;
import javax.persistence.*;
import java.util.Date;

public class AluguelControllerDTO {
    public class Aluguel {

        @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST,
                CascadeType.MERGE}, fetch = FetchType.EAGER)
        @JoinColumn(name = "idCliente")
        private Cliente cliente;

        @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST,
                CascadeType.MERGE}, fetch = FetchType.EAGER)
        @JoinColumn(name = "idLivro")
        private Livro livro;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Temporal(value = TemporalType.DATE)
        private Date dtEmprestimo;

        @Temporal(value = TemporalType.DATE)
        private Date dtDevolucao;


    }
}
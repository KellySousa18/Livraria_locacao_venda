package lpweb.livraria_aluguel_venda.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


    @SuppressWarnings("serial")
    @Embeddable
    class AluguelID implements Serializable {

        @ManyToOne(cascade={CascadeType.REFRESH, CascadeType.PERSIST,
                CascadeType.MERGE}, fetch=FetchType.EAGER)
        @JoinColumn(name="idCliente")
        private Cliente cliente;

        @ManyToOne(cascade={CascadeType.REFRESH, CascadeType.PERSIST,
                CascadeType.MERGE}, fetch=FetchType.EAGER)
        @JoinColumn(name="isbnLivro")
        private Livro livro;

        public AluguelID() { }

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

        @Override
        public boolean equals(Object arg0) {
            return super.equals(arg0);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }


}


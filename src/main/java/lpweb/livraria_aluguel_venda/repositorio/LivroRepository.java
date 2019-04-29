package lpweb.livraria_aluguel_venda.repositorio;

import lpweb.livraria_aluguel_venda.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}

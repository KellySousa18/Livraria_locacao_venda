package lpweb.livraria_aluguel_venda.repositorio;

import lpweb.livraria_aluguel_venda.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {
}


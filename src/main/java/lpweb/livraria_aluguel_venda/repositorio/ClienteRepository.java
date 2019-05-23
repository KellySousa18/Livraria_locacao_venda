package lpweb.livraria_aluguel_venda.repositorio;

import lpweb.livraria_aluguel_venda.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}

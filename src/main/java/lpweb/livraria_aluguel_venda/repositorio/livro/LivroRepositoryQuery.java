package lpweb.livraria_aluguel_venda.repositorio.livro;

import lpweb.livraria_aluguel_venda.model.Livro;
import lpweb.livraria_aluguel_venda.repositorio.filter.LivroFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LivroRepositoryQuery  {
    Page<Livro> filtrar(LivroFiltro filtro, Pageable pageable);
}
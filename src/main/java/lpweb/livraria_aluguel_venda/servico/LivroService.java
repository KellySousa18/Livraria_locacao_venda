package lpweb.livraria_aluguel_venda.servico;

import lpweb.livraria_aluguel_venda.model.Livro;
import lpweb.livraria_aluguel_venda.repositorio.LivroRepository;
import lpweb.livraria_aluguel_venda.repositorio.filter.LivroFiltro;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class LivroService {
    private final LivroRepository livroRepository;
    private final GenericoService<Livro> genericoService;
    @Autowired
    public LivroService(LivroRepository livroRepository) {

        this.livroRepository = livroRepository;
        this.genericoService = new GenericoService<Livro>(this.livroRepository);
    }

    @Transactional(readOnly = true)
    public List<Livro> todas() {
        return livroRepository.findAll();
    }

    @Transactional
    public Livro salva(Livro livro) {
        return livroRepository.save(livro );

    }

    @Transactional(readOnly = true)
    public Livro buscaPor(Integer id) {
        return livroRepository.findById(id).get();

    }

    @Transactional(readOnly = true)
    public Page<Livro> busca(LivroFiltro filtro, Pageable pageable) {
        return livroRepository.filtrar(filtro, pageable );
    }

    @Transactional
    public void excluiPor(Integer id) {
        livroRepository.deleteById(id );
    }

    @Transactional
    public Livro atualiza(Integer id, Livro livro) {

        Livro livroSalva = this.buscaPor(id);
        BeanUtils.copyProperties(livro, livroSalva, "id");

        return  livroSalva;
    }

}

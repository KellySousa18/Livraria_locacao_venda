package lpweb.livraria_aluguel_venda.servico;

import lpweb.livraria_aluguel_venda.model.Aluguel;
import lpweb.livraria_aluguel_venda.repositorio.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AluguelService {
    private final AluguelRepository aluguelRepository;

    private final GenericoService<Aluguel> genericoService;

    @Autowired
    public AluguelService(AluguelRepository aluguelRepository ) {
        this.aluguelRepository = aluguelRepository;
        this.genericoService = new GenericoService<>(aluguelRepository);
    }

    @Transactional
    public Aluguel salva(Aluguel aluguel) {
        return genericoService.salva(aluguel );
    }

    @Transactional(readOnly = true )
    public List<Aluguel> todos() {
        return genericoService.todos();
    }

    @Transactional
    public Aluguel atualiza(Integer id, Aluguel aluguel) {
        return genericoService.atualiza(aluguel, id);
    }

    @Transactional(readOnly = true )
    public Aluguel buscaPor(Integer id) {
        return genericoService.buscaPor(id );
    }


}

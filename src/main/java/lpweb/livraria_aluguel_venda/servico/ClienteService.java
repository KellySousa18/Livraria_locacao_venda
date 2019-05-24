package lpweb.livraria_aluguel_venda.servico;

import lpweb.livraria_aluguel_venda.model.Cliente;
import lpweb.livraria_aluguel_venda.repositorio.ClienteRepository;
import lpweb.livraria_aluguel_venda.repositorio.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class ClienteService {
    private final ClienteRepository clienteRepository;

    private final GenericoService<Cliente> genericoService;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;

        this.genericoService = new GenericoService<Cliente>(clienteRepository );
    }

    @Transactional(readOnly = true)
    public Optional<Cliente> buscaPor(String nome) {
        return Optional.ofNullable( clienteRepository.findByNome(nome ) );
    }


    @Transactional(readOnly = true)
    public Cliente buscaPor(Integer id) {
        // ...
        return this.genericoService.buscaPor(id );
    }


    @Transactional
    public Cliente salva(Cliente cliente ) {
        return this.genericoService.salva(cliente);
    }


    @Transactional(readOnly = true)
    public List<Cliente> todos() {
        return genericoService.todos();
    }


    @Transactional
    public void excluir(Integer id) {
        this.genericoService.excluirPor(id );
    }


    @Transactional
    public Cliente atualiza(Integer id, Cliente cliente) {
        return this.genericoService.atualiza(cliente, id);
    }

    public Cliente buscarPor(Integer id) {
        return this.genericoService.buscaPor(id );
    }
}

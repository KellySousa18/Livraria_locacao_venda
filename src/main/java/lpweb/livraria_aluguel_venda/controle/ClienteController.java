package lpweb.livraria_aluguel_venda.controle;

import lpweb.livraria_aluguel_venda.controle.event.HeaderLocationEvento;
import lpweb.livraria_aluguel_venda.model.Cliente;
import lpweb.livraria_aluguel_venda.servico.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ClienteController {
    @Autowired
    private ApplicationEventPublisher publisher;

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> todos() {
        return clienteService.todos();
    }


    @PostMapping
    public ResponseEntity<Cliente> cria(@Validated @RequestBody Cliente cliente, HttpServletResponse response) {
        Cliente clienteSalvo = clienteService.salva(cliente );

        publisher.publishEvent(new HeaderLocationEvento(this, response, clienteSalvo.getId()) );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteSalvo );
    }

    @GetMapping("/{id}")
    public Cliente buscaPor(@PathVariable Integer id) {
        return clienteService.buscarPor(id );
    }


    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualiza(@PathVariable Integer id, @Validated @RequestBody Cliente cliente ) {
        Cliente clienteManager = clienteService.atualiza(id, cliente );
        return ResponseEntity.ok(clienteManager );
    }

}


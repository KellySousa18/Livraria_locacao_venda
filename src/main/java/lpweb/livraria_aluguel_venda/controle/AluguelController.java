package lpweb.livraria_aluguel_venda.controle;

import lpweb.livraria_aluguel_venda.controle.event.HeaderLocationEvento;
import lpweb.livraria_aluguel_venda.model.Aluguel;
import lpweb.livraria_aluguel_venda.servico.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AluguelController {
    private final lpweb.livraria_aluguel_venda.servico.AluguelService AluguelService;
    @Autowired
    private ApplicationEventPublisher publisher;

    private AluguelService aluguelService;

    @Autowired
    public AluguelController(AluguelService aluguelService) {
        this.AluguelService = aluguelService;
    }

    @GetMapping
    public List<Aluguel> listaDeLivro() {
        return AluguelService.todos();
    }

    @PostMapping
    public ResponseEntity<?> cria(@Validated @RequestBody Aluguel aluguel, HttpServletResponse response) {
        Aluguel aluguelSalvo = AluguelService.salva(aluguel );
        publisher.publishEvent(new HeaderLocationEvento(this, response, aluguelSalvo.getId() ));

        return  ResponseEntity.status(HttpStatus.CREATED).body(aluguelSalvo );
    }

    @GetMapping("/{id}")
    public Aluguel buscaPor(@PathVariable Integer id) {
        return AluguelService.buscaPor(id );
    
    }
}

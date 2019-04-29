package lpweb.livraria_aluguel_venda.controle;

import lpweb.livraria_aluguel_venda.model.Livro;
import lpweb.livraria_aluguel_venda.servico.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }


    @GetMapping
    public List<Livro> todas() {
        return livroService.todas();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro salva(@RequestBody Livro livro) {
        return livroService.salva(livro);
    }

    @GetMapping("/{id}")
    public Livro buscaPor(@PathVariable Integer id) {
        return livroService.buscaPor(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {
        livroService.excluiPor(id);
    }


    @PutMapping("/{id}")
    public Livro altera(@PathVariable Integer id, @RequestBody Livro livro) {
        return livroService.atualiza(id, livro);
    }

}
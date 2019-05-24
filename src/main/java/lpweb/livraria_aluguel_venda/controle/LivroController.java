package lpweb.livraria_aluguel_venda.controle;

import lpweb.livraria_aluguel_venda.controle.dto.LivroControllerDTO;
import lpweb.livraria_aluguel_venda.controle.event.HeaderLocationEvento;
import lpweb.livraria_aluguel_venda.controle.response.Erro;
import lpweb.livraria_aluguel_venda.controle.response.Resposta;
import lpweb.livraria_aluguel_venda.controle.validation.Validacao;
import lpweb.livraria_aluguel_venda.model.Livro;
import lpweb.livraria_aluguel_venda.repositorio.filter.LivroFiltro;
import lpweb.livraria_aluguel_venda.servico.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Value("${paginacao.qtd_por_pagina}")
    private Integer quantidadePorPagina;

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public Resposta<Page<LivroControllerDTO>> busca(LivroFiltro filtro, Pageable page  ) {

        Page<Livro> produtos = livroService.busca(filtro, page );

        Page<LivroControllerDTO> pageProdutosDTO = produtos.map( p -> new LivroControllerDTO(p) );

        return Resposta.comDadosDe(pageProdutosDTO );
    }

    @PostMapping
    public ResponseEntity<Resposta<LivroControllerDTO>>salva(@Valid @RequestBody LivroControllerDTO livroControllerDTO,
                                                      HttpServletResponse response ) {
        Livro livroSalvo = livroService.salva(livroControllerDTO.getLivro() );

        publisher.publishEvent(new HeaderLocationEvento(this, response, livroSalvo.getId() ));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Resposta.comDadosDe(new LivroControllerDTO(livroSalvo ) ) );

    }

    @GetMapping("/{id}")
    public Resposta<LivroControllerDTO> buscaPor(@PathVariable Integer id) {
        Livro livro = livroService.buscaPor(id);
        return Resposta.comDadosDe(new LivroControllerDTO(livro) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta<LivroControllerDTO>> atualiza(@PathVariable Integer id, @RequestBody LivroControllerDTO livroControllerDTO) {

        Livro livro = livroControllerDTO.atualizaIgnorandoNulo(livroService.buscaPor(id ) );

        List<Erro> erros = this.getErros(new LivroControllerDTO(livro) );
        if (existe(erros) ) {
            return ResponseEntity.badRequest().body(Resposta.com(erros ) );
        }

        Livro livroAtualizado = livroService.atualiza(id, livro);
        return ResponseEntity.ok(Resposta.comDadosDe(new LivroControllerDTO(livroAtualizado )) );
    }

    //TODO generalizar este código, está duplicado nos outros controllers
    private boolean existe(List<Erro> erros) {
        return Objects.nonNull( erros ) &&  !erros.isEmpty();
    }


    private List<Erro> getErros(LivroControllerDTO dto) {
        Validacao<LivroControllerDTO> validacao = new Validacao<>();
        return validacao.valida(dto);
    }

}
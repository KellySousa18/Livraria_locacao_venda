package lpweb.livraria_aluguel_venda.repositorio.livro;

import lpweb.livraria_aluguel_venda.model.Livro;
import lpweb.livraria_aluguel_venda.repositorio.filter.LivroFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class LivroRepositoryImpl implements LivroRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Livro> filtrar(LivroFiltro filtro, Pageable pageable) {

        CriteriaBuilder cBuilder = manager.getCriteriaBuilder();

        CriteriaQuery<Livro> cQuery = cBuilder.createQuery(Livro.class);

        Root<Livro> livroRoot = cQuery.from(Livro.class);

        Predicate[] restricoes = this.criaRestricoes(filtro, cBuilder, livroRoot);

        cQuery.select(livroRoot)
                .where(restricoes)
                .orderBy(cBuilder.desc(livroRoot.get("nome")));

        TypedQuery<Livro> query = manager.createQuery(cQuery);
        adicionaRestricoesDePaginacao(query, pageable);

        return new PageImpl<Livro>(query.getResultList(), pageable, total(filtro));
    }

    private Predicate[] criaRestricoes(LivroFiltro filtro, CriteriaBuilder cBuilder, Root<Livro> livroRoot) {

        List<Predicate> predicates = new ArrayList<>();
        /*
        if ( !StringUtils.isEmpty( filtro.getNome()) ) {
            // where nome like %Computador%
            predicates.add(cBuilder.like(cBuilder.lower(produtoRoot.get("nome")), "%" + filtro.getNome().toLowerCase() + "%" ) );

        }

        if ( Objects.nonNull( filtro.getAtivo()) ) {
            predicates.add( cBuilder.equal( produtoRoot.get("ativo"), filtro.getAtivo() ));
        }

        if (Objects.nonNull(filtro.getCategoriaId()) ) {

            // antes fazemos o join com categorias
            Path<Integer> categoriaPath = produtoRoot.join("categorias").<Integer>get("id");

            // semelhante a clausula "on" do critério de junção
            predicates.add ( cBuilder.equal(categoriaPath, filtro.getCategoriaId() ) );
        }
        */
        return predicates.toArray(new Predicate[ predicates.size() ] );
    }

    private void adicionaRestricoesDePaginacao(TypedQuery<Livro> query, Pageable pageable) {
        Integer paginaAtual = pageable.getPageNumber();
        Integer totalObjetosPorPagina = pageable.getPageSize();
        Integer primeiroObjetoDaPagina = paginaAtual * totalObjetosPorPagina;

        // 0 a n-1, n - (2n -1), ...
        query.setFirstResult(primeiroObjetoDaPagina);
        query.setMaxResults(totalObjetosPorPagina);

    }

    private Long total(LivroFiltro filtro) {
        CriteriaBuilder cBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> cQuery = cBuilder.createQuery(Long.class);

        Root<Livro> rootLivro = cQuery.from(Livro.class);

        Predicate[] predicates = criaRestricoes(filtro, cBuilder, rootLivro);

        cQuery.where(predicates);
        cQuery.select(cBuilder.count(rootLivro));

        return manager.createQuery(cQuery).getSingleResult();
        }

    }



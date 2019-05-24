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

public class LivroRepositoryQuery implements LivroRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Livro> filtrar(LivroFiltro filtro, Pageable pageable) {

        // Usamos o CriteriaBuilder(cb) para criar a CriteriaQueyr (cQuery)
        // com a tipagem do tipo a ser selecionado (Produto)
        CriteriaBuilder cBuilder = manager.getCriteriaBuilder();


        // 1. Select p From Produto p
        CriteriaQuery<Livro> cQuery = cBuilder.createQuery(Livro.class);

        // 2. clausula from e joins
        Root<Livro> livroRoot = cQuery.from(Livro.class);

        // 3. adiciona as restrições (os predicados) que serão passadas na clausula where
        Predicate[] restricoes = this.criaRestricoes(filtro, cBuilder, livroRoot);


        // 4. monta a consulta com as restrições
        cQuery.select(livroRoot)
                .where(restricoes)
                .orderBy(cBuilder.desc(livroRoot.get("nome")));

        // 5. cria e executa a consula
        TypedQuery<Livro> query = manager.createQuery(cQuery);
        adicionaRestricoesDePaginacao(query, pageable);

        return new PageImpl<Livro>(query.getResultList(), pageable, total(filtro));
    }


    private Predicate[] criaRestricoes(LivroFiltro filtro, CriteriaBuilder cBuilder, Root<Livro> livroRoot) {

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(filtro.getNome())) {
            // where nome like %Computador%
            predicates.add(cBuilder.like(cBuilder.lower(livroRoot.get("nome")), "%" + filtro.getNome().toLowerCase() + "%"));

        }
        if (Objects.nonNull(filtro.getAno_publicacaoDe())) {
            predicates.add(cBuilder.ge(livroRoot.get("Ano_publicacao"), filtro.getAno_publicacaoDe()));
        }

        if (Objects.nonNull(filtro.getAno_publicacaoAte())) {
            predicates.add(cBuilder.le(livroRoot.get("Ano_publicacao"), filtro.Ano_publicacaoAte()));
        }

        if (Objects.nonNull(filtro.getPrecoAluguelDe())) {
            predicates.add(cBuilder.ge(livroRoot.get("preco_aluguel"), filtro.getPrecoAluguelDe()));
        }

        if (Objects.nonNull(filtro.getPrecoAluguelAte())) {
            predicates.add(cBuilder.le(livroRoot.get("preco_aluguel"), filtro.getPrecoAluguelAte()));
        }

        if (Objects.nonNull(filtro.getLivroId())) {

            // antes fazemos o join com categorias
            Path<Integer> livroPath = livroRoot.join("livro").<Integer>get("id");

            // semelhante a clausula "on" do critério de junção
            predicates.add(cBuilder.equal(livroPath, filtro.getLivroId()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
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

        Root<Livro> rootProduto = cQuery.from(Livro.class);

        Predicate[] predicates = criaRestricoes(filtro, cBuilder, rootLivro);

        cQuery.where(predicates);
        cQuery.select(cBuilder.count(rootLivro));

        return manager.createQuery(cQuery).getSingleResult();
        }
    }
}
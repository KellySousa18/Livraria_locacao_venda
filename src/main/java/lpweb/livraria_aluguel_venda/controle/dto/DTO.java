package lpweb.livraria_aluguel_venda.controle.dto;

import lpweb.livraria_aluguel_venda.util.PropriedadesUtil;
import org.springframework.beans.BeanUtils;

final class DTO<E, D> {

    private final D dto;

    DTO(D dto) {
        this.dto = dto;
    }

    public E getEntity(E entity) {
        BeanUtils.copyProperties(this.dto, entity);
        return entity;
    }

    public D comDadosDe(E entity) {
        BeanUtils.copyProperties(entity, this.dto );
        return this.dto;

    }

    public E mergeIgnorandoNulo(E entity) {
        BeanUtils.copyProperties(this.dto,
                entity,
                PropriedadesUtil.obterPropriedadesComNullDe(this.dto) );

        return entity;
    }


}
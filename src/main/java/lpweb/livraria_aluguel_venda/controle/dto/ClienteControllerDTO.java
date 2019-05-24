package lpweb.livraria_aluguel_venda.controle.dto;

import lpweb.livraria_aluguel_venda.model.Endereco;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClienteControllerDTO {

    private Integer id;

    @NotEmpty
    private String nome;

    @Email
    private String email;

    @NotEmpty
    @CPF
    private String cpf;

    private Set<@NotEmpty String> telefones = new LinkedHashSet<>();

    private Set<Endereco> enderecos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }
}

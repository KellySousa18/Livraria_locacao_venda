package lpweb.livraria_aluguel_venda.model;

import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String nome;
    @Temporal(value=TemporalType.DATE)
    private Date dt_nasc;
    private String email;

    @NotNull
    @Enumerated (EnumType.STRING)
    private EnumType tipoCliente;

    @OneToOne(mappedBy = "cliente")
    private Endereco endereco;
    private String telefone;

    public Cliente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnumType getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(EnumType tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Date getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Date dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

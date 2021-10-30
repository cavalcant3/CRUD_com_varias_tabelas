package teste9.example.teste.crud.vendassm.cliente;

import javax.persistence.*;

@Entity
@Table

public class Cliente {
    @Id
    @SequenceGenerator(
          name = "cliente_sequence",
           sequenceName = "cliente_sequence",
           allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    private String nome;
    private String cpfCnpj;




    public Cliente() {
    }

    public Cliente(String nome, String cpfCnpj) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                '}';
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
}

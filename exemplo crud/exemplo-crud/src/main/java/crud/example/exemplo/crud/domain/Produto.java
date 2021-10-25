package crud.example.exemplo.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@AllArgsConstructor
//@NoArgsConstructor
@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double valor;

    @Deprecated
    public Produto() {
    }

    public Produto(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

}

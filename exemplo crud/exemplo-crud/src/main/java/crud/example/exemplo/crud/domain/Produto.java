package crud.example.exemplo.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double valor;

   // public Produto(Integer id, String produto, Double valor) {

  //  }

    public Integer getId() {
        return id;
    }

    public Produto add(Produto produto) {
        produto.add(produto);
        return produto ;
    }

    public void setId(long nextLong) {
    }
}

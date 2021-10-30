package teste9.example.teste.crud.vendassm.venda;

import teste9.example.teste.crud.vendassm.cliente.Cliente;
import teste9.example.teste.crud.vendassm.produto.Produto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private LocalDate data;

    //definindo relações
    @OneToMany(targetEntity = Cliente.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "FK", referencedColumnName = "id")
    List<Cliente> cliente = new ArrayList<>();
    @OneToMany
    List<Produto> produto = new ArrayList<>();
}

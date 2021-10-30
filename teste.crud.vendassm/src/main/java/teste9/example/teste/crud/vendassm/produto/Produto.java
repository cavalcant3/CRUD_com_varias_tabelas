package teste9.example.teste.crud.vendassm.produto;


import javax.persistence.*;

@Entity
@Table
public class Produto {
    @Id
    @SequenceGenerator(
            name = "produto_sequence",
            sequenceName = "produto_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "produto_sequence")

    //atributos
    private Integer id;
    private String nome;
    private double valor;

    //constructor vazio
    public Produto() {
    }
    //constructor com todos os atributos
    public Produto(String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    //getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    //tostring() para mostrar na requisição dos parametros
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }


}

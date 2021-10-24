package crud.example.exemplo.crud.service;

import crud.example.exemplo.crud.domain.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private static List<Produto> produtos;
        static {
            produtos = new ArrayList<>(List.of(new Produto(1, "carro"), new Produto(2, "moto")));
        }

    //definindo método de listar todos
    public List<Produto> listAll() {return produtos;}

    //definindo método de listar por id único
    public Produto findById(Integer id){
            return produtos.stream()
                    .filter(produto -> produto.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado."));

    }

    public Produto save(Produto produto){

        produtos.add(produto);
        return produto;
    }

    public void delete(Integer id){
            produtos.remove(findById(id));
    }

    public void replace(Produto produto){
            delete(produto.getId());
            produtos.add(produto);
    }
}

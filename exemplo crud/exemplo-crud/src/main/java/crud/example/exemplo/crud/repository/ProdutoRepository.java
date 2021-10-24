package crud.example.exemplo.crud.repository;

import crud.example.exemplo.crud.domain.Produto;

import java.util.List;

public interface ProdutoRepository {
    List<Produto> listAll();
}

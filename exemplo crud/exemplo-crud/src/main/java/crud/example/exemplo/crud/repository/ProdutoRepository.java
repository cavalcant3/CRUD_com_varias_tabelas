package crud.example.exemplo.crud.repository;

import crud.example.exemplo.crud.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> listAll();
}

package teste9.example.teste.crud.vendassm.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //método para retornar todos os produtos
    public List<Produto> getProdutos(){
        return produtoRepository.findAll();
    }

    //enviar produtos
    public void addNewProduto (Produto produto){
        //validação
        Optional<Produto> produtoOptional = produtoRepository
                .findProdutoByNome(produto.getNome());
                if (produtoOptional.isPresent()){
                    throw new IllegalStateException("Produto já cadastrado");
                }
                produtoRepository.save(produto);
    }

    public void deleteProduto(Integer produtoId) {
        boolean exist = produtoRepository.existsById(produtoId);
        if (!exist){
            throw new IllegalStateException("produto with id" + produtoId + "does not exist");
        }
        produtoRepository.deleteById(produtoId);
    }

    public void replace(Produto produto) {
        deleteProduto(produto.getId());
        produtoRepository.save(produto);
    }
}

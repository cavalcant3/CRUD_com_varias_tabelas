package teste9.example.teste.crud.vendassm.produto;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping
    public List<Produto> getProduto(){
        return produtoService.getProdutos();
    }
    @PostMapping(path = "/post")
    public void registerNewProduto(@RequestBody Produto produto){
        produtoService.addNewProduto(produto);
    }

    @DeleteMapping(path = "{produtoId}")
    public void deleteProduto(@PathVariable("produtoId") Integer produtoId){
        produtoService.deleteProduto(produtoId);
    }
    @PutMapping(path = "{produtoId}")
    public void replaceProduto(
      @RequestBody Produto produto){
        produtoService.replace(produto);
    }

}

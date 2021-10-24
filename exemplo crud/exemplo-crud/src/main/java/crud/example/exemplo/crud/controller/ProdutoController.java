package crud.example.exemplo.crud.controller;

import crud.example.exemplo.crud.domain.Produto;
import crud.example.exemplo.crud.service.ProdutoService;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto") // localhost:8080/produto
@Log4j2
public class ProdutoController {
    @Autowired
   private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping //listar todos
    public ResponseEntity<List<Produto>> list(){
        return ResponseEntity.ok(produtoService.listAll());
    }
    @GetMapping(path = "/{id}") //listar por id
        public ResponseEntity<Produto> findById(@PathVariable Integer id){
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.save(produto));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> replace(@RequestBody Produto produto){
        produtoService.replace(produto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

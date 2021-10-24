package crud.example.exemplo.crud.controller;

import crud.example.exemplo.crud.domain.Produto;
import crud.example.exemplo.crud.service.ProdutoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public ResponseEntity<List<Produto>> list(){
        return ResponseEntity.ok(produtoService.listAll());
    }
    @GetMapping(path = "/{id}") //endpoint
}

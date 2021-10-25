package crud.example.exemplo.crud.service;

import crud.example.exemplo.crud.domain.Produto;
import crud.example.exemplo.crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;
@EnableAutoConfiguration
@Service
public class ProdutoService {
        @Autowired
        private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    //definindo método de listar todos
    public List<Produto> listAll() {
        List<Produto> produtos = new ArrayList<>();
        produtoRepository.listAll()
                .forEach(produtos::add);
        return produtos;
    }

    //definindo método de listar por id único
    public Produto findById(Integer id){
            return produtoRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado."));

    }

    public Produto save(Produto produto){

        return produtoRepository.save(produto);
    }

    public void delete(Integer id){
            produtoRepository.deleteById(id);
    }

    public void replace(Produto produto){
            produtoRepository.save(produto);
    }
}

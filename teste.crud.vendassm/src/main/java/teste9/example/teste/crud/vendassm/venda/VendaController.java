package teste9.example.teste.crud.vendassm.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import teste9.example.teste.crud.vendassm.cliente.Cliente;
import teste9.example.teste.crud.vendassm.cliente.ClienteRepository;
import teste9.example.teste.crud.vendassm.produto.ProdutoRepository;

@RestController
public class VendaController {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/placeOrder")
    public Cliente placeCliente(@RequestBody Venda request){
      return ClienteRepository.save(request.getCliente());
    }
}

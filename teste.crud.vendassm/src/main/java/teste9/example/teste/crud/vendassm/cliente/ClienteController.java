package teste9.example.teste.crud.vendassm.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "cliente")
public class ClienteController {
    private final ClienteSerivce clienteSerivce;

    @Autowired
    public ClienteController(ClienteSerivce clienteSerivce) {
        this.clienteSerivce = clienteSerivce;
    }


    //req GET
    @GetMapping
    public List<Cliente> getCliente(){
        return clienteSerivce.getCliente();
    }
    //req get by id
    @GetMapping(path = "{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable Integer id){
        return ResponseEntity.ok(clienteSerivce.findById(id));
    }



    @PostMapping(path = "/post")
    public void registerNewCliente(@RequestBody Cliente cliente){
        clienteSerivce.addNewCliente(cliente);
    }
    @DeleteMapping(path = "{clienteId}")
    public void deleteCliente(@PathVariable("clienteId")Integer clienteId){
        clienteSerivce.deleteCliente(clienteId);
    }
    @PutMapping(path = "{clienteId}")
    public void replaceCliente(@RequestBody Cliente cliente){
        clienteSerivce.replaceCliente(cliente);
    }




}

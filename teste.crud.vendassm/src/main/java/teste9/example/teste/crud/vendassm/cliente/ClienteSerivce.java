package teste9.example.teste.crud.vendassm.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteSerivce {
    @Autowired
    public ClienteSerivce(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    private final ClienteRepository clienteRepository;

    //all clientes
    public List<Cliente> getCliente(){
        return clienteRepository.findAll();
    }
    //id unico
    public Optional<Cliente> findById(Integer id){
        return clienteRepository.findById(id);
    }

    //add cliente
    public void addNewCliente(Cliente cliente) {
        //validação simples
        Optional<Cliente> clienteOptional = clienteRepository
                .findClienteBycpfCnpj(cliente.getCpfCnpj());
        if (clienteOptional.isPresent()){
            throw new IllegalStateException("Cliente já cadastrado");
        }
        clienteRepository.save(cliente);
    }
    //delete cliente
    public void deleteCliente (Integer clienteId){
        boolean exist = clienteRepository.existsById(clienteId);
        if (!exist){
            throw new IllegalStateException("Cliente with id" + clienteId + "dows not exist");

        }
        clienteRepository.deleteById(clienteId);
    }

    public void replaceCliente(Cliente cliente){
        deleteCliente(cliente.getId());
        clienteRepository.save(cliente);
    }
}

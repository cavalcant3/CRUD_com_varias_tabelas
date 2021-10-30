package teste9.example.teste.crud.vendassm.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

  //  @Query("SELECT s FROM Cliente s WHERE s.cpfCnpj = ?1")
    Optional<Cliente> findClienteBycpfCnpj(String cpfCnpj);
}

package teste9.example.teste.crud.vendassm.produto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProdutoConfig {
    @Bean
    CommandLineRunner commandLineRunnerr(ProdutoRepository repository){
        return args -> {
            Produto carro = new Produto(
                    "carro",
                    256.00

            );
            Produto moto = new Produto(

                    "moto",
                    360.00

            );
            repository.saveAll(
                    List.of(carro, moto)
            );
        };
    }
}

package teste9.example.teste.crud.vendassm.cliente;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CLienteConfig {
@Bean
    CommandLineRunner commandLineRunner (ClienteRepository repository){
        return args -> {
            Cliente Matheus = new Cliente(
                    "Matheus",
                    "06433355511"
            );
            Cliente xiaomi = new Cliente(
              "xiaomi",
              "ed4487554"
            );
            repository.saveAll(
                    List.of(Matheus, xiaomi)
            );
        } ;
}
}

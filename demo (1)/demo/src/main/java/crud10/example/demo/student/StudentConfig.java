package crud10.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.JANUARY;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepistory repistory) {
        return args -> {
            Student MAtheus = new Student(


                    "MAtheus",
                    "eger@gmail.com",
                    LocalDate.of(2000, 1, 5),
                    21

            );
            Student teste = new Student(


                    "teste",
                    "e111ger@gmail.com",
                    LocalDate.of(2000, 1, 5),
                    21

            );
            repistory.saveAll(
                    List.of(MAtheus, teste)
            );
        };
    }
}

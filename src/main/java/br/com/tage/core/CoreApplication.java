package br.com.tage.core;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.tage.core.model.AlunoFacul;
import br.com.tage.core.model.Categoria;
import br.com.tage.core.model.ProfessorFacul;
import br.com.tage.core.repository.AlunoFaculRepository;
import br.com.tage.core.repository.ProfessorFaculRepository;

@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

    @Bean
    public ApplicationRunner firstCarga(ProfessorFaculRepository professorFaculRepository,
            AlunoFaculRepository alunoFaculRepository) {
        return args -> {
            ProfessorFacul p1 = new ProfessorFacul("Ale", 20, "rua florio", 112223333, Categoria.CONCURSADO);
            professorFaculRepository.save(p1);

            AlunoFacul a1 = new AlunoFacul("iza", "FIAP", "2TDSG", 11666554);
            alunoFaculRepository.save(a1);
        };
    }

}
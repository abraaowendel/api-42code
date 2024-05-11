package com.api.code.configuration;

import com.api.code.model.entities.Aula;
import com.api.code.model.entities.Curso;
import com.api.code.model.entities.Modulo;
import com.api.code.repositories.AulaRepository;
import com.api.code.repositories.CursoRepository;
import com.api.code.repositories.ModuloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner{
    private final AulaRepository aulaRepository;
    private final CursoRepository cursoRepository;
    private final ModuloRepository moduloRepository;

    public TestConfiguration(AulaRepository aulaRepository, CursoRepository cursoRepository, ModuloRepository moduloRepository) {
        this.aulaRepository = aulaRepository;
        this.cursoRepository = cursoRepository;
        this.moduloRepository = moduloRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Curso CursoDeJava = new Curso(null, "Java", "Linguagem foda", "www.google.com", null);
        cursoRepository.save(CursoDeJava);


        Modulo moduloArrays = new Modulo(null, "Arrays", CursoDeJava);
        moduloRepository.save(moduloArrays);

        Aula aulaArray01 = new Aula(null, "Array Aula 01", "https://youtu.be/kWJHzambtNo?list=PLBlnK6fEyqRiraym3T703apTvEZLaSVtJ", false, moduloArrays);
        Aula aulaArray02 = new Aula(null, "Array Aula 02", "https://youtu.be/LDxIl9La5nk?list=PLBlnK6fEyqRiraym3T703apTvEZLaSVtJ", false, moduloArrays);
        Aula aulaArray03 = new Aula(null, "Array Aula 03", "https://youtu.be/ZJx3T3XL6CM?list=PLBlnK6fEyqRiraym3T703apTvEZLaSVtJ", false, moduloArrays);
        Aula aulaArray04 = new Aula(null, "Array Aula 04", "https://youtu.be/-VShg6LaWgc?list=PLBlnK6fEyqRiraym3T703apTvEZLaSVtJ", false, moduloArrays);
        Aula aulaArray05 = new Aula(null, "Array Aula 05", "https://youtu.be/hCB3TWpwMMM?list=PLBlnK6fEyqRiraym3T703apTvEZLaSVtJ", false, moduloArrays);
        aulaRepository.saveAll(List.of(aulaArray01, aulaArray02, aulaArray03, aulaArray04, aulaArray05));

    }
}

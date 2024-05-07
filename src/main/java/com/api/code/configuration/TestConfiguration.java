package com.api.code.configuration;

import com.api.code.model.entities.Curso;
import com.api.code.repositories.AulaRepository;
import com.api.code.repositories.CursoRepository;
import com.api.code.repositories.ModuloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
        Curso curso1 = new Curso(null, "Java", "Linguagem foda", "www.google.com");
        cursoRepository.save(curso1);
    }
}

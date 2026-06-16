package com.daweb.sistema_aluno;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaAlunoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SistemaAlunoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n=============================================");
        System.out.println("  PROJETO SPRING BOOT INICIADO COM SUCESSO!  ");
        System.out.println("=============================================\n");
    }
}
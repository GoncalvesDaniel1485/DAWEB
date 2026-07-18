package com.daweb.sistema_aluno.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daweb.sistema_aluno.entity.Aluno;
import com.daweb.sistema_aluno.repository.AlunoRepository;

@RestController
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/alunos")
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }
}
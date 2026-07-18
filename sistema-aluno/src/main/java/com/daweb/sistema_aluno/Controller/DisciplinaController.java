package com.daweb.sistema_aluno.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daweb.sistema_aluno.entity.Disciplina;
import com.daweb.sistema_aluno.repository.DisciplinaRepository;

@RestController
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping("/disciplinas")
    public List<Disciplina> listar() {
        return disciplinaRepository.findAll();
    }

}
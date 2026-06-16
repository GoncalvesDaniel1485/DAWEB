package com.daweb.sistema_aluno.repository;

import com.daweb.sistema_aluno.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    // Fica vazio. Note o "Integer" no final, pois o ID da sua matrícula é int.
}
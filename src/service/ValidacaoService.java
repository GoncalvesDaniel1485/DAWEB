package src.service;

import src.dto.AlunoDTO;
import src.dto.DisciplinaDTO;

public class ValidacaoService {

    public void validarAluno(AlunoDTO dto) {
        if (dto.getNome() == null || dto.getNome().trim().isEmpty())
            throw new IllegalArgumentException("Nome do aluno é obrigatório.");
        if (dto.getCpf() == null || dto.getCpf().length() != 11)
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos.");
        if (dto.getIdade() < 1 || dto.getIdade() > 100)
            throw new IllegalArgumentException("Idade inválida. Deve estar entre 1 e 100.");
    }

    public void validarDisciplina(DisciplinaDTO dto) {
        if (dto.getNome() == null || dto.getNome().trim().isEmpty())
            throw new IllegalArgumentException("Nome da disciplina é obrigatório.");
        if (dto.getProfessor() == null || dto.getProfessor().trim().isEmpty())
            throw new IllegalArgumentException("Professor é obrigatório.");
        if (dto.getCurso() == null || dto.getCurso().trim().isEmpty())
            throw new IllegalArgumentException("Curso é obrigatório.");
    }
}

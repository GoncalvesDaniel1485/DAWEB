public class ValidacaoService {
    public void validarAluno(String nome, String cpf, int idade) {
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Nome do aluno é obrigatório.");
        if (cpf == null || cpf.length() != 11)
            throw new IllegalArgumentException("CPF inválido.");
        if (idade < 1 || idade > 100)
            throw new IllegalArgumentException("Idade inválida.");
    }

    public void validarDisciplina(String nome, String professor, String curso) {
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Nome da disciplina é obrigatório.");
        if (professor == null || professor.trim().isEmpty())
            throw new IllegalArgumentException("Professor é obrigatório.");
        if (curso == null || curso.trim().isEmpty())
            throw new IllegalArgumentException("Curso é obrigatório.");
    }
}
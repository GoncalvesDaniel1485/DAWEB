package src.presentation;

import src.business.AlunoService;
import src.dto.AlunoDTO;
import java.util.ArrayList;

public class AlunoController {
    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    public void cadastrar(int matricula, String nome, String cpf, int idade) {
        try {
            service.cadastrar(new AlunoDTO(matricula, nome, cpf, idade));
            System.out.println("Aluno cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void editar(int matricula, String nome, String cpf, int idade) {
        try {
            boolean ok = service.editar(new AlunoDTO(matricula, nome, cpf, idade));
            System.out.println(ok ? "Aluno atualizado com sucesso!" : "Aluno não encontrado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void matricular(int matriculaAluno, int codDisciplina) {
        try {
            service.matricular(matriculaAluno, codDisciplina);
            System.out.println("Aluno matriculado na disciplina com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public AlunoDTO buscar(int matricula) {
        return service.buscar(matricula);
    }

    public ArrayList<AlunoDTO> listar() {
        return service.listar();
    }
}

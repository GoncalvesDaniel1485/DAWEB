package src.presentation;

import src.business.DisciplinaService;
import src.dto.AlunoDTO;
import src.dto.DisciplinaDTO;
import java.util.ArrayList;

public class DisciplinaController {
    private DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    public void cadastrar(int cod, String nome, String professor, String curso) {
        try {
            service.cadastrar(new DisciplinaDTO(cod, nome, professor, curso));
            System.out.println("Disciplina cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void editar(int cod, String nome, String professor, String curso) {
        try {
            boolean ok = service.editar(new DisciplinaDTO(cod, nome, professor, curso));
            System.out.println(ok ? "Disciplina atualizada com sucesso!" : "Disciplina não encontrada.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public DisciplinaDTO buscar(int cod) {
        return service.buscar(cod);
    }

    public ArrayList<DisciplinaDTO> listar() {
        return service.listar();
    }

    public ArrayList<AlunoDTO> listarAlunosDaDisciplina(int cod) {
        return service.listarAlunosDaDisciplina(cod);
    }
}

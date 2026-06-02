package src.business;

import src.dto.AlunoDTO;
import src.dto.DisciplinaDTO;
import src.entity.Aluno;
import src.entity.Disciplina;
import src.repository.DisciplinaRepository;
import src.service.ValidacaoService;
import java.util.ArrayList;

public class DisciplinaService {
    private DisciplinaRepository rep   = new DisciplinaRepository();
    private ValidacaoService validacao  = new ValidacaoService();

    public DisciplinaRepository getRepository() {
        return rep;
    }

    public void cadastrar(DisciplinaDTO dto) {
        validacao.validarDisciplina(dto);
        if (rep.buscarPorCodigo(dto.getCod()) != null)
            throw new IllegalArgumentException("Código de disciplina já cadastrado.");
        rep.cadastrar(new Disciplina(dto.getCod(), dto.getNome(), dto.getProfessor(), dto.getCurso()));
    }

    public boolean editar(DisciplinaDTO dto) {
        validacao.validarDisciplina(dto);
        Disciplina d = rep.buscarPorCodigo(dto.getCod());
        if (d == null) return false;
        d.setNome(dto.getNome());
        d.setProfessor(dto.getProfessor());
        d.setCurso(dto.getCurso());
        return true;
    }

    public DisciplinaDTO buscar(int cod) {
        Disciplina d = rep.buscarPorCodigo(cod);
        if (d == null) return null;
        return new DisciplinaDTO(d.getCod(), d.getNome(), d.getProfessor(), d.getCurso());
    }

    public ArrayList<DisciplinaDTO> listar() {
        ArrayList<DisciplinaDTO> lista = new ArrayList<>();
        for (Disciplina d : rep.getDisciplinas())
            lista.add(new DisciplinaDTO(d.getCod(), d.getNome(), d.getProfessor(), d.getCurso()));
        return lista;
    }

    // Retorna alunos de uma disciplina como DTOs para exibição
    public ArrayList<AlunoDTO> listarAlunosDaDisciplina(int cod) {
        Disciplina d = rep.buscarPorCodigo(cod);
        ArrayList<AlunoDTO> lista = new ArrayList<>();
        if (d == null) return lista;
        for (Aluno a : d.getAlunos())
            lista.add(new AlunoDTO(a.getMatricula(), a.getNome(), a.getCpf(), a.getIdade()));
        return lista;
    }
}

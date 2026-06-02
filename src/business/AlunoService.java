package src.business;

import src.dto.AlunoDTO;
import src.entity.Aluno;
import src.entity.Disciplina;
import src.repository.AlunoRepository;
import src.repository.DisciplinaRepository;
import src.service.ValidacaoService;
import java.util.ArrayList;

public class AlunoService {
    private AlunoRepository alunoRep = new AlunoRepository();
    private DisciplinaRepository discRep = new DisciplinaRepository();
    private ValidacaoService validacao = new ValidacaoService();

    // Permite injetar o mesmo DisciplinaRepository usado pelo DisciplinaService
    public AlunoService(DisciplinaRepository discRep) {
        this.discRep = discRep;
    }

    public void cadastrar(AlunoDTO dto) {
        validacao.validarAluno(dto);
        if (alunoRep.buscarPorMatricula(dto.getMatricula()) != null)
            throw new IllegalArgumentException("Matrícula já cadastrada.");
        alunoRep.cadastrar(new Aluno(dto.getMatricula(), dto.getNome(), dto.getCpf(), dto.getIdade()));
    }

    public boolean editar(AlunoDTO dto) {
        validacao.validarAluno(dto);
        Aluno aluno = alunoRep.buscarPorMatricula(dto.getMatricula());
        if (aluno == null)
            return false;
        aluno.setNome(dto.getNome());
        aluno.setCpf(dto.getCpf());
        aluno.setIdade(dto.getIdade());
        return true;
    }

    public void matricular(int matriculaAluno, int codDisciplina) {
        Aluno aluno = alunoRep.buscarPorMatricula(matriculaAluno);
        if (aluno == null)
            throw new IllegalArgumentException("Aluno não encontrado.");

        Disciplina disciplina = discRep.buscarPorCodigo(codDisciplina);
        if (disciplina == null)
            throw new IllegalArgumentException("Disciplina não encontrada.");

        aluno.adicionarDisciplina(disciplina);
        disciplina.adicionarAluno(aluno);
    }

    public AlunoDTO buscar(int matricula) {
        Aluno a = alunoRep.buscarPorMatricula(matricula);
        if (a == null)
            return null;
        return new AlunoDTO(a.getMatricula(), a.getNome(), a.getCpf(), a.getIdade());
    }

    public ArrayList<AlunoDTO> listar() {
        ArrayList<AlunoDTO> lista = new ArrayList<>();
        for (Aluno a : alunoRep.getAlunos())
            lista.add(new AlunoDTO(a.getMatricula(), a.getNome(), a.getCpf(), a.getIdade()));
        return lista;
    }

    public Aluno buscarModel(int matricula) {
        return alunoRep.buscarPorMatricula(matricula);
    }
}

import java.util.ArrayList;

public class DisciplinaService {
    private DisciplinaRepository rep = new DisciplinaRepository();
    private ValidacaoService validator = new ValidacaoService();

    public void cadastrar(int cod, String nome, String professor, String curso) {
        validator.validarDisciplina(nome, professor, curso);
        rep.cadastrar(new Disciplina(cod, nome, professor, curso));
    }

    public boolean editar(int cod, String novoNome, String novoProfessor, String novoCurso) {
        validator.validarDisciplina(novoNome, novoProfessor, novoCurso);
        Disciplina d = rep.buscarD(cod);
        if (d == null) return false;
        d.setNomeD(novoNome);
        d.setProfessor(novoProfessor);
        d.setCurso(novoCurso);
        return true;
    }

    public Disciplina buscar(int cod) { 
        return rep.buscarD(cod); 
    }

    public ArrayList<Disciplina> listar() { 
        return rep.getDisciplinas(); 
    }
}

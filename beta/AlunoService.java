import java.util.ArrayList;

public class AlunoService {
    private AlunoRepository rep = new AlunoRepository();
    private ValidacaoService val = new ValidacaoService();

    public void cadastrar(int matricula, String nome, String cpf, int idade) {
        val.validarAluno(nome, cpf, idade);
        rep.cadastrar(new Aluno(matricula, nome, cpf, idade));
    }

    public boolean editar(int matricula, String novoNome, String novoCpf, int novaIdade) {
        val.validarAluno(novoNome, novoCpf, novaIdade);
        Aluno a = rep.buscarA(matricula);
        if (a == null) return false;
        a.setNome(novoNome);
        a.setCpf(novoCpf);
        a.setIdade(novaIdade);
        return true;
    }

    public void matricular(int matriculaAluno, Disciplina d) {
        Aluno a = rep.buscarA(matriculaAluno);
        if (a == null) throw new IllegalArgumentException("Aluno não encontrado.");
        a.adicionarDisciplina(d);
        d.adicionarAluno(a);
    }

    public Aluno buscar(int matricula) { 
        return rep.buscarA(matricula); 
    }
    
    public ArrayList<Aluno> listar() {
        return rep.getAlunos(); 
    }
}

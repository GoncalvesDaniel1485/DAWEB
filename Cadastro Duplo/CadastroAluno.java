import java.util.ArrayList;

public class CadastroAluno {
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public void cadastrar(Aluno a) {
        alunos.add(a);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public Aluno buscar(int matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula() == matricula)
                return a;
        }
        return null;
    }
}
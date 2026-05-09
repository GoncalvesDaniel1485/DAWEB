import java.util.ArrayList;

public class Disciplina {
    private int cod;
    private String nome;
    private String professor;
    private String curso;
    private ArrayList<Aluno> alunos;

    public Disciplina(int cod, String nome, String professor, String curso) {
        this.cod = cod;
        this.nome = nome;
        this.professor = professor;
        this.curso = curso;
        this.alunos = new ArrayList<>();
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public String getProfessor() {
        return professor;
    }

    public String getCurso() {
        return curso;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno a) {
        alunos.add(a);
    }

    public void setNomeD(String nome){
        this.nome = nome;
    }

    public void setProfessor(String professor){
        this.professor = professor;
    }

    public void setCurso(String curso){
        this.curso = curso;
    }

    public String toString() {
        return "Disciplina: " + nome + " | Código da Disciplina: " + cod + " | Professor: " + professor;
    }
}
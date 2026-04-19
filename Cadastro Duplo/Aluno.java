import java.util.ArrayList;

public class Aluno {
    private int matricula;
    private String nome;
    private String cpf;
    private int idade;
    private ArrayList<Disciplina> disciplinas;

    public Aluno(int matricula, String nome, String cpf, int idade) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.disciplinas = new ArrayList<>();
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public ArrayList<Disciplina> getDisciplina() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    public String toString() {
        return "Aluno: " + nome + " | Matrícula: " + matricula + " | Idade: " + idade;
    }
}
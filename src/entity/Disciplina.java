package src.entity;

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProfessor(String prof) {
        this.professor = prof;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void adicionarAluno(Aluno a) {
        alunos.add(a);
    }

    @Override
    public String toString() {
        return "Disciplina: " + nome + " | Código: " + cod + " | Professor: " + professor;
    }
}

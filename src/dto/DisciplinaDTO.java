package src.dto;

public class DisciplinaDTO {
    private int cod;
    private String nome;
    private String professor;
    private String curso;

    public DisciplinaDTO(int cod, String nome, String professor, String curso) {
        this.cod = cod;
        this.nome = nome;
        this.professor = professor;
        this.curso = curso;
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

    public void setCod(int cod) {
        this.cod = cod;
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

    @Override
    public String toString() {
        return "Disciplina: " + nome + " | Código: " + cod + " | Professor: " + professor;
    }
}

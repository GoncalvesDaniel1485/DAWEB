package src.dto;

public class AlunoDTO {
    private int matricula;
    private String nome;
    private String cpf;
    private int idade;

    public AlunoDTO(int matricula, String nome, String cpf, int idade) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
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

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + " | Matrícula: " + matricula + " | Idade: " + idade;
    }
}

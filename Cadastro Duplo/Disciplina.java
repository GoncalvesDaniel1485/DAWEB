/*1. Faça um cadastro de Disciplina e Estudante seguindo a mesma estrutura que você fez em sala de aula
2. Você deve fazer um menu onde as opções são: 1 – Cadastrar Disciplina, 2 - Cadastrar Estudante, 3 - Inserir estudante na disciplina, 4 - Listar, 5 – Sair. 
3. Caso o usuário digite 1, você deve pedir os dados para cadastrar uma disciplina e guardar em memória (e depois voltar para o menu)
4. Caso o usuário digite 2, você deve pedir os dados para cadastrar um estudante e guardar em memória (e depois voltar para o menu)
5. Caso o usuário digite 3, você deve pedir qual estudante e em qual disciplina ele quer inserir, e fazer a inserção (e depois voltar para o menu)
6. Caso digite 4, você deve listar todas as disciplinas (com seus estudantes) e estudantes cadastrados (e depois voltar para o menu)
7. Caso clique em sair, você deve encerrar o programa. */

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

    public String toString() {
        return "Disciplina: " + nome + " | Código da Disciplina: " + cod + " | Professor: " + professor;
    }
}
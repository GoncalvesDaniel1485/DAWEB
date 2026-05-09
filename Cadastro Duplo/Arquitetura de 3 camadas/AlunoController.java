import java.util.ArrayList;

public class AlunoController {
    private AlunoService service = new AlunoService();

    public void cadastrar(int matricula, String nome, String cpf, int idade) {
        try {
            service.cadastrar(matricula, nome, cpf, idade);
            System.out.println("Aluno cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void editar(int matricula, String nome, String cpf, int idade) {
        try {
            boolean ok = service.editar(matricula, nome, cpf, idade);
            if (ok) System.out.println("Aluno atualizado com sucesso!");
            else    System.out.println("Aluno não encontrado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void matricular(int matricula, Disciplina d) {
        try {
            service.matricular(matricula, d);
            System.out.println("Aluno matriculado na disciplina com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Aluno buscar(int matricula) { 
        return service.buscar(matricula); 
    }

    public ArrayList<Aluno> listar() { 
        return service.listar(); 
    }
}

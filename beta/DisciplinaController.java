import java.util.ArrayList;

public class DisciplinaController {
    private DisciplinaService service = new DisciplinaService();

    public void cadastrar(int cod, String nome, String professor, String curso) {
        try {
            service.cadastrar(cod, nome, professor, curso);
            System.out.println("Disciplina cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void editar(int cod, String nome, String professor, String curso) {
        try {
            boolean ok = service.editar(cod, nome, professor, curso);
            if (ok) System.out.println("Disciplina atualizada com sucesso!");
            else    System.out.println("Disciplina não encontrada.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Disciplina buscar(int cod) { 
        return service.buscar(cod); 
    }

    public ArrayList<Disciplina> listar() { 
        return service.listar(); 
    }
}
import java.util.ArrayList;

public class CadastroDisciplina {
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public void cadastrar(Disciplina d) {
        disciplinas.add(d);
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Disciplina buscar(int cod) {
        for (Disciplina d : disciplinas) {
            if (d.getCod() == cod)
                return d;
        }
        return null;
    }
}
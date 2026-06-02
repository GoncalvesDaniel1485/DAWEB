package src.presentation;

import src.business.AlunoService;
import src.business.DisciplinaService;
import src.dto.AlunoDTO;
import src.dto.DisciplinaDTO;
import src.service.PrinterService;
import src.service.ReaderService;

public class Menu {
    private static final PrinterService printer = new PrinterService();
    private static final ReaderService  reader  = new ReaderService();

    private static final DisciplinaService discService   = new DisciplinaService();
    private static final AlunoService      alunoService  = new AlunoService(discService.getRepository());

    private static final AlunoController      alunoCtrl = new AlunoController(alunoService);
    private static final DisciplinaController discCtrl  = new DisciplinaController(discService);

    public static void executar() {
        int op;
        do {
            printer.println("\n========== MENU ==========");
            printer.println("1 - Cadastrar Disciplina");
            printer.println("2 - Cadastrar Aluno");
            printer.println("3 - Matricular Aluno em Disciplina");
            printer.println("4 - Listar");
            printer.println("5 - Editar Aluno");
            printer.println("6 - Editar Disciplina");
            printer.println("7 - Sair");
            printer.println("==========================");

            op = reader.nextInt();

            switch (op) {
                case 1: cadastrarDisciplina(); break;
                case 2: cadastrarAluno();      break;
                case 3: matricularAluno();     break;
                case 4: listar();              break;
                case 5: editarAluno();         break;
                case 6: editarDisciplina();    break;
                case 7: printer.println("Programa encerrado."); break;
                default: printer.println("Opção inválida.");
            }
        } while (op != 7);
    }

    private static void cadastrarDisciplina() {
        printer.println("Código: ");       int cod       = reader.nextInt();
        printer.println("Nome: ");         String nome   = reader.nextLine();
        printer.println("Professor: ");    String prof   = reader.nextLine();
        printer.println("Curso: ");        String curso  = reader.nextLine();
        discCtrl.cadastrar(cod, nome, prof, curso);
    }

    private static void cadastrarAluno() {
        printer.println("Matrícula: ");         int mat    = reader.nextInt();
        printer.println("Nome: ");              String nome = reader.nextLine();
        printer.println("CPF (11 dígitos): ");  String cpf  = reader.nextLine();
        printer.println("Idade: ");             int idade   = reader.nextInt();
        alunoCtrl.cadastrar(mat, nome, cpf, idade);
    }

    private static void matricularAluno() {
        printer.println("\n--- ALUNOS ---");
        for (AlunoDTO a : alunoCtrl.listar())
            printer.println(a.toString());

        printer.println("Matrícula do aluno: ");
        int mat = reader.nextInt();

        printer.println("\n--- DISCIPLINAS ---");
        for (DisciplinaDTO d : discCtrl.listar())
            printer.println(d.toString());

        printer.println("Código da disciplina: ");
        int cod = reader.nextInt();

        alunoCtrl.matricular(mat, cod);
    }

    private static void listar() {
        printer.println("\n--- ALUNOS ---");
        for (AlunoDTO a : alunoCtrl.listar())
            printer.println(a.toString());

        printer.println("\n--- DISCIPLINAS ---");
        for (DisciplinaDTO d : discCtrl.listar()) {
            printer.println(d.toString());
            for (AlunoDTO a : discCtrl.listarAlunosDaDisciplina(d.getCod()))
                printer.println("  -> " + a);
        }
    }

    private static void editarAluno() {
        printer.println("\n--- ALUNOS ---");
        for (AlunoDTO a : alunoCtrl.listar())
            printer.println(a.toString());

        printer.println("Matrícula do aluno a editar: ");
        int mat = reader.nextInt();
        printer.println("Novo nome: ");              String nome = reader.nextLine();
        printer.println("Novo CPF (11 dígitos): ");  String cpf  = reader.nextLine();
        printer.println("Nova idade: ");             int idade   = reader.nextInt();
        alunoCtrl.editar(mat, nome, cpf, idade);
    }

    private static void editarDisciplina() {
        printer.println("\n--- DISCIPLINAS ---");
        for (DisciplinaDTO d : discCtrl.listar())
            printer.println(d.toString());

        printer.println("Código da disciplina a editar: ");
        int cod = reader.nextInt();
        printer.println("Novo nome: ");       String nome = reader.nextLine();
        printer.println("Novo professor: ");  String prof = reader.nextLine();
        printer.println("Novo curso: ");      String curso = reader.nextLine();
        discCtrl.editar(cod, nome, prof, curso);
    }
}

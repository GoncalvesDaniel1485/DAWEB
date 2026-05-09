import java.util.Scanner;

public class Menu {
    public static void executar() {
        Scanner sc = new Scanner(System.in);
        AlunoController alunoCtrl = new AlunoController();
        DisciplinaController discCtrl = new DisciplinaController();

        int op;

        do {
            System.out.println("\n1 - Cadastrar Disciplina");
            System.out.println("2 - Cadastrar Aluno");
            System.out.println("3 - Inserir aluno na disciplina");
            System.out.println("4 - Listar");
            System.out.println("5 - Editar Aluno");
            System.out.println("6 - Editar Disciplina");
            System.out.println("7 - Sair");
            System.out.print("Selecione uma opcao: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.print("Codigo: ");
                    int cod = Integer.parseInt(sc.nextLine());
                    System.out.print("Nome: ");
                    String nomeD = sc.nextLine();
                    System.out.print("Professor: ");
                    String prof = sc.nextLine();
                    System.out.print("Curso: ");
                    String curso = sc.nextLine();
                    discCtrl.cadastrar(cod, nomeD, prof, curso);
                    break;

                case 2:
                    System.out.print("Matricula: ");
                    int mat = Integer.parseInt(sc.nextLine());
                    System.out.print("Nome: ");
                    String nomeA = sc.nextLine();
                    System.out.print("CPF (11 digitos): ");
                    String cpf = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(sc.nextLine());
                    alunoCtrl.cadastrar(mat, nomeA, cpf, idade);
                    break;

                case 3:
                    System.out.println("\n--- ALUNOS ---");
                    for (Aluno a : alunoCtrl.listar())
                        System.out.println(a);
                    System.out.print("Matricula do aluno: ");
                    int m = Integer.parseInt(sc.nextLine());

                    System.out.println("\n--- DISCIPLINAS ---");
                    for (Disciplina d : discCtrl.listar())
                        System.out.println(d);
                    System.out.print("Codigo da disciplina: ");
                    int c = Integer.parseInt(sc.nextLine());

                    Disciplina discEscolhida = discCtrl.buscar(c);
                    if (discEscolhida != null)
                        alunoCtrl.matricular(m, discEscolhida);
                    else
                        System.out.println("Disciplina não encontrada.");
                    break;

                case 4:
                    
                    System.out.println("\n--- ALUNOS ---");
                    for (Aluno a : alunoCtrl.listar())
                        System.out.println(a);

                    System.out.println("\n--- DISCIPLINAS ---");
                    for (Disciplina d : discCtrl.listar()) {
                        System.out.println(d);
                        for (Aluno a : d.getAlunos())
                            System.out.println("  - " + a);
                    }
                    break;

                case 5:
                    System.out.println("\n--- ALUNOS ---");
                    for (Aluno a : alunoCtrl.listar())
                        System.out.println(a);
                    System.out.print("Matricula do aluno a editar: ");
                    int matEdit = Integer.parseInt(sc.nextLine());
                    System.out.print("Novo nome: ");
                    String novoNomeA = sc.nextLine();
                    System.out.print("Novo CPF (11 digitos): ");
                    String novoCpf = sc.nextLine();
                    System.out.print("Nova idade: ");
                    int novaIdade = Integer.parseInt(sc.nextLine());
                    alunoCtrl.editar(matEdit, novoNomeA, novoCpf, novaIdade);
                    break;

                case 6:
                    System.out.println("\n--- DISCIPLINAS ---");
                    for (Disciplina d : discCtrl.listar())
                        System.out.println(d);
                    System.out.print("Codigo da disciplina a editar: ");
                    int codEdit = Integer.parseInt(sc.nextLine());
                    System.out.print("Novo nome: ");
                    String novoNomeD = sc.nextLine();
                    System.out.print("Novo professor: ");
                    String novoProf = sc.nextLine();
                    System.out.print("Novo curso: ");
                    String novoCurso = sc.nextLine();
                    discCtrl.editar(codEdit, novoNomeD, novoProf, novoCurso);
                    break;

                case 7:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (op != 7);

        sc.close();
    }
}

import java.util.Scanner;

public class Menu {
    public static void executar() {
        Scanner sc = new Scanner(System.in);
        CadastroAluno ca = new CadastroAluno();
        CadastroDisciplina cd = new CadastroDisciplina();

        int op;

        do {
            System.out.println("\n1 - Cadastrar Disciplina");
            System.out.println("2 - Cadastrar Aluno");
            System.out.println("3 - Inserir aluno na disciplina");
            System.out.println("4 - Listar");
            System.out.println("5 - Sair");
            System.out.print("Selecione uma opção: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.print("Código: ");
                    int cod = Integer.parseInt(sc.nextLine());

                    System.out.print("Nome: ");
                    String nomeD = sc.nextLine();

                    System.out.print("Professor: ");
                    String prof = sc.nextLine();

                    System.out.print("Curso: ");
                    String curso = sc.nextLine();

                    cd.cadastrar(new Disciplina(cod, nomeD, prof, curso));
                    break;

                case 2:
                    System.out.print("Matrícula: ");
                    int mat = Integer.parseInt(sc.nextLine());

                    System.out.print("Nome: ");
                    String nomeA = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(sc.nextLine());

                    ca.cadastrar(new Aluno(mat, nomeA, cpf, idade));
                    break;

                case 3:
                    System.out.print("Matrícula do aluno: ");
                    int m = Integer.parseInt(sc.nextLine());

                    System.out.print("Código da disciplina: ");
                    int c = Integer.parseInt(sc.nextLine());

                    Aluno a = ca.buscar(m);
                    Disciplina d = cd.buscar(c);

                    if (a != null && d != null) {
                        a.adicionarDisciplina(d);
                        d.adicionarAluno(a);
                        System.out.println("Aluno inserido na disciplina.");
                    } else {
                        System.out.println("Aluno ou disciplina não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- DISCIPLINAS ---");
                    for (Disciplina disc : cd.getDisciplinas()) {
                        System.out.println(disc);
                        for (Aluno aluno : disc.getAlunos()) {
                            System.out.println("  - " + aluno);
                        }
                    }

                    System.out.println("\n--- ALUNOS ---");
                    for (Aluno aluno : ca.getAlunos()) {
                        System.out.println(aluno);
                    }
                    break;

                case 67:
                    System.out.println("Acesso negado: tentativa de deletar System32 detectada...");
                    break;

                case 5:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opcão inválida.");

            }

        } while (op != 5);

        sc.close();
    }
}
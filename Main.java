import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CadastroPessoa cadastro = new CadastroPessoa(5);

        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar Pessoa");
            System.out.println("2 - Listar Pessoas");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- CADASTRAR PESSOA ---");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();

                    Pessoa p = new Pessoa(nome, telefone, endereco);
                    cadastro.cadastrarPessoa(p);

                    System.out.println("Cadastro realizado");
                    break;

                case 2:
                    cadastro.listarPessoas();
                    break;

                case 3:
                    System.out.println("Fim.");
                    break;

                default:
                    System.out.println("Inválido.");
            }

        } while (opcao != 3);

        sc.close();
        
    }
}
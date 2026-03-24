public class CadastroPessoa {

    private Pessoa[] pessoas;
    private int total = 0;
    
        public CadastroPessoa(int quantidade){
        this.pessoas = new Pessoa[quantidade];
        
    }

    public void cadastrarPessoa(Pessoa p) {
        if (total < pessoas.length) {
            pessoas[total++] = p;
        } else {
            System.out.println("Limite de pessoas atingido!");
        }
    }

    public void listarPessoas() {
        System.out.println("--- PESSOAS ---");
        for (Pessoa p : pessoas){
        if (p != null) {
        System.out.println(p);
    }
        }
    }
}
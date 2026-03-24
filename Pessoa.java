public class Pessoa{
    private String nome;
    private String telefone;
    private String endereco;

public Pessoa(String nome, String telefone, String endereco) {
    this.nome = nome;
    this.telefone = telefone;
    this.endereco = endereco;
    }

public String getNome() {
        return nome;
    }
public String getTelefone() {
        return telefone;
    }
public String getEndereco() {
        return endereco;
}
public void setNome(String nome) {
        this.nome = nome;
    }
public void setTelefone(String telefone) {
        this.telefone = telefone;
}
public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

public String toString() {
        return "Pessoa{" +
                "nome: '" + nome + '\'' +
                ", telefone: '" + telefone + '\'' + 
                ", endereço: " + endereco +
                '}';
    }
}
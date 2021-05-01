
package biblioteca;

public class Editora {
    private String nome;

    public Editora(String nome) {
        this.nome = nome.trim().toLowerCase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }  
    
}

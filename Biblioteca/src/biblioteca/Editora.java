
package biblioteca;

public class Editora {
    private String nome;

    public Editora(String nome) {
        this.nome = nome.toLowerCase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }  
        
    @Override
    public String toString () {
        return this.nome;
    }
}

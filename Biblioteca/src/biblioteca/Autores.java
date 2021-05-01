
package biblioteca;

public class Autores {
    private String nome;

    public Autores(String nome) {
        this.nome = nome.trim().toLowerCase();
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


package biblioteca;

public class Autores {
    private String nome;

    public Autores(String nome) {
        this.nome = nome;
    }       
    
    public void pesquisar(String nome, Biblioteca biblio) {//melhorar
        for (int i=0; i<=biblio.biblioteca.size(); i++) {
            if (biblio.biblioteca.get(i).getNome() == nome) {
                biblio.exibirDados(biblio.biblioteca.get(i));
            } else {
                System.out.println("Livro não encontrado. Não cadastrado ou nome incorreto.");
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}

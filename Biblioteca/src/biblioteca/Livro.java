
package biblioteca;

public class Livro {
    //Atributos
    private int codigo;
    private String nome;
    private Autores autor;
    private Editora editora;
    private String area;
    
    //Construtor
    public Livro(int codigo, String nome, String nomeAutor, String nomeEditora, String area) {
        this.codigo = codigo;
        this.nome = nome;
        Autores autores = new Autores(nomeAutor);
        Editora editora = new Editora(nomeEditora);
        this.area = area;                
    }
    
    //Pegadores e Modificadores
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    } 

}

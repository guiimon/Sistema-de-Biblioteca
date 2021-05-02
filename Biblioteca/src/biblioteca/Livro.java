
package biblioteca;

public class Livro {
    //Atributos
    private int codigo;
    private String nome;
    private Autores[] autor;
    private Editora editora;
    private String area;
    
    //Metodos Construtores
    public Livro() {}
    public Livro(int codigo, String nome, Autores[] nomeAutor, String nomeEditora, String area) {
        this.codigo = codigo;
        this.nome = nome.toLowerCase();
        setAutor(nomeAutor);
        editora = new Editora(nomeEditora);
        this.area = area.toLowerCase();            
    }
    
    //Pegadores e Modificadores
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autores[] getAutor() {
		return autor;
	}
	public void setAutor(Autores[] autor) {
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
    
    public String EscreveAutores() {
    	String autores = "";
    	for (int i=0; i<getAutor().length; i++) {
    		if(i==getAutor().length-1) {
    			autores += getAutor()[i].getNome()+".";
    		}
    		
    		autores+= getAutor()[i].getNome()+", ";
    	}
    	return autores;
    }
    
    @Override
    public String toString () {
        return "\n\nCódigo: " + this.codigo + ", \n"
                + "Nome: " + this.nome + ", \n"
                + "Autor: " + this.getAutor() + ", \n"
                + "Editora: " + this.getEditora() + ", \n"
                + "área da Advocacia: " + this.area;
    }
}

package biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

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
    
     public void registrarLivro() {
    	File caminho = new File("C:/Biblioteca/livro");
    	File arquivo = new File(caminho, String.valueOf(getCodigo())+".txt" );
    	if(!(caminho.exists())); caminho.mkdir();
    	if(!(arquivo.exists())) {
            try {
            
            	arquivo.createNewFile();
            
            	FileWriter fileWriter = new FileWriter(arquivo, true);
            	PrintWriter printWriter = new PrintWriter(fileWriter);
            	
            	printWriter.println(getCodigo());
            	printWriter.println(getNome());
            	printWriter.println(Arrays.toString(getAutor()));
            	printWriter.println(getEditora());
            	printWriter.println(getArea());         	           	
            
            	printWriter.flush();
                       	
            	printWriter.close();
            
            } catch (IOException e) {
                e.printStackTrace();
            }
    	} else {
            System.out.println("Arquivo com o codigo ja criado.");
    	}
    }
     
     public void recebeLivro(int codigo) {
    	String caminho = "C:/Biblioteca/livro";
      	File arquivo = new File(caminho, codigo+".txt" );
    	if(arquivo.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(caminho+ "/" + codigo+".txt"));
                setCodigo(Integer.parseInt(br.readLine()));
                setNome(br.readLine());
                setAutor(criaAutores(br.readLine()));
                setEditora(new Editora(br.readLine()));
                setArea(br.readLine());                              
                
                br.close();
            } catch (FileNotFoundException e) {               
                e.printStackTrace();
            } catch (IOException e) {	
                e.printStackTrace();
            }
    	} else {
            System.out.println("Caminho especificado nao existe.");
    	}
    }
    
    public void editaLivro() {
    	File caminho = new File("C:/Biblioteca/livro");
    	File arquivo = new File(caminho, String.valueOf(getCodigo())+".txt" );
    	
    	if(!(caminho.exists())){
            caminho.mkdir();
    	}
    	if(arquivo.exists()) {
            try {
            
            	arquivo.createNewFile();
                       	
            	FileWriter fileWriter = new FileWriter(arquivo, false);            
            	PrintWriter printWriter = new PrintWriter(fileWriter);
            
            	printWriter.println(getCodigo());
            	printWriter.println(getNome());
            	printWriter.println(Arrays.toString(getAutor()));
            	printWriter.println(getEditora());
            	printWriter.println(getArea());            	
            
            	printWriter.flush();
                       	
            	printWriter.close();
            
            } catch (IOException e) {
                e.printStackTrace();
            }
    	} else {
            System.out.println("Arquivo especificado nao existe.");
    	}
    }
    
    public void excluirLivro() {
    	File caminho = new File("C:/Biblioteca/livro");
    	File arquivo = new File(caminho, getCodigo()+".txt" );
    	if(arquivo.delete()) {
            System.out.println("Deletado aquivo "+arquivo.getName());
    	} else {
            System.out.println("Arquivo nao existe.");
    	}
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
                //+ "Autor: " + this.getAutor() + ", \n"
                + "Editora: " + this.getEditora() + ", \n"
                + "Área da Advocacia: " + this.area;

    }
    
    public Autores[] criaAutores(String codigo) {
    	String[] nomes = codigo.replace("[", "").replace("]", "").split(", ");
    	Autores[] autor = new Autores[nomes.length];
    	for (int i = 0; i <autor.length; i++) {
        	autor[i] = new Autores(nomes[i]);
        }
    	return autor;
    }
    
 
}

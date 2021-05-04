
package biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Funcionario {
    //atributos
    private String matricula;
    private String nome;
    private int oab;
    private String[] livrosEmprestados = new String[3];//so pode pegar 4 livros emprestados (0,1,2,3)
    

    //construtor
    //para quem tem OAB
    public Funcionario(String matricula, String nome, int oab) {
        this.matricula = matricula.toLowerCase();
        this.nome = nome.toLowerCase();
        this.oab = oab;
    }
    //para quem N√ÉO tem OAB
    public Funcionario(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.oab = 0;
    }    
    
    //metodos
    public void registraFuncionario() {
    	File caminho = new File("C:\\biblioteca\\funcionario");
    	File arquivo = new File(caminho, getMatricula()+".txt" );
    	if(!(caminho.exists())); caminho.mkdir();
    	if(!(arquivo.exists())) {
    		try {
    			arquivo.createNewFile();
    			
    			FileWriter fileWriter = new FileWriter(arquivo, true);
            	PrintWriter printWriter = new PrintWriter(fileWriter);
            	
            	printWriter.println(getMatricula());
            	printWriter.println(getNome());
            	printWriter.println(getOab());
            	printWriter.println(Arrays.toString(getLivrosEmprestados()));
            	printWriter.flush();
            	
            	printWriter.close();
    		}catch(IOException e){
    			e.printStackTrace();
    		}
    	}
    }
    
    public void recebeFuncionario(String matricula) {
    	String caminho = "C:\\Biblioteca\\funcionario";
      	File arquivo = new File(caminho, matricula+".txt" );
    	if(arquivo.exists()) {
    		try {
				BufferedReader br = new BufferedReader(new FileReader(caminho+ "/" + matricula+".txt"));
				setMatricula(br.readLine());
				setNome(br.readLine());
				setOab(Integer.parseInt(br.readLine()));
				String[] codigos = new String[4];
				codigos = br.readLine().replace("[","").replace("]", "").split(", ");
				setLivrosEmprestados(codigos);
				br.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {	
				e.printStackTrace();
			}
    	}
    	else {
    		System.out.println("Caminho especificado n„o existe.");
    	}
    }
    
     public void editaFuncionario() {
    	 
    	 File caminho = new File("C:\\Biblioteca\\funcionario");
    	 File arquivo = new File(caminho, getMatricula()+".txt" );
    	    	
    	 if(!(caminho.exists())){
    	 	 caminho.mkdir();
    	 }
    	 if(arquivo.exists()) {
    		 try {
     			arquivo.createNewFile();
     			
     			FileWriter fileWriter = new FileWriter(arquivo, false);
             	PrintWriter printWriter = new PrintWriter(fileWriter);
             	
             	printWriter.println(getMatricula());
             	printWriter.println(getNome());
             	printWriter.println(getOab());
             	printWriter.println(Arrays.toString(getLivrosEmprestados()));
             	printWriter.flush();
             	
             	printWriter.close();
     		}catch(IOException e){
     			e.printStackTrace();
     		}
    	 }else {
    		 System.out.println("Arquivo especificado n„o existe.");
    	 }
     }
    
     public void excluirFuncionario() {
    	 
    	 File caminho = new File("C:\\Biblioteca\\funcionario");
     	 File arquivo = new File(caminho, getMatricula()+".txt" );
     	
     	 if(arquivo.delete()) {
    		 System.out.println("Deletado aquivo "+arquivo.getName());
    	 }else {
    		 System.out.println("Arquivo n„o existe.");
    	 }
     }
    
    //pegadores e modificadores
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getOab() {
        return oab;
    }

    public void setOab(int oab) {
        this.oab = oab;
    }

    public String[] getLivrosEmprestados() {
        return livrosEmprestados;
    }
    
    public void setLivrosEmprestados(String[] livros) {
    	livrosEmprestados = livros; 
    }
}

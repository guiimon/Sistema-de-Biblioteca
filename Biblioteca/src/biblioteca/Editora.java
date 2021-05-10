
package biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        
    public void registraEditora() {
    	File caminho = new File("C:/Biblioteca/editora");
    	File arquivo = new File(caminho, getNome()+".txt" );
    	
    	if(!(caminho.exists())); caminho.mkdir();
    	if(!(arquivo.exists())) {
            try {
                arquivo.createNewFile();

                FileWriter fileWriter = new FileWriter(arquivo, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printWriter.println(getNome());
                printWriter.flush();

                printWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
    	}
    }
    
    public void recebeEditora(String nome) {
    	String caminho = "C:/Biblioteca/editora";
      	File arquivo = new File(caminho, nome+".txt" );
    	if(arquivo.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(caminho+ "/" + nome+".txt"));
                setNome(br.readLine());
                br.close();

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {	
                e.printStackTrace();
            }
        }
    }
    
    public void editaEditora() {
    	File caminho = new File("C:/biblioteca/editora");
    	File arquivo = new File(caminho, getNome()+".txt" );
      	if(!(caminho.exists())) {
            caminho.mkdir();
      	}
      	if(arquivo.exists()) {
            try {
                arquivo.createNewFile();

                FileWriter fileWriter = new FileWriter(arquivo, false);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printWriter.println(getNome());

                printWriter.flush();

                printWriter.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
      	}  	
    }
    
    public void excluirFuncionario() {
    	File caminho = new File("C:/biblioteca/editora");
    	File arquivo = new File(caminho, getNome()+".txt" );
    	
    	if(arquivo.delete()) {
            System.out.println("Deletado aquivo "+arquivo.getName());
        } else {
            System.out.println("Arquivo nao existe.");
        }
}
    
    @Override
    public String toString () {
        return this.nome;
    }
}

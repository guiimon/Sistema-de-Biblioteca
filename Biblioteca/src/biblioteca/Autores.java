package biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Autores {
    private String nome;
   
    public Autores(){}
    public Autores(String nome) {
        this.nome = nome.toUpperCase();
    }       
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
    public void registraAutor() {
    	File caminho = new File("C:\\biblioteca\\autor");
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
    		}catch(IOException e){
    			e.printStackTrace();
    		}
    	}
    }
   
   public void recebeAutor(String nome) {
	   File caminho = new File("C:\\biblioteca\\autor");
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
	   }else {
		   System.out.println("Caminho especificado não existe.");
	   }
   }
    
   public void editaAutor() {
	   File caminho = new File("C:\\biblioteca\\autor");
	   File arquivo = new File(caminho, getNome()+".txt" );
	   
	   if(!(caminho.exists())){
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
  		 } catch(IOException e){
  			e.printStackTrace();
  		 }
  	 }else {
  		System.out.println("Arquivo especificado não existe.");
  	 }
   }
   
   public void excluirAutor() {
  	 
  	 File caminho = new File("C:\\Biblioteca\\autor");
   	 File arquivo = new File(caminho, getNome()+".txt" );
   	
   	 if(arquivo.delete()) {
  		 System.out.println("Deletado aquivo "+arquivo.getName());
  	 }else {
  		 System.out.println("Arquivo não existe.");
  	 }
   }
   
    @Override
    public String toString () {
        return this.nome;
    }
    
}

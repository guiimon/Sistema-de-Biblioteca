
package Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NewFile {
    
    public static void main(String[] args) {
        
        //listaArquivo();//exibe os diretorios absolutos dos arquivos
        pesquisar("c:/Biblioteca/Livros", "Adv Books");
        
        
    }
    
    public static void pesquisar(String caminho, String nome) {
        File arquivo = new File(caminho);                  
                              //listFiles retorna um vetor
        File lista [] = arquivo.listFiles();//o vetor "lista" recebe o vetor de "arquivo". 
        int n = 0;        
        for (int i=0; i<lista.length; i++) {
           try {         
                FileReader ler = new FileReader(lista[i]);
                BufferedReader lerb = new BufferedReader(ler);
                String linha = "";
                
                while ( (linha = lerb.readLine()) != null ) {

                    if (linha.equals(nome.toLowerCase())) {
                        System.out.println("");
                        ler(lista[i]); 
                        System.out.println("");
                        n++;
                    }                                                  
                }
                lerb.close();
                ler.close(); 
                
           } catch (IOException e) {
                System.out.println(e.toString());                
            }         
        }
        if (n == 0) {
            System.out.println("Não encontrado.");
        }                   
    }
    
    public static void listaArquivo() {
        File arquivo = new File("c:/Biblioteca/Livros");
        File lista [] = arquivo.listFiles();//o vetor "lista" recebe o vetor de "arquivo"
        
        for (int i=0; i<lista.length; i++) {
            System.out.println(lista[i]);//exibe os diretorios absolutos dos arquivos dentro da pasta Livros
        }
        
    }
    
    public static void escrever(String texto) {
        try {
            FileWriter onde  = new FileWriter("c:/Biblioteca/Livros/livros.txt", true);
            BufferedWriter escrever = new BufferedWriter(onde);
            escrever.write(texto);
            
            onde.close();
            escrever.close();
        } catch (IOException e) {
            
        }
    }
    
    public static void ler(File caminho) {
        try {
            //File arquivo = new File("c:/Biblioteca/Livros/livros.txt");
            FileReader ler = new FileReader(caminho);
            BufferedReader lerb = new BufferedReader(ler);
            String linha = "";
            
             while ((linha = lerb.readLine()) != null ) {
                System.out.println(linha);
            }
            
            lerb.close();
            ler.close();
            //System.out.println("Arquivo lido com sucesso");
            
        } catch (IOException e) {
            
        }
    }
    
    public static void criarDiretorio(String caminho) {
        File diretorio = new File(caminho);
        try {
            if (!diretorio.exists()) {
                diretorio.mkdirs();
                System.out.println("Diretorio criado com sucesso.");
            } else {
                System.out.println("Diretorio já existe!"); 
            }
        } catch (Exception e) {
            System.out.println("\nErro: ");
            e.printStackTrace();
        }    
    }
    
    public static void criarArquivo(String caminho) {
        try {
            File arquivo = new File(caminho);
            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado com sucesso");
            } else {
                System.out.println("Arquivo já existe!");
            }
        } catch (IOException e) {//IOException para quando envolver arquivo
            System.out.println("\nErro: ");
            e.printStackTrace();
        }
   
    }
    
    
}

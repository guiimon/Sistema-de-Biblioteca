package biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LivroDAO {

    public static void registrarLivro(Livro livro) {
        File dir = new File("C:\\BancoLivros");
        File arq = new File(dir, "LivrosRegistrados.txt");
        
        try {
            
            arq.createNewFile();
            
            /*
            O false apagaria o conteúdo do arquivo e escreveria
            o novo conteúdo.
            Se não usar o 2° parâmetro, ele por padrão será false.
            O mais importante, essa linha abre o fluxo do arquivo
            */
            FileWriter fileWriter = new FileWriter(arq, true);
            
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            printWriter.println(livro.getCodigo());
            printWriter.println(livro.getNome());
            printWriter.println(livro.getAutor());
            printWriter.println(livro.getEditora());
            printWriter.println(livro.getArea());
            
            printWriter.flush();
            
            //No final precisamos fechar o arquivo
            printWriter.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void listarLivros() {
        
        File dir = new File("C:\\BancoLivros");
        File arq = new File(dir, "LivrosRegistrados.txt");
        
        try {
            
            FileReader fileReader = new FileReader(arq);
            
            // oferece o método de leitura readLine()
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String linha = "";
            
            while((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }
            
            fileReader.close();
            bufferedReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

/*
Data Access Object - DAO
*/

package biblioteca.dao;

import biblioteca.Autores;
import biblioteca.Livro;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class LivroDAO {
    
    public static final String PATH = "C:\\BancoLivros";
    private static final String FILE = "LivrosRegistrados.txt";

    public static void registrarLivro(Livro livro) {

        File dir = new File(PATH);
        File arq = new File(dir, FILE);
        
        try {
            
            if (!dir.exists()) dir.mkdir();                
            if (!arq.exists()) arq.createNewFile();
                
            /*
            O false apagaria o conteúdo do arquivo e escreveria
            o novo conteúdo.
            Se não usar o 2° parâmetro, ele por padrão será false.
            O mais importante, essa linha abre o fluxo do arquivo
            */
            FileWriter fileWriter = new FileWriter(arq, true);
            
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            printWriter.println("Código: " + livro.getCodigo());
            printWriter.println("Nome: " + livro.getNome());
            //printWriter.println("Autor: " + Autores.layout());
            printWriter.println("Editora:" + livro.getEditora());
            printWriter.println("Área da advocacia: " + livro.getArea());
            printWriter.print("\n");
            
            printWriter.flush();
            
            //No final precisamos fechar o arquivo
            printWriter.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void listarLivros() {

        File dir = new File(PATH);
        File arq = new File(dir, FILE);
        
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
    
    /*
        Livro livro = new Livro();
        //LivroDAO livroDao = new LivroDAO();
        
        
            // ---- REGISTRO DE LIVROS ---- //
        livro.setCodigo(75);
        livro.setNome("Tratado de direito penal");
        Autores[] lista = new Autores[1];
        lista[0] = new Autores("Cezar Roberto Bitencourt");
        livro.setAutor(lista);
        livro.setEditora(new Editora("Saraiva"));
        livro.setArea("Direito Penal");
        //livroDao.registrarLivro(livro);
        //livroDao.listarLivros();
        
        l0.registrarExemplar();
        Exemplar l2 = new Exemplar();        
        l2.recebeExemplar(4161);
        //l2.excluirExemplar();
        System.out.println(l2.getCodigo());
        System.out.println(new String[1].toString());
       */ 
}

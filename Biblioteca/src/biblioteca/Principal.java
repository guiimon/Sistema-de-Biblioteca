
package biblioteca;

import biblioteca.dao.LivroDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {//Classe Movimentação do diagrama UML

    	new CriaDiretorios();
    	Autores[] exemplo = new Autores[1];
    	exemplo[0] = new Autores("JJ. James");
        Exemplar l0 = new Exemplar(010101, "7 advogados e um cliente", exemplo , "ADV Books", "Direito civil", 100, 29, 04, 2021);
        Funcionario f0 = new Funcionario("ADV01", "Demolidor");      
        Biblioteca b = new Biblioteca();
        b.cadastrar(l0);
        b.cadastrar(f0);

        //exibirDados(l0);
        b.emprestarLivro(l0, f0);
        b.emprestarLivro(l0, f0);
        b.emprestarLivro(l0, f0);
        b.emprestarLivro(l0, f0);
        b.emprestarLivro(l0, f0);
        b.emprestarLivro(l0, f0);
        b.emprestarLivro(l0, f0);
        //pesquisarLivro("7 Advogados e um cliente");
        //pesquisarFuncionario("Demolidor");
        b.exibirDados(f0);
        /*String resposta = "";
        while (!"n".equals(resposta)) {
            System.out.println("O que deseja fazer?");
            Scanner tecla = new Scanner(System.in);
            String comando = tecla.nextLine();
            b.executar(comando, b);
            b.pesquisarLivro("big");
            System.out.println("Continuar?");
            resposta = tecla.nextLine();
        }
        */
//--------------------------------------------------------------------------------------        
        Exemplar livro = new Exemplar();
        LivroDAO livroDao = new LivroDAO();
        
            // ---- REGISTRO DE LIVROS ---- //
        livro.setCodigo(500);
        livro.setNome("Tratado de direito penal");
        //Autores.layout(autorList);
        livro.setEditora(new Editora("Saraiva"));
        livro.setArea("Direito Penal");

        //livroDao.registrarLivro(livro);
        //livroDao.listarLivros();
        livro.toString();
    
        /*
        Autores autor01 = new Autores("Paul Deitel");
        Autores autor02 = new Autores("H. M. Deitel");
        
        List<Autores> autorList = new ArrayList();
        autorList.add(autor01);
        autorList.add(autor02);
        */
        //System.out.println(autorList);
        
        //layout(autorList);
        
//----------------------------------------------------------------------------------------------------------------------------
        Autores[] lista = new Autores[1];
        lista[0] = new Autores("Cezar Roberto Bitencourt");
        livro.setAutor(lista);
        livro.setEditora(new Editora("Saraiva"));
        livro.setArea("Direito Penal");
        livroDao.registrarLivro(livro);
        livroDao.listarLivros();
        
        //l0.registrarExemplar();
        Exemplar l2 = new Exemplar();
        
		l2.recebeExemplar(4161);
        
        System.out.println(l2.getNome());

    }
    /*
    public static void layout(List<Autores> autores) {
        String path = LivroDAO.PATH;
        File dir = new File(path);
        File arq = new File(dir, "User2.txt");

        if (!dir.exists()) dir.mkdir();
        
        try {
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            //Utilizamos o método print() para escrever na mesma linha e um ponto e vírgula no final.
            // para o próximo user.
            for (Autores autor : autores) {
                printWriter.print(autor.getNome() + ",");
            }
            printWriter.flush();
            printWriter.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = "";
            
            //Lista que irá guardar o resultado, ou seja,
            // cada linha do arquivo que corresponde a um User
            List<String> result = new ArrayList();
            
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
                if (linha != null && !linha.isEmpty()) {
                    result.add(linha);
                }
            }
            fileReader.close();
            bufferedReader.close();
            
            for (String s : result) {
                //Usamos o método split da classe String
                // para separar as partes entre os ponto e vírgulas.
                //Guardamos o resultado em um array
                String[] autor = s.split(";");
                
                //Criamos um objeto User e setamos em seus atributos
                //as posições correspondentes do array
                Autores u = new Autores();
                u.setNome(autor[0]);
                
                //exibe o conteúdo do objeto u
                //System.out.println(u.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

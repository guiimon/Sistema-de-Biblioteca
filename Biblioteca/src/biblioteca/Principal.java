
package biblioteca;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

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
        }*/
        
        Livro livro = new Livro();
        LivroDAO livroDao = new LivroDAO();
        
        
            // ---- REGISTRO DE LIVROS ---- //
        livro.setCodigo(75);
        livro.setNome("Tratado de direito penal");
        Autores[] lista = new Autores[1];
        lista[0] = new Autores("Cezar Roberto Bitencourt");
        livro.setAutor(lista);
        livro.setEditora(new Editora("Saraiva"));
        livro.setArea("Direito Penal");
        livroDao.registrarLivro(livro);
        livroDao.listarLivros();
        
        //l0.registrarExemplar();
        Exemplar l2 = new Exemplar(12, "7 advogados e um cliente", exemplo , "ADV Books", "Direito civil", 100, 29, 04, 2021);
        
        try {
			l2.recebeExemplar(4161);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(l2.getCodigo());
    }
    
}

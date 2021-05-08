
package biblioteca;

import java.util.Scanner;

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
        
        String resposta = "";
        while (!"n".equals(resposta)) {
            System.out.println("Pressione enter para iniciar.");
            Scanner tecla = new Scanner(System.in);           
            String comando = tecla.nextLine();
            b.executar(comando, b);           
            System.out.println("Continuar? sim[s] ou nao[n] :");
            resposta = tecla.nextLine();
        }
        System.out.println("");
        System.out.println("Sistema encerrado.");   
    }
    
    
}

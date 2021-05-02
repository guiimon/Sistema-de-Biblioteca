
package biblioteca;

public class Principal {
    public static void main(String[] args) {//Classe Movimentação do diagrama UML
        
        Exemplar l0 = new Exemplar(010101, "7 advogados e um cliente", "JJ. James", "ADV Books", "Direito civil", 100, 29, 04, 2021);
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
        
    }
    
}

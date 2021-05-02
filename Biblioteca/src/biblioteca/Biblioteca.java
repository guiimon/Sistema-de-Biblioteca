
package biblioteca;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Optional.empty;
import java.util.Scanner;
        
public class Biblioteca {//Essa é a classe Movimentação do UML da prof  
        
    public static void main(String[] args) {
    //com o main aqui não preciso instaciar um objeto Biblioteca

    Livro livro = new Livro();
    LivroDAO livroDao = new LivroDAO();
    
    //Exemplar exmp = new Exemplar(010101, "7 advogados e um cliente", "JJ. James", "ADV Books", "Direito civil", 100, 29, 04, 2021);
    //Funcionario funcionario01 = new Funcionario("ADV01", "Demolidor");
    //Biblioteca b = new Biblioteca();
    
    // ---- REGISTRO DE LIVROS ---- //
    livro.setCodigo(75);
    livro.setNome("Tratado de direito penal");
    livro.setAutor(new Autores("Cezar Roberto Bitencourt"));
    livro.setEditora(new Editora("Saraiva"));
    livro.setArea("Direito Penal");
    
    livroDao.registrarLivro(livro);
    livroDao.listarLivros();
    //System.out.println(livro);

    //b.exibirDados(l0);
    //cadastrar(l0);//vou melhorar esses métodos para usarem String
    //cadastrar(f0);
    
    //exibirDados(l0);
    //emprestarLivro(l0, f0);
    //pesquisarLivro("7 Advogados e um cliente");//apesar do toLowerCase() não está reconhecendo 
    //pesquisarFuncionario("Demolidor");
    //exibirDados(f0);
    String resposta = "";
    while (!"n".equals(resposta)) {
        System.out.println("O que deseja fazer?");
        Scanner tecla = new Scanner(System.in);
        String comando = tecla.nextLine();
        executar(comando);
        pesquisarLivro("big");
        System.out.println("Continuar?");
        resposta = tecla.nextLine();
    }
    }
        
    
    //Atributos
    static ArrayList<Exemplar> biblioteca = new ArrayList();
    static ArrayList<Funcionario> usuarios = new ArrayList();
    private static Calendar dataEmprestimo; //Calendar é superior ao Date
    private static Calendar dataDevolucao;
    
    //Principal 
    public static void executar(String comando) {
        if (comando.equals("cadastrar livro")) {
            Scanner tecla = new Scanner(System.in);
            System.out.println("Digite o codigo do Livro");
            int codigo = tecla.nextInt();
            System.out.println("Digite o nome do Livro:");
            String nome = tecla.nextLine();
            
            System.out.println("Digite o autor do Livro:");
            String autor = tecla.nextLine();
            System.out.println("Digite a editora do Livro:");
            String editora = tecla.nextLine();
            System.out.println("Digite a área do Livro:");
            String area = tecla.nextLine();
            System.out.println("Digite o preço do Livro:");
            double preco = tecla.nextDouble();
            System.out.println("Digite o dia de aquisição deste Livro(dd):");
            int dia = tecla.nextInt();
            System.out.println("Digite o mês de aquisição deste Livro(mm):");
            int mes = tecla.nextInt();
            System.out.println("Digite o ano de aquisição deste Livro(yyyy):");
            int ano = tecla.nextInt();
            Exemplar e = new Exemplar(codigo, nome, autor, editora, area, preco, dia, mes, ano);
            cadastrar(e);
            
        }
    }
    
    public static void cadastrar(Exemplar exemplar) {
        biblioteca.add(exemplar);
    }

    public static void cadastrar(Funcionario funcionario) {
        usuarios.add(funcionario);
    }
       
    public static void exibirDados(Exemplar exemplar) {//Sobrecarregado e Sobreposto (Override and Overload)
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Livro.\n" + 
                        "codigo : " + exemplar.getCodigo() + "\n" +
                        "nome : " + exemplar.getNome() + "\n" +
                        "autor : " + exemplar.getAutor().getNome() + "\n" +
                        "editora : " + exemplar.getEditora().getNome() + "\n" +
                        "area : " + exemplar.getArea() + "\n" +                        
                        "data de aquisição : " + formata.format(exemplar.getDataAquisicao().getTime()) + "\n" +
                        "preço : R$" + exemplar.getPreco()  + "\n" +
                        "Foi emprestado? " + exemplar.getEmprestado() + "\n" +
                        "Está inativo? " + exemplar.getInativo()+ "\n");
    }   

    public static void exibirDados(Funcionario funcionario) {//Sobrecarregado e Sobreposto (Override and Overload)
        try {
            System.out.println("Funcionário.\n" + 
                   "Matricula : " + funcionario.getMatricula() + "\n" +
                   "Nome : " + funcionario.getNome());  
               if (funcionario.getOab() == 0) {
                   System.out.println("não possui OAB");
               } else {
                   System.out.println("OAB : " + funcionario.getOab());
               } 
               if (funcionario.getLivrosEmprestados() == null) {
                   System.out.println("Nenhum livro emprestado");
               } else {
                   System.out.println("Livros emprestados : ");
                   for (int i=0; i<funcionario.getLivrosEmprestados().length; i++) {
                       exibirDados(funcionario.getLivrosEmprestados()[i]);
                       System.out.println();
                   }
               }
        } catch (NullPointerException e) {
        //caso de esse erro o vetor está vazio, logo nenhum livro foi emprestado a esse funcionario 
            System.out.println("Nenhum livro emprestado\n");
        } 
    } 
          
    public static void livrosEmprestados() {//para as secretarias visualizarem os nome dos livros que foram emprestados
        System.out.println("Livros que foram emprestados:");
        for (int i=0; i<=biblioteca.size(); i++) {
            if (biblioteca.get(i).getEmprestado() == true) {
                System.out.println(biblioteca.get(i).getNome() +" | "+ biblioteca.get(i).getCodigo());
            }
        }
    }
    
    public static void pesquisarLivro(String nome) {
        for (int i=0; i<biblioteca.size(); i++) {
            if (biblioteca.get(i).getNome() == nome.toLowerCase()) {
                System.out.println("Livros Encontrados:");
                exibirDados(biblioteca.get(i));
            } else {
                System.out.println("Livro não encontrado. Não cadastrado ou nome incorreto.");
            }
        }
    }
    
    public static void pesquisarAutor(String nome) {
        for (int i=0; i<biblioteca.size(); i++) {
            if (biblioteca.get(i).getAutor().getNome() == nome.toLowerCase()) {
                System.out.println("Autores Encontrados:");
                exibirDados(biblioteca.get(i));
            } else {
                System.out.println("Livro não encontrado. Não cadastrado ou nome incorreto.");
            }
        }
    }
    
    public static void pesquisarEditora(String nome) {
        for (int i=0; i<biblioteca.size(); i++) {
            if (biblioteca.get(i).getEditora().getNome() == nome.toLowerCase()) {
                System.out.println("Editoras Encontrados:");
                exibirDados(biblioteca.get(i));
            } else {
                System.out.println("Livro não encontrado. Não cadastrado ou nome incorreto.");
            }
        }
    }
     
    public static void pesquisarFuncionario(String nome) {    
        for (int i=0; i<usuarios.size(); i++) {          
            if (usuarios.get(i).getNome().toLowerCase() == nome.toLowerCase()) {
                System.out.println("Funcionarios Encontrados:");
                exibirDados(usuarios.get(i));                                   
            } else {
                System.out.println("Funcionário(a) não encontrado(a). Não cadastrado(a) ou nome incorreto.");
            }
            
        }
    }

    public static void emprestarLivro(Exemplar exemplar, Funcionario funcionario) {
        dataEmprestimo = Calendar.getInstance();//pega a data atual
        dataDevolucao = Calendar.getInstance();
        dataDevolucao.add(Calendar.DAY_OF_MONTH, 5);//soma + 5 dias a data atual
        //vem no padrão americano, com a classe SimpleDateFormat formato para o BR
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        formata.format(dataEmprestimo.getTime());
        formata.format(dataDevolucao.getTime());
        if (exemplar.getEmprestado() == true) {
            System.out.println("Este livro já foi emprestado.");
        } else if (exemplar.getInativo() == true){
            System.out.println("Livro inservível. Avariado ou inativo.");
        } else {
            if ( funcionario.getLivrosEmprestados() == null) {//verificar isso           
                    System.out.println("Limite de livros emprestado ecxedido!");
                } else {
            for (int i=0; i<funcionario.getLivrosEmprestados().length; i++) {
                if (funcionario.getLivrosEmprestados()[i] == null ) {//verifica se tem uma posição vazia
                    funcionario.getLivrosEmprestados()[i] = exemplar;  //caso sim guarda nessa posição
                    exemplar.setEmprestado(true);
                }
            }
            }    
        }
    }
    
    public static void devolverLivro(Exemplar exemplar, Funcionario funcionario) {
        exemplar.setEmprestado(false);
        for (int i=0; i<4; i++) {
            if (funcionario.getLivrosEmprestados()[i] == exemplar) {//
                funcionario.getLivrosEmprestados()[i] = null;  //
            }
        }
    }
    
    public static void inativar(Exemplar exemplar) {
        exemplar.setInativo(true);
    }
    
    public static void ativar(Exemplar exemplar) {
        exemplar.setInativo(false);
    }
       
}

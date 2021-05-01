
package biblioteca;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Optional.empty;
        
public class Biblioteca {//Essa é a classe Movimentação do UML da prof  
        
    public static void main(String[] args) {
    //com o main aqui não preciso instaciar um objeto Biblioteca
    Exemplar l0 = new Exemplar(010101, "7 advogados e um cliente", "JJ. James", "ADV Books", "Direito civil", 100, 29, 04, 2021);
    Funcionario f0 = new Funcionario("ADV01", "Demolidor");
    Biblioteca b = new Biblioteca();

    //b.exibirDados(l0);
    cadastrar(l0);//vou melhorar esses métodos para usarem String
    exibirDados(f0);

    
    }
        
    
    //Atributos
    static ArrayList<Exemplar> biblioteca = new ArrayList();
    static ArrayList<Funcionario> usuarios = new ArrayList();
    private static Calendar dataEmprestimo; //Calendar é superior ao Date
    private static Calendar dataDevolucao;
    
    //Principal
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
                   System.out.println("não possui OAB" + "\n");
               } else {
                   System.out.println("OAB : " + funcionario.getOab() + "\n");
               } 
               if (funcionario.getLivrosEmprestados() == null) {//há um erro que será tratado
                   System.out.println("Nenhum livro emprestado");
               } else {
                   System.out.println("Livros emprestados : ");
                   for (int i=0; i<=funcionario.getLivrosEmprestados().length; i++) {
                       exibirDados(funcionario.getLivrosEmprestados()[i]);
                       System.out.println();
                   }
               }
        } catch (NullPointerException e) {
        //caso de esse erro o vetor está vazio, logo nenhum livro foi emprestado a esse funcionario 
            System.out.println("Nenhum livro emprestado");
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
            if (biblioteca.get(i).getNome() == nome.trim().toLowerCase()) {
                exibirDados(biblioteca.get(i));
            } else {
                System.out.println("Livro não encontrado. Não cadastrado ou nome incorreto.");
            }
        }
    }
    
    public static void pesquisarAutor(String nome) {
        for (int i=0; i<biblioteca.size(); i++) {
            if (biblioteca.get(i).getAutor().getNome() == nome.trim().toLowerCase()) {
                exibirDados(biblioteca.get(i));
            } else {
                System.out.println("Livro não encontrado. Não cadastrado ou nome incorreto.");
            }
        }
    }
    
    public static void pesquisarEditora(String nome) {
        for (int i=0; i<biblioteca.size(); i++) {
            if (biblioteca.get(i).getEditora().getNome() == nome.trim().toLowerCase()) {
                exibirDados(biblioteca.get(i));
            } else {
                System.out.println("Livro não encontrado. Não cadastrado ou nome incorreto.");
            }
        }
    }
     
    public static void pesquisarFuncionario(String nome) {
        for (int i=0; i<usuarios.size(); i++) {
            if ( usuarios.isEmpty() ){
                System.out.println("Funcionário(a) não encontrado(a). Não cadastrado(a) ou nome incorreto.");
            } else if (usuarios.get(i).getNome() == nome.trim().toLowerCase()) {//elimina espaços antes e depois
                exibirDados(usuarios.get(i));                                   //transforma em minusculo 
            } else {
                System.out.println("Funcionário(a) não encontrado(a). Não cadastrado(a) ou nome incorreto.");
            }
            
        }
    }

    public static void emprestarLivro(Exemplar exemplar, Funcionario funcionario) {
        dataEmprestimo = Calendar.getInstance();//pega a data atual
        dataDevolucao = Calendar.getInstance();
        dataDevolucao.add(Calendar.DAY_OF_MONTH, 5);//soma + 5 dias a data atual
        //vem no padrão americano com a classe SimpleDateFormat formato para o BR
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        formata.format(dataEmprestimo);
        formata.format(dataDevolucao);
        if (exemplar.getEmprestado() == true) {
            System.out.println("Este livro já foi emprestado.");
        } else if (exemplar.getInativo() == true){
            System.out.println("Livro inservível. Avariado ou inativo.");
        } else {
            for (int i=0; i<4; i++) {
                if (funcionario.getLivrosEmprestados()[i] == null) {//verifica se tem uma posição vazia
                    funcionario.getLivrosEmprestados()[i] = exemplar;  //caso sim guarda nessa posição
                    exemplar.setEmprestado(true);
                } else if ( funcionario.getLivrosEmprestados() == null ) {//verificar isso, há um erro                  
                    System.out.println("Limite de livros emprestado ecxedido!");
                }
            }
        }
    }
    
    public static void devolverLivro(Exemplar exemplar, Funcionario funcionario) {
        exemplar.setEmprestado(false);
        for (int i=0; i<4; i++) {
            if (funcionario.getLivrosEmprestados()[i] == exemplar) {//acho que não vai funcionar
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

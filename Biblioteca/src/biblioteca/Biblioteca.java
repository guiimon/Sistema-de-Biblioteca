
package biblioteca;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
        
    public class Biblioteca implements Interface {//Essa é a classe Movimentação do UML da prof
    //Atributos
    ArrayList<Exemplar> biblioteca = new ArrayList();
    ArrayList<Funcionario> usuarios = new ArrayList();
    private Calendar dataEmprestimo; //Calendar é superior ao Date
    private Calendar dataDevolucao;
    
    //Principal
    public void cadastrar(Exemplar exemplar) {
        biblioteca.add(exemplar);
    }

    public void cadastrar(Funcionario funcionario) {
        usuarios.add(funcionario);
    }
       
    public void exibirDados(Exemplar exemplar) { //Sobrecarregado e Sobreposto (Override and Overload)
        System.out.println("Livro.\n" + 
                        "codigo : " + exemplar.getCodigo() + "\n" +
                        "nome : " + exemplar.getNome() + "\n" +
                        "autor : " + exemplar.getAutor() + "\n" +
                        "editora : " + exemplar.getEditora() + "\n" +
                        "area : " + exemplar.getArea() + "\n" +
                        "data de aquisição : " + exemplar.getDataAquisicao() + "\n" +
                        "preço : R$" + exemplar.getPreco()  + "\n" +
                        "Foi emprestado? " + exemplar.getEmprestado() + "\n" +
                        "Está inativo? " + exemplar.getInativo());
    }   

    public void exibirDados(Funcionario funcionario) { //Sobrecarregado e Sobreposto (Override and Overload)
        System.out.println("Funcionário.\n" + 
               "Matricula : " + funcionario.getMatricula() + "\n" +
               "Nome : " + funcionario.getNome() + "\n");  
           if (funcionario.getOab() == 0) {
               System.out.println("não possui OAB");
           } else {
               System.out.println("OAB : " + funcionario.getOab() + "\n");
           } 
           if (funcionario.getLivrosEmprestados() == null) {//verificar isso, há um erro
               System.out.println("Nenhum livro emprestado");
           } else {
               System.out.println("Livros emprestados : ");
               for (int i=0; i<=funcionario.getLivrosEmprestados().length; i++) {
                   exibirDados(funcionario.getLivrosEmprestados()[i]);                 
               }
           }
    }
    
    public void livrosEmprestados() {//para as secretarias visualizarem os nome dos livros que foram emprestados
        System.out.println("Livros que foram emprestados:");
        for (int i=0; i<=biblioteca.size(); i++) {
            if (biblioteca.get(i).getEmprestado() == true) {
                System.out.println(biblioteca.get(i).getNome() +" | "+ biblioteca.get(i).getCodigo());
            }
        }
    }
    
    @Override
    public void pesquisarLivro(String nome) {
        for (int i=0; i<=biblioteca.size(); i++) {
            if (biblioteca.get(i).getNome() == nome) {
                exibirDados(biblioteca.get(i));
            } else {
                System.out.println("Livro não encontrado. Não cadastrado ou nome incorreto.");
            }
        }
    }
    
    @Override
    public void pesquisarFuncionario(String nome) {
        for (int i=0; i<=usuarios.size(); i++) {
            if (usuarios.get(i).getNome() == nome) {
                exibirDados(usuarios.get(i));
            } else {
                System.out.println("Funcionário(a) não encontrado(a). Não cadastrado(a) ou nome incorreto.");
            }
        }
    }

    public void emprestarLivro(Exemplar exemplar, Funcionario funcionario) {
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
                } else if ( funcionario.getLivrosEmprestados() == null ) {//verifica isso, há um erro                  
                    System.out.println("Limite de livros emprestado ecxedido!");
                }
            }
        }
    }
    
    public void devolverLivro(Exemplar exemplar, Funcionario funcionario) {
        exemplar.setEmprestado(false);
        for (int i=0; i<4; i++) {
            if (funcionario.getLivrosEmprestados()[i] == exemplar) {//acho que não vai funcionar
                funcionario.getLivrosEmprestados()[i] = null;  //
            }
        }
    }
    
    public void inativar(Exemplar exemplar) {
        exemplar.setInativo(true);
    }
    
    public void ativar(Exemplar exemplar) {
        exemplar.setInativo(false);
    }
}

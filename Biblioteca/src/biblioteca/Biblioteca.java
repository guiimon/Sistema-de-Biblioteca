package biblioteca;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
        
public class Biblioteca {//Essa é a classe Movimentação do UML da prof    
    //Atributos
    static ArrayList<Exemplar> biblioteca = new ArrayList();
    static ArrayList<Funcionario> usuarios = new ArrayList<>();
    private  Calendar dataEmprestimo; //Calendar é superior ao Date
    private  Calendar dataDevolucao;
    
    //Principal 
    public void executar(String comando, Biblioteca b) {
        Scanner tecla = new Scanner(System.in);
        Scanner tecla1 = new Scanner(System.in);
        System.out.println("Ola, voce e um funcionario ou secretaria?");
        String resp1 = tecla1.nextLine();
        if ("secretaria".equals(resp1)) {
            System.out.println("Ola, o que voce deseja fazer?\n"
                         + "cadastrar livro\n"
                         + "cadastrar funcionario\n"
                         + "pesquisar livro\n"
                         + "pesquisar funcionario\n"
                         + "emprestar livro\n"
                         + "devolver livro\n");
            if (comando.equals("cadastrar livro")) {   
                System.out.println("Digite o codigo do Livro");
                int codigo = tecla.nextInt();
                System.out.println("Digite o nome do Livro:");
                String nome = tecla1.nextLine();
                System.out.println("Digite a quantidade de autores do livro:");
                int qtd = tecla.nextInt();
                Autores[] autor = cadastraAutores(qtd, tecla);
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
                b.cadastrar(e);          
            }

            if (comando.equals("cadastrar funcionario")) {
                System.out.println("Qual é a matricula do funcionario?");
                String matricula = tecla.nextLine();
                System.out.println("Qual o nome do funcionario?");
                String nome = tecla.nextLine();
                System.out.println("O funcionario possui OAB?[s]sim ou [n]nao:");
                String resp = tecla.nextLine();
                if ("s".equals(resp)) {
                System.out.println("Digite o número da OAB:");
                int oab = tecla.nextInt();
                Funcionario f = new Funcionario(matricula, nome, oab);
                b.cadastrar(f);
                System.out.println("Funcionario cadastrado com sucesso.");
                } else {
                    Funcionario f = new Funcionario(matricula, nome);
                    b.cadastrar(f);
                    System.out.println("Funcionario cadastrado com sucesso.");
                }
            }

            if (comando.equals("emprestrar livro")) {

            }
        }
        
        if ("funcionario".equals(resp1)) {
            System.out.println("Ola, o que voce deseja fazer?\n"
                             + "[1]pesquisar livro pelo titulo\n"
                             + "[2]pesquisar livro pelo autor\n"
                             + "[3]pesquisar livro pelo editora\n"
                             + "Digite o numero da opçao desejada:");
            int opcao = tecla1.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o titulo do livro:\n");
                    String titulo = tecla1.nextLine();
                    pesquisarLivro(titulo);
                case 2:
                    System.out.println("Digite o autor do livro:\n");
                    String autor = tecla1.nextLine();
                    pesquisarAutor(autor);
                case 3:
                    System.out.println("Digite o editora do livro:\n");
                    String editora = tecla1.nextLine();
                    pesquisarEditora(editora);                       
            }  
        }  
    }
    
    public void cadastrar(Exemplar exemplar) {
        biblioteca.add(exemplar);
    }

    public void cadastrar(Funcionario funcionario) {
        usuarios.add(funcionario);
    }
       
    public void exibirDados(String codigo) {//Sobrecarregado e Sobreposto (Override and Overload)
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        Exemplar exemplar = new Exemplar();
        exemplar.recebeExemplar(Integer.parseInt(codigo)); 
        System.out.println("Livro.\n" + 
                        "codigo : " + exemplar.getCodigo() + "\n" +
                        "nome : " + exemplar.getNome() + "\n" +
                        "autor : " + exemplar.EscreveAutores() + "\n" +
                        "editora : " + exemplar.getEditora().getNome() + "\n" +
                        "area : " + exemplar.getArea() + "\n" +                        
                        "data de aquisição : " + formata.format(exemplar.getDataAquisicao().getTime()) + "\n" +
                        "preço : R$" + exemplar.getPreco()  + "\n" +
                        "Foi emprestado? " + exemplar.getEmprestado() + "\n" +
                        "Está inativo? " + exemplar.getInativo()+ "\n");
    }   
    
    public void exibirDados(Exemplar exemplar) {
    	SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
    	System.out.println("Livro.\n" + 
                "codigo : " + exemplar.getCodigo() + "\n" +
                "nome : " + exemplar.getNome() + "\n" +
                "autor : " + exemplar.EscreveAutores() + "\n" +
                "editora : " + exemplar.getEditora().getNome() + "\n" +
                "area : " + exemplar.getArea() + "\n" +                        
                "data de aquisição : " + formata.format(exemplar.getDataAquisicao().getTime()) + "\n" +
                "preço : R$" + exemplar.getPreco()  + "\n" +
                "Foi emprestado? " + exemplar.getEmprestado() + "\n" +
                "Está inativo? " + exemplar.getInativo()+ "\n");
    }
    
    
    public void exibirDados(Funcionario funcionario) {//Sobrecarregado e Sobreposto (Override and Overload)
        try {
            System.out.println("Funcionário.\n" + 
                   "Matricula : " + funcionario.getMatricula() + "\n" +
                   "Nome : " + funcionario.getNome());  
               if (funcionario.getOab() == 0) {
                   System.out.println("não possui OAB");
               } else {
                   System.out.println("OAB : " + funcionario.getOab());
               } 
               if (funcionario.getLivrosEmprestados() == null) {//verificar isso
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
          
    public void livrosEmprestados() {//para as secretarias visualizarem os nome dos livros que foram emprestados
        System.out.println("Livros que foram emprestados:");
        for (int i=0; i<=biblioteca.size(); i++) {
            if (biblioteca.get(i).getEmprestado() == true) {
                System.out.println(biblioteca.get(i).getNome() +" | "+ biblioteca.get(i).getCodigo());
            }
        }
    }
    
    public void pesquisarLivro(String nome) {
        for (int i=0; i<biblioteca.size(); i++) {
            if (biblioteca.get(i).getNome().equals(nome.toLowerCase())) {
                System.out.println("Livros Encontrados:");
                exibirDados(biblioteca.get(i));
            } else {
                System.out.println("Livro não encontrado. Não cadastrado ou nome incorreto.");
            }
        }
    }
    
    public void pesquisarAutor(String nome) {
    	int encontrados = 0;
        for (int i=0; i<biblioteca.size(); i++) {
        	for (int j=0; j<biblioteca.get(i).getAutor().length; j++)
            if (biblioteca.get(i).getAutor()[i].getNome().equals(nome.toLowerCase())) {
                System.out.println("Autores Encontrados:");
                exibirDados(biblioteca.get(i));
                encontrados++;
            }   
        }
        if(encontrados == 0) {
            System.out.println("Livro não encontrado. Não cadastrado ou nome incorreto.");
        }
    }
    
    public void pesquisarEditora(String nome) {
        for (int i=0; i<biblioteca.size(); i++) {
            if (biblioteca.get(i).getEditora().getNome().equals(nome.toLowerCase())) {
                System.out.println("Editoras Encontrados:");
                exibirDados(biblioteca.get(i));
            } else {
                System.out.println("Livro não encontrado. Não cadastrado ou nome incorreto.");
            }
        }
    }
     
    public void pesquisarFuncionario(String nome) {    
        for (int i=0; i<usuarios.size(); i++) {          
            if (usuarios.get(i).getNome().toLowerCase().equals(nome.toLowerCase())) {
                System.out.println("Funcionarios Encontrados:");
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
        //vem no padrão americano, com a classe SimpleDateFormat formato para o BR
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        formata.format(dataEmprestimo.getTime());
        formata.format(dataDevolucao.getTime());
        try {
            if (exemplar.getEmprestado() == true) {
                System.out.println("Este livro já foi emprestado.");
            } else if (exemplar.getInativo() == true){
                System.out.println("Livro inservível. Avariado ou inativo.");
            } else { 
                exemplar.setEmprestado(true);
                for (int i=0; i<funcionario.getLivrosEmprestados().length; i++) {
                    if (funcionario.getLivrosEmprestados()[i] == null ) {
                        funcionario.getLivrosEmprestados()[i] = Integer.toString(exemplar.getCodigo());
                        break;
                    }
                }
            }
            
        } catch (NullPointerException e) {//substituir pelo erro de limite excedido do vetor
            System.out.println("Limite de livros emprestados excedido!");
        }

    }
    
    public void devolverLivro(Exemplar exemplar, Funcionario funcionario) {
        exemplar.setEmprestado(false);
        for (int i=0; i<4; i++) {
            if (funcionario.getLivrosEmprestados()[i].equals(Integer.toString(exemplar.getCodigo()))) {//
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
       
    public static Autores[] cadastraAutores(int quantidade, Scanner tecla) {
    	Autores[] lista = new Autores[quantidade]; 
    	for (int i =0; i<quantidade; i++) {
    		if(quantidade == 1) {
    			System.out.println("Informe o nome do Autor.");
        		lista[i] = new Autores(tecla.nextLine());	
    		}
        		lista[i] = new Autores(tecla.nextLine());
    	}
    	return lista;
    }
    
}

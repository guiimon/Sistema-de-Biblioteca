package biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
        
public class Biblioteca {//Essa é a classe Movimentação do UML  
    //Atributos
    //static ArrayList<Exemplar> biblioteca = new ArrayList();
    //static ArrayList<Funcionario> usuarios = new ArrayList<>();
    private  Calendar dataEmprestimo; //Calendar é superior ao Date
    private  Calendar dataDevolucao;
    
    //Principal 
    public void executar(String comando, Biblioteca b) {
        Scanner tecla = new Scanner(System.in);
        Scanner tecla1 = new Scanner(System.in);
        System.out.println("Ola, voce e um funcionario ou secretaria?");
        String resp1 = tecla1.nextLine().trim().toLowerCase();
        if ("secretaria".equals(resp1)) {
            System.out.println("O que deseja fazer?\n"
                         + "cadastrar livro\n"
                         + "cadastrar exemplar\n"
                         + "cadastrar funcionario\n"
                         //+ "cadastrar Autor\n"
                         //+ "cadastrar Editora\n"
                         + "pesquisar livro\n"
                         + "pesquisar exemplar\n"
                         + "pesquisar funcionario\n"
                         + "emprestar livro\n"
                         + "devolver livro\n");
            comando = tecla.nextLine().trim().toLowerCase();
            switch (comando) {
            case "cadastrar livro":
            	System.out.println("Digite o codigo do Livro");
                int codigo = tecla.nextInt();
                System.out.println("Digite o nome do Livro:");
                String nome = tecla1.nextLine();
                System.out.println("Digite a quantidade de autores do livro:");
                int qtd = tecla.nextInt();
                Autores[] autor = cadastraAutores(qtd, tecla);
                System.out.println("Digite a editora do Livro:");
                String editora = tecla.nextLine();
                System.out.println("Digite a area do Livro:");
                String area = tecla.nextLine();
                System.out.println("Digite o preco do Livro:");
                double preco = tecla.nextDouble();
                System.out.println("Digite o dia de aquisicao deste Livro(dd):");
                int dia = tecla.nextInt();
                System.out.println("Digite o mes de aquisicao deste Livro(mm):");
                int mes = tecla.nextInt();
                System.out.println("Digite o ano de aquisicao deste Livro(aaaa):");
                int ano = tecla.nextInt();
                Livro l = new Livro(codigo, nome, autor, editora, area);
                Livro e = new Exemplar(codigo, nome, autor, editora, area, preco, dia, mes, ano);
                b.cadastrar(l);
                b.cadastrar(e);                
                break;
                
            case "cadastrar exemplar":
            	System.out.println("Digite o codigo do Livro");
                int codigoE = tecla.nextInt();
                System.out.println("Digite o nome do Livro:");
                String nomeE = tecla1.nextLine();
                System.out.println("Digite a quantidade de autores do livro:");
                int qtdE = tecla.nextInt();
                Autores[] autorE = cadastraAutores(qtdE, tecla);
                System.out.println("Digite a editora do Livro:");
                String editoraE = tecla.nextLine();
                System.out.println("Digite a area do Livro:");
                String areaE = tecla.nextLine();
                System.out.println("Digite o preco do Livro:");
                double precoE = tecla.nextDouble();
                System.out.println("Digite o dia de aquisicao deste Livro(dd):");
                int diaE = tecla.nextInt();
                System.out.println("Digite o mes de aquisicao deste Livro(mm):");
                int mesE = tecla.nextInt();
                System.out.println("Digite o ano de aquisicao deste Livro(aaaa):");
                int anoE = tecla.nextInt();               
                Livro eE = new Exemplar(codigoE, nomeE, autorE, editoraE, areaE, precoE, diaE, mesE, anoE);                
                b.cadastrar(eE);                
            	break;
                
            case "cadastrar funcionario":
            	System.out.println("Qual e a matricula do funcionario?");
                String matricula = tecla.nextLine();
                System.out.println("Qual o nome do funcionario?");
                String nomeFun = tecla.nextLine();
                System.out.println("O funcionario possui OAB?[s]sim ou [n]nao:");
                String resp = tecla.nextLine();
                if ("s".equals(resp)) {
                System.out.println("Digite o número da OAB:");
                int oab = tecla.nextInt();
                Funcionario f = new Funcionario(matricula, nomeFun, oab);
                b.cadastrar(f);
                System.out.println("Funcionario cadastrado com sucesso.");
                } else {
                    Funcionario f = new Funcionario(matricula, nomeFun);
                    b.cadastrar(f);
                    System.out.println("Funcionario cadastrado com sucesso.");
                }
                break;
                
            case "emprestrar livro":
            	System.out.println("Qual e a matricula do funcionario que levara o livro?");
                matricula = tecla.nextLine();
                System.out.println("Qual o codigo do livro que o funcionario esta levando?");
                codigo = tecla.nextInt();
                Exemplar emprestado = new Exemplar();
                emprestado.recebeExemplar(codigo);
                Funcionario recebedor = new Funcionario();
                recebedor.recebeFuncionario(matricula);
                emprestarLivro(emprestado, recebedor);
                break;
                
            case "devolver livro":
            	System.out.println("Qual e a matricula do funcionario que levou o livro?");
                matricula = tecla.nextLine();
                System.out.println("Qual o codigo do livro que o funcionario levou?");
                codigo = tecla.nextInt();
                emprestado = new Exemplar();
                emprestado.recebeExemplar(codigo);
                recebedor = new Funcionario();
                recebedor.recebeFuncionario(matricula);
                devolverLivro(emprestado, recebedor);
                System.out.println("O livro recebido esta utilizavel?");
                String estado = tecla.nextLine();
                if(!(estado.equals("sim"))) {
                    inativar(emprestado);
                }
                System.out.println("Devolucao efetuada com sucesso");
                emprestado.editaExemplar();
                recebedor.editaFuncionario();
                break;
                
            case "pesquisar livro":
                System.out.println("Como voce deseja pesquisar?\n"
                             + "[1]pesquisar livro pelo titulo\n"
                             + "[2]pesquisar livro pelo autor\n"
                             + "[3]pesquisar livro pelo editora\n"
                             + "Digite o numero da opçao desejada:");
                int opcaoL = tecla1.nextInt();
                switch (opcaoL) {
                    case 1:
                        System.out.println("Digite o titulo do livro:\n");
                        String tituloL = tecla1.nextLine();
                        pesquisar("C:\\Biblioteca\\livros", tituloL);
                        break;
                    case 2:
                        System.out.println("Digite o autor do livro:\n");
                        String autorL = tecla1.nextLine();
                        pesquisar("C:\\Biblioteca\\livros", autorL);
                        break;
                    case 3:
                        System.out.println("Digite a editora do livro:\n");
                        String editoraL = tecla1.nextLine();
                        pesquisar("C:\\Biblioteca\\livros", editoraL); 
                        break;
                }  
                break;
                
             case "pesquisar exemplar":
                System.out.println("Digite o título do exemplar:");
                String tituloE = tecla1.nextLine();
                pesquisar("c:/Biblioteca/exemplar", tituloE);
                break; 
                
             case "pesquisar funcionario":
                System.out.println("Digite o nome do funcionario:");
                String nomeF = tecla1.nextLine();
                pesquisar("c:/Biblioteca/funcionario", nomeF);
                break;    
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
                    pesquisar("C:\\Biblioteca\\Livros", titulo);
                    break;
                case 2:
                    System.out.println("Digite o autor do livro:\n");
                    String autor = tecla1.nextLine();
                    pesquisar("C:\\Biblioteca\\Livros", autor);
                    break;
                case 3:
                    System.out.println("Digite a editora do livro:\n");
                    String editora = tecla1.nextLine();
                    pesquisar("C:\\Biblioteca\\Livros", editora);
                    break;
            }  
        }  
    }
    
    public void cadastrar(Livro livro) {        
        livro.registrarLivro();
    }

    public void cadastrar(Exemplar exemplar) {
        //biblioteca.add(exemplar);
        exemplar.registrarExemplar();
    }
    
    public void cadastrar(Funcionario funcionario) {
        //usuarios.add(funcionario);
        funcionario.registraFuncionario();
    }
       
    public void exibirDados(String codigo) {
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        Exemplar exemplar = new Exemplar();
        exemplar.recebeExemplar(Integer.parseInt(codigo)); 
        System.out.println("Livro.\n" + 
                        "codigo : " + exemplar.getCodigo() + "\n" +
                        "nome : " + exemplar.getNome() + "\n" +
                        "autor : " + exemplar.EscreveAutores() + "\n" +
                        "editora : " + exemplar.getEditora().getNome() + "\n" +
                        "area : " + exemplar.getArea() + "\n" +                        
                        "data de aquisicao : " + formata.format(exemplar.getDataAquisicao().getTime()) + "\n" +
                        "preco : R$" + exemplar.getPreco()  + "\n" +
                        "Foi emprestado? " + exemplar.getEmprestado() + "\n" +
                        "Esta inativo? " + exemplar.getInativo()+ "\n");
    }   
    
    public void exibirDados(Livro livro) {
    	System.out.println("Livro.\n" + 
                "codigo : " + livro.getCodigo() + "\n" +
                "nome : " + livro.getNome() + "\n" +
                "autor : " + livro.EscreveAutores() + "\n" +
                "editora : " + livro.getEditora().getNome() + "\n" +
                "area : " + livro.getArea() + "\n");
    }
    
    public void exibirDados(Exemplar exemplar) {
    	SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
    	System.out.println("Livro.\n" + 
                "codigo : " + exemplar.getCodigo() + "\n" +
                "nome : " + exemplar.getNome() + "\n" +
                "autor : " + exemplar.EscreveAutores() + "\n" +
                "editora : " + exemplar.getEditora().getNome() + "\n" +
                "area : " + exemplar.getArea() + "\n" +                        
                "data de aquisicao : " + formata.format(exemplar.getDataAquisicao().getTime()) + "\n" +
                "preco : R$" + exemplar.getPreco()  + "\n" +
                "Foi emprestado? " + exemplar.getEmprestado() + "\n" +
                "Esta inativo? " + exemplar.getInativo()+ "\n");
    }
       
    public void exibirDados(Funcionario funcionario) {
        try {
            System.out.println("Funcionario.\n" + 
                   "Matricula : " + funcionario.getMatricula() + "\n" +
                   "Nome : " + funcionario.getNome());  
               if (funcionario.getOab() == 0) {
                   System.out.println("nao possui OAB");
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
    
    public void pesquisar(String caminho, String nome) {
        File arquivo = new File(caminho);                  
                              //listFiles retorna um vetor
        File lista [] = arquivo.listFiles();//o vetor "lista" recebe o vetor de "arquivo". 
        int n = 0;        
        for (int i=0; i<lista.length; i++) {
            try {         
                FileReader ler = new FileReader(lista[i]);
                BufferedReader lerb = new BufferedReader(ler);
                String linha = "";
                
                while ( (linha = lerb.readLine()) != null ) {
                    if (linha.equals(nome.toLowerCase())) {
                        System.out.println("");
                        ler(lista[i]); 
                        System.out.println("");
                        n++;
                    }                                                  
                }
                
                lerb.close();
                ler.close(); 
                
            } catch (IOException e) {
                e.printStackTrace();                
            }         
        }
        if (n == 0) {
            System.out.println("Não encontrado. Nao cadastrado ou nome incorreto.\n");
        }                   
    }
    
    public void ler(File caminho) {
        try {            
            FileReader ler = new FileReader(caminho);
            BufferedReader lerb = new BufferedReader(ler);
            String linha = "";
            
             while ((linha = lerb.readLine()) != null ) {
                System.out.println(linha);
            }            
            lerb.close();
            ler.close();           
            
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: ");
            e.printStackTrace();
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
                System.out.println("Este livro ja foi emprestado.");
            } else if (exemplar.getInativo() == true){
                System.out.println("Livro inservavel. Avariado ou inativo.");
            } else { 
                exemplar.setEmprestado(true);
                for (int i=0; i<funcionario.getLivrosEmprestados().length; i++) {
                    if (funcionario.getLivrosEmprestados()[i] == null ) {
                        funcionario.getLivrosEmprestados()[i] = Integer.toString(exemplar.getCodigo());
                        break;
                    }
                }
                exemplar.editaExemplar();
                funcionario.editaFuncionario();
            }
            
        } catch (NullPointerException e) {//substituir pelo erro de limite excedido do vetor
            System.out.println("Limite de livros emprestados excedido!");
        }

    }
    
    public void devolverLivro(Exemplar exemplar, Funcionario funcionario) {
        exemplar.setEmprestado(false);
        for (int i=0; i<4; i++) {
            if (funcionario.getLivrosEmprestados()[i].equals(Integer.toString(exemplar.getCodigo()))) {
                funcionario.getLivrosEmprestados()[i] = null;  
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

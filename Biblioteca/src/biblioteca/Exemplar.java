package biblioteca;

import java.util.Calendar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Exemplar extends Livro {
    //atributos
    private Calendar dataAquisicao; //Calendar superior
    private double preco;
    private boolean inativo; //true caso o livro tenha sido avariado; false para em bom estado
    private boolean emprestado; //true para emprestado(indisponivel) e false para livre(disponivel)
    

    //construtor
    public Exemplar(){}
    public Exemplar(int codigo, String nome, Autores[] nomeAutor, String nomeEditora, String area, double preco, int dia, int mes, int ano) {
        super(codigo, nome, nomeAutor, nomeEditora, area);
        dataAquisicao = Calendar.getInstance();        
        dataAquisicao.set(ano, mes, dia); //recebe a data de aquisicao do usuario
        this.preco = preco;
        this.inativo = false;
        emprestado = false;
    }
    
    //metodos princiais
    public void pesquisar() {
    }
    
    public void registrarExemplar() {
    	File caminho = new File("C:\\Biblioteca\\Exemplar");
    	File arquivo = new File(caminho, String.valueOf(getCodigo())+".txt" );
    	if(!(caminho.exists())); caminho.mkdir();
    	if(!(arquivo.exists())) {
    		try {
            
            	arquivo.createNewFile();
            
            	FileWriter fileWriter = new FileWriter(arquivo, true);
            
            	PrintWriter printWriter = new PrintWriter(fileWriter);
            	
            	printWriter.println(getCodigo());
            	printWriter.println(getNome());
            	printWriter.println(Arrays.toString(getAutor()));
            	printWriter.println(getEditora());
            	printWriter.println(getArea());
            	SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
            	printWriter.println(formata.format(getDataAquisicao().getTime()));
            	printWriter.println(getPreco());
            	printWriter.println(getInativo());
            	printWriter.println(getEmprestado());
            
            	printWriter.flush();
            
            	printWriter.close();
            
        	} catch (IOException e) {
            	e.printStackTrace();
        	}
    	}else {
    		System.out.println("Arquivo com o c�digo ja criado.");
    	}
    }
    
    public void recebeExemplar(int codigo) {
    	String caminho = "C:\\Biblioteca\\Exemplar";
      	File arquivo = new File(caminho, codigo+".txt" );
    	if(arquivo.exists()) {
    		try {
				BufferedReader br = new BufferedReader(new FileReader(caminho+ "/" + codigo+".txt"));
				setCodigo(Integer.parseInt(br.readLine()));
				setNome(br.readLine());
				setAutor(criaAutores(br.readLine()));
				setEditora(new Editora(br.readLine()));
				setArea(br.readLine());
				String[] data = br.readLine().split("/");
				Integer[] dataint = new Integer[data.length];
				for (int i=0; i<data.length; i++) {
					dataint[i] = Integer.parseInt(data[i]);
				}
				dataAquisicao = Calendar.getInstance();  
	        	dataAquisicao.set(dataint[0], dataint[1], dataint[2]);
				setPreco(Double.parseDouble(br.readLine()));
				setInativo(Boolean.parseBoolean(br.readLine()));
				setEmprestado(Boolean.parseBoolean(br.readLine()));
			
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {	
				e.printStackTrace();
			}
    	}
    	else {
    		System.out.println("Caminho especificado nao existe.");
    	}
    }
    
    public void editaExemplar() {
    	File caminho = new File("C:\\Biblioteca\\Exemplar");
    	File arquivo = new File(caminho, String.valueOf(getCodigo())+".txt" );
    	
    	if(!(caminho.exists())){
    		caminho.mkdir();
    	}
    	if(arquivo.exists()) {
    			try {
            
            	arquivo.createNewFile();
            
            	FileWriter fileWriter = new FileWriter(arquivo, false);
            
            	PrintWriter printWriter = new PrintWriter(fileWriter);
            
            	printWriter.println(getCodigo());
            	printWriter.println(getNome());
            	printWriter.println(Arrays.toString(getAutor()));
            	printWriter.println(getEditora());
            	printWriter.println(getArea());
            	SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
            	printWriter.println(formata.format(getDataAquisicao().getTime()));
            	printWriter.println(getPreco());
            	printWriter.println(getInativo());
            	printWriter.println(getEmprestado());
            
            	printWriter.flush();
            
            	printWriter.close();
            
        	} catch (IOException e) {
            	e.printStackTrace();
        	}
    	}else {
    		System.out.println("Caminho especificado nao existe.");
    	}
    }
    
    //getters e setters
    public Calendar getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Calendar dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }
    
	public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean getInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }
    
    public boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }     
    
    public Autores[] criaAutores(String codigo) {
    	String[] nomes = codigo.replace("[", "").replace("]", "").split(", ");
    	Autores[] autor = new Autores[nomes.length];
    	for (int i = 0; i <autor.length; i++) {
        	autor[i] = new Autores(nomes[i]);
        }
    	return autor;
    }
    
}

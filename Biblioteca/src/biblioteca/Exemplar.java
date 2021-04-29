
package biblioteca;

import java.util.Calendar;

public class Exemplar extends Livro {
    //atributos
    private Calendar dataAquisicao; //Calendar é superior
    private double preco;
    private boolean inativo; //true caso o livro tenha sido avariado; false para em bom estado
    private boolean emprestado; //true para emprestado(indisponivel) e false para livre(disponivel)

    //construtor         
    public Exemplar(int codigo, String nome, String nomeAutor, String nomeEditora, String area, double preco, int dia, int mes, int ano) {
        super(codigo, nome, nomeAutor, nomeEditora, area);
        dataAquisicao = Calendar.getInstance();        
        dataAquisicao.set(ano, mes, dia); //recebe a data de aquisição do usuário
        this.preco = preco;
        this.inativo = false;
        emprestado = false;
    }
    
    
    //metodos princiais
    public void pesquisar() {
        
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
    
}


package biblioteca;

import java.util.Date;

public class Exemplar extends Livro {
    //atributos
    private Date dataAquisicao;
    private double preco;
    private boolean inativo; //true caso o livro tenha sido avariado; false para em bom estado
    private boolean emprestado; //true para emprestado(indisponivel) e false para livre(disponivel)

    //construtor         
    public Exemplar(int codigo, String nome, String nomeAutor, String nomeEditora, String area, double preco) {
        super(codigo, nome, nomeAutor, nomeEditora, area);
        dataAquisicao = new Date();       
        this.preco = preco;
        this.inativo = false;
        emprestado = false;
    }
    
    
    //metodos princiais
    public void pesquisar() {
        
    }

    
    //getters e setters
    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
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


package biblioteca;

public class Funcionario {
    //atributos
    private String matricula;
    private String nome;
    private int oab;
    private Exemplar[] livrosEmprestados = new Exemplar[3];//só pode pegar 4 livros emprestados (0,1,2,3)
    
    //construtor
    //para quem tem OAB
    public Funcionario(String matricula, String nome, int oab) {
        this.matricula = matricula.trim().toLowerCase();
        this.nome = nome.trim().toLowerCase();
        this.oab = oab;
    }
    //para quem NÃO tem OAB
    public Funcionario(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.oab = 0;
    }    
    
    //pegadores e modificadores
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getOab() {
        return oab;
    }

    public void setOab(int oab) {
        this.oab = oab;
    }

    public Exemplar[] getLivrosEmprestados() {
        return livrosEmprestados;
    }
    
    
}

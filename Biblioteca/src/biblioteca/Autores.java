package biblioteca;

import biblioteca.dao.LivroDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Autores {
    private String nome;
    List userList = new ArrayList();

    
    public Autores(){}
    public Autores(String nome) {
        this.nome = nome.toUpperCase();
    }       
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
    public List getUserList() {
        return userList;
    }

    public void setUserList(List userList) {
        this.userList = userList;
    }
    
    public static void layout(List<Autores> autores) {
        String path = LivroDAO.PATH;
        File dir = new File(path);
        File arq = new File(dir, "User2.txt");

        if (!dir.exists()) dir.mkdir();
        
        try {
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            //Utilizamos o método print() para escrever na mesma linha e um ponto e vírgula no final.
            // para o próximo user.
            for (Autores autor : autores) {
                printWriter.print(autor.getNome() + ",");
            }
            printWriter.flush();
            printWriter.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = "";
            
            //Lista que irá guardar o resultado, ou seja,
            // cada linha do arquivo que corresponde a um User
            List<String> result = new ArrayList();
            
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
                if (linha != null && !linha.isEmpty()) {
                    result.add(linha);
                }
            }
            fileReader.close();
            bufferedReader.close();
            
            for (String s : result) {
                //Usamos o método split da classe String
                // para separar as partes entre os ponto e vírgulas.
                //Guardamos o resultado em um array
                String[] autor = s.split(";");
                
                //Criamos um objeto User e setamos em seus atributos
                //as posições correspondentes do array
                Autores u = new Autores();
                u.setNome(autor[0]);
                
                //exibe o conteúdo do objeto u
                //System.out.println(u.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString () {
        return this.nome;
    }
    
}

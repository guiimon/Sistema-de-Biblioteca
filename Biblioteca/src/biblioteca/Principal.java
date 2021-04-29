
package biblioteca;

import java.util.Calendar;
import java.util.Date;


public class Principal {
    public static void main(String[] agrs) {
        Calendar data5 = Calendar.getInstance();                     
        
        System.out.println(data5.getTime());
        data5.add(Calendar.DAY_OF_MONTH, 5);             
        System.out.println(data5.getTime());
                                 
        Exemplar l0 = new Exemplar(010101, "7 advogados e um cliente", "JJ. James", "ADV Books", "Direito civil", 100);
        Funcionario f0 = new Funcionario("ADV01", "Demolidor", 00110101);
        
        
        
    }
    
}

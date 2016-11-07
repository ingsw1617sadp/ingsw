/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingsw;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author shady
 */
public class IngSw {

    /**
     * @param args the command line arguments
     * @throws java.io.UnsupportedEncodingException
     * 
     */
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        // TODO code application logic here
        System.out.println("mammt");
        
        
    // Test email class. // JUST AS DEMO 
        String title = "OttettoEmail";
        String message = "<p>messaggioDiProva<br />A <strong>Capo</strong><br /><i>mammt</i></p>";
        String receiverEmailAddress = "any@emailaddress.com"; // Insert a valid email address 
        boolean html = true;
        // Disabled in order to avoid to spam emails while debugging!
        //SendEmail send = new SendEmail(receiverEmailAddress, title, message, html);
        
    // Test Hashing class. // JUST AS DEMO
    
        String s1 = "paperino";
        //String s2 = new String();
        String s2;
        s2 = Hashing.sha2_512(s1, "");
        System.out.println(s1 +" diventa: "+ s2);
           
        s1 = null; // GC Help
        s2 = null; // GC Help
     
    // /* ****************** */ 
    
    // Test RegEx class. // JUST AS DEMO
    
        String s = "123";
        String pattern = "[0-9]{1,5}";
                
        if (RegEx.pregMatch(pattern, s)) {
            System.out.println("Match");
        }
        else {
            System.out.println("Mismatch");
        }
    // NOTA CHE SCRIVO IN ITALIANO PERCHE' TANTO ELIMINIAMO
    // Sarebbe utile implementare dei pattern FINAL che rischiano di essere usati più volte
    // Anche per non insozzare il codice con 10mila rige prima
    // di confrontare una regExp oppure riscrivendo il pattern ogni volta
    // String pattern = "[0-9]{1,5}";
    // In questo caso creerei uno switch case per attivare un SETTER che passa il pattern
    // corretto al metodo "pregMatch".
    // Avere quindi varie costanti, public final regEmail="", public final regCodFiscale=""; 
    // Questa però è una PIPPA MENTALE fatta in un momento di nulla facenza.
    // NOTA2. Per la gestione delle credenziali sto implementando una tenica che sicuro
    // piacerà a DiMartino. Ma per ora non insozzo ulteriormente questo GitHub Project.
    
    
    /* ************** */
    
    // Test reading from properties file
    ParsePropertyValues properties = new ParsePropertyValues();
    //properties.getPropValues(); //DEBUG in order to get all values
    String dbname = properties.getDbName();
    System.out.println( dbname  );
    String dbuser = properties.getDbUser();
    System.out.println( dbuser  );
    
    dbname = null; //GC Help
    dbuser = null; //GC Help
    
    //properties.writeAFile();
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingsw;

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
    public static void main(String[] args) throws UnsupportedEncodingException {
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
        
    }
    
}

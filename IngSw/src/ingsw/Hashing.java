/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingsw;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author shady
 */
public class Hashing {
    
    /**
     * This Methos allow the SHA2-512 HASH compliant with MYSQL sha-2 Hash. You will need a char[128] to store this value.
     * @param passwordToHash
     * @param salt // you can add a little bit salt in order to customize your hashing. Mysql does not support "salt"
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    public static String sha2_512(String passwordToHash, String salt) throws UnsupportedEncodingException {
    String generatedPassword = null;
    try {
         MessageDigest md = MessageDigest.getInstance("SHA-512");
         md.update(salt.getBytes("UTF-8"));
         byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
         StringBuilder sb = new StringBuilder();
         for(byte i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
         }
         generatedPassword = sb.toString();
        } 
       catch (NoSuchAlgorithmException e){
           System.err.println("Impossibile completare l'hasing");
       }
    return generatedPassword;
}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingsw;

/**
 *
 * @author shady
 */
public class RegEx {
final String pattern = "[0-9]{1,5}"; //pattern di esempio

    public static boolean pregMatch(String pattern, String content) {
        return content.matches(pattern);
    }
    
}

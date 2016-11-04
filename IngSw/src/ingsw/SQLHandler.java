/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingsw;

import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author shady
 */
public class SQLHandler {
    
    /**
     *
     * @param table Name of Table where query asks for information
     * @param field1
     * @param field2
     * @param field3
     * @return query resulti; type: ResultSet rs
     */
    protected static ResultSet GetData(String table, String field1, String field2, String field3){
        
        ResultSet rs = null;
        try {
            Connection conn;
            conn = new DBConnection().connectDB();
            String sql = "SELECT "+ field1 +", "+ field2 +", "+ field3 +" FROM "+ table +" WHERE 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
              
                      
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,  "Impossibile recuperare dati dal db" + e);
            System.err.println("No Select");
        }        
    return rs;
    }
   
    
    
    /**
     *
     * @param table Name of Table where query asks for information
     * @param field1
     * @param field2
     * @param field3
     * @param param1
     * @param param2
     * @return query result; type: ResultSet rs
     */
    protected static ResultSet GetData(String table, String field1, String field2, String field3, String param1, String param2){
        
        ResultSet rs = null;
        try {
            Connection conn;
            conn = new DBConnection().connectDB();
            String sql = "SELECT "+ field1 +", "+ field2 +", "+ field3 +" FROM "+ table +" WHERE "+ field2 +" = ? AND "+ field3 +" = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, param1);
            ps.setString(2, param2);
            rs = ps.executeQuery();
            
                      
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,  "Impossibile recuperare dati dal db" + e);
            System.err.println("No Select");
        }        
    return rs;
    }
    
    
     /**
     *
     * @param table Name of Table where query asks for information
     * @param field1
     * @param field2
     * @param field3     
     * 
     */
    protected static void InsertData(String table, String field1, String field2, String field3 ){
        // NOTE // I'd like to use a String array    
                
        try{ // It's for adding new data
                
                Connection conn = new DBConnection().connectDB();
                String sql = "INSERT into "+ table +" values (?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                             
                ps.setString(1, field1);
                ps.setString(2, field2);
                ps.setString(3, field3);
                               
                ps.execute();
                JOptionPane.showMessageDialog(null,  "Insert with success");
                 
            }
            catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null,  "Cannot complete the command insert" + e);
            }    
    }
    
    protected static void InsertData(String table, String field1, String field2, String field3, String field4 ){
             
                
        try{ // It's for adding new data
                
                Connection conn = new DBConnection().connectDB();
                String sql = "INSERT into "+ table +" values (?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                        
                ps.setString(1, field1);
                ps.setString(2, field2);
                ps.setString(3, field3);
                ps.setString(4, field4);
                               
                ps.execute();
                JOptionPane.showMessageDialog(null,  "Insert with success");
                 
            }
            catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null,  "Cannot complete the command insert" + e);
            }    
    }
        
    protected static void UpdateData(String table, String field1, String field2, String field3){
        try{  // it's for update data
               
                Connection conn = new DBConnection().connectDB();
                String sql = "UPDATE "+ table +" SET id = ?, nome =?, data=? WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, field1);
                ps.setString(2, field2);
                ps.setString(3, field3);
                ps.setString(4, field1);
                
                ps.execute(); // execute the update
                JOptionPane.showMessageDialog(null,  "Update Avvenuto con Successo");
                 
            }
            catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null,  "Update NON Avvenuto con Successo" + e);
            }    
    }
    
    
    
    protected static void CallPlsql(String field1, String field2, String field3, String field4) throws SQLException
    {
        try{
            Connection conn = new DBConnection().connectDB(); 
            CallableStatement cs;
            cs = conn.prepareCall("{call writelog(?,?,?,?)}");
            cs.setString(1, field1);
            cs.setString(2, field2);
            cs.setString(3, field3);
            cs.setString(4, field4);
            cs.execute();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,  "Cannot register the event" + e);
        }
        
    }
    
    
    protected static void DeleteData(String table, String id){ 
        try{
            Connection conn = new DBConnection().connectDB();            
                String sql = "DELETE from "+ table +" where id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, id);                
                               
                ps.execute();
                JOptionPane.showMessageDialog(null,  "Delete succesfully");
        }
        catch (SQLException | HeadlessException e) {
            System.err.println("Cannot Delete" + e);
        }
    }
    
    /**
     *
     * @param table
     * @param tableClick
     * @return
     */
    protected static ResultSet ShowParmFromClick(String table, String tableClick){
        ResultSet rs = null;
        try{
            
            Connection conn = new DBConnection().connectDB();
            String sql = "Select id, nome, data FROM test WHERE id = ?";
             
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tableClick);
            rs = ps.executeQuery();
            
        }
        catch (Exception e) {
            System.out.println("Cannot execute the statement" + e);                
            JOptionPane.showMessageDialog(null, "Cannot execute the statement" + e); 
        }
        
    return rs;
    
    }
}

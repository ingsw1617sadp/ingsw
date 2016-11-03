package ingsw;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Damiano
 */
public class Connessione {
    private static Connection conn;
    public static void setConnection(){
        try{
            conn=DriverManager.getConnection("jdbc:", "","");
            conn.setAutoCommit(false);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"connessione",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static Connection getConn(){
        return conn;
    }
    public static void chiudi(ResultSet rs,PreparedStatement st){
        try{
            if(rs!=null)
                 rs.close();
            if(st!=null)
                 st.close();
        }catch(SQLException e){
            
        }
    }
    public static void chiudi(ResultSet rs,Statement st){
        try{
            if(rs!=null)
                 rs.close();
            if(st!=null)
                 st.close();
        }catch(SQLException e){
            
        }
    }
}

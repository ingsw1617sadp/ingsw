/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ingsw;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author shady
 */
public class DBConnection {
    private Connection DBConnection;
    
    /**
     *
     * @return DB Connection
     */
    public Connection connectDB(){
           
        if (DBConnection==null){
            try{
                // This will load the MySQL driver, each DB has its own driver
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Connection Success");
            }
            catch (ClassNotFoundException cnfe) {
                System.out.println("mysqlApp.connection.connectDB()" + cnfe);
            }
            
                String hostdb   = "jdbc:mysql://HOST:3306/DBNAME";
                String user     = "USERNAME";
                String pass     = "SOMEPASSWORD";
                
            try{
                DBConnection =  (Connection) DriverManager.getConnection(hostdb,user,pass);
                System.out.println("Database Connected");
            }
            catch (SQLException se){
                System.out.println("No Databse");
                JOptionPane.showMessageDialog(null,"Connection dB Error"); 
            }
              
        } // endif
    return DBConnection;       
    } // method connect DB
} //connection class
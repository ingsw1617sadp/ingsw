/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingsw;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author shady
 */
public class ParsePropertyValues {
private String result;
private InputStream inputStream;

    public ParsePropertyValues() {
        this.inputStream = null;
        this.result = null;
    }
    
    /**
     * //Get from config.properties the database name Schema
     * @return Database Name
     * @throws IOException
     */
    public String getDbName() throws IOException {
                
        try{
            Properties prop = new Properties();
            String propFileName; 
            propFileName = "resources/config.properties"; //Default Path:  ../resources/config.properties
 
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) { 
                prop.load(inputStream);
            } 
            else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            result = prop.getProperty("db_name"); //Get the field db_name from Property file
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        finally {
            inputStream.close();
        }
        System.out.println("DEBUG: " + result);
        return result;
    }
    
    /**
     * //Parse the Databse Username from config.properties
     * @return dBUser
     * @throws IOException
     */
    public String getDbUser() throws IOException {
                
        try{
            Properties prop = new Properties();
            String propFileName; 
            propFileName = "resources/config.properties"; //Default Path:  ../resources/config.properties
 
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) { 
                prop.load(inputStream);
            } 
            else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            result = prop.getProperty("db_user"); //Get the field db_name from Property file
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        finally {
            inputStream.close();
        }
        System.out.println("DEBUG: " + result);
        return result;
    }
    
    /**
     * //Most used for DEBUG
     * @return all Properties Values for dB
     * @throws IOException
     */
    public String getPropValues() throws IOException {

    try {
    Properties prop = new Properties();
    String propFileName = "config.properties";
 
    inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
    if (inputStream != null) {
        prop.load(inputStream);
    } 
    else {
	throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
    }
 
    Date time = new Date(System.currentTimeMillis());
 
    // get the property value and print it out
    String db_user = prop.getProperty("db_user");
    String db_pass = prop.getProperty("db_pass");
    String db_host = prop.getProperty("db_host");
    String db_name = prop.getProperty("db_name");
 
    result = "DBUser = " + db_user + ", " + db_pass + ", " + db_host;
    // DEBUG
    System.out.println(result);
    } catch (Exception e) {
        System.out.println("Exception: " + e);
    } finally {
        inputStream.close(); // In order to close the file stream with or without exception
    }
        return result;
    }
}

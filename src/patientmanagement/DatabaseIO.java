/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */

// METHOD JUST TO CONNECT TO A HOSIPATL DATABASE
public abstract class DatabaseIO {
    
        //Dcelaring ANSI_RESET so we can reset the colour
    public static final String ANSI_RESET = "\u001B[30m";
    //Dcelaring ANSI colours for console message use
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    
    // REQUIRED VARIABLES FOR ESTABLISHINH A CONNECTION DECLARED AND SET TO FINAL AS THEY WILL NOT NEED TO CHANGE
    static final String DB_URL = "jdbc:mysql://localhost/hospital";
    static final String USER = "pooa";
    static final String PASSWD = "pooa";
    static final String DB_NAME = "hospital";
    // METHOD TO CONNECT TO A DATABASE, REDUCE REPETITIVE CODING AND RETURN THE STATEMENT INTEFACE INSTANCE
    public static Statement createConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWD);
            Statement stmt = conn.createStatement();
            return stmt;
        }
        catch(Exception e){
            return null;  
        }
    }
    
    
}

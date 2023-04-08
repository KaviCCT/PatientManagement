/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */

// ORIGINAL DATABASE CONNECTOR CLASS AND ITS METHODS
// CONNECTS AND QUERIES CORRECTLY
// THE MYSQL DATABASES HAVE BEEN EXPORTED INCLUDED WITH MY SUBMISSION

// I HAVE SUCCESFULLY SEPERATED AND REDUCED CODE TO SEPERATE CLASSES 
// IT IS A BIT TEMPERAMENTAL SO I HAVE INCLUDED THIS CLASS INCASE
public class DBConnector {
    
//    //Dcelaring ANSI_RESET so we can reset the colour
//    public static final String ANSI_RESET = "\u001B[30m";
//    //Dcelaring ANSI colours for console message use
//    public static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_BLUE = "\u001B[34m";
//    public static final String ANSI_GREEN = "\u001B[32m";
//    public static final String ANSI_CYAN = "\u001B[36m";
//    
//    private final String DB_URL = "jdbc:mysql://localhost";
//    private final String USER = "pooa";
//    private final String PASSWD = "pooa";
//    private final String DB_NAME = "hospital";
//    
//    public void createDB() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//        try {
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWD);
//            Statement stmt = conn.createStatement();
//            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");
//
//            System.out.println(ANSI_GREEN + "Database Created..." + ANSI_RESET);
//
//            stmt.execute("USE hospital;");
//            stmt.execute("CREATE TABLE IF NOT EXISTS patients ("
//                            + "patientID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
//                            + "name VARCHAR(40) NOT NULL,"
//                            + "complaints VARCHAR(255)"
//                            + ");");
//
//            System.out.println(ANSI_GREEN + "Patient table Created...." + ANSI_RESET);
//
//            
//            
//            
//            
//            
//            stmt.execute("CREATE TABLE IF NOT EXISTS surgeryHistory ("
//                            + "surgeryID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
//                            + "patientName VARCHAR(40) NOT NULL,"
//                            + "department VARCHAR(40) NOT NULL,"
//                            + "surgeon VARCHAR(40) NOT NULL"
//                            + ");");
//            System.out.println(ANSI_GREEN + "Surgery history table created..." + ANSI_RESET);
//            
//            
//            
//            
//            stmt.execute("CREATE TABLE IF NOT EXISTS medicationHistory ("
//                            + "prescriptionID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
//                            + "patientName VARCHAR(40) NOT NULL,"
//                            + "department VARCHAR(40) NOT NULL,"
//                            + "doctor VARCHAR(40) NOT NULL"
//                            + ");");
//            System.out.println(ANSI_GREEN + "Medication history table created..." + ANSI_RESET);
//            
//            
//     
//
//        } 
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
////    public void addPatient( int patientID, String name, String[] complaints) throws SQLException{
////        Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
////        Statement stmt = conn.createStatement();
////        stmt.execute(String.format("INSERT INTO patients ( patientID, name, complaints) VALUES ('%d', %s, %s)", patientID, name,  complaints));
////        System.out.println("Patient stored.");
////    }
//    
//    public void addPatient(String name, String[] complaints) throws SQLException{
//        Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
//        Statement stmt = conn.createStatement();
//        stmt.execute(String.format("INSERT INTO patients ( name, complaints) VALUES ('%s', '%s')", name, Arrays.toString(complaints)));
//        System.out.println(ANSI_RED + "Patient data stored." + ANSI_RESET);
//    }
//    
//    
//    public String getPatient (int patientID) throws SQLException{
//        Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM patients WHERE patientID = %d;", patientID));
//        rs.next();
//        String name = rs.getString("name");
//        String complaints = rs.getString("complaints");
//        return ANSI_RED + "Patient with patient number " + patientID + " is: " + name + " and their complaints are: " + complaints + ANSI_RESET;
//    }
//    
//    public String getPatient (String name) throws SQLException{
//        Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM patients WHERE name = '%s';", name));
//        rs.next();
//        int patientID = rs.getInt("patientID");
////        Array complaints = rs.getArray("complaints");
//        String complaints = rs.getString("complaints");
//        return ANSI_RED + "Patient with patient number " + patientID + " is: " + name + " and their complaints are: " + complaints + ANSI_RESET;
//    }
//
//     public void addSurgeryHistory(String patName, String dept, String surgName) throws SQLException{
//        Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
//        Statement stmt = conn.createStatement();
//        stmt.execute(String.format("INSERT INTO surgery_History ( patientName, department, surgeon) VALUES ('%s', '%s', '%s')", patName, dept, surgName));
//        System.out.println(ANSI_RED + "Surgery history recorded." + ANSI_RESET);
//    }
//     
//      public void addMedicationHistory (String patName, String dept, String docName) throws SQLException{
//        Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
//        Statement stmt = conn.createStatement();
//        stmt.execute(String.format("INSERT INTO medication_History ( patientName, department, doctor) VALUES ('%s', '%s', '%s')", patName, dept, docName));
//        System.out.println(ANSI_RED + "Medication history recorded." + ANSI_RESET);
//    }
//    
    
    
    
    

}
    

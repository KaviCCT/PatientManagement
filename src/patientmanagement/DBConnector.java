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
 * @author kavip
 */
public class DBConnector {
    
    private final String DB_URL = "jdbc:mysql://localhost";
    private final String USER = "pooa";
    private final String PASSWD = "pooa";
    private final String DB_NAME = "hospital";
    
    public void createDB() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWD);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");

            System.out.println("Database Created.\n");

            stmt.execute("USE hospital;");
            stmt.execute("CREATE TABLE IF NOT EXISTS patients ("
                            + "patientID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "name VARCHAR(40) NOT NULL,"
                            + "complaints VARCHAR(255)"
                            + ");");

            System.out.println("Patient table Created.\n");

            
            
            
            
            
            stmt.execute("CREATE TABLE IF NOT EXISTS surgeryHistory ("
                            + "surgeryID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "patientName VARCHAR(40) NOT NULL,"
                            + "department VARCHAR(40) NOT NULL,"
                            + "surgeon VARCHAR(40) NOT NULL"
                            + ");");
            System.out.println("Surgery history table created.\n");
            
            
            
            
            stmt.execute("CREATE TABLE IF NOT EXISTS medicationHistory ("
                            + "prescriptionID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "patientName VARCHAR(40) NOT NULL,"
                            + "department VARCHAR(40) NOT NULL,"
                            + "doctor VARCHAR(40) NOT NULL"
                            + ");");
            System.out.println("Medication history table created.\n");
            
            
     

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public void addPatient( int patientID, String name, String[] complaints) throws SQLException{
//        Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
//        Statement stmt = conn.createStatement();
//        stmt.execute(String.format("INSERT INTO patients ( patientID, name, complaints) VALUES ('%d', %s, %s)", patientID, name,  complaints));
//        System.out.println("Patient stored.");
//    }
    
    public void addPatient(String name, String[] complaints) throws SQLException{
        Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
        Statement stmt = conn.createStatement();
        stmt.execute(String.format("INSERT INTO patients ( name, complaints) VALUES ('%s', '%s')", name, Arrays.toString(complaints)));
        System.out.println("Patient data stored.");
    }
    
    
    public String getPatient (int patientID) throws SQLException{
        Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM patients WHERE patientID = %d;", patientID));
        rs.next();
        String name = rs.getString("name");
        String complaints = rs.getString("complaints");
        return "Patient with patient number " + patientID + " is: " + name + " and their complaints are: " + complaints;
    }
    
    public String getPatient (String name) throws SQLException{
        Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM patients WHERE name = '%s';", name));
        rs.next();
        int patientID = rs.getInt("patientID");
//        Array complaints = rs.getArray("complaints");
        String complaints = rs.getString("complaints");
        return "Patient with patient number " + patientID + " is: " + name + " and their complaints are: " + complaints;
    }

     public void addSurgeryHistory(String patName, String dept, String surgName) throws SQLException{
        Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
        Statement stmt = conn.createStatement();
        stmt.execute(String.format("INSERT INTO surgeryHistory ( patientName, department, surgeon) VALUES ('%s', '%s', '%s')", patName, dept, surgName));
        System.out.println("Surgery history recorded.");
    }
     
      public void addMedicationHistory (String patName, String dept, String docName) throws SQLException{
        Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
        Statement stmt = conn.createStatement();
        stmt.execute(String.format("INSERT INTO medicationHistory ( patientName, department, doctor) VALUES ('%s', '%s', '%s')", patName, dept, docName));
        System.out.println("Medication history recorded.");
    }
    
    
    
    
    

}
    

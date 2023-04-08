/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */

// A CLASS SOLEY FOR READING DATA FROM THE HOSPITAL DATABASE 
public class DatabaseReader extends DatabaseIO{
    // METHOD TO SEARCH FOR PATIENT DATA BY PATIENT ID
    public static String getPatient (int patientID) throws SQLException{
        Statement stmt = createConnection();// CONNECTION TO DATABASE
        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM patients WHERE patientID = %d;", patientID));// DECLARING THE RESULT SET TO THE RETURED VALUES
        rs.next();// NEXT VALUE FROM RESULT SET
        String name = rs.getString("name"); // PARSING TO STRING AND ALLOCATING TO NAME VARAIABLE
        String complaints = rs.getString("complaints");
        return "Patient with patient number " + patientID + " is: " + name + " and their complaints are: " + complaints;
    }
    // METHOD TO SEARCH FOR PATIENT DATA BY PATIENT NAME
    public static String getPatient (String name) throws SQLException{
        Statement stmt = createConnection();
        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM patients WHERE name = '%s';", name));
        rs.next();
        int patientID = rs.getInt("patientID");
    //        Array complaints = rs.getArray("complaints");
        String complaints = rs.getString("complaints");
        return ANSI_RED + "Patient with patient number " + patientID + " is: " + name + " and their complaints are: " + complaints + ANSI_RESET;
    }
    
    
    
}

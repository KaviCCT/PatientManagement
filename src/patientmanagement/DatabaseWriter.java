/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;


/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */

// A JAVA CLASS FOR WRITING TO THE HOSPITAL DATABASE
public class DatabaseWriter extends DatabaseIO{
    
    
    // A METHOD TO ADD NEW INPATIENT DATA TAKING PATIENT NAME AND COMPLAINS AS PARAMETERS
    public static void addPatient(String name, String[] complaints) throws SQLException{
        Statement stmt = createConnection();// SQL STATEMENT EMBEDDED IN JAVA AND FORMATED APPROPRIATELY
        stmt.execute(String.format("INSERT INTO patients ( name, complaints) VALUES ('%s', '%s')", name, Arrays.toString(complaints)));
        System.out.println(ANSI_RED + "Patient data stored." + ANSI_RESET);
    }
    // A METHOD TO ADD SURGERY DATA TAKING PATIENT NAME, DEPARTMENT AND SURGEON NAME AS PARAMETERS
    public static void addSurgeryHistory(String patName, String dept, String surgName) throws SQLException{
        Statement stmt = createConnection();
        stmt.execute(String.format("INSERT INTO surgery_history ( patientName, department, surgeon) VALUES ('%s', '%s', '%s')", patName, dept, surgName));
        System.out.println(ANSI_RED + "Surgery history recorded." + ANSI_RESET);
    }    
   // A METHOD TO ADD MEDICATION HISTORY DATA TAKING PATIENT NAME, DEPARTMENT AND PRESCRIBING DOCTOR NAME AS PARAMETERS
    public static void addMedicationHistory (String patName, String dept, String docName) throws SQLException{
        Statement stmt = createConnection();
        stmt.execute(String.format("INSERT INTO medication_history ( patientName, department, doctor) VALUES ('%s', '%s', '%s')", patName, dept, docName));
        System.out.println(ANSI_RED + "Medication history recorded." + ANSI_RESET);
    }
    
}

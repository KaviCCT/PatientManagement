/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;


import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */

// CLASS FOR THE HOSPITAL DATABSE SETUP
public class DatabaseSetup extends DatabaseIO{
    
 static final String DB_NAME = "hospital";
    
    // createDB() CONNECT WITH MYSQL, AND CREATES A DTABASE, AND THREE TABLES FOR STORING PATIENT DETAILS
    // AS THEY PROGRESS THROUGH THE SYSTEM. 
    // APPROPRIATE PATIENT DATA IS STORED ON BECOMING AN INPATIENT, WHEN SURGERY IS PERFORMED OR MEDECATION PRESCRIBED
    // APPROPRIATE PRIMARY KEYS ARE ALOCATED ALONG WITH VARIABLE TYPES AND LENGTHS.]
    // DATETIME IS ALSO STORED AUTOMATICALLY ON EACH SUBMISSION WITHIN THE DATABSE
    // HOSPITAL DATABSE HAS BEEN EXPORTED AND INCLUDED IN ASSIGNEMENT SUBMISSION FILE
    public static void createDB() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
            Statement stmt = createConnection();
            System.out.println("Yes");
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");
                  
            System.out.println(ANSI_GREEN + "Database Created..." + ANSI_RESET);

            stmt.execute("USE hospital;");
            stmt.execute("CREATE TABLE IF NOT EXISTS patients ("
                            + "patientID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "name VARCHAR(40) NOT NULL,"
                            + "complaints VARCHAR(255)"
                            + ");");

            System.out.println(ANSI_GREEN + "Patient table Created...." + ANSI_RESET);
            
            stmt.execute("CREATE TABLE IF NOT EXISTS surgeryHistory ("
                            + "surgeryID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "patientName VARCHAR(40) NOT NULL,"
                            + "department VARCHAR(40) NOT NULL,"
                            + "surgeon VARCHAR(40) NOT NULL"
                            + ");");
            System.out.println(ANSI_GREEN + "Surgery history table created..." + ANSI_RESET);
            
            stmt.execute("CREATE TABLE IF NOT EXISTS medicationHistory ("
                            + "prescriptionID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "patientName VARCHAR(40) NOT NULL,"
                            + "department VARCHAR(40) NOT NULL,"
                            + "doctor VARCHAR(40) NOT NULL"
                            + ");");
            System.out.println(ANSI_GREEN + "Medication history table created..." + ANSI_RESET);   
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patientmanagement;

import java.sql.SQLException;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 * I WOULD LIKE TO APOLOGISE IN ADVANCE FOR THE COMMENTED OUT CODE INCLUDED IN MY SUBMISSION
 * I ENCOUNTERED MASSIVE SETBACKS IN MY NAIVE AND INEXPERIENCED ATTEMPTS AT BRANCHING IN GITHUB, 
 * WHICH HAS SET ME BACK A COUPLE OF DAYS AS WELL AS ENDED ANY TRUST IN GITHUB VERSION CONTROL (FOR NOW).
 * ADDITIONAL LINES OF CODE AND UNFAMILIAR SCRIPTS SOMEHOW APPERED TRHOUGHOUT MY PROJECT. SINCE 
 * REMOVING THEM AND ATTEMPTING TO REWRITE MY CODE, MY IDE HAS BEEN PERFORMING UNEXPECTECTEDLY WITH ERRORS 
 * APPEARING AND DISAPEARING SPONTANEOUSLY. FOR THESE REASONS, I HAVE BEEN RELUCTANT TO DELETE EXISTING AND 
 * WORKING CODE IN MY ATTEMPTS AT IMPLEMENTING SOLID DESIGN PRINCIPLES
 * 
 * GITHUB LINK; https://github.com/KaviCCT/PatientManagement.git
 * 
 */


public class PatientManagement{

    
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     */

    
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException  {
//        //CONNECTION TO THE DATABASE AND TABLE SETUP
//       DBConnector dbConn = new DBConnector();
//       dbConn.createDB();
    DatabaseSetup.createDB();
 
// ACCESSIGN STATIC CLASS METHODS 
// INIATING STAFFLIST METHOD IN STAFFIMPORT CLASS TO READ CURRENT STAFF
    staffImport.staffList();
// LOGIN MENU CALLED
    Login.login();
         
       
       
    }
    
}
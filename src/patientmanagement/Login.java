/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */


// LOGIN CLASS FOR RESTRICTED ACCESS
// DIFFERENT STAFF ARE PERMITTED DIFFERENT OPTIONS
// PASSWORDS ARE BASED ON DEPARTEMNT FOR THE FIRST PROTOTYPE
public class Login {
    
    //Dcelaring ANSI_RESET so we can reset the colour
    public static final String ANSI_RESET = "\u001B[30m";
    //Dcelaring ANSI colours for console message use
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
        // INSTANTIATING A NEW Scanner OBJECT CALLED userInput AND REQUIRED VARIABLES
        public static Scanner userInput = new Scanner(System.in);
        public static String password = "";
        public static String userChoice = "";
        
        // METHOD FOR LOGINING INTO PATIENT MANAGEMENT SOFTWARE
        // AN APPROPRIATE MENU BASE ON LOGIN CREDENTIALS WILL BE DISPALYED
        public static void login() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
            // WHILE LOOP USED TO CONTINUOUSLY PROMPT FOR USER INPUT UNTIL THE CORRECT PASSWORD IS ENTERED
            // boolean incorrectPassword PASSED FROM IncorrectPasswordException CLASS FOR VALIDATION
            while (IncorrectPasswordException.incorrectPassword){
                // MESSAGE PROMPTING FOR USER PASSWORD PRINTED TO CONSOLE
                System.out.println(ANSI_RED  + "\nPlease enter your password:" + ANSI_RESET);
                // try-catch USED TO CATCH THROWN IncorrectPasswordException
                try {
                    // CALLING OUR passwordChecker() METHOD FROM IncorrectPasswordException CLASS
                    // TAKING Scanner userInput AS PARAMETER
                    
                    IncorrectPasswordException.passwordChecker(password = userInput.next()); 
                }// CATCH FOR IncorrectPasswordException 
                catch (IncorrectPasswordException err) {
                 // System.out.println(err.getMessage()); 
                }// TESTING extends IOException
            }
            // PASSWORD USED TO DETERMINE DEPARTMENT AND MENU OPTIONS
            String dept = password;
            
            // ATTEMPTS AT IMPLEMENTING SOLID DESIGN PRINCIPLES
            // REDUCED AND SEPERATED CODE FOR INDIVIDUAL PURPOSES
            // WHILE LOOP DOES NOT ITERATE AS WELL AS THE ORGINAL CODE INCLUDED BELOW
            // SWITCH CASE 
          
                    String returnChoice = "";
//                    InterfaceMenu.getMenu(dept);
//                    InterfaceMenuActions.getMenuActions(dept);
                    while (!returnChoice.toUpperCase().trim().matches("Q")){
                        
                        InterfaceMenu.getMenu(dept);
                        returnChoice = InterfaceMenuActions.getMenuActions(dept);
                    }

        }

          
            
// ORIGINAL CODE INCLUDED BELOW


//            switch(password){
//                case"Cardiology":
//                case"Ophthalmology":
//                case"Oncology":
//                case"OB/GYN":
//                case"Emergency":
//                    
//                    while (!userChoice.toUpperCase().trim().matches("Q")){
//                        // OPTION MENU DISPLAYED TO TERMINAL WINDOW
//                        System.out.println("--------------------------------------------------------------------------------------------------");
//                        System.out.println(ANSI_RED + "Please choose an option A, B, C, D, E, F, G, H or Q from the Menu below:" + ANSI_RESET);
//                        System.out.println("A. Input patient details and automatically process patient");
//                        System.out.println("B. Input patient details.");
//                        System.out.println("C. Transfer patient.");
//                        System.out.println("D. Admit patient.");
//                        System.out.println("E. Perform surgery.");
//                        System.out.println("F. Prescribe medication.");
//                        System.out.println("G. Discharge patient.");
//                        System.out.println("H. Search current patient list.");
//                        System.out.println("I. Search Inpatient records by name or patient number.");
//                        System.out.println("Q. Logout.");   
//                        System.out.println("--------------------------------------------------------------------------------------------------"); 
//                        
////                        String choice = userInput.next().trim().toUpperCase();
////                        performAction(choice, password);
//
//                        // switch-case CONDITIONAL STATEMENT USED TO ASSESS USER INPUT AND SORT THROUGH MENU
//                        switch (userChoice = userInput.next().trim().toUpperCase()) { 
//                            case "A":  
//                                PatientWorkflowOptions.patientWorkflow();
//                                break;
//                            case "B":
//                                PatientWorkflowOptions.inputPatient();
//                                break;
//                            case "C":
//                                PatientWorkflowOptions.transferPatient();
//                                break;
//                            case "D":
//                                PatientWorkflowOptions.admitPatient( PatientWorkflowOptions.inputPatient());
//                                break;
//                            case "E":                              
//                                PatientWorkflowOptions.performSurgery(dept);
//                                break;
//                            case "F":                              
//                                PatientWorkflowOptions.prescribeMeds(dept);
//                                break;
//                            case "G":
//                                PatientWorkflowOptions.dischargePatient();
//                                break;
//                            case "H":
//                                PatientWorkflowOptions.currentPatientSearch();
//                                break;
//                            case "I":
//                                PatientWorkflowOptions.searchPatient();
//                                break;
//                            case "Q":// IF USER INPUTS Q OR q
//                                    // PRINTED MESSAGE TO CONSOLE WHEN USER CHOOSES TO QUIT
//                                    System.out.println(ANSI_BLUE + "\nGoodbye!" + ANSI_RESET);
//                                    userInput.close();
//                                break;      
//
//                        }
//                    }
//                    break;
//                case"Rheumatology":
//                   
//                    
//                    while (!userChoice.toUpperCase().trim().matches("Q")){
//                        // OPTION MENU DISPLAYED TO TERMINAL WINDOW
//                        System.out.println("--------------------------------------------------------------------------------------------------");
//                        System.out.println(ANSI_RED + "Please choose an option A, B, D, F, G, H or Q from the Menu below:" + ANSI_RESET);
//                        System.out.println("A. Input patient details and automatically process patient");
//                        System.out.println("B. Input patient details.");
//                        System.out.println("D. Admit patient.");
//                        System.out.println("F. Prescribe medication.");
//                        System.out.println("G. Discharge patient.");
//                        System.out.println("H. Search current patient list.");
//                        System.out.println("I. Search Inpatient records by name or patient number.");
//                        System.out.println("Q. Logout.");   
//                        System.out.println("--------------------------------------------------------------------------------------------------"); 
//
//                        // switch-case CONDITIONAL STATEMENT USED TO ASSESS USER INPUT AND SORT THROUGH MENU
//                        switch (userChoice = userInput.next().trim().toUpperCase()) { 
//                            case "A":  
//                                PatientWorkflowOptions.patientWorkflow();
//                                break;
//                            case "B":
//                                PatientWorkflowOptions.inputPatient();
//                                break;
//                            case "D":
//                                PatientWorkflowOptions.admitPatient( PatientWorkflowOptions.inputPatient());
//                                break;
//                            case "E":                              
//                                PatientWorkflowOptions.performSurgery(dept);
//                                break;
//                            case "F":
//                                PatientWorkflowOptions.prescribeMeds(dept);
//                                break;
//                            case "G":
//                                PatientWorkflowOptions.dischargePatient();
//                                break;
//                            case "H":
//                                PatientWorkflowOptions.currentPatientSearch();
//                                break;
//                            case "I":
//                                PatientWorkflowOptions.searchPatient();
//                                break;
//                            case "Q":// IF USER INPUTS Q OR q
//                                    // PRINTED MESSAGE TO CONSOLE WHEN USER CHOOSES TO QUIT
//                                    System.out.println(ANSI_BLUE + "\nGoodbye!" + ANSI_RESET);
//                                    userInput.close();
//                                break;      
//                        }
//                    }
//                    break;      
//                case"ENT":
//                    while (!userChoice.toUpperCase().trim().matches("Q")){
//                        // OPTION MENU DISPLAYED TO TERMINAL WINDOW
//                        System.out.println("--------------------------------------------------------------------------------------------------");
//                        System.out.println(ANSI_RED + "Please choose an option A, B, D, E, F, G, H or Q from the Menu below:" + ANSI_RESET);
//                        System.out.println("A. Input patient details and automatically process patient");
//                        System.out.println("B. Input patient details.");
//                        System.out.println("D. Admit patient.");
//                        System.out.println("E. Perform surgery.");
//                        System.out.println("F. Prescribe medication.");
//                        System.out.println("G. Discharge patient.");
//                        System.out.println("H. Search current patient list.");
//                        System.out.println("I. Search Inpatient records by name or patient number.");
//                        System.out.println("Q. Logout.");   
//                        System.out.println("--------------------------------------------------------------------------------------------------"); 
//
//                        // switch-case CONDITIONAL STATEMENT USED TO ASSESS USER INPUT AND SORT THROUGH MENU
//                        switch (userChoice = userInput.next().trim().toUpperCase()) { 
//                            case "A":  
//                                PatientWorkflowOptions.patientWorkflow();
//                                break;
//                            case "B":
//                                PatientWorkflowOptions.inputPatient();
//                                break;
//                            case "D":
//                                PatientWorkflowOptions.admitPatient( PatientWorkflowOptions.inputPatient());
//                                break;
//                            case "E":                              
//                                PatientWorkflowOptions.performSurgery(dept);
//                                break;
//                            case "F":
//                                PatientWorkflowOptions.prescribeMeds(dept);
//                                break;
//                            case "G":
//                                PatientWorkflowOptions.dischargePatient();
//                                break;
//                            case "H":
//                                PatientWorkflowOptions.currentPatientSearch();
//                                break;
//                            case "I":
//                                PatientWorkflowOptions.searchPatient();
//                                break;
//                            case "Q":// IF USER INPUTS Q OR q
//                                    // PRINTED MESSAGE TO CONSOLE WHEN USER CHOOSES TO QUIT
//                                    System.out.println(ANSI_BLUE + "\nGoodbye!" + ANSI_RESET);
//                                    userInput.close();
//                                break;      
//                        }
//                    }
//                    break;
//                case"Occupational Therapy":
//                    while (!userChoice.toUpperCase().trim().matches("Q")){
//                        // OPTION MENU DISPLAYED TO TERMINAL WINDOW
//                        System.out.println("--------------------------------------------------------------------------------------------------");
//                        System.out.println(ANSI_RED + "Please choose an option B, F, G, H or Q from the Menu below:" + ANSI_RESET);
//                        System.out.println("B. Input patient details.");
//                        System.out.println("F. Prescribe medication.");
//                        System.out.println("G. Discharge patient.");
//                        System.out.println("H. Search current patient list.");
//                        System.out.println("I. Search Inpatient records by name or patient number.");
//                        System.out.println("Q. Logout.");   
//                        System.out.println("--------------------------------------------------------------------------------------------------"); 
//
//                        // switch-case CONDITIONAL STATEMENT USED TO ASSESS USER INPUT AND SORT THROUGH MENU
//                        switch (userChoice = userInput.next().trim().toUpperCase()) { 
//                            case "B":
//                                PatientWorkflowOptions.inputPatient();
//                                break;
//                            case "F":
//                                PatientWorkflowOptions.prescribeMeds(dept);
//                                break;
//                            case "G":
//                                PatientWorkflowOptions.dischargePatient();
//                                break;
//                            case "H":
//                                PatientWorkflowOptions.currentPatientSearch();
//                                break;
//                            case "I":
//                                PatientWorkflowOptions.searchPatient();
//                                break;
//                            case "Q":// IF USER INPUTS Q OR q
//                                    // PRINTED MESSAGE TO CONSOLE WHEN USER CHOOSES TO QUIT
//                                    System.out.println(ANSI_BLUE + "\nGoodbye!" + ANSI_RESET);
//                                    userInput.close();
//                                break;      
//                        }
//                    }
//                    break;
//                case"Radiology":
//                    while (!userChoice.toUpperCase().trim().matches("Q")){
//                       // char choice = chooseAction(department);
//                       
//                        // OPTION MENU DISPLAYED TO TERMINAL WINDOW
//                        System.out.println("--------------------------------------------------------------------------------------------------");
//                        System.out.println(ANSI_RED + "Please choose an option B, C, H or Q from the Menu below:" + ANSI_RESET);
//                        System.out.println("B. Input patient details.");
//                        System.out.println("C. Transfer patient.");
//                        System.out.println("H. Search current patient list.");
//                        System.out.println("I. Search Inpatient records by name or patient number.");
//                        System.out.println("Q. Logout.");   
//                        System.out.println("--------------------------------------------------------------------------------------------------");
//
//                        // switch-case CONDITIONAL STATEMENT USED TO ASSESS USER INPUT AND SORT THROUGH MENU
//                        switch (userChoice = userInput.next().trim().toUpperCase()) { 
//                            case "B":
//                                PatientWorkflowOptions.inputPatient();
//                                break;
//                            case "C":
//                                PatientWorkflowOptions.transferPatient();
//                                break;
//                            case "H":
//                                PatientWorkflowOptions.currentPatientSearch();
//                                break;
//                            case "I":
//                                PatientWorkflowOptions.searchPatient();
//                                break;
//                            case "Q":// IF USER INPUTS Q OR q
//                                    // PRINTED MESSAGE TO CONSOLE WHEN USER CHOOSES TO QUIT
//                                    System.out.println(ANSI_BLUE + "\nGoodbye!" + ANSI_RESET);
//                                    userInput.close();
//                                break;      
//                        }
//                    }
//                    break;
//            }

}//END OF CLASS
    
    

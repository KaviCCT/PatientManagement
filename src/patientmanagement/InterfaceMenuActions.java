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


//  CLASS FOR MENU ACTIONS TO BE CALLED WITH INTERFACE MENU ON SUCCESFUL LOGIN
public class InterfaceMenuActions {
    
    //Dcelaring ANSI_RESET so we can reset the colour
    public static final String ANSI_RESET = "\u001B[30m";
    //Dcelaring ANSI colours for console message use
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    public static String getMenuActions(String dept) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        // SCANNER INSTANTIATED FOR USER INPUT
        Scanner userInput = new Scanner(System.in);
        String userChoice = "";
        
        
        // THE APPROPRIATE MENU METHODS WILL BE AVAILABLE BASE ON USER CORRESPONDING WITH THE DISPLAYED MENU OPTIONS
        switch(dept){
            // NOT THE MOST EFFICIENT CODE BUT ANOTHER INCOMPLETE ATTEMPT AT SOLID DESIGN PRINCIPLES
            // DOES NOT LOOP AND RESPOND AS WELL AS THE ORGINAL CODE COMMENTED OUT OF THE LOGIN CLASS
            case"Cardiology":
            case"Ophthalmology":
            case"Oncology":
            case"OB/GYN":
            case"Emergency":
                   // while (!userChoice.toUpperCase().trim().matches("Q")){
                    // switch-case CONDITIONAL STATEMENT USED TO ASSESS USER INPUT AND SORT THROUGH MENU
                        switch (userChoice = userInput.next().trim().toUpperCase()) { 
                            case "A":  
                                PatientWorkflowOptions.patientWorkflow();
                                break;
                            case "B":
                                PatientWorkflowOptions.inputPatient();
                                break;
                            case "C":
                                PatientWorkflowOptions.transferPatient();
                                break;
                            case "D":
                                PatientWorkflowOptions.admitPatient( PatientWorkflowOptions.inputPatient());
                                break;
                            case "E":                              
                                PatientWorkflowOptions.performSurgery(dept);
                                break;
                            case "F":                              
                                PatientWorkflowOptions.prescribeMeds(dept);
                                break;
                            case "G":
                                PatientWorkflowOptions.dischargePatient();
                                break;
                            case "H":
                                PatientWorkflowOptions.currentPatientSearch();
                                break;
                            case "I":
                                PatientWorkflowOptions.searchPatient();
                                break;
                            case "Q":// IF USER INPUTS Q OR q
                                    // PRINTED MESSAGE TO CONSOLE WHEN USER CHOOSES TO QUIT
                                    System.out.println(ANSI_BLUE + "\nGoodbye!" + ANSI_RESET);
                                return userChoice;
                               

                            default: 
                                System.out.println(ANSI_RED +"\nThat is an invalid option." + ANSI_RESET);
                        }
                  //  }
            case"Rheumatology":
                //while (!userChoice.toUpperCase().trim().matches("Q")){
                    switch (userChoice = userInput.next().trim().toUpperCase()) { 
                            case "A":  
                                PatientWorkflowOptions.patientWorkflow();
                                break;
                            case "B":
                                PatientWorkflowOptions.inputPatient();
                                break;
                            case "D":
                                PatientWorkflowOptions.admitPatient( PatientWorkflowOptions.inputPatient());
                                break;
                            case "E":                              
                                PatientWorkflowOptions.performSurgery(dept);
                                break;
                            case "F":
                                PatientWorkflowOptions.prescribeMeds(dept);
                                break;
                            case "G":
                                PatientWorkflowOptions.dischargePatient();
                                break;
                            case "H":
                                PatientWorkflowOptions.currentPatientSearch();
                                break;
                            case "I":
                                PatientWorkflowOptions.searchPatient();
                                break;
                            case "Q":// IF USER INPUTS Q OR q
                                    // PRINTED MESSAGE TO CONSOLE WHEN USER CHOOSES TO QUIT
                                    System.out.println(ANSI_BLUE + "\nGoodbye!" + ANSI_RESET);
                                return userChoice;  

                        default: 
                            System.out.println(ANSI_RED +"\nThat is an invalid option." + ANSI_RESET);      
                        }
               // }       
            case"ENT":
               // while (!userChoice.toUpperCase().trim().matches("Q")){
                    switch (userChoice = userInput.next().trim().toUpperCase()) { 
                        case "A":  
                            PatientWorkflowOptions.patientWorkflow();
                            break;
                        case "B":
                            PatientWorkflowOptions.inputPatient();
                            break;
                        case "D":
                            PatientWorkflowOptions.admitPatient( PatientWorkflowOptions.inputPatient());
                            break;
                        case "E":                              
                            PatientWorkflowOptions.performSurgery(dept);
                            break;
                        case "F":
                            PatientWorkflowOptions.prescribeMeds(dept);
                            break;
                        case "G":
                            PatientWorkflowOptions.dischargePatient();
                            break;
                        case "H":
                            PatientWorkflowOptions.currentPatientSearch();
                            break;
                        case "I":
                            PatientWorkflowOptions.searchPatient();
                            break;
                        case "Q":// IF USER INPUTS Q OR q
                                // PRINTED MESSAGE TO CONSOLE WHEN USER CHOOSES TO QUIT
                                System.out.println(ANSI_BLUE + "\nGoodbye!" + ANSI_RESET);
                            return userChoice;  

                        default: 
                            System.out.println(ANSI_RED +"\nThat is an invalid option." + ANSI_RESET);      
                    }
                //}
                        
            case"Occupational Therapy":
               // while (!userChoice.toUpperCase().trim().matches("Q")){
                    switch (userChoice = userInput.next().trim().toUpperCase()) { 
                        case "B":
                            PatientWorkflowOptions.inputPatient(); 
                            break;
                        case "F":
                            PatientWorkflowOptions.prescribeMeds(dept);
                            break;
                        case "G":
                            PatientWorkflowOptions.dischargePatient();
                            break;
                        case "H":
                            PatientWorkflowOptions.currentPatientSearch();
                            break;
                        case "I":
                            PatientWorkflowOptions.searchPatient();
                            break;
                        case "Q":// IF USER INPUTS Q OR q
                                // PRINTED MESSAGE TO CONSOLE WHEN USER CHOOSES TO QUIT
                                System.out.println(ANSI_BLUE + "\nGoodbye!" + ANSI_RESET);
                            return userChoice;  

                        default: 
                            System.out.println(ANSI_RED +"\nThat is an invalid option." + ANSI_RESET);      
                    }
               // }
                
            case"Radiology":
                 //while (!userChoice.toUpperCase().trim().matches("Q")){   
                    switch (userChoice = userInput.next().trim().toUpperCase()) { 
                        case "B":
                            PatientWorkflowOptions.inputPatient();
                            break;
                        case "C":
                            PatientWorkflowOptions.transferPatient();
                            break;
                        case "H":
                            PatientWorkflowOptions.currentPatientSearch();
                            break;
                        case "I":
                            PatientWorkflowOptions.searchPatient();
                            break;
                        case "Q":// IF USER INPUTS Q OR q
                                // PRINTED MESSAGE TO CONSOLE WHEN USER CHOOSES TO QUIT
                                System.out.println(ANSI_BLUE + "\nGoodbye!" + ANSI_RESET);
                            return userChoice;  

                        default: 
                            System.out.println(ANSI_RED +"\nThat is an invalid option." + ANSI_RESET);
                    }  
                 //}
            default:   
             // default AS A CATCH WITH ERROR MESSAGE PRINTED TO TERMINAL
            System.out.println(ANSI_RED +"\nThat is an invalid option." + ANSI_RESET);  
        }
    return userChoice;
    }
    
}

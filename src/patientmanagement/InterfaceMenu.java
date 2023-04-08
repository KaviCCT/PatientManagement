/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */
// A METHOD TO LOAD THE APPROPRIATE MENU OPTIONS BASES ON USER LOGIN I.E DEPARTMENT
// A PROTOTYPE WAS REQUESTED TO DEMONSTRATE AN ONNOVATIVE, INTEROPERABLE AND INTELLIGENTLY DESIGN PATIENT MANAGEMENT SOFTWARE
// IF IT ONLY INCLUDED ONE AUTOMATIC PROCESSSING OPTION THERE WOULDNT BE MUCH POINT
// THIS WAS A POOR ATTEMPT AT SOLID DESIGN PRINCIPLES

public class InterfaceMenu {
    
    //Dcelaring ANSI_RESET so we can reset the colour
    public static final String ANSI_RESET = "\u001B[30m";
    //Dcelaring ANSI colours for console message use
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    public static void getMenu(String dept){
        
        switch(dept){
            // OPTIONS ARE DETERMINE BASED ON THE DEPARTMENT TABLE PROVIDED IN THE ASSIGNEMENT SPECIFIATION
            case"Cardiology":
            case"Ophthalmology":
            case"Oncology":
            case"OB/GYN":
            case"Emergency":
                
                // OPTION MENU DISPLAYED TO TERMINAL WINDOW BASED ON USER/PASSWORD/DEPARTMENT
                System.out.println("--------------------------------------------------------------------------------------------------");
                        System.out.println(ANSI_RED + "Please choose an option A, B, C, D, E, F, G, H or Q from the Menu below:" + ANSI_RESET);
                        System.out.println("A. Input patient details and automatically process patient");
                        System.out.println("B. Input patient details.");
                        System.out.println("C. Transfer patient.");
                        System.out.println("D. Admit patient.");
                        System.out.println("E. Perform surgery.");
                        System.out.println("F. Prescribe medication.");
                        System.out.println("G. Discharge patient.");
                        System.out.println("H. Search current patient list.");
                        System.out.println("I. Search Inpatient records by name or patient number.");
                        System.out.println("Q. Logout.");   
                        System.out.println("--------------------------------------------------------------------------------------------------");
                        break;
            case"Rheumatology":
                
                System.out.println("--------------------------------------------------------------------------------------------------");
                        System.out.println(ANSI_RED + "Please choose an option A, B, D, F, G, H or Q from the Menu below:" + ANSI_RESET);
                        System.out.println("A. Input patient details and automatically process patient");
                        System.out.println("B. Input patient details.");
                        System.out.println("D. Admit patient.");
                        System.out.println("F. Prescribe medication.");
                        System.out.println("G. Discharge patient.");
                        System.out.println("H. Search current patient list.");
                        System.out.println("I. Search Inpatient records by name or patient number.");
                        System.out.println("Q. Logout.");   
                        System.out.println("--------------------------------------------------------------------------------------------------"); 
                        break;
            case"ENT":
                
                System.out.println("--------------------------------------------------------------------------------------------------");
                        System.out.println(ANSI_RED + "Please choose an option A, B, D, E, F, G, H or Q from the Menu below:" + ANSI_RESET);
                        System.out.println("A. Input patient details and automatically process patient");
                        System.out.println("B. Input patient details.");
                        System.out.println("D. Admit patient.");
                        System.out.println("E. Perform surgery.");
                        System.out.println("F. Prescribe medication.");
                        System.out.println("G. Discharge patient.");
                        System.out.println("H. Search current patient list.");
                        System.out.println("I. Search Inpatient records by name or patient number.");
                        System.out.println("Q. Logout.");   
                        System.out.println("--------------------------------------------------------------------------------------------------"); 
                        break;
            case"Occupational Therapy":
                
                        System.out.println("--------------------------------------------------------------------------------------------------");
                        System.out.println(ANSI_RED + "Please choose an option B, F, G, H or Q from the Menu below:" + ANSI_RESET);
                        System.out.println("B. Input patient details.");
                        System.out.println("F. Prescribe medication.");
                        System.out.println("G. Discharge patient.");
                        System.out.println("H. Search current patient list.");
                        System.out.println("I. Search Inpatient records by name or patient number.");
                        System.out.println("Q. Logout.");   
                        System.out.println("--------------------------------------------------------------------------------------------------"); 
                        break;
            case"Radiology":
                    
                        System.out.println("--------------------------------------------------------------------------------------------------");
                        System.out.println(ANSI_RED + "Please choose an option B, C, H or Q from the Menu below:" + ANSI_RESET);
                        System.out.println("B. Input patient details.");
                        System.out.println("C. Transfer patient.");
                        System.out.println("H. Search current patient list.");
                        System.out.println("I. Search Inpatient records by name or patient number.");
                        System.out.println("Q. Logout.");   
                        System.out.println("--------------------------------------------------------------------------------------------------");
                        break;
                        
                        
        }
        
    }
    
}

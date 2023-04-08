/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.io.IOException;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */

// IncorrectPasswordException CLASS WHICH EXTENDS IOException
public class IncorrectPasswordException  extends IOException {

    //Dcelaring ANSI_RESET so we can reset the colour
    public static final String ANSI_RESET = "\u001B[30m";
    //Dcelaring ANSI colours for console message use
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    // boolean incorrectPassword USED FOR VALIDATION LOOP 
    // static TO BE SHARED ACROSS CLASSES
    public static boolean incorrectPassword = true;
    // IncorrectPasswordException 
    public IncorrectPasswordException() {
        // ERROR MESSAGE OVERIDES IOException MESSAGE USING super
        super ("IncorrectPasswordException");
        // ERROR MESSAGE PRINTED TO TERMIAL WINDOW FOR USER
        System.out.println(ANSI_RED + "\nThat password is incorrect. Please try again." + ANSI_RESET);
    }
    
    // passwordChecker() METHOD public AND static TO BE ACCESSED FROM OUTSIDE CLASS
    // METHOD VALIDATES USER INPUT TAKEN AS A String PARAMETER
    // THROWS IncorrectPasswordException FOR FUTURE DEVELOPERS BENEFIT
    // PASSWORDS SET BASE ON MENU OPTIONS WHICH IS BASED ON DEPARTMENTS
    public static void passwordChecker(String password) throws IncorrectPasswordException{
        if ((password.matches("Cardiology")) || (password.matches("Rheumatology")) || (password.matches("ENT")) || (password.matches("Ophthalmology")) || 
                (password.matches("Occupational")) || (password.matches("Radiology")) || (password.matches("Oncology"))  || (password.matches("OB/GYN")) 
                || (password.matches("Emergency"))){ // REGEX PATTERN USED TO MATCH PASSWORDS
            System.out.println(ANSI_GREEN + "\nPassword excepted. Welcome!!" + ANSI_RESET);
            incorrectPassword = false; // boolean incorectPassword CHANGED TO false TO END LOOP
            
        }
        else{// IF PASSWORD FAILS VALIDATION, OUR IncorrectPasswordException() METHOD IS THROWN
            throw new IncorrectPasswordException();
        }
            
    }
    

    
}// END OF CLASS
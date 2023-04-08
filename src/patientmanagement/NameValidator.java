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


// A CLASS FOR VALIDATING PATIENT NAMES
public class NameValidator {
    
//        METHOD THAT TAKES A STRING  name AS A PARAMETER AND RETURNS A BOOLEAN true 
//        IF THE name PASSES VALIDATION
    public static boolean validateName(String name){
        
        boolean isGood = true; //boolean isGood set

        // CONDITIONAL STATEMENT FOR VALIDATING name VIA Regex PATTERNS (Hyphenated names excepted spaces)
        if (!(name.matches("[a-zA-Z-]+")) && !(name.matches("[a-zA-Z-]+\\s[a-zA-Z-]+"))){
            System.out.println("Invalid Name.");
            // IF name FAILS VALIDATION isGood BOOLEAN CHANGED AND RETURNED false AND ERROR MESSAGE PRINTED TO WINDOW
            isGood = false;
        }
        // return isGood in current state
        return isGood;
    }
    

    
    
}



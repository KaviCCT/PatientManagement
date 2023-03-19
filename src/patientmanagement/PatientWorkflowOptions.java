/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import static patientmanagement.Login.userInput;

/**
 *
 * @author kavip
 */
public class PatientWorkflowOptions {
    public static void inputPatient(){
        System.out.println("Please enter the patients first name:");
        String patFirstName = userInput.next();
        System.out.println("Please enter the patients last name:");
        String patLastName = userInput.next();
        System.out.println("Please enter the patients complaints:");
        String complaintsLine = userInput.next();
        String name = patFirstName + patLastName;
        String complaintsArray [];
        if (complaintsLine.contains(",")){
            complaintsArray  =  complaintsLine.split(",");
        }
        else {
            complaintsArray  = complaintsLine.split(" ");
        }
        Patient pat = new Patient("name", complaintsArray);
        System.out.println("New patient added");
    }
    
    public static void patientWorkflow(){
        
        System.out.println("Please enter the patients first name:");
        String patFirstName = userInput.next();
        System.out.println("Please enter the patients last name:");
        String patLastName = userInput.next();
        System.out.println("Please enter the patients complaints:");
        String complaintsLine = userInput.next();
        String name = patFirstName + patLastName;
        String complaintsArray [];
        if (complaintsLine.contains(",")){
            complaintsArray  =  complaintsLine.split(",");
        }
        else {
            complaintsArray  = complaintsLine.split(" ");
        }
        Patient pat = new Patient("name", complaintsArray);
        System.out.println("New patient added");
        for (int i = 0; i < complaintsArray.length; i++){
            
        String department = complaintsArray[i];
        pat.transferDepartment(department);
        
        
    }
        
      
    
}

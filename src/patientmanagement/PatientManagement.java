/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patientmanagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author kavip
 */
public class PatientManagement{

    
        //Dcelaring ANSI_RESET so we can reset the colour
    public static final String ANSI_RESET = "\u001B[30m";
    //Dcelaring ANSI_RED colour for error message use
    public static final String ANSI_RED = "\u001B[31m";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        try {
            //Declaring and reading from text file path specified
            Scanner file = new Scanner(new FileReader("C:\\Users\\kavip\\Desktop\\New folder\\Study\\Applied Software Development\\Java Programming Object Oriented\\24_3_ Sláintecare Doctor Info.csv"));
        
            String docName;
            String dept;
            boolean isSurgeon = false;
            boolean isOnDuty = false;
            
            if (!file.hasNext()){
                System.out.println(ANSI_RED + "That is an empty file." + ANSI_RESET);
            }
            
            //Loop for reading all lines in file
            //Using .hasNext instead of .hasNextLine to avoid throwing errors for empty lines at end of file
            while (file.hasNextLine()){
                
                //Skipp empty lines in input file
                file.skip("[\\s]*");
            
                String fileLine = file.nextLine();
                System.out.println(fileLine);
                String fileLineArray[] = fileLine.split(",");
                docName = fileLineArray[0];
                System.out.println("Name: " + docName);
                dept = fileLineArray[1];
                System.out.println("Department: " + dept);
                String surgeon = fileLineArray[3];
                System.out.println("Surgeon: " + surgeon);
                String duty = fileLineArray[4];
                System.out.println("On duty: " + duty);
                if(surgeon.trim().toLowerCase().matches("yes")){
                    isSurgeon = true;
                }
                if (duty.trim().toLowerCase().matches("yes")){
                    isOnDuty = true;
                }
                
                ArrayList <Doctor> doctors = new ArrayList <>();

                switch(dept){
                    case"Cardiology":
                        Cardiology card = new Cardiology("docName", "dept", isSurgeon, isOnDuty);
                        doctors.add(card);
                        break;

                    case"Rheumatology":
                        Rheumatology rheum = new Rheumatology("docName", "dept", isSurgeon, isOnDuty);
                        doctors.add(rheum);
                        break;

                    case"ENT":
                        ENT emt = new ENT("docName", "dept", isSurgeon, isOnDuty);
                        doctors.add(emt);
                        break;

                    case"Ophthalmology":
                        Ophthalmology oph = new Ophthalmology("docName", "dept", isSurgeon, isOnDuty);
                        doctors.add(oph);
                        break;

                    case"Occupational Therapy":
                        OccupationalTherapy ot = new OccupationalTherapy("docName", "dept", isSurgeon, isOnDuty);
                        doctors.add(ot);
                        break;

                    case"Radiology":
                        Radiology rad = new Radiology("docName", "dept", isSurgeon, isOnDuty);
                        doctors.add(rad);
                        break;

                    case"Oncology":
                        Oncology onc = new Oncology("docName", "dept", isSurgeon, isOnDuty);
                        doctors.add(onc);
                        break;

                    case"OB/GYN":
                        ObGyn og = new ObGyn("docName", "dept", isSurgeon, isOnDuty);
                        doctors.add(og);
                        break;

                    case"Emergency":
                        Emergency er = new Emergency("docName", "dept", isSurgeon, isOnDuty);
                        doctors.add(er);
                        break;

                    default:
                    // default AS A CATCH WITH ERROR MESSAGE PRINTED TO TERMINAL
                    System.out.println(ANSI_RED +"\nThat is an invalid option." + ANSI_RESET);
                } 
                    
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ANSI_RED + "File not found." + ANSI_RESET);;
        }
        
        // CREATING A NEW SCANNER OBJECT TO TAKE USER INPUT
        Scanner userInput = new Scanner (System.in);
        // DECLARING AND INITIALISING VARIABLES FOR CODE
        String userChoice = "";    
        
       Login.login();
            
    }
    
}
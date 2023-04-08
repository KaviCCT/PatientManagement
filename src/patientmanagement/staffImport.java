/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */

// CLASS ALOCATED TO READING CURRENT STAFF DETAILS FROM A CSV FILE AND CREATING THE APPROPRIATED DOCTOR OBJECTS
public class staffImport {
    
    //Dcelaring ANSI_RESET so we can reset the colour
    public static final String ANSI_RESET = "\u001B[30m";
    //Dcelaring ANSI colours for console message use
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    public static ArrayList staffList(){
    
        // TRY CATCH FOR ERRORS READING FROM A CSV FILE
         try {
            //Declaring and reading from text file path specified
            Scanner file = new Scanner(new FileReader("C:\\Users\\kavip\\Desktop\\New folder\\Study\\Applied Software Development\\Java Programming Object Oriented\\24_3_ Sláintecare Doctor Info.csv"));
            // DECLARING REQUIRED VARIABLES 
            // VARIABLES ARE DOCTOR CLASS FIELDS AND WILL BE SET BASED ON THE DATA IN THE CSV STAFF FILE
            String docName;
            String dept;
            String spec;
            boolean isSurgeon = false;
            boolean isOnDuty = false;
            // CHECKING FOR EMPTY FILE
            if (!file.hasNext()){
                System.out.println(ANSI_RED + "That is an empty file." + ANSI_RESET);
            }
            
            
            //Loop for reading all lines in file
            //Using .hasNext instead of .hasNextLine to avoid throwing errors for empty lines at end of file
            while (file.hasNextLine()){
                
                //Skipp empty lines in input file
                file.skip("[\\s]*");
                // ALLOCATING String fileLine TO THE NEXT FILE LINE .nextLine()
                String fileLine = file.nextLine();
                // SPLITTING filLine INTO AN ARRAY OF SUBSTRING AT "," USING REGEX AND split()
                // STRING IT IN fileLineArray[]
                String fileLineArray[] = fileLine.split(",");
                // BASE ON THE FORMAT OF THE CSV FILE AND EACH LINE, VALUES ARE ALLOCATED TO EACH VARIABLE BASED ON THEIR POSITION
                docName = fileLineArray[0];
                dept = fileLineArray[1];
                spec = fileLineArray[2];
                String surgeon = fileLineArray[3];
                String duty = fileLineArray[4];
                // CONVERTING DATA READ IN CSV FILE TO APPROPRIATE BOOLEAN VALUE
                if(surgeon.trim().toLowerCase().matches("yes")){
                    isSurgeon = true;
                }
                if (duty.trim().toLowerCase().matches("yes")){
                    isOnDuty = true;
                }
                // SWITCH CASE USED TO CREATE AND ADD NEW DOCTOR OBJECTS DETERMINED BY THEIR DEPARTMENT
                switch(dept){
                    case"Cardiology": // IF DEPARTMENT MATCHES "Cardiology" A NEW CARDILOGIST OBJECT IS CREATED
                        Cardiology card = new Cardiology(docName, dept, isSurgeon, isOnDuty); //ATTRIBUTES ARE ASSIGNED ON CONSTRUCTION BASED ON THE DATA READ FROM THE CSV FILE
                        Doctor.doctors.add(card); // EACH NEW DOCTOR OBJECT IS ADDED TO AN ARRAYLIST OF DOCTORS 
                        break;

                    case"Rheumatology":
                        Rheumatology rheum = new Rheumatology(docName, dept, isSurgeon, isOnDuty);
                        Doctor.doctors.add(rheum);
                        break;

                    case"ENT":
                        ENT emt = new ENT(docName, dept, isSurgeon, isOnDuty);
                        Doctor.doctors.add(emt);
                        break;

                    case"Ophthalmology":
                        Ophthalmology oph = new Ophthalmology(docName, dept, isSurgeon, isOnDuty);
                        Doctor.doctors.add(oph);
                        break;

                    case"Occupational Therapy":
                        OccupationalTherapy ot = new OccupationalTherapy(docName, dept, isSurgeon, isOnDuty);
                        Doctor.doctors.add(ot);
                        break;

                    case"Radiology":
                        Radiology rad = new Radiology(docName, dept, isSurgeon, isOnDuty);
                        Doctor.doctors.add(rad);
                        break;

                    case"Oncology":
                        Oncology onc = new Oncology(docName, dept, isSurgeon, isOnDuty);
                        Doctor.doctors.add(onc);
                        break;

                    case"OB/GYN":
                        ObGyn og = new ObGyn(docName, dept, isSurgeon, isOnDuty);
                        Doctor.doctors.add(og);
                        break;

                    case"Emergency": // EMERGENECY IS THE ONLY DEPARTMENT WHERE DOCTOR SPECIALITY IS DIFFERENT TO USUAL DEPARTMENT
                        Emergency er = new Emergency(docName, dept, spec, isSurgeon, isOnDuty);
                        Doctor.doctors.add(er);
                        break;

                    default:
                    // default AS A CATCH WITH ERROR MESSAGE PRINTED TO TERMINAL
                    //System.out.println(ANSI_RED +"\nThat is an invalid option." + ANSI_RESET);
                }
            }
            System.out.println(ANSI_GREEN + "Staff List loaded." + ANSI_RESET);
            System.out.println("***********************************");
        }
         catch (FileNotFoundException ex) {
            System.out.println(ANSI_RED + "File not found." + ANSI_RESET);
        }
        return Doctor.doctors; // THE LIST OF DOCTORS PROCEESSD FROM THE CSV FILE IS RETURNED
    }   
    
    
}

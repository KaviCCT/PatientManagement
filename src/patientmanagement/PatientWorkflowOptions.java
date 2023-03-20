/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.util.ListIterator;
import static patientmanagement.Login.userInput;

/**
 *
 * @author kavip
 */
public class PatientWorkflowOptions {
    
        //Declaring ANSI_RESET so we can reset the colour
    public static final String ANSI_RESET = "\u001B[30m";
    //Declaring ANSI_RED colour for error message use
    public static final String ANSI_RED = "\u001B[31m";
    //Declaring ANSI_BLUE colour for User Interface use
    public static final String ANSI_BLUE = "\u001B[34m";
    
    public static void inputPatient(){
        System.out.println("Please enter the patients first name:");
        String patFirstName = userInput.next();
        System.out.println("Please enter the patients last name:");
        String patLastName = userInput.next();
        System.out.println("Please enter the patients complaints:");
        String complaintsLine = userInput.next();
        String name = patFirstName + patLastName;
        String complaints [];
        if (complaintsLine.contains(",")){
            complaints  =  complaintsLine.split(",");
        }
        else if(complaintsLine.contains(", ")){
            complaints  = complaintsLine.split(", ");
        }
        else{
            complaints  = complaintsLine.split(" ");
        }
        Patient pat = new Patient("name", complaints);
        System.out.println("New patient added");
    }
    
    public static void patientWorkflow(){
        
        System.out.println("Please enter the patients first name:");
        String patFirstName = userInput.next();
        System.out.println("Please enter the patients last name:");
        String patLastName = userInput.next();
        System.out.println("Please enter the patients complaints:");
        String complaintsLine = userInput.next();
        String name = patFirstName + " " + patLastName;
        String complaintsArray [];
        if (complaintsLine.contains(" ")){
            complaintsArray  =  complaintsLine.split(" ");
        }
        else {
            complaintsArray  = complaintsLine.split(",");
        }
        Patient pat = new Patient(name, complaintsArray);
        System.out.println("New patient added");
        
        //for (int i = 0; i < complaintsArray.length; i++){
            for (String complaintsArray1 : complaintsArray){
                //String department = complaintsArray[i].trim();
                String department = complaintsArray1.trim();
                pat.transferDepartment(department);
                System.out.println(pat.getName() + " has been transfered to " + pat.getDepartment());
                if (pat.needsSurgery()){
                    System.out.println(pat.getName() + " requires surgery.");
                    ListIterator <Doctor> docList = Doctor.doctors.listIterator();


                    while(docList.hasNext()){
                        Doctor doc = docList.next();

                        if ((doc.getDepartment().matches(department)) && (doc.canOperate())){
                            System.out.println(ANSI_RED + "Assigned doctor: " + docList.next().getName() + ANSI_RESET);
                            if (!pat.isInpatient()){
                                pat.admitInpatient(department);
                                System.out.println(pat.getName() + " has been admitted.");
                            }
                            pat.haveSurgery(docList.next().getSpeciality());
                            System.out.println(pat.getName() + " has had surgery.");
                        }
                    }
                }
                if(pat.needsMedication()){
                    System.out.println(pat.getName() + " requires medication.");
                    ListIterator <Doctor> docListB = Doctor.doctors.listIterator();


                    while(docListB.hasNext()){
                        Doctor doc = docListB.next();

                        if ((doc.getDepartment().matches(department)) && (doc.canPrescribe())){
                            System.out.println(ANSI_RED + "Assigned doctor: " + docListB.next().getName() + ANSI_RESET);
                            if (!pat.isInpatient()){
                                pat.admitInpatient(department);
                                System.out.println(pat.getName() + " has been admitted.");
                            }
                            pat.prescribeMedication(docListB.next().getSpeciality());
                            System.out.println(pat.getName() + " has been prescribed medication.");
                        }
                        
                    }
                }
            }
            pat.dischargeInpatient();
            System.out.println(pat.getName() + " has been discharged.");
    }
    
    public static void transferPatient(Patient pat){
        String complaintsArray [] = pat.getComplaints();
        String thisComplaint = pat.getDepartment();
        int i = 0;
        if (complaintsArray[i].matches(thisComplaint)){
            pat.transferDepartment(complaintsArray[i+1]);
            System.out.println(pat.getName() + " has been transfer to " + complaintsArray[i+1] + ".");
        }
    }
    
    public static void admitPatient(Patient pat){
        pat.admitInpatient(pat.getDepartment());
    }
    
    
    
}//END OF CLASS
      
    


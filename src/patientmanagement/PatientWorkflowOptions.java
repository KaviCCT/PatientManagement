/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
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
    

  

    private static List <Patient> currentPatientList = new ArrayList<>();
    
    public static Patient currentPatientSearch(){
        System.out.println("Please enter the patients first name:");
        String patFirstName = userInput.next();
        System.out.println("Please enter the patients last name:");
        String patLastName = userInput.next();
        String name = patFirstName + " " + patLastName;
        name = name.toLowerCase();
        for(Patient pat : currentPatientList){
            if (pat.getName().toLowerCase().matches("name")){
                System.out.println("Patient " + pat.getName() + "found.");
                return pat;
            }
            else{
                System.out.println("Not patient by that name.");
            }
        }
        return null;
    }
    public static Patient patientCheck(){
        System.out.println("Is the patient: "
                + "\nA. New patient? "
                + "\nor "
                + "\nB. Existing patient?");
        String choice = userInput.next();
        if (choice.toUpperCase().trim().matches("A")){
            Patient pat = inputPatient();
            return pat;
        }
        else if(choice.toUpperCase().trim().matches("B")){
            if (currentPatientSearch() != null){
               Patient pat = currentPatientSearch(); 
               return pat;
            }
        }   
        else{
            System.out.println("Invalid input. Try again.");
        }
      
        return null;
    }

//    public static Patient inputPatient(){
//        System.out.println("Please enter the patients first name:");
//        String patFirstName = userInput.next();
//        System.out.println("Please enter the patients last name:");
//        String patLastName = userInput.next();
//        System.out.println("Please enter the patients complaints:");
//        String complaintsLine = userInput.next();
//        String name = patFirstName + patLastName;
//        String complaints [];
//        if (complaintsLine.contains(",")){
//            complaints  =  complaintsLine.split(",");
//        }
//        else if(complaintsLine.contains(", ")){
//            complaints  = complaintsLine.split(", ");
//        }
//        else{
//            complaints  = complaintsLine.split(" ");
//        }
//        Patient pat = new Patient(name, complaints);
//        System.out.println("New patient added");
//        return pat;
//    }
    // NOT THE MOST ELEGENT SOLUTION, BUT HEY,  IF IT WORKS.....
//    public static String[] patientComplaints(String complaintsLine){
//        Set <String> complaintsHash = new HashSet <>();
//        

//        if ((complaintsLine.contains("cardiology")) ||(complaintsLine.contains("Cardiology")) || (complaintsLine.contains("CARDIOLOGY"))){
//            complaintsHash.add("Cardiology");
//        }
//        if ((complaintsLine.contains("rheumatology")) ||(complaintsLine.contains("Rheumatology")) || (complaintsLine.contains("RHEUMATOLOGY"))){
//            complaintsHash.add("Rheumatology");
//        }                 
//        if ((complaintsLine.contains("ent")) ||(complaintsLine.contains("Ent")) || (complaintsLine.contains("ENT"))){
//            complaintsHash.add("Cardiology");
//        }                
//        if ((complaintsLine.contains("ophthalmology")) ||(complaintsLine.contains("Ophthalmology")) || (complaintsLine.contains("OPHTHALMOLOGY"))){
//            complaintsHash.add("Ophthalmology");
//        }                
//        if ((complaintsLine.contains("occupational therapy")) ||(complaintsLine.contains("ocupationaltherapy")) ||(complaintsLine.contains("Occupational therapy")) 
//                ||(complaintsLine.contains("occupational Therapy")) ||(complaintsLine.contains("occupationalTherapy")) ||(complaintsLine.contains("Occupationaltherapy")) 
//                ||(complaintsLine.contains("OccupationalTherapy")) ||(complaintsLine.contains("Occupational Therapy")) ||(complaintsLine.contains("OCCUPATIONAL THERAPY")) 
//                || (complaintsLine.contains("OCCUPATIONALTHERAPY"))){
//            complaintsHash.add("Occupational Therapy");
//        }  
//        if ((complaintsLine.contains("radiology")) ||(complaintsLine.contains("Radiology")) || (complaintsLine.contains("RADIOLOGY"))){
//            complaintsHash.add("Radiology");
//        }
//        if ((complaintsLine.contains("oncology")) ||(complaintsLine.contains("Oncology")) || (complaintsLine.contains("ONCOLOGY"))){
//            complaintsHash.add("Oncology");
//        }
//        if ((complaintsLine.contains("ob/gyn")) ||(complaintsLine.contains("obgyn")) ||(complaintsLine.contains("Ob/gyn")) ||(complaintsLine.contains("Ob/Gyn")) 
//                ||(complaintsLine.contains("ob/Gyn")) ||(complaintsLine.contains("OB/GYN")) || (complaintsLine.contains("OBGYN"))){
//            complaintsHash.add("OB/GYN");
//        }
//        if ((complaintsLine.contains("emergency")) ||(complaintsLine.contains("Emergency")) || (complaintsLine.contains("EMERGENCY"))){
//            complaintsHash.add("Emergency");
//        }
//        
//        List <String> complaintsList = new ArrayList<>();
//        for(String complaint : complaintsHash){
//           complaintsList.add(complaint);
//        }
//        int length = complaintsList.size();
//        String complaints [] = new String [length];
//        complaintsList.toArray(complaints);
//        return complaints;
//    }
    
//        public static String[] patientComplaints(String complaintsLine){
//        Set <String> complaintsHash = new HashSet <>();
//        String[] sortComplaints;
//        System.out.println(complaintsLine);
//        if (complaintsLine.contains(", ")){
//            complaintsLine = complaintsLine.replace(", ",","); 
//            System.out.println(complaintsLine);
//        }
//        if (complaintsLine.contains(" ")){
//            complaintsLine = complaintsLine.replace(" ",",");
//            System.out.println(complaintsLine);
//            
//        }
//        if (complaintsLine.contains(" ,")){
//            complaintsLine = complaintsLine.replace(" ,",",");
//            System.out.println(complaintsLine);
//        }
//        if (complaintsLine.contains(".")){
//            complaintsLine = complaintsLine.replace(".",",");
//            System.out.println(complaintsLine);
//        }
//        if (complaintsLine.contains("(?<=[,.])|(?=[,.])|\\s+")){
//            complaintsLine = complaintsLine.replace("(?<=[,.])|(?=[,.])|\\s+",",");
//            System.out.println(complaintsLine);
//        }
//            System.out.println(complaintsLine);
//        sortComplaints = complaintsLine.split(",");
//        
//        System.out.println(Arrays.toString(sortComplaints));
//        
//        for (int i = 0; i < sortComplaints.length; i++){
//        
//        
//            if ((sortComplaints[i].matches("cardiology")) ||(sortComplaints[i].matches("Cardiology")) || (sortComplaints[i].matches("CARDIOLOGY"))){
//                complaintsHash.add("Cardiology");
//            }
//            if ((sortComplaints[i].matches("rheumatology")) ||(sortComplaints[i].matches("Rheumatology")) || (sortComplaints[i].matches("RHEUMATOLOGY"))){
//                complaintsHash.add("Rheumatology");
//            }                 
//            if ((sortComplaints[i].matches("ent")) ||(sortComplaints[i].matches("Ent")) || (sortComplaints[i].matches("ENT"))){
//                complaintsHash.add("Cardiology");
//            }                
//            if ((sortComplaints[i].matches("ophthalmology")) ||(sortComplaints[i].matches("Ophthalmology")) || (sortComplaints[i].matches("OPHTHALMOLOGY"))){
//                complaintsHash.add("Ophthalmology");
//            }                
//            if ((sortComplaints[i].matches("occupational therapy")) ||(sortComplaints[i].matches("ocupationaltherapy")) ||(sortComplaints[i].matches("Occupational therapy")) 
//                    ||(sortComplaints[i].matches("occupational Therapy")) ||(sortComplaints[i].matches("occupationalTherapy")) ||(sortComplaints[i].matches("Occupationaltherapy")) 
//                    ||(sortComplaints[i].matches("OccupationalTherapy")) ||(sortComplaints[i].matches("Occupational Therapy")) ||(sortComplaints[i].matches("OCCUPATIONAL THERAPY")) 
//                    || (sortComplaints[i].matches("OCCUPATIONALTHERAPY"))){
//                complaintsHash.add("Occupational Therapy");
//            }  
//            if ((sortComplaints[i].matches("radiology")) ||(sortComplaints[i].matches("Radiology")) || (sortComplaints[i].matches("RADIOLOGY"))){
//                complaintsHash.add("Radiology");
//            }
//            if ((complaintsLine.matches("oncology")) ||(complaintsLine.matches("Oncology")) || (sortComplaints[i].matches("ONCOLOGY"))){
//                complaintsHash.add("Oncology");
//            }
//            if ((sortComplaints[i].matches("ob/gyn")) ||(sortComplaints[i].matches("obgyn")) ||(sortComplaints[i].matches("Ob/gyn")) ||(sortComplaints[i].matches("Ob/Gyn")) 
//                    ||(sortComplaints[i].matches("ob/Gyn")) ||(sortComplaints[i].matches("OB/GYN")) || (sortComplaints[i].matches("OBGYN"))){
//                complaintsHash.add("OB/GYN");
//            }
//            if ((sortComplaints[i].matches("emergency")) ||(sortComplaints[i].matches("Emergency")) || (sortComplaints[i].matches("EMERGENCY"))){
//                complaintsHash.add("Emergency");
//            }
//        }
//        List <String> complaintsList = new ArrayList<>();
//        for(String complaint : complaintsHash){
//           complaintsList.add(complaint);
//        }
//        int length = complaintsList.size();
//        String complaints [] = new String [length];
//        complaintsList.toArray(complaints);
//        return complaints;
//    }
    

//        public static String[] patientComplaints(){
//            System.out.println("Please enter your first complaint:");
//            String complaintsLine = userInput.next();
//            complaintsLine = complaintsLine + userInput.nextLine();
//            Set <String> complaintsHash = new HashSet <>();
//            
//            System.out.println(complaintsLine);
//        
//        
//            if ((complaintsLine.matches("(.*)cardiology(.*)")) ||(complaintsLine.matches("(.*)Cardiology(.*)")) || (complaintsLine.matches("(.*)CARDIOLOGY(.*)"))){
//                complaintsHash.add("Cardiology");
//                System.out.println(complaintsLine);
//            }
//            if ((complaintsLine.matches("(.*)rheumatology(.*)")) ||(complaintsLine.matches("(.*)Rheumatology(.*)")) || (complaintsLine.matches("(.*)RHEUMATOLOGY(.*)"))){
//                complaintsHash.add("Rheumatology");
//            }                 
//            if ((complaintsLine.matches("(.*)ent(.*)")) ||(complaintsLine.matches("(.*)Ent(.*)")) || (complaintsLine.matches("(.*)ENT(.*)"))){
//                complaintsHash.add("Cardiology");
//            }                
//            if ((complaintsLine.matches("(.*)ophthalmology(.*)")) ||(complaintsLine.matches("(.*)Ophthalmology(.*)")) || (complaintsLine.matches("(.*)OPHTHALMOLOGY(.*)"))){
//                complaintsHash.add("Ophthalmology");
//            }                
//            if ((complaintsLine.matches("(.*)occupational therapy(.*)")) ||(complaintsLine.matches("(.*)ocupationaltherapy(.*)")) ||(complaintsLine.matches("(.*)Occupational therapy(.*)")) 
//                    ||(complaintsLine.matches("(.*)occupational Therapy(.*)")) ||(complaintsLine.matches("(.*)occupationalTherapy(.*)")) ||(complaintsLine.matches("(.*)Occupationaltherapy(.*)")) 
//                    ||(complaintsLine.matches("(.*)OccupationalTherapy(.*)")) ||(complaintsLine.matches("(.*)Occupational Therapy(.*)")) ||(complaintsLine.matches("(.*)OCCUPATIONAL THERAPY(.*)")) 
//                    || (complaintsLine.matches("(.*)OCCUPATIONALTHERAPY(.*)"))){
//                complaintsHash.add("Occupational Therapy");
//            }  
//            if ((complaintsLine.matches("(.*)radiology(.*)")) ||(complaintsLine.matches("(.*)Radiology(.*)")) || (complaintsLine.matches("(.*)RADIOLOGY(.*)"))){
//                complaintsHash.add("Radiology");
//            }
//            if ((complaintsLine.matches("(.*)oncology(.*)")) ||(complaintsLine.matches("(.*)Oncology(.*)")) || (complaintsLine.matches("(.*)ONCOLOGY(.*)"))){
//                complaintsHash.add("Oncology");
//            }
//            if ((complaintsLine.matches("(.*)ob/gyn(.*)")) ||(complaintsLine.matches("(.*)obgyn(.*)")) ||(complaintsLine.matches("(.*)Ob/gyn(.*)")) ||(complaintsLine.matches("(.*)Ob/Gyn(.*)")) 
//                    ||(complaintsLine.matches("(.*)ob/Gyn(.*)")) ||(complaintsLine.matches("(.*)OB/GYN(.*)")) || (complaintsLine.matches("(.*)OBGYN(.*)"))){
//                complaintsHash.add("OB/GYN");
//            }
//            if ((complaintsLine.matches("(.*)emergency(.*)")) ||(complaintsLine.matches("(.*)Emergency(.*)")) || (complaintsLine.matches("(.*)EMERGENCY(.*)"))){
//                complaintsHash.add("Emergency");
//            }
//            System.out.println(complaintsLine);
//            System.out.println(complaintsHash);
//        }
//            
//            if ((complaintsLine.contains("(.*)cardiology(.*)")) ||(complaintsLine.contains("(.*)Cardiology(.*)")) || (complaintsLine.contains("(.*)CARDIOLOGY(.*)"))){
//                complaintsHash.add("Cardiology");
//            }
//            if ((complaintsLine.contains("(.*)rheumatology(.*)")) ||(complaintsLine.contains("(.*)Rheumatology(.*)")) || (complaintsLine.contains("(.*)RHEUMATOLOGY(.*)"))){
//                complaintsHash.add("Rheumatology");
//            }                 
//            if ((complaintsLine.contains("(.*)ent(.*)")) ||(complaintsLine.contains("(.*)Ent(.*)")) || (complaintsLine.contains("(.*)ENT(.*)"))){
//                complaintsHash.add("Cardiology");
//            }                
//            if ((complaintsLine.contains("(.*)ophthalmology(.*)")) ||(complaintsLine.contains("(.*)Ophthalmology(.*)")) || (complaintsLine.contains("(.*)OPHTHALMOLOGY(.*)"))){
//                complaintsHash.add("Ophthalmology");
//            }                
//            if ((complaintsLine.contains("(.*)occupational therapy(.*)")) ||(complaintsLine.contains("(.*)ocupationaltherapy(.*)")) ||(complaintsLine.contains("(.*)Occupational therapy(.*)")) 
//                    ||(complaintsLine.contains("(.*)occupational Therapy(.*)")) ||(complaintsLine.contains("(.*)occupationalTherapy(.*)")) ||(complaintsLine.contains("(.*)Occupationaltherapy(.*)")) 
//                    ||(complaintsLine.contains("(.*)OccupationalTherapy(.*)")) ||(complaintsLine.contains("(.*)Occupational Therapy(.*)")) ||(complaintsLine.contains("(.*)OCCUPATIONAL THERAPY(.*)")) 
//                    || (complaintsLine.contains("(.*)OCCUPATIONALTHERAPY(.*)"))){
//                complaintsHash.add("Occupational Therapy");
//            }  
//            if ((complaintsLine.contains("(.*)radiology(.*)")) ||(complaintsLine.contains("(.*)Radiology(.*)")) || (complaintsLine.contains("(.*)RADIOLOGY(.*)"))){
//                complaintsHash.add("Radiology");
//            }
//            if ((complaintsLine.contains("(.*)oncology(.*)")) ||(complaintsLine.contains("(.*)Oncology(.*)")) || (complaintsLine.contains("(.*)ONCOLOGY(.*)"))){
//                complaintsHash.add("Oncology");
//            }
//            if ((complaintsLine.contains("(.*)ob/gyn(.*)")) ||(complaintsLine.contains("(.*)obgyn(.*)")) ||(complaintsLine.contains("(.*)Ob/gyn(.*)")) ||(complaintsLine.contains("(.*)Ob/Gyn(.*)")) 
//                    ||(complaintsLine.contains("(.*)ob/Gyn(.*)")) ||(complaintsLine.contains("(.*)OB/GYN(.*)")) || (complaintsLine.contains("(.*)OBGYN(.*)"))){
//                complaintsHash.add("OB/GYN");
//            }
//            if ((complaintsLine.contains("(.*)emergency(.*)")) ||(complaintsLine.contains("(.*)Emergency(.*)")) || (complaintsLine.contains("(.*)EMERGENCY(.*)"))){
//                complaintsHash.add("Emergency");
//            }
            
    
    
    public static String[] patientComplaints(){
        System.out.println("Please enter your first complaint:");
        String complaintsLine = userInput.next();
        complaintsLine = complaintsLine + userInput.nextLine();
        Set <String> complaintsHash = new HashSet <>();    
        if ((complaintsLine.matches("(.*)cardiology(.*)")) ||(complaintsLine.matches("(.*)Cardiology(.*)")) || (complaintsLine.matches("(.*)CARDIOLOGY(.*)"))){
            complaintsHash.add("Cardiology");
            System.out.println(complaintsLine);
        }
        if ((complaintsLine.matches("(.*)rheumatology(.*)")) ||(complaintsLine.matches("(.*)Rheumatology(.*)")) || (complaintsLine.matches("(.*)RHEUMATOLOGY(.*)"))){
            complaintsHash.add("Rheumatology");
        }                 
        if ((complaintsLine.matches("(.*)ent(.*)")) ||(complaintsLine.matches("(.*)Ent(.*)")) || (complaintsLine.matches("(.*)ENT(.*)"))){
            complaintsHash.add("Cardiology");
        }                
        if ((complaintsLine.matches("(.*)ophthalmology(.*)")) ||(complaintsLine.matches("(.*)Ophthalmology(.*)")) || (complaintsLine.matches("(.*)OPHTHALMOLOGY(.*)"))){
            complaintsHash.add("Ophthalmology");
        }                
        if ((complaintsLine.matches("(.*)occupational therapy(.*)")) ||(complaintsLine.matches("(.*)ocupationaltherapy(.*)")) ||(complaintsLine.matches("(.*)Occupational therapy(.*)")) 
                ||(complaintsLine.matches("(.*)occupational Therapy(.*)")) ||(complaintsLine.matches("(.*)occupationalTherapy(.*)")) ||(complaintsLine.matches("(.*)Occupationaltherapy(.*)")) 
                ||(complaintsLine.matches("(.*)OccupationalTherapy(.*)")) ||(complaintsLine.matches("(.*)Occupational Therapy(.*)")) ||(complaintsLine.matches("(.*)OCCUPATIONAL THERAPY(.*)")) 
                || (complaintsLine.matches("(.*)OCCUPATIONALTHERAPY(.*)"))){
            complaintsHash.add("Occupational Therapy");
        }  
        if ((complaintsLine.matches("(.*)radiology(.*)")) ||(complaintsLine.matches("(.*)Radiology(.*)")) || (complaintsLine.matches("(.*)RADIOLOGY(.*)"))){
            complaintsHash.add("Radiology");
        }
        if ((complaintsLine.matches("(.*)oncology(.*)")) ||(complaintsLine.matches("(.*)Oncology(.*)")) || (complaintsLine.matches("(.*)ONCOLOGY(.*)"))){
            complaintsHash.add("Oncology");
        }
        if ((complaintsLine.matches("(.*)ob/gyn(.*)")) ||(complaintsLine.matches("(.*)obgyn(.*)")) ||(complaintsLine.matches("(.*)Ob/gyn(.*)")) ||(complaintsLine.matches("(.*)Ob/Gyn(.*)")) 
                ||(complaintsLine.matches("(.*)ob/Gyn(.*)")) ||(complaintsLine.matches("(.*)OB/GYN(.*)")) || (complaintsLine.matches("(.*)OBGYN(.*)"))){
            complaintsHash.add("OB/GYN");
        }
        if ((complaintsLine.matches("(.*)emergency(.*)")) ||(complaintsLine.matches("(.*)Emergency(.*)")) || (complaintsLine.matches("(.*)EMERGENCY(.*)"))){
            complaintsHash.add("Emergency");
        }
            
        List <String> complaintsList = new ArrayList<>();
        for(String complaint : complaintsHash){
           complaintsList.add(complaint);

        }
        int length = complaintsList.size();
        String complaints [] = new String [length];
        complaintsList.toArray(complaints);
        return complaints;
    }
    
//     public static Patient inputPatient(){
//         System.out.println("Please enter the patients first name:");
//        String patFirstName = userInput.next();
//        System.out.println("Please enter the patients last name:");
//        String patLastName = userInput.next();
//        System.out.println("Please enter the patients complaints:");
//        String complaintsLine = userInput.next();
//        String name = patFirstName + " " + patLastName;
//        String complaints [];
//        
//        if (complaintsLine.contains(", ")){
//            complaintsLine.replace(", ",",");
//            complaints = complaintsLine.split(",");
//        }
//        else if (complaintsLine.contains(" ")){
//            complaintsLine.replace(" ",",");
//            complaints = complaintsLine.split(",");
//        }
//        
//        else {
//            complaints  = complaintsLine.split(",");
//        }
//        Patient pat = new Patient(name, complaints);
//        System.out.println("New patient added.");
//        return pat;
//     }
    
     
//    public static Patient inputPatient(){
//
//        System.out.println("Please enter the patients first name:");
//        String patFirstName = userInput.next();
//        System.out.println("Please enter the patients last name:");
//        String patLastName = userInput.next();
//        System.out.println("Please enter the patients complaints:");
//        String complaintsLine = userInput.next();
//        String name = patFirstName + patLastName;
//        String complaints [];
//        if (complaintsLine.contains(",")){
//            complaints  =  complaintsLine.split(",");
//
//        }
//        int length = complaintsList.size();
//        String complaints [] = new String [length];
//        complaintsList.toArray(complaints);
//        return complaints;
//    }
//    
//     public static Patient inputPatient(){
//         System.out.println("Please enter the patients first name:");
//        String patFirstName = userInput.next();
//        System.out.println("Please enter the patients last name:");
//        String patLastName = userInput.next();
//        System.out.println("Please enter the patients complaints:");
//        String complaintsLine = userInput.next();
//        String name = patFirstName + " " + patLastName;
//        String complaints [];
//        
//        if (complaintsLine.contains(", ")){
//            complaintsLine.replace(", ",",");
//            complaints = complaintsLine.split(",");
//        }
//        else if (complaintsLine.contains(" ")){
//            complaintsLine.replace(" ",",");
//            complaints = complaintsLine.split(",");
//        }
//        
//        else {
//            complaints  = complaintsLine.split(",");
//        }
//        Patient pat = new Patient(name, complaints);
//        System.out.println("New patient added.");
//        return pat;
//     }
    
//     
//          public static Patient inputPatient(){
//         System.out.println("Please enter the patients first name:");
//        String patFirstName = userInput.next();
//        System.out.println("Please enter the patients last name:");
//        String patLastName = userInput.next();
//        String name = patFirstName + " " + patLastName;
//
//        String complaintsArray [];
//        if (complaintsLine.contains(" ")){
//            complaintsArray  =  complaintsLine.split(" ");
//        }
//        else {
//            complaintsArray  = complaintsLine.split(",");
//        }
//        Patient pat = new Patient(name, complaintsArray);
//        System.out.println("New patient added");
//
//        
//        
//        
//        
//        String [] complaints = patientComplaints();
//        Patient pat = new Patient(name, complaints);
//        System.out.println(Arrays.toString(complaints));
//        System.out.println("New patient added.");
//        return pat;
//     }
    
        public static Patient inputPatient(){
         System.out.println("Please enter the patients first name:");
        String patFirstName = userInput.next();
        System.out.println("Please enter the patients last name:");
        String patLastName = userInput.next();
        String name = patFirstName + " " + patLastName;
        
        String [] complaints = patientComplaints();
        Patient pat = new Patient(name, complaints);
        System.out.println(Arrays.toString(complaints));
        System.out.println("New patient added.");
        return pat;
     }    
          
          
//    public static void patientWorkflow(){
//        
//        System.out.println("Please enter the patients first name:");
//        String patFirstName = userInput.next();
//        System.out.println("Please enter the patients last name:");
//        String patLastName = userInput.next();
//        System.out.println("Please enter the patients complaints:");
//        String complaintsLine = userInput.next();
//        String name = patFirstName + " " + patLastName;
//        String complaintsArray [];
//        if (complaintsLine.contains(" ")){
//            complaintsArray  =  complaintsLine.split(" ");
//        }
//        else {
//            complaintsArray  = complaintsLine.split(",");
//        }
//        Patient pat = new Patient(name, complaintsArray);
//        System.out.println("New patient added");
//        
//        //for (int i = 0; i < complaintsArray.length; i++){
//            for (String complaintsArray1 : complaintsArray){
//                //String department = complaintsArray[i].trim();
//                String department = complaintsArray1.trim();
//                pat.transferDepartment(department);
//                System.out.println(pat.getName() + " has been transfered to " + pat.getDepartment());
//                if (pat.needsSurgery()){
//                    System.out.println(pat.getName() + " requires surgery.");
//                    
//                    ListIterator <Doctor> docList = Doctor.doctors.listIterator();
//                    while(docList.hasNext()){
//                        Doctor doc = docList.next();
//
//                        if ((doc.getDepartment().matches(department)) && (doc.canOperate())){
//                            System.out.println(ANSI_RED + "Assigned doctor: " + docList.next().getName() + ANSI_RESET);
//                            if (!pat.isInpatient()){
//                                pat.admitInpatient(department);
//                                System.out.println(pat.getName() + " has been admitted.");
//                            }
//                            pat.haveSurgery(docList.next().getSpeciality());
//                            System.out.println(pat.getName() + " has had surgery.");
//                        }
//                    }
//                }
//                if(pat.needsMedication()){
//                    System.out.println(pat.getName() + " requires medication.");
//                    ListIterator <Doctor> docListB = Doctor.doctors.listIterator();
//
//
//                    while(docListB.hasNext()){
//                        Doctor doc = docListB.next();
//
//                        if ((doc.getDepartment().matches(department)) && (doc.canPrescribe())){
//                            System.out.println(ANSI_RED + "Assigned doctor: " + docListB.next().getName() + ANSI_RESET);
//                            if (!pat.isInpatient()){
//                                pat.admitInpatient(department);
//                                System.out.println(pat.getName() + " has been admitted.");
//                            }
//                            pat.prescribeMedication(docListB.next().getSpeciality());
//                            System.out.println(pat.getName() + " has been prescribed medication.");
//                        }
//                        
//                    }
//                }
//            }
//            pat.dischargeInpatient();
//            System.out.println(ANSI_RED + "All complaints have been addressed, " + pat.getName() + " has been discharged." + ANSI_RESET);
//    }
    
    public static void patientWorkflow() throws SQLException{

    Patient pat = PatientWorkflowOptions.inputPatient();
    //Patient pat = new Patient(pat.getName(), pat.getComplaints());
    
     
    
        //for (int i = 0; i < complaintsArray.length; i++){
            for (String complaints1 : pat.getComplaints()){
                //String department = complaintsArray[i].trim();
                String department = complaints1.trim();
                pat.transferDepartment(department);
                System.out.println(pat.getName() + " has been transfered to " + pat.getDepartment() + ".");
                if (pat.needsSurgery()){
                    System.out.println(pat.getName() + " requires surgery.");
                    if(Doctor.getSurgeon(department) != null){
                    Doctor doc = Doctor.getSurgeon(department);
                    //Doctor doc = new Doctor();
                    //doc.getSurgeon(department);
                    System.out.println("Assigned doctor: " + doc.getName());
                    PatientWorkflowOptions.performSurgery(pat, doc);
                    }
                }
                if(pat.needsMedication()){
                    System.out.println(pat.getName() + " requires medication.");
//                    Doctor doc = new Doctor();
//                    doc.getDoc(department);
                    if(Doctor.getDoc(department) != null){
                    Doctor doc = Doctor.getDoc(department);
                    System.out.println("Assigned doctor: " + doc.getName());
                    PatientWorkflowOptions.prescribeMeds(pat,doc);
                    }
                }
            }
        pat.dischargeInpatient();
        System.out.println(ANSI_RED + "All complaints have been addressed, " + pat.getName() + " has been discharged." + ANSI_RESET);
    }
    
  
    
//
//    public static void transferPatient(Patient pat){
//        String complaintsArray [] = pat.getComplaints();
//        String thisComplaint = pat.getDepartment();
//        int i = 0;
//        if (complaintsArray[i].matches(thisComplaint)){
//            pat.transferDepartment(complaintsArray[i+1]);
//            System.out.println(pat.getName() + " has been transfer to " + complaintsArray[i+1] + ".");
//
//        String [] complaints = patientComplaints();
//        Patient pat = new Patient(name, complaints);
//        currentPatientList.add(pat);
//        System.out.println("New patient added.");
//        return pat;
//    }
    
//    public static void patientWorkflow(){
//        
//        System.out.println("Please enter the patients first name:");
//        String patFirstName = userInput.next();
//        System.out.println("Please enter the patients last name:");
//        String patLastName = userInput.next();
//        System.out.println("Please enter the patients complaints:");
//        String complaintsLine = userInput.next();
//        String name = patFirstName + " " + patLastName;
//        String complaintsArray [];
//        if (complaintsLine.contains(" ")){
//            complaintsArray  =  complaintsLine.split(" ");
//        }
//        else {
//            complaintsArray  = complaintsLine.split(",");
//        }
//        Patient pat = new Patient(name, complaintsArray);
//        System.out.println("New patient added");
//        
//        //for (int i = 0; i < complaintsArray.length; i++){
//            for (String complaintsArray1 : complaintsArray){
//                //String department = complaintsArray[i].trim();
//                String department = complaintsArray1.trim();
//                pat.transferDepartment(department);
//                System.out.println(pat.getName() + " has been transfered to " + pat.getDepartment());
//                if (pat.needsSurgery()){
//                    System.out.println(pat.getName() + " requires surgery.");
//                    
//                    ListIterator <Doctor> docList = Doctor.doctors.listIterator();
//                    while(docList.hasNext()){
//                        Doctor doc = docList.next();
//
//                        if ((doc.getDepartment().matches(department)) && (doc.canOperate())){
//                            System.out.println(ANSI_RED + "Assigned doctor: " + docList.next().getName() + ANSI_RESET);
//                            if (!pat.isInpatient()){
//                                pat.admitInpatient(department);
//                                System.out.println(pat.getName() + " has been admitted.");
//                            }
//                            pat.haveSurgery(docList.next().getSpeciality());
//                            System.out.println(pat.getName() + " has had surgery.");
//                        }
//                    }
//                }
//                if(pat.needsMedication()){
//                    System.out.println(pat.getName() + " requires medication.");
//                    ListIterator <Doctor> docListB = Doctor.doctors.listIterator();
//
//
//                    while(docListB.hasNext()){
//                        Doctor doc = docListB.next();
//
//                        if ((doc.getDepartment().matches(department)) && (doc.canPrescribe())){
//                            System.out.println(ANSI_RED + "Assigned doctor: " + docListB.next().getName() + ANSI_RESET);
//                            if (!pat.isInpatient()){
//                                pat.admitInpatient(department);
//                                System.out.println(pat.getName() + " has been admitted.");
//                            }
//                            pat.prescribeMedication(docListB.next().getSpeciality());
//                            System.out.println(pat.getName() + " has been prescribed medication.");
//                        }
//                        
//                    }
//                }
//            }
//            pat.dischargeInpatient();
//            System.out.println(ANSI_RED + "All complaints have been addressed, " + pat.getName() + " has been discharged." + ANSI_RESET);
//    }
    

    

//    public static void transferPatient(){
//        Patient pat = PatientWorkflowOptions.inputPatient();
//        String complaintsArray [] = pat.getComplaints();
//        String thisComplaint = pat.getDepartment();
//        int i = 0;
//        if (complaintsArray[i].matches(thisComplaint)){
//            pat.transferDepartment(complaintsArray[i+1]);
//            System.out.println(pat.getName() + " has been transfer to " + complaintsArray[i+1] + ".");
//        }
//    }

        public static void transferPatient(){
       Patient pat = PatientWorkflowOptions.inputPatient();
       String[] departments = pat.getComplaints();
       pat.transferDepartment(departments[0]);
            System.out.println(pat.getName() + " has been transfered to " + departments[0] + ".");

    }
    
    
    public static void admitPatient(Patient pat) throws SQLException{
        if (!pat.isInpatient()){
            pat.admitInpatient(pat.getDepartment());
            System.out.println(pat.getName() + " has been admitted.");
            DBConnector dbConn = new DBConnector();
            dbConn.addPatient(pat.getName(), pat.getComplaints());
        }
        else{
        System.out.println(pat.getName() + " is already an inpatient.");  
        }
    }
    
    public static void performSurgery(Patient pat, Doctor doc) throws SQLException{
        if (!pat.isInpatient()){
            PatientWorkflowOptions.admitPatient(pat);
            pat.haveSurgery(doc.getSpeciality());
            System.out.println(pat.getName() + " has had surgery.");
            DBConnector dbConn = new DBConnector();
            dbConn.addSurgeryHistory(pat.getName(), pat.getDepartment(), doc.getName());
        }    
        else if(pat.needsSurgery()){
            pat.haveSurgery(doc.getSpeciality());
            System.out.println(pat.getName() + " has had surgery.");
            DBConnector dbConn = new DBConnector();
            dbConn.addSurgeryHistory(pat.getName(), pat.getDepartment(), doc.getName());
        }
    }
    
    public static void performSurgery(String dept) throws SQLException{
        
        if (patientCheck() != null){
            Patient pat = patientCheck();
            if(Doctor.getSurgeon(dept) != null){
                Doctor doc = Doctor.getSurgeon(dept);
                System.out.println("Assigned surgeon: " + doc.getName());
                performSurgery(pat, doc);
            }      
        }
        else{
            System.out.println("No current patient by that name.");
        }
    }
    
    
    public static void prescribeMeds(Patient pat, Doctor doc) throws SQLException{
        if (!pat.isInpatient()){
            PatientWorkflowOptions.admitPatient(pat);
            pat.prescribeMedication(doc.getSpeciality());
            System.out.println(pat.getName() + " has been prescribed medication.");
            DBConnector dbConn = new DBConnector();
            dbConn.addMedicationHistory(pat.getName(), pat.getDepartment(), doc.getName());
        }    
        else if (pat.needsMedication()){
            pat.prescribeMedication(doc.getSpeciality());
            DBConnector dbConn = new DBConnector();
            dbConn.addMedicationHistory(pat.getName(), pat.getDepartment(), doc.getName());
        }
        else{
            System.out.println(pat.getName() + " does not require medication!");
        }
    }
    
    public static void prescribeMeds(String dept) throws SQLException{
        if (patientCheck() != null){
            Patient pat = patientCheck();
            if(Doctor.getDoc(dept) != null){
                Doctor doc = Doctor.getDoc(dept);
                System.out.println("Assigned doctor: " + doc.getName());
                prescribeMeds(pat,doc);
            }      
        }
        else{
            System.out.println("No current patient by that name.");
        }
    }
    
    
    public static void dischargePatient(){
        if (patientCheck() != null){
            Patient pat = patientCheck();
            if (!pat.isInpatient()){
                pat.dischargeInpatient();
                System.out.println(pat.getName() + " has been discharged.");
            }
            else{
                System.out.println(pat.getName() + " is not an Inpatient.");
            }
        }
        else{
            System.out.println("No current patient by that name.");
        }
    }
    
//    public static void performSurgery(Patient pat, Doctor doc) throws SQLException{
//        if (!pat.isInpatient()){
//            PatientWorkflowOptions.admitPatient(pat);
//            pat.haveSurgery(doc.getSpeciality());
//            System.out.println(pat.getName() + " has had surgery.");
//        }    
//        else if(pat.needsSurgery()){
//            pat.haveSurgery(doc.getSpeciality());
//            System.out.println(pat.getName() + " has had surgery.");
//        }
//    }
//    
//    public static void prescribeMeds(Patient pat, Doctor doc) throws SQLException{
//        if (!pat.isInpatient()){
//            PatientWorkflowOptions.admitPatient(pat);
//            pat.prescribeMedication(doc.getSpeciality());
//            System.out.println(pat.getName() + " has been prescribed medication.");
//        }    
//        else if (pat.needsMedication()){
//            pat.prescribeMedication(doc.getSpeciality());
//        }
//        else{
//            pat.prescribeMedication(doc.getSpeciality());
//        }
//    }
    public static void dischargePatient(Patient pat){
        if (!pat.isInpatient()){
            pat.dischargeInpatient();
            System.out.println(pat.getName() + " has been discharged.");
        }
        else{
            System.out.println(pat.getName() + " is not an Inpatient.");
        }
    }
    
    public static void searchPatient() throws SQLException{
        System.out.println("Would you like to search by: "
                + "\nA. Name "
                + "\nor "
                + "\nB. ID?");
        String searchType = userInput.next();
        if (searchType.toUpperCase().matches("A")){
            System.out.println("What is the patients first name?");
            String fName = userInput.next();
            System.out.println("What is the patients last name?");
            String lName = userInput.next();
            String patName = fName + " " + lName;
            DBConnector dbConn = new DBConnector();
            System.out.println(dbConn.getPatient(patName));
           
        }
        else if(searchType.toUpperCase().matches("B")){
            System.out.println("What is the patients ID?");
            String patID = userInput.next();
            DBConnector dbConn = new DBConnector();
            System.out.println(dbConn.getPatient(Integer.parseInt(patID)));
        }   
        else{
            System.out.println("Invalid input. Try again.");
        }
      
    }
    
        public static String searchPatientForDischarge() throws SQLException{
        System.out.println("Would you like to search by: "
                + "/nA. Name "
                + "/nor "
                + "/nB. ID?");
        String searchType = userInput.next();
        if (searchType.matches("A")){
            System.out.println("What is the patients name?");
            String patName = userInput.next();
            DBConnector dbConn = new DBConnector();
            dbConn.getPatient(patName);
            return patName;
        }
        else if(searchType.matches("B")){
            System.out.println("What is the patients ID?");
            String patID = userInput.next();
            DBConnector dbConn = new DBConnector();
            dbConn.getPatient(Integer.parseInt(patID));
            return patID;
        }   
        else{
            System.out.println("Invalid input. Try again.");
        }
        return null;
    }
}//END OF CLASS
      
    


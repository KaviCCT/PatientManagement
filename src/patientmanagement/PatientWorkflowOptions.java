/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import static patientmanagement.Login.userInput;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */

// PATIENT WORKFLOW CLASS INSPIRED BY THE patient workflow PROCESS IN THE BRIEF
// METHODS DEVELOPED BASED ON USER MENU OPTIONS FOR WORKING PROTOTYPE
public class PatientWorkflowOptions {
    
    //Dcelaring ANSI_RESET so we can reset the colour
    public static final String ANSI_RESET = "\u001B[30m";
    //Dcelaring ANSI colours for console message use
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    

    // ARRAY LIST TO STORED NEW PATIENT OBJECTS
    // ARRAY LIST AS SIZE IS EXPANDLE/ LENGTH IS VARIABLE
    private static List <Patient> currentPatientList = new ArrayList<>();
    
    // METHOD TO SEARCH currentPatientList FOR MATCHING PATIENTS DEVELOPED TO ATTEMPT 

    public static Patient currentPatientSearch(){
        System.out.println(ANSI_RED + "Please enter the patients first name:" + ANSI_RESET);
        String patFirstName = userInput.next();
        System.out.println(ANSI_RED + "Please enter the patients last name:" + ANSI_RESET);
        String patLastName = userInput.next();
        String name = patFirstName + " " + patLastName;
        String searchName = name.toLowerCase(); // toLowerCase METHOD USED TO AVOID CAPITAL LETTER MISMATCH
        for(Patient pat : currentPatientList){
            if (pat.getName().toLowerCase().matches(searchName)){
                System.out.println(ANSI_GREEN + "\nYes, " + pat.getName() + " is a current patient." + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Patient details: " + pat.toString());
                return pat; // LOCATED PATIENT RETURNED 
            }
            else{
                System.out.println(ANSI_RED + "\nNo patient by that name found. Please check your spelling and try again." + ANSI_RESET);
            }
        }
        return null; // IF NO PATIENT IS FOUND
    }
    
    // METHOD TO BE CALLED WITH currentPatientSearch METHOD ABOVE
    // TO AVOID DUPLICATE ENTRIES AND ALLOW USEERS THE CHOICE OF PERFORMING NENU OPTIONS ON
    // NEW OR EXISTING PATIENTS 
    public static Patient patientCheck(){
        System.out.println( ANSI_RED + "\nIs the patient: " + ANSI_RESET
                        + "\nA. New patient? "
                        + "\nor " 
                        + "\nB. Existing patient?");
        String choice = userInput.next();
        if (choice.toUpperCase().trim().matches("A")){
            Patient pat = inputPatient();
            return pat;
        }
        else if(choice.toUpperCase().trim().matches("B")){
//            if (currentPatientSearch() != null){
//               Patient pat = currentPatientSearch(); 
//               return pat;
//            }
            Patient pat = currentPatientSearch(); 
            return pat;
        }   
        else{
            System.out.println(ANSI_RED + "Invalid input. Try again." + ANSI_RESET);
        }
        return null;
    }
    
    // METHOD TO ACEPT AND PROCESS PATIENT COMPLAINTS ON ENTRY
    // AN ARRAY OF STRINGS complaints IS RETURNED AFTER VALIDATION
    public static String[] patientComplaints(){
        System.out.println(ANSI_RED + "Please enter your complaints:" + ANSI_RESET);
        String complaintsLine = userInput.next(); // ALL COMPLAINTS STORED IN String complaintsLine 
        complaintsLine = complaintsLine + userInput.nextLine(); // THIS TWO STEP INPUT SOLVE MY nextLine PARSING ISSUES
        // DECLARING A HashSet complaintsHash AND SETTING IT TO THE RETURN HashSET OF A ValidateComplaints complaintsSet METHOD
        // Hashset SELECTED BECAUSE IT DOES NOT ALLOW DUPLICATION
        Set <String> complaintsHash = ValidateComplaints.complaintsSet(complaintsLine); 
        // DECLARING A NEW ARRAYLIST complaitList  AND ADDING EACH ELEMENT FROM complaintHash TO IT
        // SO THAT WE CAN CALCULATE ITS SIZE TO SET OUR PATIENT complaints ARRAY
        List <String> complaintsList = new ArrayList<>();
        for(String complaint : complaintsHash){
           complaintsList.add(complaint);
        }
        int length = complaintsList.size();
        String complaints [] = new String [length];
        // SETTING AND ADDING ALL COMPLAINTS TO complaints AND RETURNING IT
        complaintsList.toArray(complaints);
        return complaints;
    }
    
    // METHOD FOR PROCESSING EACH NEW PATIENT OBJECT
    public static Patient inputPatient(){
       System.out.println(ANSI_RED + "Please enter the patients first name:" + ANSI_RESET);
       String patFirstName = userInput.next();
       System.out.println(ANSI_RED + "Please enter the patients last name:" + ANSI_RESET);
       String patLastName = userInput.next();
       String name = patFirstName + " " + patLastName;
       String goodName = "";
       // VALIDATING USER NAME THROUGH NameValidator CLASS AND validateNAME METHOD AND ASSIGNING THE RESULT TO String goodName
       if(NameValidator.validateName(name)){
           goodName= name;
       }
       String [] complaints = patientComplaints();// DECALRING AND SETTING complaints ARRAY TO THE RESULT FOLLOWING VALIDATION
       Patient pat = new Patient(goodName, complaints);
       currentPatientList.add(pat); // ADDING EACH NEW PATIENT TO currentPatientList TO TRACK THEM THROUGH THE SYSTEM
       System.out.println(ANSI_GREEN + "\nNew patient " + pat.getName() + " added with the following complaints: " + Arrays.toString(complaints) + ANSI_RESET);
       return pat; // RETURNING THE NEW PATIENT OBJECT
     }
    
    // METHOD TO AUTOMATICALLY PROGRESS A PATIENT OBJECT THROUGH THE patient workflow AS SPECIFIED IN THE ASSIGNEMNET BRIEF
    public static void patientWorkflow() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        // UTILISING MULTIPLE METHODS TO REDUCE REPETITIVE CODING
        Patient pat = PatientWorkflowOptions.inputPatient(); // NEW PATIENT OBJECT CREATED THROUGH inputPatient() METHOD
        for (String complaints1 : pat.getComplaints()){ // ITERATING/LOOPING THROUGH EACH COMPLAINT
            String department = complaints1.trim();
            pat.transferDepartment(department); // UTILISING PatientInteface AND transferDepartment() METHOD TO ALLOCATE DEPARTMENT AND TRANSFER PATIENT
            System.out.println(ANSI_CYAN + pat.getName() + " has been transfered to " + pat.getDepartment() + "." + ANSI_RESET); // HELPFUL MESSAGES PRINTED TO CONSOLE ON PATIENT PROGRESS
            // CONDITIONAL STATEMENTS USED TO PROGRESS PATIENT BASED ON METHOD RETURNS
            if (pat.needsSurgery()){ // PatientInterface needsSurgery METHOD CALLED TO DETERMINE IF PATIENT NEEDS SURGERY
                System.out.println(ANSI_CYAN + pat.getName() + " requires surgery." + ANSI_RESET);
                if(Doctor.getSurgeon(department) != null){ // IF STATEMENT IN THE CASE THAT AN APPROPRIATE SURGEON IS RETURNED FROM A getSurgeon METHOD IN Doctor CLASS
                    Doctor doc = Doctor.getSurgeon(department);//INSTANTIATING AND ALLOCATING A NEW DOCTOR OBJECT TO THE RETURN VALIDATED DOCTOR
                    System.out.println(ANSI_CYAN + "Assigned doctor: " + doc.getName() + ANSI_RESET);
                    // A PATIENT MUST BE ADMITTED BEFORE SURGERY OR MEDICATION 
                    // THIS IS CONDUCTED WITHIN THE peformSurgery METHOD
                    PatientWorkflowOptions.performSurgery(pat, doc); // performSurgery METHOD CALLED FROM PatientWorkFlowOptions CLASS
                }
            }// SAME PROCESS AS ABOVE BUT CHECKING IF PATIENT OBJECT NEED MEDICATION VIA PatientInterface METHOD needsMedication
            if(pat.needsMedication()){
                System.out.println(ANSI_CYAN + pat.getName() + " requires medication." + ANSI_RESET);
                if(Doctor.getDoc(department) != null){
                    Doctor doc = Doctor.getDoc(department); // APPROPRIATE DOCTOR OBJECT IS RETURNED FROM A getDoc METHOD IN Doctor CLASS
                    System.out.println(ANSI_CYAN + "Assigned doctor: " + doc.getName() + ANSI_RESET);
                    prescribeMeds(pat,doc); // METHOD prescribeMeds() WHICH TAKES THE PATIENT AND DOCTOR OBJECT AS PARAMETER CALLED
                }
            }
        }
        pat.dischargeInpatient();// ONCE ALL COMPLAINTS HAVE BEEN ADDRESSED THE PATIENT IS DISCHARGED WITH PatientInterface dischargeInpatient()
        System.out.println(ANSI_RED + "All complaints have been addressed, " + pat.getName() + " has been discharged." + ANSI_RESET);
    }
    
    // METHOD TO TRANSFER PATIENT 
    // USER GIVEN THE CHOICE OF NEW OR EXISTING PATIENT VIA patientCheck METHOD
    public static void transferPatient(){
        Patient pat = patientCheck();
        if(pat !=null){
            String[] departments = pat.getComplaints();
            pat.transferDepartment(departments[0]); // PATIENT TRANSFER TO FIRST COMPLAINT/DEPARTMENT 
            System.out.println(ANSI_GREEN + pat.getName() + " has been transfered to " + departments[0] + "." + ANSI_RESET);
        }
        else{
            System.out.println(ANSI_RED + "Patient not found." + ANSI_RESET);
        }
    }
    
    // METHOD TO ADMIT A PATIENT AS AN INPATIENT
    // PATIENT OBJECT TAKEN AS A PARAMETER
    public static void admitPatient(Patient pat) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        if (!pat.isInpatient()){
            pat.admitInpatient(pat.getDepartment());
            System.out.println(ANSI_GREEN + pat.getName() + " has been admitted." + ANSI_RESET);
//            DBConnector dbConn = new DBConnector();
//            dbConn.addPatient(pat.getName(), pat.getComplaints());
            DatabaseWriter.addPatient(pat.getName(), pat.getComplaints());// STORING  INPATIENT DATA TO DATABASE VIA DatabaseWriter CLASS
        }
        else{
        System.out.println(ANSI_RED +pat.getName() + " is already an inpatient." + ANSI_RESET);  
        }
    }
    // METHOD FOR VALIDATING PATIENT OBJECT BEFORE SURGERY
    // PATIENT AND DOCTOR OBJECTS PASSED AS ARGUMENTS
    public static void performSurgery(Patient pat, Doctor doc) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        // PATIENT MUST BE AN INPATIENT BE SURGERY CAN BE PERFORMED
        if (!pat.isInpatient()){
            PatientWorkflowOptions.admitPatient(pat);
            pat.haveSurgery(doc.getSpeciality());
            System.out.println(ANSI_GREEN + pat.getName() + " has had surgery." + ANSI_RESET);
//            DBConnector dbConn = new DBConnector();
//            dbConn.addSurgeryHistory(pat.getName(), pat.getDepartment(), doc.getName());

            DatabaseWriter.addSurgeryHistory(pat.getName(),  pat.getDepartment(),doc.getName());// STORING  SURGERY RECORD  TO DATABASE
        }  
        else if(pat.isInpatient()){ // IF PATIENT IS ALREADY AN INPATIENT
            pat.haveSurgery(doc.getSpeciality());
            System.out.println(ANSI_GREEN + pat.getName() + " has had surgery." + ANSI_RESET);
//            DBConnector dbConn = new DBConnector();
//            dbConn.addSurgeryHistory(pat.getName(), pat.getDepartment(), doc.getName());
            DatabaseWriter.addSurgeryHistory(pat.getName(),  pat.getDepartment(),doc.getName());
        }
        else if(pat.needsSurgery()){// IF PATIENT NEEDS SURGERY
            pat.haveSurgery(doc.getSpeciality());
            System.out.println(ANSI_GREEN + pat.getName() + " has had surgery." + ANSI_RESET);
//            DBConnector dbConn = new DBConnector();
//            dbConn.addSurgeryHistory(pat.getName(), pat.getDepartment(), doc.getName());
            DatabaseWriter.addSurgeryHistory(pat.getName(),  pat.getDepartment(),doc.getName());
        }
    }
    
    // METHOD TO PERFORM SURGERY TAKING THE DEPARTMENT NAME AS A STRING PARAMETER
    public static void performSurgery(String dept) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{ 
        Patient pat = patientCheck();
        if(Doctor.getSurgeon(dept) != null){
            Doctor doc = Doctor.getSurgeon(dept); // AN APPROPRIATE SURGEON IS RETURNED 
            System.out.println(ANSI_CYAN + "Assigned surgeon: " + doc.getName() + ANSI_RESET);
            performSurgery(pat, doc);
        }      
    }
    
    // SAME AS ABOVE
    // METHOD FOR VALIDATING A PATIENT BEFORE PRESCRIBING MEICATION
    // PATIENT CHECKED FOR INPATIENT AND NEEDS MEDICTAION BEFORE PRESCRIBING MEDICATION
    // MEDICCATION HISTORY DATA STORED IN AN APPRORIATE TABLE WITHIN OUR DATABASE
    public static void prescribeMeds(Patient pat, Doctor doc) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        if (!pat.isInpatient()){
            PatientWorkflowOptions.admitPatient(pat);
            pat.prescribeMedication(doc.getSpeciality());
            System.out.println(ANSI_GREEN + pat.getName() + " has been prescribed medication." + ANSI_RESET);
//            DBConnector dbConn = new DBConnector();
//            dbConn.addMedicationHistory(pat.getName(), pat.getDepartment(), doc.getName());
           DatabaseWriter.addMedicationHistory(pat.getName(),  pat.getDepartment(), doc.getName());
        } 
        else if (pat.isInpatient()){
            pat.prescribeMedication(doc.getSpeciality());
//            DBConnector dbConn = new DBConnector();
//            dbConn.addMedicationHistory(pat.getName(), pat.getDepartment(), doc.getName());
            DatabaseWriter.addMedicationHistory(pat.getName(),  pat.getDepartment(), doc.getName());
        }
        else if (pat.needsMedication()){
            pat.prescribeMedication(doc.getSpeciality());
//            DBConnector dbConn = new DBConnector();
//            dbConn.addMedicationHistory(pat.getName(), pat.getDepartment(), doc.getName());
            DatabaseWriter.addMedicationHistory(pat.getName(),  pat.getDepartment(), doc.getName());
        }
        else{
            System.out.println(ANSI_RED + pat.getName() + " does not require medication!" + ANSI_RESET);
        }
    }
    
    // METHOD TO PRESCRIBE MEDICATION TAKING THE DEPARTMENT NAME AS A STRING PARAMETER
    // FOR USE IN INTERFACE MENU
    public static void prescribeMeds(String dept) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Patient pat = patientCheck();
        if(Doctor.getDoc(dept) != null){
            Doctor doc = Doctor.getDoc(dept);
            System.out.println(ANSI_CYAN + "Assigned doctor: " + doc.getName() + ANSI_RESET);
            prescribeMeds(pat,doc);
        }
    }
    
    // METHOD TO DISCHARGE A PATIENT
    // OPTION FOR USER TO SEARCH FOR EXISTING PATIENT
    // CONDITIONAL STATEMENT FOR PATIENT NOT FOUND OR NOT AN INPATIENT
    public static void dischargePatient(){
        if (patientCheck() != null){
            Patient pat = patientCheck();
            if (!pat.isInpatient()){
                pat.dischargeInpatient();
                System.out.println(ANSI_RED + pat.getName() + " has been discharged." + ANSI_RESET);
            }
            else{
                System.out.println(ANSI_RED + pat.getName() + " is not an Inpatient." + ANSI_RESET);
            }
        }
        else{
            System.out.println(ANSI_RED + "No current patient by that name." + ANSI_RESET);
        }
    }
    
      // METHOD TO DISCHARGE A PATIENT TAKING THE PATIENT OBJECT AS A PARAMETER
    public static void dischargePatient(Patient pat){
        if (!pat.isInpatient()){
            pat.dischargeInpatient();
            System.out.println(ANSI_RED + pat.getName() + " has been discharged." + ANSI_RESET);
        }
        else{
            System.out.println(ANSI_RED + pat.getName() + " is not an Inpatient." + ANSI_RESET);
        }
    }
    
    // METHOD TO SEARCH THE PATIENT DATABASE BY NAME OR PATIENTID
    public static void searchPatient() throws SQLException{
        System.out.println("Would you like to search by: "
                + "\nA. Name "
                + "\nor "
                + "\nB. ID?");
        String searchType = userInput.next();
        if (searchType.toUpperCase().matches("A")){
            System.out.println(ANSI_RED + "What is the patients first name?" + ANSI_RESET);
            String fName = userInput.next();
            System.out.println(ANSI_RED + "What is the patients last name?" + ANSI_RESET);
            String lName = userInput.next();
            String patName = fName + " " + lName;
//            DBConnector dbConn = new DBConnector();
//            System.out.println(ANSI_GREEN + dbConn.getPatient(patName) + ANSI_RESET);
           DatabaseReader.getPatient(patName);// ACCESSING THE DATABASE THROUGH DatabaseReader CLASS
        }
        else if(searchType.toUpperCase().matches("B")){
            System.out.println(ANSI_RED + "What is the patients ID?" + ANSI_RESET);
            String patID = userInput.next();
//            DBConnector dbConn = new DBConnector();
//            System.out.println(ANSI_GREEN + dbConn.getPatient(Integer.parseInt(patID)) + ANSI_RESET);
            DatabaseReader.getPatient(patID);
        }   
        else{
            System.out.println(ANSI_RED + "Invalid input. Try again." + ANSI_RESET);
        }
      
    }
    
} //END OF CLASS
    

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;


import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */

// DOCTOR CLASS ORIGINALLY INTENDED AS CHANGED DURING DEVELOPMENT
public class Doctor {
    
    //Dcelaring ANSI_RESET so we can reset the colour
    public static final String ANSI_RESET = "\u001B[30m";
    //Dcelaring ANSI colours for console message use
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    

    // DOCTOR INSTANCE FIELDS THAT ALL CHILD CLASS WILL INHERET
    // THYE WILL BE SET ACCORDINGLY WITHIN EACH CHILD CLASS
    
    protected String name;
    protected String department;
    protected String speciality;
    protected boolean surgeon;
    protected boolean onDuty;
    protected boolean canPrescribe;
    protected boolean canAdmit;
    protected boolean canDischarge;
    protected boolean canTransfer;
    // ARRAYLIST TO STORED DOCTOR OBJECTS CREATED BASED ON CSV FILE INPUT
    public static ArrayList <Doctor> doctors = new ArrayList <>();
    // DEFAULT DOCTOR CONSTRUCTOR
    public Doctor() {
    }
    // OVERLOAD DOCTOR CONSTRUCTORE
    public Doctor(String name, String department, String speciality, boolean surgeon, boolean onDuty, boolean canPrescribe, boolean canAdmit, boolean canDischarge, boolean canTransfer) {
        this.name = name;
        this.department = department;
        this.speciality = speciality;
        this.surgeon = surgeon;
        this.onDuty = onDuty;
        this.canPrescribe = canPrescribe;
        this.canAdmit = canAdmit;
        this.canDischarge = canDischarge;
        this.canTransfer = canTransfer;
    }
  
    // A METHOD TO SORT THROUGH THE DOCTOR ARRAYLIST 
    // FILTER EACH DOCTOR OBJECT BASED ON MATCHING THE REQUUIRED DEPARTMENT AND CAN PERFORM SURGERY
    // AN APPROPRIATE DOCTOR OBJECT IS RETURNED
    // THE CURRENT DPARTMENT IS PARSED AS A STRING ARGUMENT
    public static Doctor getSurgeon (String department){
        ListIterator <Doctor> docList = Doctor.doctors.listIterator();// LIST ITERATOR TO IETERATE THROUGH THE LIST
        while(docList.hasNext()){
            Doctor doc = docList.next();// THE CURRENT OBJECT IS STORED IN INSTANCE doc AND VALIDATED
            if ((doc.getDepartment().matches(department)) && (doc.canOperate())){// ON DUTY IS DETERMINED IN canOPERATE METHOD
                return doc;
            }// A DOCTOR WHO PASSES THE CONDITIONS IS RETURNED
        }
        return null; // REQUIRED NULL RETURN ACCOUNTED FOR ON CALLIN END
    }
    
    // SAME AS ABOVE
    // AMETHOD TO FILTER THROUGH docList AND RETURN A DOCTOR WHO MATCHES THE PASSED DEPARTMENT AND CAN PRESCRIBE MEDICATION
    // ON DUTY IS CHECKED IN canPrescribe METHOD
    public static Doctor getDoc (String department){
        ListIterator <Doctor> docList = Doctor.doctors.listIterator();
        while(docList.hasNext()){
            Doctor doc = docList.next();
            if ((doc.getDepartment().matches(department)) && (doc.canPrescribe())){              
               return doc;
            }
        }
        return null;
    }
    
    // A METHOD TO RETURN A BOOLEAN VALUE ACCORDING TO BOOLEANS surgeon AND onDuty
    // BOTH VARIABLES MUST BE TRUE OR THE RETURN WILL BE FALSE
    public boolean canOperate() {
        return surgeon && onDuty;
    }
    // SAME AS ABOVE BUT CHECKING FOR canPrescribe AND onDuty BOOLEAN VALUES
    // BITH MUST BE TRUE OR false IS RETURNED PER
     public boolean canPrescribe() {
        return canPrescribe && onDuty;
    }

     
    // ALL GETTERS AND SETTERS SET FOR FUTURE DEVELOPERS EASE OF USE
    protected String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getSpeciality() {
        return speciality;
    }

    public boolean isSurgeon() {
        return surgeon;
    }

    public boolean isOnDuty() {
        return onDuty;
    }

    public boolean isCanPrescribe() {
        return canPrescribe;
    }

    public boolean isCanAdmit() {
        return canAdmit;
    }

    public boolean isCanDischarge() {
        return canDischarge;
    }

    public boolean isCanTransfer() {
        return canTransfer;
    }

    public static ArrayList<Doctor> getDoctors() {
        return doctors;
    }
    
    
}

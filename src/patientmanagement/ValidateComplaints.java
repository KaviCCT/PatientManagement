/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */

// CLASS TO VALIDATE THE STRING OF PATIENT COMPLAINTS
public class ValidateComplaints {
    
    // METHOD TO VALIDATE THE STRING OF PATIENT COMPLAINTS
    // THE STRING IS PASSED AS AN PARAMETER AND A HASHSET IS RETURN
    public static Set complaintsSet(String complaintsLine){
        
        // DECLARING NEW HASHSET TO STORED PATIENT COMPLAINTS
        // HASHSET USED AS IT DOES NOT STORED DUPLICATES
        Set <String> complaintsHash = new HashSet <>();    
        // NOT THE MOST ELEGENT SOLUTION BUT IT WILL DO FOR A FIRST PROTOTYPE
        // A LIMITED AMOUNT OF POSSIBLE INPUTS  MEANT TO MATCH OUR COMPLAINTS/DEPARTMENTS ARE SPECIFIED
        // IF A MATCH IS FOUND WITHIN THE complaintsLine String, IT IS ADDED TO THE HASHSET
        if ((complaintsLine.matches("(.*)cardiology(.*)")) ||(complaintsLine.matches("(.*)Cardiology(.*)")) || (complaintsLine.matches("(.*)CARDIOLOGY(.*)"))){
            complaintsHash.add("Cardiology");
        }
        if ((complaintsLine.matches("(.*)rheumatology(.*)")) ||(complaintsLine.matches("(.*)Rheumatology(.*)")) || (complaintsLine.matches("(.*)RHEUMATOLOGY(.*)"))){
            complaintsHash.add("Rheumatology");
        }                 
        if ((complaintsLine.matches("(.*)ent(.*)")) ||(complaintsLine.matches("(.*)Ent(.*)")) || (complaintsLine.matches("(.*)ENT(.*)"))){
            complaintsHash.add("ENT");
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
                ||(complaintsLine.matches("(.*)ob/Gyn(.*)"))||(complaintsLine.matches("(.*)ObGyn(.*)")) ||(complaintsLine.matches("(.*)OB/GYN(.*)")) || (complaintsLine.matches("(.*)OBGYN(.*)"))){
            complaintsHash.add("OB/GYN");
        }
        if ((complaintsLine.matches("(.*)emergency(.*)")) ||(complaintsLine.matches("(.*)Emergency(.*)")) || (complaintsLine.matches("(.*)EMERGENCY(.*)"))){
            complaintsHash.add("Emergency");
        }
        return complaintsHash; // THE HASHSET OF VALIDATED COMPLAINTS IS RETURNED
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.List;

/**
 *
 * @author Akshay Reddy Vontari
 */
public interface Hospital {
    static final double BASE_CONSULTATION_FEE=20.0;
    static final double EMERGENCY_FEE=30.0;
    
    double calcBill(String billingDetails);
    void assignDocToPatient(List<Doctor> doctorList) throws SpecialistNotFoundException;
    
}

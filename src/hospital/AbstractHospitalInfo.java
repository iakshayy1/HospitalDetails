/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Akshay Reddy Vontari
 */
public abstract class AbstractHospitalInfo extends Patient implements Hospital{
    private List<Doctor> availableDoctorsList;
    private List<String> doctorsMappedToPatients;
    private String hospitalAddress;
    private String hospitalName;

    public AbstractHospitalInfo() {
        this.availableDoctorsList=new ArrayList<>();
        this.doctorsMappedToPatients= new ArrayList<>();
    }

    public AbstractHospitalInfo(String hospitalAddress, String hospitalName, String fName, String lName, int insuranceID, int age, char gender, Date lastCheckUpDate, boolean lastCheckUpStatus, String lastDoctorVisited) {
        super(fName, lName, insuranceID, age, gender, lastCheckUpDate, lastCheckUpStatus, lastDoctorVisited);
        this.hospitalAddress = hospitalAddress;
        this.hospitalName = hospitalName;
    }

    public List<Doctor> getAvailableDoctorsList() {
        return availableDoctorsList;
    }

    public List<String> getDoctorsMappedToPatients() {
        return doctorsMappedToPatients;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public static double getBASE_CONSULTATION_FEE() {
        return BASE_CONSULTATION_FEE;
    }

    public static double getEMERGENCY_FEE() {
        return EMERGENCY_FEE;
    }
    
    public List<Doctor> addDoctors(Doctor doctor) throws InvalidDoctorSizeException{
        if(availableDoctorsList.size()<0){
            throw new InvalidDoctorSizeException("Invalid doctor size exception");
        }
        availableDoctorsList.add(doctor);
        return availableDoctorsList;
        
    }
    
    public abstract void assignDocToPatient(List<Doctor> doctorList) throws SpecialistNotFoundException;
    public abstract double calcBill(String billingDetails);
    
    
    
    
    
    
}

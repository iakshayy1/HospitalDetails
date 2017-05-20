/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Akshay Reddy Vontari
 */
public class MaternityWard extends AbstractHospitalInfo{
    private boolean appointmentStatus;

    public MaternityWard( String hospitalName, String hospitalAddress, String fName, String lName, int insuranceID, int age, char gender, Date lastCheckUpDate, boolean lastCheckUpStatus, String lastDoctorVisited) {
        super(hospitalName,hospitalAddress,fName, lName, insuranceID, age, gender, lastCheckUpDate, lastCheckUpStatus, lastDoctorVisited);
        this.appointmentStatus = false;
    }
    
    public void assignDocToPatient(List<Doctor> doctorList)throws SpecialistNotFoundException{
        if(doctorList != null){
        for (Doctor u : doctorList) {
            if(appointmentStatus==true&&u.getSpecialityType().equalsIgnoreCase("Gynaecologist")){
                appointmentStatus=true;
                String doctor = u.getName();
                String patientName= getfName()+getlName();
                getDoctorsMappedToPatients().add(doctor+":"+patientName);
                doctorList.remove(doctor);
                
                
            }
            else
            {
                throw new SpecialistNotFoundException("There is no available doctors in the list who are child specialist ");
            }
        }
        
    }
    }
    
    
    public double calcBill(String billingDetails){
        double bill=0;
        String[] items = billingDetails.split(",");
        for(String f : items){
            if(f != null){
            switch(f){
                case "group B streptococcus":
                    bill=bill+18.75;
                    break;
                case "respiratory syncytial virus":
                    bill=bill+21.29;
                    break;
                case "influenza":
                    bill=bill+18.98;
                    break;
                case "pertussis":
                    bill=bill+17.5;
                    break;
                default:
                    bill=bill+EMERGENCY_FEE;
                    break;
                    
            }
        }
        
        
    }
        return bill+BASE_CONSULTATION_FEE;
    
    
    
    
    
}

    @Override
    public String toString() {
        return super.toString()+ "\nStatus=" + appointmentStatus;
    }
    
}

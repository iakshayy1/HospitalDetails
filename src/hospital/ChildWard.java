/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Akshay Reddy Vontari
 */
public class ChildWard extends AbstractHospitalInfo{
    private boolean appointmentStatus;

    public ChildWard() {
    }

    ChildWard(String hospitalName,String hospitalAddress,String fName,String lName, int insuranceID, int age, char gender, java.util.Date lastCheckUpDate, boolean lastCheckUpStatus, java.lang.String lastDoctorVisited) {
        super( hospitalName,hospitalAddress, fName, lName, insuranceID, age, gender, lastCheckUpDate, lastCheckUpStatus, lastDoctorVisited);
        this.appointmentStatus = false;
    }


    
    
    @Override
    public void assignDocToPatient(List<Doctor> doctorList)throws SpecialistNotFoundException{
       
            for (Doctor u :doctorList) {
            //   System.out.println(supe);
//                System.out.println(appointmentStatus);
            if(appointmentStatus==true&&"Child Specialist".equalsIgnoreCase(u.getSpecialityType())){
//                System.out.println("wades");
                appointmentStatus=true;
                String doctor = u.getName();
                String patientName= getfName()+getlName();
                getDoctorsMappedToPatients().add(doctor+":"+patientName);
                getAvailableDoctorsList().remove(u);
                
                
            }
            else
            {
        
                throw new SpecialistNotFoundException(" There is no available doctors in the list who are child specialist ");
            }
        }
        
    
    }
    
    public double calcBill(String billingDetails){
        double bill=0;
        String[] items = billingDetails.split(",");
        for(String e:items){
            if(e != null){
               switch(e){
                       case "Diptheria":
                           bill = bill+10.25;
                           break;
                       case"tetanus":
                           bill =bill+12.99;
                           break;
                       case "acellular pertussis":
                           bill = bill+17.89;
                           break;
                       case "Haemophilus influenzae":
                           bill= bill+7.5;
                           break;
                       case "Pneumococcal conjugate":
                           bill=bill+9.9;
                           break;
                       default:
                           bill=bill+ EMERGENCY_FEE;
                           break;
                           
                           
                           
               }
                
            }
        }
        return BASE_CONSULTATION_FEE+bill;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nStatus=" + appointmentStatus;
    }
    
    
    
    
}

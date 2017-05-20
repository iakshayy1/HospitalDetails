/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.Date;

/**
 *
 * @author Akshay Reddy Vontari
 */
public class ChildInsurance extends AbstractInsurance{

    public ChildInsurance(String InsuranceCompanyName, double InsuranceCoverage, String fName, String lName, int insuranceID, int age, char gender, Date lastCheckUpDate, boolean lastCheckUpStatus, String lastDoctorVisited) {
        super(InsuranceCompanyName, InsuranceCoverage, fName, lName, insuranceID, age, gender, lastCheckUpDate, lastCheckUpStatus, lastDoctorVisited);
    }
    
    public double calcAmountPayableToHospital(double PremiumPaidByCustomer,double billGenerated)throws NegativeAmountException{
        if(PremiumPaidByCustomer<0){
            throw new NegativeAmountException("Negative amount Exception");
        }
        else if(PremiumPaidByCustomer>BASE_PREMIUM_AMOUNT){
            return 0.8*billGenerated;
        }
        else if(PremiumPaidByCustomer<=BASE_PREMIUM_AMOUNT&PremiumPaidByCustomer>(BASE_PREMIUM_AMOUNT/2)){
            return 0.5*billGenerated;
        }
        else{
            return 0.2*billGenerated;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
    
    
}

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
public class AdultInsurance extends AbstractInsurance {

    public AdultInsurance(String InsuranceCompanyName, double InsuranceCoverage, String fName, String lName, int insuranceID, int age, char gender, Date lastCheckUpDate, boolean lastCheckUpStatus, String lastDoctorVisited) {
        super(InsuranceCompanyName, InsuranceCoverage, fName, lName, insuranceID, age, gender, lastCheckUpDate, lastCheckUpStatus, lastDoctorVisited);
    }
    
    public double calcAmountPayableToHospital(double PremiumPaidByCustomer,double billGenerated)throws NegativeAmountException{
        if(PremiumPaidByCustomer<0)
        {
            throw new NegativeAmountException("Negative Amount");
        }
          else if(PremiumPaidByCustomer>BASE_PREMIUM_AMOUNT)
        {
            return 0.75*billGenerated;
        }
         else if(PremiumPaidByCustomer<=BASE_PREMIUM_AMOUNT&&PremiumPaidByCustomer>0.5*BASE_PREMIUM_AMOUNT)
        {
            return 0.45*billGenerated;
        }
        else{
            return billGenerated;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
    
}

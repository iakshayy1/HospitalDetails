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
public abstract class AbstractInsurance extends Patient implements Insurance{
    private String InsuranceCompanyName;
    private double InsuranceCoverage;

    public AbstractInsurance(String InsuranceCompanyName, double InsuranceCoverage, String fName, String lName, int insuranceID, int age, char gender, Date lastCheckUpDate, boolean lastCheckUpStatus, String lastDoctorVisited) {
        super(fName, lName, insuranceID, age, gender, lastCheckUpDate, lastCheckUpStatus, lastDoctorVisited);
        this.InsuranceCompanyName = InsuranceCompanyName;
        this.InsuranceCoverage = InsuranceCoverage;
    }

    public String getInsuranceCompanyName() {
        return InsuranceCompanyName;
    }

    public double getInsuranceCoverage() {
        return InsuranceCoverage;
    }
    
    public abstract double calcAmountPayableToHospital(double PremiumPaid,double billGenerated)throws NegativeAmountException;
    
    public String checkHealthInsurancePlan()throws InvalidInsuranceIDException{
        String plan = "";
        if(super.getInsuranceID()<0&&super.getInsuranceID()>40000){
            throw new InvalidInsuranceIDException("invalid insurance ID exception   ");
        }
        else if(0<super.getInsuranceID()&&super.getInsuranceID()<10000){
            plan= "Health maintenance organizations (HMOs) plan";
        }
        else if(10000<=super.getInsuranceID() &&super.getInsuranceID()<20000){
            plan= "Preferred provider organizations (PPOs) plan";
        }
        else if(20000<=super.getInsuranceID() &&super.getInsuranceID()<30000){
            plan=  "Point-of-service (POS) plan";
        }
        else if(30000<=super.getInsuranceID() &&super.getInsuranceID()<40000){
             plan="High-deductible health plans (HDHPs)";
        }
        return plan;
    }

    @Override
    public String toString() {
        return "Insurance Company Name: " + InsuranceCompanyName + "Insurance Coverage: " + InsuranceCoverage;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Application launches from this class
 *
 * @author Akshay Reddy Vontari
 */
public class HospitalDriver {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException Throws if file is not found
     * @throws java.text.ParseException Parse the exception if there parsing has
     * problems
     * @throws hospital.InvalidInsuranceIDException
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException,  InvalidInsuranceIDException {
        Scanner sc = new Scanner(new File("Input.txt"));
        List<Doctor> doctorsList = new ArrayList<>();
        int count = 0;
        String docname;
        String SpecialityType;
        String officeHours;
        AbstractHospitalInfo hospitalInfo = new ChildWard();
        while(sc.hasNext()){
            String doc = sc.nextLine();
           // System.out.println(doc);
            if(doc.equals("Doctor")){
                docname = sc.nextLine();
                //System.out.println(docname);
                SpecialityType = sc.nextLine();
               // System.out.println(SpecialityType);
                officeHours = sc.nextLine();
               // System.out.println(officeHours);
                Doctor d = new Doctor(docname,SpecialityType,officeHours); 
                try
                {
                    hospitalInfo.addDoctors(d);
                }
                catch(InvalidDoctorSizeException e)
                {
                    System.out.println(e.getMessage());
                }
            }
                else
                {
                        String genderstring = sc.nextLine();
                        char gender= genderstring.charAt(count);
                        int age = Integer.parseInt(sc.nextLine());
                        if(age<16)
                        {
                            String hospitalName = sc.nextLine();
                            String hospitalAddress=sc.nextLine();
                            String childFName = sc.nextLine();
                            String childLName = sc.nextLine();
                            int insuranceID = Integer.parseInt(sc.nextLine());
                            String lastdateString = sc.nextLine();
                            DateFormat d = new SimpleDateFormat("MM/dd/yyyy",Locale.ENGLISH);
                            Date lastCheckUpDate = d.parse(lastdateString);
                            String lastCheckUpStatusString = sc.nextLine();
                            boolean lastCheckUpStatus = Boolean.parseBoolean(lastCheckUpStatusString);
                            if("true".equalsIgnoreCase(lastCheckUpStatusString))
                            {
                                String lastDoctorVisited = sc.nextLine();
                                ChildWard childWard = new ChildWard(hospitalName,hospitalAddress, childFName,childLName,insuranceID ,age,gender,lastCheckUpDate ,lastCheckUpStatus,lastDoctorVisited);
                                System.out.println("****************************************\nPatient Details: ");
                                System.out.println("****************************************");
                                System.out.println("Child Ward Details: "+childWard.toString());
                                
                                try{
                                    childWard.assignDocToPatient(hospitalInfo.getAvailableDoctorsList());
                                }
                                catch(SpecialistNotFoundException s)
                                {
                                    System.out.println("ChildSpecialistDoctorNotFoundException:"+s.getMessage());
                                }
                                
                                String billingDetails = sc.nextLine();
                                double childBillGenerated=childWard.calcBill(billingDetails);
                                System.out.println("Bill Amount Generated for Children before Insurance deduction:"+childBillGenerated);
                                System.out.println(childWard.getLastCheckUpDetails());
                                
                                String InsuranceCompany = sc.nextLine();
                                double InsuranceCoverage = Double.parseDouble(sc.nextLine());
                                ChildInsurance childInsurance = new ChildInsurance(InsuranceCompany,InsuranceCoverage,childFName,childLName,insuranceID,age,gender,lastCheckUpDate,lastCheckUpStatus,lastDoctorVisited);
                                System.out.println(childInsurance.toString());
                                try
                                {
                                    String insurancePlanName= childInsurance.checkHealthInsurancePlan();
                                    System.out.println("Insurance Plan Name: "+insurancePlanName);
                                }
                                catch(InvalidInsuranceIDException i)
                                        {
                                            System.out.println(i.getMessage());
                                        }
                                double premiumPaid = Double.parseDouble(sc.nextLine());
                                try
                                {
                                   double amountPayable= childInsurance.calcAmountPayableToHospital(premiumPaid, childBillGenerated);
                                    System.out.println("Amount to be paid by after insurance deduction: "+amountPayable);
                                    System.out.println("****************************************");
                                }
                                catch(NegativeAmountException n)
                                {
                                    System.out.println(n.getMessage());
                                }
                            }
                        }
                                
                                else if(age>16&"f".equalsIgnoreCase(genderstring))
                                {
                                    String hospitalname = sc.nextLine();
                                    String hospitalAddress = sc.nextLine();
                                    String adultFName = sc.nextLine();
                                    String adultLName = sc.nextLine();
                                    int insuranceID = Integer.parseInt(sc.nextLine());
                                    String lastdateString = sc.nextLine();
                                    DateFormat e = new SimpleDateFormat("MM/dd/yyyy",Locale.ENGLISH);
                                    Date lastcheckUpDate = e.parse(lastdateString);
                                    String lastCheckUpStatusString = sc.nextLine();
                                    boolean lastCheckUpStatus=Boolean.parseBoolean(lastCheckUpStatusString);
                                    
                                    if("true".equalsIgnoreCase(lastCheckUpStatusString))
                                    {
                                        String lastdoctorVisited = sc.nextLine();
                                        MaternityWard maternityWard = new MaternityWard(hospitalname,hospitalAddress,adultFName,adultLName,insuranceID,age,gender,lastcheckUpDate,lastCheckUpStatus,lastdoctorVisited);
                                        System.out.println("****************************************");
                                        System.out.println("Maternity Ward Details: "+maternityWard.toString());
                                        try
                                        {
                                            maternityWard.assignDocToPatient(hospitalInfo.getAvailableDoctorsList());
                                        }
                                        catch(SpecialistNotFoundException c)
                                        {
                                            System.out.println("GynaecologistNotFoundException: "+c.getMessage());
                                        }
                                        
                                        String billingDetails=sc.nextLine();
                                        double adultBillGenerated = maternityWard.calcBill(billingDetails);
                                        System.out.println("Bill Amount Generated for Adult before Indsurance deduction:"+adultBillGenerated);
                                        System.out.println(maternityWard.getLastCheckUpDetails());
                                        String InsuranceCompany = sc.nextLine();
                                        double InsuranceCoverage= Double.parseDouble(sc.nextLine());
                                        AdultInsurance adultInsurance = new AdultInsurance(InsuranceCompany,InsuranceCoverage,adultFName,adultLName,insuranceID,age,gender,lastcheckUpDate,lastCheckUpStatus,lastdoctorVisited);
                                        System.out.println(adultInsurance.toString());
                                        try
                                        {
                                            String insurancePlanName = adultInsurance.checkHealthInsurancePlan();
                                            System.out.println("Insurance Plan Name: "+insurancePlanName);
                                        }
                                        catch(InvalidInsuranceIDException i)
                                        {
                                            System.out.println(i.getMessage());
                                        }
                                        double premiumPaid = Double.parseDouble(sc.nextLine());
                                        try
                                        {
                                            double amountPayable = adultInsurance.calcAmountPayableToHospital(premiumPaid, adultBillGenerated);
                                            System.out.println("Amount to be paid by after insurance deduction: "+amountPayable);
                                        }
                                        catch(NegativeAmountException n)
                                        {
                                            System.out.println(n.getMessage());
                                        }
                                    }
                                }
                        }
                }
        System.out.println("****************************************");
        System.out.println("List of Doctors in Hospital: \n****************************************");
        for(Doctor q : hospitalInfo.getAvailableDoctorsList())
        {
            System.out.println(q.toString());
                
        }
                
    }
}
                                 

	
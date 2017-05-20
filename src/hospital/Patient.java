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
public class Patient {
    private String fName;
    private String lName;
    private int insuranceID;
    private int age;
    private char gender;
    private Date lastCheckUpDate;
    private boolean lastCheckUpStatus;
    private String lastDoctorVisited;

    public Patient() {
    }

    public Patient(String fName, String lName, int insuranceID, int age, char gender, Date lastCheckUpDate, boolean lastCheckUpStatus, String lastDoctorVisited) {
        this.fName = fName;
        this.lName = lName;
        this.insuranceID = insuranceID;
        this.age = age;
        this.gender = gender;
        this.lastCheckUpDate = lastCheckUpDate;
        this.lastCheckUpStatus = lastCheckUpStatus;
        this.lastDoctorVisited = lastDoctorVisited;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getLastCheckUpDetails(){
        if(lastCheckUpStatus == true){
            return "Last Check Up Date: "+lastCheckUpDate+"Last Doctor Visited: "+lastDoctorVisited+"Last Check Up Status: Success";
        }
        else
        {
           return "Last Check Up Date: "+lastCheckUpDate+"Last Doctor Visited: "+lastDoctorVisited+"Last Check Up Status: Failure"; 
        }
    }

    @Override
    public String toString() {
        return "\nFirst Name: " + fName + "\nLast Name: " + lName + "\nInsurance ID: " + insuranceID + "\nAge: " + age + "\nGender: " + gender;
    }
    
    
    
}

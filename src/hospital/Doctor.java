/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author Akshay Reddy Vontari
 */
public class Doctor {
    private String name;
    private String SpecialityType;
    private String officeHours;

    public Doctor(String name, String SpecialityType, String officeHours) {
        this.name = name;
        this.SpecialityType = SpecialityType;
        this.officeHours = officeHours;
    }

    public String getName() {
        return name;
    }

    public String getSpecialityType() {
        return SpecialityType;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    @Override
    public String toString() {
        return "Doctor Name: " + name + "\nSpeciality Type: " + SpecialityType + "\nOffice Hours: " + officeHours+"\n****************************************";
    }
    
    
    
}

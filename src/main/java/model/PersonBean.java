/*
 * Copyright Payara Services Ltd
 */
package model;

/**
 *
 * @author asroth
 */
public class PersonBean implements java.io.Serializable{
    private String ID;
    private String name;
    private String jobTitle;
    private String DOB;
    private String phoneNumber;
    private AppearanceBean appearance;
    
    public PersonBean(){
        
    }
    
    @Override
    public String toString(){
        return "ID: " + ID + "\n" + "Name: " + name + "\n" + "Job Title: " + jobTitle + "\n" + "DOB: " + DOB + "\n" + "Phone Number: " + phoneNumber 
                + "\n" + appearance.toString() + "\n";
    }
    
    public void setPhoneNumber(String number){
        this.phoneNumber = number;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setAppearance(AppearanceBean appearance){
        this.appearance = appearance;
    }
    
    public AppearanceBean getAppearance(){
        return appearance;
    }
 
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDOB() {
        return DOB;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }  
}

/*
 * Copyright Payara Services Ltd
 */
package model;

/**
 *
 * @author asroth
 */
public class Person {
    private String ID;
    private String name;
    private String jobTitle;
    private String DOB;
    //private Appearance appearance;
    private String appearance;
    private String phoneNumber;
    
    public Person(){
        
    }
    
    /*
    public void setAppearance(Appearance appearance){
        this.appearance = appearance;
    }
    
    public Appearance getAppearance(){
        return appearance;
    }
    */
    
    @Override
    public String toString(){
        return ID + ": " + name + ", " + jobTitle + ", " + DOB + ", " + phoneNumber + ", " + appearance; 
    }
    
    public void setPhoneNumber(String number){
        this.phoneNumber = number;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setAppearance(String appearance){
        this.appearance = appearance;
    }
    
    public String getAppearance(){
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

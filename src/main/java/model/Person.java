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
    
    public Person(){
        this.ID = ID;
        this.name = name;
        this.jobTitle = jobTitle;
        this.DOB = DOB;
    }
    
    /*
    public void setAppearance(Appearance appearance){
        this.appearance = appearance;
    }
    
    public Appearance getAppearance(){
        return appearance;
    }
    */
    
    public void setAppearance(String appearace){
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

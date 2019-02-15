/*
 * Copyright Payara Services Ltd
 */
package model;

/**
 *
 * @author asroth
 */
public class Appearance {
    private String height;
    private String hairColour;
    private String eyeColour;
    private String gender;
    
    public Appearance(){
        
    }
    
    public void setHeight(String height){
        this.height = height;
    }
    
    public void setHairColour(String colour){
        hairColour = colour;
    }
    
    public void setEyeColour(String colour){
        eyeColour = colour;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
}

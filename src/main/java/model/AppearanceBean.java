/*
 * Copyright Payara Services Ltd
 */
package model;

/**
 *
 * @author asroth
 */
public class AppearanceBean implements java.io.Serializable{
    private String height;
    private String hairColour;
    private String eyeColour;
    private String gender;
    
    public AppearanceBean(){
        
    }
    
    @Override
    public String toString(){
        return "Height: " + height + "; " + "Hair Colour: " +  hairColour + "; " + "Gender: " + gender + "; " + "Eye Colour: " + eyeColour;
    }
    
    public String getHeight(){
        return height;
    }
    
    public String getHairColour(){
        return hairColour;
    }
    
    public String getEyeColour(){
        return eyeColour;
    }
    
    public String getGender(){
        return gender;
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

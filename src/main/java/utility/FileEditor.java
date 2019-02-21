/*
 * Copyright Payara Services Ltd
 */
package utility;

import filemanipulator.MenuManager;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import model.PersonBean;

/**
 *
 * @author asroth
 */
public class FileEditor {   
    private boolean isVerbose;
    private MenuManager menuManager;
    private FileParser fileParser;
    private FileMaker fileMaker;
    private FileManager fileManager;
    private String currentFile;
    private InputParser inputParser;
    
    public FileEditor(){
        isVerbose = false;
        fileParser = new FileParser();
        menuManager = new MenuManager();
        inputParser = new InputParser();
        fileMaker = new FileMaker();
    }
    
    public boolean printContents(boolean isVerbose) {
        File file = new File(currentFile);
        if (!file.exists()) {
            System.out.println("Couldn't print the contents of the file at: " + currentFile);
            return false;
        }
        
        for (PersonBean person : fileParser.getPersonListFromFile(file)) {
            if(isVerbose){
                System.out.println(person.toString());
            }else{
                System.out.println(person.getID() + "\n" + person.getName());
            } 
        }
        return true;
    }
    
    public boolean newEntry() {
        File file = new File(currentFile);
        if (!file.exists()) {
            System.out.println("Can't edit file because it does not exist");
            return false;
        }

        PersonBean person = new PersonBean();
        System.out.println("Assign a ID to the new entry: ");
        person.setID("ID: " + inputParser.getLine());
        System.out.println("Assign a name to the new entry: ");
        person.setName("Name: " + inputParser.getLine());
        System.out.println("Assign a job title to the new entry: ");
        person.setJobTitle("Job Title: " + inputParser.getLine());
        System.out.println("Assign a Date Of Birth to the new entry: ");
        person.setDOB("DOB: " + inputParser.getLine());
        System.out.println("Assign a phone number to the new entry: ");
        person.setPhoneNumber("Phone number" + inputParser.getLine());
        System.out.println("Assign appearance: TO DO");
        
        fileMaker.writeToFile(file, person.toString());
        
        return true;
    }
    
    public boolean updateEntry(){
        File file = new File(currentFile);
        if(!file.exists()){
            System.out.println("Can't edit file because it does not exist");
            return false;
        }
        ArrayList<PersonBean> personList = fileParser.getPersonListFromFile(file);
        ArrayList<String> idList = new ArrayList<String>();
        ArrayList<String> selectedIDs = new ArrayList<String>();
        
        for(PersonBean person : personList){
            idList.add(person.getID());
        }
        
        System.out.println("Avaliable enteries:");
        printContents(false);
        System.out.println("Enter a ID or more to edit them");

        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Selected IDs:");
            String idString = selectedIDs.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(", ", " ", " "));
            System.out.println(idString);
            System.out.println("Enter DONE to finish adding IDs");

            String input = inputParser.getLine();

            for (String id : idList) {
                if (id.contains(input)) {
                    selectedIDs.add(input);
                }
            }

            if (input.equalsIgnoreCase("DONE")) {
                isRunning = false;
            }
        }
        
        System.out.println("Which field would you like to edit? \n"
                + "Name\n"
                + "Job Title\n"
                + "DOB\n"
                + "Phone Number\n"
                + "Height\n"
                + "Hair Colour\n"
                + "Eye Colour\n"
                + "Gender\n");
        
        String input = inputParser.getLine().trim().toUpperCase();
        
        String newName = null;
        String newJobTitle = null;
        String newDOB = null;
        String newPhoneNumber = null;
        String newHeight = null;
        String newHairColour = null;
        String newEyeColour = null;
        String newGender = null;
        
        if(input.contains("NAME")){
            System.out.println("What would you like to change the name to?: ");
            newName = inputParser.getLine().trim();
        }else if(input.contains("JOB TITLE")){
            System.out.println("What would you like to change the job title to?: ");
            newJobTitle = inputParser.getLine().trim();
        }else if(input.contains("DOB")){
            System.out.println("What would you like to change the date of birth to?: ");
            newDOB = inputParser.getLine().trim();
        }else if(input.contains("PHONE NUMBER")){
            System.out.println("What would you like to change the phone number to?: ");
            newPhoneNumber = inputParser.getLine().trim();
        }else if(input.contains("HEIGHT")){
            System.out.println("What would you like to change the height to?: ");
            newHeight = inputParser.getLine().trim();
        }else if(input.contains("HAIR COLOUR")){
            System.out.println("What would you like to change the hair colour to?: ");
            newHairColour = inputParser.getLine().trim();
        }else if(input.contains("EYE COLOUR")){
            System.out.println("What would you like to change the eye colour to?: ");
            newEyeColour = inputParser.getLine().trim();
        }else if(input.contains("GENDER")){
            System.out.println("What would you like to change the gender to?: ");
            newGender = inputParser.getLine().trim();
        }else{
            System.out.println(input + " isn't a valid field!");
        }
        
        for(String id : idList){
            for(PersonBean person : personList){
                if(person.getID().contains(id)){
                    if(newName != null){
                        person.setName(newName);
                    }else if(newJobTitle != null){
                        person.setJobTitle(newJobTitle);
                    }else if(newDOB != null){
                        person.setPhoneNumber(newPhoneNumber);
                    }else if(newHeight != null){
                        person.getAppearance().setHeight(newHeight);
                    }else if(newHairColour != null){
                        person.getAppearance().setHairColour(newHairColour);
                    }else if(newEyeColour != null){
                        person.getAppearance().setEyeColour(newEyeColour);
                    }else if(newGender != null){
                        person.getAppearance().setGender(newGender);
                    }
                }
            }
        }
        
        if(isVerbose){
           Thread t1 = new Thread(() -> {
               fileManager.recombobulateFiles(currentFile);
           });
           Thread t2 = new Thread(() -> {
               printContents(true);
           });
           t1.start();
           t2.start();
        }else{
            fileManager.recombobulateFiles(currentFile);
        }

        return true;
    }
    
    public void toggleVerbose(){
        isVerbose = !isVerbose;
    }
    
    public boolean isVerbose(){
        return isVerbose;
    }
    
    public String getCurrentFilePath(){
        return currentFile;
    }
    
    public void setCurrentFilePath(String filePath){
        currentFile = filePath;
    }
    
    public void registerFileManager(FileManager fileManager){
        this.fileManager = fileManager;
    }
    
}
    


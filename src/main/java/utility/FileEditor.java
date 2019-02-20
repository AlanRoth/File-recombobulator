/*
 * Copyright Payara Services Ltd
 */
package utility;

import filemanipulator.MenuManager;
import java.io.File;
import java.util.ArrayList;
import model.PersonBean;

/**
 *
 * @author asroth
 */
public class FileEditor {   
    private ArrayList<PersonBean> personList;
    private boolean isVerbose;
    private MenuManager menuManager;
    private FileParser fileParser;
    private FileMaker fileMaker;
    private String currentFile;
    private CommandParser commandParser;
    private InputParser inputParser;
    
    public FileEditor(){
        isVerbose = false;
        fileParser = new FileParser();
        menuManager = new MenuManager();
        inputParser = new InputParser();
        fileMaker = new FileMaker();
    }
    
    public boolean printContents() {
        File file = new File(currentFile);
        if (!file.exists()) {
            System.out.println("Couldn't print the contents of the file at: " + currentFile);
            return false;
        }
        
        for (PersonBean person : fileParser.getPersonListFromFile(file)) {
                System.out.println(person.toString());
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
    
    public boolean updateEntry(String commandData){
        File file = new File(currentFile);
        if(!file.exists()){
            System.out.println("Can't edit file because it does not exist");
            return false;
        }
        
        //TO DO
        //Extract ID and field, then update the field with the provided data
        
        for(PersonBean person : fileParser.getPersonListFromFile(file)){
            
        }     
        return true;
    }
    
    public void registerCommandParser(CommandParser commandParser){
        this.commandParser = commandParser;
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
    
}
    


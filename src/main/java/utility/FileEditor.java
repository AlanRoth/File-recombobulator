/*
 * Copyright Payara Services Ltd
 */
package utility;

import filemanipulator.MenuManager;
import java.io.File;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import model.AppearanceBean;
import model.PersonBean;

/**
 *
 * @author asroth
 */
public class FileEditor {   
    private boolean isVerbose;
    private MenuManager menuManager;
    private FileParser fileParser;
    private FileManager fileManager;
    private String currentFile;
    private InputParser inputParser;
    
    public FileEditor(){
        isVerbose = false;
        fileParser = new FileParser();
        menuManager = new MenuManager();
        inputParser = new InputParser();
    }
    
    public boolean checkIfFileExists(File file){    
        if (!file.exists()) {
            System.out.println("Couldn't print the contents of the file at: " + currentFile);
            return false;
        }
        return true;
    }
    
    public boolean printContents(boolean isVerbose) {
        File file = new File(currentFile);
        if (checkIfFileExists(file)) {
            for (PersonBean person : fileParser.getPersonListFromFile(file)) {
                if (isVerbose) {
                    System.out.println(person.toString());
                } else {
                    System.out.println(person.getID() + "\n" + person.getName());
                }
            }         
        }
        return true;
    }
    
    public boolean newEntry() {
        File file = new File(currentFile);
        if (checkIfFileExists(file)) {

            PersonBean person = new PersonBean();
            AppearanceBean appearance = new AppearanceBean();
            person.setAppearance(appearance);
            System.out.println("Assign a ID to the new entry: ");
            person.setID(inputParser.getLine());
            System.out.println("Assign a name to the new entry: ");
            person.setName(inputParser.getLine());
            System.out.println("Assign a job title to the new entry: ");
            person.setJobTitle(inputParser.getLine());
            System.out.println("Assign a Date Of Birth to the new entry: ");
            person.setDOB(inputParser.getLine());
            System.out.println("Assign a phone number to the new entry: ");
            person.setPhoneNumber(inputParser.getLine());
            System.out.println("Assign a height to the new entry: ");
            person.getAppearance().setHeight(inputParser.getLine());
            System.out.println("Assign a hair colour to the new entry: ");
            person.getAppearance().setHairColour(inputParser.getLine());
            System.out.println("Assign a eye colour to the new entry: ");
            person.getAppearance().setEyeColour(inputParser.getLine());
            System.out.println("Assign a gender to the new entry: ");
            person.getAppearance().setGender(inputParser.getLine());
            
            ArrayList<PersonBean> personList = fileParser.getPersonListFromFile(file);
            personList.add(person);
            
            fileManager.writeFile(file, personList);
        }
        return true;
    }
    
    public boolean updateEntry(){
        File file = new File(currentFile);
        String input = "";
        if (checkIfFileExists(file)) {
            ArrayList<PersonBean> personList = fileParser.getPersonListFromFile(file);
            ArrayList<PersonBean> selectedPersons = selectPersons(personList);

            for(PersonBean person : selectedPersons){
                System.out.println("\n" + "Current ID: " + person.getID() + "\n");
                
                Boolean isRunning = true;
                while(isRunning){
                    System.out.println("Which field would you like to edit? \n"
                    + "Enter 'done' to finish editing\n"
                    + "Name [To change the name]\n"
                    + "Job [To change the job title]\n"
                    + "DOB [To change the date of birth]\n"
                    + "Phone [To change the phone number]\n"
                    + "Height [To change the height]\n"
                    + "Hair [To change the hair colour]\n"
                    + "Eye [To change the eye colour]\n"
                    + "Gender [To change the gender]\n");
                    
                    input = inputParser.getLine().trim().toUpperCase();
                    
                    switch(input.toUpperCase()){
                        case "NAME": 
                            System.out.print("Changing name: " + person.getName() + " to: ");
                            person.setName(inputParser.getLine().trim());
                            break;
                            
                        case "JOB":
                            System.out.print("Changing job title: " + person.getJobTitle() + " to: ");
                            person.setJobTitle(inputParser.getLine().trim());
                            break;
                            
                        case "DOB":
                            System.out.print("Changing date of birth: " + person.getDOB() + " to: ");
                            person.setDOB(inputParser.getLine().trim());
                            break;
                            
                        case "PHONE":
                            System.out.print("Changing phone number: " + person.getPhoneNumber() + " to: ");
                            person.setJobTitle(inputParser.getLine().trim());
                            break;
                            
                        case "HEIGHT":
                            System.out.print("Changing height: " + person.getAppearance().getHeight() + " to: ");
                            person.getAppearance().setHeight(inputParser.getLine().trim());
                            break;
                            
                        case "HAIR":
                            System.out.println("Changing hair colour: " + person.getAppearance().getHairColour() + " to: ");
                            person.getAppearance().setHairColour(inputParser.getLine());
                            break;
                            
                        case "EYE":
                            System.out.println("Changing eye colour: " + person.getAppearance().getHairColour() + " to: ");
                            person.getAppearance().setEyeColour(inputParser.getLine());
                            break;
                            
                        case "GENDER":
                            System.out.println("Changing gender: " + person.getAppearance().getHairColour() + " to: ");
                            person.getAppearance().setGender(inputParser.getLine());
                            break;
                            
                        case "DONE":
                            isRunning = false;
                            break;
                            
                        default: 
                            System.out.println("That attribute doesn't exist! You can finish by typing 'Done'");
                    }
                    
                }   
            }       

            if (isVerbose) {
                Thread t1 = new Thread(() -> {
                    fileManager.writeFile(file, personList);
                });
                
                Thread t2 = new Thread(() -> {
                    printContents(true);
                });        
                t1.start();
                t2.start();
            } else {
                fileManager.writeFile(file, personList);
            }
        }
        return true;
    }
    
    private ArrayList<PersonBean> selectPersons(ArrayList<PersonBean> arrayList){
        ArrayList<PersonBean> personList = arrayList;
        ArrayList<PersonBean> selectedPersons = new ArrayList<>();
        ArrayList<String> avaliableIDs = new ArrayList<>(personList.stream().map(p -> p.getID()).collect((Collectors.toList())));
        
        String input = "";
        
        boolean isRunning = true;
        while(isRunning){
            System.out.println("Avaliable IDs: \n"
                    + avaliableIDs.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(", ", " ", " ")) + "\n");
            System.out.println("Selected IDs: \n"
                    + selectedPersons.stream().map(p -> p.getID()).collect(Collectors.joining(", ", " ", " ")) + "\n");
            
            System.out.println("Enter the ID you would like to select, enter DONE to finish selecting IDs");
            input = inputParser.getLine();
            
            if(avaliableIDs.contains(input) && !(selectedPersons.stream().map(p -> p.getID()).collect(Collectors.toList()).contains(input))){
                for(PersonBean person : personList){
                    if(person.getID().equalsIgnoreCase(input)){
                        selectedPersons.add(person);
                    }
                }
            }else if(input.equalsIgnoreCase("DONE")){
                isRunning = false;
            }else{
                System.out.println("Thats not a valid ID! You can enter 'Done' to finish adding IDs");
            }
        }
        
        return selectedPersons;
    }
    
    public boolean deleteEntry(String commandData){
        File file = new File(currentFile);
        if (checkIfFileExists(file)) {
            ArrayList<PersonBean> personList = fileParser.getPersonListFromFile(file);
            for(PersonBean person : personList){
                if(person.getID().equals(commandData)){
                    personList.remove(person);
                    fileManager.writeFile(file, personList);
                    return true;
                }
            }
            System.out.println("That ID doesn't exist!");
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
    


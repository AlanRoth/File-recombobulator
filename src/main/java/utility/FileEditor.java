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
    private String currentFile;
    private CommandParser commandParser;
    private InputParser inputParser;
    
    public FileEditor(){
        isVerbose = false;
        fileParser = new FileParser();
        menuManager = new MenuManager();
    }
    
    public void editMenu() {
        
    }
    
    public void printContents() {
        File file = new File(currentFile);
        if (file.exists()) {
            for (PersonBean person : fileParser.getPersonListFromFile(file)) {
                System.out.println(person.toString());
            }
        } else {
            System.out.println("Couldn't print the contents of the file at: " + currentFile);
        }
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
    


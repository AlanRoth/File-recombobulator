/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.util.ArrayList;

/**
 *
 * @author asroth
 */
public class CommandParser {
    private FileManager fileManager;
    private FileEditor fileEditor;
    private boolean isEditing;
    
    public CommandParser(FileManager fileManager, FileEditor fileEditor){
        this.fileEditor = fileEditor;
        this.fileManager = fileManager;
        isEditing = false;
    }
    
    public boolean processCommand(Command command){       
        String commandWord = command.getCommandWord().toUpperCase();
        if(isEditing){
            return processEditCommand(command);
        }
        switch(commandWord){
            case "ADD":
                fileManager.addPath(command.getCommandData());
                return true;
            case "RECOMBOBULATE":
                fileManager.recombobulateFiles(command.getCommandData());
                return true;
            case "EDIT":
                if(isEditing){
                    System.out.println("You're already in edit mode!");
                }else{
                    isEditing = true;
                }
                return true;
            case "LOAD":
                fileManager.addDefaultPaths();
                return true;
            case "CLEAR":
                fileManager.clearPaths();
                return true;
            case "VERBOSE":
                //TO DO
                return true;
            case "QUIT":              
                return false;
            default:
                System.out.println("Command " + commandWord + " is not recognised");
        }       
        return true;
    }
    
    private boolean processEditCommand(Command command){
        String commandWord = command.getCommandWord().toUpperCase();
        fileEditor.setCurrentFilePath(fileManager.getOutputPath());
        switch(commandWord){
            case "SELECT":
                if (!command.hasData()) {
                    System.out.println("You need to specify a file path.");
                } else {
                    fileEditor.setCurrentFilePath(command.getCommandData());
                }
                return true;
            case "PRINT":
                fileEditor.printContents();
            case "MENU":              
                return false;
            default:
                System.out.println("Command " + commandWord + " is not recognised");
        }
        return true;
    }
    
    public boolean IsEditing(){
       return isEditing;
    }
    
    public FileManager getFileManager(){
        return fileManager;
    }
}

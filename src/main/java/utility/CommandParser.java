/*
 * Copyright Payara Services Ltd
 */
package utility;

import model.Command;
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
        //Main commands
        switch(commandWord){
            case "ADD":
                fileManager.addPath(command.getCommandData());
                return true;
            case "RECOMBOBULATE":
                fileManager.recombobulateFiles(command.getCommandData());
                return true;
            case "EDIT":
                isEditing = true;
                return true;
            case "LOAD":
                fileManager.addDefaultPaths();
                return true;
            case "CLEAR":
                fileManager.clearPaths();
                return true;
            case "VERBOSE":
                fileEditor.toggleVerbose();
                return true;
            case "JSON":
                fileManager.toggleIsJson();
                return true;
            case "QUIT":              
                return false;         
        }       
        
        //Edit commands
        if(isEditing){
            switch(commandWord){
                case "SELECT":
                    fileEditor.setCurrentFilePath(command.getCommandData());
                    return true;
                case "PRINT":
                    if(command.getCommandData().contains("-v")){
                        fileEditor.printContents(true);
                    }else{
                        fileEditor.printContents(false);
                    }
                    return true;
                case "NEW":
                    fileEditor.newEntry();
                    return true;
                case "UPDATE":
                    fileEditor.updateEntry();
                    return true;
                case "DELETE":
                    fileEditor.deleteEntry(command.getCommandData());
                    return true;
                case "BACK":
                    isEditing = false;
                    return true;
            }
        }
        System.out.println("Command: " + commandWord + " is not recognised!");
        return true;
    }
   
    public boolean isEditing(){
        return isEditing;
    }
    
    public FileManager getFileManager(){
        return fileManager;
    }
}

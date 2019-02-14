/*
 * Copyright Payara Services Ltd
 */
package org.alan.roth.filemanipulator;

import java.util.ArrayList;
import utility.FileManager;
import utility.InputParser;

/**
 *
 * @author asroth
 */
public class UserIO {  
    private final InputParser inputParser;
    public final FileManager fileManager;
    private final MenuManager menuManager;
    
    public UserIO(){
        System.out.println("Welcome to the database file re-combobulator\n"
                + "\t...For all your recombobulating needs!\n");
        inputParser = new InputParser();
        fileManager = inputParser.getFileManager();
        menuManager = new MenuManager();
    }
    
    public void mainMenu(){
             boolean isActive = true;
             ArrayList<String> filePaths;
             while(isActive){
                 filePaths = fileManager.getFilePathBuffer();
                 
                 System.out.println("\nFile paths loaded: ");
                 for(String path : filePaths){
                     System.out.println(path);
                 }
                 
                 menuManager.printHelpMenu();                                                 
                 
                 inputParser.getInput();
                 inputParser.processInput();
             }
 
    }
}

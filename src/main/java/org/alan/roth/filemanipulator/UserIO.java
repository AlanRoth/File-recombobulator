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
    private final FileManager fileManager;
    private final MenuManager menuManager;
    
    public UserIO(){
        System.out.println("Welcome to the database file re-combobulator\n"
                + "\t...For all your recombobulating needs!\n");
        fileManager = new FileManager();
        inputParser = new InputParser();
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
                 System.out.println(filePaths.toString());
                 //(a)dd more file paths
                 //(r)ecombobulate files at file paths into one (try to)
                 //(e)dit recombobulated file
                 //(c)lear all file paths
                 //(l)oad default file paths
                 //(v)erbose mode
                 //(q)uit
                 
                 menuManager.printHelpMenu();                                                 
                 
                 inputParser.getInput();
                 inputParser.processInput();
             }
 
    }
}

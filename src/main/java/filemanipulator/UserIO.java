/*
 * Copyright Payara Services Ltd
 */
package filemanipulator;

import java.util.ArrayList;
import utility.CommandParser;
import utility.FileEditor;
import utility.FileManager;
import utility.InputParser;

/**
 *
 * @author asroth
 */
public class UserIO {  
    //Default output location
    private static final String OUTPUTPATH = "/home/asroth/Documents/resource/output.txt";
    //3 default file paths
    private static final String FILEPATH1 = "/home/asroth/Documents/resource/file1";
    private static final String FILEPATH2 = "/home/asroth/Documents/resource/file2";
    private static final String FILEPATH3 = "/home/asroth/Documents/resource/file3";
    
    private final InputParser inputParser;
    public final FileManager fileManager;
    public final FileEditor fileEditor;
    private final MenuManager menuManager;
    private final CommandParser commandParser;
    private boolean isRunning;
    
    public UserIO(){
        System.out.println("Welcome to the database file recombobulator\n"
                + "\t...For all your recombobulating needs...\n");
        inputParser = new InputParser();      
        fileManager = new FileManager(OUTPUTPATH, FILEPATH1, FILEPATH2, FILEPATH3);
        fileEditor = new FileEditor();
        menuManager = new MenuManager();
        commandParser = new CommandParser(fileManager, fileEditor);
    }
    
    public void mainMenu(){
             isRunning = true;       
             while(isRunning){                
                 System.out.println("\nFile paths loaded: ");
                 //Gets the file paths from fileManager and loops through them
                 for(String path : fileManager.getFilePathQueue()){
                     System.out.println(path);
                 }
                 
                 menuManager.printHelpMenu(fileEditor.isVerbose());                                                                
                 if(!commandParser.processCommand(inputParser.getInput())){
                     isRunning = false;
                     System.exit(0);
                 }                         
             }
    }
}

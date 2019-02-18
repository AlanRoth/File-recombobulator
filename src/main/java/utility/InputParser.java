/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.util.Scanner;

/**
 *
 * @author asroth
 */
public class InputParser {
    private final Scanner scanner;
    private final FileManager fileManager;
    private String lastCommand;
    private String lastData;
    
    public InputParser(){
        scanner = new Scanner(System.in);
        fileManager = new FileManager();
        lastCommand = "";
        lastData = "";
    }
    
    public String getInput(){
        lastCommand = scanner.next().trim();
        lastData = scanner.nextLine().trim();
        return lastCommand + " " + lastData;
    }
    
    public void processInput(){
        if(lastCommand.equalsIgnoreCase("add")){
            fileManager.addPath(lastData);
        }else if(lastCommand.equalsIgnoreCase("recombobulate")){
            fileManager.addFiles();
            if(lastData.trim().isEmpty() || lastData == null){
                fileManager.recombobulateFiles();
            }else{
                fileManager.recombobulateFiles(lastData);
            }
        }else if(lastCommand.equalsIgnoreCase("edit")){
            
        }else if(lastCommand.equalsIgnoreCase("load")){
            fileManager.addDefaultPaths();
        }else if(lastCommand.equalsIgnoreCase("clear")){
            fileManager.clearPaths();
        }else if(lastCommand.equalsIgnoreCase("verbose")){
            
        }else if(lastCommand.equalsIgnoreCase("quit")){
            System.exit(0);
        }else{
            System.out.println("Command " + lastCommand + " isn't recognised!");
        }
    }
    
    public FileManager getFileManager(){
        return fileManager;
    }
    
}

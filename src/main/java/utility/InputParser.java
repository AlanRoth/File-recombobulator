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
    private final FileWriter fileWriter;
    private String lastCommand;
    private String lastData;
    
    public InputParser(){
        scanner = new Scanner(System.in);
        fileManager = new FileManager();
        fileWriter = new FileWriter();
        lastCommand = "";
        lastData = "";
    }
    
    public String getInput(){
        lastCommand = scanner.next();
        lastData = scanner.nextLine();
        return lastCommand + lastData;
    }
    
    public void processInput(){
        if(lastCommand.equalsIgnoreCase("add")){
            fileManager.addPath(lastData);
        }else if(lastCommand.equalsIgnoreCase("recombobulate")){
            fileManager.addFiles();
            if(lastData.trim().isEmpty() || lastData == null){
                fileWriter.makeFile();
            }else{
                fileWriter.makeFile(lastData);
            }
        }else if(lastCommand.equalsIgnoreCase("edit")){
            
        }else if(lastCommand.equalsIgnoreCase("clear")){
            
        }else if(lastCommand.equalsIgnoreCase("load")){
            
        }else if(lastCommand.equalsIgnoreCase("verbose")){
            
        }else if(lastCommand.equalsIgnoreCase("quit")){
            System.exit(0);
        }else{
            System.out.println(lastCommand + " isn't recognised!");
        }
    }
    
}

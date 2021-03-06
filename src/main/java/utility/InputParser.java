/*
 * Copyright Payara Services Ltd
 */
package utility;

import model.Command;
import java.util.Scanner;

/**
 *
 * @author asroth
 */
public class InputParser {
    private final Scanner scanner;
    private String lastCommand;
    private String lastData;
    
    public InputParser(){
        scanner = new Scanner(System.in);
        lastCommand = "";
        lastData = "";
    }
    
    public String getLine(){
        return scanner.nextLine().trim();
    }
    
    public Command getInput(){
        lastCommand = scanner.next().trim();       
        lastData = scanner.nextLine().trim();
        return new Command(lastCommand, lastData);
    }
    
    public String getLastCommand(){
        return lastCommand;
    }
    
    public String getLastData(){
        return lastData;
    }
}

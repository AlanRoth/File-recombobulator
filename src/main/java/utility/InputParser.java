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
    private String lastCommand;
    private String lastData;
    
    public InputParser(){
        scanner = new Scanner(System.in);
        lastCommand = "";
        lastData = "";
    }
    
    public String getLine(){
        return scanner.next().trim();
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

/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.util.ArrayList;

/**
 *
 * @author asroth
 */
public class Command {
    public String commandWord;
    public String commandData;
    
    public Command(String command, String data){
        commandWord = command;
        commandData = data;
    }
    
    public String getCommandWord(){
        return commandWord;
    }
    
    public String getCommandData(){
        return commandData;
    }   
    
    public boolean hasData(){
        return isEmptyOrNull(commandData);
    }
    
    public boolean hasWord(){
       return isEmptyOrNull(commandWord);
    }
    
    private boolean isEmptyOrNull(String string){
        if(string == null){
            return true;
        }else if(string.trim().isEmpty()){
            return true;
        }
        return false;
    }
    
}

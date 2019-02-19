/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/**
 *
 * @author asroth
 */
public class FileMaker {
    private PrintWriter writer;  
    
    public void writeToFile(File file, String text){
        try {
            writer = new PrintWriter(new FileWriter(file, true), true);
            writer.println(text);
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            writer.close();
        }       
    }
    
    public void overwriteLine(Pattern pattern, String text){
        
    }
    
}

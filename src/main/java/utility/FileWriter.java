/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author asroth
 */
public class FileWriter {
    private String defaultPath = "../resource/output/";
    
    public void makeFile(){
        File newfile = new File("output.txt");
        try{
            if(newfile.createNewFile()){
                System.out.println("A file has been created at " + defaultPath);
            }else{
                System.out.println("File overwritten");
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    
    public void makeFile(String path){
        
    }
    
}

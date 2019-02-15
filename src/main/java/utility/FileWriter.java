/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asroth
 */
public class FileWriter {
    private String defaultPath = "/home/asroth/Documents/resource/";
    PrintWriter writer;
    
    public FileWriter(){
        try {
            writer = new PrintWriter("output.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }
    
    public void makeFile(){
        makeFile(defaultPath);
    }
    
    public void makeFile(String path){
        File newfile = new File("output.txt");
        try{
            if(newfile.createNewFile()){
                System.out.println("A file has been created at " + path);
            }else{
                newfile.delete();
                System.out.println("File already exists");
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}

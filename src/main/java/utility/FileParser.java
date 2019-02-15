/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Person;

/**
 *
 * @author asroth
 */
public class FileParser {
    private ArrayList<File> files;
    BufferedReader reader;
    
    public FileParser(){
        
    }
    
    public void getPersonFromFiles(){
        for(File file : files){
            try {
                reader = new BufferedReader(new FileReader(file));
                reader.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Person newPerson = new Person();
            
            
        }
    }
    
    public void setFileList(ArrayList<File> files){
        this.files = files;
    }
    
    
}

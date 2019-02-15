/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Person;

/**
 *
 * @author asroth
 */
public class FileParser {
    private ArrayList<File> files;
    
    public FileParser(){

    }
    
    public void setFileList(ArrayList<File> files){
        this.files = files;
    }
    
    public ArrayList<Person> extractDataFromFiles(){
        ArrayList<Person> personList = new ArrayList<Person>();
        HashMap<String, Person> personMap = new HashMap<String, Person>();
        String currentId = "";
        
        for(File file : files){
            
        }
        
        return personList;
    }
    
    private String extractId(File file){
        Pattern idPattern = Pattern.compile("ID:\\s\\d+\\s?");
        //Matcher idMatcher = idPattern.matcher(cs);
        try{
            Scanner scanner = new Scanner(file);
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        
        return null;
        
    }
}

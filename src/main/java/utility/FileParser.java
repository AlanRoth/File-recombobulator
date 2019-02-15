/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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
}

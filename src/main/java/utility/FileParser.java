/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Person;

/**
 *
 * @author asroth
 */
public class FileParser {
    
    public FileParser(){
        
    }

    public ArrayList<Person> getPersonListFromFile(File file, String outputPath) {
        HashMap<String, Person> personMap = new HashMap<String, Person>();
        
        Pattern idPattern = Pattern.compile("ID: \\d+[^\\s]");
        Pattern namePattern = Pattern.compile("Name: [a-zA-Z].+");
        Pattern jobPattern = Pattern.compile("Job Title: [a-zA-Z].+");
        Pattern dobPattern = Pattern.compile("DOB: \\d\\d[\\/]\\d\\d[\\/]\\d+");
        Pattern appearancePattern = Pattern.compile("Appearance: .+");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            String currentID = "";  
            
            Matcher idMatcher;
            Matcher nameMatcher;
            Matcher jobMatcher;
            Matcher dobMatcher;
            Matcher appearanceMatcher;
            
            while (line != null) {       
                Person newperson = new Person();
                line = reader.readLine();
                
                idMatcher = idPattern.matcher(line);
                nameMatcher = namePattern.matcher(line);
                jobMatcher = jobPattern.matcher(line);
                dobMatcher = dobPattern.matcher(line);
                appearanceMatcher = appearancePattern.matcher(line);             
                
                if (idMatcher.find()) {
                    currentID = idMatcher.group();
                    if(!personMap.containsKey(currentID)){
                        personMap.put(currentID, newperson);
                    }
                }
                
                if(nameMatcher.find()){
                    personMap.get(currentID).setName(nameMatcher.group());
                }
                
                if(jobMatcher.find()){
                    personMap.get(currentID).setJobTitle(jobMatcher.group());
                }
                
                if(dobMatcher.find()){
                    personMap.get(currentID).setDOB(jobMatcher.group());
                }
                
                if(appearanceMatcher.find()){
                    personMap.get(currentID).setAppearance(jobMatcher.group());
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}


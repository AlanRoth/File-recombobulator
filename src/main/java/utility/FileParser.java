/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.AppearanceBean;
import model.PersonBean;

/**
 *
 * @author asroth
 */
public class FileParser {

    public ArrayList<PersonBean> getPersonListFromFile(File file){
        ArrayList<File> fileList = new ArrayList<>();
        fileList.add(file);
        return getPersonListFromFiles(fileList);
    }
    
    public ArrayList<PersonBean> getPersonListFromFiles(ArrayList<File> fileList) {
        HashMap<String, PersonBean> personMap = new HashMap<>();
        for(File file : fileList){
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                
                String line = reader.readLine();
                String lastSearch = "";
                String currentID = "";
                
                Function<Matcher, String> findLambda = (m) -> {
                    if(m.find()){
                        return m.group(2);
                    }
                    
                    return null;
                };

                
                while(line != null){
                    
                    //Find the ID
                    lastSearch = performSearch("(\"?ID\":\"? \"\"?|ID: )([0-9]+)", line, findLambda);
                    if(lastSearch != null){
                        currentID = lastSearch;
                        if(!(personMap.containsKey(currentID))){
                            PersonBean person = new PersonBean();
                            AppearanceBean appearance = new AppearanceBean();
                            person.setID(currentID);
                            person.setAppearance(appearance);
                            personMap.put(currentID, person);
                        }
                    }
                    
                    //Find the name                
                    lastSearch = performSearch("(\"?name\":\"? \"\"?|Name: )([a-zA-Z ]+)", line, findLambda);
                    if(lastSearch != null){
                        personMap.get(currentID).setName(lastSearch);
                    }                                   
                    
                    //Find the job title
                    lastSearch = performSearch("(\"?jobTitle\":\"? \"\"?|Job Title: )([a-zA-Z ]+)", line, findLambda);
                    if(lastSearch != null){
                        personMap.get(currentID).setJobTitle(lastSearch);
                    }
                 
                    //Find the date of birth
                    lastSearch = performSearch("(\"?DOB\":\"? \"\"?|DOB: )([0-9]{2}.[0-9]{2}.[0-9]{4})", line, findLambda);
                    if(lastSearch != null){
                        personMap.get(currentID).setDOB(lastSearch);
                    }
                    
                    //Find phone number
                    lastSearch = performSearch("(\"?phoneNumber\":\"? \"\"?|Phone Number: )([0-9]{11})", line, findLambda);
                    if(lastSearch != null){
                        personMap.get(currentID).setPhoneNumber(lastSearch);
                    }
                    
                    //Find the height
                    lastSearch = performSearch("(\"?height\":\"? \"\"?|Height: )(\\d+\\w+)", line, findLambda);
                    if(lastSearch != null){
                        personMap.get(currentID).getAppearance().setHeight(lastSearch);
                    }
                
                    //Find the hair colour
                    lastSearch = performSearch("(\"?hairColour\":\"? \"\"?|Hair Colour: )(\\w+)", line, findLambda);
                    if(lastSearch != null){
                        personMap.get(currentID).getAppearance().setHairColour(lastSearch);
                    }
                    
                    //Find the gender
                    lastSearch = performSearch("(\"?gender\":\"? \"\"?|Gender: )(Male|Female|male|female|M|F|m|f)", line, findLambda);
                    if(lastSearch != null){
                        personMap.get(currentID).getAppearance().setGender(lastSearch);
                    }
                    
                    //Find the eye colour
                    lastSearch = performSearch("(\"?eyeColour\":\"? \"\"?|Eye Colour: )(\\w+)", line, findLambda);
                    if(lastSearch != null){
                        personMap.get(currentID).getAppearance().setEyeColour(lastSearch);
                    }             
                    
                    line = reader.readLine();
                    
                }
                
            } catch (FileNotFoundException ex) {
                System.err.println("Couldn't find file");
            } catch (IOException ex) {
                System.err.println("Couldn't access file");
            }
        }
        return new ArrayList<>(personMap.values());
    }
    
    public String performSearch(String patternString, String line, Function<Matcher, String> function){
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(line);
        matcher.reset(line);
        return function.apply(matcher);
    }
}

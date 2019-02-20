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
import model.PersonBean;

/**
 *
 * @author asroth
 */
public class FileParser {

    private ArrayList<PersonBean> personList;

    public ArrayList<PersonBean> getPersonListFromFile(File file){
        ArrayList<File> fileList = new ArrayList<File>();
        fileList.add(file);
        return getPersonListFromFiles(fileList);
    }
    
    public ArrayList<PersonBean> getPersonListFromFiles(ArrayList<File> fileList) {
        HashMap<String, PersonBean> personMap = new HashMap<String, PersonBean>();
        ArrayList<PersonBean> personList = new ArrayList<PersonBean>();

        Pattern idPattern = Pattern.compile("ID: \\d+[^\\s]");
        Pattern namePattern = Pattern.compile("Name: [a-zA-Z].+");
        Pattern jobPattern = Pattern.compile("Job Title: [a-zA-Z].+");
        Pattern dobPattern = Pattern.compile("DOB: [0-9]{2}.[0-9]{2}.[0-9]{4}");
        Pattern appearancePattern = Pattern.compile("Appearance:.+");
        Pattern mobilePattern = Pattern.compile("Phone Number: [0-9]{11}");
        for (File file : fileList) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = "";
                String currentID = "";

                Matcher idMatcher = idPattern.matcher(line);
                Matcher nameMatcher = namePattern.matcher(line);
                Matcher jobMatcher = jobPattern.matcher(line);
                Matcher dobMatcher = dobPattern.matcher(line);
                Matcher appearanceMatcher = appearancePattern.matcher(line);
                Matcher mobileMatcher = mobilePattern.matcher(line);

                while (line != null) {
                    line = reader.readLine();

                    if (line != null) {

                        idMatcher.reset(line);
                        nameMatcher.reset(line);
                        jobMatcher.reset(line);
                        dobMatcher.reset(line);
                        appearanceMatcher.reset(line);
                        mobileMatcher.reset(line);

                        if (idMatcher.find()) {
                            currentID = idMatcher.group();
                            if (!personMap.containsKey(currentID)) {
                                PersonBean newPerson = new PersonBean();
                                newPerson.setID(currentID);
                                personMap.put(currentID, newPerson);
                            }
                        }

                        if (nameMatcher.find()) {
                            personMap.get(currentID).setName(nameMatcher.group());
                        }

                        if (jobMatcher.find()) {
                            personMap.get(currentID).setJobTitle(jobMatcher.group());
                        }

                        if (dobMatcher.find()) {
                            personMap.get(currentID).setDOB(dobMatcher.group());
                        }

                        if (appearanceMatcher.find()) {
                            personMap.get(currentID).setAppearance(appearanceMatcher.group());
                        }

                        if (mobileMatcher.find()) {
                            personMap.get(currentID).setPhoneNumber(mobileMatcher.group());
                        }
                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        for (PersonBean person : personMap.values()) {
            personList.add(person);
        }

        return personList;
    }
}

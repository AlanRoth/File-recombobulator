/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.PersonBean;

/**
 *
 * @author asroth
 */
public class FileMaker {
    
    public void writeToFile(File file, String text){
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true), true)){           
            writer.println(text);
        } catch (IOException ex) {
            System.out.println("Couldn't write to file! Probably because there is no file to write to. Error: " + ex.getMessage());
        }    
    }    
    
    public void writeListToFile(File file, ArrayList<PersonBean> arrayList){
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (PersonBean person : arrayList) {
                writer.println(person.toString());
            }
        } catch (IOException ex) {
            System.out.println("Couldn't write to file! Probably because there is no file to write to. Error: " + ex.getMessage());
        }
    }
}

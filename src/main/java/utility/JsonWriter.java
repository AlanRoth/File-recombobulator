/*
 * Copyright Payara Services Ltd
 */
package utility;
import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  
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
public class JsonWriter {
    GsonBuilder builder;
    Gson gson;
    
    public JsonWriter(){
        builder = new GsonBuilder().setPrettyPrinting();
        gson = builder.create();
    }
    
    public void writeToJson(File file, String text){
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true), true)){           
            writer.write(gson.toJson(text));
        } catch (IOException ex) {
            System.out.println("Couldn't write to file! Probably because there is no file to write to. Error: " + ex.getMessage());
        }   
    }
    
    public void writeListToJson(File file, ArrayList<PersonBean> arrayList){       
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.write(gson.toJson(arrayList));
        } catch (IOException ex) {
            System.out.println("Couldn't write to file! Probably because there is no file to write to. Error: " + ex.getMessage());
        }
    }    
}

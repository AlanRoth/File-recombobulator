/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author asroth
 */
public class FileManager {
    private String filePath1 = "../Resources/file1";
    private String filePath2 = "../Resources/file2";
    private String filePath3 = "../Resources/file3";
    private ArrayList<String> filePathBuffer = new ArrayList<String>();
    private ArrayList<File> fileBuffer = new ArrayList<File>();
    
    public FileManager(){
        filePathBuffer.add(filePath1);
        filePathBuffer.add(filePath2);
        filePathBuffer.add(filePath3);
        
        addFiles();
    }         
    
    public FileManager(String filePath1){
        this.filePath1 = filePath1;
    }
    
    public FileManager(String filePath1, String filePath2){
        this.filePath1 = filePath1;
        this.filePath2 = filePath2;
    }
    
    public FileManager(String filePath1, String filePath2, String filePath3){    
        this.filePath1 = filePath1;
        this.filePath2 = filePath2;
        this.filePath3 = filePath3;
    }  
    
    public FileManager(String...filePath){
        filePathBuffer = new ArrayList<>();
        fileBuffer = new ArrayList<>();
        
        for(String path : filePath){           
            if(path != null || !(path.trim().isEmpty())){
                filePathBuffer.add(path);
            }        
        }  
        
        addFiles();
    }   
    
    private void addFiles(){
        for(String path : filePathBuffer){
            File file = new File(path);
            if(file.exists()){
                fileBuffer.add(file);
            }else{
                System.out.println("Couldn't find file at: " + path);
            }
        }
    }
    
    public int getFileNumber(){
        return fileBuffer.size();
    }
    
    public ArrayList<File> getFileBuffer(){
        return fileBuffer;
    }  
}

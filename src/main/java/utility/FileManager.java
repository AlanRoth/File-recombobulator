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
    private ArrayList<File> fileBuffer;
    
    public FileManager(){
        
    }
    
    public FileManager(String filePath){
        this.filePath1 = filePath;
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
        for(String path : filePath){
            
            File newFile = new File(path);
            
            if(newFile.exists()){
                fileBuffer.add(newFile);
            }
            
        }
        
    }
    
}

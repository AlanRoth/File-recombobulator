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
    //3 default file paths
    private final String filePath1 = "/home/asroth/Documents/resource/file1";
    private final String filePath2 = "/home/asroth/Documents/resource/file2";
    private final String filePath3 = "/home/asroth/Documents/resource/file3";
    private final String outputPath = "/home/asroth/Documents/resource/output";
    //Counter to make sure the first 3 files added overwrite the default file paths.
    private int pathCounter;
    private ArrayList<String> filePathBuffer = new ArrayList<String>();
    private ArrayList<File> fileBuffer = new ArrayList<File>();
    
    private FileWriter filewriter;
    private FileParser fileparser;
    
    public FileManager(){
        filePathBuffer.add(filePath1);
        filePathBuffer.add(filePath2);
        filePathBuffer.add(filePath3);
        
        pathCounter = 0;
        
        filewriter = new FileWriter();
        fileparser = new FileParser();
    }         
    
    public void addPath(String path){
        switch (pathCounter) {
            case 0:
                filePathBuffer.set(0, path);
                break;
            case 1:
                filePathBuffer.set(1, path);
                break;
            case 2:
                filePathBuffer.set(2, path);
                break;
            default:
                filePathBuffer.add(path);
                break;
        }
        pathCounter++;
    }
    
    public void addFiles(){
        for(String path : filePathBuffer){
            File file = new File(path);
            if(file.exists()){
                fileBuffer.add(file);
            }else{
                System.out.println("Couldn't find file at: " + path + " \nSo it was ignored");
            }
        }
    }   
    
    public void addDefaultPaths(){
        filePathBuffer.add(filePath1);
        filePathBuffer.add(filePath2);
        filePathBuffer.add(filePath3);
    }   
    
    public void recombobulateFiles(String outputPath){
        for(File file : fileBuffer){
            fileparser.getPersonListFromFile(file, outputPath);
        }   
    }
    
    public void recombobulateFiles(){
        recombobulateFiles(outputPath);
    }
    
    public void clearPaths(){
        filePathBuffer.clear();
    }
    
    public ArrayList<String> getFilePathBuffer(){
        return filePathBuffer;
    }
    
    public ArrayList<File> getFileBuffer(){
        return fileBuffer;
    }  
}

/*
 * Copyright Payara Services Ltd
 */
package utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import model.PersonBean;

/**
 *
 * @author asroth
 */
public class FileManager {  
    private final String outputPath;
    private final String filePath1;
    private final String filePath2;
    private final String filePath3;
    //Counter to make sure the first 3 files added overwrite the default file paths.
    private int pathCounter;
    private final ArrayList<String> filePathQueue = new ArrayList<String>();
    private final ArrayList<File> fileQueue = new ArrayList<File>();
    
    private final FileMaker fileWriter;
    private final FileParser fileParser;
    
    public FileManager(String outputPath, String filePath1, String filePath2, String filePath3){
        this.outputPath = outputPath;
        this.filePath1 = filePath1;
        this.filePath2 = filePath2;
        this.filePath3 = filePath3;
        addDefaultPaths();
        
        pathCounter = 0;
        
        fileWriter = new FileMaker();
        fileParser = new FileParser();
    }         
    
    public void addPath(String path){
        switch (pathCounter) {
            case 0:
                filePathQueue.set(0, path);
                break;
            case 1:
                filePathQueue.set(1, path);
                break;
            case 2:
                filePathQueue.set(2, path);
                break;
            default:
                filePathQueue.add(path);
                break;
        }
        pathCounter++;
    }
    
    public void addFiles(){
        for(String path : filePathQueue){
            File file = new File(path);
            if(file.exists()){
                fileQueue.add(file);
            }else{
                System.out.println("Couldn't find file at: " + path + " \nSo it was ignored");
            }
        }
    }   
    
    public void addDefaultPaths(){
        filePathQueue.add(filePath1);
        filePathQueue.add(filePath2);
        filePathQueue.add(filePath3);
    }   
    
    public void recombobulateFiles(String path){
        addFiles();
        ArrayList<PersonBean> personList= fileParser.getPersonListFromFiles(fileQueue);
        File outputFile;

        if(path == null || path.trim().isEmpty()){
            outputFile = new File(outputPath);
        }else{
            outputFile = new File(path);
        }              

        try {
            if(outputFile.exists()){
                outputFile.delete();
            }           
            outputFile.createNewFile();     
        } catch (IOException ex) {
            System.out.println("Couldn't recombobulate files: " + outputFile.getPath() + " Error: " + ex.getMessage());
        }
        
        for(int i = 0; i < personList.size(); i++){
            fileWriter.writeToFile(outputFile, personList.get(i).toString());
        }
    } 

    public void recombobulateFiles(){
        recombobulateFiles(outputPath);
    }
    
    public void clearPaths(){
        filePathQueue.clear();
    }
    
    public String getOutputPath(){
        return outputPath;
    }
    
    public ArrayList<String> getFilePathQueue(){
        return filePathQueue;
    }
    
    public ArrayList<File> getFileQueue(){
        return fileQueue;
    }   
}

/*
 * Copyright Payara Services Ltd
 */
package org.alan.roth.filemanipulator;

import java.util.Scanner;
import utility.FileManager;

/**
 *
 * @author asroth
 */
public class UserIO {  
    private Scanner reader;
    
    public static void main(String[] args) {
        FileManager fm = new FileManager();
        System.out.println(fm.getFileNumber());
    }
    
    public void selectionScreen(){
        
    }
    
}

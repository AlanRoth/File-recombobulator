/*
 * Copyright Payara Services Ltd
 */
package org.alan.roth.filemanipulator;

/**
 *
 * @author asroth
 */
public class Launcher {
    public static UserIO userIO;
    
    public static void main(String[] args) {
        userIO = new UserIO();
        userIO.mainMenu();
    }
    
}

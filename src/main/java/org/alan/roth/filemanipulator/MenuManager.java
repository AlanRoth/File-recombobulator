/*
 * Copyright Payara Services Ltd
 */
package org.alan.roth.filemanipulator;

/**
 *
 * @author asroth
 */
public class MenuManager {
    
    public void printHelpMenu(){
        System.out.print("\nChoose what you would like to do: \n"
                         + "-add {file path} [Adds the file path for a file to a list]\n"
                         + "-recombobulate {leave empty for default} || {file path} [Combine all files in the list into one] \n"
                         + "-edit {leave empty for default} || {filepath} [Edit a recombobulated file at a file path]\n"
                         + "-clear [Clears added filepaths]\n"
                         + "-load [Loads default file paths back up]\n"
                         + "-verbose [Toggles verbose mode, will print edits to console]\n"
                         + "-quit [Quits the program]\n");
    }
    
}

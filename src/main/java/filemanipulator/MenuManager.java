/*
 * Copyright Payara Services Ltd
 */
package filemanipulator;

import utility.FileManager;
import utility.InputParser;

/**
 *
 * @author asroth
 */
public class MenuManager {
    UserIO userIO;
    
    public MenuManager(UserIO userIO){
        this.userIO = userIO;
    }
    
    public void printHelpMenu(){
        System.out.print("\nChoose what you would like to do: \n"
                         + "-add {file path} [Adds the file path for a file to the list]\n"
                         + "-recombobulate {leave empty for default file path} || {file path} [Combines all files in the list into one file] \n"
                         + "-edit {leave empty for default file path} || {filepath} [Edit a recombobulated file at a file path]\n"
                         + "-load [Adds default file paths to already added ones]\n"
                         + "-clear [Clears all added paths, including default]\n"
                         + "-verbose on: " + userIO.isVerbose() +" [Toggles verbose mode, will print edits to console]\n"
                         + "-quit [Quits the program]\n");
    }
    
    public void printEditMenu(){
        System.out.println("\nThis editor allows you to change fields in files\n"
                         + "-print [Prints all the contents of the currently selected file]"
                         + "-append {ID} {data} [Adds a line to the end of a entry]"
                         + "-update {ID} {field} {data} [Update field under a specified ID with the provided data]"
                         + "-updateall {ID...} [Provide comma seperated ID's to run updates on them in series]"
                         + "-delete {ID} [Removes the entry that has the provided ID]");
    }                       
}

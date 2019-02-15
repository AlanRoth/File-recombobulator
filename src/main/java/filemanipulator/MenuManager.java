/*
 * Copyright Payara Services Ltd
 */
package filemanipulator;

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
                         + "-add {file path} [Adds the file path for a file to a list]\n"
                         + "-recombobulate {leave empty for default} || {file path} [Combines all files in the list into one] \n"
                         + "-edit {leave empty for default} || {filepath} [Edit a recombobulated file at a file path]\n"
                         + "-load [Adds default file paths to already added ones]\n"
                         + "-clear [Clears all added paths, including default]\n"
                         + "-verbose on: " + userIO.isVerbose() +" [Toggles verbose mode, will print edits to console]\n"
                         + "-quit [Quits the program]\n");
    }
    
}

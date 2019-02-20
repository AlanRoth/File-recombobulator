/*
 * Copyright Payara Services Ltd
 */
package filemanipulator;

/**
 *
 * @author asroth
 */
public class MenuManager {

    public void printHelpMenu(boolean isVerbose){
        System.out.print("\nChoose what you would like to do: \n"
                         + "-add {file path} [Adds the file path for a file to the list]\n"
                         + "-recombobulate {leave empty for default file path} || {file path} [Combines all files in the list into one file] \n"
                         + "-edit {leave empty for default file path} || {filepath} [Edit a recombobulated file at a file path]\n"
                         + "-load [Adds default file paths to already added ones]\n"
                         + "-clear [Clears all added paths, including default]\n"
                         + "-verbose isOn: " + isVerbose +" [Toggles verbose mode, will print edits to console]\n"
                         + "-quit [Quits the program]\n");
    }
    
    public void printEditMenu(String filepath){
        System.out.println("\nEdit mode\n"
                         + "Currently selected file path: " + filepath + "\n"
                         + "-select {filepath} [Selects a file to edit at provided filepath]\n"
                         + "-print [Prints all the contents of the currently selected file]\n"
                         + "-new [Makes a new entry]"
                         + "-update {ID} {field} {data} [Overwrites the provided field with the provided data]\n"
                         + "-updateall {ID...} {field} {data} [Provide comma seperated ID's to update the fields with provided data in one action]\n"
                         + "-delete {ID} [Removes the entry that has the provided ID]\n"
                         + "-back [Return to the main menu]\n");
    }                       
}

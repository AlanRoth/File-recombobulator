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
                         + "-verbose on: " + isVerbose +" [Toggles verbose mode, will print edits to console]\n"
                         + "-quit [Quits the program]\n");
    }
    
    public void printEditMenu(){
        System.out.println("\nEdit mode\n"
                         + "-select {filepath} [Selects a file to edit at provided filepath]"
                         + "-print [Prints all the contents of the currently selected file]\n"
                         + "-new [Makes a new entry]"
                         + "-append {ID} {data} [Adds a line to the end of a entry]\n"
                         + "-update {ID} {field} {data} [Update field under a specified ID with the provided data]\n"
                         + "-updateall {ID...} {field} {data} [Provide comma seperated ID's to update all their fields]\n"
                         + "-delete {ID} [Removes the entry that has the provided ID]\n"
                         + "-change {filepath} [Change the file you are editing]\n"
                         + "-menu [Return to the main menu]\n");
    }                       
}
